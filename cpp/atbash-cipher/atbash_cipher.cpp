#include "atbash_cipher.h"
#include <sstream>
#include <cctype>

namespace atbash_cipher {
    const std::string plain = "abcdefghijklmnopqrstuvwxyz";
    const std::string cipher = "zyxwvutsrqponmlkjihgfedcba";

    std::string encode(const std::string &text, const bool add_space) {
        std::stringstream ss("");
        int i = 0;
        for (char ch : text) if (isalpha(ch)) {
            ss << cipher[plain.find(char(std::tolower(ch)))];
            if (++i % 5 == 0 && add_space) {
                ss << ' ';
                i = 0;
            }
        } else if (isdigit(ch)) {
            ss << ch;
            if (++i % 5 == 0 && add_space) {
                ss << ' ';
                i = 0;
            }
        }
        std::string res = ss.str();
        return res[res.length() - 1] == ' ' ? res.substr(0, res.length() - 1) : res;
    }

    std::string decode(const std::string &text) {
        return encode(text, false);
    }
}  // namespace atbash_cipher
