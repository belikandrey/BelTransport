package by.bsuir.beltransport.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client extends User {
  @NotBlank(message = "Name should be not blank")
  @Size(min = 3, max = 30, message = "Name length should be more than 3 and less than 30")
  private String name;

  @NotBlank(message = "Surname should be not blank")
  @Size(min = 3, max = 35, message = "Surname length should be more than 3 and less than 35")
  private String surname;

  @Pattern(
      regexp = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",
      message = "Email should be correct. Example : ivanIvanov@gmail.com")
  private String email;

  @Pattern(
      regexp = "^\\+375(17|29|33|44)[0-9]{3}[0-9]{2}[0-9]{2}$",
      message = "Phone number should be like this : +375295054412")
  private String phoneNumber;

  private Integer bonus;

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Basic
  @Column(name = "email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Basic
  @Column(name = "phone_number")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Basic
  @Column(name = "bonus")
  public Integer getBonus() {
    return bonus;
  }

  public void setBonus(Integer bonus) {
    this.bonus = bonus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Client client = (Client) o;
    return Objects.equals(name, client.name)
        && Objects.equals(surname, client.surname)
        && Objects.equals(email, client.email)
        && Objects.equals(phoneNumber, client.phoneNumber)
        && Objects.equals(bonus, client.bonus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), name, surname, email, phoneNumber, bonus);
  }
}
