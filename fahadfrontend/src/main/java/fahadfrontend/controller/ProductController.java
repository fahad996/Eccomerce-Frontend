package fahadfrontend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fahadbackend.dao.CategoryDAO;
import com.fahadbackend.dao.ProductDAO;
import com.fahadbackend.model.Category;
import com.fahadbackend.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping("/product")
	public String showProduct(Model m)
	{
		Product product = new Product();
	    m.addAttribute(product);
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		m.addAttribute("categoryList", this.getCategories());
		m.addAttribute("pageinfo", "Manage Product-");
		
		
		return "Product";
		
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product, @RequestParam("pimage")MultipartFile filedet, Model m)
	{
		productDAO.addProduct(product);
		
		Product product1 = new Product();
		m.addAttribute(product1);
		m.addAttribute("pageinfo" , "Manage Product-");
		m.addAttribute("categoryList", this.getCategories());
		
		String imagepath = "F:\\eclipse\\maven-frontend\\frontend\\src\\main\\resources";
		imagepath = imagepath+String.valueOf(product.getProductId())+ ".png";
		
		File image = new File(imagepath);
		
		if(!filedet.isEmpty())
		{
			try 
			{
				byte buff[] = filedet.getBytes();
				FileOutputStream fos = new FileOutputStream(image);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(buff);
				bs.close();
 			}
			catch(Exception e)
			{
				m.addAttribute("errorInfo" , "Exception Occured during Image Uploading:" + e.getMessage());
			}
		}
		else 
		{
			m.addAttribute("errorInfo" , "Problem Occured during Image Uploading:");
			
		}
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
		return "Product";
		
	}
	
	@RequestMapping(value="/UpdateProduct" , method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product, Model m)
	{
		productDAO.updateProduct(product);
		
		Product product1 = new Product();
		m.addAttribute(product1);
		
		m.addAttribute("pageinfo" , "Manage Product-");
		m.addAttribute("categoryList", this.getCategories());
		
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
		return "Product";
		
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product = productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		Product product1 = new Product();
		m.addAttribute(product1);
		
		m.addAttribute("pageinfo" , "Manage Product-");
		m.addAttribute("categoryList", this.getCategories());
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
		return "Product";
		
	}
	

	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product = productDAO.getProduct(productId);
		m.addAttribute(product);
		
		m.addAttribute("pageinfo" , "Manage Product-");
		m.addAttribute("categoryList", this.getCategories());
		
		return "UpdateProduct";
		
	}
	
	@RequestMapping(value="/productDisplay")
	public String displayAllProduct(Model m)
	{
		m.addAttribute("pageinfo" , "Product Catalog-");
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
		return "ProductDisplay";
		
	}
	
	@RequestMapping(value="/totalProductDisplay/{productId}")
	public String totalProductDisplay(@PathVariable("productId")int productId , Model m)
	{
		m.addAttribute("pageinfo", "Product Info-");
		Product product = productDAO.getProduct(productId);
		m.addAttribute("product", product);
		
		return "TotalProductDisplay";
	}
	
	public LinkedHashMap<Integer,String> getCategories()
	{
		List<Category> listcategories = categoryDAO.listCategories();
		LinkedHashMap<Integer,String> categoryList = new LinkedHashMap<Integer,String>();
		for(Category category:listcategories)
		{
			categoryList.put(category.getCategoryID(), category.getCategoryName());
		}
		
		return categoryList;
		
	}
	

}
