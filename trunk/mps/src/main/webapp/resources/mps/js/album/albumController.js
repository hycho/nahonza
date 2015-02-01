var albumApp = angular.module('albumApp', ['asyncHttpModule']);

albumApp.controller('albumListCtrl', ['$scope', '$http', '$location', 'asyncHttpService', 'albumListService', function($scope, $http, $location, asyncHttpService, albumListService) {
	
	$scope.moveChoutube = function() {
		document.location.href = window.mps.contextPath + '/album/choutube';
	};
	
}]);

albumApp.service('albumListService', function() {
	var service = {};
	var albumList = [];
	
	service = {
		albumList : albumList
	};
	
	return service;
});