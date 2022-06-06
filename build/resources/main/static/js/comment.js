function userInputCounter() {
//default id
    const userInput = document.getElementById('userInput');
    const editComment = document.getElementById('editComment');
    //length id
    const userInputLength = document.getElementById('userInputLength');
    const editCommentLength = document.getElementById('editCommentLength');
    //counter ids
    const userInputCounter = document.getElementById('userInputCounter');
    const editCommentCounter = document.getElementById('editCommentCounter');



        userInput.addEventListener('input', function(event) {
            const target = event.target;
            const maxLength = target.getAttribute("maxlength");
            const currentLength = target.value.length;
            if (userInput.value != "") {
                userInputCounter.textContent = currentLength + "/" + maxLength;
            }

            if (userInput.value == "") {
                userInputCounter.textContent = "0";
            }
        })

        editComment.addEventListener('input', function(event) {
                    const target = event.target;
                    const maxLength = target.getAttribute("maxlength");
                    const currentLength = target.value.length;
                    if (editComment.value != "") {
                        editCommentCounter.textContent = currentLength + "/" + maxLength;
                    }

                    if (editComment.value == "") {
                        editCommentCounter.textContent = "0";
                    }
                })

    }


    function init() {
        userInputCounter();
    }

    window.addEventListener("load", init);
