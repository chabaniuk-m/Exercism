#include "acronym.h"

namespace acronym {

    std::string acronym(const std::string &phrase) {
        std::string copy = phrase;
        for (char & i : copy) {
            if (i == '-')
                i = ' ';
        }
        char *context = nullptr;
        char *token = strtok_s((char*)copy.c_str(), " ", &context);

        std::string acronym;

        while (token != nullptr) {
            std::size_t i = 0;
            for (;!isalpha(token[i]); ++i);
            acronym += char(toupper(token[i]));

            token = strtok_s(nullptr, " ", &context);
        }

        return acronym;
    }
}  // namespace acronym
