package com.helper;

import java.util.List;
import org.flywaydb.core.api.output.CleanResult;
import org.flywaydb.core.api.output.MigrateOutput;
import org.flywaydb.core.api.output.MigrateResult;
import org.flywaydb.core.api.output.ValidateOutput;
import org.flywaydb.core.api.output.ValidateResult;

public class Helper {

  public static void printValidateResult(ValidateResult validateResult) {
    System.out.println("           printValidateResult          ");
    String database = validateResult.database;
    String flywayVersion = validateResult.flywayVersion;
    String operation = validateResult.operation;
    int validateCount = validateResult.validateCount;
    boolean validationSuccessful = validateResult.validationSuccessful;
    List<String> warnings = validateResult.warnings;

    List<ValidateOutput> invalidMigrations = validateResult.invalidMigrations;
    System.out.println("----------------------------------------");
    System.out.println("database=" + database);
    System.out.println("flywayVersion=" + flywayVersion);
    System.out.println("operation=" + operation);
    System.out.println("validateCount=" + validateCount);
    System.out.println("validationSuccessful=" + validationSuccessful);
    System.out.println("warnings.size=" + warnings.size());
    for (String item : warnings) {
      System.out.println("\t" + item);
    }
    System.out.println("invalidMigrations.size=" + invalidMigrations.size());
    for (ValidateOutput item : invalidMigrations) {
      System.out.println("\tValidateOutput:");
      System.out.println("\t\tversion=" + item.version);
      System.out.println("\t\tdescription=" + item.description);
      System.out.println("\t\tfilepath=" + item.filepath);
      System.out.println("\t\terrorDetails=" + item.errorDetails.errorCode+"; "+item.errorDetails.errorMessage);

    }
  }

  public static void printCleanResult(CleanResult cleanResult) {
    System.out.println("           printCleanResult          ");
    String database = cleanResult.database;
    String flywayVersion = cleanResult.flywayVersion;
    String operation = cleanResult.operation;
    List<String> schemasCleaned = cleanResult.schemasCleaned;
    List<String> schemasDropped = cleanResult.schemasDropped;
    List<String> warnings = cleanResult.warnings;
    System.out.println("----------------------------------------");
    System.out.println("database=" + database);
    System.out.println("flywayVersion=" + flywayVersion);
    System.out.println("operation=" + operation);
    System.out.println("schemasCleaned.size=" + schemasCleaned.size());
    for (String item : schemasCleaned) {
      System.out.println("\t" + item);
    }
    System.out.println("schemasDropped.size=" + schemasDropped.size());
    for (String item : schemasDropped) {
      System.out.println("\t" + item);
    }
    System.out.println("warnings.size=" + warnings.size());
    for (String item : warnings) {
      System.out.println("\t" + item);
    }

  }

  public static void printMigrateResult(MigrateResult migrateResult) {
    System.out.println("           printMigrateResult          ");
    String database = migrateResult.database;
    List<MigrateOutput> migrations = migrateResult.migrations;
    int migrationsExecuted = migrateResult.migrationsExecuted;
    String flywayVersion = migrateResult.flywayVersion;
    String operation = migrateResult.operation;
    String initialSchemaVersion = migrateResult.initialSchemaVersion;
    String schemaName = migrateResult.schemaName;
    boolean success = migrateResult.success;
    String targetSchemaVersion = migrateResult.targetSchemaVersion;
    System.out.println("----------------------------------------");
    System.out.println("database=" + database);
    System.out.println("migrationsExecuted=" + migrationsExecuted);
    System.out.println("flywayVersion=" + flywayVersion);
    System.out.println("operation=" + operation);
    System.out.println("initialSchemaVersion=" + initialSchemaVersion);
    System.out.println("schemaName=" + schemaName);
    System.out.println("success=" + success);
    System.out.println("targetSchemaVersion=" + targetSchemaVersion);
    System.out.println("migration.size=" + migrations.size());
    for (MigrateOutput migration : migrations) {
      String category = migration.category;
      String description = migration.description;
      int executionTime = migration.executionTime;
      String type = migration.type;
      String version = migration.version;
      String filepath = migration.filepath;
      System.out.println("\tcategory=" + category);
      System.out.println("\tdescription=" + description);
      System.out.println("\texecutionTime=" + executionTime);
      System.out.println("\ttype=" + type);
      System.out.println("\tversion=" + version);
      System.out.println("\tfilepath=" + filepath);
      System.out.println("------------------------------");
    }

  }

}
