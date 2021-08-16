package parkanthony.pnc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import parkanthony.pnc.models.CategoryModel;
import parkanthony.pnc.models.ProductModel;
import parkanthony.pnc.repositories.CategoryRepository;
import parkanthony.pnc.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	public List<ProductModel> allItems(){
		return productRepository.findAll();
	}
	public ProductModel createItem(ProductModel b) {
		return productRepository.save(b);
	}
	public ProductModel updateItem(ProductModel b) {
		return productRepository.save(b);
	}
	public ProductModel findItem(Long id) {
		Optional<ProductModel> optionalItem = productRepository.findById(id);
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		} else {
			return null;
		}
	}
	public List<ProductModel> productsNotinCategory(CategoryModel category){
		return productRepository.findByCategoriesNotContains(category);
	}
}
