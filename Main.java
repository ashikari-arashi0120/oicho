
import java.util.Scanner;

import game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scan = new Scanner(System.in);
        game.play(scan);
        scan.close();
    }
}