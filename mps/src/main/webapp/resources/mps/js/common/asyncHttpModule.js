/**
 * Default Content-type은 application/x-www-form-urlencoded이다.
**/

var asyncHttpModule = angular.module('asyncHttpModule', []);

asyncHttpModule.factory('asyncHttpService', function($q, $http, $rootScope) {
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
	
	var asyncHttpService = {};
			
	asyncHttpService.httpPost = function(url, params, callback) {
		params = params||{};

		$http.post(url, $.param(params), {
	    }).success(function(data, status) {
	    	if(callback) {
	    		callback(data);
	    	}
	    }).error(function(data, status) {
	    	alert("[Error] " + data);
	    });
	};
	
	asyncHttpService.httpGet = function(url, params, callback) {
		params = params||{};

		$http.get(url, params, {
			headers: {
				   'Content-Type': "application/json"
				}
	    }).success(function(data, status) {
	    	if(callback) {
	    		callback(data);
	    	}
	    }).error(function(data, status) {
	    	alert("[Error] " + data);
	    });
	};
	
	asyncHttpService.httpPostJson = function(url, params, callback) {
		params = params||{};

		$http.post(url, params, {
			headers: {
			   'Content-Type': "application/json"
			}
	    }).success(function(data, status) {
	    	if(callback) {
	    		callback(data);
	    	}
	    }).error(function(data, status) {
	    	alert("[Error] " + data);
	    });
	};
	
	asyncHttpService.httpPostDefer = function(url, params) {
		params = params||{};
		
		var defer = $q.defer();
		
		$http.post(url, $.param(params), {
	    }).success(function(data, status) {
	    	defer.resolve(data);
	    }).error(function(data, status) {
	    	alert("[Error] " + data);
	    });
	    
	    return defer.promise;
	};
			
	return asyncHttpService;
});