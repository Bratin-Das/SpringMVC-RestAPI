package in.NoobCoders.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import in.NoobCoders.entity.Category;
import in.NoobCoders.entity.Product;
import in.NoobCoders.entity.Supplier;

@Transactional(rollbackFor = {DaOException.class}, readOnly = true)
public interface ProductDao {
	// CRUD OPERATIONS
	
	@Transactional(readOnly = false)
	public default void addProduct(Product product) throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	@Transactional(readOnly = false)
	public default void updateProduct(Product product) throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	public default Product getProduct(Integer productId) throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	@Transactional(readOnly = false)
	public default void deleteProduct(Integer productId) throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	// QUERIES
	public default List<Product> getAllProducts() throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	public default List<Product> getProductsByPriceRange(Double min, Double max) throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	public default List<Product> getProductsInCategory(Integer categoryId) throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	public default List<Product> getProductsNotInStock() throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	public default List<Product> getProductsOnOrder() throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	public default List<Product> getDiscontinuedProducts() throws DaOException {
		throw new DaOException("Method not Implemented");
	}

	public default long count() throws DaOException {
		throw new DaOException("Method not Implemented");
	}
	
	public default List<Category> getAllCategories() throws DaOException{
		throw new DaOException("Method not Implemented");
		
	}

	public default List<Supplier> getAllSupplier() throws DaOException{
		throw new DaOException("Method not Implemented");
		
	}
	
	
}
