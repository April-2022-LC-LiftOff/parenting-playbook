let contributions = document.getElementById("contributions");
let interventions = document.getElementById("interventions");

contributions.addEventListener("click", tabLink);
interventions.addEventListener("click", tabLink);

function tabLink() {
    let allTabs = document.querySelectorAll("div[data-src]");

    for (let i = 0; i < allTabs.length; i++) {
        allTabs[i].className = "hide";
    }

    let tabId = this.attributes["data-tab"].value;
    let tab = document.getElementById(tabId);
    if (tab.className === "hide") {
         tab.className = "";
     } else {
         tab.className = "hide";
     }
 };


