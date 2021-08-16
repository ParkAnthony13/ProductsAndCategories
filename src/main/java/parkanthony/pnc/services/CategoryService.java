package parkanthony.pnc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import parkanthony.pnc.models.CategoryModel;
import parkanthony.pnc.models.ProductModel;
import parkanthony.pnc.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	public List<CategoryModel> allItems(){
		return categoryRepository.findAll();
	}
	public CategoryModel createItem(CategoryModel b) {
		return categoryRepository.save(b);
	}
	public CategoryModel saveItem(CategoryModel b) {
		return categoryRepository.save(b);
	}
	public CategoryModel findItem(Long id) {
		Optional<CategoryModel> optionalItem = categoryRepository.findById(id);
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		} else {
			return null;
		}
	}
	public List<CategoryModel> productCategories(ProductModel product) {
		return categoryRepository.findAllByProducts(product);
	}
	public List<CategoryModel> notProductCategories(ProductModel product) {
		return categoryRepository.findByProductsNotContains(product);
	}
}
