Main.controller("userController", function($scope) {
	debugger;
	//从Main模块中获取$Page,并放入$scope域
	var $Page = Main.$Page;
	var $Controller = {};
	$scope.$Page = $Page;
	$scope.$Controller = $Controller || {};
	
	
	$scope.$Controller.userController = {
			
			init : function($Page){
				$Page.name = "";
				$Page.sex = "";
				$Page.searchname = "";
				$Page.searchsex = "";
				$Controller.userController.queryUser($Page);
			},
			addUser : function($Page){
				debugger;
				$Page.user = {
						"name" : $Page.name,
						"sex" : $Page.sex
				}
				
				$Controller.userController.validate($Page);
				
				$Page.$http({
					method  : 'POST',
					url     : $Page.Path+'/user/addUser',
					responseType : 'text',
					params  : {'user':$Page.user}
				}).
				success(function(date){
					debugger;
					if(date.respCode == "1"){
						$Controller.userController.queryUser(Main.$Page);
					}else{
						alert("end!");
					}
				}).
				error(function(e){
					debugger;
				});
			},
			delUser : function($Item){
				debugger;
				$Controller.userController.validate($Page);
				
				$Page.$http({
					method  : 'POST',
					url     : $Page.Path+'/user/delUser',
					responseType : 'text',
					params  : {'user' : $Item}
				}).
				success(function(date){
					debugger;
					if(date.respCode == "1"){
						$Controller.userController.queryUser(Main.$Page);
					}else{
						alert("end!");
					}
				}).
				error(function(e){
					debugger;
				});
			},
			queryUser : function($Page){
				debugger;
				$Page.user = {
						"name" : $Page.searchname,
						"sex" : $Page.searchsex
				}
				
				$Controller.userController.validate($Page);
				
				$Page.$http({
					method  : 'POST',
					url     : $Page.Path+'/user/queryUser',
					responseType : 'text',
					params  : {'user':$Page.user}
				}).
				success(function(date){
					debugger;
					Main.$Page.userInfo = date.body.userList;
				}).
				error(function(e){
					debugger;
				});
			},
			/**
			 * 校验
			 */
			validate : function($Page){
				debugger;
				
			}
	};

});
