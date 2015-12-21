package org.ligson.algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HongBao {

	static Random random = new Random(new Date().getTime());
	/***
	 * 红包金额,要求最多两位小数,最少0.01元
	 */
	public static double totalMoney = 100;
	/***
	 * 总人数,最少1人
	 */
	public static int peopleCount = 100;

	private static int fen(int yue, int count) {
		int kuo = (yue - (count - 1) * 1);
		int max = (int) kuo;
		int r = random.nextInt(max) + 1;
		return r;
	}

	/***
	 * 分红包入口
	 * 
	 * @return 最多金额出现的位置
	 */
	public static int fahongbao() {
		List<Double> moneyList = new ArrayList<>();
		int sum = 0;
		int total = (int) (totalMoney * 100);
		System.out.println("总金额:" + totalMoney);
		for (int i = peopleCount; i > 0; i--) {
			int money = fen(total, i);
			sum += money;
			total -= money;
			BigDecimal bigDecimal = new BigDecimal(money);
			BigDecimal bigDecimal2 = new BigDecimal(100);
			BigDecimal result = bigDecimal.divide(bigDecimal2);
			System.out.println("第" + (peopleCount - i + 1) + "个人分:" + result.doubleValue() + "元");
			moneyList.add(result.doubleValue());
		}

		BigDecimal bigDecimal = new BigDecimal(sum);
		BigDecimal bigDecimal2 = new BigDecimal(100);
		BigDecimal result = bigDecimal.divide(bigDecimal2);
		// System.out.println("总金额是否相等:" + (result.doubleValue() ==
		// totalMoney));

		int maxIndex = 0;
		double maxMoney = 0;
		for (int i = 0; i < moneyList.size(); i++) {
			double tmp = moneyList.get(i);
			if (tmp > maxMoney) {
				maxMoney = tmp;
				maxIndex = i;
			}
		}
		System.out.println("本轮第" + (maxIndex + 1) + "个人获得最多金额:" + maxMoney + "元");

		return maxIndex + 1;
	}

	public static void main(String[] args) {
		List<Integer> idxList = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			System.out.println("第" + (i + 1) + "轮红包开始");
			int idex = fahongbao();
			idxList.add(idex);
			System.out.println("第" + (i + 1) + "轮红包结束");
		}

		// 统计最多红包出现的位置几率
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer integer : idxList) {
			Integer value = map.get(integer);
			if (value != null) {
				map.put(integer, value + 1);
			} else {
				map.put(integer, 1);
			}
		}

		for (Integer key : map.keySet()) {
			System.out.println("第" + key + "个人抢到最多红包的几率是:" + map.get(key) * 100.00 / idxList.size() + "%");
		}

	}
}
