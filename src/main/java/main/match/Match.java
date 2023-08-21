package main.match;

import lombok.Getter;
import riotapi.APIinfo;

import java.util.List;

@Getter
public class Match {

    private Info info;

     public Match(String region, String matchid){
//         https://europe.api.riotgames.com/lol/match/v5/matches/EUN1_3328162074?api_key=RGAPI-4ca9849d-b80c-4380-a02b-205bb3920337

         String strUrl = "https://" + region + ".api.riotgames.com/lol/match/v5/matches/" + matchid + "?api_key=" + APIinfo.privateKey;


     }
}
