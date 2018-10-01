package domain;
import domain.User;

/**
 *
 * @author 687159
 */
public class UserService {
    
    String username;
    String password;
    
    String user1 = "adam";
    String user2 = "betty";
    String pass  = "password";
    
    public User login(String username, String password)
    {
        User user = new User(username, password);
        
        if((!username.equals(user1) || !username.equals(user2)) && !password.equals(pass))
        {
            return null;
        }
        else
        {
            return user;
        }
    }
    
}
