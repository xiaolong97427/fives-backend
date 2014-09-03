package com.snj.framework.core.dimension.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.snj.framework.core.model.SnjObject;

@lombok.Getter
@lombok.Setter
@Entity
public class DimensionValue extends SnjObject{

	private static final long serialVersionUID = 3360080476037693963L;

	@Column(name="NAME")
	private String name;
	
	@Column(name="LABEL")
	private String label;
	
	@Column(name="POSITION")
	private Integer position;
	
	@ManyToOne
	@JoinColumn(name = "DIM_ID")
	private Dimension dimension;
}
