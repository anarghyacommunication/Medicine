package com.anarghya.ayurveda.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/*@Entity: defines that said class is an entity and will be mapped to a database table.*/
@Entity
/*
 * @Table: allows us to specify the details of the table that will be used to
 * persist the entity in the database.
 */
@Table(name = "medicines")
public class Medicine {

	/* @Id: specifies the primary key of an entity. */
	@Id
	/*
	 * specifies that the primary key values for User entities should be generated
	 * using an identity column in the database.
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String mfdDate;
	private String expiryDate;
	private int quantity;
	private float cost;
	private String company;
	
	private String category;
	private String description;
	private String formula;
	private String batchCode;

	@Transient
	private static int count = 1; // Make count static to ensure it's shared across all instances

	// ...

	@PrePersist
	public void generateBatchCode() {
	    if (company != null && !company.isEmpty()) {
	        // Get the current date
	        Date currentDate = Calendar.getInstance().getTime();

	        // Format the date as Month/Date
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
	        String formattedDate = dateFormat.format(currentDate);

	        // Extract the first letter of the company name and convert it to uppercase
	        String twoLetters = company.substring(0, 2).toUpperCase();

	        // Extract the current year and month
	        Calendar calendar = Calendar.getInstance();
	        int currentYear = calendar.get(Calendar.YEAR);
	        int currentMonth = calendar.get(Calendar.MONTH) + 1; // Month is 0-based

	        // Generate the batch code with count
	        batchCode = twoLetters + "" + currentYear + "/" + currentMonth + "/" + formattedDate + "/" + String.format("%03d", count);

	        // Increment the count and save it
	        count++;

	        // You might want to persist the count value in the database here
	    }
	}


	public Medicine(Long id, String name, String mfdDate, String expiryDate, int quantity, float cost, String company,
			String category, String batchCode) {
		this.id = id;
		this.name = name;
		this.mfdDate = mfdDate;
		this.expiryDate = expiryDate;
		this.quantity = quantity;
		this.cost = cost;
		this.company = company;
		this.category = category;
		this.batchCode = batchCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMfdDate() {
		return mfdDate;
	}

	public void setMfdDate(String mfdDate) {
		this.mfdDate = mfdDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getFormula() {
		return formula;
	}


	public void setFormula(String formula) {
		this.formula = formula;
	}


	public Medicine() {

	}

}
