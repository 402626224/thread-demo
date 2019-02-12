package com.tuandai.thread.service;

import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.lang.reflect.Parameter;

/**
 * Created by liusongrui on 2018/12/12.
 */
@Service
public class ChangeCardBusService implements BaseBusService {
    @Override
    public boolean matchServiceName(String serviceName) {
        return "CHANGE_BANKCARD".equalsIgnoreCase(serviceName);
    }

    @Override
    public Result handler(Parameter parameter) {
        return null;
    }
}
