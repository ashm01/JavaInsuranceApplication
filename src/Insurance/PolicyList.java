package Insurance;

import java.util.*;

/**
 * Ashley Moore - 20/02/2013
 * Policy list class which will create the list to hold all policies
 * for each client
 * @author Ash
 */
public class PolicyList {
    //Define the class variable
    private ArrayList<Policy> policyList = new ArrayList<>();

    /**
     * Default constructor for the policy list, which is set initialised to 
     * 0 in size
     */
    public PolicyList() {

        policyList.size();
    }

    /**
     * A method to add policies to the policy list
     * @param p policy to be added
     */
    public void addPolicy(Policy p) {

        policyList.add(p);
    }

    /**
     * A  method to return the number of objects in the list
     * @return
     */
    public int getNumberOfPolicies() {

        return policyList.size();
    }

    /**
     * toString method to return all the information of every policy contained
     * in the policy list
     * @return
     */
    @Override
    public String toString() {
        //Create string builder object
        StringBuilder listDetails = new StringBuilder();
        //Iterate through list to append all policies to the stringbuilder
        for (int i = 0, n = policyList.size(); i < n; i++) {
            //add the policy details to the stringbuilder
            listDetails.append("\nPolicy " +(i+1)+ ":\n"+policyList.get(i).toString());
            
        }
        return listDetails.toString();
    }
}
