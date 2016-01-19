package org.wang.web.service.impl;


import org.wang.web.dao.ProjectDao;
import org.wang.web.model.Project;
import org.wang.web.service.ProjectService;

import java.util.List;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class ProjectServiceImpl implements ProjectService {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private ProjectDao projectDao;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  @Override public void delete(Integer id) {
    projectDao.delete(id);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   *
   * @return  DOCUMENT ME!
   */
  @Override public Project findProject(String name) {
    return projectDao.findProject(name);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   id  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Project get(Integer id) {
    return projectDao.get(id);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public List<Project> list() {
    return projectDao.list();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   project  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Integer save(Project project) {
    return projectDao.save(project);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  projectDao  DOCUMENT ME!
   */
  public void setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  project  DOCUMENT ME!
   */
  @Override public void update(Project project) {
    projectDao.update(project);
  }
} // end class ProjectServiceImpl
