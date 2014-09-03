package com.snj.framework.core.dimension.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.snj.framework.core.dimension.model.Dimension;
import com.snj.framework.core.dimension.model.DimensionValue;

@RepositoryRestResource(path = "dimension")
public interface DimensionRepository extends PagingAndSortingRepository<Dimension, Long>{

	List<DimensionValue> findByName(@Param("name") String pName);
}
