
var homework = {};
//fib number 
homework.fib = function (n) {
    var sum = 0;
    for (var i = 1; i <= n; i++) {
        sum = sum + i;
    }

    return sum;
}
//sorting number 
homework.arraysort = function (arr) {
    var temp;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] > arr[i + 1]) {
            temp = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = temp;


        }
        console.log(arr[i]);
    }
}

//finding the factorial 
homework.fac = function (n) {
    if (n < 0)
        return -1;
    else if (n == 0)
        return 1;
    else (n > 0)
    return (n * (fac(n - 1)));
}
//Using stack to solve the factorial 
homework.fact = function (n) {
    var s = new Stack();
    while (n > 1) {
        s.push(n--);
    }
    var product = 1;
    while (s.length() > 0) {
        product *= s.pop();
    }
    return product;
}

//Rotate left
/*
 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]
    homework.rotateLeft = function(array, n) {
*/

homework.rotateleft = function (arr, n) {
    var myArray = new myArray();
    for (var j = 0; j < n; j++) {
        //working for shifting one time on left
        for (var i = 1; i < arr.length; i++) {
            myArray[i - 1] = arr[i];
        }
        //last element which is the first element of the arr
        myArray(arr.length - 1) = arr[0];

    }
    console.log(myArray);
}
// balanced


homework.balanced = function (arr) {

    if (arr.length % 2 !== 0) {
        return false;
    }
    else {
        var s = [];
        for (var i = 0; i < arr.length; i++) {
            switch (arr.charAt(i)) {
                case "(":
                case "{":
                case "[":
                    s.push(arr.charAt(i));
                    break;
                case ")":
                    if (s.pop() !== "(")
                        return false;
                    else

                        break;

                case "}":
                    if (s.pop() !== "{")
                        return false;
                    else

                        break;

                case "]":
                    if (s.pop() !== "[")
                        return false;
                    else

                        break;


            }

        }
    }



}

