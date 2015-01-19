package com.rts.tictactoe

import org.scalatra._
import scalate.ScalateSupport

class ComputerPlayer extends ScalatraServlet with ScalateSupport {
  
  get("/nextMove/:boardSquares") {
   
    val boardSquaresArray: Array[String] = {
      if ({params("boardSquares")}.last == ',')
        {params("boardSquares")}.split(",") ++ Array(" ");
      else
        {params("boardSquares")}.split(",");
    }
    
    Ok(ComputerPlayer.highestPrioritySquareOpen(boardSquaresArray));
  }

}
object ComputerPlayer {
   //Ordered array of square indices in order of best squares to play in
  def squarePrioritization: List[Int] = List(4, 0, 2, 6, 8, 1, 3, 5, 7);
  
  def highestPrioritySquareOpen(boardSquaresArray:Array[String]):Int = {
    val prioritizedListOfRemainingSquares = squarePrioritization.filter { x => boardSquaresArray(x) == " " };
    println("remaining squares: " + prioritizedListOfRemainingSquares.size);
    if (prioritizedListOfRemainingSquares.isEmpty)
      return -1;
    else
      return prioritizedListOfRemainingSquares.head;
  };
 
}