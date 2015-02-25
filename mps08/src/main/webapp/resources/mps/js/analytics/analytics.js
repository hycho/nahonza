/*!
  * cho analytics lib
  * MIT license
  */
(function (context) {
	if(typeof cAnalytics == 'undefined') {
		cAnalytics = function() {			
			var analysis = this;
			var latig = '';
			var longg = '';
			
			function createuuid() {
			    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
			        var r = Math.random()*16|0, v = c === 'x' ? r : (r&0x3|0x8);
			        return v.toString(16);
			    });
			};
			
			function screent() {
				return screen.availWidth + 'x' + screen.availHeight;
			};
			
			function screenp() {
				return window.innerWidth + 'x' + window.innerHeight;
			};
			
			function cbitt() {
				return screen.colorDepth;
			};
			
			function pcitt() {
				return screen.pixelDepth;
			};
			
			function locl() {
				return window.location;
			};
			
			function charr() {
				return document.characterSet || document.charset;
			};
			
			var geoc = function(){
				navigator.geolocation.getCurrentPosition(setPosition);
			}();
			
			function setPosition(position) {
				collect['lati'] = position.coords.latitude;
				collect['long'] = position.coords.longitude;
			};
			
			function langg() {
				return navigator.language||navigator.userLanguage;
			}
			
			function brow() {
				var agt = navigator.userAgent.toLowerCase();
				if (agt.indexOf("chrome") != -1) return 'Chrome'; 
				if (agt.indexOf("opera") != -1) return 'Opera'; 
				if (agt.indexOf("staroffice") != -1) return 'Star Office'; 
				if (agt.indexOf("webtv") != -1) return 'WebTV'; 
				if (agt.indexOf("beonex") != -1) return 'Beonex'; 
				if (agt.indexOf("chimera") != -1) return 'Chimera'; 
				if (agt.indexOf("netpositive") != -1) return 'NetPositive'; 
				if (agt.indexOf("phoenix") != -1) return 'Phoenix'; 
				if (agt.indexOf("firefox") != -1) return 'Firefox'; 
				if (agt.indexOf("safari") != -1) return 'Safari'; 
				if (agt.indexOf("skipstone") != -1) return 'SkipStone'; 
				if (agt.indexOf("msie") != -1) return 'Internet Explorer'; 
				if (agt.indexOf("netscape") != -1) return 'Netscape'; 
				if (agt.indexOf("mozilla/5.0") != -1) return 'Mozilla'; 
			}
			
			var collect = {
				'resolution' : screent(),
				'viewport' : screenp(),
				'cbit' : cbitt(),
				'pbit' : pcitt(),
				'encoding' : charr(),
				'browser' : brow(),
				'lati' : latig,
				'long' : longg,
				'uuid' : createuuid(),
				'userkey' : ca.arg[0][0],
				'inter' : langg(),
				'domain' : locl().hostname,
				'url' : locl().href,
				'cuuid' : '',
				'loc' : locl().protocol
			};
			
			analysis.getCollect = function() {
				return collect;
			}
			
			return analysis;
		};
	}
	
	window.onbeforeunload = function(e) {
		var collect = cAnalytics().getCollect();
		collect['endT'] = new Date().getTime();
	};
	
	window.onload = function(e) {
		var collect = cAnalytics().getCollect();
		collect['startT'] = new Date().getTime(); 
	};
	
})(this);
