package org.example;

import controller.RitoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.match.Match;
import main.match.Info;
import main.match.ParticipantDto;
import riotapi.APIinfo;
import riotapi.Resources;
import riotapi.Summoner;

import matchService.MatchService;
import matchService.MatchApiService;

import static riotapi.Summoner.getSummoner;

import java.util.List;

public class Main extends Application{

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Resources.getUI("rito.fxml"));
        loader.setController(new RitoController());
        Pane pane = loader.load();

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Rito");
        stage.show();
    }

    @Override
    public void stop() throws Exception{
        super.stop();
    }

    public static void main(String[] args) throws Exception {
/*
//        APIinfo APIinfo = new APIinfo("RGAPI-4ca9849d-b80c-4380-a02b-205bb3920337");
//        String privateKey = APIinfo.getPrivateKey();

        Summoner mate = getSummoner("sweatygenji", "EUN1");
        List<String> matches = mate.getMatches(10);

        System.out.println(mate.getName() + "  -  " + mate.getId());

        String mm = "";
        for(String el : matches){
            System.out.println(el);
            mm = el;
        }

        MatchService matchService = new MatchService("europe");
        Match match = matchService.getMatch( mm);


        System.out.println(match.getInfo().getGameDuration());
        List<ParticipantDto> lobby = match.getInfo().getParticipants();
        for(ParticipantDto player : lobby){
//            String championName;
//            int kills;
//            String summonerName;
//            int teamId;
//            boolean win;
            if(player.isWin()){
                System.out.print("Winner - ");
            }else{
                System.out.print("Loser - ");
            }
            System.out.println(player.getSummonerName() + " lvl" + player.getSummonerLevel() + " " + player.getChampionName() + "  " + player.getKills() + "/" + player.getDeaths() + "/" + player.getAssists());

        }
//        System.out.println(match.getInfo().getGameDuration());
 */
        launch();
    }


}