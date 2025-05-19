package com.castelo.QRcode_generator.Controller;

import com.castelo.QRcode_generator.DTOS.QrcodeGenerateRequest;
import com.castelo.QRcode_generator.DTOS.QrcodeGenerateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    @PostMapping
    public ResponseEntity<QrcodeGenerateResponse> generate(@RequestBody QrcodeGenerateRequest request){

        return null;
    }
}
