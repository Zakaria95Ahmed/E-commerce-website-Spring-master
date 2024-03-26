package com.shopping.freshcart.Security.UserAccount.Services;

import com.shopping.freshcart.Security.JWT.JwtProvider;
import com.shopping.freshcart.Security.UserAccount.Model.DTO.*;
import com.shopping.freshcart.Security.UserAccount.Model.Entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final AuthenticationManager authenticationManager;
    private final JwtProvider tokenProvider;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public JwtAuthenticationResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = tokenProvider.generateAccessToken(authentication);
        String refreshToken = tokenProvider.generateRefreshToken(authentication);

        return new JwtAuthenticationResponse(accessToken, refreshToken);
    }

    @Override
    public ApiResponse registerUser(SignupRequest signupRequest) {
        if (userService.existsByUsername(signupRequest.getUsername())) {
            return new ApiResponse(false, "Username is already taken!");
        }

        if (userService.existsByEmail(signupRequest.getEmail())) {
            return new ApiResponse(false, "Email Address already in use!");
        }

        UserDTO user = new UserDTO();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        userService.createUser(user);
        return new ApiResponse(true, "User registered successfully");
    }

    @Override
    public TokenRefreshResponse refreshToken(TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        if (StringUtils.hasText(requestRefreshToken) && tokenProvider.validateToken(requestRefreshToken)) {
//            String username = tokenProvider.getUsernameFromJWT(requestRefreshToken);
//            UserDetails userDetails = userService.loadUserByUsername(username);
            String userEmail = tokenProvider.getUserEmailFromJWT(requestRefreshToken);
            UserDetails userDetails = userService.loadUserByUsername(userEmail);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            String accessToken = tokenProvider.generateAccessToken(authentication);
            return new TokenRefreshResponse(accessToken, requestRefreshToken);
        } else {
            throw new InvalidRefreshTokenException("Invalid refresh token");
        }
    }


}
