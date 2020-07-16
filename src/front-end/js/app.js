import {
  fetchVendors
} from "./apiHelper.js"
import {
  renderAllVendors
} from "./components/allVendorsView.js"

const catalog = document.querySelector(".catalog")
fetchVendors()
  .then(vendors => {
    console.log(vendors);
    renderAllVendors(catalog, vendors)
  })