var mpsApp = angular.module('mpsApp', ['ngResource', 'ngRoute', 'albumApp']);

mpsApp.config(function($routeProvider, $locationProvider) {
	$locationProvider.html5Mode({
		enabled: true,
		requireBase: false
	});
	
	$routeProvider.when(window.mps.contextPath + '/album/list', {
		templateUrl: window.mps.contextPath + '/album/list',
		controller: 'albumListCtrl'
	});
	
	$routeProvider.otherwise({
		templateUrl: window.mps.contextPath + '/dashboard/main'
	});
});


mpsApp.controller('mpsCtrl', ['$scope', '$http', '$location', function($scope, $http, $location) {
	$scope.moveChoutube = function() {
		document.location.href = window.mps.contextPath + '/album/choutube';
	};
}]);