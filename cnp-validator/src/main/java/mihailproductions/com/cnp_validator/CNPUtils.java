package mihailproductions.com.cnp_validator;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class CNPUtils {
    private CNPUtils() { }

    public static boolean isValidCNP(String cnp) {
        final int cnpLength = 13;
        if (cnp != null) {
            cnp = cnp.trim();
        } else return false;
        return cnp.length() == cnpLength && cnp.matches("\\d+") && controlValidation(cnp) && structureValidation(cnp);
    }

    private static boolean structureValidation(String cnp) {
        String yymmdd = cnp.substring(1, 7);
        String county = cnp.substring(7, 9);
        String registerNumber = cnp.substring(9, 12);
        return cnp.charAt(0) != '0' && birthdateValidation(yymmdd) && countyValidation(county) && registerNumberValidation(registerNumber);
    }

    private static boolean birthdateValidation(String yymmdd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd", Locale.getDefault());
        sdf.setLenient(false);
        try {
            sdf.parse(yymmdd);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean countyValidation(String county) {
        int countyIndex = Integer.parseInt(county);
        return (countyIndex >= 1 && countyIndex <= 46) || countyIndex == 51 || countyIndex == 52;
    }

    private static boolean registerNumberValidation(String registerNumber) {
        return !registerNumber.equals("000");
    }

    private static boolean controlValidation(String cnp) {
        final String controlSequence = "279146358279";
        final int controlDivider = 11;
        int controlSum = 0;
        int controlDigit;
        for (int charIndex = 0; charIndex < controlSequence.length(); charIndex++) {
            controlSum += Character.getNumericValue(cnp.charAt(charIndex)) * Character.getNumericValue(controlSequence.charAt(charIndex));
        }
        if (controlSum % controlDivider == 10) {
            controlDigit = 1;
        } else {
            controlDigit = controlSum % 11;
        }
        return controlDigit + '0' == cnp.charAt(cnp.length() - 1);
    }

    public static String initializeSex(Context context, String cnp) {
        int sexPrameter = cnp.charAt(0) - '0';
        if (sexPrameter == 9) {
            return context.getResources().getString(R.string.unknown);
        } else if (sexPrameter % 2 == 1) {
            return context.getResources().getString(R.string.male);
        } else {
            return context.getResources().getString(R.string.female);
        }
    }

    public static Date initializeDate(String cnp) {
        int yearIndex = cnp.charAt(0) - '0';
        String yymmdd = cnp.substring(1, 7);
        SimpleDateFormat normalDF = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        SimpleDateFormat unknownPrefixDF = new SimpleDateFormat("yyMMdd", Locale.getDefault());
        try {
            switch (yearIndex) {
                case 1:
                case 2:
                    return normalDF.parse("19" + yymmdd);
                case 3:
                case 4:
                    return normalDF.parse("18" + yymmdd);
                case 5:
                case 6:
                    return normalDF.parse("20" + yymmdd);
                case 7:
                case 8:
                case 9:
                    return unknownPrefixDF.parse(yymmdd);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isRomanianCitizen(String cnp) {
        char citizenshipParameter = cnp.charAt(0);
        return !(citizenshipParameter == '7' || citizenshipParameter == '8' || citizenshipParameter == '9');
    }

    public static String initializeRegisterNumber(String cnp) {
        return cnp.substring(9, 12);
    }

    public static String initializeCounty(Context context, String cnp) {
        int countyIndex = Integer.parseInt(cnp.substring(7, 9));
        String counties[] = context.getResources().getStringArray(R.array.counties);
        if (countyIndex == 51) {
            return counties[46];
        } else if (countyIndex == 52) {
            return counties[47];
        } else {
            return counties[countyIndex - 1];
        }
    }
}
