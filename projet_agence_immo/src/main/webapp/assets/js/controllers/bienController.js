/**
 * Creation des controllers de l'application
 */
angular.module('gestionBiens')
.controller("bienAjoutCtrl", function($scope,bienServ,$location,adresseServ,locaServ,achServ,clasServ) {
	$scope.bien = {
			statut : "Disponible",
			type : "",
			dateS : new Date(),
			dateD : "",
			revC : 0.0,
			prix : 0.0,
			dateE : "",
			photo : "",
			proprio : {
				id_p : 0
			},
			adresse : {
				id_a : 0
			},
			classeS : {
				id_cs : 0
			}
	}
	$scope.adr = {
			num : "",
			rue : "",
			cp : "",
			ville : "",
			pays : ""
	}
	$scope.loc = {
			loyer : 0,
			caution : 0,
			charges : 0,
			bail : "",
			meuble : false,
			bien : {
				id_b : 0
			}
			
	}
	$scope.ach = {
			prix : 0,
			etat : "",
			bien : {
				id_b : 0
			}
	}
	clasServ.clasGet(function(ret) {
		$scope.classes = ret;
	});
	$scope.genre = "";
	$scope.indice = false;
	// Ajout de l'adresse du bien puis du bien lui-même avec la bonne adresse
	// Puis ajout de la location ou de l'achat a partir du bien
	$scope.addBien = function() {
		
		// Ajout de l'adresse dans la BDD et recuperation de son ID
		adresseServ.adAdd($scope.adr, function(r) {
			
			if(typeof r == "object"){
				
				// ajout de l'ID de la nouvelle adresse dans l'attribut du bien
				$scope.bien.adresse = r;
				
				// ajout du bien
				bienServ.bienAdd($scope.bien, function(retour) {
					if(typeof retour == "object"){
						// recuperation de l'ID du bien
						if($scope.genre === 'location'){
							$scope.loc.bien = retour;
							// ajout de la location
							locaServ.locAdd($scope.loc, function(resp){
								if(typeof resp == "object"){
									$location.path('biensAll');
									$scope.indice = false;
								}
								else{
									$scope.msg = "La location n'a pas pu etre ajoutee !";
									$scope.indice = true;
								}
							})
						}
						else if($scope.genre === 'achat'){
							$scope.ach.bien = retour;
							// ajout de l'achat
							achServ.achAdd($scope.ach, function(re) {
								if(typeof re == "object"){
									$location.path('biensAll');
									$scope.indice = false;
								}
								else{
									$scope.msg = "L'achat n'a pas pu etre ajoute !";
									$scope.indice = true;
								}
							})
						}
						else{
							$scope.msg = "Le genre du bien n'a pas ete reconnu !";
							$scope.indice = true;
						}
						
						
					}
					else{
						$scope.msg = "Le bien n'a pas pu etre ajoute !";
						$scope.indice = true;
					}
				})
			}
			else{
				$scope.msg = "L'adresse du bien n'a pas pu etre ajoutee !";
				$scope.indice = true;
			}
		})
		
		 
		
	}
})

.controller("biensListeCtrl", function($scope,bienServ,adresseServ) {
	$scope.indice=false;
	bienServ.bienAffich(function(retour) {
		if(typeof retour == "object"){
			$scope.listeBiens =  retour;
			$scope.indice=false;
		}
		else{
			$scope.msg = "Les biens ne peuvent pas etre affiches !";
			$scope.indice = true;
		}
		
	})

})

.controller("biensListeFilterCtrl", function($scope,bienServ,adresseServ,locaServ,achServ,clasServ) {
	$scope.indice=false;
	$scope.genre = "";
	$scope.i_loc = false;
	$scope.i_ach = false;
	$scope.afficher = function() {
		
		if($scope.genre === "location"){
			locaServ.locAll(function(retour) {
				if(typeof retour == "object"){
					
					$scope.listeLocations = retour;
					$scope.i_loc = true;
					$scope.i_ach = false;
				}
				else{
					$scope.msg = "Les locations ne peuvent pas etre affiches !";
					$scope.indice = true;
				}
				
			});
			
		}
		else if($scope.genre === "achat"){
			achServ.achAll(function(retour) {
				if(typeof retour == "object"){
					
					$scope.listeAchats = retour;
					$scope.i_loc = false;
					$scope.i_ach = true;
				}
				else{
					$scope.msg = "Les achats ne peuvent pas etre affiches !";
					$scope.indice = true;
				}
				
			});
		}
		else {
			$scope.msg = "Le genre de bien n'est pas selectionne !";
			$scope.indice = true;
		}
	
	}
	
});