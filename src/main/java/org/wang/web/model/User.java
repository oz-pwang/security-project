package org.wang.web.model;

import java.io.Serializable;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity public class User implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -9177723428302689841L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column private Integer age;

  @Column private Date birthDate;

  @Transient private String birthDateString;


  @Transient private String rolename;

  @Column private String email;

  @Column(
    nullable = true,
    length   = 6
  )
  private String gender="male";

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id private Integer id;

  @Column(
    nullable = false,
    length   = 50
  )
  private String password;

  @Column private String phoneNumber;

  @Basic(fetch = FetchType.LAZY)
  @Column(
    name             = "IMGS",
    columnDefinition = "BLOB",
    nullable         = true
  )
  @Lob private byte[] photo;

  @OneToMany(
    cascade  = CascadeType.ALL,
    mappedBy = "creator"
  )
  private Set<Project> projectSet = new LinkedHashSet<Project>();


  @JoinColumn(name = "roleId")
  @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
  private Role role;

  @Column(
    nullable = false,
    length   = 30
  )
  private String username;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAge() {
    return age;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getBirthDate() {
    return birthDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBirthDateString() {
    return birthDateString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEmail() {
    return email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGender() {
    return gender;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPassword() {
    return password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public byte[] getPhoto() {
    return photo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for project set.
   *
   * @return  Set
   */
  public Set<Project> getProjectSet() {
    return projectSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for role.
   *
   * @return  Role
   */
  public Role getRole() {
    return role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getUsername() {
    return username;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  age  DOCUMENT ME!
   */
  public void setAge(Integer age) {
    this.age = age;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  birthDate  DOCUMENT ME!
   */
  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  birthDateString  DOCUMENT ME!
   */
  public void setBirthDateString(String birthDateString) {
    this.birthDateString = birthDateString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  email  DOCUMENT ME!
   */
  public void setEmail(String email) {
    this.email = email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  gender  DOCUMENT ME!
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Integer id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  password  DOCUMENT ME!
   */
  public void setPassword(String password) {
    this.password = password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNumber  DOCUMENT ME!
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  photo  DOCUMENT ME!
   */
  public void setPhoto(byte[] photo) {
    this.photo = photo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for project set.
   *
   * @param  projectSet  Set
   */
  public void setProjectSet(Set<Project> projectSet) {
    this.projectSet = projectSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role.
   *
   * @param  role  Role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  username  DOCUMENT ME!
   */
  public void setUsername(String username) {
    this.username = username;
  }

  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }

} // end class User
