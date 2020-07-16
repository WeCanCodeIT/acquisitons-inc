import {
    clearElementChildren
} from "../domHelper.js"
import {
    renderVendor
} from "./singleVendorView.js"
import {
    postNewVendor,
    fetchVendors
} from "../apiHelper.js"

const renderAllVendors = (element, vendors) => {
    clearElementChildren(element);

    for (let i = 0; i < vendors.length; i++) {
        const article = document.createElement('article');
        article.classList.add('vendor');
        article.innerHTML = `
              <h2 class="vendor__title">${vendors[i].name}</h2>
              <h4 class="vendor__phone-number">${vendors[i].phoneNumber}</h4>            
          `;

        article.addEventListener('click', () => {
            renderVendor(element, vendors[i]);
        });
        element.append(article);
    };

    drawForm(element);


}

export {
    renderAllVendors
}

function drawForm(element) {
    const nameInput = document.createElement('input');
    nameInput.type = 'text';
    nameInput.placeholder = 'Enter new vendor name';
    nameInput.classList.add('vendor__form-name');
    element.append(nameInput);
    const phoneInput = document.createElement('input');
    phoneInput.type = 'text';
    phoneInput.placeholder = 'Enter new vendor phone number.';
    phoneInput.classList.add('vendor__form-phone');
    element.append(phoneInput);
    const submitButton = document.createElement('button');
    submitButton.innerText = "Submit New Vendor";
    submitButton.classList.add('vendor__form-submit');
    element.append(submitButton);

    submitButton.addEventListener('click', () => {
        const vendor = {
            "name": nameInput.value,
            "phoneNumber": phoneInput.value
        }
        postNewVendor(vendor)
            .then(vendors => {
                renderAllVendors(element, vendors)
            })

    })
}