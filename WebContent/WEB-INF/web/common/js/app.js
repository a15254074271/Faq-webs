debugger;
var Main = angular.module("Main",['ngRoute'])

Main.$Page = {};

Main.controller("MainController", function($scope,$http) {
	debugger;
	var Path = "/faq-webs";
	var $Page = Main.$Page || {};
	$Page.Path = Path;
	$Page.$http = $http;
	$Page.$Scope = $scope;
	$Page.$Controller = $Page.$Controller || {};
	$scope.$Page = $Page;
});

