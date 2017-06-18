/**
 * 
 * 322. Coin Change
 * 
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2: coins = [2], amount = 3 return -1.
 * 
 * Note: You may assume that you have an infinite number of each kind of coin.
 * 
 * @author abhigupta
 *
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {

		if (amount < 0 || coins == null || coins.length == 0) {

			return -1;
		}

		if (amount == 0) {
			return 0;
		}

		int a[] = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			a[i] = Integer.MAX_VALUE;
			for (int c = 0; c < coins.length; c++) {

				if (i - coins[c] >= 0 && a[i - coins[c]] != Integer.MAX_VALUE) { // imp
					a[i] = Math.min(a[i], a[i - coins[c]] + 1);
				}
			}
		}
		if (a[amount] == Integer.MAX_VALUE) {
			return -1;
		}

		return a[amount];

	}

}
