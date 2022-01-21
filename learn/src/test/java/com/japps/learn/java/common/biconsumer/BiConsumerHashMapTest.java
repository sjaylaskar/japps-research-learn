/*
 * $Id: HashMapTest.java 20-Jan-2022 2:46:38 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.common.biconsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * The bi consumer hash map test.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class BiConsumerHashMapTest {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final List<Data> datas = fillAndGetDatas();

        DataCodeConsumer.load();
        processDatas(datas);
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

            //System.out.println(user1);
            //System.out.println(user2);
        }
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
            case "01":
                user.setId(data.getData());
                break;
            case "02":
                user.getPerson().setId(data.getData());
                break;
            case "03":
                user.getPerson().setFirstName(data.getData());
                break;
            case "04":
                user.getPerson().setLastName(data.getData());
                break;
            case "05":
                user.getPerson().setField1(data.getData());
                break;
            case "06":
                user.getPerson().setField2(data.getData());
                break;
            case "07":
                user.getPerson().setField3(data.getData());
                break;
            case "08":
                user.getPerson().setField4(data.getData());
                break;
            case "09":
                user.getPerson().setField5(data.getData());
                break;
            case "10":
                user.getPerson().setField6(data.getData());
                break;
            case "11":
                user.getPerson().setField7(data.getData());
                break;
            case "12":
                user.getPerson().setField8(data.getData());
                break;
            case "13":
                user.getPerson().setField9(data.getData());
                break;
            case "14":
                user.getPerson().setField10(data.getData());
                break;
            case "15":
                user.getPerson().setField11(data.getData());
                break;
            case "16":
                user.getPerson().setField12(data.getData());
                break;
            case "17":
                user.getPerson().setField13(data.getData());
                break;
            case "18":
                user.getPerson().setField14(data.getData());
                break;
            case "19":
                user.getPerson().setField15(data.getData());
                break;
            case "20":
                user.getPerson().setField16(data.getData());
                break;
            case "21":
                user.getPerson().setField17(data.getData());
                break;
            case "22":
                user.getPerson().setField18(data.getData());
                break;
            case "23":
                user.getPerson().setField19(data.getData());
                break;
            case "24":
                user.getPerson().setField20(data.getData());
                break;
            case "25":
                user.getPerson().setField21(data.getData());
                break;
            case "26":
                user.getPerson().setField22(data.getData());
                break;
            case "27":
                user.getPerson().setField23(data.getData());
                break;
            case "28":
                user.getPerson().setField24(data.getData());
                break;
            case "29":
                user.getPerson().setField25(data.getData());
                break;
            case "30":
                user.getPerson().setField26(data.getData());
                break;
            case "31":
                user.getPerson().setField27(data.getData());
                break;
            case "32":
                user.getPerson().setField28(data.getData());
                break;
            case "33":
                user.getPerson().setField29(data.getData());
                break;
            case "34":
                user.getPerson().setField30(data.getData());
                break;
            case "35":
                user.getPerson().setField31(data.getData());
                break;
            case "36":
                user.getPerson().setField32(data.getData());
                break;
            case "37":
                user.getPerson().setField33(data.getData());
                break;
            case "38":
                user.getPerson().setField34(data.getData());
                break;
            case "39":
                user.getPerson().setField35(data.getData());
                break;
            case "40":
                user.getPerson().setField36(data.getData());
                break;
            case "41":
                user.getPerson().setField37(data.getData());
                break;
            case "42":
                user.setPassword(data.getData());
                break;
            case "43":
                user.setCreateDate(data.getData());
                break;
            case "44":
                user.setUfield1(data.getData());
                break;
            case "45":
                user.setUfield2(data.getData());
                break;
            case "46":
                user.setUfield3(data.getData());
                break;
            case "47":
                user.setUfield4(data.getData());
                break;
            case "48":
                user.setUfield5(data.getData());
                break;
            case "49":
                user.setUfield6(data.getData());
                break;
            case "50":
                user.setUfield7(data.getData());
                break;
            case "51":
                user.setUfield8(data.getData());
                break;
            case "52":
                user.setUfield9(data.getData());
                break;
            case "53":
                user.setUfield10(data.getData());
                break;
            case "54":
                user.setUfield11(data.getData());
                break;
            case "55":
                user.setUfield12(data.getData());
                break;
            case "56":
                user.setUfield13(data.getData());
                break;
            case "57":
                user.setUfield14(data.getData());
                break;
            case "58":
                user.setUfield15(data.getData());
                break;
            case "59":
                user.setUfield16(data.getData());
                break;
            case "60":
                user.setUfield17(data.getData());
                break;
            case "61":
                user.setUfield18(data.getData());
                break;
            case "62":
                user.setUfield19(data.getData());
                break;
            case "63":
                user.setUfield20(data.getData());
                break;
            case "64":
                user.setUfield21(data.getData());
                break;
            case "65":
                user.setUfield22(data.getData());
                break;
            case "66":
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

        datas.forEach(data -> DataCodeConsumer.map().get(data.getCode()).accept(user, data.getData()));

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

        return datas;
    }

}
