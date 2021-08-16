package parkanthony.pnc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import parkanthony.pnc.models.CategoryModel;
import parkanthony.pnc.models.ProductModel;
import parkanthony.pnc.services.CategoryService;
import parkanthony.pnc.services.ProductService;

@Controller
public class CategoryController {
	private final CategoryService categoryService;
	private final ProductService productService;
	public CategoryController(ProductService productService,CategoryService categoryService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	@RequestMapping("/categories/new")
	public String createCategoryPage(@ModelAttribute("category") ProductModel product,Model model) {
		List<CategoryModel> categories = categoryService.allItems();
		model.addAttribute("categories",categories);
		return "/store/newCategory.jsp";
	}
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") CategoryModel product, BindingResult result) {
		if (result.hasErrors()) {
			return "/store/newCategory.jsp";
		} else {
			categoryService.createItem(product);
			return "redirect:/categories/new";
		}
	}
	@RequestMapping("/categories/{id}")
	public String viewByCategory(Model model,@PathVariable("id") Long id) {
		CategoryModel category = categoryService.findItem(id);
		List<ProductModel> notInCatProductList = productService.productsNotinCategory(category);
		List<ProductModel> productList = category.getProducts();
		model.addAttribute("category", category);
		model.addAttribute("productList", productList);
		model.addAttribute("notInCatProductList", notInCatProductList);
		return "/store/showCategory.jsp";
	}
	@RequestMapping(value="/categories/{id}",method=RequestMethod.POST)
	public String addProductToCategory(@RequestParam("products") Long productId,@PathVariable("id") Long id) {
		// first get the category so we can add to its products list
		CategoryModel category = categoryService.findItem(id);
		// get the product from the productId to have something to add to products list
		ProductModel product = productService.findItem(productId);
		// getproduct, set products, save new products list
		category.getProducts().add(product);
		categoryService.saveItem(category);
		// redirect to /categories/+id
		return "redirect:/categories/"+id;
	}
}