package db.migration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.CatContent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V11__Cat_data_create extends BaseJavaMigration {

  @Override
  public void migrate(Context context) throws Exception {
    try(PreparedStatement ps = context.getConnection().prepareStatement("INSERT INTO cat (id, name, content) VALUES(?,?,(to_json(?::json)))")){
      ObjectMapper mapper = new ObjectMapper();
      for(int i=0;i<4;i++){
        ps.setObject(1, UUID.randomUUID());
        ps.setObject(2, "Name"+(i+1));
        CatContent catContent = generate(i);
        String content = mapper.writeValueAsString(catContent);
        ps.setObject(3, content);
        ps.execute();
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
