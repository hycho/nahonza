<script>
  if (typeof angular == 'undefined')
     window.location.replace("/mps");
</script>

<aside class="right-side" ng-controller="albumListCtrl">
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
	                    <!--
	                    <div class="box-tools">
	                        <div class="input-group">
	                            <input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
	                            <div class="input-group-btn">
	                                <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
	                            </div>
	                        </div>
	                    </div>
	                    -->
	                </div><!-- /.box-header -->
	                <div class="box-body table-responsive no-padding">
	                    <table class="table table-hover">
	                        <tr>
	                            <th>Id</th>
	                            <th>Title</th>
	                            <th>Description</th>
	                            <th>Action</th>
	                        </tr>
	                        <tr style="cursor:pointer">
	                            <td>183</td>
	                            <td>John Doe</td>
	                            <td>11-7-2014</td>
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