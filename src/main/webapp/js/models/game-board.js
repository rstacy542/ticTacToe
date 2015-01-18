'use strict';

var GameBoard = function(){
	this.squares = new Array(9);
}

GameBoard.prototype = {
	calculateSquareIndex:function(row, col){
		return (row * 3) + col;
	},
	setSquare:function(row, col, symbol){	
		this.squares[this.calculateSquareIndex(row, col)] = symbol;
	}
			
}