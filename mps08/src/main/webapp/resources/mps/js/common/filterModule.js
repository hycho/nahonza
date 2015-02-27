var filterModule = angular.module('filterModule', []);


//oxbyfilter
filterModule.filter("UseByNumber", function() {
	return function (code) {
		if(code == '01'){
			return "Use"
		}else {
			return "Not Use"
		}
  	};
});

//oxbyBool filter
filterModule.filter("OXByBool", function() {
	return function (code) {
		if(code == true || code == "true"){
			return "O"
		}else {
			return "X"
		}
  	};
});

//TFbyBool filter
filterModule.filter("HiddenByBool", function() {
	return function (code) {
		if(code == true || code == "true"){
			return "숨김"
		}else {
			return "표시"
		}
  	};
});