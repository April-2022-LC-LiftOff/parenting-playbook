function importantFields() {
//default ids
    const name = document.getElementById('name');
    const action = document.getElementById('action');
    const expectedResponse = document.getElementById('expectedResponse');
    const reference = document.getElementById('reference');
    const ifItFails = document.getElementById('ifItFails');
    //blank ids
    const nameBlank = document.getElementById('nameBlank');
    const actionBlank = document.getElementById('actionBlank');
    const expectedResponseBlank = document.getElementById('expectedResponseBlank');
    //length ids
    const nameLength = document.getElementById('nameLength');
    const actionLength = document.getElementById('actionLength');
    const expectedResponseLength = document.getElementById('expectedResponseLength');
    //counter ids
    const nameCounter = document.getElementById('nameCounter');
    const actionCounter = document.getElementById('actionCounter');
    const expectedResponseCounter = document.getElementById('expectedResponseCounter');
    const referenceCounter = document.getElementById('referenceCounter');
    const ifItFailsCounter = document.getElementById('ifItFailsCounter');
//    let ImpulseControl = document.getElementById('Impulse Control');
//    let EmotionalControl = document.getElementById('Emotional Control');
//    let FlexibleThinking = document.getElementById('Flexible Thinking');
//    let WorkingMemory = document.getElementById('Working Memory');
//    let SelfMonitoring = document.getElementById('Self-Monitoring');
//    let PlanningAndPrioritizing = document.getElementById('Planning and Prioritizing');
//    let TaskInitiation = document.getElementById('Task Initiation');
//    let Organization = document.getElementById('Organization');
//    let checkBoxLabel = document.getElementById('checkBoxLabel');
//    let domainSelect = document.getElementById('domainSelect');
//    let tagCheckBox = document.getElementById('tagCheckBox');
//    let tagSelect = document.getElementById('tagSelect');

//    if (!tagCheckBox.checked) {
//        tagSelect.textContent = "Please select a Tag.";
//    }
//
//    if (!ImpulseControl.checked && !EmotionalControl.checked && !FlexibleThinking.checked && !WorkingMemory.checked && !SelfMonitoring.checked && !PlanningAndPrioritizing.checked && !TaskInitiation.checked && !Organization.checked) {
//        domainSelect.textContent = "Please select a Domain.";
//    }

    if (name.value == "") {
        name.style.backgroundColor = "yellow";
        nameBlank.textContent = "Name cannot be blank.";
        nameLength.textContent = "Name must be between 5 and 255 characters long.";
    }
    if (action.value == "") {
        action.style.backgroundColor = "yellow";
        actionBlank.textContent = "Action cannot be blank.";
        actionLength.textContent = "Action must be between 20 and 2000 characters long.";
    }
    if (expectedResponse.value == "") {
        expectedResponse.style.backgroundColor = "yellow";
        expectedResponseBlank.textContent = "Expected Response cannot be blank.";
        expectedResponseLength.textContent = "Expected Response must be between 20 and 2000 characters long.";
    }

//    tagCheckBox.addEventListener('change', function(event) {
//        if (tagCheckBox.checked) {
//            domainSelect.textContent = "";
//        }
//
//        if (!tagCheckBox.checked) {
//            tagSelect.textContent = "Please select a Tag.";
//        }
//    })

//    ImpulseControl.addEventListener('change', function(event) {
//        if (ImpulseControl.checked) {
//            domainSelect.textContent = "";
//        }
//
//        if (!ImpulseControl.checked && !EmotionalControl.checked && !FlexibleThinking.checked && !WorkingMemory.checked && !SelfMonitoring.checked && !PlanningAndPrioritizing.checked && !TaskInitiation.checked && !Organization.checked) {
//            domainSelect.textContent = "Please select a Domain.";
//        }
//    })
//
//    EmotionalControl.addEventListener('change', function(event) {
//        if (EmotionalControl.checked) {
//            domainSelect.textContent = "";
//        }
//
//        if (!ImpulseControl.checked && !EmotionalControl.checked && !FlexibleThinking.checked && !WorkingMemory.checked && !SelfMonitoring.checked && !PlanningAndPrioritizing.checked && !TaskInitiation.checked && !Organization.checked) {
//            domainSelect.textContent = "Please select a Domain.";
//        }
//    })
//
//    FlexibleThinking.addEventListener('change', function(event) {
//        if (FlexibleThinking.checked) {
//            domainSelect.textContent = "";
//        }
//
//        if (!ImpulseControl.checked && !EmotionalControl.checked && !FlexibleThinking.checked && !WorkingMemory.checked && !SelfMonitoring.checked && !PlanningAndPrioritizing.checked && !TaskInitiation.checked && !Organization.checked) {
//            domainSelect.textContent = "Please select a Domain.";
//        }
//    })
//
//    WorkingMemory.addEventListener('change', function(event) {
//        if (WorkingMemory.checked) {
//            domainSelect.textContent = "";
//        }
//
//        if (!ImpulseControl.checked && !EmotionalControl.checked && !FlexibleThinking.checked && !WorkingMemory.checked && !SelfMonitoring.checked && !PlanningAndPrioritizing.checked && !TaskInitiation.checked && !Organization.checked) {
//            domainSelect.textContent = "Please select a Domain.";
//        }
//    })
//
//    SelfMonitoring.addEventListener('change', function(event) {
//        if (SelfMonitoring.checked) {
//            domainSelect.textContent = "";
//        }
//
//        if (!ImpulseControl.checked && !EmotionalControl.checked && !FlexibleThinking.checked && !WorkingMemory.checked && !SelfMonitoring.checked && !PlanningAndPrioritizing.checked && !TaskInitiation.checked && !Organization.checked) {
//            domainSelect.textContent = "Please select a Domain.";
//        }
//    })
//
//    PlanningAndPrioritizing.addEventListener('change', function(event) {
//        if (PlanningAndPrioritizing.checked) {
//            domainSelect.textContent = "";
//        }
//
//        if (!ImpulseControl.checked && !EmotionalControl.checked && !FlexibleThinking.checked && !WorkingMemory.checked && !SelfMonitoring.checked && !PlanningAndPrioritizing.checked && !TaskInitiation.checked && !Organization.checked) {
//            domainSelect.textContent = "Please select a Domain.";
//        }
//    })
//
//    TaskInitiation.addEventListener('change', function(event) {
//        if (TaskInitiation.checked) {
//            domainSelect.textContent = "";
//        }
//
//        if (!ImpulseControl.checked && !EmotionalControl.checked && !FlexibleThinking.checked && !WorkingMemory.checked && !SelfMonitoring.checked && !PlanningAndPrioritizing.checked && !TaskInitiation.checked && !Organization.checked) {
//            domainSelect.textContent = "Please select a Domain.";
//        }
//    })
//
//    Organization.addEventListener('change', function(event) {
//        if (Organization.checked) {
//            domainSelect.textContent = "";
//        }
//
//        if (!ImpulseControl.checked && !EmotionalControl.checked && !FlexibleThinking.checked && !WorkingMemory.checked && !SelfMonitoring.checked && !PlanningAndPrioritizing.checked && !TaskInitiation.checked && !Organization.checked) {
//            domainSelect.textContent = "Please select a Domain.";
//        }
//    })

    name.addEventListener('input', function(event) {
        const target = event.target;
        const maxLength = target.getAttribute("maxlength");
        const currentLength = target.value.length;
        if (name.value != "") {
            nameBlank.textContent = "";
            nameCounter.textContent = currentLength + "/" + maxLength;
        }

        if (name.value != "" && name.value.length > 5) {
            name.style.backgroundColor = "";
            nameLength.textContent = "";
        }

        if (name.value != "" && name.value.length < 5) {
            name.style.backgroundColor = "yellow";
            nameLength.textContent = "Name must be between 5 and 255 characters long.";
        }

        if (name.value == "") {
            nameBlank.textContent = "Name cannot be blank.";
            name.style.backgroundColor = "yellow";
            nameLength.textContent = "Name must be between 5 and 255 characters long.";
            nameCounter.textContent = "0";
        }
    })

    action.addEventListener('input', function(event) {
        const target = event.target;
        const maxLength = target.getAttribute("maxlength");
        const currentLength = target.value.length;
        if (action.value != "") {
            actionBlank.textContent = "";
            actionCounter.textContent = currentLength + "/" + maxLength;
        }

        if (action.value != "" && action.value.length > 20) {
            action.style.backgroundColor = "";
            actionLength.textContent = "";
        }

        if (action.value != "" && action.value.length < 20) {
            action.style.backgroundColor = "yellow";
            actionLength.textContent = "Action must be between 20 and 2000 characters long.";
        }

        if (action.value == "") {
            actionBlank.textContent = "Action cannot be blank.";
            action.style.backgroundColor = "yellow";
            actionLength.textContent = "Action must be between 20 and 2000 characters long.";
            actionCounter.textContent = "0";
        }
    })

    expectedResponse.addEventListener('input', function(event) {
        const target = event.target;
        const maxLength = target.getAttribute("maxlength");
        const currentLength = target.value.length;
        if (expectedResponse.value != "") {
            expectedResponseBlank.textContent = "";
            expectedResponseCounter.textContent = currentLength + "/" + maxLength;
        }

        if (expectedResponse.value != "" && expectedResponse.value.length > 20) {
            expectedResponse.style.backgroundColor = "";
            expectedResponseLength.textContent = "";
        }

        if (expectedResponse.value != "" && expectedResponse.value.length < 20) {
            expectedResponse.style.backgroundColor = "yellow";
            expectedResponseLength.textContent = "Expected Response must be between 20 and 2000 characters long.";
        }

        if (expectedResponse.value == "") {
            expectedResponseBlank.textContent = "Expected Response cannot be blank.";
            expectedResponse.style.backgroundColor = "yellow";
            expectedResponseLength.textContent = "Expected Response must be between 20 and 2000 characters long.";
            expectedResponseCounter.textContent = "0";
        }
    })

    reference.addEventListener('input', function(event) {
        const target = event.target;
        const maxLength = target.getAttribute("maxlength");
        const currentLength = target.value.length;
        if (reference.value != "") {
            referenceCounter.textContent = currentLength + "/" + maxLength;
        }

        if (reference.value == "") {
            referenceCounter.textContent = "0";
        }
    })

    ifItFails.addEventListener('input', function(event) {
        const target = event.target;
        const maxLength = target.getAttribute("maxlength");
        const currentLength = target.value.length;
        if (ifItFails.value != "") {
            ifItFailsCounter.textContent = currentLength + "/" + maxLength;
        }

        if (ifItFails.value == "") {
            ifItFailsCounter.textContent = "0";
        }
    })
}

function init() {
    importantFields();
}

window.addEventListener("load", init);