/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Conceptos.Precio;
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
public class CargadorXMLPrecio {
    
     public static ArrayList Cargar(InputStream archivo){
        ArrayList<Precio> precios = new ArrayList();
        
        try {
            InputSource source = new InputSource(archivo);

            PrecioParseHandler handler = new PrecioParseHandler();
            
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setNamespaceAware(true);
            
            SAXParser parser = parserFactory.newSAXParser();
            
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(source);
            
            precios = handler.getPrecios();
            
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
 
        }
        
        return precios;
    }
}
