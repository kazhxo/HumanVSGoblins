import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testInitialize() {
        GameWorld game = new GameWorld(5, 5);
        game.initialize();

        // Assert that all cells in the grid are initialized to land
        for (int i = 0; i < game.getHeight(); i++) {
            for (int j = 0; j < game.getWidth(); j++) {
                assertEquals(".", game.getGrid()[i][j]);
            }
        }
    }

    @Test
    public void testAddGoblins() {
        GameWorld game = new GameWorld(5, 5);
        game.initialize();
        game.addGoblins();

        // Assert that the specified number of goblins are added to the grid
        int goblinCount = 0;
        for (int i = 0; i < game.getHeight(); i++) {
            for (int j = 0; j < game.getWidth(); j++) {
                if (game.getGrid()[i][j].equals("G")) {
                    goblinCount++;
                }
            }
        }
        assertEquals(game.getNumOfGoblins(), goblinCount);
    }

    @Test
    public void testCenterHuman() {
        GameWorld game = new GameWorld(5, 5);
        game.initialize();
        game.centerHuman();

        // Assert that the human is centered in the grid
        assertEquals("H", game.getGrid()[game.getHumanHeight()][game.getHumanWidth()]);
    }

}