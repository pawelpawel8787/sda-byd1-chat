package sdatwitter.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table (name = "USERS")
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
    private List<MyTwitter> orderList = new ArrayList<MyTwitter>();


}
