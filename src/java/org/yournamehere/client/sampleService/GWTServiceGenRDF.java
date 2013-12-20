/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author inilog
 */
@RemoteServiceRelativePath("sampleService/gwtservicegenrdf")
public interface GWTServiceGenRDF extends RemoteService {

    public String genRDF();
    public ArrayList<String> getAllGetterFromType (String Type);
    public HashMap<Long, String> getAllPredicate ();
    public String creatRDFGenOpt (String entityName, String columnName, Long predicateId);
}
