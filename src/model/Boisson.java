package model;
// Generated 19 mars 2022, 13:13:22 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Boisson generated by hbm2java
 */
@Entity
@Table(name = "boisson", catalog = "cantine_universitaire")
public class Boisson implements java.io.Serializable {

	private Integer idBoisson;
	private StockBoisson stockBoisson;
	private String nom;
	private int prix;
	private Set<Date> dates = new HashSet<Date>(0);
	private Set<Ticket> tickets = new HashSet<Ticket>(0);

	public Boisson() {
	}

	public Boisson(StockBoisson stockBoisson, String nom, int prix) {
		this.stockBoisson = stockBoisson;
		this.nom = nom;
		this.prix = prix;
	}

	public Boisson(StockBoisson stockBoisson, String nom, int prix, Set<Date> dates, Set<Ticket> tickets) {
		this.stockBoisson = stockBoisson;
		this.nom = nom;
		this.prix = prix;
		this.dates = dates;
		this.tickets = tickets;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_boisson", unique = true, nullable = false)
	public Integer getIdBoisson() {
		return this.idBoisson;
	}

	public void setIdBoisson(Integer idBoisson) {
		this.idBoisson = idBoisson;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stockboisson_id", nullable = false)
	public StockBoisson getStockBoisson() {
		return this.stockBoisson;
	}

	public void setStockBoisson(StockBoisson stockBoisson) {
		this.stockBoisson = stockBoisson;
	}

	@Column(name = "nom", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prix", nullable = false)
	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "boisson")
	public Set<Date> getDates() {
		return this.dates;
	}

	public void setDates(Set<Date> dates) {
		this.dates = dates;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "boisson")
	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
