package com.rts.tictactoe.models

import org.scalatra.test.specs2._

class GameBoardTest extends MutableScalatraSpec {

  val emptyGameBoard = new GameBoard(Array(" ", " ", " ", " ", " ", " ", " ", " ", " "));
  
  "filledSquaresCount " should {
    "return 0 when the board is empty" in {
      emptyGameBoard.filledSquaresCount must_== 0;
    }
    "return 9 when board is full" in {
      new GameBoard(Array("X", "X", "X", "X", "X", "X", "X", "X", "X")).filledSquaresCount must_== 9;
    }
    "return 3 when board has 2 X and 1 O" in {
      new GameBoard(Array("O", " ", " ", " ", "X", " ", " ", " ", "X")).filledSquaresCount must_== 3;
    }
  }
  
  "highestPrioritySquareOpen " should {
     "return 4 when there are no squares currently taken" in {
       emptyGameBoard.highestPrioritySquareOpen() must_== 4
     }
     "return -1 when all squares are currently taken" in {
       new GameBoard(Array("X","X","X","X","X","X","X","X","X")).highestPrioritySquareOpen() must_== -1      
     }
     "return 0 when the 4th square is already taken" in {
       new GameBoard(Array(" "," "," "," ","X"," "," "," "," ")).highestPrioritySquareOpen() must_== 0       
     }
  }

  "winningSquareFor " should {
    val gameBoard = new GameBoard(Array("X", "O", "X", " ", "O", "O", " ", " ", "X"));
    
    "return 7 for winning combination of 1,4,7 and symbol O" in {
      gameBoard.winningSquareFor("O", List(1, 4, 7)) must_== 7
    }
    "return -1 for winning combination of 1,4,7 and symbol X" in {
      gameBoard.winningSquareFor("X", List(1, 4, 7)) must_== -1
    }
    "return -1 for winning combination of 0,3,6 and symbol X" in {
      gameBoard.winningSquareFor("X", List(0, 3, 6)) must_== -1
    }
    "return -1 for winning combination of 2,5,8 and symbol X" in {
      gameBoard.winningSquareFor("X", List(2, 5, 8)) must_== -1
    }
    "return -1 for winning combination of 2,5,8 and symbol X" in {
      emptyGameBoard.winningSquareFor("X", List(2, 5, 8)) must_== -1
    }
    
  }
  
  "winningMoveFor " should {
    val gameBoard = new GameBoard(Array("X", "O", "X", " ", " ", "O", "X", "O", "X"));
    val gameBoardNoWinningMoves = new GameBoard(Array("X", "X", "O", "O", "X", "O", "X", "O", "X"));
    
    "return 3 for symbol X" in {
      gameBoard.winningMoveFor("X") must_== 3;
    }
    "return 4 for symbol O" in {
      gameBoard.winningMoveFor("O") must_== 4;
    }
    "return -1 for symbol X" in {
      gameBoardNoWinningMoves.winningMoveFor("X") must_== -1;
    }
    "return -1 for symbol O" in {
      gameBoardNoWinningMoves.winningMoveFor("O") must_== -1;
    }
    "return -1 for symbol X" in {
      emptyGameBoard.winningMoveFor("X") must_== -1;
    }
    "return -1 for symbol O" in {
      emptyGameBoard.winningMoveFor("O") must_== -1;
    }
  }
  
  "opposingSymbol " should {
    "return O when passed X" in {
      GameBoard.opposingSymbol("X") must_== "O";
    }
    "return X when passed O" in {
      GameBoard.opposingSymbol("O") must_== "X";
    }
  }
  
  "futureWinningMoveExistsFor " should {
    "return false when the middle square is not the opposite of symbol passed to it" in {
      val gameBoard = new GameBoard(Array("X", " ", " ", " ", "O", " ", " ", " ", "X"));
      gameBoard.futureWinningMoveExistsFor("O") must_== false;
    }
    "return false when their are less than 3 squares played" in {
      val gameBoard = new GameBoard(Array("O", " ", " ", " ", "X", " ", " ", " ", " "));
      gameBoard.futureWinningMoveExistsFor("O") must_== false;
    }
    "return false when their are more than 3 squares played" in {
      val gameBoard = new GameBoard(Array("O", "X", " ", " ", "X", " ", " ", "O", " "));
      gameBoard.futureWinningMoveExistsFor("O") must_== false;
    }
    "return true when middle square is opposite symbol and only 3 squares have been played" in {
      val gameBoard = new GameBoard(Array("X", " ", " ", " ", "O", " ", " ", " ", "X"));
      gameBoard.futureWinningMoveExistsFor("X") must_== true;
    }
  }
}