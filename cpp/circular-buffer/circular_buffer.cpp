#include "circular_buffer.h"

#include <stdexcept>

namespace circular_buffer {
    template<class T>
    circular_buffer<T>::circular_buffer(std::size_t capacity) {
        this->capacity = capacity;
        this->buffer = {};
        for (int i = 0; i < capacity; ++i) {
            this->buffer.push_back(T(NULL));
        }
    }

    template<class T>
    T circular_buffer<T>::read() {
        if (this->buffer.at(this->read_i) == T(NULL)) throw std::domain_error("the buffer is empty");
        T res = buffer.at(this->read_i);
        buffer.at(this->read_i) = T(NULL);
        this->read_i = (this->read_i + 1) % this->capacity;
        return res;
    }

    template<class T>
    void circular_buffer<T>::write(T value) {
        if (this->buffer.at(this->read_i) != T(NULL)) throw std::domain_error("the buffer is full");
        buffer.at(this->write_i) = value;
        this->write_i = (this->write_i + 1) % this->capacity;
    }

    template<class T>
    void circular_buffer<T>::overwrite(T value) {
        this->buffer.at(this->write_i) = value;
        this->write_i = (this->write_i + 1) % this->capacity;
    }

    template<class T>
    void circular_buffer<T>::clear() {
        for (int i = 0; i < capacity; ++i) {
            this->buffer.at(i) = T(NULL);
        }
    }
}  // namespace circular_buffer
