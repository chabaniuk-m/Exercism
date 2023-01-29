//
// This is only a SKELETON file for the 'Darts' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const score = (a, b) => {
  let dist = Math.sqrt(a * a + b * b);
  if (dist <= 1) return 10;
  if (dist <= 5) return 5;
  if (dist <= 10) return 1;
  return 0;
};
