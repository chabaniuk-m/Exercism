let a_code = 'a'.charCodeAt(0)

function gcd(a, b) {
  return !b ? a : gcd(b, a % b)
}

function check(a) {
  if (gcd(a, 26) !== 1)
    throw new Error('a and m must be coprime.')
}

function isAlpha(c) {
  let z = 'z'.charCodeAt(0)
  return a_code <= c.charCodeAt(0) && c.charCodeAt(0) <= z;
}

function isDigit(c) {
  let zero = '0'.charCodeAt(0)
  let nine = '9'.charCodeAt(0)
  return zero <= c.charCodeAt(0) && c.charCodeAt(0) <= nine;
}

export const encode = (phrase, key) => {
  phrase = phrase.toLowerCase()
  const { a, b } = key
  check(a)
  let encoded = ""
  const addSymbol = (code) => {
    encoded += String.fromCharCode([code])
  }
  for (let i = 0, k = 0; i < phrase.length; i++) {
    if (isAlpha(phrase.charAt(i))) {
      addSymbol((a * (phrase.charCodeAt(i) - a_code) + b) % 26 + a_code)
      k += 1
      if (k === 5) {
        encoded += " "
        k = 0
      }
    } else if (isDigit(phrase.charAt(i))) {
      encoded += phrase.charAt(i)
      k += 1
      if (k === 5) {
        encoded += " "
        k = 0
      }
    }
  }
  if (encoded[encoded.length - 1] === ' ')
    return encoded.substring(0, encoded.length - 1)
  return encoded;
};

function mmi(a) {
  for (let i = 1; i < 26; i++) {
    if (a * i % 26 === 1) return i
  }
}

export const decode = (phrase, key) => {
  phrase = phrase.toLowerCase()
  let { a, b } = key
  check(a)
  let decoded = ""
  a = mmi(a)
  for (const c of phrase) {
    if (isAlpha(c)) {
      let code = c.charCodeAt(0) - a_code - b
      while (code < 0) code += 26
      decoded += String.fromCharCode([a * code % 26 + a_code])
    }
    else if (isDigit(c))
      decoded += c
  }
  return decoded
};
