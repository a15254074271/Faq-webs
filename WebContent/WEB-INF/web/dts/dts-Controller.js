Main.controller("dtsController", function($scope) {
	debugger;
	//从Main模块中获取$Page,并放入$scope域
	var $Page = Main.$Page;
	var $Controller = {};
	$scope.$Page = $Page;
	$scope.$Controller = $Controller || {};


	$scope.$Controller.dtsController = {

			init : function($Page){
				$Page.dtsModul = {};
				$Page.dtsModul.dtsId = "";
				$Controller.dtsController.queryDts($Page);
			},
			addUser : function($Page){
				debugger;
				$Page.user = {
						"name" : $Page.name,
						"sex" : $Page.sex
				}

				$Controller.dtsController.validate($Page);

				$Page.$http({
					method  : 'POST',
					url     : $Page.Path+'/user/addUser',
					responseType : 'text',
					params  : {'user':$Page.user}
				}).
				success(function(date){
					debugger;
					if(date.respCode == "1"){
						$Controller.dtsController.queryDts(Main.$Page);
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
				$Controller.dtsController.validate($Page);

				$Page.$http({
					method  : 'POST',
					url     : $Page.Path+'/user/delUser',
					responseType : 'text',
					params  : {'user' : $Item}
				}).
				success(function(date){
					debugger;
					if(date.respCode == "1"){
						$Controller.dtsController.queryDts(Main.$Page);
					}else{
						alert("end!");
					}
				}).
				error(function(e){
					debugger;
				});
			},
			queryDts : function($Page){
				debugger;

				$Controller.dtsController.validate($Page);

				$Page.$http({
					method  : 'POST',
					url     : $Page.Path+'/dts/queryDts',
					responseType : 'text',
					params  : {'dtsId':$Page.dtsModul.dtsId}
				}).
				success(function(date){
					debugger;
					$Controller.dtsController.todate(date.dtsList);
					Main.$Page.dtsModul.dtsInfoList = date.dtsList;
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

			},
			todate : function(dtsList){
				debugger;
				if (dtsList == "" || dtsList == null || dtsList == []){
					return;
				}
				$.each(dtsList || [], function(i, vali){
					debugger;
					str = new Date(vali.CREATE_TIME.time).format("yyyy-MM-dd hh:mm:ss");
					vali.CREATE_TIME = str;
				});
			}
	};

});
