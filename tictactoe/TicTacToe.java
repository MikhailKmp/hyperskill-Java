package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    private char[][] table;
    private int moveNumber;

    public void go() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the cells: ");
        initTable(scanner.nextLine());

        printTable();

        System.out.println("Enter the coordinates: ");

        while (!enterCoordinates(scanner.nextLine()));

        printTable();
        printState();
        scanner.close();
    }

    private void initTable(String string) {
        table = new char[3][3];
        int row = 0;

        for (int i = 0; i < 9; i += 3) {
            char[] chars = string.substring(i, i + 3).toCharArray();
            for (int j = 0; j < 3; j++) {
                if (chars[j] == 95) {
                    table[row][j] = ' ';
                }
                else {
                    table[row][j] = chars[j];
                    moveNumber++;
                }
            }
            row++;
        }
    }
    
    private void printTable() {

        System.out.println("-".repeat(9));

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("|");
        }

        System.out.println("-".repeat(9));
    }

    private boolean enterCoordinates(String string) {
        if (!string.matches("\\d \\d")) {
            System.out.println("You should enter numbers!");
            return false;
        }

        int i = Integer.parseInt(string.substring(0,1)) - 1;
        int j = Integer.parseInt(string.substring(2)) - 1;

        if (i > 2 || j > 2) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if (table[i][j] != 32) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        table[i][j] = moveNumber % 2 == 0 ? 'X' : 'O';
        return true;
    }

    private void printState() {
        boolean winX = false;
        boolean winO = false;
        for (int i = 0; i < 3; i++) {
            if (table[i][0] == 'X' && table[i][1] == 'X' && table[i][2] == 'X') {
                winX = true;
                break;
            }
            if (table[0][i] == 'X' && table[1][i] == 'X' && table[2][i] == 'X') {
                winX = true;
                break;
            }
            if (table[i][0] == 'O' && table[i][1] == 'O' && table[i][2] == 'O') {
                winO = true;
                break;
            }
            if (table[0][i] == 'O' && table[1][i] == 'O' && table[2][i] == 'O') {
                winO = true;
                break;
            }
        }

        if (table[0][0] == 'X' && table[1][1] == 'X' && table[2][2] == 'X' ||
            table[0][2] == 'X' && table[1][1] == 'X' && table[2][0] == 'X') {
            winX = true;
        }
        else if (table[0][0] == 'O' && table[1][1] == 'O' && table[2][2] == 'O' ||
                table[0][2] == 'O' && table[1][1] == 'O' && table[2][0] == 'O') {
            winO = true;
        }

        if (winX) {
            System.out.println("X wins");
            return;
        }

        if (winO) {
            System.out.println("O wins");
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == ' ') {
                    System.out.println("Game not finished");
                    return;
                }
            }
        }
        System.out.println("Draw");
    }
}