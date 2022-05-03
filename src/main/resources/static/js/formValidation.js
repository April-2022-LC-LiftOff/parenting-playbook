function init() {
    let checkBox = document.getElementById('checkBox');
    let name = document.getElementById('name');
    let action = document.getElementById('action');
    let expectedResponse = document.getElementById('expectedResponse');
    let submit = document.getElementById('button');

    let checked = false;
    let nameInput = false;
    let actionInput = false;
    let expectedResponseInput = false;

    checkBox.addEventListener('click', function(event) {
        if (checkBox.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                    submit.disabled = false;
                }
        }
    })

    name.addEventListener('keypress', function(event) {
        if (name.value != "") {
            nameInput = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                    submit.disabled = false;
                }
        }
    })

    action.addEventListener('keypress', function(event) {
        if (action.value != "") {
            actionInput = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                    submit.disabled = false;
                }
        }
    })

    expectedResponse.addEventListener('keypress', function(event) {
        if (expectedResponse.value != "") {
            expectedResponseInput = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                    submit.disabled = false;
                }
        }
    })
}

window.addEventListener("load", init);