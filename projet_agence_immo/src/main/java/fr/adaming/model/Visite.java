package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name="visites")
@XmlRootElement
public class Visite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_v;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Temporal(TemporalType.TIME)
	private Date heure; 
	
	
	//ASSOCIATIONS
	@ManyToMany(mappedBy="listeVisites")
	List<BienImmo> listeBiens;
	
	@ManyToOne
	@JoinColumn(name="co_id",referencedColumnName="id_co")
	private Conseiller conseiller;
	
	@ManyToOne
	@JoinColumn(name="cl_id",referencedColumnName="id_cl")
	private Client client;
	
	//CONSTRUCTEUR 
	
	public Visite() {
		super();
	}



	public Visite(Date date, Date heure) {
		super();
		this.date = date;
		this.heure = heure;
	}



	public Visite(Long id_v, Date date, Date heure) {
		super();
		this.id_v = id_v;
		this.date = date;
		this.heure = heure;
	}

//GETTERS ET SETTERS
	
	

	public Long getId_v() {
		return id_v;
	}



	public List<BienImmo> getListeBiens() {
		return listeBiens;
	}



	public void setListeBiens(List<BienImmo> listeBiens) {
		this.listeBiens = listeBiens;
	}



	public Conseiller getConseiller() {
		return conseiller;
	}



	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}



	public void setId_v(Long id_v) {
		this.id_v = id_v;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Date getHeure() {
		return heure;
	}



	public void setHeure(Date heure) {
		this.heure = heure;
	}


	//TO STRING

	@Override
	public String toString() {
		return "Visite [id_v=" + id_v + ", date=" + date + ", heure=" + heure + "]";
	}
	
	
	
	

}
