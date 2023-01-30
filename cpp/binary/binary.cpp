#include "binary.h"
#include <algorithm>

namespace binary {

    int convert(const std::string &binary) {
        if (!std::all_of(binary.cbegin(), binary.cend(), isdigit)) return 0;
        int decimal = 0;
        for (int i = binary.length() - 1, p = 0; i >= 0; --i, ++p) {
            decimal += (binary[i] - '0') * int(pow(2, p));
        }
        return decimal;
    }
}  // namespace binary
