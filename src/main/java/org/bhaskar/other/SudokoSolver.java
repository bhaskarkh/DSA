package org.bhaskar.other;

public class SudokoSolver {
    final static Integer BOARD_SIZE = 9;

    public static void main(String[] args) {
        int[][] board = {
                {0, 7, 0, 0, 2, 0, 0, 4, 6},
                {0, 6, 0, 0, 0, 0, 8, 9, 0},
                {2, 0, 0, 8, 0, 0, 7, 1, 5},
                {0, 8, 4, 0, 9, 7, 0, 0, 0},
                {7, 1, 0, 0, 0, 0, 0, 5, 9},
                {0, 0, 0, 1, 3, 0, 4, 8, 0},
                {6, 9, 7, 0, 0, 2, 0, 0, 8},
                {0, 5, 8, 0, 0, 0, 0, 6, 0},
                {4, 3, 0, 0, 8, 0, 0, 7, 0}
        };
        if (solveGivenSudoku(board)) {
            System.out.println("solved successfully");
            printBoard(board);
        } else {
            System.out.println("failed to solve");
        }

    }

    private static void printBoard(int[][] board) {
        String line="-------------------------";
        System.out.println(line);
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j == 2 || j == 5)
                    System.out.print(board[i][j] + " | ");
                else
                    System.out.print(board[i][j] + " ");
            }
            System.out.print("|");
            System.out.println("");
            if (i == 2 || i == 5)
                System.out.println(line);
        }
        System.out.println(line);
    }

    public static boolean solveGivenSudoku(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValidValue(board, k, i, j)) {
                            board[i][j] = k;
                            if (solveGivenSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidValue(int[][] board, int value, int row, int col) {
        return (validColValue(board, value, col) && validRowValue(board, value, row) && validGridValue(board, value, row, col));
    }

    private static boolean validGridValue(int[][] board, int value, int row, int col) {
        int rowStart = row - row % 3;
        int colStart = col - col % 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == value) return false;
            }
        }
        return true;
    }

    private static boolean validColValue(int[][] board, int value, int col) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][col] == value) return false;
        }
        return true;
    }

    private static boolean validRowValue(int[][] board, int value, int row) {

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == value) return false;
        }
        return true;
    }
}
