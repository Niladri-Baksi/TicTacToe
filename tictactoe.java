import java.util.Scanner;

public class tictactoe {
    static char[][] board = {
            { '1', '2', '3' },
            { '4', '5', '6' },
            { '7', '8', '9' }
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter a number (1-9) to make your move:");
            int move = scanner.nextInt();

            if (isValidMove(move)) {
                placeMove(move, currentPlayer);
                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    // Prints the current state of the board
    public static void printBoard() {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Checks if the move is valid
    public static boolean isValidMove(int move) {
        if (move < 1 || move > 9)
            return false;

        int row = (move - 1) / 3;
        int col = (move - 1) % 3;

        return board[row][col] != 'X' && board[row][col] != 'O';
    }

    // Places the player's move on the board
    public static void placeMove(int move, char player) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        board[row][col] = player;
    }

    // Checks if the current player has won
    public static boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    // Checks if the board is full
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
}
