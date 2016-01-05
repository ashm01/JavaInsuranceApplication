package Insurance;

/**
 * Car policy class that inherits the policy class and holds all the information
 * and methods regarding the Car policies
 * Ashley Moore - 18/02/2013
 * @author Ash
 */
public class CarPolicy extends Policy {
    //Declaring the class variables
    private double vehicleValue;
    private int driversAge;
    private int yearsNoClaim;
    private boolean fullyComp;
    //Constant variable of basic cover set to 100
    private final double BASIC_COVER = 100;
    

    /**
     * Default car policy constructor which takes 6 parameters, setting the
     * objects fields to the corresponding parameter values
     * @param vehicleValue the value of the car
     * @param driversAge the age of the driver
     * @param yearsNoClaim the amount of no claims
     * @param fullyComp fully comp - true or false
     * @param polNum the policy ID
     * @param yearPol year of the policy
     * @throws IllegalPolicyException exception error
     */
    public CarPolicy(double vehicleValue, int driversAge, int yearsNoClaim, boolean fullyComp,
            String polNum, int yearPol) throws IllegalPolicyException {
        //Super constructor for the parent policy class
        super(polNum, yearPol);
        //If statement to check the vehicle value is valid
        if (vehicleValue > 0) {
            this.vehicleValue = vehicleValue;
        } else {
            throw new IllegalPolicyException(
                    "Vehicle Value Error");
        }
        //If statement to check the drivers age is valid
        if (driversAge > 16 && driversAge < 100) {
            this.driversAge = driversAge;
        } else {
            throw new IllegalPolicyException(
                    "Driver's Age Error");
        }
        //If statement to check whether the years no claims is valid
        if (yearsNoClaim>0) {
            this.yearsNoClaim = yearsNoClaim;
        } else {
            throw new IllegalPolicyException(
                    "Years no claims Error");
        }
        this.fullyComp = fullyComp;
    }

    /**
     * Get method to return the vehicle value 
     * @return vehicleValue
     */
    public double getVehicleValue() {
        return vehicleValue;
    }

   
    /**
     * A method to set the value of the car
     * @param vehicleValue
     * @throws IllegalPolicyException
     */
    public void setVehicleValue(double vehicleValue)
            throws IllegalPolicyException {
        //if statemnt to check whether the input is valid
         if (vehicleValue > 0) {
            this.vehicleValue = vehicleValue;
        } else {
            throw new IllegalPolicyException(
                    "Vehicle Value Error");
        }
    }

    /**
     * A method to return the age of the driver
     * @return driversAge
     */
    public int getDriversAge() {
        return driversAge;
    }

    /**
     * A method to set the age of the driver
     * @param driversAge
     * @throws IllegalPolicyException
     */
    public void setDriversAge(int driversAge)
            throws IllegalPolicyException {
        //if statement to check whether the input is valid
        if (driversAge > 17 && driversAge < 99) {
            this.driversAge = driversAge;
        } else {
            throw new IllegalPolicyException(
                    "Driver's Age Error");
        }
    }

    /**
     * A method to return the number of years no claims the policy has
     * @return yearsNoClaims
     */
    public int getYearsNoClaim() {
        return yearsNoClaim;
    }

    /**
     * A method to set the number of years no claims
     * @param yearsNoClaim
     * @throws IllegalPolicyException
     */
    public void setYearsNoClaim(int yearsNoClaim)
        throws IllegalPolicyException{
        //if statement to check whether the input is valid
        if (yearsNoClaim>0) {
            this.yearsNoClaim = yearsNoClaim;
        } else {
            throw new IllegalPolicyException(
                    "Years no claims Error");
        }
    }

    /**
     * A method to return if the policy is fully comp or not
     * @return fullyComp
     */
    public boolean isFullyComp() {
        return fullyComp;
    }

    /**
     * A method to set the fullyComp status to either true or false
     * @param fullyComp
     */
    public void setFullyComp(boolean fullyComp) {
        this.fullyComp = fullyComp;
    }
    /**
     * A method which calculates the premium for the given building policy object
     * and returns the value
     * @return premium of the policy
     */
    @Override
    public double getPremium() {
        //initialise the premium to the starting amount of cover
        double premium = Math.max(BASIC_COVER, (this.vehicleValue * 0.1));
        // if statements to calculate the premium for the policy checking
        //against various different criteria
        if(fullyComp){
            //+= replaces "= premium +" premium......
            premium += premium*0.5;
        }
        if(this.driversAge>16 && this.driversAge<26){
            premium += premium*0.5;
        }
        if (this.yearsNoClaim >= 5){
            premium -= premium *0.375;
        }else{
            premium -= (premium*(this.yearsNoClaim*0.075));
        }
        
        return premium;
    }
    
     /**
     * toString method to return all the information associated to the car policy
     * object
     * @return carPolDetails
     */
    @Override
    public String toString() {
        //creating the stringbuilder object
        StringBuilder carPolDetails = new StringBuilder();
        //append all the strings to the string builder
        carPolDetails.append(String.format("Policy Number:\t\t%s\n", policyNumber));
        carPolDetails.append(String.format("Year of Policy:\t\t%d\n" ,yearOfPolicy ));
        carPolDetails.append(String.format("Vehicle Value:\t\t£%.2f\n", vehicleValue));
        carPolDetails.append(String.format("Drivers age:\t\t%d\n", driversAge));
        carPolDetails.append(String.format("Years no claims:\t%d\n", yearsNoClaim));
        //If statement to print out the right statement in regards to whether the
        //policy is fully comp or not
        if (fullyComp=true) {
            carPolDetails.append(String.format("Fully Comp:\t\tYes\n"));          
        } else {
            carPolDetails.append(String.format("Fully Comp:\t\tNo\n"));
        }
        
        carPolDetails.append(String.format("Premium:\t\t£%.2f\n",getPremium()));
        return carPolDetails.toString();

    }
}
