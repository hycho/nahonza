var albumApp = angular.module('albumApp', ['asyncHttpModule']);

albumApp.controller('albumListCtrl', ['$scope', '$http', '$location', 'asyncHttpService', 'albumService', function($scope, $http, $location, asyncHttpService, albumService) {
	$scope.albumService = albumService;
	
	$scope.moveChoutube = function() {
		document.location.href = window.mps.contextPath + '/album/choutube';
	};
	
	$scope.clickAlbum = function(album) {
		document.location.href = window.mps.contextPath + '/album/choutube?albumId='+album.albumId;
	};
	
	function init() {
		$scope.albumService.findAllAlbumList({});
	};
	
	init();
}]);

albumApp.factory('albumService', function(asyncHttpService) {
	var service = {};

	service.albumList = [];
	
	service.findAllAlbumList = function(params, callback) {
		asyncHttpService.httpPost(window.mps.contextPath + '/album/findAllAlbumList', params, function(data) {
			service.albumList = data;
			console.log(data);
		});
	};
	
	return service;
});