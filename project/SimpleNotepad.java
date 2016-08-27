/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Ramona
 */
public class SimpleNotepad extends Page implements INotepad{

    private int pageNumber; 
    
    public SimpleNotepad(Page page, int pageNumber) {
        this.pageNumber = pageNumber;
    }
       
    @Override
    public void addTextToPage() {
      
    }

    @Override
    public void addTextOnPage() {
      
    }

    @Override
    public void deleteText() {
      
    }

    @Override
    public String printPage() {
       return super.viewPage();
    }
   
}
