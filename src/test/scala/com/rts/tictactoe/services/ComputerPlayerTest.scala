package com.rts.tictactoe.services

import org.scalatra.test.specs2._
import com.rts.tictactoe.ComputerPlayer

class ComputerPlayerTest extends MutableScalatraSpec {
  
  addServlet(classOf[ComputerPlayer], "/*")
  
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