package com.rts.tictactoe

import org.scalatra._
import scalate.ScalateSupport

class ComputerPlayer extends ScalatraServlet with ScalateSupport {

  get("/nextMove") {
    "8"
  }

}