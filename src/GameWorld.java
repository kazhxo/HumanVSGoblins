import java.util.Random;

public class GameWorld {
    private String[][] grid;
    private int width;
    private int height;

    private Goblins goblins;
    private Random random;

    private Land land;

    private Humans humans;
    private int numOfGoblins;
    private int numOfHumans;

    private int humanHeight;
    private int humanWidth;

    private final char treasureChest= 'C';
    private final String gold= "Gold";
    private final String potion="Potion";
    public GameWorld(int width, int height) {
        this.width=width;
        this.height=height;
        this.humanHeight=height/2;
        this.humanWidth=width/2;
        grid = new String[width][height];
        numOfGoblins = 4;
        numOfHumans=1;
        land= new Land();
        goblins= new Goblins();
        humans= new Humans();

        initialize();
        addGoblins();
        centerHuman();

    }

    public void initialize() {

        for(int i=0; i<width;i++){
            for(int j=0; j<height; j++){
                grid[i][j]= land.toString();
            }
        }
    }

    public void addGoblins(){

        Random rand= new Random();
        for(int i=0; i<numOfGoblins; i++) {

             int randomHeight= rand.nextInt(height);
             int randomWidth= rand.nextInt(width);

             grid[randomHeight][randomWidth] = String.valueOf(goblins.toString().charAt(0));

        }
    }

    public void centerHuman(){
        grid[humanHeight][humanWidth]= String.valueOf(humans.toString().charAt(0));
    }

    public void moveHuman(char direction) {
        int currentHeight = humanHeight;
        int currentWidth = humanWidth;


        switch (direction) {
            case 'l':
                currentWidth--;
                break;
            case 'r':
                currentWidth++;
                break;
            case 'u':
                currentHeight--;
                break;
            case 'd':
                currentHeight++;
                break;
            default:
                System.out.println("Invalid Direction Entered");
                return;
        }

        if (currentHeight >= 0 && currentHeight < height && currentWidth >= 0 && currentWidth < width) {

            if (grid[currentHeight][currentWidth].equals(String.valueOf(goblins.toString().charAt(0)))) {
                int humanAttackPoints = new Random().nextInt(11);
                int goblinAttackPoints = new Random().nextInt(11);

                if (humanAttackPoints > goblinAttackPoints) {
                    System.out.println("You win");
                    grid[currentHeight][currentWidth] = String.valueOf(humans.toString().charAt(0));

                    drop(currentHeight,currentWidth);
                    addChest();

                } else if (humanAttackPoints < goblinAttackPoints) {
                    System.out.println("Goblin wins");
                    grid[currentHeight][currentWidth] = String.valueOf(goblins.toString().charAt(0));

                    addChest();

                } else {
                    System.out.println("Its a tie");
                }
            } else {
                grid[humanHeight][humanWidth] = String.valueOf(land.toString().charAt(0));
                humanHeight = currentHeight;
                humanWidth = currentWidth;
                grid[humanHeight][humanWidth] = String.valueOf(humans.toString().charAt(0));
            }
        }}




public void addChest(){
        Random rand= new Random();
        int chestHeight= rand.nextInt(height);
        int chestWidth= rand.nextInt(width);

        if(!grid[chestHeight][chestWidth].equals(String.valueOf(goblins.toString().charAt(0))) &&
                !grid[chestHeight][chestWidth].equals((String.valueOf(humans.toString().charAt(0))))) {
            grid[chestHeight][chestWidth] = String.valueOf(treasureChest);
        }
        else{
            addChest();

        }
}

    private void drop(int goblinHeight, int goblinWidth) {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            String dropped = rand.nextBoolean() ? gold : potion;

            if (dropped.equals(gold)) {
                System.out.println("Goblin dropped: " + gold);
                if (!grid[goblinHeight][goblinWidth].equals(String.valueOf(treasureChest))) {
                    grid[goblinHeight][goblinWidth] = gold;
                }
            } else if (dropped.equals(potion)) {
                System.out.println("Goblin dropped: " + potion);
                if (!grid[goblinHeight][goblinWidth].equals(String.valueOf(treasureChest))) {
                    grid[goblinHeight][goblinWidth] = potion;
                }
            }
        }
    }

    public void displayGrid(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public String[][] getGrid() {
        return grid;
    }

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Goblins getGoblins() {
        return goblins;
    }

    public void setGoblins(Goblins goblins) {
        this.goblins = goblins;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public Humans getHumans() {
        return humans;
    }

    public void setHumans(Humans humans) {
        this.humans = humans;
    }

    public int getNumOfGoblins() {
        return numOfGoblins;
    }

    public void setNumOfGoblins(int numOfGoblins) {
        this.numOfGoblins = numOfGoblins;
    }

    public int getNumOfHumans() {
        return numOfHumans;
    }

    public void setNumOfHumans(int numOfHumans) {
        this.numOfHumans = numOfHumans;
    }

    public int getHumanHeight() {
        return humanHeight;
    }

    public void setHumanHeight(int humanHeight) {
        this.humanHeight = humanHeight;
    }

    public int getHumanWidth() {
        return humanWidth;
    }

    public void setHumanWidth(int humanWidth) {
        this.humanWidth = humanWidth;
    }

    public char getTreasureChest() {
        return treasureChest;
    }

    public String getGold() {
        return gold;
    }

    public String getPotion() {
        return potion;
    }
}