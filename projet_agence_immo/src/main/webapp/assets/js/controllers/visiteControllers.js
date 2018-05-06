// créer le controlelr de la visite :
angular.module('monApp')
.controller("visiteListeCtrl", function($scope,vService,$location,$rootScope)
		{
	
	//affichage de la liste :
	vService.vGetAll(function(callBack) {
		
	$scope.listeVisites = callBack;
	
	
	})
		})
		
	
	.controller("visiteAjoutCtrl", function($scope, vService, $location) {
	//variable :	
	$scope.visite={
			date : "",
			heure : "",
			bien : {
				id_b:""
			},
			conseiller : {
				id_co:""
			},
			client : {
				id_cl : ""
			}
	};
	
	$scope.indice=false;


	//fonction appelée par le bouton ajouter :
	$scope.ajouterVisite=function(){
		
		vService.vAjoutOne($scope.visite , function(callBack){   //qd il reçoit la rép il effectue ce qu'il y a dans cette fonction 
			
			if(callBack=='OK')
			{
			   $location.path('visiteFindAll');
			}
		else {
			$scope.indice=true;

			 $scope.message="L'ajout de l'etudiant a échouée";
		}
					
		})
				
	}
				
})
.controller("visiteModifCtrl", function($scope,vService,$location,$rootScope) {
  //déclaration de l'attribut :
		
	$scope.visite={
			id_v : "",
			date : "",
			heure: "", 
			bien : {
				id_b:""
			},
			conseiller : {
				id_co:""
			},
			client : {
				id_cl : ""
			}
	
		}
	
	
	$scope.indice=false;

	
	//fonction d'appel de modif :
	$scope.modifierVisite=function(){
		
		vService.vModifOne($scope.visite,function(callBack){
		
			if(callBack=='OK')
			{
			   $location.path('visiteFindAll');
			}
		else {
			$scope.indice=true;

			 $scope.message="La modif de l'etudiant a échouée";
		}	
			
			
		})		
		
	}
	

})
.controller("visiteSupprimCtrl", function($scope,vService,$location) {
	//$scope.msg="je suis dans la vue suppression";	
	
	$scope.idDel=undefined;     //nom de l'id qui est dans le ng-model
	$scope.indice=false;

	
	$scope.supprimerVisite=function(){
		
		vService.vSuppr($scope.idDel, function(callBack) {
			
			if(callBack=='OK')
				{
				   $location.path('visiteFindAll');
				}
			else {
				$scope.indice=true;

				 $scope.message="La suppression de l'etudiant a échouée";
			}
			
		})
		
		
	}
	
})
.controller("AjoutClientCtrl", function ($scope, vService, $location) {
	

	//variable :	
	$scope.client={
			nom:"",
			prenom :"",
			statut : ""

	};
	
	$scope.indice=false;


	//fonction appelée par le bouton ajouter :
	$scope.ajouterClient=function(){
		
		vService.clAjoutOne($scope.client , function(callBack){   //qd il reçoit la rép il effectue ce qu'il y a dans cette fonction 
			
			if(callBack=='OK')
			{
			   $location.path('clientFindAll');
			}
		else {
			$scope.indice=true;

			 $scope.message="L'ajout du client a échoué";
		}
					
		})
				
	}
				
})
.controller("visiteRechercheCtrl", function($scope, vService) {
 
$scope.id_v=undefined;
$scope.indice=false;
$scope.indice1=false;

// fonction appelée via le boutton 
$scope.rechercherVisiteParId=function(){
	//appel de la fonction getOne du service
	vService.vGetOne($scope.id_v, function(callBack) {
		 if(typeof callBack=="object"){
			 $scope.vOut=callBack;
			 $scope.indice=true;
			 $scope.indice1=false;

		 }
		 else{
			 $scope.indice=false;
			 $scope.indice1=true;

			 $scope.message="L'etudiant rechercher n'existe pas";
		 }
		   
	});	
}	
	
	
		});

