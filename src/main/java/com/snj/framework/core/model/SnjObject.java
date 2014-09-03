package com.snj.framework.core.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@lombok.Getter
@lombok.Setter
@MappedSuperclass
public class SnjObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5000023121673677776L;
	
	@Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
	
	@Column(name="CREATEDATE")
	private Timestamp createDate;
	
	@Column(name="MODIFYDATE")
	private Timestamp modifyDate;
}
