package Insurance;

/**
 * Life policy class which inherits the policy class to create a life policy
 * object
 * Ashley Moore 19/02/2013
 * @author Ash
 */
public class LifePolicy extends Policy {
    //defining the class variables
    private int age;
    private int coverAmount;
    private double risk;
    private final double THRESHOLD=60;

    /**
     * Default constructor for the life policy object which takes five
     * parameters and sets the objects fields to appropriate parameter
     * @param age the age of the policy holder 
     * @param covAmount the value of cover
     * @param risk the risk of the policy
     * @param polNum the policy ID
     * @param year the year which the policy was taken
     * @throws IllegalPolicyException if an error occurs
     */
    public LifePolicy(int age, int covAmount, double risk,
            String polNum, int year) throws IllegalPolicyException {
        //Super constructor for the parent policy class
        super(polNum, year);
        //If statement to check the drivers age is valid
        if (age > 16 && age < 100) {
            this.age = age;
        } else {
            throw new IllegalPolicyException(
                    "Driver's Age Error");
        }
        //If statement to check the cover value is valid
        if (covAmount > 0) {
            this.coverAmount = covAmount;
        } else {
            throw new IllegalPolicyException(
                    "Contents Value Error");
        }
        //If statement to check the risk value
        if (risk >= 0 && risk <= 5) {
            this.risk = risk;
        } else {
            throw new IllegalPolicyException(
                    "Risk Value Error");
        }
    }

    /**
     * toString method to return all the information associated to the 
     * life policy object
     * @return lifeDetails
     */
    @Override
    public String toString() {
        StringBuilder lifeDetails = new StringBuilder();

        lifeDetails.append(String.format("Policy Number:\t\t%s\n", policyNumber));
        lifeDetails.append(String.format("Year of Policy:\t\t%d\n" ,yearOfPolicy ));
        lifeDetails.append(String.format("Age:\t\t%d\n", age));
        lifeDetails.append(String.format("Cover Amount:\t\t£%d\n", coverAmount));
        lifeDetails.append(String.format("Risk:\t\t%.2f\n", risk));
        lifeDetails.append(String.format("Premium:\t\t£%.2f\n",getPremium()));
        return lifeDetails.toString();
    }

    /**
     * A method to return the age of the policy holder
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * A method to set the age of the policy holder
     * @param age age of the holder
     * @throws IllegalPolicyException
     */
    public void setAge(int age)
            throws IllegalPolicyException {
        //If statement to check if the age is valid throwing an exception
        //if an error occurs
         if (age > 16 && age < 100) {
            this.age = age;
        } else {
            throw new IllegalPolicyException(
                    "Driver's Age Error");
        }
    }

    /**
     * A method to return the cover amount of the policy
     * @return coverAmount
     */
    public int getCoverAmount() {
        return coverAmount;
    }

    /**
     * A method to set the cover amount of the policy
     * @param coverAmount
     * @throws IllegalPolicyException
     */
    public void setCoverAmount(int coverAmount)
        throws IllegalPolicyException{
        //If statement to check the cover value is valid
        if (coverAmount > 0) {
            this.coverAmount = coverAmount;
        } else {
            throw new IllegalPolicyException(
                    "Contents Value Error");
    }
    }
    /**
     * A method to return the risk of the policy
     * @return risk
     */
    public double getRisk() {
        return risk;
    }

    /**
     * A method to set the risk of the policy object
     * @param risk
     * @throws IllegalPolicyException
     */
    public void setRisk(double risk) throws IllegalPolicyException {
        if (risk >= 0 && risk <= 5) {
            this.risk = risk;
        } else {
            throw new IllegalPolicyException(
                    "Risk Value Error");

        }
    }
    /**
     * A method which calculates the premium for the given life policy object
     * and returns the value
     * @return premium of the policy
     */
    @Override
    public double getPremium() {
        //Initialise the premium to 0 and charge to 50
        double premium = 0;
        double chargePerThousand=50;
        //If statement to determine what equation is to be carried
        if (coverAmount % 1000 == 0) {
            //if the amount is equally divisible by 1000 it does this
            premium = ((coverAmount / 1000)*chargePerThousand) * (1 + risk);
        } else {
            //same equation as before apart from adding 1 to the cov /1000 to
            //take in the remainder as they will charged for an extra thousand
            premium = (((coverAmount / 1000) + 1)*chargePerThousand) * (1 + risk);
        }
        //check whether the age of the holder is under the age threshold and if so
        //premium stays the same otherwise and increase will occur
        if(this.age<THRESHOLD){
            return premium;
        }else {
            premium *= (this.age/THRESHOLD);
            return premium;
        }
    }
}
