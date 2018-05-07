//Configurer la table de routage

angular.module('monApp').config(function($routeProvider) {
	// conseillers
	$routeProvider.when("/consAll", {
		controller : "listeCtrl",
		templateUrl : "views/ConsListe.html"
	}).when("/tabordAll", {
		controller : "tabCTRL",
		templateUrl : "views/ConsTabord.html"
	}).when("/existCons", {
		controller : "LoginController",
		templateUrl : "views/login.html"
	}).when("/add", {
		controller : "ajoutCtrl",
		templateUrl : "views/ConsAjout.html"
	}).when("/update", {
		controller : "modifCtrl",
		templateUrl : "views/ConsModif.html"
	}).when("/delete", {
		controller : "supprimCtrl",
		templateUrl : "views/ConsSupp.html"
	}).when("/ConsListe",{
		controller : "adminCtrl",
		templateUrl : "views/ConsListe.html"
	})

	// les biens
	.when("/bienAdd", {
		controller : "bienAjoutCtrl",
		templateUrl : "views/bienAjout.html"
	}).when("/biensAll", {
		controller : "biensListeCtrl",
		templateUrl : "views/bienAffich.html"

	}).when("/biensAllFilter", {
		controller : "biensListeFilterCtrl",
		templateUrl : "views/bienAffichFilter.html"

	// les visites
	}).when("/visiteFindAll", {
		controller : "visiteListeCtrl",
		templateUrl : "views/visiteListe.html"
	}).when("/visiteAdd", {
		controller : "visiteAjoutCtrl",
		templateUrl : "views/visiteAjout.html"
	}).when("/visiteUpdate", {
		controller : "visiteModifCtrl",
		templateUrl : "views/visiteModif.html"
	}).when("/visiteDelete", {
		controller : "visiteSupprimCtrl",
		templateUrl : "views/visiteSupprim.html"
	}).when("/visiteGetById", {
		controller : "visiteRechercheCtrl",
		templateUrl : "views/visiteRecherche.html"
	}).when("/getItin", {
		controller : "wsExterneCtrl",
		templateUrl : "views/calculItineraire.html"

	// les clients
	}).when("/findAllClient", {
		controller : "GetAllClientCtrl",
		templateUrl : "views/clientListe.html"
	}).when("/getClientId", {
		controller : "rechercherClientCtrl",
		templateUrl : "views/clientRecherche.html"
	}).when("/ajouterClient", {
		controller : "ClientAjoutCtrl",
		templateUrl : "views/clientAjout.html"

	// les classes standard
	}).when("/findAll", {
		controller : "ClasseSListeCtrl",
		templateUrl : "views/classeSListe.html"
	}).when("/getCSById", {
		controller : "ClasseSRechCtrl",
		templateUrl : "views/classeSRecherche.html"
	}).when("/deleteCS", {
		controller : "CSsupprimCtrl",
		templateUrl : "views/classeSSuppr.html"
	}).when("/ajoutCS", {
		controller : "CSajoutCtrl",
		templateUrl : "views/classeSAjout.html"
	}).when("/CSmodif", {
		controller : "CSmodifCtrl",
		templateUrl : "views/classeSModif.html"

	// les proprietaires
	}).when("/proprietaireFindAll", {
		controller : "proprietaireListeCtrl",
		templateUrl : "views/proprietaireListe.html"
	}).when("/proprietaireAdd", {
		controller : "proprietaireAjoutCtrl",
		templateUrl : "views/proprietaireAjout.html"
	}).when("/proprietaireUpdate", {
		controller : "proprietaireModifCtrl",
		templateUrl : "views/proprietaireModif.html"
	}).when("/proprietaireDelete", {
		controller : "proprietaireSupprimCtrl",
		templateUrl : "views/proprietaireSupprim.html"
	}).when("/proprietaireGetById", {
		controller : "proprietaireRechercheCtrl",
		templateUrl : "views/proprietaireRecherche.html"
	}).when("/proprietaireGetByName", {
		controller : "proprietaireParNomCtrl",
		templateUrl : "views/proprietaireParNom.html"
	})

	.otherwise({
		redirectTo : "/tabordAll"
	})
});