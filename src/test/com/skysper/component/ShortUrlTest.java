package com.skysper.component;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

@RunWith(JUnit4ClassRunner.class)
public class ShortUrlTest {
    /**
     * 仅输出结果url
     */
    @Test
    public void hashTest() {
        String url = "http://www.baidu.com";
        String code = ShortUrl.hash(url);

        System.out.println("http://t1.cn/"+code);

        url = "http://www.baidu.com/celebrate.html";
        code = ShortUrl.hash(url);
        System.out.println("http://t1.cn/" + code);
    }

}
