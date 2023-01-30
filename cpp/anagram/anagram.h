#if !defined(ANAGRAM_H)
#define ANAGRAM_H

#include <string>
#include <vector>

namespace anagram {
    class anagram {
    private:
        std::vector<char> word;
    public:
        explicit anagram(const std::string& word);
        std::vector<std::string> matches(const std::vector<std::string>&& words) const;
    };
}  // namespace anagram

#endif // ANAGRAM_H