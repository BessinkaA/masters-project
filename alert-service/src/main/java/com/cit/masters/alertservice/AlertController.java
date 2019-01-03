package com.cit.masters.alertservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 */
@RestController
@Slf4j
public class AlertController {

    @Resource
    private AlertService service;
}
