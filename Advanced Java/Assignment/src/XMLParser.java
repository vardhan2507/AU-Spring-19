import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class XMLParser {
	 public void parse() {

		    try {

		    	
			File fXmlFile = new File("D:\\Workspace\\Advanced Java\\SampleProj\\XMLParser\\src\\Employee.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);		
			doc.getDocumentElement().normalize();				
			NodeList nodeList = doc.getElementsByTagName("Employee");
			
			JDBCConn jdbccon=new JDBCConn();
			
			
			for (int temp = 0; temp < nodeList.getLength(); temp++) {
				Node node = nodeList.item(temp);					
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					
					int id= Integer.parseInt(eElement.getElementsByTagName("Id").item(0).getTextContent());
					String name	=eElement.getElementsByTagName("Name").item(0).getTextContent();
					int salary= Integer.parseInt(eElement.getElementsByTagName("Salary").item(0).getTextContent());
					int deptid=Integer.parseInt(eElement.getElementsByTagName("DepartmentId").item(0).getTextContent());

					
					jdbccon.insert(id, name, salary, deptid);
					
				
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    
		  }

}
