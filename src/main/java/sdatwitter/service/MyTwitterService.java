package sdatwitter.service;

import sdatwitter.model.MyTwitter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HP on 2017-12-10.
 */
public class MyTwitterService {

    private static MyTwitterService _instance;

    private List<MyTwitter> myTweetList;

    private MyTwitterService(){
        myTweetList = new LinkedList<MyTwitter>();
    }

    public static MyTwitterService getInstance(){
        if (_instance == null){
            _instance = new MyTwitterService();
        }
        return _instance;
    }
    public void addTweet(MyTwitter tweet){
        myTweetList.add(tweet);
    }
    public List <MyTwitter>  getMyTweetList(){
        return Collections.unmodifiableList(myTweetList);
    }

}
