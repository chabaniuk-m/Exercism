#if !defined(CIRCULAR_BUFFER_H)
#define CIRCULAR_BUFFER_H

#include <cstddef>
#include <vector>

namespace circular_buffer {
    template <class T> class circular_buffer {
    private:
        std::vector<T> buffer;
        std::size_t capacity{};
        std::size_t read_i = 0;
        std::size_t write_i = 0;
    public:
        explicit circular_buffer(std::size_t capacity);
        T read();
        void write(T value);
        void overwrite(T value);
        void clear();
    };


}  // namespace circular_buffer

#endif // CIRCULAR_BUFFER_H