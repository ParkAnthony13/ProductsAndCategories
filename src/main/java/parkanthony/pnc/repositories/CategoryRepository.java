package parkanthony.pnc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import parkanthony.pnc.models.CategoryModel;
import parkanthony.pnc.models.ProductModel;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryModel, Long> {
	List<CategoryModel> findAll();
	// Retrieves a list of all categories for a particular product
    List<CategoryModel> findAllByProducts(ProductModel product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<CategoryModel> findByProductsNotContains(ProductModel product);
}
