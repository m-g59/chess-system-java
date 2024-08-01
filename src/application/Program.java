package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLUE = "\u001B[34m";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		UI.printTitle();

		while (true) {
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			
			System.out.print(ANSI_BLUE + "Source: " + ANSI_RESET);
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.print(ANSI_BLUE + "Target: " + ANSI_RESET);
			ChessPosition target = UI.readChessPosition(sc);
			System.out.println();

			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
		}
	}
}
