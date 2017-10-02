/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app.channel.sample2;

import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author prokopiukd
 */
public class Sample2 {

    public static void main(String[] args) throws Exception {
        URL url = Sample2.class.getResource("/data/nio-data1.txt");
        RandomAccessFile aFile = new RandomAccessFile(url.getFile(), "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1);
        int bytesRead = -1;
        while ((bytesRead = inChannel.read(buf)) != -1) {
            //buf.flip();
            while (buf.hasRemaining()) {
                System.out.println((char) buf.get());
            }
            //buf.clear();
        }
    }

}
