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
}

const renderVendor = (element, vendor) => {
  clearElementChildren(element);
  element.innerHTML = `
      <article class="vendor">
        <h2 class="vendor__title">${vendor.name}</h2>
        <h4 class="vendor__tagline">${vendor.phoneNumber}</h4>            
      </article>
  `
  const products = document.createElement('ul');

  //for(product of vendor.products){...}
  vendor.products.forEach((product) => {
    const li = document.createElement('li');
    li.innerHTML = `<a class = "product__name">${product.name}</a>`
    li.addEventListener('click', () => {
      alert(`You clicked on ${product.name}!`)
    })
    products.append(li);
  })
  const backHomeLink = document.createElement('a');
  backHomeLink.innerText = "Go Back to All Vendors"
  backHomeLink.addEventListener('click', () => {
    fetchVendors()
      .then(vendors => {
        renderAllVendors(catalog, vendors)
      });
  })
  element.append(products);
  element.append(backHomeLink);
}

const fetchVendors = async () => {
  return fetch('http://localhost:8080/api/vendors/')
    .then(response => response.json())
}

const clearElementChildren = element => {
  while (element.firstChild) {
    element.firstChild.remove();
  }
}


const catalog = document.querySelector(".catalog")
fetchVendors()
  .then(vendors => {
    console.log(vendors);
    renderAllVendors(catalog, vendors)
  })