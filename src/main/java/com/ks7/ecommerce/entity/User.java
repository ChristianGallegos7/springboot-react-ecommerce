package com.ks7.ecommerce.entity;


import com.ks7.ecommerce.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Name is required")
    private String name;


    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;


    @NotBlank(message = "Password is required")
    private String password;


    @Column(name = "phone_number")
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;


    private UserRole role;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItemList;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;
    @Column(name = "created_at")
    private final LocalDateTime createdAt = LocalDateTime.now();

}
