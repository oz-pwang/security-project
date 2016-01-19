package org.wang.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wang.web.command.ProjectCommand;
import org.wang.web.model.Project;
import org.wang.web.model.User;
import org.wang.web.service.ProjectService;
import org.wang.web.service.UserService;
import org.wang.web.until.Constants;
import org.wang.web.validator.ProjectValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/31.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    @Autowired
    ProjectValidator validator;


    @RequestMapping(
            value = "/add",
            method = RequestMethod.GET
    )
    public String add(Model model) {
        model.addAttribute("projectCommand", new ProjectCommand());
        return "/Project/add";
    }


    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST
    )
    public String createProject(Model model,Project project,HttpServletRequest request,
                             @ModelAttribute("projectCommand") ProjectCommand command, BindingResult result) throws Exception {
        validator.validate(command,result);
        String remoteUser = request.getRemoteUser();
        User user = userService.findByUserName(remoteUser);
        project.setCreator(user);
        projectService.save(project);
        return "redirect:/project/list";
    }

    @RequestMapping(
            value = "/list",
    method = RequestMethod.GET
    )
    public String list(HttpServletRequest request,Model model){
        List<Project> projectList = new ArrayList<Project>();
        String remoteUser = request.getRemoteUser();
        User user = userService.findByUserName(remoteUser);
        for (Project project : user.getProjectSet()) {
            projectList.add(project);
        }
        model.addAttribute("projectList",projectList);
        return "/project/list";
    }



}// end class ProjectController