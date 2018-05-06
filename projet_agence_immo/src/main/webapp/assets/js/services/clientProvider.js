// Création des services de la classe Standard pour récupérer les données du WebService
var restURL = "http://localhost:8080/projet_agence_immo/";

angular.module('clientApp').factory(
		"clientService",
		function($http) {

			function findOneClient(id, busSC) {
				$http.get(restURL + "/client?pId=" + id).then(
						function succesCallback(reponse) {
							busSC(reponse.data)
						}, function erreurCallback(reponse) {

							console.log("Erreur----" + reponse.statusText);

						});
			}

			function findAllClient(busSC) {
				$http({
					method : "GET",
					url : restURL + "/listeCl"
				}).then(function successCallback(reponse) {

					busSC(reponse.data);
				}, function erreurCallBack(reponse) {

					console.log("Erreur -------" + reponse.statusText);
				})
			}

			function ajoutClient(client, busSC) {
				$http.post(restURL + "/client").then(
						function succesCallBack(reponse) {
							busSC(reponse.data);
						}, function erreurCallBack(reponse) {
							console.log("Erreur:" + reponse.statusText)
						});
			}

			return {
				getAllClient : findAllClient,
				getOneClient : findOneClient,
				clientAdd : ajoutClient
			}

		}).factory("adresseService", function($http) {
	function ajoutAdresse(adresse, busSC) {
		$http.post(restURL + "/adresse", angular.toJson(adresse), {
			ContentType : "application/json"
		}).then(function succes(reponse) {
			busSC(reponse.data);
		}, function erreur(reponse) {
			console.log("Erreur --- : " + reponse.statusText)
		});
	}

	return {
		addAdresse : ajoutAdresse
	}

});
