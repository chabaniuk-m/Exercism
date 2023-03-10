#if !defined(BINARY_SEARCH_H)
#define BINARY_SEARCH_H

#include <stdexcept>
#include <vector>

namespace binary_search {
    std::size_t find(const std::vector<int> &v, int value);
}  // namespace binary_search

#endif // BINARY_SEARCH_H