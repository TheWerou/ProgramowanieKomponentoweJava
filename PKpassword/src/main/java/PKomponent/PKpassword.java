package PKomponent;

import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.*;
import java.util.Map;

public class PKpassword extends JPasswordField implements java.io.Serializable 
{
    private IPasswordChecker passwordChecker;

    public PKpassword()
    {
        super();
        this.passwordChecker = new StrenghtPass();
        this.setDefoults();
    }

    public PKpassword(IPasswordChecker passwordChecker)
    {
        super();
        this.passwordChecker = passwordChecker;
        this.setDefoults();
    }
    private void setDefoults()
    {
        this.setSize(20,40);
    }
    public void set_passwordChecker_variables(int min_lenght_of_password, int min_big_letters,int min_amount_of_numbers,int max_repeats,int min_amount_of_non_letters)
    {
        this.passwordChecker.set_password_variables(
                min_lenght_of_password,
                min_big_letters,
                min_amount_of_numbers,
                max_repeats,
                min_amount_of_non_letters);
    }

    public void setPasswordChecker(IPasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }

    public int getPasswordProcStrenght()
    {
        String textInWin = new String(this.getPassword());
        return passwordChecker.check_proc_password_strenght(textInWin);
    }
    public Map<String, Boolean> getMapOfErrors()
    {
       return passwordChecker.getMapOfErrors();
    }
    
    public PKpassword getObject()
    {
        return this;
    }
}
