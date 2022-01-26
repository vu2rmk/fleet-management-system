
package com.vu2rmk.fleetapp.services;

import com.vu2rmk.fleetapp.models.JobTitle;
import com.vu2rmk.fleetapp.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    public List<JobTitle> getJobTitles(){
        return jobTitleRepository.findAll();
    }

    public void save(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }

    public JobTitle findById(Integer id){
        return jobTitleRepository.findById(id).get();
    }

    public void delete(Integer id) {
        jobTitleRepository.deleteById(id);
    }
}
