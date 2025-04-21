const header = document.querySelector('h1');
header.textContent = 'Моя Собственная Библиотека';

const books = document.querySelectorAll('.book');
books.forEach(book => {
  book.style.backgroundColor = 'lightyellow';
  book.querySelector('.title').style.color = 'green';
});

const bookList = document.getElementById('book-list');
const newBook = document.createElement('div');
newBook.className = 'book';
newBook.innerHTML = '<div class="title">1984</div><div class="author">Джордж Оруэлл</div>';
bookList.appendChild(newBook);

document.querySelectorAll('.book').forEach(book => {
  if (book.querySelector('.title').textContent === 'Преступление и наказание') {
    book.parentElement.removeChild(book);
  }
});
