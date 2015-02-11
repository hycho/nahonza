<%@include file="/WEB-INF/views/common/common.jsp" %>

<script src="${resourcePath}/js/common.js"></script>

<aside class="right-side" ng-controller="albumListCtrl">
<%=name %>
	<!-- Content Header (Page header) -->
	<section class="content-header">
	    <h1>
	        Album List
	        <small>Album List</small>
	    </h1>
	    <ol class="breadcrumb">
	        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
	        <li><a href="#">Album</a></li>
	    </ol>
	</section>
	
	<section class="content">
	    <div class="row">
	        <div class="col-xs-12">
	            <div class="box">
	                <div class="box-header">
	                    <h3 class="box-title">Click to Album List</h3>
	                </div>
	                <div class="box-body table-responsive no-padding">
	                    <table class="table table-hover">
	                        <tr>
	                            <th>Title</th>
	                            <th>Description</th>
	                            <th>Action</th>
	                        </tr>
	                        <tr style="cursor:pointer" ng-repeat="album in albumService.albumList" ng-click="clickAlbum(album);">
	                            <td>{{album.title}}</td>
	                            <td>{{album.description}}</td>
	                            <td>
	                            	<span class="label label-primary">Play</span>
	                            	<span class="label label-danger">Stop</span>
	                            </td>
	                        </tr>
	                    </table>
	                </div><!-- /.box-body -->
	            </div><!-- /.box -->
	            <div class="box-footer clearfix">
                   <button class="btn btn-default btn-sm" ng-click="moveChoutube()">Move Choutube</button>
                </div>
	        </div>
	    </div>
	</section>
</aside>