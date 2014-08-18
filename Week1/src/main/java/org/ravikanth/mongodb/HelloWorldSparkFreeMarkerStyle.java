package org.ravikanth.mongodb;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloWorldSparkFreeMarkerStyle {
	
	public static void main(String [] args){
		
		final Configuration config=new Configuration();
		config.setClassForTemplateLoading(HelloWorldSparkFreeMarkerStyle.class, "/");
		
		Spark.get(new Route("/"){

			@Override
			public Object handle(Request arg0, Response arg1) {
				// TODO Auto-generated method stub
				StringWriter writer=new StringWriter();
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("name", "Ravikanth Garu!!");
				
				try {
					Template template=config.getTemplate("./hello.ftl");
					
					template.process(map, writer);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TemplateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return writer;
			}});
	}

}
