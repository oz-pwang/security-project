import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * Created by ozintel06 on 16/7/24.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  07/27/2016 21:39
 */
@Entity
public class Consumer implements Serializable ,UserDetails {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 917331463781881956L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @OneToMany
  private Set<Address> addressSet;

  @Column(
    length   = 100,
    nullable = false
  )
  private String answer;

  @Column
  private Integer balance;

  @Column(nullable = false)
  private Date createDate;

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @Column(
    length   = 18,
    nullable = false
  )
  private String IDcard;

  @OneToMany
  private Set<Indent> indentSet;


  @Column(
    length   = 12,
    nullable = false
  )
  private String name;

  @Column(
    length   = 16,
    nullable = false
  )
  private String passWord;

  @Column(
    length   = 11,
    nullable = false
  )
  private String phoneNumber;

  @Column(
    length   = 100,
    nullable = false
  )
  private String question;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for address set.
   *
   * @return  Set
   */
  public Set<Address> getAddressSet() {
    return addressSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer.
   *
   * @return  String
   */
  public String getAnswer() {
    return answer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance.
   *
   * @return  Integer
   */
  public Integer getBalance() {
    return balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for create date.
   *
   * @return  Date
   */
  public Date getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for IDcard.
   *
   * @return  String
   */
  public String getIDcard() {
    return IDcard;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for indent set.
   *
   * @return  Set
   */
  public Set<Indent> getIndentSet() {
    return indentSet;
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
   * getter method for pass word.
   *
   * @return  String
   */
  public String getPassWord() {
    return passWord;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone number.
   *
   * @return  String
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for question.
   *
   * @return  String
   */
  public String getQuestion() {
    return question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address set.
   *
   * @param  addressSet  Set
   */
  public void setAddressSet(Set<Address> addressSet) {
    this.addressSet = addressSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer.
   *
   * @param  answer  String
   */
  public void setAnswer(String answer) {
    this.answer = answer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance.
   *
   * @param  balance  Integer
   */
  public void setBalance(Integer balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for create date.
   *
   * @param  createDate  Date
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for IDcard.
   *
   * @param  IDcard  String
   */
  public void setIDcard(String IDcard) {
    this.IDcard = IDcard;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for indent set.
   *
   * @param  indentSet  Set
   */
  public void setIndentSet(Set<Indent> indentSet) {
    this.indentSet = indentSet;
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
   * setter method for pass word.
   *
   * @param  passWord  String
   */
  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone number.
   *
   * @param  phoneNumber  String
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for question.
   *
   * @param  question  String
   */
  public void setQuestion(String question) {
    this.question = question;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority(this.getClass().getName()));
    return authorities;
  }

  @Override
  public String getPassword() {
    return this.passWord;
  }

  @Override
  public String getUsername() {
    return this.name;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }
} // end class Consumer
