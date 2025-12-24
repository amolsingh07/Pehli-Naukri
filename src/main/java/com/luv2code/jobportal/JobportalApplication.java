// package com.luv2code.jobportal;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class JobportalApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(JobportalApplication.class, args);
// 	}

// }


package com.luv2code.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.luv2code.jobportal.entity")
@EnableJpaRepositories(basePackages = "com.luv2code.jobportal.repository")
public class JobportalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobportalApplication.class, args);
    }
}
