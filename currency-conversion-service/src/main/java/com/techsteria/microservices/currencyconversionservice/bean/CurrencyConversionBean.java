package com.techsteria.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private Long id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal conversionMultiple;
	private BigDecimal totalAmount;
	private int port;
	
	protected CurrencyConversionBean()
	{
		
	}
	
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple,
			int port,BigDecimal totalAmount) {
		super();
		this.id = id;	
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		System.out.println("quantity in constructor ="+quantity);
		this.conversionMultiple = conversionMultiple;
		this.port = port;
		this.totalAmount=totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount)
	{
		this.totalAmount=totalAmount;
	}
	
	public BigDecimal getTotalAmount()
	{
		return totalAmount;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "CurrencyConversionBean [id=" + id + ", from=" + from + ", to=" + to + ", quantity=" + quantity
				+ ", conversionMultiple=" + conversionMultiple + ", totalAmount=" + totalAmount + ", port=" + port
				+ "]";
	}

	
	
	
}
