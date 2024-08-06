package address;

import java.util.ArrayList;

public class AddressServices {
    private AddressDAO addressDAO;

    public AddressServices() {
        this.addressDAO = new AddressDAO();
    }

    public Address getAddressById(int id) {
        return addressDAO.getById(id);
    }

    public ArrayList<Address> getAllAddresses() {
        return addressDAO.getAll();
    }

    public void addAddress(Address address) {
        addressDAO.insert(address);
    }

    public void updateAddress(Address address) {
        addressDAO.update(address);
    }

    public void deleteAddress(Address address) {
        addressDAO.delete(address);
    }
}
