var choutubeApp = angular.module('choutubeApp', []);

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
	  
	var upcoming = [
	    //{id: 'kRJuY6ZDLPo', title: 'La Roux - In for the Kill (Twelves Remix)'}
	];
  
	$window.onYouTubeIframeAPIReady = function () {
	    $log.info('Youtube API is ready');
	    youtube.ready = true;
	    service.bindPlayer('placeholder');
	    service.loadPlayer();
	    $rootScope.$apply();
	};

	function onYoutubeReady (event) {
	    $log.info('YouTube Player is ready');
	    youtube.player.cueVideoById(upcoming[0].id);
	    youtube.videoId = upcoming[0].id;
	    youtube.videoTitle = upcoming[0].title;
	}

	function onYoutubeStateChange (event) {
		console.log(upcoming.length);
	    if (event.data == YT.PlayerState.PLAYING) {
	    	youtube.state = 'playing';
	    } else if (event.data == YT.PlayerState.PAUSED) {
	    	youtube.state = 'paused';
	    } else if (event.data == YT.PlayerState.ENDED) {
		    youtube.state = 'ended';
		    nextPlay();
	    }
	    $rootScope.$apply();
	}
	
	function nextPlay() {
		if(upcoming.length <= ++youtube.playIdx) {
			youtube.playIdx = 0;
		}

		service.launchPlayer(upcoming[youtube.playIdx].id, upcoming[youtube.playIdx].title);
	    
	    $rootScope.$broadcast("VideosController::selTitle", youtube.playIdx);
	};
	
	function sufflePlay() {
		
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
        id: data.items[i].id.videoId,
        title: data.items[i].snippet.title,
        description: data.items[i].snippet.description,
        thumbnail: data.items[i].snippet.thumbnails.default.url,
        author: data.items[i].snippet.channelTitle
      });
    }
    return results;
  }

  this.queueVideo = function (id, title) {
    upcoming.push({
      id: id,
      title: title
    });
    return upcoming;
  };

  this.deleteVideo = function (list, id) {
    for (var i = list.length - 1; i >= 0; i--) {
      if (list[i].id === id) {
        list.splice(i, 1);
        break;
      }
    }
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

}]);

// Controller

choutubeApp.controller('VideosController', function ($scope, $http, $log, VideosService) {
	$scope.query = 'you got it';
	$scope.sels = {
		selTitleIdx : -1
	};
	
	$scope.$on("VideosController::selTitle", function(event, idx) {
		$scope.sels.selTitleIdx = idx;
	});
	
	$scope.save = function () {
		$log.info('getUpcoming = ');
	    $log.info(service.getUpcoming());
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
      $http.get('https://www.googleapis.com/youtube/v3/search', {
        params: {
          key: 'AIzaSyCcXyPQpQ79ay56baFrmEDFTKPgUv9TSZw',
          type: 'video',
          maxResults: '20',
          part: 'id,snippet',
          fields: 'items/id,items/snippet/title,items/snippet/description,items/snippet/thumbnails/default,items/snippet/channelTitle',
          q: $scope.query
        }
      })
      .success( function (data) {
        VideosService.listResults(data);
        $log.info(data);
      })
      .error( function () {
        $log.info('Search error');
      });
    }

    $scope.tabulate = function (state) {
      $scope.playlist = state;
    }
    
    init();

    function init() {
      $scope.youtube = VideosService.getYoutube();
      $scope.results = VideosService.getResults();
      $scope.upcoming = VideosService.getUpcoming();
      $scope.playlist = true;
      $scope.search();
    }
});