package org.wang.web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.wang.web.dao.ProjectDao;
import org.wang.web.model.Project;

import java.util.List;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class ProjectDaoImpl implements ProjectDao {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private SessionFactory sessionFactory;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  UserDao#delete(Integer)
   */
  @Override public void delete(Integer id) {
    getSession().delete(get(id));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   *
   * @return  DOCUMENT ME!
   */
  @Override public Project findProject(String projectName) {
    return (Project) getSession().createQuery("from Project where projectName=?").setParameter(0,projectName).setMaxResults(1).uniqueResult();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  UserDao#get(Integer)
   */
  @Override public Project get(Integer id) {
    return (Project) getSession().get(Project.class, id);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public List<Project> list() {
    return getSession().createQuery("from Project").list();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   */
  @Override public Integer save(Project project) {
    return (Integer) getSession().save(project);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   */
  @Override public void update(Project project) {
    getSession().saveOrUpdate(project);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }


} // end class UserDaoImpl
