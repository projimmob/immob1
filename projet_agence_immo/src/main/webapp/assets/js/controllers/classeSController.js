// Création des controllers de mon application (ici pour la classe ClasseStandard)
angular.module ('classeSApp')
.controller("ClasseSListeCtrl", function($scope, classeSService, $location, $rootScope ){
	// AFFICHER LA LISTE
	classeSService.getAll( function(callBack){
		$scope.listeClasseS=callBack;
	});
	
	
	// LIEN MODIFIER
	$rootScope.csMod={
			id_cs:undefined,
			type:"",
			modeO:"",
			prixMax:"",
			supMin:""
	}
	$scope.updateCSLink=function(cs) {
		$rootScope.csMod=cs;
		$location.path('updateCS');
	}
	
	
	
})
.controller("CSsupprimCtrl", function ($scope, classeSService, $location) {

	$scope.idDel=undefined;
	$scope.indice=false;
	$scope.supprimerClasseS=function() {
		
		classeSService.supprCS($scope.idDel, function(callBack) {
		
			if(callBack=='OK') {
				$location.path('findAll');
			}
			else {
				$scope.indice=true;
				$scope.message="La suppression de la classe standard a échouée"
			}	
		})
	}
})
.controller("CSajoutCtrl", function($scope, classeSService, $location) {
	// Variable 
	$scope.classeStandard={
			type:"",
			modeO:"",
			prixMax:"",
			supMin:""
			
	};
	
	$scope.indice=false;
	
	// Fonction appelée par le bouton ajouter
	$scope.ajouterCS=function(){
		classeSService.ajoutOneCS($scope.classeStandard, function(callBack){
			if(callBack=='OK') {
				$location.path=('findAll');
			} else {
				$scope.indice=true;
				$scope.message="L'ajout de la classe standard a échoué";
			}
		})
	}
})
.controller("CSmodifCtrl", function($scope, classeSService, $location, $rootScope) {
	// Déclaration de l'attribut
	if($rootScope.csMod.id_cs==undefined) {
		$scope.classeStandard={
				id_cs:"",
				type:"",
				modeO:"",
				prixMax:"",
				supMin:""
		}
	} else {
		$scope.classeStandard=$rootScope.csMod;
		
	}
	
	$scope.indice=false;
	$scope.modifierCS=function(){
		classeSService.modifCS($scope.classeStandard, function (callBack) {
			if(callBack=='OK') {
				$location.path('findAll');
			} else {
				
				$scope.indice=true;
				$scope.message="L'ajout de la classe Standard a échoué";
			}	
		})
	}
})



.controller("ClasseSRechCtrl", function($scope, classeSService) {

	$scope.id=undefined;
	$scope.indice=false;
	$scope.indice1=false;
	
	// Fonction appelée via le boutton
	$scope.getClasseSByID=function(){
		classeSService.getOneClasse($scope.id, function(callBack) {
			if(typeof callBack=="object"){
				$scope.csOut=callBack;
				$scope.indice=true;
				$scope.indice1=false;
			}
			else {
				$scope.indice=false;
				$scope.indice1=true;
				$scope.message="L'étudiant recherché n'existe pas";
			}	
		});	
	}
});

