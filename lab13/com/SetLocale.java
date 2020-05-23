package com;
import java.util.*;

public class SetLocale {
   public static Locale Set(Locale locale) {
 
      Locale.setDefault(new Locale("ro", "ro"));
      locale = new Locale("ro", "ro");

      System.out.println("Locale: " +  Locale.getDefault());
      return locale;
   }
}