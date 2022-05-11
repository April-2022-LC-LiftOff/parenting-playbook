const toggleBtn = document.querySelector('.myContributions', '.mySavedInterventions');
const divList = document.querySelector('.commentList', '.myInterventionList');

toggleBtn.addEventListener('click', () => {
if (divList.style.display === 'none') {
divList.style.display = 'block';
} else {
divList.style.display = 'none';
}

});
