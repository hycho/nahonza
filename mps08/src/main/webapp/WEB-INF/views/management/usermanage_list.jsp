<%@include file="/WEB-INF/views/common/common.jsp" %>

<script src="${resourcePath}/js/common.js"></script>

<aside class="right-side" ng-controller="userManageCtrl">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	    <h1>
	        User Manage List
	        <small>User List</small>
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
	                            <th>Id</th>
	                            <th>Email</th>
	                            <th>Name</th>
	                            <th>Created Date</th>
	                            <th>Use Flag</th>
	                        </tr>
	                        <tr style="cursor:pointer" ng-repeat="user in userList" ng-click="viewUserInfoDialog()">
	                            <td>{{user.id}}</td>
	                            <td>{{user.email}}</td>
	                            <td>{{user.name}}</td>
	                            <td>{{user.createdDate | date:'yyyy-MM-dd'}}</td>
	                            <td>{{user.useFlag | UseByNumber}}</td>
	                        </tr>
	                    </table>
	                </div><!-- /.box-body -->
	            </div><!-- /.box -->
	            <div class="box-footer clearfix">
                   <button class="btn btn-default btn-sm">Choutube</button>
                </div>
	        </div>
	    </div>
	</section>
</aside>