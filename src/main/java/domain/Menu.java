package domain;

import entity.Issure;
import entity.Project;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    public void enterNewRecord() {
        try {
            JAXBContext context = JAXBContext.newInstance(Issure.class);

            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Issure issure = new Issure(1, "12.09.18", "akdkxvjxdjxdbvkxj");
            List<Issure> issures = new LinkedList<Issure>();
            issures.add(issure);

            StringWriter sw = new StringWriter();
            m.marshal(issures, sw);

            Unmarshaller um = context.createUnmarshaller();
            String s = sw.toString();
            System.out.println(s);

            System.out.println("==============================================");
            System.out.println("==============================================");
            System.out.println("==============================================");

            List<Issure> issures2 = (List<Issure>) um.unmarshal(new StreamSource(new StringReader(s)));
            System.out.println(issures2);
        } catch (JAXBException e) {
            e.printStackTrace();
        }





        /*System.out.println("FINISH ;)");
        Issure issure = new Issure(1, "12.09.18", "akdkxvjxdjxdbvkxj");
        String fileName = "C:\\file.xml";
        System.out.println(issure.toString());
        convertObjectToXml(issure, fileName);*/
    }

    public void displayTheList() {
        System.out.println("2");
    }

    public void generateAReport() {
        System.out.println("3");
    }
}

    /*// сохраняем объект в XML файл
    private static void convertObjectToXml(Issure issure, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Issure.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(issure, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void convertObjectToXml(Project project, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Project.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(project, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    // восстанавливаем объект из XML файла
    private static Issure fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Issure.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Issure) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}


*/