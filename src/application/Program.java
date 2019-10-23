package application;

import bordgame.Board;
import bordgame.Position;
import chess.Chessmatch;

public class Program {

	public static void main(String[] args) {
		
		Chessmatch chessmatch = new Chessmatch();
		UI.printBoard(chessmatch.getpieces()); //recebe matriz de peças da partida

	}

}
