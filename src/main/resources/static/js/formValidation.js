function importantFields() {
    let name = document.getElementById('name');
    let action = document.getElementById('action');
    let expectedResponse = document.getElementById('expectedResponse');
    let ImpulseControl = document.getElementById('Impulse Control');
    let EmotionalControl = document.getElementById('Emotional Control');
    let FlexibleThinking = document.getElementById('Flexible Thinking');
    let WorkingMemory = document.getElementById('Working Memory');
    let SelfMonitoring = document.getElementById('Self-Monitoring');
    let PlanningAndPrioritizing = document.getElementById('Planning and Prioritizing');
    let TaskInitiation = document.getElementById('Task Initiation');
    let Organization = document.getElementById('Organization');
    let checkBoxLabel = document.getElementById('checkBoxLabel');

    if (!ImpulseControl.checked && !EmotionalControl.checked && !FlexibleThinking.checked && !WorkingMemory.checked && !SelfMonitoring.checked && !PlanningAndPrioritizing.checked && !TaskInitiation.checked && !Organization.checked) {
        checkBoxLabel.style.color = "yellow";
    }
    if (name.value == "") {
        name.style.backgroundColor = "yellow";
    }
    if (action.value == "") {
        action.style.backgroundColor = "yellow";
    }
    if (expectedResponse.value == "") {
        expectedResponse.style.backgroundColor = "yellow";
    }

    ImpulseControl.addEventListener('click', function(event) {
        if (ImpulseControl.checked) {
            checkBoxLabel.style.color = "";
        }
    })
    ImpulseControl.addEventListener('keypress', function(event) {
            if (ImpulseControl.checked) {
                checkBoxLabel.style.color = "";
            }
        })

    EmotionalControl.addEventListener('click', function(event) {
        if (EmotionalControl.checked) {
            checkBoxLabel.style.color = "";
        }
    })
    EmotionalControl.addEventListener('keypress', function(event) {
            if (EmotionalControl.checked) {
                checkBoxLabel.style.color = "";
            }
        })

    FlexibleThinking.addEventListener('click', function(event) {
        if (FlexibleThinking.checked) {
            checkBoxLabel.style.color = "";
        }
    })
    FlexibleThinking.addEventListener('keypress', function(event) {
            if (FlexibleThinking.checked) {
                checkBoxLabel.style.color = "";
            }
        })

    WorkingMemory.addEventListener('click', function(event) {
        if (WorkingMemory.checked) {
            checkBoxLabel.style.color = "";
        }
    })
    WorkingMemory.addEventListener('keypress', function(event) {
            if (WorkingMemory.checked) {
                checkBoxLabel.style.color = "";
            }
        })

    SelfMonitoring.addEventListener('click', function(event) {
        if (SelfMonitoring.checked) {
            checkBoxLabel.style.color = "";
        }
    })
    SelfMonitoring.addEventListener('keypress', function(event) {
            if (SelfMonitoring.checked) {
                checkBoxLabel.style.color = "";
            }
        })

    PlanningAndPrioritizing.addEventListener('click', function(event) {
        if (PlanningAndPrioritizing.checked) {
            checkBoxLabel.style.color = "";
        }
    })
    PlanningAndPrioritizing.addEventListener('keypress', function(event) {
            if (PlanningAndPrioritizing.checked) {
                checkBoxLabel.style.color = "";
            }
        })

    TaskInitiation.addEventListener('click', function(event) {
        if (TaskInitiation.checked) {
            checkBoxLabel.style.color = "";
        }
    })
    TaskInitiation.addEventListener('keypress', function(event) {
            if (TaskInitiation.checked) {
                checkBoxLabel.style.color = "";
            }
        })

    Organization.addEventListener('click', function(event) {
        if (Organization.checked) {
            checkBoxLabel.style.color = "";
        }
    })
    Organization.addEventListener('keypress', function(event) {
            if (Organization.checked) {
                checkBoxLabel.style.color = "";
            }
        })

    name.addEventListener('keypress', function(event) {
        if (name.value != "") {
            name.style.backgroundColor = "";
        }
    })

    action.addEventListener('keypress', function(event) {
        if (action.value != "") {
            action.style.backgroundColor = "";
        }
    })

    expectedResponse.addEventListener('keypress', function(event) {
        if (expectedResponse.value != "") {
            expectedResponse.style.backgroundColor = "";
        }
    })
}

function inputsArePresent() {
    let name = document.getElementById('name');
    let action = document.getElementById('action');
    let expectedResponse = document.getElementById('expectedResponse');
    let submit = document.getElementById('button');

    let ImpulseControl = document.getElementById('Impulse Control');
    let EmotionalControl = document.getElementById('Emotional Control');
    let FlexibleThinking = document.getElementById('Flexible Thinking');
    let WorkingMemory = document.getElementById('Working Memory');
    let SelfMonitoring = document.getElementById('Self-Monitoring');
    let PlanningAndPrioritizing = document.getElementById('Planning and Prioritizing');
    let TaskInitiation = document.getElementById('Task Initiation');
    let Organization = document.getElementById('Organization');

    let checked = false;
    let nameInput = false;
    let actionInput = false;
    let expectedResponseInput = false;



    ImpulseControl.addEventListener('click', function(event) {
        if (ImpulseControl.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })
    ImpulseControl.addEventListener('keypress', function(event) {
        if (ImpulseControl.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })

    EmotionalControl.addEventListener('click', function(event) {
        if (EmotionalControl.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })
    EmotionalControl.addEventListener('keypress', function(event) {
        if (EmotionalControl.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })

    FlexibleThinking.addEventListener('click', function(event) {
        if (FlexibleThinking.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })
    FlexibleThinking.addEventListener('keypress', function(event) {
        if (FlexibleThinking.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })

    WorkingMemory.addEventListener('click', function(event) {
        if (WorkingMemory.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })
    WorkingMemory.addEventListener('keypress', function(event) {
        if (WorkingMemory.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })

    SelfMonitoring.addEventListener('click', function(event) {
        if (SelfMonitoring.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })
    SelfMonitoring.addEventListener('keypress', function(event) {
        if (SelfMonitoring.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })

    PlanningAndPrioritizing.addEventListener('click', function(event) {
        if (PlanningAndPrioritizing.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })
    PlanningAndPrioritizing.addEventListener('keypress', function(event) {
        if (PlanningAndPrioritizing.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })

    TaskInitiation.addEventListener('click', function(event) {
        if (TaskInitiation.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })
    TaskInitiation.addEventListener('keypress', function(event) {
        if (TaskInitiation.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })

    Organization.addEventListener('click', function(event) {
        if (Organization.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
        }
    })
    Organization.addEventListener('keypress', function(event) {
        if (Organization.checked) {
            checked = true;
            if (checked == true && nameInput == true && actionInput == true && expectedResponseInput == true) {
                submit.disabled = false;
            }
        } else if (!ImpulseControl && !EmotionalControl && !FlexibleThinking && !WorkingMemory && !SelfMonitoring && !PlanningAndPrioritizing && !TaskInitiation && !Organization) {
            checked = false;
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

function init() {
    importantFields();
    inputsArePresent();
}

window.addEventListener("load", init);