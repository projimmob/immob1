// Création des services de la classe Standard pour récupérer les données du WebService

angular.module('classeSApp')
.factory("classeSService", function($http){
	
	var restURL="http://localhost:8080/Projet_immo_Marianne";
	
	function findAll(busSC){
		$http({
			method:"GET",
			url:restURL+"/classesS"
		}).then(function successCallback(reponse){
			
			busSC(reponse.data);
		}, function erreurCallBack(reponse){
			
			console.log("Erreur -------"+reponse.statusText);
		})
		
		
	}
	
	function deleteCS(id, busSC) {
		$http.delete(restURL+"/classeS/"+id).then(function succesCallback(reponse){
			busSC(reponse.data)
		}, function erreurCallback(reponse) {
			console.log("Erreur------"+reponse.statusText);
		});
		
		
		
	}
	
	
	
	function getCSById(id, busSC) {
		$http.get(restURL+"/classeS?pId="+id).then(function succesCallback(reponse) {
			busSC(reponse.data)
			
			
		}, function erreurCallback(reponse) {
			
			console.log("Erreur ----" + reponse.statusText);
		});
		
		
	}
	
	function CSmodif(classeStandard, busSC) {
		$http({
			method:"PUT", 
			url : restURL+"/classeS",
			data : angular.toJson(classeStandard),
			headers : {ContentType : 'application/json'}
		}).then(function succesCallback(reponse) {
			busSC(reponse.statusText);
			
			
		}, function erreurCallback(reponse) {
			console.log("Erreur-----"+reponse.statusText);

		})
		
		
		
	}
	
	
	
	function ajoutCS(classeStandard, busSC){
		$http({
			method:"POST", 
			url:restURL+"/classeS",
			data:angular.toJson(classeStandard),
			headers : {ContentType: 'application/json'}
	}).then (function succesCallback(reponse) {
		busSC(reponse.statusText);
	}, function erreurCallback(reponse){
		console.log("Erreur--------"+reponse.statusText);
	})
			
	}
	
	
	return {
		getAll:findAll,
		getOneClasse:getCSById,
		supprCS:deleteCS,
		ajoutOneCS:ajoutCS,
		modifCS:CSmodif
		
		
	}
	
});