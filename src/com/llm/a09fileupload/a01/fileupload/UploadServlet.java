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
 * ���������ǰ�ڸ����й�ȵ���ʦ�õġ�
 * 2018��6��29�����Լ�����һ�ݣ����򵥵�jspҳ�棺myTestWeb��Ŀ��a01uploadFile����
 */
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	1. ��ȡ������Ϣ��
		//1.3 ����commons-fileupload�������ļ��ϴ��Ļ���Ч����
		//�� �õ�FileItem�ļ��ϣ�
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//�����ڴ��������Դ�ŵ��ϴ��ļ��Ĵ�С, ����������ļ�д��һ����ʱ�ļ�����. �� byte Ϊ��λ
		factory.setSizeThreshold(1024 * 500);
		
		//����һ����ʱ�ļ���
		File tempDirectory = new File("Q:\\tempDirectory");
		factory.setRepository(tempDirectory);
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//�����ϴ��ļ����ܵĴ�С. Ҳ�������õ����ļ��Ĵ�С. 
		upload.setSizeMax(1024 * 1024 * 5);
		
		try {
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);
			
			//�� ����Item������һ��һ��ı������ӡ��Ϣ��
			for(FileItem item : items){
				if(item.isFormField()){
					String name = item.getFieldName();
					String value = item.getString();
					System.out.println("^_^" + name + ":" + value);
				}else{
					//�����ļ�������ļ����浽Q:\\filesĿ¼�£�
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contenType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					
					System.out.println("fieldName: " + fieldName);
					System.out.println("fileName:��" + fileName);
					System.out.println("contenType����" + contenType);
					System.out.println("isInMemory����" + isInMemory);
					
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
		 * 1.1 ������ʹ�� request.getParameter() �ȷ�ʽ��ȡ������Ϣ. ��ȡ����.
		 * 	      ��Ϊ��uploadFile.jspҳ���У������ύ�Ĳ��ǵ�����from�������Ǽ���enctype="multipart/form-data"��from����
		 *	      ������form����formBody�У���key-value����ʽתΪ������ͨ�����紫����������;
		 *	      ����enctype="multipart/form-data"��form������ı�formBody��key-value�ĸ�ʽ�������Ϊһ����������ݡ�
		 *	      ע��enctype="multipart/form-data"�����ã����ļ��ϴ�ʱ����Ҫ�õ��ġ�
		 */
//		String file = request.getParameter("file");
//		String desc = request.getParameter("desc");
//		System.out.println(file);
//		System.out.println(desc);
		
		/**
		 * 1.2 ����ʹ���������ķ�ʽ����ȡ. ��������������.��Ϊ�����Ƶ��ļ���������̫�鷳��:
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
