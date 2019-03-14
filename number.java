package number;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class number {

    public static void main(String[] args) {
    	String dirname = "C:/Users/njucslab/Desktop/layout";
    	File f1 = new File(dirname);
    	if(f1.isDirectory()) {
    	String s[] = f1.list();
    	for(int i=0; i < s.length;i++) {
    	String filePath = dirname + '/' + s[i];
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            //update attribute value
            updateColor(doc);
            updateSize(doc);
            updateVisibility(doc);
            
            //write the updated document to file or console
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML file updated successfully" + filePath);

        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
            e1.printStackTrace();
        }
    	}
    	}
    }


    
  

    
    private static double getDoubleValue(String str)
    {
     double d = 0;  
     
     if(str!=null && str.length()!=0)
     {
      StringBuffer bf = new StringBuffer();
      
      char[] chars = str.toCharArray();
      for(int i=0;i<chars.length;i++)
      {
       char c = chars[i];   
       if(c>='0' && c<='9') 
       {
        bf.append(c);
       }
       else if(c=='.')
       {
        if(bf.length()==0)
        {
         continue;
        }
        else if(bf.indexOf(".")!=-1)
        {
         break;
        }
        else
        {
         bf.append(c);
        }
       }    
       else
       {
        if(bf.length()!=0)
        {
         break;
        }
       }
      }
      try
      {
       d = Double.parseDouble(bf.toString());
      }
      catch(Exception e)
      {}
     }
     
     return d;
    } 
    
    
    
    private static void updateVisibility(Document doc) {
    	int qq = 0;
    /*	try {
    		NodeList Llay = doc.getElementsByTagName("TextView");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:padding")) {
    				//if(L.hasAttribute("android:visibility")) {
    					
    
    					Element tmp = doc.createElement("TextView");
    				
    					double padding = getDoubleValue(L.getAttribute("android:padding"));
    		
    					padding = padding * Math.random();

    					
    					L.setAttribute("andriod:padding", String.format("%.1f", padding));
    					tmp.setAttribute("android:background", "#11111111");
    					tmp.setAttribute("android:layout_width", L.getAttribute("android:layout_width"));
    					tmp.setAttribute("android:layout_height", L.getAttribute("android:layout_height"));
    					tmp.setAttribute("android:id", "@+id/x" + qq);
    					
    					qq++;

    				//	L.appendChild(tmp);
    					
    					//System.out.println("here");
    				
    				//}
    			}
    		
    		}
    	}catch(StringIndexOutOfBoundsException e1) {
        		;
        }
    	
    */	
    	/*
    	try {
    		NodeList Llay = doc.getElementsByTagName("RelativeLayout");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.getAttribute("android:layout_width").equals("0.0dip")==false) {
    				//if(L.hasAttribute("android:visibility")) {
    					Element tmp = doc.createElement("RelativeLayout");
    				
    					//System.out.println(tmp.getAttribute("android:visibility"));
    					//tmp.setAttribute("android:visibility", "gone");
    					tmp.setAttribute("android:background", "#11111111");
    					tmp.setAttribute("android:layout_width", L.getAttribute("android:layout_width"));
    					tmp.setAttribute("android:layout_height", L.getAttribute("android:layout_height"));
    					tmp.setAttribute("android:id", "@+id/x"+qq);
    					qq++;
    					Node parent = L.getParentNode();
    				//	parent.insertBefore(tmp,L.getNextSibling());
    					
    					parent.insertBefore(tmp, L);
    					//System.out.println("here");
    				
    				//}
    			}
    		
    		}
    	}catch(StringIndexOutOfBoundsException e1) {
        		;
        }
    	
    	
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("FrameLayout");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.getAttribute("android:layout_width").equals("0.0dip")==false) {
    			//	if(L.hasAttribute("android:visibility")) {
    					Element tmp = doc.createElement("FrameLayout");
    				
    					//System.out.println(tmp.getAttribute("android:visibility"));
    					tmp.setAttribute("android:background", "#11111111");
    					//tmp.setAttribute("android:visibility", "gone");
    					tmp.setAttribute("android:layout_width", L.getAttribute("android:latout_width"));
    					tmp.setAttribute("android:layout_height", L.getAttribute("android:layout_height"));
    					tmp.setAttribute("android:id", "@+id/x"+qq);
    					qq++;
    					Node parent = L.getParentNode();
    					parent.insertBefore(tmp,L);
    					
    					//System.out.println("here");
    				
    			//	}
    			}
    		
    		}
    	}catch(StringIndexOutOfBoundsException e1) {
        		;
        }
    	
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("ImageView");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.getAttribute("android:layout_width").equals("0.0dip")==false) {
    				//if(L.hasAttribute("android:visibility")) {
    					Element tmp = doc.createElement("ImageView");
    				
    					//System.out.println(tmp.getAttribute("android:visibility"));
    					//tmp.setAttribute("android:visibility", "gone");
    					tmp.setAttribute("android:background", "#11111111");
    					tmp.setAttribute("android:layout_width", L.getAttribute("android:layout_width"));
    					tmp.setAttribute("android:layout_height", L.getAttribute("android:layout_height"));
    					tmp.setAttribute("android:id", "@+id/x"+qq);
    					qq++;
    					Node parent = L.getParentNode();
    					parent.insertBefore(tmp,L);
    					
    					//System.out.println("here");
    				
    	//			}
    			}
    		
    		}
    	}catch(StringIndexOutOfBoundsException e1) {
        		;
        }
    	
    	
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("TextView");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:padding")) {
    	//			if(L.hasAttribute("android:visibility")) {
    					Element tmp = doc.createElement("TextView");
    					double padding = getDoubleValue(L.getAttribute("android:padding"));
    					padding = padding * Math.random();
    					//System.out.println(tmp.getAttribute("android:visibility"));
    					tmp.setAttribute("andriod:padding", String.format("%.1f", padding));
    					tmp.setAttribute("android:background", "#11111111");
    					tmp.setAttribute("android:layout_width", L.getAttribute("android:layout_width"));
    					tmp.setAttribute("android:layout_height", L.getAttribute("android:layout_height"));
    					tmp.setAttribute("android:id", "@+id/x"+qq);
    					qq++;
    					Node parent = L.getParentNode();
    					parent.insertBefore(tmp,L);
    					
    					//System.out.println("here");
    				
    //				}
    			}
    		
    		}
    	}catch(StringIndexOutOfBoundsException e1) {
        		;
        }
    	
    	
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("GridView");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.getAttribute("android:layout_width").equals("0.0dip")==false) {
    			//	if(L.hasAttribute("android:visibility")) {
    					Element tmp = doc.createElement("GridView");
    				
    					//System.out.println(tmp.getAttribute("android:visibility"));
    					tmp.setAttribute("android:background", "#11111111");
    					tmp.setAttribute("android:layout_width", L.getAttribute("android:layout_width"));
    					tmp.setAttribute("android:layout_height", L.getAttribute("android:layout_height"));
    					tmp.setAttribute("android:id", "@+id/x"+qq);
    					qq++;
    					Node parent = L.getParentNode();
    					parent.insertBefore(tmp,L);
    					
    					//System.out.println("here");
    				
    			//	}
    			}
    		
    		}
    	}catch(StringIndexOutOfBoundsException e1) {
        		;
        }
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("ListView");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.getAttribute("android:layout_width").equals("0.0dip")==false) {
    			//	if(L.hasAttribute("android:visibility")) {
    					Element tmp = doc.createElement("ListView");
    				
    					//System.out.println(tmp.getAttribute("android:visibility"));
    					tmp.setAttribute("android:background", "#11111111");
    					tmp.setAttribute("android:layout_width", L.getAttribute("android:layout_width"));
    					tmp.setAttribute("android:layout_height", L.getAttribute("android:layout_height"));
    					tmp.setAttribute("android:id", "@+id/x"+qq);
    					qq++;
    					Node parent = L.getParentNode();
    					parent.insertBefore(tmp,L);
    					
    					//System.out.println("here");
    				
    			//	}
    			}
    		
    		}
    	}catch(StringIndexOutOfBoundsException e1) {
        		;
        }
    	
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("view");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.getAttribute("android:layout_width").equals("0.0dip")==false) {
    				//if(L.hasAttribute("android:visibility")) {
    					Element tmp = doc.createElement("view");
    				
    					//System.out.println(tmp.getAttribute("android:visibility"));
    					tmp.setAttribute("android:background", "#11111111");
    					tmp.setAttribute("android:layout_width", L.getAttribute("android:layout_width"));
    					tmp.setAttribute("android:layout_height", L.getAttribute("android:layout_height"));
    					tmp.setAttribute("android:id", "@+id/x"+qq);
    					qq++;
    					Node parent = L.getParentNode();
    					parent.insertBefore(tmp,L);
    					
    					//System.out.println("here");
    				
    				//}
    			}
    		
    		}
    	}catch(StringIndexOutOfBoundsException e1) {
        		;
        }
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("View");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.getAttribute("android:layout_width").equals("0.0dip")==false) {
    			//	if(L.hasAttribute("android:visibility")) {
    					Element tmp = doc.createElement("View");
    				
    					//System.out.println(tmp.getAttribute("android:visibility"));
    					tmp.setAttribute("android:background", "#11111111");
    					tmp.setAttribute("android:layout_width", L.getAttribute("android:layout_width"));
    					tmp.setAttribute("android:layout_height", L.getAttribute("android:layout_height"));
    					tmp.setAttribute("android:id", "@+id/x"+qq);
    					qq++;
    					Node parent = L.getParentNode();
    					parent.insertBefore(tmp,L);
    					
    					//System.out.println("here");
    				
    			//	}
    			}
    		
    		}
    	}catch(StringIndexOutOfBoundsException e1) {
        		;
        }
    	
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("EditText");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.getAttribute("android:layout_width").equals("0.0dip")==false) {
    			//	if(L.hasAttribute("android:visibility")) {
    					Element tmp = doc.createElement("EditText");
    				
    					//System.out.println(tmp.getAttribute("android:visibility"));
    					tmp.setAttribute("android:background", "#11111111");
    					tmp.setAttribute("android:layout_width", L.getAttribute("android:layout_width"));
    					tmp.setAttribute("android:layout_height", L.getAttribute("android:layout_height"));
    					tmp.setAttribute("android:id", "@+id/x"+qq);
    					qq++;
    					Node parent = L.getParentNode();
    					parent.insertBefore(tmp,L);
    					
    					//System.out.println("here");
    				
    			//	}
    			}
    		
    		}
    	}catch(StringIndexOutOfBoundsException e1) {
        		;
        }
       */
    }  
      


    
    
    private static void updateSize(Document doc) {
    	try {
    		NodeList Llay = doc.getElementsByTagName("RelativeLayout");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:layout_height")) {
    				if(Character.isDigit(L.getAttribute("android:layout_height").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_height"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_height", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    			if(L.hasAttribute("android:layout_width")) {
    				if(Character.isDigit(L.getAttribute("android:layout_width").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_width"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_width", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    		}
    	}
    	catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("LinearLayout");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:layout_height")) {
    				if(Character.isDigit(L.getAttribute("android:layout_height").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_height"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_height", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    			if(L.hasAttribute("android:layout_width")) {
    				if(Character.isDigit(L.getAttribute("android:layout_width").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_width"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_width", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    		}
    	}
    	catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("FrameLayout");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:layout_height")) {
    				if(Character.isDigit(L.getAttribute("android:layout_height").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_height"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_height", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    			if(L.hasAttribute("android:layout_width")) {
    				if(Character.isDigit(L.getAttribute("android:layout_width").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_width"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_width", String.format("%#.1f", padding) +"dip");
    				}
    					
    			}
    		}
    	}
    	catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("TextView");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:layout_height")) {
    				if(Character.isDigit(L.getAttribute("android:layout_height").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_height"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_height", String.format("%#.1f", padding) +"dip");
    				}
    					
    			}
    			if(L.hasAttribute("android:layout_width")) {
    				if(Character.isDigit(L.getAttribute("android:layout_width").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_width"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_width", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    		}
    	}
    	catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("view");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:layout_height")) {
    				if(Character.isDigit(L.getAttribute("android:layout_height").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_height"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_height", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    			if(L.hasAttribute("android:layout_width")) {
    				if(Character.isDigit(L.getAttribute("android:layout_width").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_width"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_width", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    		}
    	}
    	catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("View");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:layout_height")) {
    				if(Character.isDigit(L.getAttribute("android:layout_height").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_height"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_height", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    			if(L.hasAttribute("android:layout_width")) {
    				if(Character.isDigit(L.getAttribute("android:layout_width").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_width"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_width", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    		}
    	}
    	catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("ImageView");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:layout_height")) {
    				if(Character.isDigit(L.getAttribute("android:layout_height").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_height"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_height", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    			if(L.hasAttribute("android:layout_width")) {
    				if(Character.isDigit(L.getAttribute("android:layout_width").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_width"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_width", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    			
    		}
    	}
    	catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
    	
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("GridView");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:layout_height")) {
    				if(Character.isDigit(L.getAttribute("android:layout_height").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_height"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_height", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    			if(L.hasAttribute("android:layout_width")) {
    				if(Character.isDigit(L.getAttribute("android:layout_width").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_width"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_width", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    		}
    	}
    	catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
    	
    	try {
    		NodeList Llay = doc.getElementsByTagName("EditText");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:layout_height")) {
    				if(Character.isDigit(L.getAttribute("android:layout_height").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_height"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_height", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    			if(L.hasAttribute("android:layout_width")) {
    				if(Character.isDigit(L.getAttribute("android:layout_width").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_width"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_width", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    		}
    	}
    	catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
    	
      	try {
    		NodeList Llay = doc.getElementsByTagName("ImageButton");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:layout_height")) {
    				if(Character.isDigit(L.getAttribute("android:layout_height").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_height"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_height", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    			if(L.hasAttribute("android:layout_width")) {
    				if(Character.isDigit(L.getAttribute("android:layout_width").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_width"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_width", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    		}
    	}
    	catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
      	
      	try {
    		NodeList Llay = doc.getElementsByTagName("ListView");
    		Element L = null;
    		for(int i = 0; i < Llay.getLength();i++) {
    			L = (Element)Llay.item(i);
    			if(L.hasAttribute("android:layout_height")) {
    				if(Character.isDigit(L.getAttribute("android:layout_height").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_height"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_height", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    			if(L.hasAttribute("android:layout_width")) {
    				if(Character.isDigit(L.getAttribute("android:layout_width").charAt(0))) {
    					double padding = getDoubleValue(L.getAttribute("android:layout_width"));
    		    		
    					padding = padding * 1.1;

    					
    					L.setAttribute("android:layout_width", String.format("%#.1f", padding)+"dip");
    				}
    					
    			}
    		}
    	}
    	catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
      	
      	
      	
    }
    





    private static void updateColor(Document doc) {
    	try {
        NodeList a_back = doc.getElementsByTagName("LinearLayout");
        Element emp = null;
        //loop for each employee
        for(int i=0; i<a_back.getLength();i++){
            emp = (Element) a_back.item(i);
        //    String gender = emp.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
            if(emp.hasAttribute("android:background")) {
            if(emp.getAttribute("android:background").charAt(0)=='#') {
                //prefix id attribute with M
            	Integer alpha = Integer.parseUnsignedInt((emp.getAttribute("android:background").substring(1,3)),16);
            	Integer red =  Integer.parseUnsignedInt((emp.getAttribute("android:background").substring(3,5)),16);
            	Integer green = Integer.parseUnsignedInt((emp.getAttribute("android:background").substring(5,7)),16);
            	Integer blue = Integer.parseUnsignedInt((emp.getAttribute("android:background").substring(7,9)),16);
            	if(red >= 0x80)
            		red -= 0x01;
            	else
            		red += 0x01;
            	if(green >= 0x80)
            		green -= 0x01;
            	else
            		green += 0x01;
            	if(blue >= 0x80)
            		blue -= 0x01;
            	else
            		blue += 0x01;
                emp.setAttribute("android:background", "#"+String.format("%08x", (alpha << 24) + (red<<16) + (green << 8) + blue));
            }//else{
                //prefix id attribute with F
        //        emp.setAttribute("id", "F"+emp.getAttribute("id"));
        //    }
            }
        }
    	}catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
    	
    	
    	try {
            NodeList a_back = doc.getElementsByTagName("RelativeLayout");
            Element emp = null;
            //loop for each employee
            for(int i=0; i<a_back.getLength();i++){
                emp = (Element) a_back.item(i);
            //    String gender = emp.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
                if(emp.hasAttribute("android:background")) {
                if(emp.getAttribute("android:background").charAt(0)=='#') {
                    //prefix id attribute with M
                	Integer alpha = Integer.parseUnsignedInt((emp.getAttribute("android:background").substring(1,3)),16);
                	Integer red =  Integer.parseUnsignedInt((emp.getAttribute("android:background").substring(3,5)),16);
                	Integer green = Integer.parseUnsignedInt((emp.getAttribute("android:background").substring(5,7)),16);
                	Integer blue = Integer.parseUnsignedInt((emp.getAttribute("android:background").substring(7,9)),16);
                	if(red >= 0x80)
                		red -= 0x01;
                	else
                		red += 0x01;
                	if(green >= 0x80)
                		green -= 0x01;
                	else
                		green += 0x01;
                	if(blue >= 0x80)
                		blue -= 0x01;
                	else
                		blue += 0x01;
                    emp.setAttribute("android:background", "#"+String.format("%08x", (alpha << 24) + (red<<16) + (green << 8) + blue));
                }//else{
                    //prefix id attribute with F
            //        emp.setAttribute("id", "F"+emp.getAttribute("id"));
            //    }
            
                }
            }
        	}catch(StringIndexOutOfBoundsException e1) {
        		;
        	}
    	
    	
    	try {
            NodeList a_back = doc.getElementsByTagName("FrameLayout");
            Element emp = null;
            //loop for each employee
            for(int i=0; i<a_back.getLength();i++){
                emp = (Element) a_back.item(i);
                if(emp.hasAttribute("android:background")) {
            //    String gender = emp.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
                if(emp.getAttribute("android:background").charAt(0)=='#') {
                    //prefix id attribute with M
                	Integer alpha = Integer.parseUnsignedInt((emp.getAttribute("android:background").substring(1,3)),16);
                	Integer red =  Integer.parseUnsignedInt((emp.getAttribute("android:background").substring(3,5)),16);
                	Integer green = Integer.parseUnsignedInt((emp.getAttribute("android:background").substring(5,7)),16);
                	Integer blue = Integer.parseUnsignedInt((emp.getAttribute("android:background").substring(7,9)),16);
                	if(red >= 0x80)
                		red -= 0x01;
                	else
                		red += 0x01;
                	if(green >= 0x80)
                		green -= 0x01;
                	else
                		green += 0x01;
                	if(blue >= 0x80)
                		blue -= 0x01;
                	else
                		blue += 0x01;
                    emp.setAttribute("android:background", "#"+String.format("%08x", (alpha << 24) + (red<<16) + (green << 8) + blue));
                }//else{
                    //prefix id attribute with F
            //        emp.setAttribute("id", "F"+emp.getAttribute("id"));
            //    }
            
                }
            }
        	}catch(StringIndexOutOfBoundsException e1) {
        		;
        	}
    	
    	try {
        NodeList Listview = doc.getElementsByTagName("ListView");
        Element lst = null;
        //loop for each employee
        for(int i=0; i<Listview.getLength();i++){
            lst = (Element) Listview.item(i);
        //    String gender = emp.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
            if(lst.getAttribute("android:cacheColorHint").charAt(0)!='@') {
                //prefix id attribute with M
            	Integer alpha = Integer.parseUnsignedInt((lst.getAttribute("android:cacheColorHint").substring(1,3)),16);
            	Integer red =  Integer.parseUnsignedInt((lst.getAttribute("android:cacheColorHint").substring(3,5)),16);
            	Integer green = Integer.parseUnsignedInt((lst.getAttribute("android:cacheColorHint").substring(5,7)),16);
            	Integer blue = Integer.parseUnsignedInt((lst.getAttribute("android:cacheColorHint").substring(7,9)),16);
            	if(red >= 0x80)
            		red -= 0x01;
            	else
            		red += 0x01;
            	if(green >= 0x80)
            		green -= 0x01;
            	else
            		green += 0x01;
            	if(blue >= 0x80)
            		blue -= 0x01;
            	else
            		blue += 0x01;
                lst.setAttribute("android:cacheColorHint", "#"+String.format("%08x", (alpha << 24) + (red<<16) + (green << 8) + blue));
            }
            
            if(lst.getAttribute("android:divider").charAt(0)!='@') {
                //prefix id attribute with M
            	Integer alpha = Integer.parseUnsignedInt((lst.getAttribute("android:divider").substring(1,3)),16);
            	Integer red =  Integer.parseUnsignedInt((lst.getAttribute("android:divider").substring(3,5)),16);
            	Integer green = Integer.parseUnsignedInt((lst.getAttribute("android:divider").substring(5,7)),16);
            	Integer blue = Integer.parseUnsignedInt((lst.getAttribute("android:divider").substring(7,9)),16);
            	if(red >= 0x80)
            		red -= 0x01;
            	else
            		red += 0x01;
            	if(green >= 0x80)
            		green -= 0x01;
            	else
            		green += 0x01;
            	if(blue >= 0x80)
            		blue -= 0x01;
            	else
            		blue += 0x01;
                lst.setAttribute("android:divider", "#"+String.format("%08x", (alpha << 24) + (red<<16) + (green << 8) + blue));
            }
                //prefix id attribute with F
        //        emp.setAttribute("id", "F"+emp.getAttribute("id"));
        //    }
        }
    	}catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
        
    	
    	try {
        NodeList view = doc.getElementsByTagName("View");
        
        
        Element vw = null;
        //loop for each employee
        for(int i=0; i<view.getLength();i++){
            vw = (Element) view.item(i);
        //    String gender = emp.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
            if(vw.getAttribute("android:background").charAt(0)=='#') {
                //prefix id attribute with M
            	Integer alpha = Integer.parseUnsignedInt((vw.getAttribute("android:background").substring(1,3)),16);
            	Integer red =  Integer.parseUnsignedInt((vw.getAttribute("android:background").substring(3,5)),16);
            	Integer green = Integer.parseUnsignedInt((vw.getAttribute("android:background").substring(5,7)),16);
            	Integer blue = Integer.parseUnsignedInt((vw.getAttribute("android:background").substring(7,9)),16);
            	if(red >= 0x80)
            		red -= 0x01;
            	else
            		red += 0x01;
            	if(green >= 0x80)
            		green -= 0x01;
            	else
            		green += 0x01;
            	if(blue >= 0x80)
            		blue -= 0x01;
            	else
            		blue += 0x01;
                vw.setAttribute("android:background", "#"+String.format("%08x", (alpha << 24) + (red<<16) + (green << 8) + blue));
            }//else{
                //prefix id attribute with F
        //        emp.setAttribute("id", "F"+emp.getAttribute("id"));
        //    }
        }
        
    	}catch(StringIndexOutOfBoundsException e1) {
    		;
    	}
    	
    	
    	try {
        NodeList gridview = doc.getElementsByTagName("GridView");
        Element gvw = null;
        //loop for each employee
        for(int i=0; i<gridview.getLength();i++){
            gvw = (Element) gridview.item(i);
        //    String gender = emp.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
            if(gvw.getAttribute("android:background").charAt(0)!='@') {
                //prefix id attribute with M
            	Integer alpha = Integer.parseUnsignedInt((gvw.getAttribute("android:background").substring(1,3)),16);
            	Integer red =  Integer.parseUnsignedInt((gvw.getAttribute("android:background").substring(3,5)),16);
            	Integer green = Integer.parseUnsignedInt((gvw.getAttribute("android:background").substring(5,7)),16);
            	Integer blue = Integer.parseUnsignedInt((gvw.getAttribute("android:background").substring(7,9)),16);
            	if(red >= 0x80)
            		red -= 0x01;
            	else
            		red += 0x01;
            	if(green >= 0x80)
            		green -= 0x01;
            	else
            		green += 0x01;
            	if(blue >= 0x80)
            		blue -= 0x01;
            	else
            		blue += 0x01;
                gvw.setAttribute("android:background", "#"+String.format("%08x", (alpha << 24) + (red<<16) + (green << 8) + blue));
            }//else{
                //prefix id attribute with F
        //        emp.setAttribute("id", "F"+emp.getAttribute("id"));
        //    }
        }
    	}catch(StringIndexOutOfBoundsException e1) {
    		;
    	}

    	
    	try {
            NodeList textview = doc.getElementsByTagName("TextView");
            Element tvw = null;
            //loop for each employee
            for(int i=0; i<textview.getLength();i++){
                tvw = (Element) textview.item(i);
            //    String gender = emp.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
                if(tvw.getAttribute("android:textColor").charAt(0)!='@') {
                    //prefix id attribute with M
                	Integer alpha = Integer.parseUnsignedInt((tvw.getAttribute("android:textColor").substring(1,3)),16);
                	Integer red =  Integer.parseUnsignedInt((tvw.getAttribute("android:textColor").substring(3,5)),16);
                	Integer green = Integer.parseUnsignedInt((tvw.getAttribute("android:textColor").substring(5,7)),16);
                	Integer blue = Integer.parseUnsignedInt((tvw.getAttribute("android:textColor").substring(7,9)),16);
                	if(red >= 0x80)
                		red -= 0x01;
                	else
                		red += 0x01;
                	if(green >= 0x80)
                		green -= 0x01;
                	else
                		green += 0x01;
                	if(blue >= 0x80)
                		blue -= 0x01;
                	else
                		blue += 0x01;
                    tvw.setAttribute("android:textColor", "#"+String.format("%08x", (alpha << 24) + (red<<16) + (green << 8) + blue));
                }//else{
                    //prefix id attribute with F
            //        emp.setAttribute("id", "F"+emp.getAttribute("id"));
            //    }
            }
        	}catch(StringIndexOutOfBoundsException e1) {
        		;
        	}

    }

}

