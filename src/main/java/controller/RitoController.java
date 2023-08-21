package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import main.match.ParticipantDto;
import matchService.MatchService;
import riotapi.Summoner;
import riotapi.Region;
import main.match.Match;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static riotapi.Summoner.getSummoner;

public class RitoController implements Initializable {

    public ListView<String> playerList;
    public TextField summonerSearchTextField;
    public Button searchButton;
    public Label statusLabel;
    public Label displayName;
    public ChoiceBox<String> choiceBox;
    private final String[] regions = {"EUN1" , "EUW1" , "RU1" , "TR1" ,
            "BR1", "LA1", "LA2", "NA1",
            "KR", "JP1", "PH2", "SG2", "TW2", "TH2", "VN2",
            "OCE", "OCE1" };

    private int matchNum = 0;
    private List<String> matches;

    private final String[] playerLobby = {"1" , "2" , "3" , "4" ,"5", "6", "7", "8","9", "10" };

    public String reg;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(regions);
    }

    @FXML
    public void searchSummoner(ActionEvent event) throws Exception {

        String searchSummoner = summonerSearchTextField.getText();
        String searchRegion = choiceBox.getValue();
        statusLabel.setText("Looking for " + searchRegion + " " + searchSummoner);
        Summoner summoner = getSummoner(searchSummoner , searchRegion);
        statusLabel.setText("...");

        displayName.setText(summoner.getName() + "    lvl" + summoner.getSummonerLevel());

        matches = summoner.getMatches(10);

//        System.out.println(mate.getName() + "  -  " + mate.getId());

        this.matchNum = 0;
        String matchId = matches.get(0);
        statusLabel.setText("match  number : " + Integer.toString( this.matchNum + 1));
        reg = Region.specificToGeneral(summoner.getSpecificRegion());
        displayMatch(matchId);

    }

    public void nextMatch(ActionEvent event) throws Exception {
//        System.out.println("in");
        this.matchNum ++;
        this.matchNum = this.matchNum%10;
        String matchId = matches.get(matchNum);
        displayMatch(matchId);

        statusLabel.setText("match  number : " + Integer.toString( this.matchNum + 1));

    }

    public void displayMatch(String matchId){
//        System.out.println(reg);

        MatchService matchService = new MatchService(reg);
        Match match = matchService.getMatch(matchId);


        System.out.println(match.getInfo().getGameDuration());
        List<ParticipantDto> lobby = match.getInfo().getParticipants();

        int ind = 0;
        for(ParticipantDto player : lobby){
            String displayStr = "";
            if(player.isWin()){
                displayStr += "Winner - ";
//                System.out.print("Winner - ");
            }else{
                displayStr += "Loser - ";
//                System.out.print("Loser - ");
            }

            displayStr += player.getSummonerName() + " lvl" + player.getSummonerLevel() + " " + player.getChampionName() + "  " + player.getKills() + "/" + player.getDeaths() + "/" + player.getAssists();
            playerLobby[ind] = displayStr;
            ind++;
            System.out.println(displayStr);
        }
        playerList.getItems().clear();
        playerList.getItems().addAll(playerLobby);
    }

}
