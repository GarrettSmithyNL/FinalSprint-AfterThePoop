package address;

import java.util.ArrayList;

/**
 * Service class for managing Address entities.
 * Provides methods to perform CRUD operations using AddressDAO.
 */
public class AddressServices {
    private AddressDAO addressDAO;

    /**
     * Constructor for AddressServices.
     * Initializes the AddressDAO instance.
     */
    public AddressServices() {
        this.addressDAO = new AddressDAO();
    }

    /**
     * Retrieves an address by its ID.
     *
     * @param id the ID of the address to retrieve
     * @return the Address object with the specified ID
     */
    public Address getAddressById(int id) {
        return addressDAO.getById(id);
    }

    /**
     * Retrieves all addresses from the database.
     *
     * @return an ArrayList of Address objects
     */
    public ArrayList<Address> getAllAddresses() {
        return addressDAO.getAll();
    }

    /**
     * Adds a new address to the database.
     *
     * @param address the Address object to add
     * @return the ID of the newly inserted address, or -1 if the insertion failed
     */
    public int addAddress(Address address) {
        return addressDAO.insert(address);
    }

    /**
     * Updates an existing address in the database.
     *
     * @param address the Address object with updated information
     */
    public void updateAddress(Address address) {
        addressDAO.update(address);
    }

    /**
     * Deletes an address from the database.
     *
     * @param address the Address object to delete
     */
    public void deleteAddress(Address address) {
        addressDAO.delete(address);
    }
}