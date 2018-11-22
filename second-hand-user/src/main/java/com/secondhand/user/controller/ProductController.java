package com.secondhand.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.secondhand.user.dto.ProductDto;
import com.secondhand.user.entity.FirstCategory;
import com.secondhand.user.entity.Product;
import com.secondhand.user.entity.SecondCategory;
import com.secondhand.user.entity.Seller;
import com.secondhand.user.entity.User;
import com.secondhand.user.service.BuycarService;
import com.secondhand.user.service.CategoryService;
import com.secondhand.user.service.ProductService;

/**
 * 商品controller
 * @author Administrator
 *
 */
@Controller
public class ProductController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BuycarService buycarService;
	
/*	@RequestMapping(value="/allProducts")
	public String findAllProducts(Model model){
		List<Product> list = productService.findAllProducts();
		model.addAttribute("products",list);
		return "forward:/index";
	}*/
	/**
	 * 根据二级分类分页查询商品列表
	 * @param scid 二级分类id
	 * @param page 当前页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{scid}/{page}/products")
	public String category(@PathVariable("scid") Integer scid,@PathVariable("page") Integer page,Model model){
		int pieces = 10;
		int start = (page-1)*pieces;
		ProductDto productDto = productService.findProductsByScid(scid,start,pieces);
		model.addAttribute("page", page);
		model.addAttribute("productDto",productDto);
		return "product/list";
	}
	
	/**
	 * 根据商品id查询商品详细信息
	 * @param pid
	 * @param model
	 * @return
	 */
//	@RequestMapping(value="/{pid}/detail")
//	public String detail(@PathVariable("pid") Integer pid,Model model){
//		Product product = productService.findProductByPid(pid);
//		model.addAttribute("product", product);
//		return "product/detail";
//	}
	/**
	 * 根据商品id查询商品详细信息,先判断用户是否登录，购物车中是否有该商品，如果有就要商品库存量-购物车中商品数量来显示商品剩余，没有就直接显示商品库存量
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{pid}/detailProduct")
	public String detail(@PathVariable("pid") Integer pid,HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Product product = productService.findProductByPid(pid);
		if(user == null){
			request.setAttribute("product", product);
			return "product/detail";
		}
		else{
			Integer stock = buycarService.countFromBuycar(user.getUid(), pid);
			if(stock == null){
				request.setAttribute("product", product);
				return "product/detail";
			}else{
				stock = product.getStock() - stock;
				if(stock<0){
					product.setStock(0);
					request.setAttribute("product", product);
					return "product/detail";
				}else {
					product.setStock(stock);
					request.setAttribute("product", product);
					return "product/detail";
				}
			}
		}
	}
	
	//根据关键字模糊查询商品列表(通过搜索框搜索)
	@RequestMapping(value="/{page}/nameLikeProducts",method=RequestMethod.POST)
	public String nameLikeProducts(@PathVariable("page")Integer page,String pname,Model model){
		int pieces = 10;
		int start = (page-1)*pieces;
		ProductDto productDto = productService.findProductsLikePname(pname,start,pieces);
		model.addAttribute("page",page);
		model.addAttribute("pname",pname);
		model.addAttribute("productDto", productDto);
		return "product/pnameList";
	}
	
	//根据关键字模糊查询商品列表(分页查询)
	@RequestMapping(value="/{page}/{pname}/nameLikeProducts")
	public String nameLikeProductsPage(@PathVariable("page")Integer page,@PathVariable("pname") String pname,Model model){
		int pieces = 10;
		int start = (page-1)*pieces;
		ProductDto productDto = productService.findProductsLikePname(pname,start,pieces);
		model.addAttribute("page",page);
		model.addAttribute("pname",pname);
		model.addAttribute("productDto", productDto);
		return "product/pnameList";
	}
	
//	@RequestMapping(value="/{pid}/detailProduct")
//	public String detailProduct(@PathVariable("pid") Integer pid,Model model){
//		Product product = productService.findProductByPid(pid);
//		model.addAttribute("product", product);
//		return "product/detail";
//	}
	
	//卖者模糊查询自己的闲置(通过搜索框)
	@RequestMapping(value="/{page}/nameLikeProductsBySid")
	public String nameLikeProductsBySid(@PathVariable("page") Integer page, String pname, HttpServletRequest request){
		Seller seller = (Seller)request.getSession().getAttribute("seller");
		Integer sid = seller.getSid();
		ProductDto productDto = productService.findNameLikeProductsBySid(pname,sid,page);
		request.setAttribute("pname", pname);
		request.setAttribute("page", page);
		request.setAttribute("productDto", productDto);
		return "seller/nameLikeList";
		
	}
	
	//卖者模糊查询自己的闲置(通过分页)
	@RequestMapping(value="/{page}/{pname}/nameLikeProductsBySid")
	public String nameLikeProductsBySidPage(@PathVariable("page") Integer page, @PathVariable("pname")String pname, HttpServletRequest request){
		Seller seller = (Seller)request.getSession().getAttribute("seller");
		Integer sid = seller.getSid();
		ProductDto productDto = productService.findNameLikeProductsBySid(pname,sid,page);
		request.setAttribute("pname", pname);
		request.setAttribute("page", page);
		request.setAttribute("productDto", productDto);
		return "seller/nameLikeList";
		
	}
	
	//前往更新商品信息页面，将商品信息回显在表单上
	@RequestMapping(value="/{pid}/toUpdateProduct")
	public String toUpdateProduct(@PathVariable("pid") Integer pid,Model model){
		Product product = productService.toUpdateProduct(pid);
		List<FirstCategory> fcList = categoryService.findAllCategory();
		Integer fcid = product.getFcid();
		List<SecondCategory> scList = categoryService.getSecondCategory(fcid);
		model.addAttribute("scList", scList);
		model.addAttribute("fcList", fcList);
		model.addAttribute("product", product);
		return "seller/productDetail";
	}
	
	//验证商品信息，更新商品信息
	@RequestMapping(value="/{pid}/updateProduct")
	public String updateProduct(@PathVariable Integer pid,Double price,Integer stock,Product product,MultipartFile pic,HttpServletRequest request){
		Seller seller = (Seller)request.getSession().getAttribute("seller");
		if(seller == null){
			return "seller/login";
		}else{
			Integer sid = seller.getSid();
			product.setSid(sid);
			String pname = product.getPname();
			if(pname==null||pname.trim().length()==0){
				request.setAttribute("msg", "商品名不能为空");
				return "forward:/"+pid+"/toUpdateProduct";
			}
			else if(price == null || price <= 0){
				request.setAttribute("msg", "价格不能为负数或为空");
				return "forward:/"+pid+"/toUpdateProduct";
			}else if(stock == null || stock<=0){
				request.setAttribute("msg", "库存不能为负数或为空");
				return "forward:/"+pid+"/toUpdateProduct";
			}else if(pic.getSize() != 0){
					String path = null;
					String type = null;
					String filename = pic.getOriginalFilename();
					type = filename.indexOf(".")!=-1?filename.substring(filename.lastIndexOf(".")+1,filename.length()):null;
					if(type != null){
						if("GIF".equalsIgnoreCase(type)||"PNG".equalsIgnoreCase(type)||"jpg".equalsIgnoreCase(type)){
							String realPath = request.getSession().getServletContext().getRealPath("/");
							String picname = String.valueOf(System.currentTimeMillis())+"."+type;
							path = realPath+"resources\\images\\"+picname;
							try {
								pic.transferTo(new File(path));
								product.setApicname(picname);
							} catch (IllegalStateException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}else{
							request.setAttribute("msg", "文件格式错误");
							return "forward:/"+pid+"/toUpdateProduct";
						}
					}else{
						request.setAttribute("msg", "文件类型为空");
						return "forward:/"+pid+"/toUpdateProduct";
					}
			}else{
				product.setPrice(price);
				product.setStock(stock);
				productService.updateProduct(product);
				return "redirect:/seller/"+1+"/sellerindex";
			}
		}
		product.setPrice(price);
		product.setStock(stock);
		productService.updateProduct(product);
		return "redirect:/seller/"+1+"/sellerindex";
	}
	
	//下架商品
	@RequestMapping(value="/{pid}/deleteProduct")
	public String deleteProduct(@PathVariable("pid") Integer pid){
		productService.deleteProduct(pid);
		return "redirect:/seller/"+1+"/sellerindex";
	}
	
	//前往添加商品页面
	@RequestMapping(value="/toAddProduct")
	public String toAddProduct(HttpServletRequest request){
		Seller seller = (Seller)request.getSession().getAttribute("seller");
		if(seller == null){
			return "seller/login";
		}else{
			List<FirstCategory> fcList = categoryService.findAllCategory();
			List<SecondCategory> scList = categoryService.getSecondCategory(1);
			request.setAttribute("fcList", fcList);
			request.setAttribute("scList", scList);
			return "seller/addProduct";
		}
	}
	
	//验证商品信息，添加商品
	@RequestMapping(value="/addProduct")
	public String addProduct(Product product,MultipartFile pic,HttpServletRequest request){
		if(product == null){
			request.setAttribute("msg", "闲置信息不能为空");
			return "redirect:/toAddProduct";
		}
		Seller seller = (Seller)request.getSession().getAttribute("seller");
		if(seller == null){
			return "seller/login";
		}else{
			Integer sid = seller.getSid();
			product.setSid(sid);
			String pname = product.getPname();
			Double price = product.getPrice();
			Integer stock = product.getStock();
			if(pname==null||pname.trim().length()==0){
				request.setAttribute("msg", "商品名不能为空");
				request.setAttribute("product", product);
				return "forward:/toAddProduct";
			}
			else if(price == null){
				request.setAttribute("msg", "价格不能为空");
				request.setAttribute("product", product);
				return "forward:/toAddProduct";
			}else if(stock == null){
				request.setAttribute("msg", "库存不能为空");
				request.setAttribute("product", product);
				return "forward:/toAddProduct";
			}else if(pic.getSize() == 0){
				request.setAttribute("msg", "请上传图片");
				request.setAttribute("product", product);
				return "forward:/toAddProduct";
			}else{
				String path = null;
				String type = null;
				String filename = pic.getOriginalFilename();
				type = filename.indexOf(".")!=-1?filename.substring(filename.lastIndexOf(".")+1,filename.length()):null;
				if(type != null){
					if("GIF".equalsIgnoreCase(type)||"PNG".equalsIgnoreCase(type)||"jpg".equalsIgnoreCase(type)){
						String realPath = request.getSession().getServletContext().getRealPath("/");
						String picname = String.valueOf(System.currentTimeMillis())+"."+type;
						path = realPath+"resources\\images\\"+picname;
						try {
							pic.transferTo(new File(path));
							product.setApicname(picname);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else{
						request.setAttribute("msg", "文件格式错误");
						request.setAttribute("product", product);
						return "forward:/toAddProduct";
					}
				}else{
					request.setAttribute("msg", "文件类型为空");
					request.setAttribute("product", product);
					return "forward:/toAddProduct";
				}
				product.setSid(sid);
				productService.addProduct(product);
				return "redirect:/seller/"+1+"/sellerindex";
			}
		}
	}
}
