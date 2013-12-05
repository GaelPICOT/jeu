/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import entity.encyclopedia.Book;
import facade.BookFacade;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Anthony
 */
@ManagedBean(name="BookView")
@RequestScoped
public class BookView {
    @EJB
    private BookFacade bookFacade;
    private Book book;
    /**
     * Creates a new instance of BookView
     */
    public BookView() {
        this.book = new Book();
    }
    
    public Book getBook() {
//        logger.info("getUser");
      return book;
    }
    
    public String createBook(){
//        logger.info("createAccount");
//       this.messageFacade.create(message);
    bookFacade.create(book);
    return "livreAjoute";
}
}
