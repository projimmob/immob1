package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "biens")
@XmlRootElement
public class BienImmo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ATTRIBUTS

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_b;
	private String type;
	private String statut;

	@Temporal(TemporalType.DATE)
	private Date dateS;

	@Temporal(TemporalType.DATE)
	private Date dateD;
	private double revC;
	private double prix;

	@Temporal(TemporalType.DATE)
	private Date dateE;

	@Lob
	private byte[] photo;
	@Transient
	private String image;

	// ASSOCIATIONS
	@ManyToMany
	@JoinTable(name = "visites_biens", joinColumns = @JoinColumn(name = "b_id", referencedColumnName = "id_b"), 
	inverseJoinColumns = @JoinColumn(name = "v_id", referencedColumnName = "id_v"))
	List<Visite> listeVisites;

	@ManyToOne
	@JoinColumn(name = "p_id", referencedColumnName = "id_p")
	private Proprietaire proprio;

	@OneToOne
	@JoinColumn(name = "a_id", referencedColumnName = "id_a")
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "cs_id", referencedColumnName = "id_cs")
	private ClasseStandard classeS;

	// CONSTRUCTEURS
	public BienImmo() {
		super();
	}

	public BienImmo(Long id_b, String type, String statut, Date dateS, Date dateD, double revC, double prix, Date dateE,
			byte[] photo, String image) {
		super();
		this.id_b = id_b;
		this.type = type;
		this.statut = statut;
		this.dateS = dateS;
		this.dateD = dateD;
		this.revC = revC;
		this.prix = prix;
		this.dateE = dateE;
		this.photo = photo;
		this.image = image;
	}

	public BienImmo(String type, String statut, Date dateS, Date dateD, double revC, double prix, Date dateE,
			byte[] photo, String image) {
		super();
		this.type = type;
		this.statut = statut;
		this.dateS = dateS;
		this.dateD = dateD;
		this.revC = revC;
		this.prix = prix;
		this.dateE = dateE;
		this.photo = photo;
		this.image = image;
	}

	// GETTERS ET SETTERS

	public Long getId_b() {
		return id_b;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public ClasseStandard getClasseS() {
		return classeS;
	}

	public void setClasseS(ClasseStandard classeS) {
		this.classeS = classeS;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Visite> getListeVisites() {
		return listeVisites;
	}

	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}

	public Proprietaire getProprio() {
		return proprio;
	}

	public void setProprio(Proprietaire proprio) {
		this.proprio = proprio;
	}

	public void setId_b(Long id_b) {
		this.id_b = id_b;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateS() {
		return dateS;
	}

	public void setDateS(Date dateS) {
		this.dateS = dateS;
	}

	public Date getDateD() {
		return dateD;
	}

	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}

	public double getRevC() {
		return revC;
	}

	public void setRevC(double revC) {
		this.revC = revC;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDateE() {
		return dateE;
	}

	public void setDateE(Date dateE) {
		this.dateE = dateE;
	}

	// TO STRING
	@Override
	public String toString() {
		return "BienImmo [id_b=" + id_b + ", type=" + type + ", statut=" + statut + ", dateS=" + dateS + ", dateD="
				+ dateD + ", revC=" + revC + ", prix=" + prix + ", dateE=" + dateE + "]";
	}

}
