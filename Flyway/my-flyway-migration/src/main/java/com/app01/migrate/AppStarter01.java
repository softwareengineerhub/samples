package com.app01.migrate;

import com.helper.Helper;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;

public class AppStarter01 {

  public static void main(String[] args) {
    Flyway flyway = Flyway.configure()
        .dataSource("jdbc:postgresql://127.0.0.1:5439/mydb", "user", "11111111").load();

    MigrateResult migrateResult = flyway.migrate();
    Helper.printMigrateResult(migrateResult);
  }

}
