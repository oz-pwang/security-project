package org.wang.web.command;


import org.wang.web.model.Project;
import org.wang.web.model.User;

/**
 * Created by Administrator on 2015/9/1.
 */
public class ProjectCommand {

    private Integer id;
    private String projectName;
    private User creator;

    public ProjectCommand() {
    }

    public ProjectCommand(Project project) {
        this.id = project.getId();
        this.projectName = project.getProjectName();
        this.creator = project.getCreator();
    }


    public Project toProject() throws Exception{
        Project project = new Project();
        project.setId(this.getId());
        project.setProjectName(this.getProjectName());
        project.setCreator(this.getCreator());
        return project;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String name) {
        this.projectName = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }


}
