package sdatweeter.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table (name = "USER_DETAILS")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int user_id;

    @Column(name = "NICK")
    private String nick;

    @Column(name = "PASS")
    private String pass;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<MyTweet> orderList = new ArrayList<MyTweet>();


}
