package com.shopping.freshcart.Security.UserAccount.Model.Entity;



import com.shopping.freshcart.Models.Entity.Order;
import com.shopping.freshcart.Security.Permissions.UserRolesAuthentications;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;



@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String username;
    @Email
    @NonNull
    private String email;
    @NonNull
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Enumerated(EnumType.STRING)
    private UserRolesAuthentications role;

    @Lob
    @Convert(converter = StringArrayConverter.class)
    private String[] authorities;

    private boolean isActive;// Enable/Disable
    private boolean isNotLocked;//Locked/UnLocked

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;



}

