const toggleBtn = document.querySelector('.hamburger');
const menu = document.querySelector('.menu');

toggleBtn.addEventListener('click', () =>{
  menu.classList.toggle('active');
});