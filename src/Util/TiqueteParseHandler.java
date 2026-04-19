/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Tiquete;
import java.util.ArrayList;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author User
 */
public class TiqueteParseHandler extends DefaultHandler{
    ArrayList<Tiquete> tiquetes = new ArrayList();
    Stack pilaElementos = new Stack();
    Stack pilaObjetos = new Stack();
    
    /* Eventos de SAX's que se manejaran */
    
    @Override
    public void startDocument() throws SAXException
    {
    }

    @Override
    public void endDocument() throws SAXException
    {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        this.pilaElementos.push(qName);
        
        if ("tiquete".equals(qName)){
            Tiquete tiquete = new Tiquete();
            this.pilaObjetos.push(tiquete);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        this.pilaElementos.pop();
        
        if ("tiquete".equals(qName)){
            Tiquete tiquete = (Tiquete)this.pilaObjetos.pop();
            this.tiquetes.add(tiquete);
        }
    }
    
    /* Este evento se llama cada vez que aparece un nodo del XML */ 
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String valor = new String(ch, start, length). trim();
        
        if (valor.length() == 0)
        {
            return;
        }
        if ("id".equals(elementoActual())){
            Tiquete tiquete = (Tiquete)this.pilaObjetos.peek();
            tiquete.setId(valor);
        } else if ("nombre".equals(elementoActual())){
            Tiquete tiquete = (Tiquete)this.pilaObjetos.peek();
            tiquete.setNombre(valor);
        } else if ("precio_id".equals(elementoActual())) {
            Tiquete tiquete = (Tiquete)this.pilaObjetos.peek();
            tiquete.setPrecioId(valor);
        }
    }
    
    private String elementoActual()
    {
        return (String)this.pilaElementos.peek();
    }
    
    public ArrayList getTiquetes()
    {
        return tiquetes;
    }
}
