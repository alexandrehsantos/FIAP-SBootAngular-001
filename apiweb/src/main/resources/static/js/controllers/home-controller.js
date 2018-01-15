appListas.controller("homeController", function($scope, $http) {
	
	$scope.lista = {};
	$scope.listas = [];

	carregarItens = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/listas'
		})
			.then(function(response) {
				$scope.listas = response.data;
				console.log(response.data);
				console.log(response.status);
			}, function(response) {
				console.log(response.data);
				console.log(response.status);
			});
	};

	carregarItens();
	
	
} )