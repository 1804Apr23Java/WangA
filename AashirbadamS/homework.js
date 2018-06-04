//TODO: Javascript homework
/*1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/
function getUSA() {
    const listItems1 = document.querySelector('h1').firstElementChild;
    const listItems1content = document.querySelector('h1').firstElementChild.textContent;
    console.log(listItems1 + ":" + listItems1content);
    const listItems2 = document.querySelector('h1').lastElementChild;
    const listItems2content = document.querySelector('h1').lastElementChild.textContent;
    console.log(listItems2 + ":" + listItems2content);
}
/*
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
function getPeopleInSales() {
    var employeeNames = document.getElementsByClassName("empName");
    for (var i = 0; i < employeeNames.length; i++) {
        var dept = employeeNames[i].nextElementSibling.textContent;
        if (dept == "Sales") {
            console.log(employeeNames[i].textContent);
        }
    }
}
/*
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/

function getAnchorChildren() {
    var anchorItems = document.querySelectorAll("a > span");
    for (var i = 0; i < anchorItems.length; i++) {
        console.log(anchorItems[i].textContent);
    }
}

/*
Define function getHobbies()	
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/

function getHobbies() {
    var hobbies = document.querySelectorAll("select[name='skills'] > option");
    hobbies.forEach(function (hobbies) {
        if (hobbies.getAttribute('selected')) {
            console.log("Checked content: " + hobbies.innerHTML + ":" + "value:" + hobbies.getAttribute('value'));
        }
    })
}

/*
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/

function getCustomAttribute() {
    var customer = document.querySelectorAll('[data-customAttr]');
    customer.forEach(function(customer){   
        console.log(customer.getAttribute('data-customAttr') + " :" + customer.tagName);
    })
}

/*
<input id="num1" class="nums" type="text"/>	
<input id="num2" class="nums" type="text"/>	
<h3>Sum: span id="sum"></span></h3>
*/
function sumEvent() {
    var num1 = parseInt(document.getElementById("num1").value);
    var num2 = parseInt(document.getElementById("num2").value);
    var result = num1 + num2;
    var sum = document.getElementById("sum").innerHTML = result;
    addEventListener('change', sumEvent);

}

/*


/*
When user selects a skill, create an alert with a message similar to:	
"Are you sure CSS is one of your skills?"
*/



function skillevent2() {
    var selectedHobbies = document.querySelectorAll("select[name='skills']");
    selectedHobbies.forEach(function (selectedHobbies) {
        selectedHobbies.addEventListener("change", function () {
            alert("Are you sure " + selectedHobbies.options[selectedHobbies.selectedIndex].innerHTML + " is one of your skills?");
        });
    })
}


function skillevent() {
    var selectedHobbies = document.querySelector("select[name='skills']");
    selectedHobbies.addEventListener("change", function () {
        alert(selectedHobbies.options[selectedHobbies.selectedIndex].text)
    });


}

/*
When a user selects a color, create an alert with a message similar to:	
"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor
*/

function selectColor() {  
    //need to be careful, there should be no space between input name.
    var element = document.querySelectorAll('input[name ="favoriteColor"]');
    element.forEach(function (element) {
        element.addEventListener("click", function (event) {
            var x = event.target.tagName;           
                var current=this.getAttribute("value");
                  alert("you like " + current + " " + previous);
                             
            
        })
        console.log(element);
    })

  }
/*
Write unobtrusive Javascript
When user hovers over an employees name:	
Hide the name if shown.
Show the name if hidden
*/
window.onload =emphidden;
function emphidden() {

    empnames = document.querySelectorAll(".empName");
    empnames.forEach(function (empnames) {
        console.log(empnames);
        empnames.addEventListener('mouseover', function () {
            //hiding the element 
            if (empnames.style.opacity == "0") {
                empnames.style.opacity = "1";
            } else {
                empnames.style.opacity = "0";
            }
        });
    })
}

/*
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/
window.onload = currentTime;
function currentTime() {
    var d = new Date();
    var t = d.toLocaleTimeString();
    var time = document.getElementById("currentTime").innerHTML = t;
}

/*
Regarding this element:	s
<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/
function delay() {
    var test = document.getElementById("helloWorld");
    test.addEventListener("click", function () {
        setInterval(function () {
            test.style.color = randomColors();
        }, 3000);
    });}

window.onload = randomColors;
function randomColors() {
    return '#' + Math.floor(Math.random() * 16777215).toString(16);

}

/*12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. 
Use recursion.
On each node, call func(node).
*/
function walkTheDOM(node, func) {
    var children = node.childNodes;
    for (var i = 0; i < children.length; i++) {
        walkTheDOM(children[i], func);
    }
    func(node);
}



