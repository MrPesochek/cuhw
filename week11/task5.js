const originalList = document.getElementById('book-list');
const secondList = document.createElement('div');
secondList.id = 'booklist2';
originalList.parentElement.appendChild(secondList);

originalList.addEventListener('click', event => {
  const card = event.target.closest('.book');
  if (!card) return;
  setTimeout(() => {
    secondList.appendChild(card);
  }, 10);
});

secondList.addEventListener('click', event => {
  const card = event.target.closest('.book');
  if (!card) return;
  setTimeout(() => {
    originalList.appendChild(card);
  }, 10);
});
