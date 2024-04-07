package com.example.myfirstxm.service;

import com.example.myfirstxm.mbg.model.PmsBrand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PmsBrandService
 * @author blind
 * @create 2023-02-25-13:49
 */

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
