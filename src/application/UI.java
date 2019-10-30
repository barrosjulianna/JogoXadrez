package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.ChessMatch;
import chess.Collor;

public class UI {
	//cores pra imprimir no console
	//cores texto
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	//cores fundo
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	//LIMPAR A TELA
	public static void clearScreen() {
		 System.out.print("\033[H\033[2J");
		 System.out.flush();
		} 
	
	//ler posi��o do usuario
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);
		}
		catch (RuntimeException e) {
			throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
		}
	}
	
	//imprimir partida
	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turn : " + chessMatch.getTurn());
		//antes de mostrar pro proximo jogador jogar
		if(!chessMatch.getCheckMate()) {
			System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
		if (chessMatch.getCheck()) {
			System.out.println("CHECK!");
		}}
		else {
			System.out.println("CHECKMATE!!");
			System.out.println("Vencedor: "+ chessMatch.getCurrentPlayer());
		}
	}
	
	
//imprimir tabuleiro
	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j],false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	//imprimir tabuleiro com as posi��es possiveis
	public static void printBoard(ChessPiece[][] pieces,boolean[][]possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j],possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	

	// IMPRIMIR UMA PE�A, SE N TIVER PE�A UM -				//variavel pra indicar se deve ou n colorir fundo
	private static void printPiece(ChessPiece piece,boolean background) {
		if(background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
    	if (piece == null) {
            System.out.print("-"+ANSI_RESET);
        }
        else {
            if (piece.getCollor() == Collor.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}
	
	private static void printCapturedPieces(List<ChessPiece> captured) {
		//imprimir pe�as capturadas criado lista
		//filyttando na lista td mundo q a cor � branca
		List<ChessPiece> white =captured.stream().filter(x -> x.getCollor() == Collor.WHITE).collect(Collectors.toList());
		List<ChessPiece> black =captured.stream().filter(x -> x.getCollor() == Collor.BLACK).collect(Collectors.toList());
		System.out.println("Captured pieces:");
		System.out.print("White: ");
		System.out.print(ANSI_WHITE); //COR BRANCA
		System.out.println(Arrays.toString(white.toArray()));
		System.out.println(ANSI_RESET);
		
		System.out.print("Black: ");
		System.out.print(ANSI_YELLOW); //COR BRANCA
		System.out.println(Arrays.toString(black.toArray()));
		System.out.println(ANSI_RESET);
	}
	
	
}
