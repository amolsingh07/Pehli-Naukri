// package com.luv2code.jobportal.config;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
// import org.springframework.stereotype.Component;

// import java.io.IOException;

// @Component
// public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

//     @Override
//     public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//         UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//         String username = userDetails.getUsername();
//         System.out.println("The username " + username + " is logged in.");
//         boolean hasJobSeekerRole = authentication.getAuthorities().stream().anyMatch(r->r.getAuthority().equals("Job Seeker"));
//         boolean hasRecruiterRole = authentication.getAuthorities().stream().anyMatch(r->r.getAuthority().equals("Recruiter"));

//         if (hasRecruiterRole || hasJobSeekerRole) {
//             response.sendRedirect("/dashboard/");
//         }
//     }
// }


// package com.luv2code.jobportal.config;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
// import org.springframework.stereotype.Component;

// import java.io.IOException;

// @Component
// public class CustomAuthenticationSuccessHandler
//         implements AuthenticationSuccessHandler {

//     @Override
//     public void onAuthenticationSuccess(
//             HttpServletRequest request,
//             HttpServletResponse response,
//             Authentication authentication)
//             throws IOException, ServletException {

//         for (GrantedAuthority authority : authentication.getAuthorities()) {

//             if (authority.getAuthority().equals("Recruiter")) {
//                 response.sendRedirect("/recruiter/dashboard");
//                 return;
//             }

//             if (authority.getAuthority().equals("Job Seeker")) {
//                 response.sendRedirect("/job-seeker/dashboard");
//                 return;
//             }
//         }

//         // fallback
//         response.sendRedirect("/");
//     }
// }



// package com.luv2code.jobportal.config;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
// import org.springframework.stereotype.Component;

// import java.io.IOException;

// @Component
// public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

//     @Override
//     public void onAuthenticationSuccess(
//             HttpServletRequest request,
//             HttpServletResponse response,
//             Authentication authentication
//     ) throws IOException, ServletException {

//         boolean isRecruiter = authentication.getAuthorities()
//                 .stream()
//                 .anyMatch(a -> a.getAuthority().equals("ROLE_RECRUITER"));

//         boolean isJobSeeker = authentication.getAuthorities()
//                 .stream()
//                 .anyMatch(a -> a.getAuthority().equals("ROLE_JOB_SEEKER"));

//         if (isRecruiter) {
//             response.sendRedirect("/recruiter/dashboard");
//             return;
//         }

//         if (isJobSeeker) {
//             response.sendRedirect("/jobseeker/dashboard");
//             return;
//         }

//         // fallback
//         response.sendRedirect("/");
//     }
// }


// package com.luv2code.jobportal.config;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
// import org.springframework.stereotype.Component;

// import java.io.IOException;

// @Component
// public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

//     @Override
//     public void onAuthenticationSuccess(
//             HttpServletRequest request,
//             HttpServletResponse response,
//             Authentication authentication
//     ) throws IOException, ServletException {

//         boolean isRecruiter = authentication.getAuthorities().stream()
//                 .anyMatch(a -> a.getAuthority().equals("ROLE_RECRUITER"));

//         boolean isJobSeeker = authentication.getAuthorities().stream()
//                 .anyMatch(a -> a.getAuthority().equals("ROLE_JOB_SEEKER"));

//         if (isRecruiter) {
//             response.sendRedirect("/recruiter/dashboard");
//             return;
//         }

//         if (isJobSeeker) {
//             response.sendRedirect("/jobseeker/dashboard");
//             return;
//         }

//         response.sendRedirect("/");
//     }
// }


package com.luv2code.jobportal.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {

        if (authentication.getAuthorities().contains(
                new SimpleGrantedAuthority("ROLE_RECRUITER"))) {

            response.sendRedirect("/recruiter/dashboard");
            return;
        }

        if (authentication.getAuthorities().contains(
                new SimpleGrantedAuthority("ROLE_JOB_SEEKER"))) {

            response.sendRedirect("/dashboard/");
            return;
        }

        // fallback
        response.sendRedirect("/");
    }
}
