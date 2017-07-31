import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wang.mall.service.ConsumerService;
import org.wang.mall.service.MerchantService;
import org.wang.mall.util.LoginForm;
import org.wang.mall.util.Parameter;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Yang Wang on 8/15/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Controller
public class LoginAction {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Autowired
  private ConsumerService consumerService;
  @Autowired
  private MerchantService merchantService;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * login.
   *
   * @param   request    HttpServletRequest
   * @param   loginForm  LoginForm
   *
   * @return  String
   */
  @RequestMapping(
    value  = "/login",
    method = RequestMethod.POST
  )
  public String login(HttpServletRequest request, LoginForm loginForm) {

    if (loginForm.getRole().equals("consumer")){
      Consumer consumer = consumerService.findByNameAndPassWord(loginForm.getName(), loginForm.getPassword());

      if (consumer != null) {
        request.getSession().setAttribute(Parameter.USER_NAME_KEY, consumer.getName());
        request.getSession().setAttribute(Parameter.USER_ID_KEY, consumer.getId());

        return "redirect:/mall";
      }
    }
      if (loginForm.getRole().equals("merchant")){
        Merchant merchant = merchantService.findByNameAndPassWord(loginForm.getName(), loginForm.getPassword());

        if (merchant != null) {
          request.getSession().setAttribute(Parameter.USER_NAME_KEY, merchant.getName());
          request.getSession().setAttribute(Parameter.USER_ID_KEY, merchant.getId());

          return "redirect:/merchant/index";
        }
      }
    return "redirect:/login?failed=true";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toLoginView.
   *
   * @return  String
   */
  @RequestMapping(
    value  = "/login",
    method = RequestMethod.GET
  )
  public String toLoginView() {
    return "login";
  }

} // end class LoginAction
