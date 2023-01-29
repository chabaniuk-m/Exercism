//
// This is only a SKELETON file for the 'Gigasecond' exercise. It's been provided as a
// convenience to get you started writing code faster.
//
function is_leap(year) {
  if (year % 4 === 0)
    if (year % 100 === 0)
      return year % 400 === 0;
    else
      return true
  else
    return false
}

export const gigasecond = (moment) => {
  let giga = 1_000_000_000
  let minute = 60
  let hour = minute * 60
  let day = hour * 24
  let year = day * 365
  let leap_year = year + day
  let new_year = moment.getFullYear()
  let new_month = moment.getMonth()     // 0 - 11
  let new_date = moment.getDate()
  let new_hour = moment.getHours()
  let new_minute = moment.getMinutes()
  let new_second = moment.getSeconds()

// 1 ADD YEARS

// consider next leap year
  if (new_month === 2 && new_date === 29 || new_month >= 3)
    while (giga >= year) {
      new_year += 1
      giga -=  is_leap(new_year) ? leap_year : year
    }
// consider this leap year
  else
    while (giga >= year) {
      new_year += 1
      giga -=  is_leap(new_year) ? leap_year : year
    }

// 2 ADD DAYS

  const add_one_day = () =>
  {
    if ([1, 3, 5, 7, 8, 10, 12].includes(new_month)) {
      if (new_date === 31) {
        new_date = 1
        if (new_month === 12) {
          new_year += 1
          new_month = 1
        } else new_month += 1
      }
      else new_date += 1
    } else if ([4, 6, 9, 11].includes(new_month)) {
      if (new_date === 30) {
        new_date = 1
        new_month += 1
      } else new_date += 1
    }
  else {
      if (new_date === 29 || !is_leap(new_year) && new_date === 28) {
        new_date = 1
        new_month = 3
      } else new_date += 1
    }
  }

  while (giga >= day) {
    giga -= day
    add_one_day()
  }

// 3 ADD HOURS

  const add_hours = (_hours) => {
    new_hour += _hours
    if (new_hour >= 24) {
      new_hour -= 24
      add_one_day()
    }
  }

  if (giga >= hour) {
    add_hours(Math.floor(giga / hour))
    giga %= hour
  }

// 4 ADD MINUTES

  const add_minutes = (_minutes) => {
    new_minute += _minutes
    if (new_minute >= 60) {
      new_minute -= 60
      add_hours(1)
    }
  }

  if (giga >= minute) {
    add_minutes(Math.floor(giga / minute))
    giga %= minute
  }

// 5 ADD SECONDS

  new_second += giga
  if (new_second >= 60) {
    new_second -= 60
    add_minutes(1)
  }

  return new Date(new_year, new_month, new_date, new_hour, new_minute, new_second)
};
