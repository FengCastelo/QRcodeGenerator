package com.castelo.QRcode_generator.Service;

import com.castelo.QRcode_generator.ports.StoragePorts;
import org.springframework.stereotype.Service;

@Service
public class QrCodeGeneratorService {

    private final StoragePorts storage;

    public QrCodeGeneratorService (StoragePorts storage){
        this.storage = storage;
    }


}
