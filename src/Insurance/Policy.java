

package Insurance;

import java.util.Calendar;

/*
 * Ashley Moore - 18/02/2013
 * An abstract Java class the will act as the base class for 
 * the rest of the policy classes
 * @author Ash
 */
public abstract class Policy {
    //Defining the class variables
    protected String policyNumber;
    protected int yearOfPolicy;
    private int year = Calendar.getInstance().get(Calendar.YEAR);

    /**
     * Default Policy object constructor with two parameters,
     * which are passed through individual checks to validate they
     * are appropriate data
     * 
     * @param polNum
     * @param yearPol
     * @throws IllegalPolicyException
     */
    public Policy(String polNum, int yearPol)
            throws IllegalPolicyException {
        
        //IF statement used with the argument that the string should 
        //match the format illustrated(\\d=number)
        if (polNum.matches("[BCLV][\\d][\\d][\\d][\\d][\\d][\\d][\\d][\\d]")) {
            //If the string is valid, set the policy number to the given string
            //Else throw an exception error
            this.policyNumber = polNum;
        } else {
            throw new IllegalPolicyException(
                    "Policy Number Error");
        }
        //check the given number is in between the correct years
        if (yearPol> 1989 && yearPol <= year) {
            this.yearOfPolicy = yearPol;
        } else {
            throw new IllegalPolicyException(
                    "Policy Year out of range");
        }

    }

    /**
     * Retrieves the policy number for the given policy object
     * @return policyNumber 
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number of the policy object to a given string
     * variable
     * @param policyNumber the String of the new policy number
     */
    public void setPolicyNumber(String policyNumber)
    throws IllegalPolicyException{
          if (policyNumber.matches("[BCLV][\\d][\\d][\\d][\\d][\\d][\\d]"
                  + "[\\d][\\d]")) {
            //If the string is valid, set the policy number to the given string
            //Else throw an exception error
            this.policyNumber = policyNumber;
        } else {
            throw new IllegalPolicyException(
                    "Policy Number Error");
        }
    }

    /**
     * Retrieves the year of which the policy was taken out 
     * @return yearOfPolicy
     */
    public int getYearOfPolicy() {
        return yearOfPolicy;
    }

    /**
     * Sets the year in which the policy was taken out
     * @param yearOfPolicy the year of the policy
     */
    public void setYearOfPolicy(int yearOfPolicy)throws IllegalPolicyException {
        //check the given number is in between the correct years
        if (yearOfPolicy> 1989 && yearOfPolicy <= year) {
            this.yearOfPolicy = yearOfPolicy;
        } else {
            throw new IllegalPolicyException(
                    "Policy Year out of range");
        }
    }

    /**
     * A toString method to return the information of the policy object
     * @return policy
     */
    @Override
    public String toString() {
        String policy = String.format
                ("Policy ID: %s\n, Year%d", policyNumber, yearOfPolicy);
        return policy;
                
    }
    
    /**
     * Abstract method that must be over written by all classes
     * inheriting the policy class.
     * @return
     */
    abstract public double getPremium();
}   
