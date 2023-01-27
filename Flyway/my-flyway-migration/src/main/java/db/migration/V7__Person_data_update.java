package db.migration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V7__Person_data_update extends BaseJavaMigration {

  @Override
  public void migrate(Context context) throws Exception {
    try(PreparedStatement ps = context.getConnection().prepareStatement("SELECT * FROM PERSON")){
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
        String name = rs.getString("name");
        int id = rs.getInt("id");

        try(PreparedStatement ps2 = context.getConnection().prepareStatement("UPDATE person set name=? WHERE id=?")){
          ps2.setObject(1, name+"Updated");
          ps2.setObject(2, id);
          ps2.executeUpdate();
        }

      }
    }
  }
}
