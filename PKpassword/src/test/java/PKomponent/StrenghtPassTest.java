/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKomponent;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author wojte
 */
public class StrenghtPassTest {
    private final StrenghtPass password_checker;
    
    public StrenghtPassTest() {
        this.password_checker = new StrenghtPass();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMapOfErrors method, of class StrenghtPass.
     */

    public void rest_data()
    {
        this.password_checker.setMin_amount_of_numbers(1);
        this.password_checker.setMin_big_letters(1);
        this.password_checker.setMin_lenght_of_password(8);
        this.password_checker.setMax_repeats(2);
        this.password_checker.setMin_amount_of_non_letters(1);
    }
    @Test
    public void getMapOfErrors() 
    {
        this.rest_data();
        String test_1_password = "AaaalmKot";
        this.password_checker.check_proc_password_strenght(test_1_password);
        Map<String, Boolean> mapError = this.password_checker.getMapOfErrors();
        assertEquals(Boolean.TRUE,mapError.get("GoodLenght"));
        assertEquals(Boolean.TRUE,mapError.get("Correct"));
        assertEquals(Boolean.FALSE,mapError.get("NoRepats"));
        assertEquals(Boolean.FALSE,mapError.get("Numbers"));
        assertEquals(Boolean.TRUE,mapError.get("BigLetters"));
        assertEquals(Boolean.FALSE,mapError.get("NonLerrers"));
        
    }
    
    @Test
    public void check_password_strenght()
    {
        this.rest_data();
        String test_1_password = "aaaa aaaa";
        assertEquals(0,this.password_checker.check_proc_password_strenght(test_1_password));

        test_1_password = "aaaaaaaa";
        assertEquals(20,this.password_checker.check_proc_password_strenght(test_1_password));

        test_1_password = "dakotaqem";
        assertEquals(40,this.password_checker.check_proc_password_strenght(test_1_password));

        test_1_password = "Dakotanim";
        assertEquals(60,this.password_checker.check_proc_password_strenght(test_1_password));

        test_1_password = "Dakotac1324^";
        assertEquals(100,this.password_checker.check_proc_password_strenght(test_1_password));
    }

    @Test
    public void check_lenght() {
        this.rest_data();
        String test_1_password = "aaaaaaaa";
        assertTrue(this.password_checker.check_lenght(test_1_password));

        test_1_password = "aaaaaa";
        assertFalse(this.password_checker.check_lenght(test_1_password));

        test_1_password = "aaaa";
        this.password_checker.setMin_lenght_of_password(20);
        assertFalse(this.password_checker.check_lenght(test_1_password));
    }

    @Test
    public void check_char_repeat() {
        this.rest_data();

        String test_1_password = "AaaalmKot";
        this.password_checker.setMax_repeats(3);
        assertTrue(this.password_checker.check_char_repeat(test_1_password));

        test_1_password = "kotale";
        assertFalse(this.password_checker.check_char_repeat(test_1_password));

        test_1_password = "kkkkk";
        this.password_checker.setMax_repeats(5);
        assertTrue(this.password_checker.check_char_repeat(test_1_password));

        test_1_password = "kkkk";
        this.password_checker.setMax_repeats(6);
        assertFalse(this.password_checker.check_char_repeat(test_1_password));

        test_1_password = "kkkkvvvv";
        this.password_checker.setMax_repeats(4);
        assertFalse(this.password_checker.check_char_repeat(test_1_password));

        test_1_password = "kkkkkkkkkkkkkkkk";
        this.password_checker.setMax_repeats(5);
        assertFalse(this.password_checker.check_char_repeat(test_1_password));

    }

    @Test
    public void check_if_correct_char() {
        this.rest_data();

        String test_1_password = "Ala ma Kota";
        assertFalse(this.password_checker.check_if_correct_char(test_1_password));

        test_1_password = "AlamaKota";
        assertTrue(this.password_checker.check_if_correct_char(test_1_password));
    }

    @Test
    public void check_if_big_char_included() {
        this.rest_data();
        String test_1_password = "AlamaKota";
        assertTrue(this.password_checker.check_if_big_char_included(test_1_password));

        test_1_password = "Alamaota";
        assertTrue(this.password_checker.check_if_big_char_included(test_1_password));

        test_1_password = "alamaota";
        assertFalse(this.password_checker.check_if_big_char_included(test_1_password));

        test_1_password = "ALamaOTa";
        this.password_checker.setMin_big_letters(4);
        assertTrue(this.password_checker.check_if_big_char_included(test_1_password));

        test_1_password = "ALamaOa";
        this.password_checker.setMin_big_letters(4);
        assertFalse(this.password_checker.check_if_big_char_included(test_1_password));

        test_1_password = "ALamaOTADASa";
        this.password_checker.setMin_big_letters(4);
        assertTrue(this.password_checker.check_if_big_char_included(test_1_password));
    }

    @Test
    public void check_if_number_is_included() {
        this.rest_data();

        String test_1_password = "AlamaKota";
        assertFalse(this.password_checker.check_if_number_is_included(test_1_password));

        test_1_password = "AlamaK2ota";
        assertTrue(this.password_checker.check_if_number_is_included(test_1_password));

        test_1_password = "Al9amaK2ota";
        this.password_checker.setMin_amount_of_numbers(2);
        assertTrue(this.password_checker.check_if_number_is_included(test_1_password));

        test_1_password = "Al9amaKota";
        this.password_checker.setMin_amount_of_numbers(2);
        assertFalse(this.password_checker.check_if_number_is_included(test_1_password));
    }

    @Test
    public void check_if_non_latters_included() {
        this.rest_data();

        String test_1_password = "AlamaKota@";
        assertTrue(this.password_checker.check_if_non_latters_included(test_1_password));

        test_1_password = "AlamaKota";
        assertFalse(this.password_checker.check_if_non_latters_included(test_1_password));

        test_1_password = "AlamaKota!";
        this.password_checker.setMin_amount_of_non_letters(2);
        assertFalse(this.password_checker.check_if_non_latters_included(test_1_password));

        test_1_password = "AlamaKota!@";
        this.password_checker.setMin_amount_of_non_letters(2);
        assertTrue(this.password_checker.check_if_non_latters_included(test_1_password));

        test_1_password = "AlamaKota!^@";
        this.password_checker.setMin_amount_of_non_letters(2);
        assertTrue(this.password_checker.check_if_non_latters_included(test_1_password));

    }
    
}
