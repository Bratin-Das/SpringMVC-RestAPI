package com.NoobCoders.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.NoobCoders.validators.ProductValidator;

import in.NoobCoders.dao.DaOException;
import in.NoobCoders.dao.ProductDao;
import in.NoobCoders.entity.Category;
import in.NoobCoders.entity.Product;
import in.NoobCoders.entity.Supplier;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {
	
	@Autowired
	ProductDao htDao;
	 
	
	@RequestMapping(method = RequestMethod.GET , path = "/all-products")
	public String getAllProducts(Model model) throws DaOException {
		//List<Product> list = htDao.getAllProducts();
		//controller is supposed to store this in a scope i.e view as access to that
		model.addAttribute("pageTitle", "All Products");
		model.addAttribute("products",htDao.getAllProducts());
		return "show-products";
	}
	
	@RequestMapping(method = RequestMethod.GET , path = "/products-by-price-range")
	public String  getProductsByPriceRange(Model model, @RequestParam Double min ,@RequestParam Double max) throws DaOException {
		
		model.addAttribute("pageTitle", "List of products between $"+min+" and $"+max);
		model.addAttribute("products",htDao.getProductsByPriceRange(min,max));
		
		return "show-products";
	}
	
	
	@RequestMapping("/product-details")
	public String getProductDetails(@RequestParam Integer id, Model model) throws DaOException {
		
		model.addAttribute("pr",htDao.getProduct(id));
		
		return "product-details"; 
	}
	
	@RequestMapping(path = "/add-Product" , method = RequestMethod.GET )
	public String addProduct(Model model) throws DaOException {
		model.addAttribute("pr", new Product()); //pr--model Attribute
		model.addAttribute("categories", htDao.getAllCategories());
		model.addAttribute("suppliers", htDao.getAllSupplier());
		return "product-form";
	}
	
	@RequestMapping(path = "/edit-product" , method = RequestMethod.GET )
	public String editProduct(Model model,@RequestParam Integer id) throws DaOException {
		model.addAttribute("pr", htDao.getProduct(id));
		return "product-form";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategoryList() throws DaOException{
		return htDao.getAllCategories();
		
	}
	@ModelAttribute("suppliers")
	public List<Supplier> getSupplierList() throws DaOException{
		return htDao.getAllSupplier();
		
	}
	
	@RequestMapping(path = "/save-product" , method = RequestMethod.POST )
	public String saveProduct(@ModelAttribute("pr") Product pr , BindingResult errors) throws DaOException {
		ProductValidator pv = new ProductValidator();
		pv.validate(pr, errors);
		
		if(errors.hasErrors()) {
			return "product-form";
		}
		if(pr.getProductId() == null) {
			htDao.addProduct(pr);
		}
		else {
			htDao.updateProduct(pr);
		}
		
		return "redirect:product-details?id="+pr.getProductId();
	}
	
	
	
}
