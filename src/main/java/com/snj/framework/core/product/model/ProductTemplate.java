package com.snj.framework.core.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.Columns;
import org.joda.money.BigMoney;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.snj.framework.core.model.SnjObject;

@lombok.Getter
@lombok.Setter
@Entity(name = "SNJ_PRODUCT_TEMPLATE")
public class ProductTemplate extends SnjObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2777618859567714850L;

	@Column(name="NAME")
	private String name;

	@Column(name="IMAGE_FILE_NAME")
	private String imageFilename;

	@Column(name="SUPPLIER_REF")
	private String supplierRef;

	@Column(name="INTERNAL_REF")
	private String internalRef;

//	@Type(type = "com.snj.framework.core.type.MoneyUserType", value = null)
//	@Columns(columns = {@Column(name = "BUY_PRICE"), @Column(name = "BUY_CURRENCY")})
//	private BigMoney buyPrice;
//
//	@Type(type = "com.snj.framework.core.type.MoneyUserType")
//	@Columns(columns = {@Column(name = "SELLADVISED_PRICE"), @Column(name = "SELLADVISED_CURRENCY")})
//	private BigMoney sellAdvisedPrice;
//
//	@Type(type = "com.snj.framework.core.type.MoneyUserType", value = null)
//	@Columns(columns = {@Column(name = "SELL_PRICE"), @Column(name = "SELL_CURRENCY")})
//	private BigMoney sellPrice;


}
