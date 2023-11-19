package leetcode.simple;

import java.util.Arrays;

public class LCP_40
{
	public int maxmiumScore(int[] cards, int cnt)
	{
		Arrays.sort(cards);

		int count = 0;

		int maxLength = cards.length - cnt;
		int maxEvenNum = 0;
		int maxOddNum = 0;

		for (int i = cards.length - 1; i >= maxLength - cnt; i--)
		{
			int card = cards[i];
			if (card % 2 == 1 && maxEvenNum == 0)
			{
				maxEvenNum = card;
			}
			else if (card % 2 == 0 && maxOddNum == 0)
			{
				maxEvenNum = card;
			}
		}




		return count;
	}

	public static void main(String[] args)
	{
		LCP_40 a = new LCP_40();
		int[] cards = new int[]{1, 2, 8, 9};

		System.out.println(a.maxmiumScore(cards, 3));
	}
}
