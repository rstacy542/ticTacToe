package com.rts.tictactoe

import org.scalatra.test.specs2._

class ComputerPlayerTest extends MutableScalatraSpec {
  
  addServlet(classOf[ComputerPlayer], "/*")

  "highestPrioritySquareOpen " should {
     "return 4 when there are no squares currently taken" in {
       ComputerPlayer.highestPrioritySquareOpen(Array(" "," "," "," "," "," "," "," "," ")) must_== 4
     }
     "return -1 when all squares are currently taken" in {
       ComputerPlayer.highestPrioritySquareOpen(Array("X","X","X","X","X","X","X","X","X")) must_== -1      
     }
     "return 0 when the 4th square is already taken" in {
       ComputerPlayer.highestPrioritySquareOpen(Array(" "," "," "," ","X"," "," "," "," ")) must_== 0       
     }
  }
  
  "GET /nextMove/,,,,,,,,, on ComputerPlayer" should {
    "return square index 4 when all squares are available" in {
      get("/nextMove/%20,%20,%20,%20,%20,%20,%20,%20,%20") {
        response.getContent() must_== "4"
        status must_== 200
      }
    }
    "return square index 0 when only the middle square is taken" in {
      get("/nextMove/%20,%20,%20,%20,X,%20,%20,%20,%20") {
        response.getContent() must_== "0"
        status must_== 200
      }
    }
    "return -1 when all squares are full" in {
      get("/nextMove/X,X,X,X,X,X,X,X,X") {
        response.getContent() must_== "-1"
        status must_== 200
      }
    }
  }
}