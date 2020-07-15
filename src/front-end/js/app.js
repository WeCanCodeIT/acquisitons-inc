const renderAllVendors = (element, vendors) => {
  clearElementChildren(element);
  let vendorHtml = ''
  for (let i = 0; i < vendors.length; i++) {
    vendorHtml += `
        <article class="vendor">
            <h2 class="vendor__title">${vendors[i].name}</h2>
            <h4 class="vendor__tagline">${vendors[i].phoneNumber}</h4>            
        </article>
        `
    console.log(vendorHtml)
  };
  element.innerHTML = vendorHtml;
  element.querySelectorAll('.vendor').forEach(element => element.addEventListener('click', () => {
    alert("HI!")
  }))
}

const fetchVendors = async () => {
  return `
      [
        {
          "id": 1,
          "name": "ACME Inc",
          "products": [
            {
              "id": 4,
              "name": "Grand Piano",
              "price": 1000000.00
            }
          ],
          "phoneNumber": "419-950-4343"
        },
        {
          "id": 2,
          "name": "Jenni's Ice Cream",
          "products": [
            {
              "id": 3,
              "name": "Salted Carmel",
              "price": 13.45
            }
          ],
          "phoneNumber": "614-867-5309"
        }
      ]
    `
}

const clearElementChildren = element => {
  while (element.firstChild) {
    element.firstChild.remove();
  }
}


const catalog = document.querySelector(".catalog")
fetchVendors()
  .then(response => JSON.parse(response))
  .then(vendors => {
    console.log(vendors);
    renderAllVendors(catalog, vendors)
  })