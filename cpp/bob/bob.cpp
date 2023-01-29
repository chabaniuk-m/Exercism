#include <algorithm>
#include "bob.h"

namespace bob {

    std::string trim(const std::string& s) {
        std::size_t start = 0;
        std::size_t end = s.length() - 1;
        for (; start < s.length() && isspace(s.at(start)); ++start);
        for (; end >= 0 && isspace(s.at(end)); --end);
        return s.substr(start, end + 1 - start);
    }

    bool is_upper(const std::string& message) {
        if (std::none_of(message.cbegin(), message.cend(), isalpha)) return false;
        for (const char ch : message) {
            if (isalpha(ch)) if (!isupper(ch)) return false;
        }
        return true;
    }

    std::string hey(const std::string& s) {
        if (std::all_of(s.cbegin(), s.cend(), isspace)) return "Fine. Be that way!";
        const std::string message = trim(s);
        if (message.at(message.length() - 1) == '?') {
            if (is_upper(message)) return "Calm down, I know what I'm doing!";
            return "Sure.";
        }
        if (is_upper(message)) return "Whoa, chill out!";
        return "Whatever.";
    }
}  // namespace bob
