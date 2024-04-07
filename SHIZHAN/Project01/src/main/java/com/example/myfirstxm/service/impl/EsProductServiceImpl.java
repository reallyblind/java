package com.example.myfirstxm.service.impl;

import com.example.myfirstxm.common.api.CommonResult;
import com.example.myfirstxm.dao.EsProductDao;
import com.example.myfirstxm.nosql.elasticsearch.document.EsProduct;
import com.example.myfirstxm.nosql.elasticsearch.repository.EsProductRepository;
import com.example.myfirstxm.service.EsProductService;
import com.google.common.base.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 商品搜索管理Service实现类
 * @author blind
 * @create 2023-03-03-23:44
 */
@Service
public class EsProductServiceImpl implements EsProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsProductServiceImpl.class);
    @Autowired
    private EsProductDao productDao;
    @Autowired
    private EsProductRepository productRepository;


    @Override
    public int importAll() {
        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
        Iterable<EsProduct> esProductIterable = productRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> esProductList = productDao.getAllEsProductList(id);
        if (esProductList.size()>0){
            EsProduct esProduct = esProductList.get(0);
            result = productRepository.save(esProduct);
        }
        return result;
    }

    @Override
    public CommonResult<EsProduct> create(EsProduct esProduct) {
        if (esProduct!=null){
            long id = esProduct.getId();
            Iterable<EsProduct> all = productRepository.findAll();
            Iterator<EsProduct> iterator = all.iterator();
            while (iterator.hasNext()) {
                Long id1 = iterator.next().getId();
                if (Objects.equal(id, id1)) {
                    LOGGER.warn("此id: {}已经被创建", id);
                    return CommonResult.failed();
                }
            }
            productRepository.save(esProduct);
            LOGGER.info("创建商品成功，id：{}", id);
            return CommonResult.success(esProduct);
        }
        return CommonResult.failed();
    }

    @Override
    public void delete(List<Long> ids) {
        if(!CollectionUtils.isEmpty(ids)){
            List<EsProduct> esProductList =new ArrayList<>();
            for (Long id:ids){
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                esProductList.add(esProduct);
            }
            productRepository.deleteAll(esProductList);

        }
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return productRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword,pageable);
    }
}
