package com.tuandai.thread.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;

/**
 * Created by liusongrui on 2018/12/12.
 */
@Service
public class BusController {

    @Autowired
    private List<BaseBusService> busServices;


    @Autowired
    ChangeCardBusService changeCardBusService;

    public Result exec() {
        String serviceName = "CHANGE_BANKCARD";
        Result result = null;
        for (BaseBusService busService : busServices) {
            if (busService.matchServiceName(serviceName)) {
                result = busService.handler(null);
            }
        }
        return result;
    }


}
