import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void winnerAlexei() {
        Game game = new Game();

        Player Alexei = new Player(1_165, "Алексей", 999);
        Player Michael = new Player(899, "Михаил", 9);

        game.register(Alexei);
        game.register(Michael);

        int expected = 1;
        int actual = game.round("Алексей", "Михаил");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void winnerMichael() {
        Game game = new Game();

        Player Alexei = new Player(1_165, "Алексей", 999);
        Player Michael = new Player(899, "Михаил", 9_999);

        game.register(Alexei);
        game.register(Michael);

        int expected = 2;
        int actual = game.round("Алексей", "Михаил");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playedInADraw() {
        Game game = new Game();

        Player Alexei = new Player(1_165, "Алексей", 1);
        Player Michael = new Player(899, "Михаил", 1);

        game.register(Alexei);
        game.register(Michael);

        int expected = 0;
        int actual = game.round("Алексей", "Михаил");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void passingTheTestNotRegisteredExceptionPlayer2() {
        Game game = new Game();

        Player Alexei = new Player(1_165, "Алексей", 1);
        Player Michael = new Player(899, "Михаил", 1);

        game.register(Alexei);
        game.register(Michael);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Алексей", "Алёна");
        });
    }

    @Test
    public void passingTheTestNotRegisteredExceptionPlayer1() {
        Game game = new Game();

        Player Alexei = new Player(1_165, "Алексей", 1);
        Player Michael = new Player(899, "Михаил", 1);

        game.register(Alexei);
        game.register(Michael);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Алёна", "Алексей");
        });
    }

    @Test
    public void passingTheTestNotRegisteredExceptionAllPlayer() {
        Game game = new Game();

        Player Alexei = new Player(1_165, "Алексей", 1);
        Player Michael = new Player(899, "Михаил", 1);

        game.register(Alexei);
        game.register(Michael);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Алёна", "Константин");
        });
    }
}
