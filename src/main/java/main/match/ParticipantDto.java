package main.match;

import lombok.Getter;

@Getter
public class ParticipantDto {
    String championName;
    int kills;
    int assists;
    int deaths;
    int summonerLevel;
    String summonerName;
    int teamId;
    boolean win;
}
