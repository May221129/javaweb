package com.llm.a09fileupload.a01.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 这个代码是前期跟着尚硅谷的老师敲的。
 * 2018年6月29日有自己重敲一份，含简单的jsp页面：myTestWeb项目的a01uploadFile包。
 */
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	1. 获取请求信息：
		//1.3 利用commons-fileupload组件完成文件上传的基本效果：
		//① 得到FileItem的集合：
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//设置内存中最多可以存放的上传文件的大小, 若超出则把文件写到一个临时文件夹中. 以 byte 为单位
		factory.setSizeThreshold(1024 * 500);
		
		//设置一个临时文件夹
		File tempDirectory = new File("Q:\\tempDirectory");
		factory.setRepository(tempDirectory);
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//设置上传文件的总的大小. 也可以设置单个文件的大小. 
		upload.setSizeMax(1024 * 1024 * 5);
		
		try {
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);
			
			//② 遍历Item：若是一个一般的表单域，则打印信息：
			for(FileItem item : items){
				if(item.isFormField()){
					String name = item.getFieldName();
					String value = item.getString();
					System.out.println("^_^" + name + ":" + value);
				}else{
					//若是文件域，则把文件保存到Q:\\files目录下：
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contenType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					
					System.out.println("fieldName: " + fieldName);
					System.out.println("fileName:　" + fileName);
					System.out.println("contenType：　" + contenType);
					System.out.println("isInMemory：　" + isInMemory);
					
					InputStream in = item.getInputStream();
					byte [] buffer = new byte[1024];
					int len = 0;
					OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\" + fileName);
					while((len = in.read(buffer)) != -1){
						out.write(buffer, 0, len);
					}
					out.close();
					in.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		/**
		 * 1.1 不能再使用 request.getParameter() 等方式获取请求信息. 获取不到.
		 * 	      因为在uploadFile.jsp页面中，我们提交的不是单纯的from表单，而是加了enctype="multipart/form-data"的from表单。
		 *	      单纯的form表单的formBody中，是key-value的形式转为二进制通过网络传到服务器的;
		 *	      加了enctype="multipart/form-data"的form表单，会改变formBody中key-value的格式，将其变为一个整体的内容。
		 *	      注：enctype="multipart/form-data"的作用：做文件上传时必须要用到的。
		 */
//		String file = request.getParameter("file");
//		String desc = request.getParameter("desc");
//		System.out.println(file);
//		System.out.println(desc);
		
		/**
		 * 1.2 可以使用输入流的方式来获取. 但不建议这样做.因为二进制等文件处理起来太麻烦了:
		 */
//		InputStream in = request.getInputStream();
//		Reader reader = new InputStreamReader(in);
//		BufferedReader bufferedReader = new BufferedReader(reader);
//		
//		String str = null;
//		while((str = bufferedReader.readLine()) != null){
//			System.out.println(str); 
//		}
	}
}
