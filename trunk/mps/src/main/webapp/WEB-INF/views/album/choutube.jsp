<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="resourcePath" value="${pageContext.request.contextPath}/resources" />

<html data-ng-app="choutubeApp">
<head>
<meta charset="utf-8">
<title>ChouTube</title>
<meta name="author" content="J. Thomas">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${resourcePath}/css/album/choutube.css" type="text/css">
<link rel="icon" href="/favicon.ico">
</head>
<body data-ng-controller="VideosController">
	<header>
		<h1>
			Chou<strong>Tube</strong>
		</h1>
		<form id="search" data-ng-submit="search()">
			<input id="query" name="q" type="text" placeholder="Search for a YouTube video" data-ng-model="query">
			<input id="submit" type="image" src="${resourcePath}/img/search.png" alt="Search">
		</form>
		<nav>
			<a id="play">{{ youtube.state }}</a> <a id="pause">Pause</a>
		</nav>
	</header>
	<div id="results">
		<div class="video" data-ng-repeat="video in results"
			data-ng-click="queue(video.id, video.title)">
			<img class="video-image" data-ng-src="{{ video.thumbnail }}">
			<p class="video-title">{{ video.title }}</p>
			<p class="video-author">{{ video.author }}</p>
			<p class="video-description">{{ video.description }}</p>
		</div>
	</div>
	<div id="player">
		<div id="placeholder"></div>
	</div>
	<div id="playlist">
		<p id="current">{{ youtube.videoTitle }}</p>
		<ol id="upcoming">
			<li data-ng-repeat="video in upcoming">
				<p class="item-delete" data-ng-click="delete('upcoming', video.id)">delete</p>
				<p class="item-title" ng-class="{'selected': $index==sels.selTitleIdx}" data-ng-click="launch(video.id, video.title, $index); sels.selTitleIdx = $index">{{video.title}}</p>
			</li>
		</ol>
		<p id="tabs">
			<a class="green" data-ng-click="save()">Save</a>
			<a class="blue" data-ng-click="recommend()">Recommend</a>
		</p>
	</div>
	<script src="${resourcePath}/js/plugins/angularjs/angular.min-1.3.8.js"></script>
	<script src="${resourcePath}/js/album/choutube.js"></script>
</body>
</html>