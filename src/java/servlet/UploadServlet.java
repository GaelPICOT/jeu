package servlet;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.util.List;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import gwtupload.server.UploadAction;
import gwtupload.server.exceptions.UploadActionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UploadServlet extends UploadAction {
  /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
	Logger loggerJava = Logger.getLogger("log");
    @Override
    public String executeAction(HttpServletRequest request, List<FileItem> sessionFiles) throws UploadActionException {
    //	logger.info("Bonjour, logger");
    //	loggerJava.log(Level.SEVERE, "Bonjour, logger");
    //	System.out.println("Bonjour, syso");
        String ret = "";
        for (FileItem item : getSessionItems(request)) {
          if (!item.isFormField()) {
              try {

                  // we can save the received file
                  String fileName = item.getName().substring(
                              item.getName().lastIndexOf(File.separator) + 1);
    //              File file = File.createTempFile("upload-", ".bin", new File("/home/anthony/"));
    //              item.write(file);
    //              File file = new File("./www/localServerUploads/" );
    //
    //              if(!file.exists())
    //                    file.mkdirs();
                  /*
                   *
                   * File file = File.createTempFile("receivedFile", ".tmp",
                   * new File("./www/"));
                   */
                  File file = new File("/home/anthony/images/"+fileName);
                  item.write(file);
                  
                  loggerJava.log(Level.SEVERE, "upload fichier: " + file.getAbsolutePath());

    //              response =   fileName;
    //              System.out.println("fichier: " + fileName + ", dest: " + file.getAbsolutePath());
    //              logger.info("fichier: " + fileName + ", dest: " + file.getAbsolutePath());
    //              ret += fileName;



            } catch (Exception e) {
                  throw new UploadActionException(e.getMessage());
            }
            // Do anything with the file.

            // Update the string to return;
            ret += "server message";
          }
        }
        super.removeSessionFileItems(request);
        return ret;
      }
}