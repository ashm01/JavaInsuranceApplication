package Insurance;

import java.io.File;
import java.io.IOException;

/**
 * Main class which holds the main method for the insurance application
 *
 * @author Ashley Moore
 */
public class InsuranceCoDemo {

    /**
     * Main method for the application which executes all the commands and runs
     * the application
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {


        //Initialise the file object with the path to the client text file
        File file = new File("C:\\Users\\moora\\Dropbox\\Netbeans"
                + "\\NetBeansProjects\\InsuranceCoursework\\src\\Insurance"
                + "\\ClientDetailsInput.txt");
        
        //Create the client list which will store all the data from the fle
        ClientDetailsList test = new ClientDetailsList();
        try {
            //Invoke the readfile method from the inputdata class passing the file
            //created above
            test = InputData.readFile(file);
        } catch (IllegalPolicyException e) {
            System.out.println(e);
        }
        //Invokes the gui
        new GUI(test);

    }
}
