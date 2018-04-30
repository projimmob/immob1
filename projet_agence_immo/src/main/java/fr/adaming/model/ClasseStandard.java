package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="classes_standards")
@XmlRootElement
public class ClasseStandard {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_cs;
	private String type;
	private String modeO;
	private double prixMax;
	private double supMin;
	
	//Associations
	@OneToMany(mappedBy="classeS")
	private List<BienImmo> listeBiens;
	
	//Constructeurs
	public ClasseStandard() {
		super();
	}
	public ClasseStandard(String type, String modeO, double prixMax, double supMin) {
		super();
		this.type = type;
		this.modeO = modeO;
		this.prixMax = prixMax;
		this.supMin = supMin;
	}
	public ClasseStandard(long id_cs, String type, String modeO, double prixMax, double supMin) {
		super();
		this.id_cs = id_cs;
		this.type = type;
		this.modeO = modeO;
		this.prixMax = prixMax;
		this.supMin = supMin;
	}
	
	//Getters et setters
	public long getId_cs() {
		return id_cs;
	}
	public void setId_cs(long id_cs) {
		this.id_cs = id_cs;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModeO() {
		return modeO;
	}
	public void setModeO(String modeO) {
		this.modeO = modeO;
	}
	public double getPrixMax() {
		return prixMax;
	}
	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}
	public double getSupMin() {
		return supMin;
	}
	public void setSupMin(double supMin) {
		this.supMin = supMin;
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
		return "ClasseStandard [id_cs=" + id_cs + ", type=" + type + ", modeO=" + modeO + ", prixMax=" + prixMax
				+ ", supMin=" + supMin + "]";
	}
	
	
}
