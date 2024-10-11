/*
 * Id: CoinFlipProbabilityComputer.java
 * Copyright (©) 2024 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.math;

import java.util.*;

import org.apache.commons.lang3.*;
import org.apache.commons.lang3.builder.*;

import com.japps.learn.util.*;

public final class CoinFlipProbabilityComputer implements Loggable {

    private static final LogUtil log = LogUtil.newInstance(CoinFlipProbabilityComputer.class);
    private static final double HUNDRED_DOUBLE = 100d;

    private CoinFlipProbabilityComputer() {

    }

    public static CoinFlipProbabilityComputer of() {
        return new CoinFlipProbabilityComputer();
    }

    public CoinFlipProbabilityComputer disableLogs() {
        log.disabled(true);
        return this;
    }

    public enum CoinFace {
        HEAD(0, 'H', "Heads"),
        TAIL(1, 'T', "Tails");

        private final int bit;
        private final char notation;
        private final String name;

        CoinFace(int bit, char notation, String name) {
            this.bit = bit;
            this.notation = notation;
            this.name = name;
        }

        public int getBit() {
            return bit;
        }

        public char getNotation() {
            return notation;
        }

        public String getName() {
            return name;
        }

        public static CoinFace fromBit(int bit) {
			return switch (bit) {
				case 0 -> HEAD;
				case 1 -> TAIL;
				default -> null;
			};
        }

        public static boolean isHead(CoinFace coinFace) {
            return HEAD.equals(coinFace);
        }

        public boolean isHead() {
            return HEAD.equals(this);
        }

        @Override
        public String toString() {
            return getName();
        }
    }

    public CoinFlipProbability compute(long flipCount, long trialCount) {
        log.println("================================== COIN FLIP PROBABILITY ==================================");
        log.println("flipCount: " + flipCount);
        log.println("trialCount: " + trialCount);
        CoinFlipProbability coinFlipProbability = CoinFlipProbability.of();
        for (long tc = 1; tc <= trialCount; tc++) {
            log.println("Trial: " + tc);
            long headCount = 0;
            long tailCount = 0;
            for (long fc = 1; fc <= flipCount; fc++) {
                CoinFace coinFace = CoinFace.fromBit(RandomUtils.nextInt(0, 2));
                log.println("Flip: " + fc + ", Result: " + coinFace);
                if (CoinFace.isHead(coinFace)) {
                    headCount++;
                } else {
                    tailCount++;
                }
            }
            log.println("Trial: (" + tc + ") - Heads: (" + headCount + ") - Tails: (" + tailCount + ").");
            double headsProbabilityPercentage = ((double) headCount / flipCount) * HUNDRED_DOUBLE;
            double tailsProbabilityPercentage = ((double) tailCount / flipCount) * HUNDRED_DOUBLE;
            log.println("Trial: (" + tc + ") - Heads: (" + headsProbabilityPercentage + ") - Tails: (" + tailsProbabilityPercentage + ").");
            Map<CoinFace, Double> trialProbability = new HashMap<>(2);
            trialProbability.put(CoinFace.HEAD, headsProbabilityPercentage);
            trialProbability.put(CoinFace.TAIL, tailsProbabilityPercentage);
            coinFlipProbability.put(tc, trialProbability);
        }
        log.println("Coin flip probabilities per trial: " + coinFlipProbability);
        log.println("Average coin flip probability: " + coinFlipProbability.average());
        return coinFlipProbability;
    }

    public static class CoinFlipProbability {

        private CoinFlipProbability(){}

        private final Map<Long, Map<CoinFace, Double>> trialProbabilities = new HashMap<>();

        public static CoinFlipProbability of() {
            return new CoinFlipProbability();
        }

        public static CoinFlipProbability of(Map<Long, Map<CoinFace, Double>> trialProbabilities) {
            CoinFlipProbability instance = of();
            instance.trialProbabilities.putAll(trialProbabilities);
            return instance;
        }

        public void put(long trialNumber, Map<CoinFace, Double> trialProbability) {
            trialProbabilities.put(trialNumber, trialProbability);
        }

        public Map<CoinFace, Double> average() {
            Map<CoinFace, Double> average = new HashMap<>(2);
            average.put(CoinFace.HEAD, trialProbabilities.values().stream().mapToDouble(trialProbability -> trialProbability.get(CoinFace.HEAD)).average().orElse(0d));
            average.put(CoinFace.TAIL, trialProbabilities.values().stream().mapToDouble(trialProbability -> trialProbability.get(CoinFace.TAIL)).average().orElse(0d));
            return average;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("trialProbabilities", trialProbabilities)
                    .append("average probability", average())
                    .toString();
        }
    }
}
