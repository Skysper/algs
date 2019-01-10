package com.skysper.util;

import java.io.BufferedInputStream;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author David Pritchard
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * @author skysper
 */
public class In {
    private static final  String CHARSET_NAME = "UTF-8";
    private static final Locale LOCALE = Locale.CHINA;
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

    private Scanner scanner;
    public In() {
        scanner = new Scanner(new BufferedInputStream(System.in), CHARSET_NAME);
        scanner.useLocale(LOCALE);
    }

    public String readString() {
        try{
            return scanner.next();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("read a 'String' failed from the input stream.");
        }
    }

    public String readAll() {
        if (!scanner.hasNextLine()) {
            return "";
        }
        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }


    public String[] readAllStrings() {
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        if (tokens.length == 0 || tokens[0].length() > 0) {
            return tokens;
        }
        String[] decapitokens = new String[tokens.length - 1];
        for (int i = 0; i < tokens.length - 1; i++) {
            decapitokens[i] = tokens[i+1];
        }
        return decapitokens;
    }

    public int[] readAllInts() {
        String[] fields = readAllStrings();
        int[] vals = new int[fields.length];
        for(int i = 0; i < fields.length; i++) {
            vals[i] = Integer.parseInt(fields[i]);
        }
        return vals;
    }






}
