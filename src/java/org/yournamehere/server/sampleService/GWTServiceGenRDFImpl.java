/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.RDFWriter;
import com.hp.hpl.jena.rdf.model.Resource;
import entity.semantic.SemanticLiteral;
import entity.semantic.SemanticNode;
import entity.semantic.SemanticRessource;
import entity.semantic.Triple;
import facade.SemanticNodeFacade;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

import org.yournamehere.client.sampleService.GWTServiceGenRDF;

/**
 *
 * @author inilog
 */
public class GWTServiceGenRDFImpl extends RemoteServiceServlet implements GWTServiceGenRDF {

    @EJB
    private SemanticNodeFacade semanticNodeFacade;
    
    @Override
    public String genRDF() {
        Model model = ModelFactory.createDefaultModel();
        List<SemanticNode> listSN = semanticNodeFacade.findAll();
        for (SemanticNode SN : listSN) {
            if (!SN.getClass().equals(SemanticLiteral.class)) {
                SemanticRessource SR = (SemanticRessource) SN;
                Resource subject = model.createResource(SR.getURI());
                for (Triple t : SN.getSujet()) {
                    Property predicate = model.createProperty(t.getPredicate().getURI());
                    RDFNode object;
                    if (t.getObjet().getClass().getName().equals(SemanticLiteral.class.getName()))
                        object = model.createLiteral(t.getObjet().toString());
                    else
                        object = model.createResource(((SemanticRessource)t.getObjet()).getURI());
                    model.add(model.createStatement(subject, predicate, object));
                }
            }
        }
        RDFWriter w = model.getWriter();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        w.write(model, outStream, SemanticRessource.BASEURI);
        try {
            return outStream.toString("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GWTServiceGenRDFImpl.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
}
