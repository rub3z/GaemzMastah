package launcher.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ProgramManager {
    String filePath;
    List<Program> appList;

    public ProgramManager(String filePath) {
        this.filePath = filePath;
        appList = new ArrayList<Program>();
        readDataFromFile();
    }

    public void readDataFromFile() {
        try {
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(fXmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("application");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String title = element.getAttribute("id");
                String path = element.getElementsByTagName("path").item(0).getTextContent();
                String iconPath = element.getElementsByTagName("iconPath").item(0).getTextContent();
                appList.add(new Program(title, path, iconPath));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public List<Program> getAppList() {
        return appList;
    }
}
