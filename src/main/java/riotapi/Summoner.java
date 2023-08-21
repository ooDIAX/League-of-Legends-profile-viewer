package riotapi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import org.json.JSONArray;

import java.util.List;

@Getter
public class Summoner {

//             "id": "cIovQb869svN5ll24HyLlr0XYktY2cujR9qLbxmrjqV6nEg",
//             "accountId": "r7i0_I0hmQXYoYf1Cu7VzBBhg4j-vgAiG_b5bRYx4z68ump26TnZI9zP",
//             "puuid": "1-UHQlCVGpsXKqACt_-SGzOfFSQmQohNM1zZ6DPu3i2vNmYWIxVomnzNxT-54tnfoGeB9gIokzJnog",
//             "name": "Didi24cm",
//             "profileIconId": 905,
//             "revisionDate": 1678200484191,
//             "summonerLeve
    private final String id;
    private final String accountId;
    private final String puuid;
    private final String name;
    private final int profileIconId;
    private final String revisionDate;
    private final int summonerLevel;
    private String generalRegion;
    private String specificRegion;
    private int totalChampionMastery;

//    public summoner(String privateKey, String name){
//        summoner("!2","12","!@3",name,12,"Asd",123);
//    }
    public Summoner(String id, String accountId, String puuid, String name, int profileIconId, String  revisionDate, int summonerLevel) {
        this.id = id;
        this.accountId = accountId;
        this.puuid = puuid;
        this.name = name;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.summonerLevel = summonerLevel;
    }

    public static Summoner getSummoner(String name, String region){

        String strUrl = "https://" +  region + ".api.riotgames.com/lol/summoner/v4/summoners/by-name/";
        strUrl += name;
        strUrl += "?api_key=" + riotapi.APIinfo.privateKey;

        String info = riotapi.APIinfo.getData(strUrl);
        Gson gson = new Gson();
        Summoner summoner = gson.fromJson(info , Summoner.class);
        summoner.addRegion(region);
        summoner.addTotalChampionMastery();

        //        System.out.println(summoner.getName() + " " + summoner.getSummonerLevel());
        return summoner;
    }

    public List<String> getMatches(int numberOfMatches) throws Exception {
        System.out.println(this.generalRegion);
        String region = this.generalRegion;
        String strUrl = "https://" + this.generalRegion;
//        String strUrl = Region.generealRegion(region);
//        switch (region) {
//            case "europe", "Europe", "EU" -> strUrl = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/";
//            case "Americas", "America", "NA" ->
//                    strUrl = "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/";
//            case "Asia", "ASIA" -> strUrl = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/";
//            case "sea", "SEA" -> strUrl = "https://sea.api.riotgames.com/lol/match/v5/matches/by-puuid/";
//            default -> {
//                throw new Exception("wrong region");
//            }
//        }
        strUrl += ".api.riotgames.com/lol/match/v5/matches/by-puuid/";
        strUrl += this.puuid;
        strUrl += "/ids?count=" + numberOfMatches;
        strUrl += "&api_key=" + riotapi.APIinfo.privateKey;

        String info = APIinfo.getData(strUrl);
        System.out.println(info);

        Gson gson = new Gson();

        List<String> matches = new Gson().fromJson(info , new TypeToken<List<String>>() {}.getType());

        return matches;

    }

    public void addRegion(String region){
        this.specificRegion = region;
        this.generalRegion = Region.specificToGeneral(region);
    }

    public void addTotalChampionMastery(){
        String strUrl = "https://" + this.specificRegion + ".api.riotgames.com/lol/champion-mastery/v4/scores/by-summoner/";
        strUrl += this.id;
        strUrl += "?api_key=" + riotapi.APIinfo.privateKey;

        String info = APIinfo.getData(strUrl);

        this.totalChampionMastery = Integer.parseInt(info);
    }

}
