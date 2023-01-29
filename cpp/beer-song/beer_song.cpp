#include "beer_song.h"

namespace beer_song {
    std::string bottles(int count) {
        std::stringstream ss("");
        ss << count << " bottles";
        return count == 1 ? "1 bottle" : ss.str();
    }

    std::string verse(int count) {
        if (count == 0)
            return "No more bottles of beer on the wall, no more bottles of beer.\n"
                   "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
        if (count == 1)
            return "1 bottle of beer on the wall, 1 bottle of beer.\n"
                   "Take it down and pass it around, no more bottles of beer on the wall.\n";
        std::stringstream ss("");
        ss << bottles(count) << " of beer on the wall, " << bottles(count) << " of beer.\n";
        ss << "Take one down and pass it around, " << bottles(count - 1) << " of beer on the wall.\n";
        return ss.str();
    }

    std::string sing(int start, int end) {
        if (end == -1) end = start;
        std::stringstream ss("");
        for (int i = start; i >= end; --i) {
            ss << verse(i);
            if (i > end) ss << '\n';
        }
        return ss.str();
    }
}  // namespace beer_song
