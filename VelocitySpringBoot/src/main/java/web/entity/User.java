package web.entity;

import javax.persistence.*;

/**
 * Created by EGBoldyr on 05.03.18.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @SequenceGenerator(name = "userId", sequenceName = "user_id_seq", initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userId")
    private Long userId;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String email;

    public User() {}

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Long getUserId() {

        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
