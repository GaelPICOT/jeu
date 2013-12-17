/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.yournamehere.client.sampleService.GWTServiceAddImage;

/**
 *
 * @author inilog
 */
public class GWTServiceAddImageImpl extends RemoteServiceServlet implements GWTServiceAddImage {

    @Override
    protected void service(final HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
        byte[] image = (request.getParameter("image")).getBytes();
        File fileOut= new File("file.jpg");
        FileOutputStream fos = new FileOutputStream(fileOut);
        fos.write(image);
        fos.close();
    }
}
