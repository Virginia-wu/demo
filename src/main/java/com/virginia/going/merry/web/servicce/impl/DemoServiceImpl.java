package com.virginia.going.merry.web.servicce.impl;

import com.virginia.going.merry.web.servicce.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    public Integer demo() {
        return 3;
    }
}
