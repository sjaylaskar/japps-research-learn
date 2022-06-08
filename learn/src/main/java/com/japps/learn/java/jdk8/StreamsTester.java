/*
 * $Id: StreamsTester.java 08-Jun-2022 11:50:37 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * The streams tester.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StreamsTester {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        testGroupByField();
        testLimitAndSkip();
    }

    /**
     * Test limit and skip.
     */
    private static void testLimitAndSkip() {
        System.out.println(
        IntStream.range(1, 11)
        .map(val -> val * val)
        .skip(2)
        .boxed()
        .toList());

        System.out.println(
            IntStream.range(1, 11)
            .map(val -> val * val)
            .limit(2)
            .boxed()
            .toList());
    }

    /**
     * Test group by field.
     */
    private static void testGroupByField() {

        final class Country {

            private String name;

            private String language;

            Country name(final String name) {

                this.name = name;
                return this;
            }

            Country language(final String language) {

                this.language = language;
                return this;
            }

            String getName() {

                return name;
            }

            String getLanguage() {

                return language;
            }

            @Override
            public String toString() {

                return getName() + "=>" + getLanguage();
            }

        }

        enum LanguagePriority {
            HIN(0),
            EN(1),
            EN_US(2),
            NL(3),
            FR(4),
            GE(5),
            CH(6),
            SP(7),
            UNKNOWN(Integer.MAX_VALUE);

            private final Integer priority;


            private LanguagePriority(final Integer priority) {

               this.priority = priority;
            }

            static int compare(final String language1, final String language2) {
                return Integer.compare(LanguagePriority.fromLanguage(language1).getPriority(),
                    LanguagePriority.fromLanguage(language2).getPriority());
            }

            static LanguagePriority fromLanguage(final String language) {
                return Arrays.stream(values()).filter(value -> value.name().equalsIgnoreCase(language)).findFirst().orElse(UNKNOWN);
            }

            Integer getPriority() {

                return priority;
            }
        }

        // Order: HIN > EN > EN_US > NL > FR > GE > CH > SP

        final List<Country> countries = List.of(
            new Country().name("China").language("CH"),
            new Country().name("India").language("HIN"),
            new Country().name("Hong Kong").language("CH"),
            new Country().name("Australia").language("EN"),
            new Country().name("Nederlands").language("NL"),
            new Country().name("France").language("FR"),
            new Country().name("German").language("GE"),
            new Country().name("Poland").language("GE"),
            new Country().name("Spain").language("SP"),
            new Country().name("USA").language("EN_US"),
            new Country().name("Nepal").language("HIN"),
            new Country().name("Sri Lanka").language("HIN"),
            new Country().name("Norway").language("GE"),
            new Country().name("Belgium").language("FR"));

        System.out.println(countries
            .stream()
            .collect(
                Collectors.groupingBy(Country::getLanguage)));

        System.out.println("Sorted by language priority:");
        System.out.println(
        countries
        .stream()
        .collect(
            Collectors.groupingBy(Country::getLanguage))
        .entrySet()
        .stream()
        .sorted((a, b) -> LanguagePriority.compare(a.getKey(), b.getKey()))
        .toList());
    }

}
