"use strict";

//Selectors
let resultsDiv = document.querySelector("#results-div");

let titleInput = document.querySelector("#titleInput");
let yearInput = document.querySelector("#yearInput");
let directorInput = document.querySelector("#directorInput");
let hiddenId = document.querySelector("#hidden-id");

let createBtn = document.querySelector("#createBtn");
let updateBtn = document.querySelector("#updateBtn");
let deleteBtn = document.querySelector("#deleteBtn");
let cancelBtn = document.querySelector("#cancelBtn");

//Functions 

let printResults = (result) => {
    let entryParent = document.createElement("div");
    entryParent.setAttribute("class", "entry-parent");

    let entryDiv = document.createElement("div");
    entryDiv.setAttribute("class", "entry-div");
    entryDiv.textContent = `${result.title} (${result.releaseYear}), dir: ${result.director}`;

    let entryBtn = document.createElement("button");
    entryBtn.setAttribute("class", "entry-btn");
    entryBtn.type = "button";
    entryBtn.id=`${result.id}`;
    entryBtn.setAttribute("onClick", "edit(this.id)");
    entryBtn.textContent = "Edit";

    entryParent.appendChild(entryDiv);
    entryParent.appendChild(entryBtn);
    resultsDiv.appendChild(entryParent);
}
let getAll = () => {
    axios.get("http://localhost:8080/movie/getAll")
    .then(res => {
        resultsDiv.innerHTML = "";

        let results = res.data;
        for (let result of results) {
            printResults(result);
        }

    })
    .catch(err => {console.log(err); });
}

let create = () => {

    let obj = {
        "title" : titleInput.value,
        "releaseYear" : yearInput.value,
        "director" : directorInput.value
    }
    axios.post("http://localhost:8080/movie/create", obj)
    .then(res => {
        getAll();
    }).catch(err => {console.log(err); });
}

let edit = (id) => {
    axios.get(`http://localhost:8080/movie/getById/${id}`)
    .then(res => {
        titleInput.value = res.data.title;
        yearInput.value = res.data.releaseYear;
        directorInput.value = res.data.director;
        hiddenId.value = res.data.id;
        createBtn.style.display = "none";
        updateBtn.style.display = "inline-block";
        deleteBtn.style.display = "inline-block";
        cancelBtn.style.display = "inline-block";
    })
    .catch(err => {console.log(err);});
}

let update = () => {
    
    let obj = {
        "title" : titleInput.value,
        "releaseYear" : yearInput.value,
        "director" : directorInput.value
    }

    axios.put(`http://localhost:8080/movie/update/${hiddenId.value}`, obj)
    .then(res => {
        getAll();
    }).catch(err => {console.log(err);})
}

let del = () => {
    axios.delete(`http://localhost:8080/movie/delete/${hiddenId.value}`)
    .then(res => {
        getAll();
    }).catch(err => {console.log(err);})
}

let cancel = () => {
    titleInput.value = "";
    yearInput.value = "";
    directorInput.value = "";
    createBtn.style.display = "inline-block";
    updateBtn.style.display = "none";
    deleteBtn.style.display = "none";
    cancelBtn.style.display = "none";
}


//Listeners
createBtn.addEventListener("click", create);
updateBtn.addEventListener("click", update);
deleteBtn.addEventListener("click", del);
cancelBtn.addEventListener("click", cancel);