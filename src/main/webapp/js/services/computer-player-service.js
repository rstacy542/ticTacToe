'use strict';

angular.module('app').service('ComputerPlayerService', function ($http) {

	//squares is an array of 9 characters
	//each character is either an 'X', 'O', or ''
	this.nextMove = function(squares) {
		$http.get('/computerPlayer/nextMove/' + squares.toString()).success(function (data) {
	        return parseInt(data);
	    })
	    .error(function () {
	    	return -1;
	    });
	}
});