package org.wang.web.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.wang.web.command.ProjectCommand;
import org.wang.web.service.ProjectService;

/**
 * Created by Administrator on 2015/9/1.
 */
public class ProjectValidator implements Validator {
    private ProjectService projectService;

    @Override
    public boolean supports(Class aClass) {
        return ProjectCommand.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        ProjectCommand project = (ProjectCommand) object;
        if (projectService.findProject(project.getProjectName()) == null)
            errors.rejectValue("projectName",null,"not project");
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }
}
