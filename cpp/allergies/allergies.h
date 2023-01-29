#if !defined(ALLERGIES_H)
#define ALLERGIES_H
#include <vector>
#include <unordered_set>
#include <string>

namespace allergies {
    class allergy_test
    {
    private:
        std::unordered_set<std::string> allergies;
    public:
        static const std::vector<std::string> everything;
        explicit allergy_test
        (int score);
        ~allergy_test
        ();

        [[nodiscard]] bool is_allergic_to(const std::string& meal) const;
        [[nodiscard]] std::unordered_set<std::string> get_allergies() const;
    };
}  // namespace allergies

#endif // ALLERGIES_H