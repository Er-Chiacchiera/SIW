package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"firstName","lastName,email"}))
public class Customer {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		@Column(nullable = false)
		private String firstName;
		@Column(nullable = false)
		private String lastName;
		private String email;
		private LocalDate dateOfBirth;
		@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
		private Address address;
		@OneToMany(mappedBy = "payer",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	    private List<Order> payedOrders;
	    @OneToMany(mappedBy = "deliver",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	    private List<Order> orders;
	    
	    
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}

}