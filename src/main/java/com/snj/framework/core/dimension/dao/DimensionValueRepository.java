package com.snj.framework.core.dimension.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.snj.framework.core.dimension.model.Dimension;

//@RestResource(path = "dimensionValue", rel = "dimensionValue")
@RepositoryRestResource(path = "dimensionValue")
public interface DimensionValueRepository extends PagingAndSortingRepository<Dimension, Long> {

}
