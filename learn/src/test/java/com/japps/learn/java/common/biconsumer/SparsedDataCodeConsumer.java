/*
 * $Id: SparsedDataCodeConsumer.java 20-Jan-2022 8:32:14 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.common.biconsumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


/**
 * The sparsed data code consumer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class SparsedDataCodeConsumer {

    /**
     * Instantiates a new sparsed data code consumer.
     */
    private SparsedDataCodeConsumer() {

    }

    /**
     * Load.
     */
    public static void load() {
        System.out.println("Sparsed data code consumer loaded: " + DATA_CODE_CONSUMER_MAP.size() + " entries.");
    }

    /** The sparsed data code consumer map. */
    private static final Map<String, BiConsumer<User, String>> DATA_CODE_CONSUMER_MAP = new HashMap<>(66);

    static {

        DATA_CODE_CONSUMER_MAP.put("02323gd110", (final User user, final String data) -> user.setId(data));
        DATA_CODE_CONSUMER_MAP.put("01sff2143", (final User user, final String data) -> user.getPerson().setId(data));
        DATA_CODE_CONSUMER_MAP.put("1234", (final User user, final String data) -> user.getPerson().setFirstName(data));
        DATA_CODE_CONSUMER_MAP.put("34sfs262", (final User user, final String data) -> user.getPerson().setLastName(data));
        DATA_CODE_CONSUMER_MAP.put("2sfwttt23", (final User user, final String data) -> user.getPerson().setField1(data));
        DATA_CODE_CONSUMER_MAP.put("12", (final User user, final String data) -> user.getPerson().setField2(data));
        DATA_CODE_CONSUMER_MAP.put("99901", (final User user, final String data) -> user.getPerson().setField3(data));
        DATA_CODE_CONSUMER_MAP.put("12123", (final User user, final String data) -> user.getPerson().setField4(data));
        DATA_CODE_CONSUMER_MAP.put("8289", (final User user, final String data) -> user.getPerson().setField5(data));
        DATA_CODE_CONSUMER_MAP.put("1127", (final User user, final String data) -> user.getPerson().setField6(data));
        DATA_CODE_CONSUMER_MAP.put("82662", (final User user, final String data) -> user.getPerson().setField7(data));
        DATA_CODE_CONSUMER_MAP.put("26273", (final User user, final String data) -> user.getPerson().setField8(data));
        DATA_CODE_CONSUMER_MAP.put("1103abc", (final User user, final String data) -> user.getPerson().setField9(data));
        DATA_CODE_CONSUMER_MAP.put("09232", (final User user, final String data) -> user.getPerson().setField10(data));
        DATA_CODE_CONSUMER_MAP.put("12wwsff3", (final User user, final String data) -> user.getPerson().setField11(data));
        DATA_CODE_CONSUMER_MAP.put("31sfsft12", (final User user, final String data) -> user.getPerson().setField12(data));
        DATA_CODE_CONSUMER_MAP.put("09823sdsd", (final User user, final String data) -> user.getPerson().setField13(data));
        DATA_CODE_CONSUMER_MAP.put("1212xre", (final User user, final String data) -> user.getPerson().setField14(data));
        DATA_CODE_CONSUMER_MAP.put("121312sss", (final User user, final String data) -> user.getPerson().setField15(data));
        DATA_CODE_CONSUMER_MAP.put("loresn12", (final User user, final String data) -> user.getPerson().setField16(data));
        DATA_CODE_CONSUMER_MAP.put("1213sd", (final User user, final String data) -> user.getPerson().setField17(data));
        DATA_CODE_CONSUMER_MAP.put("09912dsd", (final User user, final String data) -> user.getPerson().setField18(data));
        DATA_CODE_CONSUMER_MAP.put("12137sdhsh", (final User user, final String data) -> user.getPerson().setField19(data));
        DATA_CODE_CONSUMER_MAP.put("por12", (final User user, final String data) -> user.getPerson().setField20(data));
        DATA_CODE_CONSUMER_MAP.put("abcg1212", (final User user, final String data) -> user.getPerson().setField21(data));
        DATA_CODE_CONSUMER_MAP.put("98731ss", (final User user, final String data) -> user.getPerson().setField22(data));
        DATA_CODE_CONSUMER_MAP.put("poo0992", (final User user, final String data) -> user.getPerson().setField23(data));
        DATA_CODE_CONSUMER_MAP.put("12esd23", (final User user, final String data) -> user.getPerson().setField24(data));
        DATA_CODE_CONSUMER_MAP.put("kkjj121adsd", (final User user, final String data) -> user.getPerson().setField25(data));
        DATA_CODE_CONSUMER_MAP.put("09992ffw11", (final User user, final String data) -> user.getPerson().setField26(data));
        DATA_CODE_CONSUMER_MAP.put("112er34", (final User user, final String data) -> user.getPerson().setField27(data));
        DATA_CODE_CONSUMER_MAP.put("0992kkljd1", (final User user, final String data) -> user.getPerson().setField28(data));
        DATA_CODE_CONSUMER_MAP.put("546723sddf", (final User user, final String data) -> user.getPerson().setField29(data));
        DATA_CODE_CONSUMER_MAP.put("sfsd223", (final User user, final String data) -> user.getPerson().setField30(data));
        DATA_CODE_CONSUMER_MAP.put("pooop2332", (final User user, final String data) -> user.getPerson().setField31(data));
        DATA_CODE_CONSUMER_MAP.put("09232sfsf1", (final User user, final String data) -> user.getPerson().setField32(data));
        DATA_CODE_CONSUMER_MAP.put("12ff121f", (final User user, final String data) -> user.getPerson().setField33(data));
        DATA_CODE_CONSUMER_MAP.put("1213fff12", (final User user, final String data) -> user.getPerson().setField34(data));
        DATA_CODE_CONSUMER_MAP.put("099913dfsfsf", (final User user, final String data) -> user.getPerson().setField35(data));
        DATA_CODE_CONSUMER_MAP.put("poppoosdsd1122", (final User user, final String data) -> user.getPerson().setField36(data));
        DATA_CODE_CONSUMER_MAP.put("09923ff", (final User user, final String data) -> user.getPerson().setField37(data));
        DATA_CODE_CONSUMER_MAP.put("abcndwsc122987", (final User user, final String data) -> user.setPassword(data));
        DATA_CODE_CONSUMER_MAP.put("101023sfsff", (final User user, final String data) -> user.setCreateDate(data));
        DATA_CODE_CONSUMER_MAP.put("abcd1212popophfhr", (final User user, final String data) -> user.setUfield1(data));
        DATA_CODE_CONSUMER_MAP.put("xqytsdsfl12", (final User user, final String data) -> user.setUfield2(data));
        DATA_CODE_CONSUMER_MAP.put("oiir84hfg71", (final User user, final String data) -> user.setUfield3(data));
        DATA_CODE_CONSUMER_MAP.put("47", (final User user, final String data) -> user.setUfield4(data));
        DATA_CODE_CONSUMER_MAP.put("232rjfjkr12", (final User user, final String data) -> user.setUfield5(data));
        DATA_CODE_CONSUMER_MAP.put("09923fsffsf1", (final User user, final String data) -> user.setUfield6(data));
        DATA_CODE_CONSUMER_MAP.put("llpok211312", (final User user, final String data) -> user.setUfield7(data));
        DATA_CODE_CONSUMER_MAP.put("sfjskfj1212", (final User user, final String data) -> user.setUfield8(data));
        DATA_CODE_CONSUMER_MAP.put("09982313fsfsf", (final User user, final String data) -> user.setUfield9(data));
        DATA_CODE_CONSUMER_MAP.put("uuuii12fsfsfm", (final User user, final String data) -> user.setUfield10(data));
        DATA_CODE_CONSUMER_MAP.put("929323fdfdf", (final User user, final String data) -> user.setUfield11(data));
        DATA_CODE_CONSUMER_MAP.put("23232efdff23", (final User user, final String data) -> user.setUfield12(data));
        DATA_CODE_CONSUMER_MAP.put("98872323dgdgdgdgerwrwt", (final User user, final String data) -> user.setUfield13(data));
        DATA_CODE_CONSUMER_MAP.put("12124fdfd3", (final User user, final String data) -> user.setUfield14(data));
        DATA_CODE_CONSUMER_MAP.put("131fdg1231", (final User user, final String data) -> user.setUfield15(data));
        DATA_CODE_CONSUMER_MAP.put("1213gdgd23", (final User user, final String data) -> user.setUfield16(data));
        DATA_CODE_CONSUMER_MAP.put("1213fgdg1233099ffff", (final User user, final String data) -> user.setUfield17(data));
        DATA_CODE_CONSUMER_MAP.put("kladad1212rrt", (final User user, final String data) -> user.setUfield18(data));
        DATA_CODE_CONSUMER_MAP.put("yttogpfn12", (final User user, final String data) -> user.setUfield19(data));
        DATA_CODE_CONSUMER_MAP.put("12313egdg232e", (final User user, final String data) -> user.setUfield20(data));
        DATA_CODE_CONSUMER_MAP.put("dfdg1212gdg21", (final User user, final String data) -> user.setUfield21(data));
        DATA_CODE_CONSUMER_MAP.put("ff213gdg2", (final User user, final String data) -> user.setUfield22(data));
        DATA_CODE_CONSUMER_MAP.put("2323gdg2323oop2323nfmmnfke", (final User user, final String data) -> user.setUfield23(data));

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
