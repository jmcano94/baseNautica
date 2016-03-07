/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.parser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author marc
 */
public class baseNauticaXMLParser {
    
    /**
     * Data Manager
     */
    baseNauticaXMLParser dataManager;
    
    
    /**
     * Constructor
     *
     * @param dataManager
     */
    public baseNauticaXMLParser(baseNauticaXMLParser dataManager) {
        this.dataManager = dataManager;
    }
    
    /**
     * Parseja un fitxer XML de MotoRent i guarda les dades al sistema
     *
     * @param nomFitxer
     */
    public void parse(String nomFitxer) {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(nomFitxer));
            doc.getDocumentElement().normalize();

            // Obtenim dades
        } catch (SAXParseException err) {
            System.out.println("** Error parsejant" + ", linia " + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());
        } catch (SAXException e) {
            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    
    
    
}
