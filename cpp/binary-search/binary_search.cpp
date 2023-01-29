#include "binary_search.h"

namespace binary_search {
    std::size_t find(const std::vector<int> &v, int value) {
        std::size_t start = 0;
        std::size_t end = v.size() - 1;
        if (end == -1)
            throw std::domain_error("the value is not present in the vector");
        while (start < end - 1) {
            std::size_t mid = (start + end) / 2;
            if (v.at(mid) == value) return mid;
            else if (value < v.at(mid)) end = mid;
            else start = mid;
        }
        if (v.at(end) == value) return end;
        if (v.at(start) == value) return start;
        throw std::domain_error("the value is not present in the vector");
    }
}  // namespace binary_search
