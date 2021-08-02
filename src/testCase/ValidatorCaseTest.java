package testCase;

import org.junit.jupiter.api.Test;
import validator.Validator;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorCaseTest extends Validator {
    @Test
    void testCreditCardNum() {
        assertTrue(Validator.checkCreditCardNum("1234567812345678"));
        assertTrue(Validator.checkCreditCardNum("1234567890123455"));
        assertFalse(Validator.checkCreditCardNum("27836"));
        assertFalse(Validator.checkCreditCardNum("2783648"));
        assertFalse(Validator.checkCreditCardNum("123456781234567A"));
    }

    @Test
    void testDateFormatEU() {

        assertTrue(Validator.checkDateFormatEU("02.08.2021"));
        assertTrue(Validator.checkDateFormatEU("31.12.2021"));
        assertFalse(Validator.checkDateFormatEU("31.13.2021"));
        assertFalse(Validator.checkDateFormatEU("3.12.2021"));
        assertFalse(Validator.checkDateFormatEU("31/12.2021"));
        assertFalse(Validator.checkDateFormatEU("2021.11.31"));
    }

    @Test
    void testDateFormatUS() {
        assertTrue(Validator.checkDateFormatUS("2021-08-02"));
        assertTrue(Validator.checkDateFormatUS("2021-12-31"));
        assertFalse(Validator.checkDateFormatUS("2021-12-32"));
        assertFalse(Validator.checkDateFormatUS("2021-13-31"));
        assertFalse(Validator.checkDateFormatUS("2021-12-3"));
        assertFalse(Validator.checkDateFormatUS("2021-11/31"));
        assertFalse(Validator.checkDateFormatUS("02-08-2021"));
    }

    @Test
    void testPhoneNumber() {
        assertTrue(Validator.checkPhoneNumber("+99(99)9999-9999"));
        assertFalse(Validator.checkPhoneNumber("99(99)9999-9999"));
        assertFalse(Validator.checkPhoneNumber("+9(99)9999-9999"));
        assertFalse(Validator.checkPhoneNumber("+99(9)9999-9999"));
        assertFalse(Validator.checkPhoneNumber("+99(9)999-9999"));
        assertFalse(Validator.checkPhoneNumber("+99(9)9999-999"));
    }

    @Test
    void testLessEquals255() {
        assertTrue(Validator.checkLessEquals255("255.255.255.255")); // не больше 255 / 0-255
        assertTrue(Validator.checkLessEquals255("55.255.255.255"));
        assertTrue(Validator.checkLessEquals255("5.255.25.255"));
        assertTrue(Validator.checkLessEquals255("0.255.255.255"));
        assertFalse(Validator.checkLessEquals255(".255.225.255"));
    }


}