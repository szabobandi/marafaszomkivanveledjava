package mar.faszom.kivan.domain;

import java.util.List;

public interface ProductCatalog {

	public void addProduct(String productName, String price);
	public void addProduct(String productName, Integer price);
	public void addProduct(Product product);
	public Product findById(Long id);
	public List<Product> getProducts();
	public void deleteProduct(Long id);
	public List<Product> findByMaxPrice(Integer maxPrice);
}

