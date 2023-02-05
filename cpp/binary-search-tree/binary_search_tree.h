#if !defined(BINARY_SEARCH_TREE_H)
#define BINARY_SEARCH_TREE_H

#include <cstddef>
#include <memory>

namespace binary_search_tree {

    template<class T>
    class binary_tree {
    private:
        binary_tree<T> *left_c = nullptr;
        binary_tree<T> *right_c = nullptr;
        T value;
        size_t size;
    public:
        binary_tree();
        explicit binary_tree(T iter);
        ~binary_tree();

        std::unique_ptr<binary_tree<T>> left() const;
        std::unique_ptr<binary_tree<T>> right() const;
        T data() const;

        void insert(T data);

        T* begin();
        T* end();
    private:
        void fill_array(T *arr, size_t& idx) const;
    };
}  // namespace binary_search_tree

#endif // BINARY_SEARCH_TREE_H