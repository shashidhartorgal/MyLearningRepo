package com.example.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot.model.Products;
import com.example.springboot.service.ProductsService;

@Controller
public class ProductController {

	@Autowired
	ProductsService productsService;

	@Autowired
	Products products;

	@GetMapping("/getproducts")
	public String getAllProducts(Model model){
		List<Products> prod = (List<Products>) 
		productsService.getAllProducts();
		//	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("prodlist", prod); 
		return "showprods"; 
	}

	@PostMapping("/addproducts")
	public String addProduct(@ModelAttribute Products prod, Model model) { 
		model.addAttribute("products", prod);
		productsService.addProduct(prod); 
		return "result";
	}


	@GetMapping("/productscatlog")
	public String productsForm(Model model) {
		model.addAttribute("products", new Products());
		return "productsform"; 
	}
	
	@PostMapping( "/deleteProd/{id}")
	public String deleteProduct(@PathVariable Long id) { 
		productsService.deleteProduct(id); 
		return "redirect:/getproducts";
	}
	

}
