angular.module('clientApp')
.controller("GetAllClientCtrl", function($scope, clientService, $location, $rootScope ){
	// AFFICHER LA LISTE
	clientService.getAllClient( function(callBack){
		$scope.listeClients=callBack;
	});
})
.controller("ClientAjoutCtrl", function($scope, clientService, adresseService, $location ){
	$scope.client={
			nom:"",
			telP:"",
			statut:"", 
			adresse:{
				id_a:0
			}
	}
	$scope.adresse={
			num:"",
			rue:"",
			cp:"",
			ville:"",
			pays:""			
	}
	
	
	
$scope.indice=false;
$scope.addClient = function(){
	console.log("ad"+$scope.adresse);
	console.log("cl"+$scope.client);
	
	// Ajout de l'adresse dans la base de données et récupération de son ID 
	adresseService.addAdresse($scope.adresse, function(r){
		if (typeof r == "object"){
			// Ajout de l'id de la nouvelle adresse dans l'attribut du client
			$scope.client.adresse=r;
			// Ajout du client 
			clientService.clientAdd($scope.client, function (retour){
				if (typeof retour=="object"){
					// Récupération de l'id du bien 
					$location.path('findAllClient');
				} else {
					$scope.message="Impossible d'ajouter le client";
					$scope.indice=true;					
				}
			})
		}
		else {
			$scope.message = "L'adresse du bien n'a pas pu etre ajoutee !";
			$scope.indice = true;
		}
	})
}
})





.controller("rechercherClientCtrl", function($scope, clientService){
	
	$scope.id;
	$scope.indice=false;
	$scope.indice1=false;
	// Fonction appelée via le bouton
	$scope.getClientById=function(){
		// Appel de la fonction rechercher client du webservice
		clientService.getOneClient($scope.id, function(callBack){
			if (typeof callBack=="object"){
				$scope.clOut=callBack;
				$scope.indice=true;
				$scope.indice1=false;
			}
			else {
				$scope.indice=false;
				$scope.indice=true;
				$scope.message="Le client recherché n'existe pas dans la base de données";
			}
		})
	
	}

	
});



