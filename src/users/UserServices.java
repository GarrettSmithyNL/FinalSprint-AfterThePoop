package users;

import org.mindrot.jbcrypt.BCrypt;

public class UserServices {
    private UserDAO userDAO;

    public UserServices() {
        this.userDAO = new UserDAO();
    }

    // Handles authentication (READ)
    public boolean authenticate(String email, String password) {
        User user = userDAO.getByEmail(email);
        return user != null && BCrypt.checkpw(password, user.getPassword());
    }

    // Registration (CREATE)
    public void register(User user) {
        userDAO.insert(user);
    }

    // Profile modification (UPDATE)
    public void updateProfile(User user) {
        userDAO.update(user);
    }

    // Password reset (UPDATE)
    public void resetPassword(String email, String newPassword) {
        User user = userDAO.getByEmail(email);
        if (user != null) {
            user.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
            userDAO.update(user);
        }
    }

    // Enter email, phone number (UPDATE)
    public void updateEmail(int userId, String newEmail) {
        User user = userDAO.getById(userId);
        if (user != null) {
            user.setEmail(newEmail);
            userDAO.update(user);
        }
    }

    public void updatePhoneNumber(int userId, String newPhoneNumber) {
        User user = userDAO.getById(userId);
        if (user != null) {
            user.setUserPhone(newPhoneNumber);
            userDAO.update(user);
        }
    }
}