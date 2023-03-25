package middle;

public class T1138_alphabetBoardPath {
    public String alphabetBoardPath(String target) {
        StringBuilder result = new StringBuilder();
        int curRow = 0;
        int curCol = 0;
        boolean fin = true;
        for (int i = 0; i < target.length(); i++) {
            int row = (target.charAt(i) - 'a') / 5;
            int col = (target.charAt(i) - 'a') % 5;
            while (row < curRow) {
                result.append('U');
                curRow--;
            }
            while (col < curCol) {
                result.append('L');
                curCol--;
            }
            while (row > curRow) {
                result.append('D');
                curRow++;
            }
            while (col > curCol) {
                result.append('R');
                curCol++;
            }
            result.append('!');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T1138_alphabetBoardPath().alphabetBoardPath("zdz"));
    }
}
