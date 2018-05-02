package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="conseillers")
@XmlRootElement
public class Conseiller {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_co;
	private String mail;
	private String psw;
	
	//Associations
	@JsonIgnore
	@OneToMany(mappedBy="conseiller")
	private List<Visite> listeVisites;
	
	//Constructeurs
	public Conseiller() {
		super();
	}
	public Conseiller(String mail, String psw) {
		super();
		this.mail = mail;
		this.psw = psw;
	}
	public Conseiller(long id_co, String mail, String psw) {
		super();
		this.id_co = id_co;
		this.mail = mail;
		this.psw = psw;
	}
	
	//Getters et setters
	public long getId_co() {
		return id_co;
	}
	public void setId_co(long id_co) {
		this.id_co = id_co;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
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
		return "Conseiller [id_co=" + id_co + ", mail=" + mail + ", psw=" + psw + "]";
	};
	

}