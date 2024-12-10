package com.ratolla.PicPaySimplified.repositories;

import com.ratolla.PicPaySimplified.entities.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {

}
