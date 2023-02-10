import java.util.regex.Pattern;

class Connect {
    private final String[] board;
    private boolean isEmpty = true;

    public Connect(String[] board) {
        this.board = new String[board.length];
        for (int i = 0; i < board.length; i++) {
            this.board[i] = board[i].trim();
            if (isEmpty && !Pattern.matches("^\\.+$", this.board[i])) {
                isEmpty = false;
            }
        }
    }

    public Winner computeWinner() {
        if (isEmpty) return Winner.NONE;

        // check if X wins
        for (int i = 0; i < board.length; i++) {
            if (board[i].charAt(0) == 'X')
                if (wins(i, 0, 'r', i, i, 0))
                    return Winner.PLAYER_X;
        }

        // check if O wins
        for (int i = 0; i < board[0].length(); ++i) {
            if (board[0].charAt(i) == 'O')
                if (wins(0, i, 'd', i, 0, i))
                    return Winner.PLAYER_O;
        }

        return Winner.NONE;
    }

    public boolean wins(int row, int col, char direction, int start, int prevRow, int prevCol) {
        if (direction == 'r') {     // right
            if (col == board.length - 1) {
                // also check up, down & left
                boolean wins = row == start;
                if (wins) return true;

                if (row - 1 != -1 && row - 1 != prevRow)            // can go up
                    wins = wins(row - 1, col, direction, start, row, col);
                if (wins) return true;


                return row == start;
            }
        } else {                    // down

        }
    }
}
