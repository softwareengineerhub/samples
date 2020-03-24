package com.app;

import example.avro.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;

public class MyTransformer {
    private static final String FILE_PATH = "users.txt";
    //private static final String FILE_PATH = "users.avro";

    public void serialize(User u1, User u2, User u3) {
        try {
            DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
            DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
            dataFileWriter.create(u1.getSchema(), new File(FILE_PATH));
            dataFileWriter.append(u1);
            dataFileWriter.append(u2);
            dataFileWriter.append(u3);
            dataFileWriter.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void deserialize() {
        try {
            DatumReader<User> userDatumReader = new SpecificDatumReader<User>(User.class);
            DataFileReader<User> dataFileReader = new DataFileReader<User>(new File(FILE_PATH), userDatumReader);
            User user = null;
            while (dataFileReader.hasNext()) {
                user = dataFileReader.next(user);
                System.out.println(user);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
