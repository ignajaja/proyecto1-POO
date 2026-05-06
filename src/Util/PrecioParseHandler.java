/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Conceptos.Precio;
import java.util.ArrayList;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author User
 */
public class PrecioParseHandler extends DefaultHandler{
    ArrayList<Precio> precios = new ArrayList();
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
        
        if ("precio".equals(qName)){
            Precio precio = new Precio();
            String id = attributes.getValue("id");
            precio.setId(id);
            this.pilaObjetos.push(precio);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        this.pilaElementos.pop();
        
        if ("precio".equals(qName)){
            Precio precio = (Precio)this.pilaObjetos.pop();
            this.precios.add(precio);
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
        if ("tipo".equals(elementoActual())){
            Precio precio = (Precio)this.pilaObjetos.peek();
            precio.setTipo(valor);
        } else if ("monto".equals(elementoActual())) {
            Precio p = (Precio)this.pilaObjetos.peek();
            p.setMonto(valor);
        } else if ("fecha".equals(elementoActual())) {
            Precio precio = (Precio)this.pilaObjetos.peek();
            precio.setFecha(valor);
        }
    }
    
    private String elementoActual()
    {
        return (String)this.pilaElementos.peek();
    }
    
    public ArrayList getPrecios()
    {
        return precios;
    }
}
