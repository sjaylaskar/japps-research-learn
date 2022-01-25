/*
 * $Id: HashMapTest.java 20-Jan-2022 2:46:38 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.common.biconsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;


/**
 * The bi consumer hash map test.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class SparsedBiConsumerHashMapTest {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final List<Data> datas = fillAndGetDatas();

        SparsedDataCodeConsumer.load();
        processDatas(datas);

        printIntKeys();
    }

    /**
     * Process datas.
     *
     * @param datas the datas
     */
    private static void processDatas(final List<Data> datas) {

        // Measure process performance:
        for (int i = 1; i <= 25; i++) {
            long start, end;

            final User user1 = new User();
            final User user2 = new User();

            start = System.currentTimeMillis();
            processBySwitchCase(datas, user1);
            end = System.currentTimeMillis();
            System.out.println("Processed by switch-case in " + (end - start) + " ms.");

            start = System.currentTimeMillis();
            processByMap(datas, user2);
            end = System.currentTimeMillis();
            System.out.println("Processed by map in: " + (end - start) + " ms.");

            System.out.println(user1);
            System.out.println(user2);

        }
    }

    private static void printIntKeys() {
        SparsedDataCodeConsumer.map()
        .keySet()
        .stream()
        .filter(NumberUtils::isCreatable)
        .map(Integer::parseInt)
        .filter(val -> val >= 0)
        .forEach(System.out::println);
    }

    /**
     * Process by switch case.
     *
     * @param datas the datas
     * @param user the user
     */
    private static void processBySwitchCase(final List<Data> datas, final User user) {

        datas.forEach(data -> {
            switch (data.getCode()) {
            case "02323gd110":
                user.setId(data.getData());
                break;
            case "01sff2143":
                user.getPerson().setId(data.getData());
                break;
            case "1234":
                user.getPerson().setFirstName(data.getData());
                break;
            case "34sfs262":
                user.getPerson().setLastName(data.getData());
                break;
            case "2sfwttt23":
                user.getPerson().setField1(data.getData());
                break;
            case "12":
                user.getPerson().setField2(data.getData());
                break;
            case "99901":
                user.getPerson().setField3(data.getData());
                break;
            case "12123":
                user.getPerson().setField4(data.getData());
                break;
            case "8289":
                user.getPerson().setField5(data.getData());
                break;
            case "1127":
                user.getPerson().setField6(data.getData());
                break;
            case "82662":
                user.getPerson().setField7(data.getData());
                break;
            case "26273":
                user.getPerson().setField8(data.getData());
                break;
            case "1103abc":
                user.getPerson().setField9(data.getData());
                break;
            case "09232":
                user.getPerson().setField10(data.getData());
                break;
            case "12wwsff3":
                user.getPerson().setField11(data.getData());
                break;
            case "31sfsft12":
                user.getPerson().setField12(data.getData());
                break;
            case "09823sdsd":
                user.getPerson().setField13(data.getData());
                break;
            case "1212xre":
                user.getPerson().setField14(data.getData());
                break;
            case "121312sss":
                user.getPerson().setField15(data.getData());
                break;
            case "loresn12":
                user.getPerson().setField16(data.getData());
                break;
            case "1213sd":
                user.getPerson().setField17(data.getData());
                break;
            case "09912dsd":
                user.getPerson().setField18(data.getData());
                break;
            case "12137sdhsh":
                user.getPerson().setField19(data.getData());
                break;
            case "por12":
                user.getPerson().setField20(data.getData());
                break;
            case "abcg1212":
                user.getPerson().setField21(data.getData());
                break;
            case "98731ss":
                user.getPerson().setField22(data.getData());
                break;
            case "poo0992":
                user.getPerson().setField23(data.getData());
                break;
            case "12esd23":
                user.getPerson().setField24(data.getData());
                break;
            case "kkjj121adsd":
                user.getPerson().setField25(data.getData());
                break;
            case "09992ffw11":
                user.getPerson().setField26(data.getData());
                break;
            case "112er34":
                user.getPerson().setField27(data.getData());
                break;
            case "0992kkljd1":
                user.getPerson().setField28(data.getData());
                break;
            case "546723sddf":
                user.getPerson().setField29(data.getData());
                break;
            case "sfsd223":
                user.getPerson().setField30(data.getData());
                break;
            case "pooop2332":
                user.getPerson().setField31(data.getData());
                break;
            case "09232sfsf1":
                user.getPerson().setField32(data.getData());
                break;
            case "12ff121f":
                user.getPerson().setField33(data.getData());
                break;
            case "1213fff12":
                user.getPerson().setField34(data.getData());
                break;
            case "099913dfsfsf":
                user.getPerson().setField35(data.getData());
                break;
            case "poppoosdsd1122":
                user.getPerson().setField36(data.getData());
                break;
            case "09923ff":
                user.getPerson().setField37(data.getData());
                break;
            case "abcndwsc122987":
                user.setPassword(data.getData());
                break;
            case "101023sfsff":
                user.setCreateDate(data.getData());
                break;
            case "abcd1212popophfhr":
                user.setUfield1(data.getData());
                break;
            case "xqytsdsfl12":
                user.setUfield2(data.getData());
                break;
            case "oiir84hfg71":
                user.setUfield3(data.getData());
                break;
            case "47":
                user.setUfield4(data.getData());
                break;
            case "232rjfjkr12":
                user.setUfield5(data.getData());
                break;
            case "09923fsffsf1":
                user.setUfield6(data.getData());
                break;
            case "llpok211312":
                user.setUfield7(data.getData());
                break;
            case "sfjskfj1212":
                user.setUfield8(data.getData());
                break;
            case "09982313fsfsf":
                user.setUfield9(data.getData());
                break;
            case "uuuii12fsfsfm":
                user.setUfield10(data.getData());
                break;
            case "929323fdfdf":
                user.setUfield11(data.getData());
                break;
            case "23232efdff23":
                user.setUfield12(data.getData());
                break;
            case "98872323dgdgdgdgerwrwt":
                user.setUfield13(data.getData());
                break;
            case "12124fdfd3":
                user.setUfield14(data.getData());
                break;
            case "131fdg1231":
                user.setUfield15(data.getData());
                break;
            case "1213gdgd23":
                user.setUfield16(data.getData());
                break;
            case "1213fgdg1233099ffff":
                user.setUfield17(data.getData());
                break;
            case "kladad1212rrt":
                user.setUfield18(data.getData());
                break;
            case "yttogpfn12":
                user.setUfield19(data.getData());
                break;
            case "12313egdg232e":
                user.setUfield20(data.getData());
                break;
            case "dfdg1212gdg21":
                user.setUfield21(data.getData());
                break;
            case "ff213gdg2":
                user.setUfield22(data.getData());
                break;
            case "2323gdg2323oop2323nfmmnfke":
                user.setUfield23(data.getData());
                break;
            }
        });

    }

    /**
     * Process by map.
     *
     * @param datas the datas
     * @param user the user
     */
    private static void processByMap(final List<Data> datas, final User user) {

        datas.stream().filter(data -> SparsedDataCodeConsumer.map().containsKey(data.getCode()))
            .forEach(data -> SparsedDataCodeConsumer.map().get(data.getCode()).accept(user, data.getData()));

    }

    /**
     * Fill and get datas.
     *
     * @return the array list
     */
    private static List<Data> fillAndGetDatas() {

        final List<Data> datas = new ArrayList<>(
            Arrays.asList(
                new Data("01", "UserId"),
                new Data("02", "PersonId"),
                new Data("03", "P_FirstName"),
                new Data("04", "P_LastName")));
        for (int i = 5; i <= 41; i++) {
            datas.add(new Data(((i < 10) ? "0" + i : String.valueOf(i)), ("Field" + (i - 4))));
        }
        datas.addAll(Arrays.asList(
            new Data("42", "U_Password"),
            new Data("43", "U_CreateDate")));
        for (int i = 44; i <= 66; i++) {
            datas.add(new Data(String.valueOf(i), ("UField" + (i - 43))));
        }

        datas.addAll(SparsedDataCodeConsumer.map().keySet().stream().map(code -> new Data(code, "Field" + code)).toList());

        return datas;
    }

}
