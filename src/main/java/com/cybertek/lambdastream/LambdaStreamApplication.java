package com.cybertek.lambdastream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LambdaStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(LambdaStreamApplication.class, args);
		System.out.println("Read all managers:  " + Exam.readAllManagers());
		System.out.println("Read all suspended users:  " + Exam.readAllSuspendedUsers());
		System.out.println("Count courses:  " + Exam.countCourses());
		System.out.println("Count courses by status:  " + Exam.countCoursesByStatus());
		System.out.println("sum Duration For All Data:  " + Exam.sumDurationForAllData());
		System.out.println("Find courses by specific user:  " + Exam.findCoursesByUser());
		System.out.println("Modify object:  " + Exam.modifyObject());
	}

}
