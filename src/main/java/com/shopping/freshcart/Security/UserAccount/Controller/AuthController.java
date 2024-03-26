//package com.shopping.freshcart.Security.UserAccount.Controller;
//
//
//import com.shopping.freshcart.Security.JWT.JwtProvider;
//import com.shopping.freshcart.Security.UserAccount.Model.Entity.User;
//import com.shopping.freshcart.Security.UserAccount.Services.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtProvider tokenProvider;
//
//    @Autowired
//    private UserServiceImpl userService;
//
//
//
//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String accessToken = tokenProvider.generateAccessToken(authentication);
//        String refreshToken = tokenProvider.generateRefreshToken(authentication);
//
//        return ResponseEntity.ok(new JwtAuthenticationResponse(accessToken, refreshToken));
//    }
//
//
//
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
//        if (userService.existsByUsername(signupRequest.getUsername())) {
//            return ResponseEntity.badRequest().body(new ApiResponse(false, "Username is already taken!"));
//        }
//
//        if (userService.existsByEmail(signupRequest.getEmail())) {
//            return ResponseEntity.badRequest().body(new ApiResponse(false, "Email Address already in use!"));
//        }
//
//        User user = new User();
//        user.setUsername(signupRequest.getUsername());
//        user.setEmail(signupRequest.getEmail());
//        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
//
//        User savedUser = userService.createUser(user);
//
//        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
//    }
//
//
//
//
//    @PostMapping("/refreshtoken")
//    public ResponseEntity<?> refreshtoken(@RequestBody TokenRefreshRequest request) {
//        String requestRefreshToken = request.getRefreshToken();
//
//        if (StringUtils.hasText(requestRefreshToken) && tokenProvider.validateToken(requestRefreshToken)) {
//            String username = tokenProvider.getUsernameFromJWT(requestRefreshToken);
//            UserDetails userDetails = userService.loadUserByUsername(username);
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                    userDetails, null, userDetails.getAuthorities());
//            String accessToken = tokenProvider.generateAccessToken(authentication);
//            return ResponseEntity.ok(new TokenRefreshResponse(accessToken, requestRefreshToken));
//        } else {
//            return ResponseEntity.badRequest().body(new ApiResponse(false, "Invalid refresh token"));
//        }
//    }
//
//
//
//
//
//}