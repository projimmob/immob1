
var restUrl="http://localhost:8080/projet_agence_immo";


angular.module('gestionProprio')
.factory("prService", function($http) {
	
	
	function proprioFindAll(busSC){              
		$http({      
			method: "GET",
			url:restUrl+"/listePr"                     
		}).then(function succesCallback(reponse) {   
			
			busSC(reponse.data);  
			
		}, function erreurCallback(reponse) {
			
			console.log("Erreur----"+reponse.statusText);
			
		})
		
	}
	
	function proprioFindOne(id , busSC) {
		$http.get(restUrl+"/prop/?pId="+id).then(function succesCallback(reponse) {
			busSC(reponse.data)
		} , function erreurCallback(reponse) {
			
			console.log("Erreur----"+reponse.statusText);
			
		});						
	}
	
	
	function proprioDelete(id , busSC){
		$http.delete(restUrl+"/prop/"+id).then(function succesCallback(reponse){
			busSC(reponse.statusText)
		} , function erreurCallback(reponse){
			console.log("Erreur----"+reponse.statusText);	
		});
	}
	
	
	function proprioAdd( proprietaire , busSC)
	{
		$http({     
			method: "POST",
			url:restUrl+"/prop",			
			data:angular.toJson(proprietaire),
		             
			headers : {ContentType : 'application/json'}    
		}).then(function succesCallback(reponse) {    
			busSC(reponse.data); 	
			
			//busSC(reponse.data);  
			
		}, function erreurCallback(reponse) {
			
			console.log("Erreur----"+reponse.statusText);
			
		})	
		
	}
	
	
	
	function propUpd( proprietaire , busSC)
	{
		
	
		$http({     
			method: "PUT",
			url:restUrl+"/prop",			
			data:angular.toJson(proprietaire),
		  //data : JSON.stringify(etudiant),  (équivalent à la ligne précédente)           //data : on envoie dans le body de la requete  |   params : dans l'uri
			headers : {ContentType : 'application/json'}    //headers : ce qu'on envoie dans le body de la requete (param entrée) est un JSON (éq à consumes) 
		}).then(function succesCallback(reponse) {    
						  
			busSC(reponse.statusText);  
			
		}, function erreurCallback(reponse) {
			
			console.log("Erreur----"+reponse.statusText);
			
		})	
	}
	
	
/*	function proprioFindName(nom , busSC) {
		$http.get(restUrl+"/propName/"+nom).then(function succesCallback(reponse) {
			busSC(reponse.data)
		} , function erreurCallback(reponse) {
			
			console.log("Erreur----"+reponse.statusText);
			
		});						
	}
*/	
	
	
	return{
		proprioGetAll : proprioFindAll,
		proprioGetOne : proprioFindOne,
		supprProprio : proprioDelete,
		ajoutProprio : proprioAdd,
		modifierProprio : propUpd,
		//rechercherProprioNom : proprioFindName
		
	}
	
})
.factory("biServ", function($http)
{
	function bienDelete(id_b , busSC){
		$http.delete(restUrl+"/bien/"+id_b).then(function succesCallback(reponse){
			busSC(reponse.statusText)
		} , function erreurCallback(reponse){
			console.log("Erreur----"+reponse.statusText);	
		});
	}	
	
return   {
	
	supprBien : bienDelete
	
}

})
.factory("adrServ", function($http)
		{
	
	function adresseAdd( adresse , busSC)
	{
		$http({     
			method: "POST",
			url:restUrl+"/adresse",			
			data:angular.toJson(adresse),
		  //data : JSON.stringify(etudiant),  (équivalent à la ligne précédente)           //data : on envoie dans le body de la requete  |   params : dans l'uri
			headers : {ContentType : 'application/json'}    //headers : ce qu'on envoie dans le body de la requete (param entrée) est un JSON (éq à consumes) 
		}).then(function succesCallback(reponse) {    
			busSC(reponse.data); 	
			
			//busSC(reponse.data);  
			
		}, function erreurCallback(reponse) {
			
			console.log("Erreur----"+reponse.statusText);
			
		})	
		
	}
	
	
	
			function  adresseDelete(id_a , busSC){
				$http.delete(restUrl+"/adresse/"+id_a).then(function succesCallback(reponse){
					busSC(reponse.data)
				} , function erreurCallback(reponse){
					console.log("Erreur----"+reponse.statusText);	
				});
			}	
			
		return   {
			
			supprAdresse : adresseDelete,
			 ajoutAdresse : adresseAdd
			
		}

		});

