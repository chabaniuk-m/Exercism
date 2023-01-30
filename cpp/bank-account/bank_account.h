#if !defined(BANK_ACCOUNT_H)
#define BANK_ACCOUNT_H

#include <mutex>

namespace Bankaccount {
    class Bankaccount {
    private:
        bool is_open;
        int _balance;
        std::mutex m;
    public:
        Bankaccount();
        [[nodiscard]] int balance() const;
        void deposit(int amount);
        int withdraw(int amount);
        void open();
        void close();
    };  // class Bankaccount
}  // namespace Bankaccount

#endif  // BANK_ACCOUNT_H