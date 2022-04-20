package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime creationTime;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.REMOVE,CascadeType.MERGE})
    @JoinColumn(name = "orders_id")
    private List<OrderLine> orderLines;

	@ManyToOne
    private Customer payer;
    @ManyToOne
    private Customer deliver;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}
	public Customer getCustomer() {
		return payer;
	}
	public void setCustomer(Customer payer) {
		this.payer = payer;
	}
}