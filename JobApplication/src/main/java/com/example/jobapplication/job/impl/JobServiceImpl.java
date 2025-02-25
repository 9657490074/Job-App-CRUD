package com.example.jobapplication.job.impl;

import com.example.jobapplication.job.Job;
import com.example.jobapplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;


    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id))
                return job;
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getUpdateById(Long id, Job job) {
        for (Job job1 : jobs) {
            if (job1.getId().equals(id)) {
                job1.setTitle(job.getTitle());
                job1.setDescription(job.getDescription());
                job1.setMinSalary(job.getMinSalary());
                job1.setMaxSalary(job.getMaxSalary());
                job1.setLocation(job.getLocation());
                return true;
            }
        }
        return false;
    }
}
