package com.example.mycloudmusicapi;

import com.example.mycloudmusicapi.util.BCryptUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BCryptUtilTests {
        /**
         * 要加密的数据
         */
        private String source = "ixueaedu";

        /**
         * 测试加密/是否匹配
         */
        @Test
        public void test() {
            //加密
            String encrypt = BCryptUtil.encrypt(source);

            //相等测试
            assertTrue(BCryptUtil.matchEncode(source, encrypt));

            //不相等测试
            assertFalse(BCryptUtil.matchEncode(source, source));
        }
}
