package com.castelo.QRcode_generator.Infrastructure;

import com.castelo.QRcode_generator.ports.StoragePorts;
import org.springframework.beans.factory.annotation.Value;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

public class S3StorageAdapter implements StoragePorts {


    private final S3Client s3Client;

    private final String bucketName;

    private final String region;

    public S3StorageAdapter (@Value("${aws.s3.region}") String region,
     @Value("${aws.s3.bucket-name}") String bucketName) {
        this.bucketName = bucketName;
        this.region = region;
        this.s3Client = S3Client.builder()
                .region(Region.of(this.region))
                .build();
    }

    @Override
    public String uploadFile(byte[] fileData, String fileName, String contentType) {
        return "";
    }
}
