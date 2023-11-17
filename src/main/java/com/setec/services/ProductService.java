package com.setec.services;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.setec.Exceptions.StudentNotfFoundException;
import com.setec.models.Product;
import com.setec.repositorys.ProductRepository;
import com.setec.repositorys.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository ProductRepository;

	public List<Product> getProductAll() {
		List<Product> productList=ProductRepository.findAll();
		List<Product> productList1=new ArrayList<>();
		for(int i=0;i<productList.size();i++) {
			Product product=new Product();
			product.setName(productList.get(i).getName());
			product.setBarcode(productList.get(i).getBarcode());
			productList1.add(product);
		}
		
		 
		
		return productList1;
	}

	public ResponseEntity<Object> save(Product Product) {
		// TODO Auto-generated method stub
		Product Product1=new Product();
		Product1.setName(Product.getName());
		Product1.setCreateBy(Product.getCreateBy());
		ProductRepository.save(Product1);
		return new ResponseEntity<Object>("Product created",HttpStatus.CREATED);
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		Product Product=new Product();
		Product=ProductRepository.findProductById(id);
		if(Product==null) {
			throw new StudentNotfFoundException("Not found id:"+id);
		}
		return Product;
	}

	public List<Product> findByName(Product Product) {
		// TODO Auto-generated method stub
		List<Product> ProductList=ProductRepository.findProductByName(Product.getName());
		if(ProductList.size()==0) {
			throw new StudentNotfFoundException("Not found name:"+Product.getName());
		}
		return ProductList;
	}

	public ResponseEntity<Object> updateById(int id, Product Product) {
		Product Product1=ProductRepository.findProductById(id);
		if(Product1==null) {
			throw new StudentNotfFoundException("Not found id:"+id);
		}
		Product1.setName(Product.getName());
		Product1.setUpdateBy(Product.getUpdateBy());
		ProductRepository.save(Product1);
		return new ResponseEntity<Object>("Product updated",HttpStatus.OK);
	}

	public ResponseEntity<Object> deleteById(int id) {
		Product Product1=ProductRepository.findProductById(id);
		if(Product1==null) {
			throw new StudentNotfFoundException("Not found id:"+id);
		}
		ProductRepository.deleteById(Product1.getId());
		return new ResponseEntity<Object>("Product deleted",HttpStatus.OK);
	}
 
}
