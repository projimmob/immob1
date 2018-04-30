package fr.adaming.model;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;

@MappedSuperclass
@XmlRootElement
public class Personne {

	//Attributs
	protected String nom;
	protected String telP;
	
	//Constructeurs
	public Personne() {
		super();
	}
	public Personne(String nom, String telP) {
		super();
		this.nom = nom;
		this.telP = telP;
	}
	
	//Getters et setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelP() {
		return telP;
	}
	public void setTelP(String telP) {
		this.telP = telP;
	}
	
}