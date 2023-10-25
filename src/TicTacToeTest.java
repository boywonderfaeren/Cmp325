import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {

    private TicTacToe ticTacToe;

    @Before
    public void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void testDrawWhenGameIsNotADraw() {
        assertFalse(ticTacToe.draw());
    }

    @Test
    public void testDrawWhenGameIsADraw() {
        ticTacToe.makeMove(0, 0);
        ticTacToe.makeMove(0, 1);
        ticTacToe.makeMove(0, 2);
        ticTacToe.makeMove(1, 1);
        ticTacToe.makeMove(1, 0);
        ticTacToe.makeMove(2, 0);
        ticTacToe.makeMove(1, 2);
        ticTacToe.makeMove(2, 2);
        ticTacToe.makeMove(2, 1);

        assertTrue(ticTacToe.draw());
    }

    @Test
    public void testReset() {
        ticTacToe.makeMove(0, 0);
        ticTacToe.makeMove(0, 1);
        ticTacToe.reset();

        char[][] board = ticTacToe.getBoard();
        assertEquals(' ', board[0][0]);
        assertEquals(' ', board[0][1]);
        assertEquals('X', ticTacToe.getCurrentPlayer());
    }

    @Test
    public void testCheckWinWhenNoWin() {
        assertFalse(ticTacToe.checkWin());
    }

    @Test
    public void testCheckWinForRowWin() {
        ticTacToe.makeMove(0, 0);
        ticTacToe.makeMove(1, 0);
        ticTacToe.makeMove(0, 1);
        ticTacToe.makeMove(1, 1);
        ticTacToe.makeMove(0, 2);

        assertTrue(ticTacToe.checkWin());
    }

    @Test
    public void testCheckWinForColumnWin() {
        ticTacToe.makeMove(0, 0);
        ticTacToe.makeMove(0, 1);
        ticTacToe.makeMove(1, 0);
        ticTacToe.makeMove(1, 1);
        ticTacToe.makeMove(2, 0);

        assertTrue(ticTacToe.checkWin());
    }

    @Test
    public void testCheckWinForDiagonalWin() {
        ticTacToe.makeMove(0, 0);
        ticTacToe.makeMove(0, 1);
        ticTacToe.makeMove(1, 1);
        ticTacToe.makeMove(1, 0);
        ticTacToe.makeMove(2, 2);

        assertTrue(ticTacToe.checkWin());
    }
}
