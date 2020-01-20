package com.tbudis.penguinrandomhouse.consumer.util;


import org.apache.commons.text.WordUtils;

/**
 * Utility for converting name of person.
 *
 * @author titus
 * @since 2020-01-20
 */
public class NameUtil {

    /**
     * If the input name is in format [lastName, firstName], convert it into [firstName lastName] format.
     * For example, "Howell, Dan" becomes "Dan Howell".
     *
     * @param name input name
     * @return formatted name
     */
    public static String convert(String name) {
        int commaIndex = name.indexOf(',');
        if (commaIndex == -1) {
            return name;
        }

        String lastName = name.substring(0, commaIndex).trim();
        String firstName = name.substring(commaIndex + 1).trim();

        String fullName = String.format("%s %s", firstName, lastName);
        return WordUtils.capitalizeFully(fullName);
    }
}
