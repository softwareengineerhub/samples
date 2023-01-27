package com.app03.validate;

import com.helper.Helper;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.ValidateResult;

public class AppStarter03 {

  public static void main(String[] args) {
    Flyway flyway = Flyway.configure()
        .dataSource("jdbc:postgresql://127.0.0.1:5439/mydb", "user", "11111111").load();

    //flyway.validate();
    ValidateResult validateResult = flyway.validateWithResult();
    Helper.printValidateResult(validateResult);
  }

}
