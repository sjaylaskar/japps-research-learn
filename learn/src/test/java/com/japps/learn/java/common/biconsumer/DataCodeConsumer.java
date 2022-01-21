/*
 * $Id: DataCodeConsumer.java 20-Jan-2022 8:32:14 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.common.biconsumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


/**
 * The data code consumer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class DataCodeConsumer {

    /**
     * Instantiates a new data code consumer.
     */
    private DataCodeConsumer() {

    }

    public static void load() {
        System.out.println("Data code consumer loaded: " + DATA_CODE_CONSUMER_MAP.size() + " entries.");
    }

    /** The data code consumer map. */
    private static final Map<String, BiConsumer<User, String>> DATA_CODE_CONSUMER_MAP = new HashMap<>(66);

    static {

        DATA_CODE_CONSUMER_MAP.put("01", (final User user, final String data) -> user.setId(data));
        DATA_CODE_CONSUMER_MAP.put("02", (final User user, final String data) -> user.getPerson().setId(data));
        DATA_CODE_CONSUMER_MAP.put("03", (final User user, final String data) -> user.getPerson().setFirstName(data));
        DATA_CODE_CONSUMER_MAP.put("04", (final User user, final String data) -> user.getPerson().setLastName(data));
        DATA_CODE_CONSUMER_MAP.put("05", (final User user, final String data) -> user.getPerson().setField1(data));
        DATA_CODE_CONSUMER_MAP.put("06", (final User user, final String data) -> user.getPerson().setField2(data));
        DATA_CODE_CONSUMER_MAP.put("07", (final User user, final String data) -> user.getPerson().setField3(data));
        DATA_CODE_CONSUMER_MAP.put("08", (final User user, final String data) -> user.getPerson().setField4(data));
        DATA_CODE_CONSUMER_MAP.put("09", (final User user, final String data) -> user.getPerson().setField5(data));
        DATA_CODE_CONSUMER_MAP.put("10", (final User user, final String data) -> user.getPerson().setField6(data));
        DATA_CODE_CONSUMER_MAP.put("11", (final User user, final String data) -> user.getPerson().setField7(data));
        DATA_CODE_CONSUMER_MAP.put("12", (final User user, final String data) -> user.getPerson().setField8(data));
        DATA_CODE_CONSUMER_MAP.put("13", (final User user, final String data) -> user.getPerson().setField9(data));
        DATA_CODE_CONSUMER_MAP.put("14", (final User user, final String data) -> user.getPerson().setField10(data));
        DATA_CODE_CONSUMER_MAP.put("15", (final User user, final String data) -> user.getPerson().setField11(data));
        DATA_CODE_CONSUMER_MAP.put("16", (final User user, final String data) -> user.getPerson().setField12(data));
        DATA_CODE_CONSUMER_MAP.put("17", (final User user, final String data) -> user.getPerson().setField13(data));
        DATA_CODE_CONSUMER_MAP.put("18", (final User user, final String data) -> user.getPerson().setField14(data));
        DATA_CODE_CONSUMER_MAP.put("19", (final User user, final String data) -> user.getPerson().setField15(data));
        DATA_CODE_CONSUMER_MAP.put("20", (final User user, final String data) -> user.getPerson().setField16(data));
        DATA_CODE_CONSUMER_MAP.put("21", (final User user, final String data) -> user.getPerson().setField17(data));
        DATA_CODE_CONSUMER_MAP.put("22", (final User user, final String data) -> user.getPerson().setField18(data));
        DATA_CODE_CONSUMER_MAP.put("23", (final User user, final String data) -> user.getPerson().setField19(data));
        DATA_CODE_CONSUMER_MAP.put("24", (final User user, final String data) -> user.getPerson().setField20(data));
        DATA_CODE_CONSUMER_MAP.put("25", (final User user, final String data) -> user.getPerson().setField21(data));
        DATA_CODE_CONSUMER_MAP.put("26", (final User user, final String data) -> user.getPerson().setField22(data));
        DATA_CODE_CONSUMER_MAP.put("27", (final User user, final String data) -> user.getPerson().setField23(data));
        DATA_CODE_CONSUMER_MAP.put("28", (final User user, final String data) -> user.getPerson().setField24(data));
        DATA_CODE_CONSUMER_MAP.put("29", (final User user, final String data) -> user.getPerson().setField25(data));
        DATA_CODE_CONSUMER_MAP.put("30", (final User user, final String data) -> user.getPerson().setField26(data));
        DATA_CODE_CONSUMER_MAP.put("31", (final User user, final String data) -> user.getPerson().setField27(data));
        DATA_CODE_CONSUMER_MAP.put("32", (final User user, final String data) -> user.getPerson().setField28(data));
        DATA_CODE_CONSUMER_MAP.put("33", (final User user, final String data) -> user.getPerson().setField29(data));
        DATA_CODE_CONSUMER_MAP.put("34", (final User user, final String data) -> user.getPerson().setField30(data));
        DATA_CODE_CONSUMER_MAP.put("35", (final User user, final String data) -> user.getPerson().setField31(data));
        DATA_CODE_CONSUMER_MAP.put("36", (final User user, final String data) -> user.getPerson().setField32(data));
        DATA_CODE_CONSUMER_MAP.put("37", (final User user, final String data) -> user.getPerson().setField33(data));
        DATA_CODE_CONSUMER_MAP.put("38", (final User user, final String data) -> user.getPerson().setField34(data));
        DATA_CODE_CONSUMER_MAP.put("39", (final User user, final String data) -> user.getPerson().setField35(data));
        DATA_CODE_CONSUMER_MAP.put("40", (final User user, final String data) -> user.getPerson().setField36(data));
        DATA_CODE_CONSUMER_MAP.put("41", (final User user, final String data) -> user.getPerson().setField37(data));
        DATA_CODE_CONSUMER_MAP.put("42", (final User user, final String data) -> user.setPassword(data));
        DATA_CODE_CONSUMER_MAP.put("43", (final User user, final String data) -> user.setCreateDate(data));
        DATA_CODE_CONSUMER_MAP.put("44", (final User user, final String data) -> user.setUfield1(data));
        DATA_CODE_CONSUMER_MAP.put("45", (final User user, final String data) -> user.setUfield2(data));
        DATA_CODE_CONSUMER_MAP.put("46", (final User user, final String data) -> user.setUfield3(data));
        DATA_CODE_CONSUMER_MAP.put("47", (final User user, final String data) -> user.setUfield4(data));
        DATA_CODE_CONSUMER_MAP.put("48", (final User user, final String data) -> user.setUfield5(data));
        DATA_CODE_CONSUMER_MAP.put("49", (final User user, final String data) -> user.setUfield6(data));
        DATA_CODE_CONSUMER_MAP.put("50", (final User user, final String data) -> user.setUfield7(data));
        DATA_CODE_CONSUMER_MAP.put("51", (final User user, final String data) -> user.setUfield8(data));
        DATA_CODE_CONSUMER_MAP.put("52", (final User user, final String data) -> user.setUfield9(data));
        DATA_CODE_CONSUMER_MAP.put("53", (final User user, final String data) -> user.setUfield10(data));
        DATA_CODE_CONSUMER_MAP.put("54", (final User user, final String data) -> user.setUfield11(data));
        DATA_CODE_CONSUMER_MAP.put("55", (final User user, final String data) -> user.setUfield12(data));
        DATA_CODE_CONSUMER_MAP.put("56", (final User user, final String data) -> user.setUfield13(data));
        DATA_CODE_CONSUMER_MAP.put("57", (final User user, final String data) -> user.setUfield14(data));
        DATA_CODE_CONSUMER_MAP.put("58", (final User user, final String data) -> user.setUfield15(data));
        DATA_CODE_CONSUMER_MAP.put("59", (final User user, final String data) -> user.setUfield16(data));
        DATA_CODE_CONSUMER_MAP.put("60", (final User user, final String data) -> user.setUfield17(data));
        DATA_CODE_CONSUMER_MAP.put("61", (final User user, final String data) -> user.setUfield18(data));
        DATA_CODE_CONSUMER_MAP.put("62", (final User user, final String data) -> user.setUfield19(data));
        DATA_CODE_CONSUMER_MAP.put("63", (final User user, final String data) -> user.setUfield20(data));
        DATA_CODE_CONSUMER_MAP.put("64", (final User user, final String data) -> user.setUfield21(data));
        DATA_CODE_CONSUMER_MAP.put("65", (final User user, final String data) -> user.setUfield22(data));
        DATA_CODE_CONSUMER_MAP.put("66", (final User user, final String data) -> user.setUfield23(data));

    }

    /**
     * Gets the data consumer map.
     *
     * @return the data consumer map
     */
    static Map<String, BiConsumer<User, String>> map() {

        return Map.copyOf(DATA_CODE_CONSUMER_MAP);
    }
}
