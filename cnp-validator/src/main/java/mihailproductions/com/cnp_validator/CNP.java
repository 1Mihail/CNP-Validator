package mihailproductions.com.cnp_validator;

import android.content.Context;

import java.util.Date;

public class CNP {
    private String cnp;
    private boolean isValid;
    private String sex;
    private Date birthdate;
    private String county;
    private String registerNumber;
    private boolean isRomanianCitizen;

    public CNP(Context context, String cnp) {
        this.isValid = CNPUtils.isValidCNP(cnp);
        if (this.isValid) {
            this.cnp = CNPUtils.initializeCNP(cnp);
            this.sex = CNPUtils.initializeSex(context, this.cnp);
            this.birthdate = CNPUtils.initializeDate(this.cnp);
            this.isRomanianCitizen = CNPUtils.isRomanianCitizen(this.cnp);
            this.registerNumber = CNPUtils.initializeRegisterNumber(this.cnp);
            this.county = CNPUtils.initializeCounty(context, this.cnp);
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

    @Override
    public String toString() {
        return this.cnp;
    }
}
