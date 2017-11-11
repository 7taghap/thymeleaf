package com.ai.exam.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Product implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String name;
  
  private String description;
  
  private String categoryPath;
  
  private String available;
  
  private Double price;
  
  private String status;
  
  private Integer qty;
  
  private Date created;
  
  private String creator;
  
@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(name = "product_category", joinColumns = {
        @JoinColumn(name = "product_id", nullable = false, updatable = false) },
        inverseJoinColumns = { @JoinColumn(name = "category_id",
                nullable = false, updatable = false) })
  private Set<Category> categories;
}
