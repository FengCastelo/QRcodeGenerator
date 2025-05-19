package com.castelo.QRcode_generator.ports;

public interface StoragePorts {
    String uploadFile (byte[] fileData, String fileName, String contentType);
}
