import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BowlingGameTest {
    private BowlingGame bowlingGame;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        bowlingGame = new BowlingGame();
    }

    private void rollMany(int pins, int quantityOfRolls) {
        for (int i = 0; i < quantityOfRolls; i++) {
            bowlingGame.roll(pins);
        }
    }

    private void rollSpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }

    private void rollStrike() {
        bowlingGame.roll(10);
    }

    @Test
    void testGutterGame() throws Exception {
        rollMany(0, 20);
        Assertions.assertEquals(0, bowlingGame.score());
    }

    @Test
    void testOnesGame() throws Exception {
        rollMany(1, 20);
        Assertions.assertEquals(20, bowlingGame.score());
    }

    @Test
    void testOneSpareGame() throws Exception {
        rollSpare();
        bowlingGame.roll(3);
        rollMany(0, 17);
        Assertions.assertEquals(16, bowlingGame.score());
    }

    @Test
    void testOneStrikeGame() throws Exception {
        rollStrike();
        bowlingGame.roll(4);
        bowlingGame.roll(3);
        rollMany(0, 16);
        Assertions.assertEquals(24, bowlingGame.score());
    }

    @Test
    void testPerfectGame() throws Exception {
        rollMany(10, 12);
        Assertions.assertEquals(300, bowlingGame.score());
    }
}