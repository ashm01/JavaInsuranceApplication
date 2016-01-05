package Insurance;

import java.util.*;

/**
 * Ashley Moore 21/02/2013
 *
 * @author Ash
 */
public class ClientDetailsList {
    //Defining the class variable arraylist

    ArrayList<ClientDetails> clientDetailsList = new ArrayList<>();

    /**
     * Default constructor for the clientDetails list which is initiated to 0 in
     * size
     */
    public ClientDetailsList() {

        clientDetailsList.size();
    }

    /**
     * A method to add a client to the client list
     *
     * @param c client details object
     */
    public void addClient(ClientDetails c) {

        clientDetailsList.add(c);
    }

    /**
     * A method to return the total number of clients in the list
     *
     * @return size of list
     */
    public int getNumberOfClients() {

        return clientDetailsList.size();
    }

    /**
     * A toString method to return all the details from all the clients
     *
     * @return listDetails
     */
    @Override
    public String toString() {
        //creating the stringbuilder object
        StringBuilder listDetails = new StringBuilder();
        //for loop to iterate through the list, so each object is then
        //added to the string builder using .append then the indiviual
        //objects's toString method is invoked
        for (int i = 0, n = clientDetailsList.size(); i < n; i++) {
            listDetails.append(clientDetailsList.get(i).toString());
            listDetails.append("------------------------------------------"
                    + "---------------------------\n");
        }
        return listDetails.toString();
    }

    /**
     * A method to determine whether or not a given person, identified by a
     * surname and a postcode is a client of the Insurance company. If so, the
     * client's ID should be returned.
     *
     * @param lastName the surname of the person to be searched for.
     * @param code the postcode of the address of the person to be searched for.
     * @return the Client ID if the person has at least one policy with the
     * company, null otherwise.
     */
    public String findClient(String lastName, String code) {
        //for each loop to iterate through the entire list
        for (ClientDetails temp : clientDetailsList) {
            //through each loop, initialise these two temp variables
            String tempLastName = temp.getClientFullName().
                    getSurname();
            String tempPostcode = temp.getClientFullAddress().
                    getPostcode();
            //Checks the temp strings against clients data to see if there is a 
            //match. If so returns the client ID
            if (lastName.toUpperCase().equals(tempLastName)
                    && code.toUpperCase().equals(tempPostcode)) {
                return temp.getClientID();
            }
        }
        //If not match return this message
        return "Client Not Found";
    }

    /**
     * A method to get the client details corresponding to a given client ID.
     *
     * @param clientID the client ID whose details are required.
     *
     * @return the required ClientDetails if found, null otherwise.
     */
    public ClientDetails getClientDetails(String givenID) {
        if ("".equals(givenID)){
            return null;
        }else{
        //for each loop to loop through each item in the list
        for (ClientDetails temp : clientDetailsList) {
            //Checking the temp ID against all IDs in the list
            if (temp.getClientID().contains(givenID)
                ) {
                //If there is a match return temp(ClientDetails)
                return temp;
            }
        }
        //if there isnt a match null is returned
        return null;
    }}

    /**
     * A method to determine another client who has the same address as the
     * client whose details are given.
     *
     * @param cDetails the client details whose address is to be searched for.
     * @return the ClientDetails of a client with the same address if there is
     * one, null otherwise.
     *
     */
    public ClientDetails sameAddressCheck(ClientDetails cDetails) {
        
        String address = cDetails.getClientFullAddress().toString();
        //for each loop to iterate through the list
        for (ClientDetails temp : clientDetailsList) {
            //if statement to check the given address against all other addresses
            if (address.matches(temp.getClientFullAddress().toString())&&
                    cDetails.getClientID()!=temp.getClientID())
                     {
                //if there is a match return the matched object
                
                return temp;
            }
        }
        //if no match null is returned
        return null;
    }
}
