package Advanced.Exam;

import java.util.Scanner;

public class E02_PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessboard = new char[8][8];

        for (int row = 0; row < 8; row++) {
            chessboard[row] = scanner.nextLine().toCharArray();
        }

        int rowWhitePawns = 0;
        int colWhitePawns = 0;
        int rowBlackPawns = 0;
        int colBlackPawns = 0;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (chessboard[row][col] == 'b') {
                    rowBlackPawns = row;
                    colBlackPawns = col;
                }
                if (chessboard[row][col] == 'w') {
                    rowWhitePawns = row;
                    colWhitePawns = col;
                }
            }
        }

        while (true) {
            if (isInChessboard(rowWhitePawns - 1, colWhitePawns - 1) && chessboard[rowWhitePawns - 1][colWhitePawns - 1] == 'b') {
                String position = SetPosition(rowWhitePawns - 1, colWhitePawns - 1);
                System.out.printf("Game over! White capture on %s.", position);
                break;
            } else if (isInChessboard(rowWhitePawns - 1, colWhitePawns + 1) && chessboard[rowWhitePawns - 1][colWhitePawns + 1] == 'b') {
                String position = SetPosition(rowWhitePawns - 1, colWhitePawns + 1);
                System.out.printf("Game over! White capture on %s.", position);
                break;
            } else {
                chessboard[rowWhitePawns][colWhitePawns] = '-';
                rowWhitePawns -= 1;
                chessboard[rowWhitePawns][colWhitePawns] = 'w';
                if (rowWhitePawns == 0) {
                    String position = SetPosition(rowWhitePawns, colWhitePawns);
                    System.out.printf("Game over! White pawn is promoted to a queen at %s.", position);
                    break;
                }
            }

            if (isInChessboard(rowBlackPawns + 1, colBlackPawns - 1) && chessboard[rowBlackPawns + 1][colBlackPawns - 1] == 'w') {
                String position = SetPosition(rowBlackPawns + 1, colBlackPawns - 1);
                System.out.printf("Game over! Black capture on %s.", position);
                break;
            } else if (isInChessboard(rowBlackPawns + 1, colBlackPawns + 1 )&& chessboard[rowBlackPawns + 1][colBlackPawns + 1] == 'w') {
                String position = SetPosition(rowBlackPawns + 1, colBlackPawns + 1 );
                System.out.printf("Game over! Black capture on %s.", position);
                break;
            } else {
                chessboard[rowBlackPawns][colBlackPawns] = '-';
                rowBlackPawns += 1;
                chessboard[rowBlackPawns][colBlackPawns] = 'b';
                if (rowBlackPawns == 7) {
                    String position = SetPosition(rowBlackPawns, colBlackPawns);
                    System.out.printf("Game over! Black pawn is promoted to a queen at %s.", position);
                    break;
                }
            }

        }
    }

    private static String SetPosition(int row, int col) {
        StringBuilder builder = new StringBuilder();
        for (int i = 8; i >= 0; i--) {
            if (col == i) {
                builder.append((char)(i + 97));
            }
        }

        int counter = 8;
        for (int i = 0; i < 8; i++) {
            if (row == i) {
                builder.append(counter);
            }
            counter--;
        }
        return builder.toString();
    }

    public static boolean isInChessboard (int row, int col) {
        return row >= 0 && row <= 7 && col >= 0 && col <= 7;
    }
}
