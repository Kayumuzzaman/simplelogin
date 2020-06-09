package com.dsi.simpleloginsystem.simpleloginsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "login_users")
public class CurrentUser extends Key{

    @NotNull(message = "Email can't be null" )
    @Email
    @Column(name = "user_email")
    private String userEmail;

    @NotNull(message = "Password can't be null" )
    @Column(name = "user_password")
    private String userPassword;
}
