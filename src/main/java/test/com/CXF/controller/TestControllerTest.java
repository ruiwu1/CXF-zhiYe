package test.com.CXF.controller; 

import com.CXF.mapper.TestMapper;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/** 
* TestController Tester. 
* 
* @author <Authors name> 
* @since <pre>一月 25, 2018</pre> 
* @version 1.0 
*/ 
public class TestControllerTest {
    private Logger logger = LoggerFactory.getLogger(TestControllerTest.class);

    @Autowired
    private TestMapper testMapper;


    /**
    *
    * Method: testToken(HttpServletRequest request, HttpServletResponse response, Model model)
    *
    */
    @Test
    public void testTestToken() throws Exception {
        MessageDigest sha1=MessageDigest.getInstance("SHA1");
        BASE64Encoder base64en = new BASE64Encoder();
        String passwd = base64en.encode(sha1.digest("123456".trim().getBytes("utf-8")));

        logger.info(passwd);
    }


} 
