var myhomeApp = angular.module('myhomeApp', ['ngResource', 'ngRoute', 'ngAnimate', 'albumApp', 'userManageApp']);

myhomeApp.config(function($routeProvider, $locationProvider) {
	$locationProvider.html5Mode({
		enabled: true,
		requireBase: false
	});
	
	$routeProvider.when(window.mps.contextPath + '/album/list', {
		templateUrl: window.mps.contextPath + '/album/list'
	});
	
	$routeProvider.when(window.mps.contextPath + '/userManage/list', {
		templateUrl: window.mps.contextPath + '/userManage/list'
	});
	
	$routeProvider.otherwise({
		templateUrl: window.mps.contextPath + '/dashboard/main'
	});
	 
});


myhomeApp.controller('myhomeAppCtrl', ['$scope', '$http', '$location', function($scope, $http, $location) {
	$scope.mpsMenu = {
		sideSlideMenu : '-1'
	};
	
	$scope.moveChoutube = function() {
		document.location.href = window.mps.contextPath + '/album/choutube';
	};
}]);

