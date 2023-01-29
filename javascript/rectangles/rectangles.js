//
// This is only a SKELETON file for the 'Rectangles' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export function count(arr) {
  const points = []
  for (let i = 0; i < arr.length; ++i) {
    const row = points[i]
    for (let j = 0; j < arr.length; ++j) {
      if (row[j] === '+')
        points.push({x: i, y: j})
    }
  }
}
