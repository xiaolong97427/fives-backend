	package com.snj.framework.core.dimension.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;




import javax.persistence.OneToMany;

import com.snj.framework.core.model.SnjObject;

@lombok.Getter
@lombok.Setter
@Entity
public class Dimension extends SnjObject{

//	/**
//	 * 
//	 */
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	private Long id;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4308531837617692193L;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy = "dimension", cascade = CascadeType.PERSIST)
	private List<DimensionValue> listDimensionValue = new ArrayList<DimensionValue>();
}
