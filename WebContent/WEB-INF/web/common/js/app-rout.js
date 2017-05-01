Main.config(['$routeProvider', function($routeProvider){
	debugger;
	//加载路由 
	$.ajax({
        type: "POST",
        url: "/faq-webs/menu/queryMenu",
        data: {'menu': {}},
        async: false,
        dataType: "json",
        success: function(data){
        	debugger;
        	Main.$Page.menuList = data.menuList;
            $.each(data.menuList,function(i,menu){
            	$routeProvider.when(menu.MENU_LOGIC_PATH,{templateUrl:menu.MENU_PHYSICS_PATH,controller:menu.CONTROLLER_NAME});
            	
            });
            $routeProvider.otherwise({redirectTo:'/home'});
       }
    });
}]);