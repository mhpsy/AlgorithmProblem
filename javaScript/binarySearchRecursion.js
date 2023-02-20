function XX() { }

XX.prototype.Rank = function (arr, key) {
    return this.binarySearchRank(arr, key, 0, arr.length - 1)
}

XX.prototype.binarySearchRank = function (arr, key, lo, hi){
    if (lo > hi) return -1;
    let mid = Math.ceil(lo + (hi - lo) / 2);
    if (arr[mid] > key) return this.binarySearchRank(arr, key, lo, mid - 1)
    else if (arr[mid] < key) return this.binarySearchRank(arr, key, mid + 1, hi)
    else return mid
}

//test
const arr = [];
for (let i = 0; i < 100; i++) {
    //Manually create an incremental array
    //with test this function
    arr.push(Math.floor(Math.random() * 100 + i * 100))
}

const xxObj = new XX();
const res = [];
for (let i = 0; i < 100; i++) {
    //if xxObj.Rank return not equal i then function not correct
    res.push(xxObj.Rank(arr, arr[i]) === i)
}

console.log(res.filter(v => !v));//all true then []