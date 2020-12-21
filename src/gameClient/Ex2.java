package gameClient;

import Server.Game_Server_Ex2;
import api.game_service;

public class Ex2 {
    public static void main(String[] args) {
        int levelNumber = 1;
        game_service game = Game_Server_Ex2.getServer(levelNumber);
        game.getGraph();
        System.out.print("End");
    }

}
