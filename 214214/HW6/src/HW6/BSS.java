package HW6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BSS {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}

class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameEnded;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameEnded = false;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (!gameEnded) {
            drawBoard();
            boolean validInput = false;
            while (!validInput) {
                System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
                try {
                    int row = scanner.nextInt();
                    int col = scanner.nextInt();
                    if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                        board[row][col] = currentPlayer;
                        validInput = true;
                    } else {
                        System.out.println("This move at (" + row + "," + col + ") is not valid. Try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter two integers separated by space.");
                    scanner.nextLine(); // 清除缓冲区
                }
            }
            gameEnded = checkWinner();
            if (!gameEnded) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        drawBoard();
        System.out.println("Player " + currentPlayer + " wins!");
        scanner.close();
    }

    private void drawBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    private boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }
}