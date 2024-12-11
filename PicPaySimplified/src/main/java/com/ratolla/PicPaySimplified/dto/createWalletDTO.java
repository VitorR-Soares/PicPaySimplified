package com.ratolla.PicPaySimplified.dto;

import com.ratolla.PicPaySimplified.entities.Wallet;
import com.ratolla.PicPaySimplified.entities.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record createWalletDTO(@NotBlank String fullname,
                              @NotBlank String cpfCnpj,
                              @NotBlank String email,
                              @NotBlank String password,
                              @NotNull WalletType.Enum walletType) {
    public Wallet toWallet(){
        return new Wallet(fullname, cpfCnpj, email, password, walletType.get());
    }

}
