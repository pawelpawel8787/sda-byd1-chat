package sdatwitter.service;

import sdatwitter.model.MyTwitter;
import sdatwitter.model.User;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HP on 2017-12-10.
 */
public class UserService {

    private static UserService _instance;

    private List<User> myUserList;

    private UserService(){
        myUserList = new LinkedList<>();
    }

    public static UserService getInstance(){
        if (_instance == null){
            _instance = new UserService();
        }
        return _instance;
    }
    public void addUser(User user){
        myUserList.add(user);
    }
    public List <User> getMyUserList(){
        return Collections.unmodifiableList(myUserList);
    }
}
