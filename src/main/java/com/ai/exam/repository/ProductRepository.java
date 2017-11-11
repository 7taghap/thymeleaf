package com.ai.exam.repository;

import org.springframework.data.repository.CrudRepository;

import com.ai.exam.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
