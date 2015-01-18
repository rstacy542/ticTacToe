'use strict';

angular.module('app').controller("GameController", function(gameBoard, ComputerPlayerService){
    var gameController = this;
    gameController.title = "Tic Tac Toe";
    gameController.grid = new Array(3);
    gameController.boardDisabled = false;
    
    gameController.makePlayerMove = function(row, col) {
    	if (!gameController.boardDisabled) {
    		gameController.boardDisabled = true;
    		gameBoard.setSquare(row, col, 'X');	
    		var squarePickedByComputer = ComputerPlayerService.nextMove(gameBoard.squares);
    		gameBoard.setSquare(2, 2, 'O');
    		gameController.boardDisabled = false;
    	}
    }
    
    gameController.getSquareSymbol = function(row, col) {
    	return gameBoard.getSquareSymbol(row,col);
    }
    
});