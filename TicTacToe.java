import java.util.Scanner;

public class TicTacToe{
  public static void printBoard(String[][] arr) {   //prints out Tic Tac Toe board
    System.out.println("-------------");
    System.out.println("| "+arr[0][0]+" | "+arr[0][1]+" | "+arr[0][2]+" |");
    System.out.println("-------------");
    System.out.println("| "+arr[1][0]+" | "+arr[1][1]+" | "+arr[1][2]+" |");
    System.out.println("-------------");
    System.out.println("| "+arr[2][0]+" | "+arr[2][1]+" | "+arr[2][2]+" |");
    System.out.println("-------------");
  }

  public static void playerMove(String[][] arr) { //player move
    boolean repeat = false;
    while (!repeat) {
      Scanner a = new Scanner(System.in);
      System.out.println("Enter X,Y coordinates for your move: ");
      String coor = a.nextLine();
      if (coor.isEmpty()) {
        repeat = false;
        System.out.println("Invalid move. Try again.");
      }
      else {
        int x1 = Integer.valueOf(coor.substring(0, coor.indexOf(",")));
        int y1 = Integer.valueOf(coor.substring(coor.indexOf(",")+1));
        int x = x1 - 1;
        int y = y1 - 1;
        if (x > 3 || y > 3) {
          repeat = false;
          System.out.println("Invalid move. Try again.");
        }
        if (arr[x][y] == "X" || arr[x][y] == "O") {
          repeat = false;
          System.out.println("Invalid move. Try again.");
        }
        else {
          arr[x][y] = "X";
          repeat = true;
        }
        a.close();
      }
    }
  }
  
  public static void computerMove(String[][] arr) { //computer move
    if (arr[1][1] == " ") { //if center was not taken
      arr[1][1] = "O";  //computer takes center
      return;
    }
    boolean second = false;
    for (int i = 0; i < arr.length; i++) { //this is computerWin horizontal
      if (arr[i][0] == "O" && arr[i][1] == "O" && arr[i][2] == " ") {
        arr[i][2] = "O";
        second = true;
        return;
      }
      if (arr[i][1] == "O" && arr[i][2] == "O" && arr[i][0] == " ") {
        arr[i][0] = "O";
        second = true;
        return;
      }
      if (arr[i][0] == "O" && arr[i][2] == "O" && arr[i][1] == " ") {
        arr[i][1] = "O";
        second = true;
        return;
      }
    }
    for (int j = 0; j < arr.length; j++) { //this is computerWin vertical
      if (arr[0][j] == "O" && arr[1][j] == "O" && arr[2][j] == " ") {
        arr[2][j] = "O";
        second = true;
        return;
      }
      if (arr[1][j] == "O" && arr[2][j] == "O" && arr[0][j] == " ") {
        arr[0][j] = "O";
        second = true;
        return;
      }
      if (arr[0][j] == "O" && arr[2][j] == "O" && arr[1][j] == " ") {
        arr[1][j] = "O";
        second = true;
        return;
      }
    }
    if (arr[0][0] == "O" && arr[1][1] == "O" && arr[2][2] == " ") { //diagonal 1
      arr[2][2] = "O";
      second = true;
      return;
    }
    if (arr[1][1] == "O" && arr[2][2] == "O" && arr[0][0] == " ") {
      arr[0][0] = "O";
      second = true;
      return;
    }
    if (arr[0][0] == "O" && arr[2][2] == "O" && arr[1][1] == " ") {
      arr[1][1] = "O";
      second = true;
      return;
    }
    if (arr[2][0] == "O" && arr[1][1] == "O" && arr[0][2] == " ") { //diagonal 2 
      arr[0][2] = "O";
      second = true;
      return;
    }
    if (arr[1][1] == "O" && arr[0][2] == "O" && arr[2][0] == " ") {
      arr[2][0] = "O";
      second = true;
      return;
    }
    if (arr[2][0] == "O" && arr[0][2] == "O" && arr[1][1] == " ") {
      arr[1][1] = "O";
      second = true;
      return;
    }
    if (!second) {
      for (int i = 0; i < arr.length; i++) { //this is stopPlayerWin horizontal
        if (arr[i][0] == "X" && arr[i][1] == "X" && arr[i][2] == " ") {
          arr[i][2] = "O";
          return;
        }
        if (arr[i][1] == "X" && arr[i][2] == "X" && arr[i][0] == " ") {
          arr[i][0] = "O";
          return;
        }
        if (arr[i][0] == "X" && arr[i][2] == "X" && arr[i][1] == " ") {
          arr[i][1] = "O";
          return;
        }
      }
      for (int j = 0; j < arr.length; j++) { //this is stopPlayerWin vertical
        if (arr[0][j] == "X" && arr[1][j] == "X" && arr[2][j] == " ") {
          arr[2][j] = "O";
          return;
        }
        if (arr[1][j] == "X" && arr[2][j] == "X" && arr[0][j] == " ") {
          arr[0][j] = "O";
          return;
        }
        if (arr[0][j] == "X" && arr[2][j] == "X" && arr[1][j] == " ") {
          arr[1][j] = "O";
          return;
        }
      }
      if (arr[0][0] == "X" && arr[1][1] == "X" && arr[2][2] == " ") { //diagonal 1
        arr[2][2] = "O";
        return;
      }
      if (arr[1][1] == "X" && arr[2][2] == "X" && arr[0][0] == " ") {
        arr[0][0] = "O";
        return;
      }
      if (arr[0][0] == "X" && arr[2][2] == "X" && arr[1][1] == " ") {
        arr[1][1] = "O";
        return;
      }
      if (arr[2][0] == "X" && arr[1][1] == "X" && arr[0][2] == " ") { //diagonal 2 
        arr[0][2] = "O";
        return;
      }
      if (arr[1][1] == "X" && arr[0][2] == "X" && arr[2][0] == " ") {
        arr[0][0] = "O";
        return;
      }
      if (arr[2][0] == "X" && arr[0][2] == "X" && arr[1][1] == " ") {
        arr[1][1] = "O";
        return;
      }
    }
    int a = (int)(Math.random())*4;
    switch (a) {
      case 0: 
        if (arr[1][0] != "X" || arr[1][0] != "O") {
        arr[1][0] = "0";
      }
        break;
      case 1: 
        if (arr[0][2] != "X" || arr[0][2] != "O") {
        arr[0][2] = "0";
      }
        break;
      case 2: 
        if (arr[1][2] != "X" || arr[1][2] != "O") {
        arr[1][2] = "0";
      }
        break;
      case 3: 
        if (arr[2][1] != "X" || arr[2][1] != "O") {
        arr[2][1] = "0";
      }
        break;
    }
        
  }
  public static boolean checkPlayerWin(String[][] arr) { //checks to see if the player won
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; i < arr[0].length; i++) {
        if (arr[i][j] == "X" && arr[i][j+1] == "X" && arr[i][j+2] == "X") {
          return true; //checks for across win
        }
      }
    }
    for (int k = 0; k < arr.length; k++) {
      if (arr[0][k] == "X" && arr[1][k] == "X" && arr[2][k] == "X") {
        return true; //should check for win vertical;
      }
    }
    if (arr[2][0] == "X" && arr[1][1] == "X" && arr[0][2] == "X") {
      return true; //should check for win diagonal
    }
    if (arr[0][0] == "X" && arr[1][1] == "X" && arr[2][2] == "X") {
      return true; //should check for win diagonal
    }
    return false;
  }
      
  public static boolean checkComputerWin(String[][] arr) { //checks to see if the computer won
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; i < arr[0].length; i++) {
        if (arr[i][j] == "O" && arr[i][j+1] == "O" && arr[i][j+2] == "O") {
          return true; //checks for across win
        }
      }
    }
    for (int k = 0; k < arr.length; k++) {
      if (arr[0][k] == "O" && arr[1][k] == "O" && arr[2][k] == "O") {
        return true; //should check for win vertical
      }
    }
    if (arr[0][0] == "O" && arr[1][1] == "O" && arr[2][2] == "O") {
      return true; //should check for win diagonal
    }
    if (arr[2][0] == "O" && arr[1][1] == "O" && arr[0][2] == "O") {
      return true;
    }
    return false;
  }
  
  public static void main(String[] args) { //main method
    System.out.println("Tic Tac Toe Game");
    boolean stop = false;
    while (!stop) {
      String[][] board = new String[3][3];
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board.length; j++) {
          board[i][j] = " ";
        }
      }
      printBoard(board);
      int i = 0;
      while (i < 5) {
        playerMove(board);
        computerMove(board);
        printBoard(board);
        checkPlayerWin(board);
        checkComputerWin(board);
        if (checkPlayerWin(board) == true) {
          System.out.println("Player Wins!");
          break;
        }
        if (checkComputerWin(board) == true) {
          System.out.println("Computer Wins!");
          break;
        }
        if (i == 4) {
          System.out.println("Tie!");
          break;
        }
        i++;
      }
      Scanner restart = new Scanner(System.in);
      System.out.println("Do you want to play again? (Y / N)");
      String ans = restart.next();
      if (ans.equals("Y") || ans.equals("y")) {
        stop = false;
        restart.close();
      }
      else if (ans.equals("N") || ans.equals("n")) {
        stop = true;
      }
    }
  }
}