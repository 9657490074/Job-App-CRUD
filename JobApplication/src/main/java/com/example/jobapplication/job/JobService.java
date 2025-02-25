package com.example.jobapplication.job;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean getUpdateById(Long id, Job job);
}
