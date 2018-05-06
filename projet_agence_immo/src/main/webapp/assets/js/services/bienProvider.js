/**
 * Creation des services pour la gestion des biens
 */

var restUrl = "http://localhost:8080/projet_agence_immo/";
angular.module('gestionBiens')
.factory("bienServ", function($http) {
	
	//fonctions
	function ajoutBien(bien, bus) {
		//transformer l'image recuperee en tableau de byte
		bien.photo = bien.photo.base64;
		
		$http.post(restUrl+"/bien",angular.toJson(bien),{ContentType: "application/json"}).then(function succes(resp) {
			bus(resp.data);
		}, function erreur(resp) {
			console.log("Erreur: "+resp.statusText)
		});
	}
	
	function getAllBiens(bus) {
		$http.get(restUrl+"/biens").then(function succes(resp) {
			bus(resp.data);
		}, function erreur(resp) {
			console.log("Erreur: "+resp.statusText)
		});
	}
	
	return {
		bienAdd:ajoutBien,
		bienAffich:getAllBiens
	}
}).factory("adresseServ", function($http) {
	
	function ajoutAdresse(adr,bus) {
		$http.post(restUrl+"/adresse", angular.toJson(adr),{ContentType: "application/json"}).then(function succes(resp) {
			bus(resp.data);
		}, function erreur(resp) {
			console.log("Erreur: "+resp.statusText)
		});
	}
	
	return {
		adAdd : ajoutAdresse
	}
}).factory("locaServ", function($http) {
	function ajoutLocation(loc,bus){
		$http.post(restUrl+"/location", angular.toJson(loc),{ContentType: "application/json"}).then(function succes(resp) {
			bus(resp.data);
		}, function erreur(resp) {
			console.log("Erreur: "+resp.statusText)
		});
	}
	
	function getLocations(bus) {
		$http.get(restUrl+"/location").then(function succes(resp) {
			bus(resp.data);
		}, function erreur(resp) {
			console.log("Erreur: "+resp.statusText)
		});
	}
	
	return {
		locAdd : ajoutLocation,
		locAll : getLocations
	}
	
}).factory("achServ", function($http) {
	function ajoutAchat(ach,bus) {
		$http.post(restUrl+"/achat", angular.toJson(ach),{ContentType: "application/json"}).then(function succes(resp) {
			bus(resp.data);
		}, function erreur(resp) {
			console.log("Erreur: "+resp.statusText)
		});
	}
	
	function getAchats(bus) {
		$http.get(restUrl+"/achat").then(function succes(resp) {
			bus(resp.data);
		}, function erreur(resp) {
			console.log("Erreur: "+resp.statusText)
		});
	}
	
	return {
		achAdd : ajoutAchat,
		achAll : getAchats
	}
}).factory("clasServ",function($http){
	function getClasses(bus) {
		$http.get(restUrl+"/classesS").then(function succes(resp) {
			bus(resp.data);
		}, function erreur(resp) {
			console.log("Erreur: "+resp.statusText)
		});
	}
	
	return {
		clasGet : getClasses
	}
});