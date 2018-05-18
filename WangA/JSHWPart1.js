/*Fill in the functions below and submit them in a file called JSHWPart1.js. 
Due 5pm Friday, May 11 */

var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    var nextNum = 0;
    var currNum = 1;
    var prevNum = 0;
    for (var x = 0; x < n; x++) {
        nextNum = currNum + prevNum;
        prevNum = currNum;
        currNum = nextNum;
    }
    return prevNum;
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    for (var x = 0; x < array.length; x++) {
        for (var y = x + 1; y < array.length; y++) {
            temp = 0;
            if (array[x] > array[y]) {
                temp = array[x];
                array[x] = array[y];
                array[y] = temp;
            }
        }
    }
    return array;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    var factorial = 1;
    for (var x = n; x > 0; x--) {
        factorial *= x;
    }
    return factorial;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    for (var x = 0; x < n; x++) {
        var move = array.shift();
        array.push(move);
    }
    return array;
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){
    var stack = [];
    var open = {'{':'}','[':']','(':')'};
    var close = { '}': true, ']': true, ')': true };
    for (x = 0; x < bracketsString.length; x++) {
        if (open[bracketsString[x]]) {
            stack.push(bracketsString[x]);
        } else if (close[bracketsString[x]]) {
            if (open[stack.pop()] !== bracketsString[x]) {
                return false;
            }
        }
    }
    return (stack.length === 0);
};

/*YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;) */


