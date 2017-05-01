Main.controller("indexController", function($scope) {
	debugger;
	//从Main模块中获取$Page,并放入$scope域
	var $Page = Main.$Page;
	var $Controller = {};
	$scope.$Page = $Page;
	$scope.$Controller = $Controller || {};
	$Page.name = "";
	$Page.sex = "";
	
	$scope.$Controller.indexController = {
			
			queryUser : function($Page){
				debugger;
				$Page.user = {
						"name" : $Page.name,
						"sex" : $Page.sex
				}
				
				$Controller.indexController.validate($Page);
				
				$Page.$http({
					method  : 'POST',
					url     : $Page.Path+'/user/queryUser',
					responseType : 'text',
					params  : {'user':$Page.user}
				}).
				success(function(date){
					debugger;
					Main.$Page.userInfo = date;
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
				if((($Page.user||{}).name == "") || (($Page.user||{}).name == null)){
					
					
				}
				
			}
	};

});
