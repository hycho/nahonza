var userManageApp = angular.module('userManageApp', ['asyncHttpModule', 'filterModule', 'ngDialog']);

userManageApp.controller('userManageCtrl', ['$scope', '$http', '$location', 'asyncHttpService', 'userManageService', 'ngDialog', function($scope, $http, $location, asyncHttpService, userManageService, ngDialog) {
	
	$scope.userList = [];
	
	$scope.viewUserInfoDialog = function() {
		ngDialog.open({
			template : window.mps.contextPath + "/userManage/viewUserInfoDialog",
			className : "ngdialog-theme-default",
			controller : "viewUserInfoCtrl",
			scope : $scope
		});
	};
	
	function init() {
		userManageService.findUserList({}, function(result){
			console.log(result);
			$scope.userList = result;
		});
	};
	
	init();
}]);

userManageApp.controller('viewUserInfoCtrl', ['$scope', '$http', '$location', 'asyncHttpService', function($scope, $http, $location, asyncHttpService) {
	
}]);

userManageApp.factory('userManageService', function(asyncHttpService) {
	var service = {};
	
	service.findUserList = function(params, callback) {
		asyncHttpService.httpPost(window.mps.contextPath + '/userManage/findUserList', params, function(data) {
			if(callback){
				callback(data);
			}
		});
	};
	
	return service;
});