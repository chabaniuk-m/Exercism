#include "bank_account.h"

#include <stdexcept>

namespace Bankaccount {

    Bankaccount::Bankaccount(): is_open(false), _balance(0){}

    int Bankaccount::balance() const {
        if (!is_open) throw std::runtime_error("Account is closed");
        return this->_balance;
    }

    void Bankaccount::deposit(int amount) {
        if (!is_open || amount < 0) throw std::runtime_error("Account is closed");
        m.lock();
        this->_balance += amount;
        m.unlock();
    }

    int Bankaccount::withdraw(int amount) {
        if (!is_open || amount < 0) throw std::runtime_error("Account is closed");
        if (amount > this->_balance) throw std::runtime_error("Insufficient number of funds on the balance");
        m.lock();
        this->_balance -= amount;
        m.unlock();
        return amount;
    }

    void Bankaccount::close() {
        if (!is_open) throw std::runtime_error("Account is already closed");
        this->is_open = false;
    }

    void Bankaccount::open() {
        if (is_open) throw std::runtime_error("Account is already open");
        this->is_open = true;
        this->_balance = 0;
    }
}