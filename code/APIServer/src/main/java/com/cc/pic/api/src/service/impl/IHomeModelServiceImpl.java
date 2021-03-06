package com.cc.pic.api.src.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cc.pic.api.src.pojo.HomeModel;
import com.cc.pic.api.src.mapper.HomeModelMapper;
import com.cc.pic.api.src.service.IHomeModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ProJectName APIServer
 * @FileName IHomeModelServiceImpl
 * @Description
 * @Author CandyMuj
 * @Date 2020/1/7 15:48
 * @Version 1.0
 */
@Slf4j
@Service
public class IHomeModelServiceImpl extends ServiceImpl<HomeModelMapper, HomeModel> implements IHomeModelService {

}
