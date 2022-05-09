package com.bcm;


import com.bcm.entity.Person;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Title TestDrools
 * Package
 * Description 测试Drools类
 * Author 唐磊
 * Date 2019-07-06 14:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class TestDrools {

    private static KieContainer container = null;
    private KieSession statefulKieSession = null;

    /**
     * Title ruleStringTest
     * Param []
     * Return void
     * Exception
     * Description 基于字符串
     * Author 唐磊
     * Date 2019-07-06 14:27
     */
    @Test
    public void ruleStringTest() throws Exception {

        String myRule = "aaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbcccccccc";

        KieHelper helper = new KieHelper();

        helper.addContent(myRule, ResourceType.DRL);

        KieSession ksession = helper.build().newKieSession();

        Person person = new Person();

        person.setAge(12);
        myRule=myRule.toUpperCase();
        person.setName(myRule);

        ksession.insert(person);

        ksession.fireAllRules();

        ksession.dispose();
    }

}

