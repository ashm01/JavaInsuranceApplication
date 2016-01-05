package Insurance;

/**
 * Ashley Moore 19/02/2013
 * Contents Policy class which inherits the policy class and
 * creates the content policy objects
 * @author Ash
 */
public class ContentPolicy extends Policy {
    //Defining the class variables
    private double risk;
    private double contentsValue;
    private final double CONTENTS_FACTOR = 0.01;

    /**
     * Default constructor for the content policy which takes
     * four parameters
     * @param year the year when the policy was taken out
     * @param polNum the ID number for the policy
     * @param risk the risk value 
     * @param contentsValue the value of the contents
     * @throws IllegalPolicyException
     */
    public ContentPolicy(int year, String polNum,
            double contentsValue ,double risk) throws IllegalPolicyException {
        //Invokes the super policy constructor
        super(polNum,year);
        //If statement to check if the value is above 0
        if (contentsValue > 0) {
            this.contentsValue = contentsValue;     
        } else {
            throw new IllegalPolicyException(
                    "Contents Value Error");
        }
        //If statement to insure the value is between 0-1
        if (risk >= 0 && risk <= 1) {
            this.risk = risk;
        } else {
            throw new IllegalPolicyException(
                    "Risk Value Error");
        }
    }

    /**
     * A method to get the risk value of the policy
     * @return risk
     */
    public double getRisk() {
        return risk;
    }

    /**
     * A method to set the risk value of the policy object
     * @param risk risk value of the policy
     */
    public void setRisk(double risk)throws IllegalPolicyException {
        //If statement to check if the risk is valid
        if (risk >= 0 && risk <= 1) {
            this.risk = risk;
        } else {
            throw new IllegalPolicyException(
                    "Risk Value Error");
        }
    }

    /**
     * A method to get the contents value of the policy object
     * @return contents value of the home
     */
    public double getContentsValue() {
        return contentsValue;
    }

    /**
     * A method to set the contents value for the policy
     * @param contentsValue the value of the contents
     * @throws IllegalPolicyException exception error
     */
    public void setContentsValue(double contentsValue) 
        throws IllegalPolicyException {
        //If statement to check that the contents value is
        //above 0
        if (contentsValue > 0) {
            this.contentsValue = contentsValue;     
        } else {
            throw new IllegalPolicyException(
                    "Contents Value Error");
        }
    }
    /**
     * A method to work out the premium for the policy
     * @return premium 
     */
    @Override
    public double getPremium() {
        double premium;
        //the calculation to work out the premium for the policy
        premium = this.contentsValue * CONTENTS_FACTOR * (1 + this.risk);

        return premium;
    }

    /**
     * toString method which uses the string builder to return all the
     * information associated to the contents policy object
     * @return
     */
    @Override
    public String toString() {

        StringBuilder contentDetails = new StringBuilder();

         contentDetails.append(String.format("Policy Number:\t\t%s\n", policyNumber));
         contentDetails.append(String.format("Year of Policy:\t\t%d\n" ,yearOfPolicy ));
         contentDetails.append(String.format("Contents Value:\t\t£%.2f\n",contentsValue));
         contentDetails.append(String.format("Risk:\t\t%.2f\n", risk));
         contentDetails.append(String.format("Premium: \t\t£%.2f\n" ,getPremium()));
         return contentDetails.toString();

    }
}
