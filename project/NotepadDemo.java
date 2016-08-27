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
public class NotepadDemo {
    public static void main(String[] args) {
        
        SimpleNotepad smpNotepade = new SimpleNotepad(new Page(), 1);
        smpNotepade.addHeading("Page heading");
        smpNotepade.addText("Lorem ipsum sit amet text demo");
        smpNotepade.addTextOnPage();
        
        String heading = smpNotepade.getHeading();
        String printedPage = smpNotepade.printPage();
        
        System.out.println(printedPage);
        
    }
}
