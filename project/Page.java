package project;

/**
 *
 * @author Ramona
 */
public class Page {
    
    protected String heading;
    protected String text;
    
    /**
     * Adding heading to a page
     * @param heading 
     */
    public void addHeading(String heading) {
        this.heading = heading;
    }
    
    /**
     * Get heading of a page
     * @return 
     */
    public String getHeading() {
       return this.heading;
    }
    
    /**
     * Adding text to a page
     * @param text 
     */
    public void addText(String text) {
        this.text = text;
    }
    
    public String getText() {
        return this.text;
    }
    
    /**
     * Deleting text from a page
     */
    public void deleteText() {
        
    }
    
    
    public String viewPage() {
        return this.getHeading() + "\n" + this.getText();
    }
    
    
}
