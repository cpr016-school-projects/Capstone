package antenatal.views;

public class BaseVisitView extends GenericView {
    
    public BaseVisitView() {
        super();
    }
    
    public String readStringWithPrompt(String prompt) {
        this.write(prompt);
        System.out.flush();
        String input = in.nextLine();
        return input;
    }
    

}
