#include "binary_search_tree.h"

namespace binary_search_tree {

    template<class T>
    binary_tree<T>::binary_tree() = default;

    template<class T>
    binary_tree<T>::binary_tree(T value) : value(value), size(1) {}

    template<class T>
    binary_tree<T>::~binary_tree() {
        delete this->left_c;
        delete this->right_c;
    }

    template<class T>
    void binary_tree<T>::insert(T data) {
        if (data < this->value)
            if (this->left_c) this->left_c->insert(data);
            else this->left_c = new binary_tree(data);
        else
            if (this->right_c) this->right_c->insert(data);
            else this->right_c = new binary_tree(data);
        this->size += 1;
    }

    template<class T>
    std::unique_ptr<binary_tree<T>> binary_tree<T>::left() const {
        return std::unique_ptr(this->left_c);
    }

    template<class T>
    std::unique_ptr<binary_tree<T>> binary_tree<T>::right() const {
        return std::unique_ptr(this->right_c);
    }

    template<class T>
    T binary_tree<T>::data() const {
        return this->value;
    }

    template<class T>
    T *binary_tree<T>::begin() {
        size_t idx = 0;
        auto arr = new T[this->size];
        this->fill_array(arr, idx);
        return arr;
    }

    template<class T>
    T *binary_tree<T>::end() {
        return &this->begin()[this->size];
    }

    template<class T>
    void binary_tree<T>::fill_array(T *arr, size_t &idx) const {
        if (this->left_c) this->left_c->fill_array(arr, idx);
        arr[idx++] = this->value;
        if (this->right_c) this->right_c->fill_array(arr, idx);
    }
}  // namespace binary_search_tree
