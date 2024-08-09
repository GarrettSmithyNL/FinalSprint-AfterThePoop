package address;

/**
 * Represents an Address with details such as street, city, province, and postal code.
 */
public class Address {
    private int addressId; // Unique identifier for the address
    private String street; // Street name and number
    private String city; // City name
    private String province; // Province or state name
    private String postalCode; // Postal or ZIP code

    /**
     * Gets the unique identifier for the address.
     *
     * @return the address ID
     */
    public int getAddressId() {
        return addressId;
    }

    /**
     * Sets the unique identifier for the address.
     *
     * @param addressId the address ID to set
     */
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets the street name and number.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street name and number.
     *
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the city name.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city name.
     *
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the province name.
     *
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province name.
     *
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets the postal code.
     *
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code.
     *
     * @param postalCode the postal code to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}