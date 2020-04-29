package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.domain.Version;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("接口v1 版本信息接口")
@RestController
@RequestMapping("/v1")
@Slf4j
public class MonitorControllerV1 {

    @Autowired
    private Version version;

    /**
     * 返回版本信息
     * @return
     */
    @GetMapping("/version")
    public Version version(){
       /* Version version = new Version();
        version.setCode(code);
        version.setName(name);*/
//        log.warn("test:" + this.version.toString());
        return this.version;
    }

}
