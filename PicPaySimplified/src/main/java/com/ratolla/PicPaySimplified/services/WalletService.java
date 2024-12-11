package com.ratolla.PicPaySimplified.services;

import com.ratolla.PicPaySimplified.dto.createWalletDTO;
import com.ratolla.PicPaySimplified.entities.Wallet;
import com.ratolla.PicPaySimplified.exceptions.WalletDataAlreadyExistsException;
import com.ratolla.PicPaySimplified.repositories.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(createWalletDTO dto) {
        var test = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (test.isPresent()){
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
        }
        Wallet newWallet = dto.toWallet();
        return walletRepository.save(newWallet);
    }
}
