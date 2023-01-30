#include "anagram.h"
#include <sstream>
#include <cctype>

namespace anagram {

    anagram::anagram(const std::string& word) {
        for (const char c : word) {
            this->word.push_back(char(tolower(c)));
        }
    }

    std::string to_lower(const std::string& s) {
        std::stringstream ss("");
        for (const char c : s) ss << (isupper(c) ? char(tolower(c)) : c);
        return ss.str();
    }

    std::vector<std::string> anagram::matches(const std::vector<std::string> &&words) const {

        std::vector<std::string> anagrams;

        for (const auto current : words) {
            auto word = to_lower(current);
            if (word.length() == this->word.size()) {
                bool is_anagram = true;
                bool same_words = true;
                std::vector<char> counted;
                int i = 0;
                for (char c : word) {
                    if (c != this->word[i++]) same_words = false;
                    if (std::find(counted.begin(), counted.end(), c) == counted.end()) {
                        if (std::count(word.cbegin(), word.cend(), c) != std::count(this->word.cbegin(), this->word.cend(), c)) {
                            is_anagram = false;
                            break;
                        }
                        counted.push_back(c);
                    }
                }
                if (is_anagram && !same_words) anagrams.push_back(current);
            }
        }
        return anagrams;
    }
}  // namespace anagram
