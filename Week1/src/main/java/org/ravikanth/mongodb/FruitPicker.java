package org.ravikanth.mongodb;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FruitPicker {

	public static void main(String [] args){

		final Configuration config=new Configuration();
		config.setClassForTemplateLoading(FruitPicker.class, "/");
		
		
		Spark.get(new Route("/"){
			@Override
			public Object handle(Request arg0, Response arg1) {
				// TODO Auto-generated method stub
				Template template;
				StringWriter writer=null;
				try {
					template = config.getTemplate("./fruitPicker.ftl");
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("favouriteFruits", Arrays.asList("apple", "orange", "banana", "pineapple"));
					//map.put("fruits", "apple");
					writer=new StringWriter();
					template.process(map,writer);
					return writer;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TemplateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return writer;
		}});
		
		Spark.post(new Route("/fruitPicker"){
			@Override
			public Object handle(Request request, Response response) {
				// TODO Auto-generated method stub
				String query=request.queryParams("fruit");
				if(query==null) return "Please go back and choose one fruit.";
				return "You picked "+query;
			}
			
		});
		
	   }
}
