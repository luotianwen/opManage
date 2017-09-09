package com.op.util;

import java.lang.reflect.Field;

public class GetField {

	 public static void main(String[] args) {
	  try {
	   Class clazz = Class.forName("com.op.dto.order.ActivityRefundOrdersDTO");//根据类名获得其对应的Class对象 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
	   Field[] fields = clazz.getDeclaredFields();//根据Class对象获得属性 私有的也可以获得
	   for(Field f : fields) {
	    System.out.print(f.getName()+",");//打印每个属性的类型名字
	   }
	  } catch(Exception e) {
	   e.printStackTrace();
	  }
	  
	 }
	}
