package com.snj.framework.core.product.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.snj.framework.core.dimension.model.Dimension;

//@RepositoryRestResource(path = "productTemplate", rel = "productTemplate")
@RepositoryRestResource(path = "productTemplate")
public interface ProductTemplateRepository extends PagingAndSortingRepository<Dimension, Long>{

}
