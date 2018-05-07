//Création des controllers de mon application
angular.module('monApp')
.controller("listeCtrl",
		function($scope, cService, $location, $rootScope) {
			cService.getAll(function(callBack) {
				$scope.ListeCons = callBack;
			});

			$scope.deleteLien = function(id) {
				// Appel de la fonction findOne du service
				cService.deleteCons(id, function(callBack) {
					if (callBack == 'OK') {
						cService.getAll(function(callBack) {
							$scope.ListeCons = callBack;
						});
					} else {
						$scope.message = "La suppression a échoué."
					}
				});
			}

			$rootScope.modifCons={
					id:undefined
			}
			$scope.modifierLien = function(conseiller) {
				$rootScope.modifCons = conseiller;
				$location.path('consUpdate');
			}
		})
		.controller("ajoutCtrl", function($scope, cService, $location) {
	$scope.cAjout = {
		mail : "",
		psw : "",
		
	}
	// Fonction appelée via le bouton
	$scope.ajouter = function() {
		// Appel de la fonction findOne du service
		cService.addCons($scope.cAjout, function(callBack) {
			if (callBack == 'OK') {
				$location.path('consAll');
			} else {
				$scope.message = "Ajout échoué"
			}
		})
	}
})
.controller("modifCtrl", function($scope, $rootScope, cService, $location) {

	if($rootScope.modifCons.id_co==undefined){
		$scope.cModif={
				id_co:"",
				mail : "",
				password: "",
				}
	}else{
		$scope.cModif=$rootScope.modifCons;
	}	
	
	// Fonction appelée via le bouton
	$scope.modifier = function() {
		// Appel de la fonction findOne du service
		cService.updateCons($scope.cModif, function(callBack) {
			if (callBack == 'OK') {
				$location.path('consAll');
			} else {
				$scope.message = "Modif échoué"
			}
		});
	}
}).controller("supprimCtrl", function($scope, cService, $location) {
	$scope.idDel = undefined;
	$scope.indice = false;
	// Fonction appelée via le bouton
	$scope.deleteID = function() {
		// Appel de la fonction findOne du service
		cService.deleteCons($scope.idDel, function(callBack) {
			if (callBack == 'OK') {
				$location.path('consAll');
			} else {
				$scope.message = "La suppression a échoué."
			}
		});
	}
}).controller("chercheCtrl", function($scope, cService) {

	$scope.id = undefined;
	$scope.indice = false;
	$scope.indice1 = false;
	// Fonction appelée via le bouton
	$scope.rechercherParId = function() {
		// Appel de la fonction findOne du service
		cService.getById($scope.id, function(callBack) {
			if (typeof callBack == "object") {
				$scope.cOut = callBack;
				$scope.indice = true;
				$scope.indice1 = false;
			} else {
				$scope.message = "Aucun conseiller trouve avec cet ID"
				$scope.indice = false;
				$scope.indice1 = true;
			}
		});
	}

}).controller("adminCtrl",function($scope,$location){
	$scope.psw;
	$scope.i=false;
	$scope.submitAdmin = function() {
		if($scope.psw === "admin"){
			$scope.i=false;
			$location.path("ConsListe");
		}
		else{
			$scope.msg = "Le mot de passe administrateur est incorrect !!";
			$scope.i = true;
		}
	}
});