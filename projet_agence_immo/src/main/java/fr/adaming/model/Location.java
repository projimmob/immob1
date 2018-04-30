package fr.adaming.model;

import fr.adaming.model.BienImmo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="locations")
@XmlRootElement
public class Location {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_l;
	private double loyer;
	private double caution;
	private double charges;
	private String bail;
	private boolean meuble;
	
	//Associations
	@OneToOne
	@JoinColumn(name="b_id",referencedColumnName="id_b")
	private BienImmo bien;
	
	//Constructeurs
	public Location() {
		super();
	}
	public Location(double loyer, double caution, double charges, String bail, boolean meuble) {
		super();
		this.loyer = loyer;
		this.caution = caution;
		this.charges = charges;
		this.bail = bail;
		this.meuble = meuble;
	}
	public Location(long id_l, double loyer, double caution, double charges, String bail, boolean meuble) {
		super();
		this.id_l = id_l;
		this.loyer = loyer;
		this.caution = caution;
		this.charges = charges;
		this.bail = bail;
		this.meuble = meuble;
	}
	
	//Getters et setters 
	public long getId_l() {
		return id_l;
	}
	public void setId_l(long id_l) {
		this.id_l = id_l;
	}
	public double getLoyer() {
		return loyer;
	}
	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}
	public double getCaution() {
		return caution;
	}
	public void setCaution(double caution) {
		this.caution = caution;
	}
	public double getCharges() {
		return charges;
	}
	public void setCharges(double charges) {
		this.charges = charges;
	}
	public String getBail() {
		return bail;
	}
	public void setBail(String bail) {
		this.bail = bail;
	}
	public boolean isMeuble() {
		return meuble;
	}
	public void setMeuble(boolean meuble) {
		this.meuble = meuble;
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
		return "Location [id_l=" + id_l + ", loyer=" + loyer + ", caution=" + caution + ", charges=" + charges
				+ ", bail=" + bail + ", meuble=" + meuble + "]";
	}
	
	
	
}