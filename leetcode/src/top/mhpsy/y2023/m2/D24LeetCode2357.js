const minimumOperations = function (nums) {
    let flag = noZeroMinNum(nums);
    let ans = 0;
    while (flag !== 0) {
        ans++;
        nums.forEach((item, index, arr) => {
            if (item !== 0) arr[index] -= flag;
            //原来forEach是不能改变原来的基本数据类型的,也要用arr[index]这种形式更改
            //forEach里面的item其实是复制出来的一个属性,也就是跟原来的元素没有一点关系
            //但是如果是引用数据类型,那么就是复制的指针就可以改变原来的元素
            //引用数据类型改变引用地址也是没用的,原理也是上面提到的,这是一个复制出来的对象
        })
        flag = noZeroMinNum(nums);
    }
    return ans;
};

const noZeroMinNum = (nums) => {
    let temp = 0, index = 0;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > 0) {//找到第一个非零的值
            temp = nums[i];
            index = i;
            break;
        }
    }

    if (temp === 0 || index === nums.length) return temp;

    for (let i = index; i < nums.length; i++) {
        if (nums[i] < temp && nums[i] !== 0) {
            temp = nums[i];
        }
    }

    return temp;
}

console.log(minimumOperations([1, 5, 0, 3, 5]))
// console.log(noZeroMinNum([2, 5, 0, 3, 5]))