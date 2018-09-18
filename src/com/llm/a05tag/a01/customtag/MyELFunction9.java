package com.llm.a05tag.a01.customtag;
/**
 * 自定义EL函数：
 * 步骤：
 * 1. 写一个public的类；
 * 2. 该类中写一个自定义的static的方法；
 * 3. 在tld文件中进行描述；
 * 4. 在jsp页面进行导入，就可以直接使用了。
 */

public class MyELFunction9 {
	
//	静态方法：还需要在tld中进行描述
	public static String contains(String str1, String str2){
		return str1 + str2;
	}
}
