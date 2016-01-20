package org.wang.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class BaseDao {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private SessionFactory sessionFactory;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sessionFactory  DOCUMENT ME!
   */
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session.
   *
   * @return  Session
   */
  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }
} // end class BaseDaoImpl
