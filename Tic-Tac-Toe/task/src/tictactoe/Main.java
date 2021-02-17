package tictactoe;

import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")
public class Main {

    public static void main(String[] args) {
        // write your code here
        char[][] board = new char[3][3];
        //the first turn always start with 'X'
        char token = 'X';

        //set up an empty board
        fillField(board, "_________");
        printField(board);

        while (!gameOver(board)) {
            move(board, token);

            //change turn
            if (token == 'X') {
                token = 'O';
            } else //noinspection ConstantConditions
                if (token == 'O') {
                token = 'X';
            } else {
                System.out.println("Something has gone wrong. The token is neither 'X' nor 'O'");
            }
        }
    }

    public static void fillField(char[][] field, String userInput) {
        for (int i = 0, c = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (userInput.charAt(c++)) {
                    case 'X':
                        field[i][j] = 'X';
                        break;
                    case 'O':
                        field[i][j] = 'O';
                        break;
                    case '_':
                        field[i][j] = '_';
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
        }
    }

    public static void printField(char[][] field) {
        String dashes = "----------";
        StringBuilder lineOne = new StringBuilder(" | _ _ _ |");
        StringBuilder lineTwo = new StringBuilder(" | _ _ _ |");
        StringBuilder lineThree = new StringBuilder(" | _ _ _ |");

        lineOne.replace(3, 4, String.valueOf(field[0][0]));
        lineOne.replace(5, 6, String.valueOf(field[0][1]));
        lineOne.replace(7, 8, String.valueOf(field[0][2]));
        lineTwo.replace(3, 4, String.valueOf(field[1][0]));
        lineTwo.replace(5, 6, String.valueOf(field[1][1]));
        lineTwo.replace(7, 8, String.valueOf(field[1][2]));
        lineThree.replace(3, 4, String.valueOf(field[2][0]));
        lineThree.replace(5, 6, String.valueOf(field[2][1]));
        lineThree.replace(7, 8, String.valueOf(field[2][2]));

        System.out.println(dashes);
        System.out.println(lineOne);
        System.out.println(lineTwo);
        System.out.println(lineThree);
        System.out.println(dashes);
    }

    public static boolean gameOver(char[][] field) {
        //store the number of X and O on the board
        int totalX = 0, totalO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 'X') {
                    totalX++;
                } else if (field[i][j] == 'O') {
                    totalO++;
                }
            }
        }

        boolean xVictorious = false, oVictorious = false;
        if (field[0][0] == 'X' && field[0][1] == 'X' && field[0][2] == 'X') {
            xVictorious = true;
        }
        if (field[0][0] == 'O' && field[0][1] == 'O' && field[0][2] == 'O') {
            oVictorious = true;
        }
        if (field[1][0] == 'X' && field[1][1] == 'X' && field[1][2] == 'X') {
            xVictorious = true;
        }
        if (field[1][0] == 'O' && field[1][1] == 'O' && field[1][2] == 'O') {
            oVictorious = true;
        }
        if (field[2][0] == 'X' && field[2][1] == 'X' && field[2][2] == 'X') {
            xVictorious = true;
        }
        if (field[2][0] == 'O' && field[2][1] == 'O' && field[2][2] == 'O') {
            oVictorious = true;
        }
        if (field[0][0] == 'X' && field[1][0] == 'X' && field[2][0] == 'X') {
            xVictorious = true;
        }
        if (field[0][0] == 'O' && field[1][0] == 'O' && field[2][0] == 'O') {
            oVictorious = true;
        }
        if (field[0][1] == 'X' && field[1][1] == 'X' && field[2][1] == 'X') {
            xVictorious = true;
        }
        if (field[0][1] == 'O' && field[1][1] == 'O' && field[2][1] == 'O') {
            oVictorious = true;
        }
        if (field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X') {
            xVictorious = true;
        }
        if (field[0][2] == 'O' && field[1][2] == 'O' && field[2][2] == 'O') {
            oVictorious = true;
        }
        if (field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X') {
            xVictorious = true;
        }
        if (field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O') {
            oVictorious = true;
        }
        if (field[0][2] == 'X' && field[1][1] == 'X' && field[2][0] == 'X') {
            xVictorious = true;
        }
        if (field[0][2] == 'O' && field[1][1] == 'O' && field[2][0] == 'O') {
            oVictorious = true;
        }

        //if any coordinate in the board is empty, return false
        for (int i = 0; i < 3; i++) {
            for (int j = 0; i < 3; i++) {
                if (field[i][j] == '_') {
                    return false;
                }
            }
        }

        if (xVictorious && oVictorious) {
            System.out.println("Impossible");
            return true;
        } else if ((totalX - totalO) < -1 || (totalX - totalO) > 1) {
            System.out.println("Impossible");
            return true;
        } else if (xVictorious) {
            System.out.println("X wins");
            return true;
        } else if (oVictorious) {
            System.out.println("O wins");
            return true;
        } else {
            System.out.println("Draw");
            return true;
        }
    }

    public static void move(char[][] field, char token) {
        /*
        This function is organized in this way:
        1. boilerplate
        2. check for invalid inputs
        3. update the board
        4. print the board
         */

        //1. Boilerplate
        Scanner scanner = new Scanner(System.in);
        int xCoor = 0, yCoor = 0;
        boolean correctInput = false;

        //2. Check for invalid input
        while (!correctInput) {
            System.out.print("Enter the coordinates: ");
            String coordinates = scanner.nextLine();
            //this ensure that the value of xCoor and yCoor will be correct even if the user put more
            //than one space in between their numbers
            coordinates = coordinates.replaceAll("\\s", "");

            if (Character.isDigit(coordinates.charAt(0))) {
                xCoor = Character.getNumericValue(coordinates.charAt(0)) - 1;
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (Character.isDigit(coordinates.charAt(1))) {
                yCoor = Character.getNumericValue(coordinates.charAt(1)) - 1;
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }

            //if the coordinate is invalid, return error message
            if (xCoor < 0 || xCoor > 2 || yCoor < 0 || yCoor > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (field[xCoor][yCoor] == 'X' || field[xCoor][yCoor] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            
            correctInput = true;
        }

        //3. update the board
        field[xCoor][yCoor] = token;

        //4. print board
        printField(field);
    }
}
