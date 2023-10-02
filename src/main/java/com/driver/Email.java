package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword == password && newPassword.length() >= 8)
        {
            int upperChar = 0;
            int lowerChar = 0;
            int digitChar = 0;
            int specialChar = 0;

            for(int i=0;i<newPassword.length();i++)
            {
                char ch = newPassword.charAt(i);
                if(ch >= 65 && ch <= 90)
                {
                    upperChar++;
                }
                else if(ch >= 97 && ch <= 122)
                {
                    lowerChar++;
                }
                else if(ch >= 48 && ch <= 57)
                {
                    digitChar++;
                }
                else specialChar++;
            }

            if(upperChar != 0 && lowerChar != 0 && digitChar != 0 && specialChar != 0)
            {
                this.password = newPassword;
            }
        }
    }
}
