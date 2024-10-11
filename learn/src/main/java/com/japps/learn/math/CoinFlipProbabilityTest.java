package com.japps.learn.math;

import com.japps.learn.util.*;

public final class CoinFlipProbabilityTest {

	public static void main(String[] args) {
		CoinFlipProbabilityComputer coinFlipProbabilityComputer = CoinFlipProbabilityComputer.of().disableLogs();

		CoinFlipProbabilityComputer.CoinFlipProbability coinFlipProbability = coinFlipProbabilityComputer.compute(100, 10);
		LogUtil.printLn("CoinFlipProbability: " + coinFlipProbability.average());

		coinFlipProbability = coinFlipProbabilityComputer.compute(100, 10);
		LogUtil.printLn("CoinFlipProbability: " + coinFlipProbability.average());

		coinFlipProbability = coinFlipProbabilityComputer.compute(1000, 20);
		LogUtil.printLn("CoinFlipProbability: " + coinFlipProbability.average());

		coinFlipProbability = coinFlipProbabilityComputer.compute(5000, 30);
		LogUtil.printLn("CoinFlipProbability: " + coinFlipProbability.average());

		coinFlipProbability = coinFlipProbabilityComputer.compute(10000, 40);
		LogUtil.printLn("CoinFlipProbability: " + coinFlipProbability.average());

		coinFlipProbability = coinFlipProbabilityComputer.compute(100000, 100);
		LogUtil.printLn("CoinFlipProbability: " + coinFlipProbability.average());

		coinFlipProbability = coinFlipProbabilityComputer.compute(100000, 1000);
		LogUtil.printLn("CoinFlipProbability: " + coinFlipProbability.average());
	}
}
