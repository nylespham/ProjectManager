package com.jrp.projectmanager.dao;

import com.jrp.projectmanager.dto.ChartData;
import com.jrp.projectmanager.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long > {
    @Override
    public List<Project> findAll();

//    @Query(nativeQuery = true, value="SELECT stage, COUNT(*) as value FROM project GROUP BY stage;"
//    )
//    public List<ChartData> getProjectStatus();
}
