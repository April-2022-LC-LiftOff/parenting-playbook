package org.launchcode.liftoffproject.models.dto;

public class RegisterFormDTO extends LoginFormDTO{

    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

//    public RegisterFormDTO(String String) {
//        this.verifyPassword = verifyPassword;
//    }
//
//    public RegisterFormDTO() {
//
//    }
//
//
//    public String getUsername() {
//        return null;
//    }
}
