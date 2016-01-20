package org.wang.web.dao;


import org.wang.web.model.Role;

import java.util.List;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface RoleDao {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  void delete(Integer id);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   name  DOCUMENT ME!
   *
   *                <p>@ return DOCUMENT ME!</p>
   *
   * @return  dOCUMENT ME!
   */
  Role findRole(String name);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findRoles.
   *
   * @param   query  String
   *
   * @return  List
   */
  List<Role> findRoles(String query);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   id  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Role get(Integer id);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for count.
   *
   * @return  int
   */
  int getCount();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  List<Role> list();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * list.
   *
   * @param   start     int
   * @param   pageSize  int
   *
   * @return  List
   */
  List<Role> list(int start, int pageSize);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   role  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Integer save(Role role);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  role  DOCUMENT ME!
   */
  void update(Role role);
} // end interface RoleDao
