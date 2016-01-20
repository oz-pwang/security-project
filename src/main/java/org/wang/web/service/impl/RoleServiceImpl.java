package org.wang.web.service.impl;


import java.util.List;

import org.wang.web.dao.RoleDao;
import org.wang.web.model.Role;
import org.wang.web.service.RoleService;


/**
 * Created by Administrator on 2015/9/6.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  01/14/2016 17:58
 */
public class RoleServiceImpl implements RoleService {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private RoleDao roleDao;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.wang.web.service.RoleService#delete(java.lang.Integer)
   */
  @Override public void delete(Integer id) {
    roleDao.delete(id);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.wang.web.service.RoleService#findRole(java.lang.String)
   */
  @Override public Role findRole(String name) {
    return roleDao.findRole(name);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.wang.web.service.RoleService#findRoles(java.lang.String)
   */
  @Override public List<Role> findRoles(String query) {
    return roleDao.findRoles(query);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.wang.web.service.RoleService#get(java.lang.Integer)
   */
  @Override public Role get(Integer id) {
    return roleDao.get(id);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.wang.web.service.RoleService#getCount()
   */
  @Override public int getCount() {
    return roleDao.getCount();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.wang.web.service.RoleService#list()
   */
  @Override public List<Role> list() {
    return roleDao.list();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.wang.web.service.RoleService#list(int, int)
   */
  @Override public List<Role> list(int start, int pageSize) {
    return roleDao.list(start, pageSize);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.wang.web.service.RoleService#save(org.wang.web.model.Role)
   */
  @Override public Integer save(Role role) {
    return roleDao.save(role);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role dao.
   *
   * @param  roleDao  RoleDao
   */
  public void setRoleDao(RoleDao roleDao) {
    this.roleDao = roleDao;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.wang.web.service.RoleService#update(org.wang.web.model.Role)
   */
  @Override public void update(Role role) {
    roleDao.update(role);
  }


} // end class RoleServiceImpl
