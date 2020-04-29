package com.example.mycloudmusicapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AliyunOSSServiceTests {

    public void listBucket(){
        /**
         * oss地址
         */
        @Value("${aliyun.oss.endpoint}")
        private String endpoint;

        /**
         * 阿里云ak
         */
        @Value("${aliyun.ak}")
        private String ak;

        /**
         * 阿里云sk
         */
        @Value("${aliyun.sk}")
        private String sk;

        /**
         * 列举bucket
         */
        public void listBucket() {
            //创建OSSClient
            OSS ossClient = new OSSClientBuilder().build(
                    endpoint,
                    ak,
                    sk
            );

            //列举存储空间
            List<Bucket> buckets = ossClient.listBuckets();
            for (Bucket bucket : buckets) {
                log.info("listBucket {}", bucket.getName());
            }

            //关闭OSSClient
            ossClient.shutdown();
        }
    }

}
