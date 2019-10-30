package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.ChessMatch;;

public class Program {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ChessMatch chessmatch = new ChessMatch();
		//lista de peças
		List<ChessPiece> captured =new ArrayList<>();
		while(!chessmatch.getCheckMate()) {
			try {
				
				
				UI.clearScreen();
				UI.printMatch(chessmatch,captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source= UI.readChessPosition(sc);
				
				//depois q declara a posição de origem aparece pra onde pode ir colorido
				boolean[][]possibleMoves=chessmatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessmatch.getPieces(),possibleMoves);
				
				System.out.println();
				System.out.print("Target:");
				ChessPosition target = UI.readChessPosition(sc);
				
				//executa movimenti de xadrez e retornar possivel peça capturada
				ChessPiece capturedPiece= chessmatch.performChessMove(source, target);
				//se  a peça q for capturada for diferente de nulo, alguma peça foi capturada
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
		}catch(ChessException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
			
		}UI.clearScreen();
		UI.printMatch(chessmatch, captured);
		 

	}

}
