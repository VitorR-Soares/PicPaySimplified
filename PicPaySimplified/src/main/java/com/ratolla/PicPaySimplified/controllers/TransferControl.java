package com.ratolla.PicPaySimplified.controllers;

import com.ratolla.PicPaySimplified.dto.TransferDTO;
import com.ratolla.PicPaySimplified.entities.Transfer;
import com.ratolla.PicPaySimplified.services.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferControl {

    private final TransferService transferService;

    public TransferControl(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDTO dto){

        var transfer = transferService.transfer(dto);

        return ResponseEntity.ok(transfer);
    }

}
