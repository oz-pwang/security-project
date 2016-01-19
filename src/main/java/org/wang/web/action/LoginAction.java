package org.wang.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wang.web.command.LoginForm;
import org.wang.web.model.User;
import org.wang.web.service.UserService;
import org.wang.web.until.Constants;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Yang Wang on 8/15/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Controller public class LoginAction {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Autowired
  UserService userService;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  @RequestMapping(
    value  = "/login",
    method = RequestMethod.GET
  )
  protected String login() {
    return "login";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   request    DOCUMENT ME!
   * @param   loginForm  command DOCUMENT ME!
   * @param   result     errors DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  @RequestMapping(
    value  = "/login",
    method = RequestMethod.POST
  )
  protected String onLogin(HttpServletRequest request, LoginForm loginForm, BindingResult result) throws Exception {
    User user = userService.findUser(loginForm.getUsername(), loginForm.getPassword());

    if (user != null) {
      request.getSession().setAttribute(Constants.USERNAME_KEY, user.getUsername());
      request.getSession().setAttribute(Constants.USERID_KEY, user.getId());

        return "redirect:/user/info?id=" + user.getId();
    } else {
      return "redirect:/login?failed=true";
    }
  }
} // end class LoginAction
