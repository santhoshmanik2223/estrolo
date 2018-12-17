package com.rknowsys.estrolo.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemsTable")
public class Items implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId;
	private String itemName;
	private String description;
	private Boolean isParent;
	private Integer availableQuantities;
	private Long price;
	private Boolean status;
	private String imageWebUrl;
	private String tags;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoryId")
	private CategoryAPIEntity category;



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CategoryAPIEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryAPIEntity category) {
		this.category = category;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Integer getAvailableQuantities() {
		return availableQuantities;
	}

	public void setAvailableQuantities(Integer availableQuantities) {
		this.availableQuantities = availableQuantities;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageWebUrl() {
		return imageWebUrl;
	}

	public void setImageWebUrl(String imageWebUrl) {
		this.imageWebUrl = imageWebUrl;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
