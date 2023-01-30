#include "all_your_base.h"

#include <stdexcept>
#include <cmath>

namespace all_your_base {

    std::vector<unsigned int> convert(int a, const std::vector<unsigned int> &number, int b) {
        if (a < 2 || b < 2) throw std::invalid_argument("Each base must be 2 or more");
        for (auto d : number) {
            if (d >= a) throw std::invalid_argument("Number is invalid");
        }
        unsigned int decimal = 0;
        for (int i = int(number.size()) - 1, p = 0; i >= 0; --i, ++p) {
            decimal += number[i] * std::pow(a, p);
        }
        std::vector<unsigned int> result;
        while (decimal > 0) {
            result.insert(result.begin(), decimal % b);
            decimal /= b;
        }
        return result;
    }
}  // namespace all_your_base
