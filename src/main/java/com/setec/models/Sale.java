package com.setec.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sale")
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name ="createBy",nullable =false)
	private int createBy;
	@CreationTimestamp()
	@Column(name ="saleDate",nullable =false)
	private Date saleDate;
	@Column(name ="totalAmount",nullable =false)
	private double totalAmount;
	@OneToMany(mappedBy ="sale")
	private List<SaleDetail> saleDetails;
	public Sale() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCreateBy() {
		return createBy;
	}
	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<SaleDetail> getSaleDetails() {
		return saleDetails;
	}
	public void setSaleDetails(List<SaleDetail> saleDetails) {
		this.saleDetails = saleDetails;
	}
	public void addSale(SaleDetail tempSaleDetail) {
		if(saleDetails==null) {
			saleDetails=new ArrayList<>();
		}
		saleDetails.add(tempSaleDetail);
		tempSaleDetail.setSale(this);
	}
	 

}
