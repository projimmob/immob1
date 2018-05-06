angular.module('gestionProprio')
.controller("proprietaireListeCtrl", function($scope,prService , $location , $rootScope) {
	//AFICHER LA LISTE	
	prService.proprioGetAll(  function (callBack){    
		$scope.listeProprietaires = callBack ;      
	});	
	
	
	
$scope.deleteLink=function(id){  //methode du controller
		
		prService.supprProprio(id,function(callBack)  //appel de la fonction supprimer de service
				{
			if(callBack=='OK')
			{
				prService.proprioGetAll(  function (callBack){    
					$scope.listeProprietaire= callBack ;     
				})
			}
		else {

			 $scope.message="La suppression du proprietaire a échouée";
		}		 	
				}) 				
	}



//Lien pour modifier :
$rootScope.prMod={
    id_p: undefined,
	nom: "",
	telP: "",
	telT: "",
	adresse: {
		id_a: "",
			num : "",
			rue : "",
			cp : "",
			ville : "",
			pays : ""
	}
}

$scope.updateLink=function(pr)
{
	$rootScope.prMod=pr;
	   $location.path('proprietaireUpdate');

}



	
})


.controller("proprietaireAjoutCtrl", function($scope, prService, $location,adrServ) {
	//variable :	
	$scope.proprietaire={
			nom : "",
			telP : "",
			telT : "",
			adresse : {
				id_a : 0
				/*num : "",
				rue : "",
				cp : "",
				ville : "",
				pays : ""*/
			}	
	}
	
	$scope.adr = {
			num : "",
			rue : "",
			cp : "",
			ville : "",
			pays : ""
	}
	
	$scope.indice=false;
	
	//ajout de l'adresse du proprietaire puis du proprietaire lui-même:

	

	//fonction appelée par le bouton ajouter :
	$scope.ajouterProprietaire=function(){
		
		adrServ.ajoutAdresse($scope.adr,function(r){
			console.log("ad"+$scope.adr);

			
		if(typeof r == "object")
		{	
			$scope.proprietaire.adresse=r;
			
			
		prService.ajoutProprio($scope.proprietaire , function(result){   //qd il reçoit la rép il effectue ce qu'il y a dans cette fonction 
			
			if(typeof result=='object')
			{
			   $location.path('proprietaireFindAll');
			}
		else {
			$scope.indice=true;

			 $scope.message="L'ajout du proprietaire a échouée";
		}
					
		})
	
		
		}
		
		else
			{
			$scope.indice=true;

			 $scope.message="L'ajout de l'adresse a échouée";
			
			}
		})
	}
	
	
				
})
.controller("proprietaireModifCtrl", function($scope,prService,$location,$rootScope) {
  
	if($rootScope.prMod.id_p == undefined)  //si l'id est null le formulaire est vide
	{
	
	$scope.proprietaire={
	
	        id_p : "",
			nom : "",
			telP : "",
			telT : "",
			adresse : {
				id_a : "",
				num : "",
				rue : "",
				cp : "",
				ville : "",
				pays : ""
			}
	}
	}
	else
		{
		$scope.proprietaire=$rootScope.prMod;
		}
	
	$scope.indice=false;

	
	//fonction d'appel de modif :
	$scope.modifierProprietaire=function(){
		
		prService.modifierProprio($scope.proprietaire,function(callBack){
		
			if(callBack=='OK')
			{
			   $location.path('proprietaireFindAll');
			}
		else {
			$scope.indice=true;

			 $scope.message="La modif de l'etudiant a échouée";
		}	
			
			
		})		
		
	}
	
})
	
.controller("proprietaireSupprimCtrl", function($scope,prService,$location,biServ,adrServ) {
	
	$scope.idDel=undefined;     //nom de l'id qui est dans le ng-model
	$scope.indice=false;
	$scope.indice1=false;
	$scope.indice2=false;
	$scope.idB=undefined;
	$scope.id=undefined;
	
	$scope.supprimerProprietaire=function(){
		
		
		/*biServ.supprBien($scope.idB, function(callback)
		{
		
			if(calLBack='OK')
				{*/
		prService.supprProprio($scope.idDel, function(callback){
			
			
			
			
			if(callback=='Ok')
			{
		
				biServ.supprBien($scope.idB, function(calLBack)
		{
		
			if(calLBack='OK')
				{
				
		adrServ.supprAdresse($scope.id, function(callBack) {
			
			
				
				
			
			if(callBack=='OK')
				{
				   $location.path('proprietaireFindAll');
				}
			else {
				$scope.indice=true;

				 $scope.message="La suppression de l'etudiant a échouée";
			}
			
			
				
		})
		
			}
			
			else {
				$scope.indice1=true;

				 $scope.message="La suppression de l'etudiant a échouée";
			}
		
			
	})
}
			else
			{
			$scope.indice2=true;

			 $scope.message="La suppression de l'etudiant a échouée";
			}
		
		})
				}
			/*else
				{
				$scope.indice2=true;

				 $scope.message="La suppression de l'etudiant a échouée";
				}
		})
	}*/
	
})
	.controller("proprietaireRechercheCtrl", function($scope, prService) {
		 
		$scope.id=undefined;
		$scope.indice=false;
		$scope.indice1=false;

		// fonction appelée via le boutton 
		$scope.rechercherProprioParId=function(){
			//appel de la fonction getOne du service
			prService.proprioGetOne($scope.id, function(callBack) {
				 if(typeof callBack=="object"){
					 $scope.prOut=callBack;
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
	
	
})
/*.controller("proprietaireParNomCtrl", function($scope, prService) {
	
	$scope.proprietaire={
			
	        id_p : "",
			nom : undefined,
			telP : "",
			telT : "",
			adresse : {
				id_a : ""
			}
	}
	
	
		 
		//$scope.nom=undefined;
		$scope.indice=false;
		$scope.indice1=false;

		// fonction appelée via le boutton 
		$scope.rechercherProprioParNom=function(){
			//appel de la fonction getOne du service
			prService.rechercherProprioNom($scope.propietaire.nom, function(callBack) {
				 if(typeof callBack=="object"){
					 $scope.prOut=callBack;
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
	
	
})*/
