#include "armstrong_numbers.h"
#include <cmath>

namespace armstrong_numbers {

    bool is_armstrong_number(int n) {
        int num = n;
        int power = int(std::log10(n)) + 1;
        int sum = 0;
        while (n > 0) {
            sum += int(std::pow(n % 10, power));
            n /= 10;
        }
        return sum == num;
    }
}  // namespace armstrong_numbers
