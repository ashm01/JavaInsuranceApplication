package Insurance;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Input data class that is used to read the data from a given 
 * file
 * @author Ash
 * @version 1.03
 */
public class InputData {

    /**
     * A method that takes in a file and reads in the data and
     * from there performs checks and creates a client details list
     * with the data
     * @param inputFile file which holds the data
     * @return dataList 
     * @throws IOException
     * @throws IllegalPolicyException
     */
    public static ClientDetailsList readFile(File inputFile)
            throws IOException, IllegalPolicyException {
        //Create the arraylist of cliet detailss which will be
        //returned
        ClientDetailsList dataList = new ClientDetailsList();
        //Scanner which reads data from text file
        Scanner file = new Scanner(new FileReader(inputFile));
        //Use the delimeter# to seperate the data
        file.useDelimiter("#");
        // while loop which will iterate through allthe data in the file
        while (file.hasNext()) {
            //Create the policy list for the users polices to be stored
            PolicyList policies = new PolicyList();
            // String which holds all the data from a user
            String userInfo = file.next();
            //splits the userinfo into indivial tokens of data
            String[] result = userInfo.split("/");
            //Sets the customer ID to the first token of data from
            //the file
            String ID = result[0];
            //Creates a name object using the next 3 tokens created
            //from the result array
            Name nameDetails = new Name(result[1], result[2], result[3]);
            //Same as name, create address using result array data
            Address addDetails = new Address(result[4], result[5], result[6]);
            //for loop to iterate through the array of the line of data
            //which has been read and stored from the file
            for (int i = 0; i<result.length;i++){
                //If statement to determine whether the token of data matches
                //the pattern given
                if(result[i].matches("[C]\\d\\d\\d\\d\\d\\d\\d\\d")){
                    // if the token does match the pattern assign these variables
                    // to spefic tokens of data from the array
                    int year = Integer.parseInt(result[i-1]);
                    String polID = result[i];
                    double value = Double.parseDouble(result[i+1]);
                    double risk = Double.parseDouble(result[i+2]);
                    //Create the specific policy
                    ContentPolicy cp = new ContentPolicy(year,polID,value,risk);
                    //Add the policy to the policy list
                    policies.addPolicy(cp);                     
                }
                //If statement to determine whether the token of data matches
                //the pattern given
                if(result[i].matches("[V]\\d\\d\\d\\d\\d\\d\\d\\d")){
                    // if the token does match the pattern assign these variables
                    // to spefic tokens of data from the array
                    int year = Integer.parseInt(result[i-1]);
                    String polID = result[i];
                    double value = Double.parseDouble(result[i+1]);
                    int age = Integer.parseInt(result[i+2]);
                    int yearsNoClaims = Integer.parseInt(result[i+3]);
                    int fc = Integer.parseInt(result[i+4]);
                    boolean fullyComp = false;
                    //if the fullycomp parameter = 1 then its true
                    if(fc ==1){
                         fullyComp = true;
                    }
                    //if the fullycomp parameter = 0 then its false
                    if(fc==0){
                         fullyComp = false;
                    }
                    //Create the specific policy
                    CarPolicy vp = new CarPolicy(value,age,yearsNoClaims,
                            fullyComp,polID,year);
                    //Add the policy to the policy list
                    policies.addPolicy(vp);     
                }
                // if the token does match the pattern assign these variables
                // to spefic tokens of data from the array
                if(result[i].matches("[B]\\d\\d\\d\\d\\d\\d\\d\\d")){
                    // if the token does match the pattern assign these variables
                    // to spefic tokens of data from the array
                    int year = Integer.parseInt(result[i-1]);
                    String polID = result[i];
                    double value = Double.parseDouble(result[i+1]);
                    double risk = Double.parseDouble(result[i+2]);
                    //Create the specific policy
                    BuildingPolicy bp = new BuildingPolicy(year,polID,value,risk);
                    //Add the policy to the policy list
                    policies.addPolicy(bp);   
                }
                // if the token does match the pattern assign these variables
                // to spefic tokens of data from the array
                if(result[i].matches("[L]\\d\\d\\d\\d\\d\\d\\d\\d")){
                    // if the token does match the pattern assign these variables
                    // to spefic tokens of data from the array
                    int year = Integer.parseInt(result[i-1]);
                    String polID = result[i];
                    int value = Integer.parseInt(result[i+1]);
                    int age = Integer.parseInt(result[i+2]);
                    double risk = Double.parseDouble(result[i+3]);
                    //Create the specific policy
                    LifePolicy lp = new LifePolicy(age,value,risk,polID,year);
                    //Add the policy to the policy list
                    policies.addPolicy(lp);    
                }
            }
                //Create the client details object, using the objects
                //created above as the parameters
		ClientDetails user = new ClientDetails(ID,nameDetails,
                        addDetails,policies);
                
                //add the client details to the datalist
                dataList.addClient(user);			
            }
        //After the loop is finished return the datalist
        return dataList;
    }
}