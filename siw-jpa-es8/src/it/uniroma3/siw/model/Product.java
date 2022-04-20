package it.uniroma3.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="selectAllProduct",query="SELECT p FROM Product p ")
@NamedQuery(name="deleteAllProduct",query="DELETE FROM Product p")
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String name;
	private String description;
	private float price;
	@Column(nullable = false)
	private String code;
	
	
	public Product(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	
	public Product(String name, float price, String code) {
		super();
		this.name = name;
		this.price = price;
		this.code = code;
	}


	public Product() {
		
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
/*	public List<Provider> getProviders() {
		return providers;
	}
	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	@ManyToMany(mappedBy = "products")
	private List <Provider> providers;*/
}
