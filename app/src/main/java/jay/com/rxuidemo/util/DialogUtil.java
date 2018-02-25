package jay.com.rxuidemo.util;

import android.app.DatePickerDialog;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 */

public class DialogUtil {

    private static int MAX_DATE_LIMIT = 151;
    private static int MAX_DAY_LIMIT = 31;

    /**
     * This function will use to show date picker
     *
     * @param context:              Get activity context, required for dialog
     * @param dateFormat:           Send date format e.g "MM/DD/YY"
     * @param isFutureDateRequired: Required if we required to show future date
     * @param dialogPickerListener: Listener for callback of date picker
     */
    public static void getDatePickerDialog(Context context, String dateFormat, boolean isFutureDateRequired, boolean isPastDateRequired, final DialogPickerListener dialogPickerListener) {
        final SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat, Locale.US);
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog dateOfBirthPickerDialog = new DatePickerDialog(context, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            dialogPickerListener.returnDate(dateFormatter.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        if (!isFutureDateRequired) {
            Calendar calender = Calendar.getInstance();
            calender.add(Calendar.DAY_OF_MONTH, -1);
            dateOfBirthPickerDialog.getDatePicker().setMaxDate(calender.getTimeInMillis());
            calender.add(Calendar.YEAR, Calendar.YEAR - MAX_DATE_LIMIT);
            dateOfBirthPickerDialog.getDatePicker().setMinDate(calender.getTimeInMillis());
        }
        if (isPastDateRequired) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 1);
            dateOfBirthPickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis());
        }
        dateOfBirthPickerDialog.show();

    }

    public interface DialogPickerListener {
        void returnDate(String date);
    }
}
