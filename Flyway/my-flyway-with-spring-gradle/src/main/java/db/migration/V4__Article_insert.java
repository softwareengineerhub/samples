package db.migration;

import java.sql.PreparedStatement;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V4__Article_insert extends BaseJavaMigration {

  @Override
  public void migrate(Context context) throws Exception {
    System.out.println("---------V4__Article_insert----------");
    try(PreparedStatement ps = context.getConnection().prepareStatement("insert into article(title, description) VALUES(?,?);")){
      ps.setObject(1, "JavaTitle2");
      ps.setObject(2, "JavaDescription2");
      ps.execute();
    }
  }
}
