package PKomponent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public interface IPasswordChecker {

    public int check_proc_password_strenght(String password_to_set);

    public Map<String, Boolean> getMapOfErrors();
    
    public void set_password_variables(int min_lenght_of_password, int min_big_letters,int min_amount_of_numbers,int max_repeats,int min_amount_of_non_letters);
    
    public int getMin_amount_of_non_letters();
    
    public void setMin_amount_of_non_letters(int min_amount_of_non_letters);
    
    public int getMax_repeats();
    
    public void setMax_repeats(int max_repaets);

    public int getMin_lenght_of_password();

    public void setMin_lenght_of_password(int min_lenght_of_password);

    public int getMin_big_letters();

    public void setMin_big_letters(int min_big_letters);

    public int getMin_amount_of_numbers();

    public void setMin_amount_of_numbers(int min_amount_of_numbers);
    
    public boolean check_lenght(String password_to_set);

    public boolean check_char_repeat(String password_2_set);

    public boolean check_if_correct_char(String password_2_set);

    public boolean check_if_big_char_included(String password_2_set);

    public boolean check_if_number_is_included(String password_2_set);
    
    public boolean check_if_non_latters_included(String password_2_set);
    
}
