package challenges.java.datastructures;

import java.util.Comparator;

import challenges.java.datastructures.Player;

	class Checker implements Comparator<Player> {

		@Override
		public int compare(Player player1, Player player2) {
			int resultComparation = player1.score < player2.score ? 1 : -1;
			if (player1.score == player2.score) {
				resultComparation = player1.name.compareTo(player2.name);
			}
			return resultComparation;
		}

	}

