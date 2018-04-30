package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="achats")
@XmlRootElement
public class Achat {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_ac;
	private double prix;
	private String etat;
	
	//Associations
	@OneToOne
	@JoinColumn(name="b_id",referencedColumnName="id_b")
	private BienImmo bien;
	
	//Constructeurs
	public Achat() {
		super();
	}
	public Achat(double prix, String etat) {
		super();
		this.prix = prix;
		this.etat = etat;
	}
	public Achat(long id_ac, double prix, String etat) {
		super();
		this.id_ac = id_ac;
		this.prix = prix;
		this.etat = etat;
	}
	
	//Getters et setters
	public long getId_ac() {
		return id_ac;
	}
	public void setId_ac(long id_ac) {
		this.id_ac = id_ac;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public BienImmo getBien() {
		return bien;
	}
	public void setBien(BienImmo bien) {
		this.bien = bien;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Achat [id_ac=" + id_ac + ", prix=" + prix + ", etat=" + etat + "]";
	}
	
	
}