/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Conceptos.Tipo;
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
public class CargadorXMLTipo {
    
     public static ArrayList Cargar(InputStream archivo){
        ArrayList<Tipo> tipos = new ArrayList();
        
        try {
            InputSource source = new InputSource(archivo);

            TipoParseHandler handler = new TipoParseHandler();
            
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setNamespaceAware(true);
            
            SAXParser parser = parserFactory.newSAXParser();
            
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(source);
            
            tipos = handler.getTiquetes();
            
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
 
        }
        
        return tipos;
    }
}
