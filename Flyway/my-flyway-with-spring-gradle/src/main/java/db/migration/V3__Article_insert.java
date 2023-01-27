package db.migration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V3__Article_insert extends BaseJavaMigration {

  @Override
  public void migrate(Context context) throws Exception {
    System.out.println("---------V3__Article_insert----------");
    try(PreparedStatement ps = context.getConnection().prepareStatement("insert into article(title, description) VALUES(?,?);")){
      ps.setObject(1, "JavaTitle");
      ps.setObject(2, "JavaDescription");
      ps.execute();
    }
  }
}
