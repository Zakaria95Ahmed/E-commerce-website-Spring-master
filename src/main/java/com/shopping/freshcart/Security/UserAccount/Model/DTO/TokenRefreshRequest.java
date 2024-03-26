package com.shopping.freshcart.Security.UserAccount.Model.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenRefreshRequest {

    private String refreshToken;

    // getters and setters
}
