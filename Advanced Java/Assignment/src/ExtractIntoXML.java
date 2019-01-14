
import java.io.File;
import java.sql.ResultSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ExtractIntoXML {

	void extract() {
		
		   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
	        try {
	            dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.newDocument();
	            
	            Element rootElement =
	                doc.createElementNS("", "Departments");
	            
	            doc.appendChild(rootElement);
	            
	            JDBCConn jdbccon=new JDBCConn();
	            ResultSet rs=jdbccon.fetchData();
	            while(rs.next()) {
	                int id  = rs.getInt("deptid");
	                String name = rs.getString("name"); 
	                rootElement.appendChild(getDept(doc, String.valueOf(id), name));
	             }
	            	           	         
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            DOMSource source = new DOMSource(doc);
	            StreamResult console = new StreamResult(System.out);
	            StreamResult file = new StreamResult(new File("D:\\Workspace\\Advanced Java\\SampleProj\\XMLParser\\src\\Departments.xml"));
	            transformer.transform(source, file);
	          
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	 Node getDept(Document doc, String id, String deptname) {
        Element dept = doc.createElement("Department");    
        dept.appendChild(getDeptElements(doc, dept, "Id", deptname));
        dept.appendChild(getDeptElements(doc, dept	, "DepartmentName", deptname));  
        return dept;
    }

     Node getDeptElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
