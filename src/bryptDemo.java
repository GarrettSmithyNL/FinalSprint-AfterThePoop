import org.mindrot.jbcrypt.BCrypt;

public class bryptDemo {
  public static void main(String[] args) {
    String password = "password";
    String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
    System.out.println(password);
    System.out.println(hashed);
    System.out.println(BCrypt.checkpw(password, hashed));

  }
}
