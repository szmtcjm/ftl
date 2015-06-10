package com.cjm;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Ftl {

	public static void main(String[] args) {
		String fmconfig = args[0];
		String dataModel = args[2];
		String templateName = args[1];
		
		Configuration cfg = new Configuration();
		
		String fullPath = "";
	    if ((!"".equals(fullPath)) && (fullPath.endsWith("ftl"))) {
		    cfg.setDirectoryForTemplateLoading(new File(fPath));
		    cfg.setAutoFlush(true);
		    cfg.setDefaultEncoding("UTF-8");
		    fullPath = fullPath.substring(1);
		    Template t = cfg.getTemplate(fullPath);
		    HashMap root = new HashMap();
		    // ×ª»»dataModelÎªMAP
		 	JSONParser parser = new JSONParser();
		 	Object parsedObject = null;
		 	
		 	Map<String, Object> obj = null;
		 	try {
		 	  obj = (Map<String, Object>) parser.parse(fmconfig);
		 	}catch (org.json.simple.parser.ParseException e) {
				e.printStackTrace();
				return;
			}
		 	
		 	
		    try {
		      parsedObject = parser.parse(dataModel);
		      Writer out = new OutputStreamWriter(System.out);
			  if(parsedObject instanceof JSONObject) {
				root = (HashMap) parsedObject;
				t.process(root, out);
			  }
		    } catch (TemplateException e) {
		      e.printStackTrace();
		    } catch (org.json.simple.parser.ParseException e) {
		      e.printStackTrace();
		    }finally {
		    }
	    
	  }
	}
}
