#include "clock.h"

#include <sstream>

namespace date_independent {

    clock clock::at(int hour, int minutes) {
        while (minutes > 59) {
            minutes -= 60;
            hour += 1;
        }
        while (minutes < 0) {
            minutes += 60;
            hour -= 1;
        }
        while (hour > 23) hour -= 24;
        while (hour < 0) hour += 24;

        clock c = clock(hour, minutes);
        return c;
    }

    clock::clock(int h, int m): hour(h), minutes(m) {}

    clock clock::plus(int min) const {
        return clock::at(this->hour, this->minutes + min);
    }

    bool clock::operator==(const clock &other) const {
        clock a = at(this->hour, this->minutes);
        clock b = at(other.hour, other.minutes);

        return a.hour == b.hour && b.minutes == a.minutes;
    }

    bool clock::operator!=(const clock &other) const {
        clock a = at(this->hour, this->minutes);
        clock b = at(other.hour, other.minutes);

        return a.hour != b.hour || b.minutes != a.minutes;
    }

    clock::operator std::string() const {
        std::stringstream ss("");
        if (this->hour < 10) ss << 0;
        ss << this->hour << ":";
        if (this->minutes < 10) ss << 0;
        ss << this->minutes;
        return ss.str();
    }
}  // namespace date_independent
