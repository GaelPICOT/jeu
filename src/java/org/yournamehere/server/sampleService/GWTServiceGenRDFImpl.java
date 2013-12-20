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
import entity.option.RDFGenerator;
import entity.semantic.Predicate;
import entity.semantic.SemanticLiteral;
import entity.semantic.SemanticNode;
import entity.semantic.SemanticRessource;
import entity.semantic.Triple;
import facade.PredicateFacade;
import facade.RDFGeneratorFacade;
import facade.SemanticNodeFacade;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
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
    @EJB
    private PredicateFacade predicateFacade;
    @EJB
    private RDFGeneratorFacade rDFGeneratorFacade;
    
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

    @Override
    public ArrayList<String> getAllGetterFromType(String Type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Long, String> getAllPredicate() {
        List<Predicate> preds = predicateFacade.findAll();
        HashMap<Long, String> retour = new HashMap<>();
        for(Predicate pred : preds) {
            retour.put(pred.getId(), pred.getLabel());
        }
        return retour;
    }

    @Override
    public String creatRDFGenOpt(String entityName, String columnName, Long predicateId) {
        RDFGenerator RDFopt = new RDFGenerator();
        RDFopt.setEntityName(entityName);
        RDFopt.setColumnName(columnName);
        rDFGeneratorFacade.create(RDFopt);
        RDFopt.setToGenerate(predicateFacade.find(predicateId));
        rDFGeneratorFacade.edit(RDFopt);
        
        return "Ok";
    }
}
