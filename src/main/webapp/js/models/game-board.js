'use strict';

var GameBoard = function(){
	this.squares = [' ',' ',' ',' ',' ',' ',' ',' ',' '];
	this.squaresFilled = 0;
}

GameBoard.prototype = {
	calculateSquareIndex:function(row, col){
		return (row * 3) + col;
	},
	setSquare:function(row, col, symbol){
		this.squares[this.calculateSquareIndex(row, col)] = symbol;
		this.squaresFilled++;
	},
	setSquareByIndex:function(squareIndex, symbol){
		this.squares[squareIndex] = symbol;
		this.squaresFilled++;
	},
	getSquareSymbol:function(row, col){	
		return this.squares[this.calculateSquareIndex(row, col)];
	},
	isFull:function(){
		if (this.squaresFilled == 9)
			return true;
		else
			return false;
	}
			
}