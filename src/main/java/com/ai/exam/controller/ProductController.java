package com.ai.exam.controller;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ai.exam.model.Product;
import com.ai.exam.repository.ProductRepository;



@Controller
public class ProductController {
  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductController.class);
 
  @Autowired
  ProductRepository productRepository;
  /**
   * create product
   * @param product
   * @return
   */
  @RequestMapping(value = "/createproduct", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String createProduct(Model model) {
    
    model.addAttribute("product", new Product());
    
    return "/createproduct";
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
          return "product_create";
      }
      productRepository.save(product);
//      postRepository.save(new PostEntity(post.getTitle(), post.getContent()));
//      model.addAttribute("posts", postRepository.findAll());
      return "redirect:product";
  }
}
