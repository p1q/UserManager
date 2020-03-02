package UserManager.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.Month;

@NamedQueries({
        @NamedQuery(name = User.ALL, query = "SELECT u FROM User u ORDER BY u.name"),
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.GET, query = "SELECT u FROM User u WHERE u.id=:id")
})

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "login", name = "users_unique_login_idx")})
public class User {
    public static final String ALL = "User.getAll";
    public static final String DELETE = "User.delete";
    public static final String GET = "User.get";
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @Column(name = "last_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String surname;

    @Column(name = "birthday", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime birthday;

    @Column(name = "login", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String login;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @Column(name = "about_myself", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String aboutMyself;

    @Column(name = "address", nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String address;

    public User() {
    }

    public User(Integer id,
                @NotBlank @Size(min = 2, max = 100) String name,
                @NotBlank @Size(min = 2, max = 100) String surname,
                @NotBlank @Size(min = 5, max = 100) String login,
                @NotBlank @Size(min = 5, max = 100) String password,
                @NotBlank @Size(min = 2, max = 100) String aboutMyself,
                @NotBlank @Size(min = 2, max = 50) String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        birthday = LocalDateTime.of(2015, Month.JUNE, 1, 18, 0);
        this.login = login;
        this.password = password;
        this.aboutMyself = aboutMyself;
        this.address = address;
    }

    public User(Integer id, String name, String surname, LocalDateTime birthday,
                String login, String password, String aboutMyself, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.login = login;
        this.password = password;
        this.aboutMyself = aboutMyself;
        this.address = address;
    }

    public User(String name, String surname, LocalDateTime birthday,
                String login, String password, String aboutMyself, String address) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.login = login;
        this.password = password;
        this.aboutMyself = aboutMyself;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + surname + '\'' +
                ", birthday=" + birthday +
                ", login='" + login + '\'' +
                ", aboutMyself='" + aboutMyself + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
