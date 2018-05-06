//crére les services de la visite via la methode factory :
angular.module('monApp')
.factory("vService", function($http) {
	
	var urlProj="http://localhost:8080/projet_agence_immo/";
	
	function vFindAll(busSC) {
		
		$http({      //http est ici considérée comme une méthode : permet d'envoyer la requete
			method: "GET",
			url:urlProj+"/listeVis"                       //XHR= XmlHttpRequest appelle succesCallback
		}).then(function succesCallback(reponse) {    //la variable reponce est utilisé par le XHR pour stocker la réponse du server
			
			//console.log(reponse.data);    //la liste est stockée dans data du retuurs de Http
			busSC(reponse.data);  //appel de la fonction bus SC 
			
		}, function erreurCallback(reponse) {
			
			console.log("Erreur----"+reponse.statusText);
			
		})
		
		
	}
	
	
	function vFindOne(id_v , busSC) {
		$http.get(urlProj+"/findOneVis?pId="+id_v).then(function succesCallback(reponse) {
			busSC(reponse.data)
		} , function erreurCallback(reponse) {
			
			console.log("Erreur----"+reponse.statusText);
			
		});						
	}
	
	
	function vDelete(id_v , busSC){
		$http.delete(urlProj+"/supprimerVis/"+id_v).then(function succesCallback(reponse){
			busSC(reponse.statusText)
		} , function erreurCallback(reponse){
			console.log("Erreur----"+reponse.statusText);	
		});
	}
	
	
	
	
	function vAddOne( visite , busSC)
	{
		$http({     
			method: "POST",
			url:urlProj+"/ajouterVis",			
			data:angular.toJson(visite),
			headers : {ContentType : 'application/json'}    //headers : ce qu'on envoie dans le body de la requete (param entrée) est un JSON (éq à consumes) 
		}).then(function succesCallback(reponse) {    
			busSC(reponse.statusText); 	
			
			//busSC(reponse.data);  
			
		}, function erreurCallback(reponse) {
			
			console.log("Erreur----"+reponse.statusText);
			
		})	
		
	}
	
	
	
	function vUpdOne( visite , busSC)
	{
		
	
		$http({     
			method: "PUT",
			url:urlProj+"/updateVis",			
			data:angular.toJson(visite),
			headers : {ContentType : 'application/json'}    
		}).then(function succesCallback(reponse) {    
						  
			busSC(reponse.statusText);  
			
		}, function erreurCallback(reponse) {
			
			console.log("Erreur----"+reponse.statusText);
			
		})	
	}
	
	function clAddOne(client, busSC) {
		{
			$http({     
				method: "POST",
				url:urlProj+"/client",			
				data:angular.toJson(client),
				headers : {ContentType : 'application/json'}    //headers : ce qu'on envoie dans le body de la requete (param entrée) est un JSON (éq à consumes) 
			}).then(function succesCallback(reponse) {    
				busSC(reponse.statusText); 	
				
				//busSC(reponse.data);  
				
			}, function erreurCallback(reponse) {
				
				console.log("Erreur----"+reponse.statusText);
				
			})	
			
		}
		
		
		
		
		
	}
	
	return {
	vGetAll :	vFindAll,
	vGetOne  :  vFindOne,
	vSuppr : vDelete,
	vAjoutOne : vAddOne,
	vModifOne : vUpdOne,	
	clAjoutOne:clAddOne	
		
	}
	
	
});