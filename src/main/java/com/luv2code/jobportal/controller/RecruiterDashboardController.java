// package com.luv2code.jobportal.controller;

// import org.springframework.stereotype.Controller;

// @Controller
// public class HomeController {

//     public String home() {
//         return "index";
//     }
// }

// package com.luv2code.jobportal.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;

// @Controller
// public class HomeController {

//     @GetMapping("/")
//     public String home() {
//         return "index";
//     }
// }


package com.luv2code.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recruiter")
public class RecruiterDashboardController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "recruiter-dashboard";
    }
}
