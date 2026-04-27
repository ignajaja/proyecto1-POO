/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Tipo;
import java.util.ArrayList;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author User
 */
public class TipoParseHandler extends DefaultHandler{
    ArrayList<Tipo> tipos = new ArrayList();
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
            Tipo tipo = new Tipo();
            this.pilaObjetos.push(tipo);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        this.pilaElementos.pop();
        
        if ("tiquete".equals(qName)){
            Tipo tipo = (Tipo)this.pilaObjetos.pop();
            this.tipos.add(tipo);
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
            Tipo tipo = (Tipo)this.pilaObjetos.peek();
            tipo.setId(valor);
        } else if ("nombre".equals(elementoActual())){
            Tipo tipo = (Tipo)this.pilaObjetos.peek();
            tipo.setNombre(valor);
        } else if ("descripcion".equals(elementoActual())) {
            Tipo tipo = (Tipo)this.pilaObjetos.peek();
            tipo.setDescripcion(valor);
        } else if ("imagen".equals(elementoActual())) {
            Tipo tipo = (Tipo)this.pilaObjetos.peek();
            tipo.setImagen(valor);
        }
    }
    
    private String elementoActual()
    {
        return (String)this.pilaElementos.peek();
    }
    
    public ArrayList getTiquetes()
    {
        return tipos;
    }
}
