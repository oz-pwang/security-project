package org.wang.web.model;

import java.io.Serializable;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * Created by Administrator on 2015/9/6.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  01/14/2016 17:58
 */
@Entity public class Role implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -2977309122139788243L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(length = 255)
  private String description;


  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id private Integer id;

  @Column(
    length   = 20,
    nullable = false,
    unique   = true
  )
  private String name;


  @OneToMany
  private Set<User> users;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Integer
   */
  public Integer getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for users.
   *
   * @return  Set
   */
  public Set<User> getUsers() {
    return users;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Integer
   */
  public void setId(Integer id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for users.
   *
   * @param  users  Set
   */
  public void setUsers(Set<User> users) {
    this.users = users;
  }
} // end class Role
