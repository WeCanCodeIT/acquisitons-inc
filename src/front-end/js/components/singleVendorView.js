import {
    clearElementChildren
} from "../domHelper.js"
import {
    renderAllVendors
} from "./allVendorsView.js"
import {
    fetchVendors
} from "../apiHelper.js"

const renderVendor = (element, vendor) => {
    clearElementChildren(element);
    element.innerHTML = `
        <article class="vendor">
          <h2 class="vendor__title">${vendor.name}</h2>
          <h4 class="vendor__tagline">${vendor.phoneNumber}</h4>            
        </article>
    `
    const products = document.createElement('ul');

    vendor.products.forEach((product) => {
        const li = document.createElement('li');
        li.innerHTML = `<a class = "product__name">${product.name}</a>`
        li.addEventListener('click', () => {
            // rendorProduct(product)

            alert(`You clicked on ${product.name}!`)
        })
        products.append(li);
    })
    const backHomeLink = document.createElement('a');
    backHomeLink.innerText = "Go Back to All Vendors"
    backHomeLink.addEventListener('click', () => {
        fetchVendors()
            .then(vendors => {
                renderAllVendors(element, vendors)
            });
    });
    element.append(products);
    element.append(backHomeLink);
}

export {
    renderVendor
}