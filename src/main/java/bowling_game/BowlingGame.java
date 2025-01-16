package bowling_game;

public class BowlingGame {
    private static final int MAX_ROLLS = 21;
    private final int[] rolls = new int[MAX_ROLLS];
    private int currentRolls = 0;

    public static void main(String[] args) {
        BowlingGame game = new BowlingGame();

        // 올바른 10개의 프레임 데이터
        game.roll(10); // 1번째 프레임: 스트라이크
        game.roll(7);
        game.roll(3);  // 2번째 프레임: 스페어
        game.roll(9);
        game.roll(0);  // 3번째 프레임: 일반 프레임
        game.roll(10); // 4번째 프레임: 스트라이크
        game.roll(10); // 5번째 프레임: 스트라이크
        game.roll(10); // 6번째 프레임: 스트라이크
        game.roll(2);
        game.roll(3);  // 7번째 프레임: 일반 프레임
        game.roll(6);
        game.roll(4);  // 8번째 프레임: 스페어
        game.roll(7);
        game.roll(2);  // 9번째 프레임: 일반 프레임
        game.roll(10); // 10번째 프레임: 스트라이크
        game.roll(10); // 추가 롤
        game.roll(10); // 추가 롤

        System.out.println("Total Score: " + game.scoreBoard());
    }


    public void roll(int pins) {
        rolls[currentRolls++] = pins;
    }


    public int scoreBoard() {
        int score = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) {
                score += 10 + strikeBonus(rollIndex);
                rollIndex++;
            } else if (isSpare(rollIndex)) {
                score += 10 + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                score += NormalRoll(rollIndex);
                rollIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private int NormalRoll(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }
}