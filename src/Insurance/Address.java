package Insurance;

/**
 * The address class contains the information regarding all the users
 * address details in the insurance system which include 
 * street, town and postcode
 * @author Ash
 */
public class Address implements Comparable<Address> {
    //Class variables
    private String street;
    private String townCity;
    private String postcode;
    

    /**
     * The default constructor for Address
     * Sets the objects variables to the given parameters
     * @param street the street where the user lives
     * @param townCity the town where the user lives
     * @param postcode the postcode for their address
     */
    public Address(String street, String townCity, String postcode) {
        //assigning the given information to the object
        this.street = street;
        this.townCity = townCity;
        this.postcode = postcode.toUpperCase();
    }

    /**
     * toString method that returns the full address of the user
     * in an appropriate format.
     * @return the full address associated to the user.
     */
    @Override
    public String toString() {
        //String.format used to display the information correctly
        String address = String.format("Address: %s, %s, %s", street, townCity, postcode);
        return address;
    }

    /**
     * Get method to return the street of the user's address. 
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set method to assign a string value to the street field 
     * of the address object
     * @param street the street data of the address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get method to return the town or city of the user's address 
     * @return townCity
     */
    public String getTownCity() {
        return townCity;
    }

    /**
     * Set method to assign a string value to the townCity field of
     * the address object
     * @param townCity
     */
    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    /**
     * Get method to return the postcode of the user's address
     * @return postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Set method to assign a string value to the postCode field
     * of the address object
     * @param postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode.toUpperCase();
    }


    /**
     * compareTo method to determine if there is a match when a given
     * address is compared to another address objects
     * 
     * @param t address data to be compared against another addresses
     * @return the number of matches from the search
     */
    @Override
    public int compareTo(Address t) {
        //result will be 1 if there is a match or 0 if not
        int results = this.toString().compareTo(t.toString());
        return results;
    }
}
