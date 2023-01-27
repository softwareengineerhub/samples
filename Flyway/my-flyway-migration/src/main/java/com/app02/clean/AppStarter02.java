package com.app02.clean;

import com.helper.Helper;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.CleanResult;

public class AppStarter02 {

  public static void main(String[] args) {
    Flyway flyway = Flyway.configure()
        .dataSource("jdbc:postgresql://127.0.0.1:5439/mydb", "user", "11111111").load();

    CleanResult cleanResult = flyway.clean();
    Helper.printCleanResult(cleanResult);
  }

}
