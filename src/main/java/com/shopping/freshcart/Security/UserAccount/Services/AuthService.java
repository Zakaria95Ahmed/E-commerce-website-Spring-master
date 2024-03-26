package com.shopping.freshcart.Security.UserAccount.Services;

import com.shopping.freshcart.Security.UserAccount.Model.DTO.*;

public interface AuthService {
    JwtAuthenticationResponse authenticateUser(LoginRequest loginRequest);
    ApiResponse registerUser(SignupRequest signupRequest);
    TokenRefreshResponse refreshToken(TokenRefreshRequest request);



}
