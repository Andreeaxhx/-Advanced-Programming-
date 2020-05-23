package com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;

public class Info {

	Locale locale = Locale.getDefault();
	static void printDate(Locale locale){
        DateFormat formatter=DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
        Date currentDate=new Date();
        String date=formatter.format(currentDate);
        System.out.println(date);
        }

    static void printCurrency(Locale locale){
         double dbl=10500.3245;
         NumberFormat formatter=NumberFormat.getCurrencyInstance(locale);
         String currency=formatter.format(dbl);
         System.out.println(currency+" for the locale "+locale);
        } 

    public static void main(String args[])
    { 
    	String weekday;
        int i;
        Locale locale= new Locale("en","en");
        locale=SetLocale.Set(locale);

        System.out.println("Country: " + locale.getDisplayCountry());
        System.out.println("Language: " + locale.getDisplayLanguage());
        System.out.println("English name: " + locale.getDisplayName());
        
        String[] weekdays = new DateFormatSymbols().getWeekdays();
        
        System.out.print("Week days: ");
        for (i = 2; i < (weekdays.length-2); i++) {
           weekday = weekdays[i];
           System.out.print(weekday + ", ");
        }
        System.out.println(weekdays[i]);

 
         Currency currency = Currency.getInstance(locale);
         System.out.println("Currency: " + currency.getSymbol());
         
         
         final DateFormatSymbols months = new DateFormatSymbols(locale);

             String[] longMonths = months.getMonths();
             System.out.printf("Months: ");
             for (i = 0; i < (longMonths.length-2); i++) {
                weekday = longMonths[i];
                System.out.print(weekday + ", ");
             }
             System.out.println(longMonths[i]);

             String[] ShortMonths = months.getShortMonths();
             System.out.printf("Short months: ");
             for (i = 0; i < (ShortMonths.length-2); i++) {
                 weekday = ShortMonths[i];
                 System.out.print(weekday + ", ");
              }
              System.out.println(ShortMonths[i]);

         
         LocalDateTime today = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale);
         System.out.print("Today: " + today.format(formatter) + " (");
         formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale);
         System.out.print(" " + today.format(formatter) + ")");
    }
}
