/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.filetransformation;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
/**
 *
 * @author ninhow
 */
public class CodecBase64 {
    
    /**
     * This method converts the content of a source file into Base64 encoded data and saves that to a target file.If isChunked parameter is set to true, there is a hard wrap of the output  encoded text.
     * @param sourceFile
     * @param isChunked
     * @return 
     * @throws java.lang.Exception
     */
    public static String encode(String sourceFile, boolean isChunked) throws Exception {

        byte[] base64EncodedData = Base64.encodeBase64(loadFileAsBytesArray(sourceFile), isChunked);

        return new String(base64EncodedData);
    }
    
    public static String ecnodeString(String text, boolean isChunked) {
    	byte [] base64EncodedData = Base64.encodeBase64(loadStringAsByteArray(text), isChunked);
    	return new String(base64EncodedData);
    }
    public static String encode(File sourceFile, boolean isChunked) throws Exception {

        byte[] base64EncodedData = Base64.encodeBase64(loadFileAsBytesArray(sourceFile), isChunked);

        return new String(base64EncodedData);
    }
    
    /**
     * This method loads a file from file system and returns the byte array of the content.
     * 
     * @param fileName
     * @return
     * @throws Exception
     */
    public static void decode(String decodedBase64, String targetFile) throws Exception {

        byte[] decodedBytes = Base64.decodeBase64(decodedBase64);

        writeByteArraysToFile(targetFile, decodedBytes);
    }
    private static byte[] loadFileAsBytesArray(String fileName) throws Exception {

        File file = new File(fileName);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
        return bytes;

    }
    private static byte[] loadStringAsByteArray(String text) {
           return text.getBytes();
    }
    private static byte[] loadFileAsBytesArray(File file) throws Exception {
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
        return bytes;
    }

    /**
     * This method writes byte array content into a file.
     * 
     * @param fileName
     * @param content
     * @throws IOException
     */
    public static void writeByteArraysToFile(String fileName, byte[] content) throws IOException {

        File file = new File(fileName);
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
        writer.write(content);
        writer.flush();
        writer.close();
    }

}
