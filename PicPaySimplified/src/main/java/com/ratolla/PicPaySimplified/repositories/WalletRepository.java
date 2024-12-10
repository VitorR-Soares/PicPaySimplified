package com.ratolla.PicPaySimplified.repositories;

import com.ratolla.PicPaySimplified.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

}
