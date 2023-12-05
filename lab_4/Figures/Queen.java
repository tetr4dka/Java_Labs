public class Queen extends Figure{
    public Queen(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1, Figure[][] fields) {
        if (row == row1 && col != col1 || row != row1 && col == col1 || Math.abs(row - row1) == Math.abs(col - col1)) {
            int rowDir = Integer.compare(row1, row);
            int colDir = Integer.compare(col1, col);
            int i = row + rowDir;
            int j = col + colDir;
            while (Math.abs(col1 - i) > 0 || Math.abs( col1 - j) > 0) {
                if (fields[i][j] != null) {
                    return false;
                }
                i += rowDir;
                j += colDir;
            }
            return true;
        }
        return false;
    }
}
