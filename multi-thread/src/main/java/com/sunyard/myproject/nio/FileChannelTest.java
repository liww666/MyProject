package com.sunyard.myproject.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Administrator on 2018/8/13.
 */
public class FileChannelTest {
    public static void main(String[] args){
        FileChannelTest test=new FileChannelTest();
//        test.readFile();
        test.bufferSlice();
    }
    public void readFile(){
        //buffer作为缓冲区，读是channel->buffer，写是buffer->channel
        FileInputStream fin=null;
        FileOutputStream fos=null;
        try {
            fin=new FileInputStream("C:\\Users\\Administrator\\Desktop\\pm_old.txt");
            FileChannel fc=fin.getChannel();
            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            int length;
            int num=0;
            fos=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\pm_old2.txt");
            FileChannel fcout=fos.getChannel();
            while ((length=fc.read(byteBuffer))!=-1){
                System.out.println("do :" + (num++) + " times!");
                byteBuffer.flip();
                fcout.write(byteBuffer);
                byteBuffer.clear();
            }

            System.out.println("done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        } finally {
            try {
                fin.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void bufferSlice(){
        //buffer 分片
        ByteBuffer byteBuffer=ByteBuffer.allocate(10);
        for(int i=0;i<byteBuffer.capacity();i++){
            byteBuffer.put((byte)i);
        }
        byteBuffer.position(3);
        byteBuffer.limit(8);
        ByteBuffer bufferSlice=byteBuffer.slice();
        for(int j=0;j<bufferSlice.capacity();j++){
//            System.out.println(bufferSlice.get(j));
            bufferSlice.put(j,(byte)(bufferSlice.get(j)*10));
        }
        byteBuffer.clear();
        while(byteBuffer.remaining()>0){
            System.out.println(byteBuffer.get());
        }
    }
}
