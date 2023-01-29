//
// This is only a SKELETON file for the 'All Your Base' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

const convert = (num, a, b) => {
    if (a < 2 || b < 2) throw new Error("Base must be 2 or more");
    let decimal = 0
    let i = 0
    for (let j = num.length - 1; j >= 0; --j) {
        decimal += num[j] * Math.pow(a, i++)
    }
    let res = []
    while (decimal > 0) {
        res.push(decimal % b)
        decimal = Math.floor(decimal / b)
    }
    return res.reverse()
};

console.log(convert([1, 0, 1], 2, 10))
console.log(convert([2, 10], 16, 3))
