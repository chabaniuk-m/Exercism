#include "allergies.h"

namespace allergies {
    const std::vector<std::string> allergy_test::everything = {"eggs", "peanuts", "shellfish", "strawberries", "tomatoes", "chocolate", "pollen", "cats"};

    allergy_test
    ::allergy_test
    (int score)
    {
        this->allergies = {};
        int i = 0;
        while (score > 0 && std::size_t(i) < allergy_test::everything.size()) {
            if (score % 2 == 1) {
                this->allergies.insert(allergy_test::everything.at(i));
            }
            score /= 2;
            i += 1;
        }
    }

    allergy_test
    ::~allergy_test
    () = default;

    bool allergy_test::is_allergic_to(const std::string& meal) const {
        return this->allergies.count(meal);
    }

    std::unordered_set<std::string> allergy_test::get_allergies() const {
        return this->allergies;
    }
}  // namespace allergies
