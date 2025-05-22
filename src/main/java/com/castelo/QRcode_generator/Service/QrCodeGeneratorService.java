package com.castelo.QRcode_generator.Service;

import com.castelo.QRcode_generator.DTOS.QrcodeGenerateResponse;
import com.castelo.QRcode_generator.ports.StoragePorts;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeGeneratorService {

    private final StoragePorts storage;

    public QrCodeGeneratorService (StoragePorts storage){
        this.storage = storage;
    }

    public QrcodeGenerateResponse generateQRCode (String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream OutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix ,"PNG", OutputStream);
        byte[] pngData = OutputStream.toByteArray();

        String url = storage.uploadFile(pngData, UUID.randomUUID().toString(), "image/png");

        return new QrcodeGenerateResponse(url);
    }

}
