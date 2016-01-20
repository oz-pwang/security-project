package org.wang.web.dao.impl;

import java.util.List;

import org.wang.web.dao.BaseDao;
import org.wang.web.dao.UserDao;
import org.wang.web.model.User;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class UserDaoImpl extends BaseDao implements UserDao {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.wang.web.dao.UserDao#delete(java.lang.Integer)
   */
  @Override public void delete(Integer id) {
    getSession().delete(get(id));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.wang.web.dao.UserDao#findByUserName(java.lang.String)
   */
  @Override public User findByUserName(String username) {
    return (User) getSession().createQuery("from User where username = ? ").setParameter(0,
        username).setMaxResults(1).uniqueResult();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   username  DOCUMENT ME!
   * @param   password  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public User findUser(String username, String password) {
    return (User) getSession().createQuery("from User where username = ? and password = ?").setParameter(0,
        username).setParameter(1, password).setMaxResults(1).uniqueResult();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * get.
   *
   * @param   id  Integer
   *
   * @return  User
   */
  @Override public User get(Integer id) {
    return (User) getSession().get(User.class, id);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public List<User> list() {
    return getSession().createQuery("from User").list();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * save.
   *
   * @param   user  User
   *
   * @return  Integer
   */
  @Override public Integer save(User user) {
    return (Integer) getSession().save(user);
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  org.wang.web.dao.UserDao#update(org.wang.web.model.User)
   */
  @Override public void update(User user) {
    getSession().saveOrUpdate(user);
  }

} // end class UserDaoImpl
