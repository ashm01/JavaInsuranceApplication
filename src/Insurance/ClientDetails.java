package Insurance;

/**
 * Client details class the holds all the information attached to each
 * client
 * Ashley Moore - 21/02/2013
 * @author Ash
 */
public class ClientDetails {
    //Declaring the class variables

    private String clientID;
    private Name clientFullName;
    private Address clientFullAddress;
    private PolicyList clientPolicies;

    /**
     * Default client details constructor which takes 4 parameters, an address
     * name and policy objects along with an client ID string.
     *
     * @param clientID
     * @param clientFullName
     * @param clientFullAddress
     * @param clientPolicies
     */
    public ClientDetails(String clientID, Name clientFullName,
            Address clientFullAddress, PolicyList clientPolicies) {

        this.clientID = clientID;
        this.clientFullName = clientFullName;
        this.clientFullAddress = clientFullAddress;
        this.clientPolicies = clientPolicies;
    }

    /**
     * Get method to return the client ID
     *
     * @return clientID
     */
    public String getClientID() {
        return clientID;
    }

    /**
     * A method to set the client ID
     *
     * @param clientID
     */
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * A method to get the full name of the client
     *
     * @return clientFullName
     */
    public Name getClientFullName() {
        return clientFullName;
    }

    /**
     * A method to set the full name of the client
     *
     * @param clientFullName
     */
    public void setClientFullName(Name clientFullName) {
        this.clientFullName = clientFullName;
    }

    /**
     * A method to return the full address of the client
     *
     * @return clientFullAddress
     */
    public Address getClientFullAddress() {
        return clientFullAddress;
    }

    /**
     * A method to set the full address of the client
     *
     * @param clientFullAddress
     */
    public void setClientFullAddress(Address clientFullAddress) {
        this.clientFullAddress = clientFullAddress;
    }

    /**
     * A method to return a list of polices associated to the client
     *
     * @return clientPolicies
     */
    public PolicyList getClientPolicies() {
        return clientPolicies;
    }

    /**
     * A method to set the list of policies attached to the client
     *
     * @param clientPolicies
     */
    public void setClientPolicies(PolicyList clientPolicies) {
        this.clientPolicies = clientPolicies;
    }

    /**
     * toString method which returns all the information associated to the
     * client
     *
     * @return
     */
    @Override
    public String toString() {
        //Create the stringbuilder object
        StringBuilder clientDetails = new StringBuilder();
        
        //Append all the strings to the clientDetails object       
        clientDetails.append(String.format("Client ID:%s\n",clientID));

        clientDetails.append(String.format("%s\n",clientFullName.toString()));
        clientDetails.append(String.format("%s\n",clientFullAddress.toString()));
        clientDetails.append(String.format("%s\n",clientPolicies.toString()));
        return clientDetails.toString();

    }
}
