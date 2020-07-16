const fetchVendors = async () => {
    return fetch('http://localhost:8080/api/vendors/')
        .then(response => response.json())
}

const postNewVendor = async (vendor) => {
    console.log(vendor);
    return fetch('http://localhost:8080/api/vendors/add/', {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(vendor)
    }).then(response => response.json())
}

export {
    fetchVendors,
    postNewVendor
}