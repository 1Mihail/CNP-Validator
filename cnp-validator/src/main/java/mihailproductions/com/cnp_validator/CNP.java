package mihailproductions.com.cnp_validator;

import android.content.Context;

import java.util.Date;

public class CNP {
    private boolean isValid;
    private String sex;
    private Date birthdate;
    private String county;
    private String registerNumber;
    private boolean isRomanianCitizen;

    public CNP(Context context, String cnp) {
        this.isValid = CNPUtils.isValidCNP(cnp);
        if (this.isValid) {
            this.sex = CNPUtils.initializeSex(context, cnp);
            this.birthdate = CNPUtils.initializeDate(cnp);
            this.isRomanianCitizen = CNPUtils.isRomanianCitizen(cnp);
            this.registerNumber = cnp.substring(9, 12);
            this.county = CNPUtils.initializeCounty(context, cnp);
        }
    }

    public boolean isValid() {
        return isValid;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getCounty() {
        return county;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public boolean isRomanianCitizen() {
        return isRomanianCitizen;
    }
}
