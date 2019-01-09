package org.launchcode.cheesemvc.models.user;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

public class User {

    private final int userId;

    private static int nextUserId = 1;

    @NotNull
    @Size(min=1, max=15, message="Username must be 3-15 characters in length")
    private String username;

    @NotNull(message="Password field must not be empty")
    @Size(min=1, max=15, message="Password must be 3-15 characters in length")
    private String password;

    @NotNull(message="Passwords do not match")
    private String verifyPassword;

    @Email (message="Not a valid email address")
    private String email;

    private final LocalDateTime timeStamp;

    public User() {
        userId = nextUserId;
        nextUserId++;
        this.timeStamp = LocalDateTime.now();
    }

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }

    private void checkPassword() {
            if (!this.password.equals(this.verifyPassword)) {
            this.verifyPassword = null;
       }
     }

   }


