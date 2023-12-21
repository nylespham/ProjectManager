package com.jrp.projectmanager.services;

import com.jrp.projectmanager.dao.ProjectRepository;
import com.jrp.projectmanager.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository proRep;

    public Project save(Project project) {
        return proRep.save(project);
    }

    public List<Project> getAll(){
        return proRep.findAll();
    }

}
