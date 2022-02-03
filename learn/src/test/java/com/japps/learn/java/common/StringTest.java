/*
* $Id: StringTest.java 31-Jan-2022 8:10:18 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.java.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The StringTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringTest {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println("EXTRACTIEDATUM;RELATIENUMMER_AGT;STATUS;DATUM_LAATSTE_WIJZIGING;CODE_SUBAGENT;HOOFDAGENT;TELEFOONNR;STRAAT;HUISNUMMER;HUISNUMMER_TOEV;PLAATS;STRAAT_POSTBUS;HUISNUMMER_POSTBUS;PLAATS_POSTBUS;POSTCODE_KANTOOR;POSTCODE_POSTBUS;EMAIL_ADRES;KVK_NR;KVK_NR_VESTIGING;SAMENV_VERMOGEN;SAMENV_PENSIOENEN;IPDT_NAAM;AANSTELL_DAT;ROYEMENTSDAT;WFD_VERG_NR;BRANCHETYPE"
            .replace(";", ",\n"));

        System.out.println("2018-07-17;243230;AA;20170613;0;;0186 573949;Voorstr;6;;Numansdorp;;;;3281 AV;;henri.bijl@tripleorange.nl;67340342;;J;N;Triple Orange Insurance & Finance B.V.;20161001;;12044706;A"
            .replace(";", ",\n"));

        final String[] keys =
                "EXTRACTIEDATUM;RELATIENUMMER_AGT;STATUS;DATUM_LAATSTE_WIJZIGING;CODE_SUBAGENT;HOOFDAGENT;TELEFOONNR;STRAAT;HUISNUMMER;HUISNUMMER_TOEV;PLAATS;STRAAT_POSTBUS;HUISNUMMER_POSTBUS;PLAATS_POSTBUS;POSTCODE_KANTOOR;POSTCODE_POSTBUS;EMAIL_ADRES;KVK_NR;KVK_NR_VESTIGING;SAMENV_VERMOGEN;SAMENV_PENSIOENEN;IPDT_NAAM;AANSTELL_DAT;ROYEMENTSDAT;WFD_VERG_NR;BRANCHETYPE"
                .split(";");
        final String[] values = "2018-07-17;243230;AA;20170613;0;;0186 573949;Voorstr;6;;Numansdorp;;;;3281 AV;;henri.bijl@tripleorange.nl;67340342;;J;N;Triple Orange Insurance & Finance B.V.;20161001;;12044706;A"
        .split(";");
        final Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }

        System.out.println(map);
    }

}
