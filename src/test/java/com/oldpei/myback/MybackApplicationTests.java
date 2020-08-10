package com.oldpei.myback;

import com.oldpei.myback.utils.publicTools.CommonUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybackApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(MybackApplicationTests.class);
	@Test
	void contextLoads() {
		System.out.println(CommonUtils.getFileExtension("test.cmk"));
		logger.info(CommonUtils.getFileExtension("test.cmk"));
	}

}
