appListas.controller("listaController", function($scope, $http) {

	$scope.item = {};
	$scope.lista = {};
	$scope.listas = [];
	$scope.itens = [];

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

	$scope.removerItem = function(lista, item) {

		index = lista.itens.indexOf(item);
		lista.itens.splice(index, 1);

		$scope.alterarLista(lista);
		$scope.salvarLista();
		$scope.item = {};


	}



	$scope.salvarItem = function(lista) {

		lista.itens.push($scope.item);
		$scope.alterarLista(lista);
		$scope.salvarLista();
		$scope.item = {};
	}

	$scope.salvarLista = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/listas',
			data : $scope.lista
		})
			.then(function(response) {
				//				$scope.listas.push(response.data);
				carregarItens();
				$scope.lista = {};

				console.log(response.data);
				console.log(response.status);
			}, function(response) {
				console.log(response.data);
				console.log(response.status);
			});
	};

	$scope.excluirLista = function(item) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/listas/' + item.id
		})
			.then(function(response) {
				index = $scope.listas.indexOf(item);
				$scope.listas.splice(index, 1);

				console.log(response.status);
			}, function(response) {
				console.log(response.data);
				console.log(response.status);
			});
	};

	$scope.alterarLista = function(lista) {

		$scope.lista = angular.copy(lista);


	}

	$scope.cancelarAlteracaoLista = function() {
		carregarItens();
		$scope.lista = {};
	};



});