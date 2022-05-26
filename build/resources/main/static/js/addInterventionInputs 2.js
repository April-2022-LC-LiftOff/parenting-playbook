function importantFields() {
    let name = document.getElementById('name');
    let action = document.getElementById('action');
    let expectedResponse = document.getElementById('expectedResponse');
    let nameBlank = document.getElementById('nameBlank');
    let actionBlank = document.getElementById('actionBlank');
    let expectedResponseBlank = document.getElementById('expectedResponseBlank');
    let nameLength = document.getElementById('nameLength');
    let actionLength = document.getElementById('actionLength');
    let expectedResponseLength = document.getElementById('expectedResponseLength');
    let ImpulseControl = document.getElementById('Impulse Control');
    let EmotionalControl = document.getElementById('Emotional Control');
    let FlexibleThinking = document.getElementById('Flexible Thinking');
    let WorkingMemory = document.getElementById('Working Memory');
    let SelfMonitoring = document.getElementById('Self-Monitoring');
    let PlanningAndPrioritizing = document.getElementById('Planning and Prioritizing');
    let TaskInitiation = document.getElementById('Task Initiation');
    let Organization = document.getElementById('Organization');
    let checkBoxLabel = document.getElementById('checkBoxLabel');
    let domainSelect = document.getElementById('domainSelect');
    let tagCheckBox = document.getElementById('tagCheckBox');
    let tagSelect = document.getElementById('tagSelect');

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

    name.addEventListener('keyup', function(event) {
        if (name.value != "") {
            nameBlank.textContent = "";
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
        }
    })

    action.addEventListener('keyup', function(event) {
        if (action.value != "") {
            actionBlank.textContent = "";
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
        }
    })

    expectedResponse.addEventListener('keyup', function(event) {
        if (expectedResponse.value != "") {
            expectedResponseBlank.textContent = "";
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
        }
    })
}

function init() {
    importantFields();
}

window.addEventListener("load", init);