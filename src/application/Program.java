package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLUE = "\u001B[34m";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		

		while (true) {
			try {
		
			UI.clearScreen();
			UI.printTitle();
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
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
