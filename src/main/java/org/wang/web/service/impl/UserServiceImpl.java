package org.wang.web.service.impl;


import org.wang.web.dao.UserDao;
import org.wang.web.model.User;
import org.wang.web.service.UserService;

import java.util.List;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class UserServiceImpl implements UserService {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private UserDao userDao;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  @Override public void delete(Integer id) {
    userDao.delete(id);
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
    return userDao.findUser(username, password);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   id  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public User get(Integer id) {
    return userDao.get(id);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public List<User> list() {
    return userDao.list();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   user  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Integer save(User user) {
    return (Integer)userDao.save(user);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  userDao  DOCUMENT ME!
   */
  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  user  DOCUMENT ME!
   */
  @Override public void update(User user) {
    userDao.update(user);
  }

  @Override
  public User findByUserName(String username) {
    return userDao.findByUserName(username);
  }
} // end class UserServiceImpl
