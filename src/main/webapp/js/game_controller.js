'use strict';

angular.module('app').controller("GameController", function(gameBoard, ComputerPlayerService){
    var gameController = this;
    gameController.title = "Tic Tac Toe";
    gameController.grid = new Array(3);
    gameController.boardDisabled = false;
    gameController.gameOver = false;
    
    gameController.makePlayerMove = function(row, col) {
    	//only process the event if it is the players turn
    	if (!gameController.boardDisabled) {
    		gameController.boardDisabled = true;
    		gameBoard.setSquare(row, col, 'X');	
    		
    		if (gameBoard.isFull()) {
    			alert("Game Over");
    			gameController.gameOver = true;
    		} else {
	    		ComputerPlayerService.nextMove(gameBoard.squares).then(function(squareIndex) {
	   				gameBoard.setSquareByIndex(ComputerPlayerService.computerNextMoveIndex(), 'O');
		    		gameController.boardDisabled = false;    
	    		}, function(reason) {
	    			alert(reason);
	    		});
	    	}
    	}
    }
    
    gameController.getSquareSymbol = function(row, col) {
    	return gameBoard.getSquareSymbol(row,col);
    }
    
});