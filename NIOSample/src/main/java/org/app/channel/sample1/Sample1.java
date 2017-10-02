/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app.channel.sample1;

import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author prokopiukd
 */
public class Sample1 {

    public static void main(String[] args) throws Exception {
        URL url = Sample1.class.getResource("/data/nio-data.txt");
        RandomAccessFile file = new RandomAccessFile(url.getFile(), "rw");
        FileChannel inChannel = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            buf.flip();   
          //  while (buf.hasRemaining()) {
                String str = new String(buf.array());
                System.out.println(str);
                System.out.println(str.length());
                System.out.println("bytesRead=" + bytesRead);
                System.out.println("--------------------------");
           // }
           buf.clear();
           bytesRead = inChannel.read(buf);
        }
    }

}
