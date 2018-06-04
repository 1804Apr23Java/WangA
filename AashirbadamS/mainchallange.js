let b = document.getElementById("button");
let p = document.createElement("p");
b.addEventListener("click", function () {
    p.innerHTML = "Title:" + document.getElementById("title").value + " Author:" + document.getElementById("author").value + " Genra:"
        + document.getElementById("genra").value + " Link:"+ document.getElementById("link").value;
         new Array (document.body.appendChild(p));
});

window.onload=addtitle;
function addtitle() {

     var title = document.getElementById("title").value;
      var booktitle = document.getElementById("booktitle").innerHTML = title;

     var author = document.getElementById("author").value;
     var bookauthor = document.getElementById("bookauthor").innerHTML = author;

     var genra = document.getElementById("genra").value;
     var bookgenra = document.getElementById("bookgenra").innerHTML = genra;

     var link = document.getElementById("link").value;
     var coverImage = document.getElementById("coverImage").innerHTML = link;
     var added = addEventListener('change', addtitle);

 }



