package com;

import java.util.*;
import java.text.*;

public class DisplayLocales {
    public DisplayLocales () {
        Locale list[] = DateFormat.getAvailableLocales();
        for (Locale aLocale : list) {
            System.out.println(aLocale.toString());
        }
    }
}