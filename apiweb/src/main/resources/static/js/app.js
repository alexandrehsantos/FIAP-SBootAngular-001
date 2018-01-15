//Modulo Principal 
var appListas = angular.module("appListas", [ 'ngRoute' ])

	.run(function($rootScope) {
		$rootScope.filter = {};
		$rootScope.$watch('filter', search, true); 
		function search(newFilter, oldFilter) {
			if (newFilter === oldFilter) return 
			console.log("Search:", newFilter);
		}
	})

	.directive('updateOnEnter', function() {
		return {
			restrict : 'A',
			require : 'ngModel',
			link : function(scope, element, attrs, ctrl) {
				element.on("keyup", function(ev) {
					if (ev.keyCode !== 13) return ev.stopImmediatePropagation();
					ctrl.$commitViewValue();
					scope.$apply(ctrl.$setTouched);
				});
			}
		}
	});
;



appListas.config(function($routeProvider, $locationProvider) {
	$routeProvider
		.when("/listas", {
			templateUrl : 'view/lista.html',
			controller : 'listaController'
		})
		.when("/home",
			{
				templateUrl : 'view/home.html',
				controller : 'homeController'
			}
	)
		.otherwise({
			redirectTo : '/home'
		});

	$locationProvider
		.html5Mode(true);
});