package com.ai.exam.controller;


import java.util.Date;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.exam.model.Category;
import com.ai.exam.model.Product;
import com.ai.exam.repository.CategoryRepository;
import com.ai.exam.repository.ProductRepository;



@Controller
public class ProductController {
  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductController.class);
 
  @Autowired
  ProductRepository productRepository;
  @Autowired
  CategoryRepository categoryRepository;
  /**
   * create product
   * @param product
   * @return
   */
  @RequestMapping(value = "/createproduct", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String createProduct(Model model) {
    
    model.addAttribute("product", new Product());
    model.addAttribute("categories", categoryRepository.findAll());
    model.addAttribute("title", "Create Product");
    return "/createproduct";
  }
  
  @RequestMapping(value = "/editproduct/{id}", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String editProduct(@PathVariable String id, Model model) {
    

    model.addAttribute("product", productRepository.findOne(Long.valueOf(id)));
    model.addAttribute("categories", categoryRepository.findAll());
    model.addAttribute("title", "Edit Product");
    return "/createproduct";
  }
  
  @RequestMapping(value = "/deleteproduct/{id}", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String deleteProduct(@PathVariable String id, Model model) {
    Product product = productRepository.findOne(Long.valueOf(id));
    product.setCategory(null);
    productRepository.save(product);
    productRepository.delete(product);
    return "redirect:/product";
  }
  
  /**
   * product list
   * @param product
   * @return
   */
  @RequestMapping(value = "/product", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String productList(Model model) {
    model.addAttribute("products", productRepository.findAll());
    return "/product";
  }
  
  @RequestMapping(value = "/product/add", method = RequestMethod.POST)
  public String addProduct(@Valid Product product, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
          return "/createproduct";
      }
      Category category = categoryRepository.findOne(product.getCategory().getId());
      product.setCategory(category);
      product.setAvailable(String.valueOf(product.getQty()));
      product.setCreated(new Date());
      productRepository.save(product);
      return "redirect:/product";
  }
}
