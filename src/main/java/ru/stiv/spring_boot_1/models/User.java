package myappweb.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Это поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Слишком длинное имя")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "Это поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Слишком длинная фамилия")
    @Column(name = "lastname")
    private String lastname;
    @Min(value = 0, message = "Возвраст не может быть отрицательным")
    @Column(name = "age")
    private int age;
    @NotEmpty(message = "Это поле не должно быть пустым")
    @Email(message = "Адрес эл.почты некорректный")
    @Column(name = "email")
    private String email;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
