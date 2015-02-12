/**
 * addon asyncHttpModule.js(비동기 호출 모듈)
 */

var choutubeApp = angular.module('choutubeApp', ['asyncHttpModule']);

// Run
choutubeApp.run(function () {
	var tag = document.createElement('script');
	tag.src = "http://www.youtube.com/iframe_api";
	var firstScriptTag = document.getElementsByTagName('script')[0];
	firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
});

// Config
choutubeApp.config( function ($httpProvider) {
	delete $httpProvider.defaults.headers.common['X-Requested-With'];
});

// Service
choutubeApp.service('VideosService', ['$window', '$rootScope', '$log', function ($window, $rootScope, $log) {
	var service = this;
	var typeIdx = 0;
	var album = {
		albumId : ""
	};
	
	var playTypes = [
	    "repeat",
	    "suffle",
	    "random"
	];
	
	var playType = playTypes[typeIdx];
	
	var youtube = {
	    ready: false,
	    player: null,
	    playerId: null,
	    videoId: null,
	    videoTitle: null,
	    playerHeight: '480',
	    playerWidth: '640',
	    state: 'stopped',
	    playIdx : 0
	};
  
	var results = [];
	  
	var upcoming = [];
  
	$window.onYouTubeIframeAPIReady = function () {
	    $log.info('Youtube API is ready');
	    youtube.ready = true;
	    service.bindPlayer('placeholder');
	    service.loadPlayer();
	    $rootScope.$apply();
	};

	function onYoutubeReady (event) {
	    $log.info('YouTube Player is ready');
	    youtube.player.cueVideoById(upcoming[0].playId);
	    youtube.videoId = upcoming[0].playId;
	    youtube.videoTitle = upcoming[0].title;
	}

	function onYoutubeStateChange (event) {
	    if (event.data == YT.PlayerState.PLAYING) {
	    	youtube.state = 'playing';
	    } else if (event.data == YT.PlayerState.PAUSED) {
	    	youtube.state = 'paused';
	    } else if (event.data == YT.PlayerState.ENDED) {
		    youtube.state = 'ended';

		    if(playType == 'repeat') {
		    	nextPlay();
		    } else if(playType == 'suffle') {
		    	sufflePlay();
		    } else {
		    	randomPlay();
		    }
	    }
	    $rootScope.$apply();
	}
	
	function nextPlay() {
		if(upcoming.length <= ++youtube.playIdx) {
			youtube.playIdx = 0;
		}
		service.launchPlayer(upcoming[youtube.playIdx].playId, upcoming[youtube.playIdx].title);
	    $rootScope.$broadcast("VideosController::selTitle", youtube.playIdx);
	};
	
	function sufflePlay() {
		service.launchPlayer(upcoming[youtube.playIdx].playId, upcoming[youtube.playIdx].title);
	    $rootScope.$broadcast("VideosController::selTitle", youtube.playIdx);
	};
	
	function randomPlay() {
		youtube.playIdx = Math.floor(Math.random() * upcoming.length);
		service.launchPlayer(upcoming[youtube.playIdx].playId, upcoming[youtube.playIdx].title);
	    $rootScope.$broadcast("VideosController::selTitle", youtube.playIdx);
	};

	this.bindPlayer = function (elementId) {
		$log.info('Binding to ' + elementId);
		youtube.playerId = elementId;
	};

	this.createPlayer = function () {
		$log.info('Creating a new Youtube player for DOM id ' + youtube.playerId + ' and video ' + youtube.videoId);
		return new YT.Player(youtube.playerId, {
			height: youtube.playerHeight,
			width: youtube.playerWidth,
			playerVars: {
				rel: 0,
				showinfo: 0
			},
			events: {
				'onReady': onYoutubeReady,
				'onStateChange': onYoutubeStateChange
			}
		});
	};

  this.loadPlayer = function () {
    if (youtube.ready && youtube.playerId) {
      if (youtube.player) {
        youtube.player.destroy();
      }
      youtube.player = service.createPlayer();
    }
  };

  this.launchPlayer = function (id, title) {
    youtube.player.loadVideoById(id);
    youtube.videoId = id;
    youtube.videoTitle = title;
    return youtube;
  }

  this.listResults = function (data) {
    results.length = 0;
    for (var i = data.items.length - 1; i >= 0; i--) {
      results.push({
        playId: data.items[i].id.videoId,
        title: data.items[i].snippet.title,
        description: data.items[i].snippet.description,
        thumbnail: data.items[i].snippet.thumbnails.default.url,
        author: data.items[i].snippet.channelTitle
      });
    }
    return results;
  }

  this.queueVideo = function (id, title, pYoutubeId) {
    upcoming.push({
      playId: id,
      title: title,
      youtubeId: pYoutubeId
    });
    return upcoming;
  };

  this.deleteVideo = function (list, id) {
    for (var i = list.length - 1; i >= 0; i--) {
      if (list[i].playId === id) {
        list.splice(i, 1);
        break;
      }
    }
  };
  
  this.deleteAll = function() {
	  upcoming.length = 0;
  };

  this.getYoutube = function () {
    return youtube;
  };

  this.getResults = function () {
    return results;
  };

  this.getUpcoming = function () {
    return upcoming;
  };
  
  this.getAlbum = function () {
	  return album;
  };
  
  this.setAlbum = function (pAlbum) {
	  album = pAlbum;
  };
  
  this.getPlayTypes = function() {
	  return playType;
  };
  
  this.getPlayType = function() {
	  return playType;
  };
  
  this.nextPlayType = function() {
	if(++typeIdx >= playTypes.length){
		typeIdx = 0;
	}
	playType = playTypes[typeIdx];
	return playType;
  };
  
}]);

// Controller

choutubeApp.controller('VideosController', function ($scope, $http, $log, VideosService, asyncHttpService) {
	$scope.query = 'you got it';
	$scope.sels = {
		selTitleIdx : -1
	};
	$scope.albumId = "";
	$scope.playType = VideosService.getPlayType();
	
	
	$scope.$on("VideosController::selTitle", function(event, idx) {
		$scope.sels.selTitleIdx = idx;
	});
	
	$scope.nextPlayType = function() {
		$scope.playType = VideosService.nextPlayType(); 
	};
	
	$scope.save = function() {
		var album = VideosService.getAlbum(); 
		console.log(VideosService.getAlbum().albumId);
		if(typeof VideosService.getAlbum().albumId == 'undefined' || VideosService.getAlbum().albumId == '') {
	    	var title = prompt("Please enter your album title", "sr-71");
	    	
	    	if(title == null) {
	    		return;
	    	}
	    	
	    	if(title !== '') {
	    		album = {
	    	    	"title" : title,
	    	    	"description" : title,
	    	    	"youtubes" : VideosService.getUpcoming()
	    	    }
	    	} else {
	    		alert('check title !');
	    		return;
	    	}
	    } else {
	    	album['youtubes'] = VideosService.getUpcoming();
	    }
		console.log("#######################");
		console.log(album);
		
		asyncHttpService.httpPostJson(window.mps.contextPath + '/album/saveAlbum', album, function(data) {
			alert("complete save");
		});
	};
	
	$scope.saveAs = function() {
		
	};
	
	$scope.recommend = function() {
		
	};
	
    $scope.launch = function (id, title, idx) {
      VideosService.launchPlayer(id, title);
      VideosService.getYoutube().playIdx = idx;
      
      $log.info('Launched id:' + id + ' and title:' + title);
    };

    $scope.queue = function (id, title) {
      VideosService.queueVideo(id, title);
      $log.info('Queued id:' + id + ' and title:' + title);
    };

    $scope.delete = function (list, id) {
      VideosService.deleteVideo($scope.upcoming, id);
    };
    
    $scope.search = function () {
    	asyncHttpService.httpGet(
    		'https://www.googleapis.com/youtube/v3/search',
    		{
    	        params: {
    	          key: 'AIzaSyCcXyPQpQ79ay56baFrmEDFTKPgUv9TSZw',
    	          //key: 'AIzaSyCx_-DPip0Gt6lXn6ixuKczI7EXAyc2tIE',
    	          type: 'video',
    	          maxResults: '20',
    	          part: 'id,snippet',
    	          fields: 'items/id,items/snippet/title,items/snippet/description,items/snippet/thumbnails/default,items/snippet/channelTitle',
    	          q: $scope.query
    	        }
    	    },
    	    function(data) {
    	    	VideosService.listResults(data);
    	        $log.info(data);
    	    }
    	);
    };
    
    $scope.bindByAlbum = function(albumId) {
    	asyncHttpService.httpPost(window.mps.contextPath + '/youtube/findYoutubesByAlbumId', {'albumId':albumId}, function(data) {
    		angular.forEach(data, function(value) {
    			VideosService.queueVideo(value.playId, value.title, value.youtubeId);
    		});
    	});
    	
    	asyncHttpService.httpPost(window.mps.contextPath + '/album/findAllAlbumsByAlbumId', {'albumId':albumId}, function(data) {
    		VideosService.setAlbum(data[0]);
    	});
    };
    
    init();

    function init() {
     	var albumId = angular.element(document.querySelector('#albumId')).val();
     	$scope.youtube = VideosService.getYoutube();
	    $scope.results = VideosService.getResults();
	    $scope.upcoming = VideosService.getUpcoming();
	    $scope.bindByAlbum(albumId);
	    $scope.search();
    }
});