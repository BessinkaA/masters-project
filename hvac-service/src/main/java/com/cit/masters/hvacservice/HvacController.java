package com.cit.masters.hvacservice;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 */
@RestController
public class HvacController {

    @Resource
    private HvacService hvacService;
}
