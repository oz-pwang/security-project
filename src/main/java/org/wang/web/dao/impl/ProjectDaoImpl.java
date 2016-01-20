package org.wang.web.dao.impl;

import java.util.List;

import org.wang.web.dao.BaseDao;
import org.wang.web.dao.ProjectDao;
import org.wang.web.model.Project;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author $author$
 * @version $Revision$, $Date$
 */
public class ProjectDaoImpl extends BaseDao implements ProjectDao {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * delete.
   *
   * @param id Integer
   */
  @Override
  public void delete(Integer id) {
    getSession().delete(get(id));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param projectName String
   * @return DOCUMENT ME!
   */
  @Override
  public Project findProject(String projectName) {
    return (Project) getSession().createQuery("from Project where projectName=?").setParameter(0, projectName)
        .setMaxResults(1).uniqueResult();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**

   */
  @Override
  public Project get(Integer id) {
    return (Project) getSession().get(Project.class, id);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  @Override
  public List<Project> list() {
    return getSession().createQuery("from Project").list();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * save.
   *
   * @param project Project
   * @return Integer
   */
  @Override
  public Integer save(Project project) {
    return (Integer) getSession().save(project);
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param project Project
   */
  @Override
  public void update(Project project) {
    getSession().saveOrUpdate(project);
  }

  //~ ------------------------------------------------------------------------------------------------------------------



} // end class ProjectDaoImpl
