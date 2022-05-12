//package org.launchcode.liftoffproject.models.dto;
//
//public class RegisterFormDTO extends LoginFormDTO{
//    private String verifyPassword;
//
//    public RegisterFormDTO(String String) {
//        this.verifyPassword = verifyPassword;
//    }
//
//    public RegisterFormDTO() {
//
//    }
//
//    public String getVerifyPassword() {
//        return verifyPassword;
//    }
//
//    public void setVerifyPassword(String verifyPassword) {
//        this.verifyPassword = verifyPassword;
//    }
//
//    public String getUsername() {
//        return null;
//    }
//}
package org.launchcode.liftoffproject.models.dto;

import javax.validation.constraints.NotNull;

public class RegisterFormDTO extends LoginFormDTO {

    @NotNull(message = "Must provide first name")
    private String firstName;

    @NotNull(message = "Must provide last name")
    private String lastName;

    @NotNull(message = "Must provide email")
    private String email;

    private String verifyPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

}

