import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan= new Scanner(System.in);
       GameWorld game= new GameWorld(10,10);
       game.displayGrid();


       while(true){
           System.out.println("Enter direction: l,r,u,d");
           char direction= scan.next().charAt(0);

           game.moveHuman(direction);

           game.displayGrid();
       }
    }
}