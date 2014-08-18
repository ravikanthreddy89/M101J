package org.ravikanth.mongodb;



import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloWorldFreeMarkerStyle {

	public static void main(String [] args){
		Configuration config=new Configuration();
		config.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");
		
		StringWriter writer=new StringWriter();
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("name", "Ravikanth");
		
		try {
			Template template=config.getTemplate("./hello.ftl");
			template.process(map, writer);
			System.out.println(writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
