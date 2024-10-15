package com.fawry.springproject.service.mechant;

import com.fawry.springproject.dto.MerchantDto;
import com.fawry.springproject.entity.Merchant;


public interface MerchantService {
    Merchant getMerchantById(Long id);
    Merchant createMerchant(MerchantDto merchant);
    Merchant updateMerchant(Long id, MerchantDto merchant);
    void deleteMerchant(Long id);
    boolean isMerchantExist(Long id);
}
