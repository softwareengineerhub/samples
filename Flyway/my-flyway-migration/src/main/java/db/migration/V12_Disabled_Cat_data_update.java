package db.migration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.CatContent;
import com.model.CatContent2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.UUID;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V12_Disabled_Cat_data_update extends BaseJavaMigration {

  @Override
  public void migrate(Context context) throws Exception {
    try(PreparedStatement ps = context.getConnection().prepareStatement("SELECT * FROM cat")){
      ObjectMapper mapper = new ObjectMapper();
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
        String content = rs.getString( "content" );
        UUID id = UUID.fromString(rs.getString("id"));
        System.out.println("######content="+content);
        CatContent2 catContent2 = mapper.readValue(content, CatContent2.class);
        catContent2.setPhoneNumber("UPDATE");
        System.out.println("######catContent2="+catContent2);
        try(PreparedStatement updateStatement = context.getConnection().prepareStatement("UPDATE cat SET content = (to_json(?::json)) WHERE id= ?")){
          String content2 = mapper.writeValueAsString(catContent2);
          updateStatement.setObject(1, content2);
          updateStatement.setObject(2, id);
          updateStatement.executeUpdate();
        }
      }
    }
  }

  private CatContent generate(int index){
    CatContent catContent = new CatContent();
    catContent.setType(index);
    catContent.setPhoneNumber("Number"+index);
    catContent.setDescriptions(Arrays.asList(index+"DescriptionA", index+"DescriptionB", index+"DescriptionC"));
    return catContent;
  }
}
