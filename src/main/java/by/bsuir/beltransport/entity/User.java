package by.bsuir.beltransport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
  private Integer id;

  @NotBlank(message = "Login should be be not blank")
  @Size(min = 3, max = 35, message = "Login length should be more than 3 and less than 35")
  private String login;

  @NotBlank(message = "Password should be not blank")
  @Size(min = 5, max = 75, message = "Password length should be more than 5 and less than 75")
  private String password;

  private Role role;
  private Status status;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  // Basic
  @Column(name = "login")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  // @Basic
  @Column(name = "password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Column(name = "role")
  @Enumerated(EnumType.STRING)
  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id)
        && Objects.equals(login, user.login)
        && Objects.equals(password, user.password)
        && Objects.equals(role, user.role)
        && Objects.equals(status, user.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, password, role, status);
  }
}
