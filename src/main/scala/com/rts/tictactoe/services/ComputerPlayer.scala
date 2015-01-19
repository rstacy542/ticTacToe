package com.rts.tictactoe

import org.scalatra._
import scalate.ScalateSupport
import com.rts.tictactoe.models.GameBoard

class ComputerPlayer extends ScalatraServlet with ScalateSupport {
  
  get("/nextMove/:boardSquares") {
   
    val boardSquaresArray: Array[String] = {
      if ({params("boardSquares")}.last == ',')
        {params("boardSquares")}.split(",") ++ Array(" ");
      else
        {params("boardSquares")}.split(",");
    }
    
    val gameBoard = new GameBoard(boardSquaresArray);
    
    //handle scenario where only 1 O on board and it is in middle and no way for computer to win
    Ok(gameBoard.highestPrioritySquareOpen());
  }

}
