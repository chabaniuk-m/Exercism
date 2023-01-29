#if !defined(CLOCK_H)
#define CLOCK_H

#include <string>

namespace date_independent {
    class clock {
    private:
        int hour;
        int minutes;
    public:
        clock(int hour, int minutes);
        static clock at(int hour, int minutes);
        [[nodiscard]] clock plus(int min) const;

        bool operator==(const clock& other) const;
        bool operator!=(const clock& other) const;
    };
}  // namespace date_independent

#endif // CLOCK_H