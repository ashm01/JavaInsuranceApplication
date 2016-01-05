package Insurance;

/**
 * Ashley Moore -18/02/2013 A class that inherits the policy class to create a
 * building policy object
 *
 * @author Ash
 */
public class BuildingPolicy extends Policy {
    
    private double reBuildCost;
    private double risk;
    private final double REBUILD_FACTOR = 0.001;

    /**
     * Default building policy constructor which takes four parameters, it sets
     * the object's fields to the given parameters
     * @param polYear the year when the policy was taken out
     * @param polNum the policy id number
     * @param reBuildCost cost to rebuild the insured building
     * @param risk double between 0-1 risk factor
     * @throws IllegalPolicyException exception error
     */
    public BuildingPolicy(int polYear, String polNum,
            double reBuildCost, double risk) throws IllegalPolicyException {
        //Super constructor for the parent policy class
        super(polNum, polYear);
        //if statement to check the given number is above 0
        if (reBuildCost > 0) {
            this.reBuildCost = reBuildCost;
        } else {
            throw new IllegalPolicyException(
                    "Build cost error!");
        }
        //if statement to check the given number is between 0-1
        if (risk >= 0 && risk <= 1) {
            this.risk = risk;
        } else {
            throw new IllegalPolicyException(
                    "Risk Value Error");

        }
    }

    /**
     * A method to return the reBuildCost of a building policy object
     *
     * @return reBuildCost
     */
    public double getReBuildCost() {
        return reBuildCost;
    }

    /**
     * A method to set the rebuild cost of the building policy object
     * checking whether number is above 0
     *
     * @param reBuildCost the cost to re build the house
     * @throws IllegalPolicyException
     */
    public void setReBuildCost(double reBuildCost) throws IllegalPolicyException {
        //if statement to check the given number is above 0
        if (reBuildCost < 0) {
            this.reBuildCost = reBuildCost;
        } else {
            throw new IllegalPolicyException(
                    "Build cost error!");
        }
    }

    /**
     * Get method to return the risk of the policy object
     * @return risk
     */
    public double getRisk() {
        return risk;
    }

    /**
     * Set method to set the risk of the building policy object whilst checking
     * if the given number is valid
     * @param risk
     * @throws IllegalPolicyException
     */
    public void setRisk(double risk) throws IllegalPolicyException {
        //if statement to check the given number is above 0
        if (risk >= 0 && risk <= 1) {
            this.risk = risk;
        } else {
            throw new IllegalPolicyException(
                    "Risk Value Error");

        }
    }

    /**
     * A method which calculates the premium for the given building policy object
     * and returns the value
     * @return premium of the policy
     */
    @Override
    public double getPremium() {
        double premium;
        //calculating the premium for the polciy
        premium = this.reBuildCost * REBUILD_FACTOR * (1 + this.risk);

        return premium;

    }

    /**
     * toString method which uses string builder to return all the information
     * associated to the building policy object
     * @return
     */
    @Override
    public String toString() {
        //create new string bulder object
        StringBuilder buildDetails = new StringBuilder();
        //appending all the information to the string builder object
        buildDetails.append(String.format("Policy Number:\t\t%s\n", policyNumber));
        buildDetails.append(String.format("Year of Policy:\t\t%d\n" ,yearOfPolicy ));
        buildDetails.append(String.format("Cost to rebuild:\t\t£%.2f\n", reBuildCost ));
        buildDetails.append(String.format("Risk:\t\t%.2f\n", risk));
        buildDetails.append(String.format("Premium: \t\t£%.2f\n" ,getPremium()));
        return buildDetails.toString();

    }
}
