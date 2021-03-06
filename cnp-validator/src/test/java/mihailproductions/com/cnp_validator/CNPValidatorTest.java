package mihailproductions.com.cnp_validator;

import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class CNPValidatorTest {

    @Test
    public void checkForValidCNPs() {
        //CNP random generated by a valid algorithm
        assertTrue(CNPUtils.isValidCNP("        3500929442955"));
        assertTrue(CNPUtils.isValidCNP("3500929448438"));
        assertTrue(CNPUtils.isValidCNP("4500630373278"));
        assertTrue(CNPUtils.isValidCNP("4500630373181"));
        assertTrue(CNPUtils.isValidCNP("9501120299005"));
    }

    @Test
    public void checkForInvalidCNPs() {
        assertFalse(CNPUtils.isValidCNP("35009294429552"));
        assertFalse(CNPUtils.isValidCNP("350092942955"));
        assertFalse(CNPUtils.isValidCNP("35009294429"));
        assertFalse(CNPUtils.isValidCNP("3500929a42955"));
        assertFalse(CNPUtils.isValidCNP(null));
        assertFalse(CNPUtils.isValidCNP("0000000000000"));
        assertFalse(CNPUtils.isValidCNP("7777777777771"));
        assertFalse(CNPUtils.isValidCNP("9999999999996"));
    }

    @Test
    public void checkForCorrectDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yy");
        assertEquals("30/07/1850", sdf.format(CNPUtils.initializeDate("4500730334151")));
        assertEquals("27/01/1850", sdf.format(CNPUtils.initializeDate("4500127346605")));
        assertEquals("08/11/12", sdf2.format(CNPUtils.initializeDate("7121108021180")));
        assertEquals("20/11/50", sdf2.format(CNPUtils.initializeDate("9501120299371")));
    }

    @Test
    public void checkIfCitizen() {
        assertFalse(CNPUtils.isRomanianCitizen("7121108021180"));
        assertFalse(CNPUtils.isRomanianCitizen("8731010207661"));
        assertFalse(CNPUtils.isRomanianCitizen("9501120299371"));
        assertTrue(CNPUtils.isRomanianCitizen("3500808133078"));
        assertTrue(CNPUtils.isRomanianCitizen("4500713315711"));
    }
}