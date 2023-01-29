//
// This is only a SKELETON file for the 'Armstrong Numbers' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const isArmstrongNumber = (n) => {
  let r = n
  let sum = 0
  let i = Math.floor(Math.log10(n)) + 1
  while (i > 0) {
    sum += Math.pow(r % 10, i)
    i -= 1
    r = Math.floor(r / 10)
    console.log(r)
  }
  return sum === n;
}
