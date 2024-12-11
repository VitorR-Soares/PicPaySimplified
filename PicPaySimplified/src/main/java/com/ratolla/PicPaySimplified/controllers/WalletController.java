package com.ratolla.PicPaySimplified.controllers;

import com.ratolla.PicPaySimplified.dto.createWalletDTO;
import com.ratolla.PicPaySimplified.entities.Wallet;
import com.ratolla.PicPaySimplified.services.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/createWallet")
    public ResponseEntity<Wallet> createWallet(@RequestBody createWalletDTO dto){

        var wallet = walletService.createWallet(dto);

        return ResponseEntity.ok(wallet);
    }
}
