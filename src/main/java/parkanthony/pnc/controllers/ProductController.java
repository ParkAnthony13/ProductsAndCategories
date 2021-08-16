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
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductController(ProductService productService,CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	@RequestMapping("/")
	public String landing() {
		return "redirect:/products/new";
	}
	@RequestMapping("/products/new")
	public String createProductPage(@ModelAttribute("product") ProductModel product,Model model) {
		List<ProductModel> products = productService.allItems();
		model.addAttribute("products",products);
		return "/store/newProduct.jsp";
	}
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result) {
		if (result.hasErrors()) {
			return "/store/newProduct.jsp";
		} else {
			productService.createItem(product);
			return "redirect:/products/new";
		}
	}
	// show a single product and be able to add categories to product
	@RequestMapping("/products/{id}")
	public String showProd(Model model,@PathVariable("id") Long id) {
		ProductModel product = productService.findItem(id);
		List<CategoryModel> prodCategories = categoryService.productCategories(product);
		List<CategoryModel> notProdCategories = categoryService.notProductCategories(product);
		for (CategoryModel cat:notProdCategories) {
			System.out.println(cat.getName());
		}
		model.addAttribute("product", product);
		model.addAttribute("prodCategories",prodCategories);
		model.addAttribute("notProdCategories",notProdCategories);
		return "/store/showProduct.jsp";
	}
	@RequestMapping(value="/products/{id}",method=RequestMethod.POST)
	public String addCategorytoProduct(@RequestParam("categories") Long catid,@PathVariable("id") Long id) {
		ProductModel product = productService.findItem(id);
		CategoryModel category = categoryService.findItem(catid);
		product.getCategories().add(category);
		productService.updateItem(product);
		return "redirect:/products/"+id;
	}
}
