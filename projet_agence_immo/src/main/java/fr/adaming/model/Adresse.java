package fr.adaming.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="adresses")
@XmlRootElement
public class Adresse {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_a;
	private String rue;
	private String num;
	private String cp;
	private String ville;
	private String pays;
	
	//Associations
	@OneToOne(mappedBy="adresse")
	private Client client;
	
	@OneToOne(mappedBy="adresse")
	private Proprietaire proprietaire;
	
	@OneToOne(mappedBy="adresse")
	private BienImmo bien;
	
	//Constructeurs
	public Adresse() {
		super();
	}
	public Adresse(String rue, String num, String cp, String ville, String pays) {
		super();
		this.rue = rue;
		this.num = num;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
	}
	public Adresse(long id_a, String rue, String num, String cp, String ville, String pays) {
		super();
		this.id_a = id_a;
		this.rue = rue;
		this.num = num;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
	}
	
	//Getters et setters
	public long getId_a() {
		return id_a;
	}
	public void setId_a(long id_a) {
		this.id_a = id_a;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	//toString
	@Override
	public String toString() {
		return "Adresse [id_a=" + id_a + ", rue=" + rue + ", num=" + num + ", cp=" + cp + ", ville=" + ville + ", pays="
				+ pays + "]";
	}
	

}
