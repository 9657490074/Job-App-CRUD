package com.example.jobapplication.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {


    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs/all")
    public ResponseEntity<List<Job>> findAll() {
        return new ResponseEntity<List<Job>>(jobService.findAll(), HttpStatus.OK);

    }

    @PostMapping("/jobs/create")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobByID(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        //  return jobService.getJobById(id);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean delete = jobService.deleteJobById(id);
        if (delete) {
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Job Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job job) {

        boolean updateJob = jobService.getUpdateById(id, job);
        if (updateJob) {
            return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Job Not Found", HttpStatus.NOT_FOUND);
        }
    }


}
