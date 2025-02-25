package com.example.jobapplication.job;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Job {

    private  Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

}
