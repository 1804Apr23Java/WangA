//behavior that will execute when page loads
window.onload = function() {
    console.log('page loaded');
    counter = getCount();
};
function getCount() {
    var count = 0;
    return function() {
        count += 1;
        console.log("count is: " + count);
        return count;
    }
}