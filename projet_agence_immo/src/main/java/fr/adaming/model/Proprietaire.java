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
@Table(name="proprietaires")
@XmlRootElement
public class Proprietaire extends Personne{

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_p;
	private String telT;
	
	//Associations
	@OneToOne
	@JoinColumn(name="a_id",referencedColumnName="id_a")
	private Adresse adresse;
	
	@JsonIgnore
	@OneToMany(mappedBy="proprio")
	private List<BienImmo> listeBiens;
	
	//Constructeurs
	public Proprietaire() {
		super();
	}
	public Proprietaire(String nom, String telP, String telT) {
		super(nom, telP);
		this.telT = telT;
	}
	public Proprietaire(String nom, String telP, long id_p, String telT) {
		super(nom, telP);
		this.id_p = id_p;
		this.telT = telT;
	}
	
	//Getters et setters
	public long getId_p() {
		return id_p;
	}
	public void setId_p(long id_p) {
		this.id_p = id_p;
	}
	public String getTelT() {
		return telT;
	}
	public void setTelT(String telT) {
		this.telT = telT;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public List<BienImmo> getListeBiens() {
		return listeBiens;
	}
	public void setListeBiens(List<BienImmo> listeBiens) {
		this.listeBiens = listeBiens;
	}
	
	//toString
	@Override
	public String toString() {
		return "Proprietaire [id_p=" + id_p + ", telT=" + telT + ", nom=" + nom + ", telP=" + telP + "]";
	}

	
}