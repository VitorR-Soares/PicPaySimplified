package com.ratolla.PicPaySimplified.services;

import com.ratolla.PicPaySimplified.dto.TransferDTO;
import com.ratolla.PicPaySimplified.entities.Transfer;
import com.ratolla.PicPaySimplified.entities.Wallet;
import com.ratolla.PicPaySimplified.exceptions.InsufficientBalanceException;
import com.ratolla.PicPaySimplified.exceptions.UnauthorizedTransferException;
import com.ratolla.PicPaySimplified.exceptions.UnauthorizedTransferForWallletTypeException;
import com.ratolla.PicPaySimplified.exceptions.WalletNotFoundException;
import com.ratolla.PicPaySimplified.repositories.TransferRepository;
import com.ratolla.PicPaySimplified.repositories.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferService {

    private final WalletRepository walletRepository;
    private final TransferRepository transferRepository;
    private final NotificationService notificationService;
    private final AuthorizationService authorizationService;

    public TransferService(WalletRepository walletRepository, TransferRepository transferRepository, NotificationService notificationService, AuthorizationService authorizationService) {
        this.walletRepository = walletRepository;
        this.transferRepository = transferRepository;
        this.notificationService = notificationService;
        this.authorizationService = authorizationService;
    }
    @Transactional
    public Transfer transfer(TransferDTO dto){

        var sender = walletRepository.findById(dto.sender())
                .orElseThrow(() -> new WalletNotFoundException(dto.sender()));
        var receiver = walletRepository.findById(dto.receiver())
                .orElseThrow(() -> new WalletNotFoundException(dto.sender()));

        validateTransfer(dto, sender);

        sender.debit(dto.value());
        receiver.credit(dto.value());

        Transfer newTransfer = new Transfer(sender, receiver, dto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        transferRepository.save(newTransfer);

        CompletableFuture.runAsync(()-> notificationService.sendNotification(newTransfer));

        return newTransfer;
    }

    public void validateTransfer(TransferDTO dto, Wallet sender){
        if(!sender.isWalletTypeUser()){
            System.out.println("Entendeu como falso");
            throw new UnauthorizedTransferForWallletTypeException();
        }
        if(!sender.isBalanceEnough(dto.value())){
            throw new InsufficientBalanceException();
        }
        if(!authorizationService.isAuthorized(dto)){
            throw new UnauthorizedTransferException();
        }
    }


}
