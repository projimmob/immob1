// declaration module d'authentification
// ng-cookies permet le stockage des infos dans une session

angular.module('Authentication', []);
angular.module('gestionBiens', []);
angular.module('clientApp', []);
angular.module('classeSApp', []);
angular.module('gestionProprio',[]);
// crea module général
angular
		.module(
				'monApp',
				[ 'gestionProprio','classeSApp','clientApp','Authentication', 'gestionBiens', 'ngRoute', 'ngCookies',
						'naif.base64' ])

		.config([ '$routeProvider', function($routeProvider) {

			$routeProvider.when('/existCons', {
				controller : 'LoginController',
				templateUrl : 'views/login.html',
				hideMenus : true
			})
			  .when('/', {
            controller: 'tabCTRL',
            templateUrl: 'views/ConsTabord.html'
        })
	
			.otherwise({
				redirectTo : '/existCons'
			});
		} ])

		.run(
				[
						'$rootScope',
						'$location',
						'$cookieStore',
						'$http',
						function($rootScope, $location, $cookieStore, $http) {
							// keep user logged in after page refresh
							$rootScope.globals = $cookieStore.get('globals')
									|| {};
							if ($rootScope.globals.currentUser) {
								$http.defaults.headers.common['Authorization'] = 'Basic '
										+ $rootScope.globals.currentUser.authdata; // jshint
																					// ignore:line
							}

							$rootScope.$on('$locationChangeStart', function(
									event, next, current) {
								// redirect to login page if not logged in
								if ($location.path() !== '/existCons'
										&& !$rootScope.globals.currentUser) {
									$location.path('/existCons');
								}
							});
						} ]);
