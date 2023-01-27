package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.PreparedStatement;

public class V3__Insert_article_data extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        System.out.println("-------V3__Insert_article_data------");
        String sql = "insert into article(title, description) VALUES(?,?)";
        try (PreparedStatement select = context.getConnection().prepareStatement(sql)) {
            select.setObject(1, "JavaName4");
            select.setObject(2, "JavaDesc5");
            select.execute();
        }
    }
}
