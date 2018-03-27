package org.tysf.admin.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.tysf.admin.service.AdminProductService;
import org.tysf.admin.service.Impl.AdminProductServiceImpl;
import org.tysf.domain.Product;
import org.tysf.servlet.base.BaseServlet;
import org.tysf.utils.UUIDUtils;

@WebServlet("/adminProductServlet")
public class AdminProductServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	AdminProductService adminProductService = new AdminProductServiceImpl();

	/*
	 * 查询所有商品
	 */
	public void findAll(HttpServletRequest req, HttpServletResponse resp)throws SQLException, ServletException, IOException {
		List<Product> productList = adminProductService.findAll();
		req.setAttribute("productList", productList);
		req.getRequestDispatcher("/admin/product/list.jsp").forward(req, resp);

	}

	/*
	 * 添加商品
	 */
	public String add(HttpServletRequest req, HttpServletResponse resp)throws SQLException, IOException, ServletException {
		Product addProduct = fileUpload(req, resp);
		System.out.println("新添加的商品" + addProduct);
		List<Product> productList = adminProductService.add(addProduct);
		System.out.println("----------------");
		List<String> category = adminProductService.cid();
		req.setAttribute("category", category);
//		System.out.println(category);
//		System.out.println("添加后的商品列表" + productList);
		req.setAttribute("productList", productList);
		return "/admin/product/list.jsp";
	}

	/*
	 * 修改商品信息
	 */
	public void edit(HttpServletRequest req, HttpServletResponse resp) {
		
	}

	/*
	 * 删除商品
	 */
	public void delete(HttpServletRequest req, HttpServletResponse resp) {

	}

	/*
	 * 文件上传的方法
	 */
	public Product fileUpload(HttpServletRequest req, HttpServletResponse resp) {
		String pname = null;
		int is_hot = 1 ;
		double market_price = 0.0 ;
		double shop_price = 0.0 ;
		String pimage = null;
		String  pdesc = null;
		String cid = null;
		// 1.解析请求
		boolean isMultipar = ServletFileUpload.isMultipartContent(req);
		if (isMultipar) {
			// 2.创建工厂
			FileItemFactory factory = new DiskFileItemFactory();
			// 3.创建上传的解析
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(1024 * 1024 * 10);// 10M
			upload.setHeaderEncoding("utf-8");
			// 4.解析请求
			try {
				List<FileItem> itemList = upload.parseRequest(req);
				Iterator<FileItem> iter = itemList.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();
					/*
					 * 判断是普通的表单元素还是文件上传
					 */
					if (item.isFormField()) {
						// 处理普通表单元素
						try {
							String fieldName = item.getFieldName();
							String value = item.getString("utf-8");
							switch (fieldName) {
							case "pname":
								pname = value;
								System.out.println(pname);
								break;
							case "is_hot":
								is_hot = Integer.parseInt(value);
								break;
							case "market_price":
								market_price =Double.parseDouble(value);
								break;
							case "shop_price":
								shop_price = Double.parseDouble(value);
								break;
							case "pdesc":
								pdesc = value;
								break;
							case "cid":
								cid = value;
								break;
							}
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					} else {
						// 处理文件上传
						// String uploadFiledName = item.getFieldName();
						String fileName = item.getName();
						pimage = fileName;
						// String contentType = item.getContentType();
						// Long size = item.getSize();
						// int index = fileName.lastIndexOf("\\");
						// if (index != -1) {
						// fileName = fileName.substring(index + 1);
						// }
						System.out.println("文件名称" + fileName);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		System.out.println(pname+"-"+market_price+"-"+shop_price+"-"+pimage+"-"+is_hot+"-"+pdesc+"-"+cid);
		Product addProduct = new Product(UUIDUtils.getId(), pname, market_price, shop_price, pimage, new Date(), is_hot, pdesc, 1, cid);
		return addProduct;
	}
	
	
}
