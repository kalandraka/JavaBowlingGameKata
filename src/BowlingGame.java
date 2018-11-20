public class BowlingGame {

    private int score = 0;
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    private boolean isSpare(int firstBallInFrame) {
        return twoBallsInFrame(firstBallInFrame) == 10;
    }

    private boolean isStrike(int firstBallInFrame) {
        return rolls[firstBallInFrame] == 10;
    }

    private int twoBallsInFrame(int firstBallInFrame) {
        return rolls[firstBallInFrame] + rolls[firstBallInFrame + 1];
    }

    private int nextTwoBallsForStrike(int firstBallInFrame) {
        return rolls[firstBallInFrame + 1] + rolls[firstBallInFrame + 2];
    }

    private int nextBallForSpare(int firstBallInFrame) {
        return rolls[firstBallInFrame + 2];
    }

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int firstBallInFrame = 0;
        for (int currentFrame = 0; currentFrame < 10; currentFrame++) {
            if (isStrike(firstBallInFrame)) {
                score += 10 + nextTwoBallsForStrike(firstBallInFrame);
                firstBallInFrame += 1;
            } else if (isSpare(firstBallInFrame)) {
                score += 10 + nextBallForSpare(firstBallInFrame);
                firstBallInFrame += 2;
            } else {
                score += twoBallsInFrame(firstBallInFrame);
                firstBallInFrame += 2;
            }
        }
        return score;
    }
}