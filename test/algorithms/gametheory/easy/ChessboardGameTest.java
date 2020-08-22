package algorithms.gametheory.easy;

import org.junit.Assert;
import org.junit.Test;

public class ChessboardGameTest {

    @Test
    public void test01() {
        Assert.assertEquals(ChessboardGame.SECOND, ChessboardGame.chessboardGame(5, 2));
    }

    @Test
    public void test02() {
        Assert.assertEquals(ChessboardGame.FIRST, ChessboardGame.chessboardGame(5, 3));
    }

    @Test
    public void test03() {
        Assert.assertEquals(ChessboardGame.FIRST, ChessboardGame.chessboardGame(5, 8));
    }
}