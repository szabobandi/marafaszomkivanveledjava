package mar.faszom.kivan.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletResponse;

import mar.faszom.kivan.domain.Product;
import mar.faszom.kivan.domain.ProductCatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductCatalog catalog;

	@RequestMapping("list")
	public String list(Model model) {

		model.addAttribute("products", catalog.getProducts());
		return "listProducts";
	}

	@RequestMapping("form")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "newProduct";
	}

	@RequestMapping("add")
	public String add(@ModelAttribute Product product, BindingResult bindingResult, Model model) {
		bindingResult.addError(new FieldError("product", "name", "nem tetszik"));
		if (bindingResult.hasErrors()) {
			model.addAttribute("errorMsg", "baj van ...");
			return "newProduct";
		}

		catalog.addProduct(product);

		return "redirect:/product/list";
	}

	@RequestMapping("edit")
	public String edit(Model model, @RequestParam Long id) {

		Product product = catalog.findById(id);
		model.addAttribute("product", product);

		return "editProduct";
	}

	@RequestMapping("delete")
	public String delete(Model model, @RequestParam Long id) {

		catalog.deleteProduct(id);
		return "redirect:/product/list";
	}

	@RequestMapping(value="search", method=RequestMethod.GET)
	public String searchForm() {
		return "searchForm";
	}

	@RequestMapping(value="search", method=RequestMethod.POST)
	public String search(@RequestParam Integer maxPrice, Model model) {
		List<Product> products = catalog.findByMaxPrice(maxPrice);
		model.addAttribute("products", products);

		return "searchResult";
	}


	@RequestMapping("save")
	public String save(@ModelAttribute Product product, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "editProduct";
		}
		catalog.addProduct(product);
		return "redirect:/product/list";
	}

	@RequestMapping("{productId}")
	public void jsonProduct(@PathVariable Integer productId, ServletResponse resp) {
		try {
			resp.getWriter().print("{id='" + productId + "', name='vodor'}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@ExceptionHandler(Exception.class)
	public String bajVan() {

		return "newProduct";
	}

}