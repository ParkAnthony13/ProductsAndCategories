package parkanthony.pnc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import parkanthony.pnc.models.CategoryModel;
import parkanthony.pnc.models.ProductModel;


@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long> {
	List<ProductModel> findAll();
	
	List<ProductModel> findByCategoriesNotContains(CategoryModel category);
}
