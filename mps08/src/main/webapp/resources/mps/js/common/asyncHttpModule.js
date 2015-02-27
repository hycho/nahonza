/**
 * Default Content-type은 application/x-www-form-urlencoded
**/

var asyncHttpModule = angular.module('asyncHttpModule', []);

asyncHttpModule.factory('asyncHttpService', function($q, $http, $rootScope) {
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
	
	var asyncHttpService = {};
	
	/**
	 * $http.post를 통해 호출하며 $.param으로 param을 감싸서 호출 할때 사용한다. Controller : @requestParam, @modelAttribute에서 사용
	 */
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
	
	/**
	 * $http.post를 통해 호출하며 Content-Type을 application/json을 통해서 올릴때 사용한다. Controller는 @responseBody를 사용해서 통으로 받아올때 사용한다.
	 */
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
	
	asyncHttpService.httpGet = function(url, params, callback) {
		params = params||{};
		
		$http.get(url, params)
	    .success( function (data) {
	    	if(callback) {
	    		callback(data);
	    	}
	    })
	    .error( function (data, status) {
	    	alert("[Error] " + data);
	    });
	};
			
	return asyncHttpService;
});