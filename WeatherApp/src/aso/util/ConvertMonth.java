// Student number: c1767198
package aso.util;

import java.text.DateFormatSymbols;

/**
 * Class for formatting of months
 */
public class ConvertMonth {

    /**
     * Method to convert month from integer number (1-12) to name of month (January - December).
     * @param monthNum, integer number of month (1-12)
     * @return string, name of month.
     */
    public static String convertMonth(int monthNum){
        return new DateFormatSymbols().getMonths()[monthNum - 1];
    }
}
