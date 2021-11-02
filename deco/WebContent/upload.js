const fileInput = document.querySelector('#file-upload');
const thumbnail = document.querySelector('#view-thumbnail');

const fileInput2 = document.querySelector('#file-upload2');
const thumbnail2 = document.querySelector('#view-thumbnail2');

function setImgThumnail(e) {
  const fileReader = new FileReader();

  fileReader.onload = function (e) {
    const img = document.createElement('img');
    img.setAttribute('src', e.target.result);
    img.setAttribute('display', 'inline-block');
    img.setAttribute('class', 'thubnail_img')
    thumbnail.appendChild(img);
  };
  fileReader.readAsDataURL(e.target.files[0]);
}

function setImgThumnail2(e) {
  const fileReader = new FileReader();

  fileReader.onload = function (e) {
    const img = document.createElement('img');
    img.setAttribute('src', e.target.result);
    img.setAttribute('display', 'inline-block');
    img.setAttribute('class', 'thubnail_img')
    thumbnail2.appendChild(img);
  };
  fileReader.readAsDataURL(e.target.files[0]);
}

fileInput.addEventListener('change', setImgThumnail);
fileInput2.addEventListener('change', setImgThumnail2);
