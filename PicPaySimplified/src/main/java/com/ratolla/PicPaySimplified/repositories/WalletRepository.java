package com.ratolla.PicPaySimplified.repositories;

import com.ratolla.PicPaySimplified.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

}
