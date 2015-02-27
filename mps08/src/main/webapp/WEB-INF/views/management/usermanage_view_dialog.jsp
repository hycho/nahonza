<%@include file="/WEB-INF/views/common/common.jsp" %>

<script src="${resourcePath}/js/common.js"></script>

<body class="bg-black">
	<div class="form-box-popup" id="login-box">
    	<div class="header">User Info</div>
   		<div class="body">
   			<div class="form-group">
              <input type="text" class="form-control" id="inputSuccess" placeholder="User ID">
            </div>
       		<div class="form-group">
           		<input type="text"  class="form-control" placeholder="User Name"/>
       		</div>
       		<div class="form-group">
           		<input type="password" class="form-control" placeholder="Password"/>
       		</div>
       		<div class="form-group">
           		<input type="text" class="form-control" placeholder="User Email"/>
       		</div>
       		<div class="form-group">
           		<select class="form-control">
           			<option>Use</option>
           			<option>Not Use</option>
           		</select>
       		</div>
       		<div class="form-group" style="height:100px; overflow-y:scroller">
		    	<div class="checkbox">
                	<label>
                    	<input type="checkbox">	Checkbox 1
                    </label>
            	</div>
            	<div class="checkbox">
                	<label>
                    	<input type="checkbox">	Checkbox 1
                    </label>
            	</div>
            	<div class="checkbox">
                	<label>
                    	<input type="checkbox">	Checkbox 1
                    </label>
            	</div>
            	<div class="checkbox">
                	<label>
                    	<input type="checkbox">	Checkbox 1
                    </label>
            	</div>
            	<div class="checkbox">
                	<label>
                    	<input type="checkbox">	Checkbox 1
                    </label>
            	</div>
            	<div class="checkbox">
                	<label>
                    	<input type="checkbox">	Checkbox 1
                    </label>
            	</div>
            	<div class="checkbox">
                	<label>
                    	<input type="checkbox">	Checkbox 1
                    </label>
            	</div>
            	<div class="checkbox">
                	<label>
                    	<input type="checkbox">	Checkbox 1
                    </label>
            	</div>
    		</div>
   		</div>
	   	<div class="footer">
	       <button class="btn bg-olive btn-block">Save</button>
	       <button class="btn bg-olive btn-block" ng-click="closeThisDialog()">Exit</button>
	   	</div>
    </div>
</body>