package com.ratolla.PicPaySimplified.dto;

import com.ratolla.PicPaySimplified.entities.Wallet;
import com.ratolla.PicPaySimplified.entities.WalletType;

public record createWalletDTO(String fullname,
                              String cpfCnpj,
                              String email,
                              String password,
                              WalletType.Enum walletType) {
    public Wallet toWallet(){
        return new Wallet(fullname, cpfCnpj, email, password, walletType.get());
    }

}
