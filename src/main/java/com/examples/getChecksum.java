package com.examples;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

public class getChecksum {
    public static void main(String[] args) throws IOException {
        String test = "Test";
        long crc32Checksum = getCRC32Checksum(test.getBytes(StandardCharsets.UTF_8));
        System.out.println(crc32Checksum);

        String anotherString = "Tesp";
        long checksumCRC32 = getChecksumCRC32(new ByteArrayInputStream(anotherString.getBytes(StandardCharsets.UTF_8)), 1024);
        System.out.println(checksumCRC32);
    }

    public static long getCRC32Checksum(byte[] bytes) throws IOException {
        Checksum crc32 = new CRC32();
        crc32.update(bytes, 0, bytes.length);
        return crc32.getValue();
    }

    public static long getChecksumCRC32(InputStream stream, int bufferSize)
            throws IOException {
        CheckedInputStream checkedInputStream = new CheckedInputStream(stream, new CRC32());
        byte[] buffer = new byte[bufferSize];
        while (checkedInputStream.read(buffer, 0, buffer.length) >= 0) {}
        return checkedInputStream.getChecksum().getValue();
    }
}
