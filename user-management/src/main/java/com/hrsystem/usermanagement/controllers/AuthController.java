package com.hrsystem.usermanagement.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.usermanagement.model.Employee;
import com.hrsystem.usermanagement.model.Role;
import com.hrsystem.usermanagement.model.RoleName;
import com.hrsystem.usermanagement.payload.request.LoginRequest;
import com.hrsystem.usermanagement.payload.request.SignUpForm;
import com.hrsystem.usermanagement.payload.response.ApiResponse;
import com.hrsystem.usermanagement.payload.response.ApiResponseError;
import com.hrsystem.usermanagement.payload.response.JwtResponse;
import com.hrsystem.usermanagement.security.jwt.JwtUtils;
import com.hrsystem.usermanagement.security.service.UserDetailsImpl;
import com.hrsystem.usermanagement.service.EmployeeService;
import com.hrsystem.usermanagement.service.RoleService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/test")
    public String getUser() {
    	return "User Controller Works";
    }
	
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication, loginRequest.isRememberMe());

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

         return ResponseEntity.ok(new JwtResponse(userDetails.getId(), jwt, userDetails.getEmail(), userDetails.getAuthorities()));
    }
    
    
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody SignUpForm signUpForm) {
    	ApiResponse response = new ApiResponse();
    	List<ApiResponseError> errors = null;
    	ApiResponseError error = null; 
    	
        if(employeeService.existsByEmail(signUpForm.getEmail())) {
        	error = new ApiResponseError("email", "Email already exist");
        	errors = new ArrayList<>();
        	errors.add(error);
        	response.setErrors(errors);
            return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
        }

        // Creating employee's account
        Employee employee = new Employee(signUpForm.getName(),
                "https://image.freepik.com/free-photo/elegant-man-with-thumbs-up_1149-1595.jpg",
                signUpForm.getEmail(),
                passwordEncoder.encode(signUpForm.getPassword()),
                20,
                signUpForm.getPosition(),
                signUpForm.getPhone());

        Set<String> strRoles = signUpForm.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "ROLE_ADMIN":
                    Role adminRole = roleService.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);

                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });

        employee.setRoles(roles);
        employeeService.save(employee);

        response.setData("User registered successfully!");
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
}
