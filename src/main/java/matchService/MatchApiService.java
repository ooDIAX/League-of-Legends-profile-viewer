package matchService;

import main.match.Match;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import riotapi.APIinfo;

import java.util.List;

public interface MatchApiService {

    @GET("{gameId}" +
            "?api_key=" +
            APIinfo.privateKey)
    Call<Match> getMatch(@Path("gameId") String gameId);
//    @Path("region") String region , @Path("gameId") String gameId
}
