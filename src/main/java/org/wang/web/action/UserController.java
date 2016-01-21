package org.wang.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.wang.web.command.UserCommand;
import org.wang.web.model.Project;
import org.wang.web.model.Role;
import org.wang.web.model.User;
import org.wang.web.service.RoleService;
import org.wang.web.service.UserService;
import org.wang.web.validator.UserValidator;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Controller
@RequestMapping("/user")
public class UserController {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Autowired private UserService userService;
  @Autowired private RoleService roleService;

  private UserValidator validator = new UserValidator();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   model  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @RequestMapping(
    value  = "/add",
    method = RequestMethod.GET
  )
  protected String addUser(Model model) {

    List<Role> roles = roleService.list();
    model.addAttribute("command", new UserCommand());
    model.addAttribute("roles" , roles);

    return "/user/add";
  }

  @RequestMapping(
    value  = "/update",
    method = RequestMethod.GET
  )
  protected String updateUser(HttpServletRequest request,Model model) {
    String username = request.getParameter("username");
//    Integer id = Integer.valueOf(request.getParameter("id"));

    User user = userService.findByUserName(username);

    UserCommand command = new UserCommand(user);

    model.addAttribute("command",command);
    return "/user/add";
  }



  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   id       Integer
   * @param   model    DOCUMENT ME!
   * @param   request  HttpServletRequest
   *
   * @return  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  @RequestMapping(value = "/info")
  protected String createUser(Integer id, Model model, HttpServletRequest request) throws Exception {
    if (id != null) {
      User user = userService.get(id);
      model.addAttribute("user", user);

      return "/user/info";
    } else {
      String remoteUser = request.getRemoteUser();
      User   user       = userService.findByUserName(remoteUser);
      model.addAttribute("user", user);
      return "/user/info";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   request   DOCUMENT ME!
   * @param   response  DOCUMENT ME!
   * @param   command   user DOCUMENT ME!
   * @param   result    DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  @RequestMapping(
    value  = "/add",
    method = RequestMethod.POST
  )
  protected String createUser(HttpServletRequest request, HttpServletResponse response,
    @ModelAttribute("command") UserCommand command, BindingResult result) throws Exception {
    validator.validate(command, result);

    if (!result.hasErrors()) {
      User    user = command.toUser();
      String rolename = request.getParameter("rolename");
      Role role = roleService.findRole(rolename);
      user.setRole(role);
      Integer id   = userService.save(user);
      return "redirect:/user/info?id=" + id;
    } else {
      return "/user/add";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   model  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @RequestMapping(
    value  = "/list",
    method = RequestMethod.GET
  )
  protected String listUser(Model model) {
    List<User> users = userService.list();
    model.addAttribute("users", users);

    return "/user/list";
  }
} // end class UserController
