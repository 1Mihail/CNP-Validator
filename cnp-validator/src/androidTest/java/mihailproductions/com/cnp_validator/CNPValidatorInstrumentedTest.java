package mihailproductions.com.cnp_validator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class CNPValidatorInstrumentedTest {
    private Context context;

    @Before
    public void initialization() {
        this.context = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void CheckForCorrectSex() {
        assertEquals(CNPUtils.initializeSex(context, "3500819163377"), context.getResources().getString(R.string.male));
        assertEquals(CNPUtils.initializeSex(context, "4501122373430"), context.getResources().getString(R.string.female));
    }

    @Test
    public void CheckForCorrectCounty() {
        String counties[] = context.getResources().getStringArray(R.array.counties);
        assertEquals(CNPUtils.initializeCounty(context, "4500425028294"), counties[1]);
        assertEquals(CNPUtils.initializeCounty(context, "4500610405290"), counties[39]);
        assertEquals(CNPUtils.initializeCounty(context, "3501219522496"), counties[47]);
    }

    @Test
    public void checkRegisterNumber() {
        CNP cnp = new CNP(context, "7121108021180");
        CNP cnp2 = new CNP(context, "3500819163377");

        assertEquals("118", cnp.getRegisterNumber());
        assertEquals("337", cnp2.getRegisterNumber());
    }
}
