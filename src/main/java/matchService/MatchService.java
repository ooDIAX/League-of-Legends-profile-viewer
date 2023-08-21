package matchService;

import main.match.Match;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import riotapi.APIinfo;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class MatchService {
//    CountriesApiService
    private MatchApiService api;

    public MatchService(String region) {
        String baseUrl = "https://" +
                region + //europe
                ".api.riotgames.com/lol/match/v5/matches/" ;


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(MatchApiService.class);
    }

    public Match getMatch(String gameId) {
//        String region, String gameId)
        Call<Match> getMatchCall = api.getMatch(gameId);
        try {
            Response<Match> response = getMatchCall.execute();
            return response.body();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }

}
