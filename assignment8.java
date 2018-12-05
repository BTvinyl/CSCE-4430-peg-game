//compile with: javac assignment8.java
//run with: java assignment8
import java.util.ArrayList;

public class assignment8 
{

	private static ArrayList<Move> moves = new ArrayList<Move>();

	// class that represents a move
	public static class Move 
	{
		public int from;
		public int over;
		public int to;

		public Move(int f, int o, int t)
		{
			from = f;
			over = o;
			to = t;
		}
	}

	// class that represents a board
	public static class Board
	{
		public int occupiedCells;
		public int[] cells;

		public Board(int ocs, int[] cs)
		{			
			occupiedCells = ocs;
			cells = cs;
		}
	}

    public static void main(String[] args) 
    {
    	// move forward and backwards 
     	moves.add(new Move(0,1,2));
	  	moves.add(new Move(0,2,5));
		moves.add(new Move(1,3,6));
		moves.add(new Move(1,4,8));
		moves.add(new Move(2,4,7));
		moves.add(new Move(2,5,9));
		moves.add(new Move(3,6,10));
		moves.add(new Move(3,7,12));
		moves.add(new Move(4,7,11));
		moves.add(new Move(4,8,13));
		moves.add(new Move(5,8,12));
		moves.add(new Move(5,9,14));
		moves.add(new Move(3,4,5));
		moves.add(new Move(6,7,8));
		moves.add(new Move(7,8,9));
		moves.add(new Move(10,11,12));
		moves.add(new Move(11,12,13));
		moves.add(new Move(12,13,14));
     	moves.add(new Move(2,1,0));
	  	moves.add(new Move(5,2,0));
		moves.add(new Move(6,3,1));
		moves.add(new Move(8,4,1));
		moves.add(new Move(7,4,2));
		moves.add(new Move(9,5,2));
		moves.add(new Move(10,6,3));
		moves.add(new Move(12,7,3));
		moves.add(new Move(11,7,4));
		moves.add(new Move(13,8,4));
		moves.add(new Move(12,8,5));
		moves.add(new Move(14,9,5));
		moves.add(new Move(5,4,3));
		moves.add(new Move(8,7,6));
		moves.add(new Move(9,8,7));
		moves.add(new Move(12,11,10));
		moves.add(new Move(13,12,11));
		moves.add(new Move(14,13,12));

		// initialize board to 0
		Board myBoard = Init(0);

		for (int i = 0; i < 15; i++)
		{
			// if we're at least at the second iteration, create a new board for the next starting location
			if (i > 0)
			{
				myBoard = Init(i);
			}			

			// print initial layout
			System.out.println("=== " + i + " ===");
			System.out.println("    " + myBoard.cells[0] + "    ");
			System.out.println("   " + myBoard.cells[1] + " " + myBoard.cells[2] + "   ");
			System.out.println("  " + myBoard.cells[3] + " " + myBoard.cells[4] + " " + myBoard.cells[5] + "  ");
			System.out.println(" " + myBoard.cells[6] + " " + myBoard.cells[7] + " " + myBoard.cells[8] + " " + myBoard.cells[9] + " ");
			System.out.println(myBoard.cells[10] + " " + myBoard.cells[11] + " " + myBoard.cells[12] + " " + myBoard.cells[13] + " " + myBoard.cells[14]);

			// do this 100 times because I wasn't clever enough to figure out how to actually solve it legitimately
			for (int j = 0; j < 100; j++)
			{
				// run for each move
				for (int k = 0; k < moves.size(); k++)
				{			       
					myBoard = PerformMove(myBoard, moves.get(k));      
				}
			}

			// print end results
			System.out.println("    " + myBoard.cells[0] + "    ");
			System.out.println("   " + myBoard.cells[1] + " " + myBoard.cells[2] + "   ");
			System.out.println("  " + myBoard.cells[3] + " " + myBoard.cells[4] + " " + myBoard.cells[5] + "  ");
			System.out.println(" " + myBoard.cells[6] + " " + myBoard.cells[7] + " " + myBoard.cells[8] + " " + myBoard.cells[9] + " ");
			System.out.println(myBoard.cells[10] + " " + myBoard.cells[11] + " " + myBoard.cells[12] + " " + myBoard.cells[13] + " " + myBoard.cells[14]);
		}
	}

    public static Board Init(int i)
    {
    	// initialize to all 1's, then set i to 0
    	int[] cells = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    	cells[i] = 0;
    	return new Board(14, cells);
    }

    public static Board PerformMove(Board board, Move move)
    {
    	// if we have one occupied cell, we're done
    	if (board.occupiedCells == 1)
    	{
    		return board;
    	}

    	// if we can make a jump, make it and print it
    	if (board.cells[move.from] == 1 && board.cells[move.over] == 1 && board.cells[move.to] == 0)
    	{    	
    		board.cells[move.from] = 0;
    		board.cells[move.over] = 0;
    		board.cells[move.to] = 1;    	

			System.out.println("    " + board.cells[0] + "    ");
			System.out.println("   " + board.cells[1] + " " + board.cells[2] + "   ");
			System.out.println("  " + board.cells[3] + " " + board.cells[4] + " " + board.cells[5] + "  ");
			System.out.println(" " + board.cells[6] + " " + board.cells[7] + " " + board.cells[8] + " " + board.cells[9] + " ");
			System.out.println(board.cells[10] + " " + board.cells[11] + " " + board.cells[12] + " " + board.cells[13] + " " + board.cells[14]);
    	}

    	return board;
    }
}
