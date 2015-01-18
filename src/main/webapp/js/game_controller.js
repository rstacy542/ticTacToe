'use strict';

angular.module('app').controller("GameController", function(gameBoard){
    var gameController = this;
    gameController.title = "Tic Tac Toe";
    gameController.grid = new Array(3);
    
    gameController.makePlayerMove = function(row, col) {
    	gameBoard.setSquare(row, col, 'X');	
    }
    
    gameController.getSquareSymbol = function(row, col) {
    	return gameBoard.getSquareSymbol(row,col);
    }
    
});