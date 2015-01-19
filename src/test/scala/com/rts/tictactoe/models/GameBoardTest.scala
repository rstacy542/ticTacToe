package com.rts.tictactoe.models

import org.scalatra.test.specs2._

class GameBoardTest extends MutableScalatraSpec {

  val emptyGameBoard = new GameBoard(Array(" ", " ", " ", " ", " ", " ", " ", " ", " "));
  
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
}