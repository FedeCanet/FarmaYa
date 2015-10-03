package com.is3;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Parameters{
	
	public static String getParameter(String key){
		String value = null; 
	    SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File( "src\\META-INF\\parameters.xml" );
	    try
	    {
	        Document document = (Document) builder.build( xmlFile );
	 
	        Element rootNode = document.getRootElement();
	 
	        List list = rootNode.getChildren(key);
	
	        for ( int i = 0; i < list.size(); i++ )
	        {
	        	Element tabla = (Element) list.get(i);
	 
	        	value = tabla.getText();
	        }
	    }catch ( IOException io ) {
	        System.out.println( io.getMessage() );
	    }catch ( JDOMException jdomex ) {
	        System.out.println( jdomex.getMessage() );
	    }
	    return value;
	}
}