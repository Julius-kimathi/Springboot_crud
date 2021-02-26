package com.techie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techie.demo.entity.Product;
import com.techie.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//post methods
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products){
		return repository.saveAll(products);
	}
	
    //get methods	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	public Product  getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	public Product  getProductByName(String name) {
		return repository.findByName(name);
	}
	
	//delete methods
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "product removed successfully || " +id;
	}
	
	//update methods
	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
}
