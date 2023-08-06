package middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hujinxu
 */
public class T36_isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 用于存放不同位置的数字集合
        Map<Integer, Set<Character>> map = new HashMap<>(9);
        // 用于存放列的数字集合
        Map<Integer, Set<Character>> colMap = new HashMap<>(9);
        for (int row = 0; row < 9; ++row) {
            // 存放行
            Set<Character> rowSet = new HashSet<>();
            for (int col = 0; col < 9; ++col) {
                char c = board[row][col];
                if (c == '.') {
                    continue;
                }
                // 首先检查行集合
                if (rowSet.contains(c)) {
                    return false;
                } else {
                    rowSet.add(c);
                }

                // 检查列集合
                if (colMap.containsKey(col)) {
                    Set<Character> characters = colMap.get(col);
                    if (characters.contains(c)) {
                        return false;
                    } else {
                        characters.add(c);
                        colMap.put(col, characters);
                    }
                } else {
                    Set<Character> set = new HashSet<>();
                    set.add(c);
                    colMap.put(col, set);
                }

                // 检查九宫格
                if (map.containsKey(row / 3 * 10 + col / 3)) {
                    Set<Character> characters = map.get(row / 3 * 10 + col / 3);
                    if (characters.contains(c)) {
                        return false;
                    } else {
                        characters.add(c);
                        map.put(row / 3 * 10 + col / 3, characters);
                    }
                } else {
                    Set<Character> characters = new HashSet<>();
                    characters.add(c);
                    map.put(row / 3 * 10 + col / 3, characters);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new T36_isValidSudoku().isValidSudoku(board));
    }
}