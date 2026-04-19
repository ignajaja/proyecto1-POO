/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Tiquete;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


/**
 *
 * @author User
 */
public class CargadorXMLTiquete {
    
     public static ArrayList Cargar(InputStream archivo){
        ArrayList<Tiquete> tiquetes = new ArrayList();
        
        try {
            InputSource source = new InputSource(archivo);

            TiqueteParseHandler handler = new TiqueteParseHandler();
            
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setNamespaceAware(true);
            
            SAXParser parser = parserFactory.newSAXParser();
            
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(source);
            
            tiquetes = handler.getTiquetes();
            
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
 
        }
        
        return tiquetes;
    }
}
