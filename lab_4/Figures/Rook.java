public class Rook extends Figure{
    public Rook(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1, Figure[][] fields) {
        if (row == row1 || col == col1){
            int direction = 0;
            if (Math.abs(row - row1) != 0) {
                direction = row < row1 ? 1 : -1;
                if (!checkEmptyFields(row, row1, direction, col, fields)) return false;
            }
            if (Math.abs(col - col1) != 0) {
                direction = col < col1 ? 1 : -1;
                if (!checkEmptyFields(col, col1, direction, row, fields)) return false;
            }
            return true;
        }
        return false;
    }

    private boolean checkEmptyFields(int start, int end, int step, int index, Figure[][] fields) {
        for (int i = start + step; Math.abs(end - i) > 0; i = i + step) {
            if (fields[index][i] != null) return false;
        }
        return true;
    }
}
