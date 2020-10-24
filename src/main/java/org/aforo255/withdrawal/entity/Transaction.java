package org.aforo255.withdrawal.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "transaction_table")
public class Transaction extends PanacheEntityBase{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id ;
	private double amount ;
	private String type ;
	@Column(name = "account_id")
	private Integer accountId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
}
