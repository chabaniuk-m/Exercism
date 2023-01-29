//
// This is only a SKELETON file for the 'Flatten Array' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

/*export */const flatten = (arr) => {
  let res = []
  for (const el of arr) {
    if (Array.isArray(el)) res = res.concat(flatten(el));
    else res.push(el)
  }
  return res
};