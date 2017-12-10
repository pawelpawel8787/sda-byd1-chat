package sdatweeter.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "nick")
    private String nick;

    @Column(name = "pass")
    private String pass;

    @OneToMany(mappedBy="user_id", cascade = CascadeType.ALL)
    private List<MyTweet> orderList = new ArrayList<MyTweet>();


}
