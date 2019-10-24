package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import bordgame.Board;
import bordgame.Position;
import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Chessmatch;

public class Program {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Chessmatch chessmatch = new Chessmatch();
		while(true) {
			try {
				
				
				UI.clearScreen();
				UI.printBoard(chessmatch.getpieces());//recebe matriz de peças da partida
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source= UI.readChessPosition(sc);
				
				System.out.println();
				System.out.print("Target:");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece= chessmatch.performChessMove(source, target);
		}catch(ChessException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
			
		}
		 

	}

}
