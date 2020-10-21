package com.example.mariposa;

import java.io.FileReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(TournamentRepostitory repository) {
    return args -> {
      // parseJSON(repository);
      log.info("Test preload " + repository.save(new Tournament(0, "bracket", "stream", "winner")));
    };
  }

  @SuppressWarnings("unchecked")
  // put data from database (local file rn) into repository
  private void parseJSON(TournamentRepostitory repository) {
      //JSON parser object to parse read file
      JSONParser jsonParser = new JSONParser();

      URL path = LoadDatabase.class.getResource("MOCK_DATA.json");

      try (FileReader reader = new FileReader(path.getFile()))
      {
          //Read JSON file
          Object obj = jsonParser.parse(reader);

          JSONArray tournamentList = (JSONArray) obj;

          //Iterate over tournament array
          tournamentList.forEach(tournament -> parseTournament((JSONObject) tournament, repository));

      } catch (Exception e) {
          System.out.println(e);
          e.printStackTrace();
      }
  }

  // helper func to populate the repository
  private void parseTournament(JSONObject tournament, TournamentRepostitory repository) {
      log.info("Preloading ", repository.save(new Tournament((Long) tournament.get("tournamentID"),
                                    (String) tournament.get("bracket"),
                                    (String) tournament.get("stream"),
                                    (String) tournament.get("winner"))));
  }
}