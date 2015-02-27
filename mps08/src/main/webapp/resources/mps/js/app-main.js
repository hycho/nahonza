var mainApp = angular.module('mainApp', ['albumApp']);

mainApp.controller('mainCtrl', ['$scope', '$http', '$location', 'albumService', function($scope, $http, $location, albumService) {
	
	$scope.flags = {
		viewLogin : 'false',
		viewMyMusic : 'false'
	};
	
	$scope.clickAlbum = function(albumId) {
		document.location.href = window.mps.contextPath + '/album/choutube?albumId='+albumId;
	};
	
	$scope.goToMyHome = function() {
		document.location.href = window.mps.contextPath + '/myhome/main';
	};
	
	$scope.publicMusicAlbum = [];
	
	function init() {
		initAllAlbumList();
	};
	
	var initAllAlbumList = function() {
		albumService.findAllAlbumList({}, function(data) {
			$scope.publicMusicAlbum = data;
		});
	};
	
	init();
	
}]);

