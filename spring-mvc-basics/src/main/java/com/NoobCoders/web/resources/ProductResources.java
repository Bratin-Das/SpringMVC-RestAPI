package com.NoobCoders.web.resources;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.NoobCoders.dao.DaOException;
import in.NoobCoders.dao.ProductDao;
import in.NoobCoders.entity.Product;

@RequestMapping("/api/products")
@RestController
public class ProductResources {

	@Autowired
	ProductDao htDao;

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> getAllProducts() throws DaOException {
		return htDao.getAllProducts();
	}

	// -----------------------GET---------------------
	@RequestMapping(path = "/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id) throws DaOException {

		Product pr = htDao.getProduct(id);

		if (pr == null) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("message", "No Products found !");
			m.put("productId", id);
			return new ResponseEntity<>(m, HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(pr); // 200
	}

	// -----------------------POST------------------------

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addProduct(@RequestBody Product pr) {
		try {
			htDao.addProduct(pr);
			pr = htDao.getProduct(pr.getProductId());
			return ResponseEntity.ok(pr);
		} catch (DaOException e) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("message", e.getMessage());
			m.put("product", pr);
			return new ResponseEntity<>(m, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	// ----------------------PUT-------------------------------

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody Product pr) {

		try {
			pr.setProductId(id);
			htDao.updateProduct(pr);
			pr = htDao.getProduct(pr.getProductId());
			return ResponseEntity.ok(pr);
		} catch (DaOException e) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("message", e.getMessage());
			m.put("product", pr);
			return new ResponseEntity<>(m, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	// ------------------DELETE--------------------
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {

		try {
			Product pr = htDao.getProduct(id);
			if (pr == null) {
				HashMap<String, Object> m = new HashMap<String, Object>();
				m.put("message", "No Products found !");
				m.put("productId", id);
				return new ResponseEntity<>(m, HttpStatus.NOT_FOUND);
			}

			htDao.deleteProduct(id);
			pr = htDao.getProduct(id);
			return ResponseEntity.ok(pr); // 200
		} catch (DaOException e) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("message", e.getMessage());
			return new ResponseEntity<>(m, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
