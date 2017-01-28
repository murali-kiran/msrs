var taskManagerModule = angular.module('msrsHomeApp', ['ui.bootstrap', 'ngResource']);

taskManagerModule.controller('msrsHomeController', function ($scope,$http) {
	
	$scope.predicate = 'empid';  
	$scope.reverse = false;  
	$scope.currentPage = 1;  
	$scope.order = function (predicate) {  
	  $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;  
	  $scope.predicate = predicate;  
	};
	
	$http.defaults.headers.post["Content-Type"] = "application/json";
	function findAllEmps() {
		$http.get('/rest/all').success(function (data) {
			$scope.emps = data;
			$scope.totalItems = data.length;  
		});
	}
    $scope.numPerPage = 5;  
    $scope.paginate = function (value) {  
      var begin, end, index;  
      begin = ($scope.currentPage - 1) * $scope.numPerPage;  
      end = begin + $scope.numPerPage;  
      index = $scope.emps.indexOf(value);  
      return (begin <= index && index < end);  
    };
	findAllEmps();
});
