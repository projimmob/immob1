package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="clients")
@XmlRootElement
public class Client extends Personne{

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_cl;
	private String statut;
	
	//Associations
	@OneToOne
	@JoinColumn(name="a_id",referencedColumnName="id_a")
	private Adresse adresse;
	
	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<Visite> listeVisites;
	
	//Constructeurs
	public Client() {
		super();
	}
	public Client(String nom, String telP, String statut) {
		super(nom, telP);
		this.statut = statut;
	}
	public Client(String nom, String telP, long id_cl, String statut) {
		super(nom, telP);
		this.id_cl = id_cl;
		this.statut = statut;
	}
	
	//Getters et setters
	public long getId_cl() {
		return id_cl;
	}
	public void setId_cl(long id_cl) {
		this.id_cl = id_cl;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	public List<Visite> getListeVisites() {
		return listeVisites;
	}
	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}
	
	//toString
	@Override
	public String toString() {
		return "Client [id_cl=" + id_cl + ", statut=" + statut + ", nom=" + nom + ", telP=" + telP + "]";
	}

	
}
