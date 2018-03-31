package mihailproductions.com.cnp_validator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

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
        assertEquals(CNPUtils.initializeSex(context, "9501120293215"), context.getResources().getString(R.string.unknown));
    }

    @Test
    public void CheckForCorrectCounty() {
        String counties[] = context.getResources().getStringArray(R.array.counties);
        assertEquals(CNPUtils.initializeCounty(context, "4500425028294"), counties[1]);
        assertEquals(CNPUtils.initializeCounty(context, "4500610405290"), counties[39]);
        assertEquals(CNPUtils.initializeCounty(context, "3501219522496"), counties[47]);
        assertEquals(CNPUtils.initializeCounty(context, "9501120293215"), counties[28]);
    }

    @Test
    public void checkRegisterNumber() {
        List<CNP> cnpList = new ArrayList<>();
        cnpList.add(new CNP(context, "7121108021180"));
        cnpList.add(new CNP(context, "3500819163377"));
        cnpList.add(new CNP(context, "9501120293215"));

        assertEquals("118", cnpList.get(0).getRegisterNumber());
        assertEquals("337", cnpList.get(1).getRegisterNumber());
        assertEquals("321", cnpList.get(2).getRegisterNumber());
    }

    @Test
    public void checkToString() {
        List<CNP> cnpList = new ArrayList<>();
        cnpList.add(new CNP(context, "4500425028294"));
        cnpList.add(new CNP(context, "3501219522496"));
        cnpList.add(new CNP(context, "4501122373430"));

        assertEquals(cnpList.get(0).toString(), "4500425028294");
        assertEquals(cnpList.get(1).toString(), "3501219522496");
        assertEquals(cnpList.get(2).toString(), "4501122373430");
    }
}
