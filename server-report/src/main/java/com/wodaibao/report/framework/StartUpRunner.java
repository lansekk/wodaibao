package com.wodaibao.report.framework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 启动加载
 *
 */
@Component
@Slf4j
public class StartUpRunner implements CommandLineRunner {

//    private final RedisTemplate<String, String> redisTemplate;
//    private final PropertyService propertyServcie;
//    private final CarBrandServcie carBrandServcie;
//    private final RegionsService regionsService;
//
//    @Autowired
//    public StartUpRunner(RedisTemplate<String, String> redisTemplate,PropertyService propertyServcie, CarBrandServcie carBrandServcie, RegionsService regionsService) {
//        this.propertyServcie = propertyServcie;
//        this.carBrandServcie = carBrandServcie;
//        this.regionsService = regionsService;
//        this.redisTemplate=redisTemplate;
//    }

    @Override
    public void run(String... arg0) throws Exception {
//        redisTemplate.delete(Constants.CACHE_QUALITY_PROPERTY);
//        propertyServcie.listPropertyLJPJ();
//        log.info("缓存零件品质结束");
//        redisTemplate.delete(Constants.CACHE_CAR_BRAND_SORT);
//        carBrandServcie.listCarBrandGroupByLetter();
//        log.info("缓存车辆品牌结束");
//        redisTemplate.delete(Constants.CACHE_RERIONS_VUX);
//        regionsService.listRegionsDoVux();
//        log.info("缓存vux省市区结束");
        log.info("启动自动加载完毕...");
    }

}