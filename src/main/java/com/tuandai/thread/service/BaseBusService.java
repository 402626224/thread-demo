package com.tuandai.thread.service;

import javax.xml.transform.Result;
import java.lang.reflect.Parameter;

/**
 * Created by liusongrui on 2018/12/12.
 */
public interface BaseBusService {

    boolean matchServiceName(String serviceName);

    Result handler(Parameter parameter);
}
