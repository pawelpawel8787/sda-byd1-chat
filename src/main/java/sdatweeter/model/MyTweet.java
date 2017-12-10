package sdatweeter.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "MY_TWEET")
public class MyTweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TWEET_ID")
    private int tweet_id;

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    private User user;

    @Column(name = "TIMESTAMP")
    private Long timestamp;

    @Column(name = "MESSAGE")
    private String message;


}
