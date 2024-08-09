package users;

/**
 * Represents a User with details such as user ID, address ID, company ID, user name, email, password, phone number, and admin status.
 */
public class User {
    private int userId; // Unique identifier for the user
    private int addressId; // ID of the address associated with the user
    private int companyId; // ID of the company associated with the user
    private String userName; // Name of the user
    private String email; // Email of the user
    private String password; // Password of the user
    private String userPhone; // Phone number of the user
    private boolean isAdmin; // Admin status of the user

    // Getters and setters

    /**
     * Gets the unique identifier for the user.
     *
     * @return the user ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier for the user.
     *
     * @param userId the user ID to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the ID of the address associated with the user.
     *
     * @return the address ID
     */
    public int getAddressId() {
        return addressId;
    }

    /**
     * Sets the ID of the address associated with the user.
     *
     * @param addressId the address ID to set
     */
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets the ID of the company associated with the user.
     *
     * @return the company ID
     */
    public int getCompanyId() {
        return companyId;
    }

    /**
     * Sets the ID of the company associated with the user.
     *
     * @param companyId the company ID to set
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /**
     * Gets the name of the user.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the name of the user.
     *
     * @param userName the user name to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the email of the user.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the phone number of the user.
     *
     * @return the user phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param userPhone the user phone to set
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * Gets the admin status of the user.
     *
     * @return true if the user is an admin, false otherwise
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Sets the admin status of the user.
     *
     * @param isAdmin the admin status to set
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}