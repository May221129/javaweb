package com.llm.a10.i18n;
/**
 * JavaWeb���ʻ�
 */

import java.util.Locale;
import java.util.ResourceBundle;
import org.junit.Test;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class I18nTest{
	
	/**
	 * ResourceBundle: ��Դ����.
	 * 1. ����·������Ҫ�ж�Ӧ����Դ�ļ�: baseName.properties. ���� baseName �ǻ���.
	 * 2. ����ʹ�� ����_���Դ���_���Ҵ���.properties ����Ӳ�ͬ���һ��������Դ�ļ�. i18n_zh_CN.properties
	 * 3. Ҫ�����л�����ͬ����Դ�ļ��� key ������ȫһ��. 
	 * 4. ����ʹ�� native2ascii �������õ� ���� ��һ���� asc ��. Eclipse �����˹���
	 * 5. ���Ե��� ResourceBundle �� getBundle(����, Locale ʵ��) ��ȡ��ȡ ResourceBundle ����
	 * 6. ���Ե��� ResourceBundle �� getString(key) ����ȡ��Դ�ļ��� value �ַ�����ֵ. 
	 * 7. ��� DateFormat, NumberFormat, MessageFormat ����ʵ�ֹ��ʻ�. 
	 */
	@Test
	public void testResourceBundle(){
		Locale locale = Locale.CHINA;//����locale��̬�Ķ�λ����Դ�ļ�
		ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n", locale);
	
//		System.out.println(resourceBundle.getString("date"));
//		System.out.println(resourceBundle.getString("salary"));
		
		String dateLabel = resourceBundle.getString("date");
		String salLabel = resourceBundle.getString("salary");
		
		String str = "{0}:{1}, {2}:{3}";
		
		Date date = new Date();
		double sal = 12345.12;
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		String dateStr = dateFormat.format(date);
		
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		String salStr = numberFormat.format(sal);
		
		String result = MessageFormat.format(str, dateLabel, dateStr, salLabel, salStr);
		System.out.println(result); 
	}
	
	
	/**
	 * MessageFormat: ���Ը�ʽ��ģʽ�ַ���
	 * ģʽ�ַ���: ��ռλ�����ַ���: "Date: {0}, Salary: {1}"
	 * ����ͨ�� format ������ģʽ�ַ������и�ʽ��
	 */
	@Test
	public void testMessageFormat(){
		String str = "Date:{0},Salary:{1}";
		
		Locale locale = Locale.CHINA;
		Date date = new Date();
		double sal = 12345.12;//salary,нˮ
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		String dateStr = dateFormat.format(date);
		
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		String salStr = numberFormat.format(sal);
		
		String result = MessageFormat.format(str, dateStr, salStr);
		System.out.println(result); 
	}
	
	/**
	 * NumberFormat: ��ʽ�����ֵ������ַ���, ������ַ����Ĺ�����
	 * 1. ͨ������������ȡ NumberFormat ����
	 * 	NumberFormat.getNumberInstance(locale); //����ʽ��Ϊ���ֵ��ַ���
	 * 	NumberFormat.getCurrencyInstance(locale); //��ʽΪ���ҵ��ַ���
	 * 2. ͨ�� format ���������и�ʽ��
	 * 3. ͨ�� parse ������һ���ַ�������Ϊһ�� Number ����. 
	 */
	@Test
	public void testNumberFormat() throws ParseException{
		//ת��ʱ�䣺
		double d = 123456789.123d;
		Locale locale = Locale.CHINA;//ָ������
		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		String str = numberFormat.format(d);
		System.out.println(str);
		
		//ת�����ң�
		NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(locale);
		str = numberFormat2.format(d);
		System.out.println(str);
		System.out.println("----------");
		
//		������ת��
		str = "123,456,789.123";
		d = (double) numberFormat.parse(str);
		System.out.println(d);
		
		str="��123,456,789.123";
		d = (double) numberFormat2.parse(str);
		System.out.println(d);
	}
	/**
	 * DateFormat: ��ʽ�����ڵĹ�����. ������һ��������. 
	 * 
	 * 1. ��ֻϣ��ͨ�� DateFormat ��һ�� Date ����תΪһ���ַ���, �����ͨ�� DateFormat �Ĺ�����������ȡ DateFormat ����
	 * 2. ���Ի�ȡֻ��ʽ�� Date�� DateFormat ����: getDateInstance(int style, Locale aLocale) 
	 * 3. ���Ի�ȡֻ��ʽ�� Time�� DateFormat ����: getTimeInstance(int style, Locale aLocale) 
	 * 4. ���Ի�ȡ�ȸ�ʽ�� Date, Ҳ��ʽ�� Time �� DateFormat����: getDateTimeInstance(int dateStyle, int timeStyle, Locale aLocale) 
	 * 		���� style ����ȡֵΪ:DateFormat �ĳ���: SHORT, MEDIUM, LONG, FULL. Locale ��Ϊ������ҵ����� Locale ����
	 * 5. ͨ�� DateFormat�� format��������ʽ���� Date �����ַ���. 
	 * 6. ����һ���ַ���, ��ν���Ϊһ�� Date ������ ? 
	 * 	�� �ȴ��� DateFormat ����: ���� DateFormat ������ SimpleDateFormat ����
	 * 		SimpleDateFormat(String pattern). ���� pattern Ϊ����, ʱ��ĸ�ʽ, ����: yyyy-MM-dd hh:mm:ss
	 * 	�� ���� DateFormat �� parse �����������ַ����� Date ����.  
	 */
//	ʹ��DateFormat�ࣺ����һ���ַ�����������ַ�����ΪDate���ͣ�
	@Test
	public void testDateFormat2() throws ParseException{
		String str = "1990-11-22 11:22:22";
		//��Ҫָ��������ʽ��
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date date = dateFormat.parse(str);
		System.out.println(date);
	}
	
//	ʹ��DateFormat�ࣺ������תΪ��Ӧ���ҵ��ַ���
	@Test
	public void testDateFormat(){
		Locale locale = Locale.CHINA;
		
		Date date = new Date();
		System.out.println(date);
		
		//��ȡDateFormat����,���������locale����������ڵĸ�ʽ����
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, locale);
		String str = dateFormat.format(date);
		System.out.println(str);
	}
	
	/**
	 * Locale: Java�б�ʾ���һ��������. JDK ���ṩ�˺ܶೣ��.
	 * Ҳ����ͨ�� Locale(languageCode, countryCode) �ķ�ʽ������ 
	 * �� WEB Ӧ���п���ͨ�� request.getLocale() ��������ȡ. 
	 */
	@Test
	public void testLoacle(){
		//�ڳ����У�ͨ�� . �ķ�ʽ����ȡLocale
		Locale locale = Locale.CHINA;
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
		System.out.println("----------");
		
		//�Լ�����Locale����ָ�����Ժ͹���
		locale = new Locale("en", "US");
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
	}
}