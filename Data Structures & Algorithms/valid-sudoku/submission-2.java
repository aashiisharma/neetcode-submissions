class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                //Skip no value
                if(board[row][col] == '.') continue;

                //Change to bit
                int valid = board[row][col] - '1';
                int bitValue = 1 << valid;
                
                //Square cordinate
                int square = (row/3) * 3 + (col/3);

                if((rows[row] & bitValue) != 0 ||
                  (cols[col] & bitValue) != 0 ||
                  (squares[square] & bitValue) != 0){
                    return false;
                }

                rows[row] |= bitValue;
                cols[col] |= bitValue;
                squares[square] |= bitValue;
            }
        }
        return true;
    }
}
