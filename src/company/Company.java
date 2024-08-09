package company;

/**
 * Represents a Company with details such as company ID, address ID, company name, and company phone.
 */
public class Company {
    private int companyId; // Unique identifier for the company
    private int addressId; // Identifier for the associated address
    private String companyName; // Name of the company
    private String companyPhone; // Phone number of the company

    /**
     * Gets the unique identifier for the company.
     *
     * @return the company ID
     */
    public int getCompanyId() {
        return companyId;
    }

    /**
     * Sets the unique identifier for the company.
     *
     * @param companyId the company ID to set
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /**
     * Gets the identifier for the associated address.
     *
     * @return the address ID
     */
    public int getAddressId() {
        return addressId;
    }

    /**
     * Sets the identifier for the associated address.
     *
     * @param addressId the address ID to set
     */
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets the name of the company.
     *
     * @return the company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the name of the company.
     *
     * @param companyName the company name to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets the phone number of the company.
     *
     * @return the company phone
     */
    public String getCompanyPhone() {
        return companyPhone;
    }

    /**
     * Sets the phone number of the company.
     *
     * @param companyPhone the company phone to set
     */
    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }
}