package com.castelo.QRcode_generator.Controller;

import com.castelo.QRcode_generator.DTOS.QrcodeGenerateRequest;
import com.castelo.QRcode_generator.DTOS.QrcodeGenerateResponse;

import com.castelo.QRcode_generator.Service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
    @RequestMapping("/qrcode")
    public class QrCodeController {

    private QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController qrCodeController(QrCodeGeneratorService qrCodeService) {
        this.qrCodeGeneratorService = qrCodeService;
    }


    @PostMapping
    public ResponseEntity<QrcodeGenerateResponse> generate(@RequestBody QrcodeGenerateRequest request) {
        try {
            QrcodeGenerateResponse response = this.qrCodeGeneratorService.generateQRCode(request.text());
            return ResponseEntity.ok(response);

        } catch (Exception error) {
            return ResponseEntity.internalServerError().build();

        }

    }
}
