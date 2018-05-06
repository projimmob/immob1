	//Créer les services pour récupérer les données du webService

angular.module('monApp')
.factory("cService", function($http) {
	var restUrl = "http://localhost:8080/projet_agence_immo/";
	function consAll(busSC) {
		$http({
			method : "GET",
			url : restUrl + "/liste"
		}).then(function succesCallBack(reponse) {
			busSC(reponse.data)
		}, function erreurCallBack(reponse) {
			console.log("Erreur : " + reponse.statusText)
		})
	};

	function findOne(id, busSc) {
		$http.get(restUrl + "/findCons?pId=" + id).then(
				function succes(reponse) {
					busSc(reponse.data)
				}, function echec(reponse) {
					console.log("Erreur : " + reponse.statusText)
				})
	};
	
	function deleteOne(id_co,busSc) {
		$http.delete(restUrl + "/supprimer/" + id_co).then(
				function succes(reponse) {
					busSc(reponse.statusText)
				}, function echec(reponse) {
					console.log("Erreur : " + reponse.statusText)
				})
	};
	function addOne(conseiller,busSc) {
		$http({
			method : "POST",
			url : restUrl + '/ajouterCons',
			data : angular.toJson(conseiller),
			headers : {ContentType:"application/json"}
		}).then(
				function succes(reponse) {
					busSc(reponse.statusText)
				}, function echec(reponse) {
					console.log("Erreur : " + reponse.statusText)
				})
	};
	function updateOne(conseiller,busSc) {
		$http({
			method : "PUT",
			url : restUrl + "/updateCons",
			data : angular.toJson(conseiller),
			headers : {ContentType:"application/json"}
		}).then(
				function succes(reponse) {
					busSc(reponse.statusText)
				}, function echec(reponse) {
					console.log("Erreur : " + reponse.statusText)
				})
	};
	return {
		getAll : consAll,
		getById : findOne,
		deleteCons:deleteOne,
		addCons:addOne,
		updateCons:updateOne
	}
});