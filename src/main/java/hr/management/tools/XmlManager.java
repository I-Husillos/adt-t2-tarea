package hr.management.tools;

import hr.management.model.Vehicle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class XmlManager {

    public static Vehicle readVehicleFromXml(String ruta){
        File xml= new File(ruta);
        Vehicle vehicle = null;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document doc = builder.parse(xml);

            NodeList nodeList = doc.getElementsByTagName("vehicle");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element vehicleElement = (Element) node;
                    String plate = vehicleElement.getElementsByTagName("plate").item(0).getTextContent();
                    String brand = vehicleElement.getElementsByTagName("brand").item(0).getTextContent();
                    String model = vehicleElement.getElementsByTagName("model").item(0).getTextContent();
                    String yearBought = vehicleElement.getElementsByTagName("yearBought").item(0).getTextContent();

                    vehicle = new Vehicle(plate, brand, model, Integer.parseInt(yearBought));

                }
            }

            return vehicle;
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

}