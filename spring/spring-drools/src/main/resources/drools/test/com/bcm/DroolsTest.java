package com.bcm;


import com.bcm.entity.Car;
import com.bcm.entity.DrlResult;
import com.bcm.entity.Person;
import com.bcm.entity.RuleStr;
import org.kie.api.KieServices;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

import java.util.ArrayList;
import java.util.HashSet;

public class DroolsTest {

    static HashSet hashSet = new HashSet<String>();//
    /**
     * 主方法，junit 太慢
     *
     * @param args
     */
    public static void main(String[] args) {
        //droolsRules4();
        droolsRules3();
        // droolsRules2();
        // droolsRules1();
        // droolsRules();//寿险 反洗钱
    }


    /**
     * 匹配一定的东西，比如相应的文件夹下
     */
    public static void droolsRules1() {
        //从工厂中获得KieServices实例
        KieServices kieServices = KieServices.Factory.get();
        //默认自动加载 META-INF/kmodule.xml
        //从KieServices中获得KieContainer实例，其会加载kmodule.xml文件并load规则文件
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //kmodule.xml 中定义的 ksession name
        //建立KieSession到规则文件的通信管道
        //kieSession有状态, 维护会话状态，type=stateful  最后结束要调用dispose()
        //statelessKieSession无状态，不会维护会话状态 type=stateless
        KieSession kieSession = kieContainer.newKieSession("rules");//那个kmodule配置的文件包的名称
        Person p1 = new Person();
        Car car = new Car();
        DrlResult drlResult = new DrlResult();

        p1.setAge(32);
        p1.setName("小米");
        car.setName("小明");
        car.setAge(40);
        car.setDiscount(50);
        car.setName(car.getName().toUpperCase());
       // car.setPerson(p1);

        drlResult.setStaute("false");

        kieSession.insert(car);//插入到working memory
        kieSession.insert(p1);//插入到working memory
        kieSession.insert(drlResult);//插入到working memory

        int count;
        ClassObjectFilter cf = null;


        RuleStr s = new RuleStr("0003");
        String rules = "rule" + s.getStr();


        //通知规则引擎执行规则

        count = kieSession.fireAllRules();  // 匹配包下所有
        // count = kieSession.fireAllRules(new RuleNameEqualsAgendaFilter(rules));  // rules 特定的规则名
        /**
         * 匹配到就会执行文件then，执行then状态就会改变
         */
        cf = new ClassObjectFilter(DrlResult.class);//再通过反射拿Result结果

        for (Object ob : kieSession.getObjects(cf)) {
            DrlResult drlResult1 = (DrlResult) ob;
            System.out.println(drlResult1);
        }

        System.out.println(" 触发的count条数:" + count);

        kieSession.dispose();
    }

    /**
     * 就是匹配固定条数
     */
    public static void droolsRules2() {
        //从工厂中获得KieServices实例
        KieServices kieServices = KieServices.Factory.get();
        //默认自动加载 META-INF/kmodule.xml
        //从KieServices中获得KieContainer实例，其会加载kmodule.xml文件并load规则文件
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //kmodule.xml 中定义的 ksession name
        //建立KieSession到规则文件的通信管道
        //kieSession有状态, 维护会话状态，type=stateful  最后结束要调用dispose()
        //statelessKieSession无状态，不会维护会话状态 type=stateless
        KieSession kieSession = kieContainer.newKieSession("rules");//那个kmodule配置的文件包的名称
        Person p1 = new Person();
        Car car = new Car();
        DrlResult drlResult = new DrlResult();

        p1.setAge(32);
        p1.setName("小米");

        car.setName("小明");
        car.setAge(40);
        car.setDiscount(50);
        car.setName(car.getName().toUpperCase());
        //car.setPerson(p1);

        drlResult.setStaute("false");

        kieSession.insert(car);//插入到working memory
        kieSession.insert(p1);//插入到working memory
        kieSession.insert(drlResult);//插入到working memory

        int count;
        ClassObjectFilter cf = null;


        RuleStr s = new RuleStr("0003");
        String rules = "rule" + s.getStr();


        //通知规则引擎执行规则

        hashSet.add("rule0004");
        hashSet.add("rule0005");
        hashSet.add("rule0007");
        count = kieSession.fireAllRules(new AgendaFilter() {

            @Override
            public boolean accept(Match match) {
                String rulename = match.getRule().getName();

                return hashSet.contains(rulename);
            }
        });  // 匹配包下所有
        // count = kieSession.fireAllRules(new RuleNameEqualsAgendaFilter(rules));  // rules 特定的规则名
        /**
         * 匹配到就会执行文件then，执行then状态就会改变
         */
        cf = new ClassObjectFilter(DrlResult.class);//再通过反射拿Result结果

        for (Object ob : kieSession.getObjects(cf)) {
            DrlResult drlResult1 = (DrlResult) ob;
            System.out.println(drlResult1);
        }

        System.out.println(" 触发的count条数:" + count);

        kieSession.dispose();
    }

    /**
     * AgendaFilter 转 lambda
     */
    public static void droolsRules3() {
        //从工厂中获得KieServices实例
        KieServices kieServices = KieServices.Factory.get();
        //默认自动加载 META-INF/kmodule.xml
        //从KieServices中获得KieContainer实例，其会加载kmodule.xml文件并load规则文件
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //kmodule.xml 中定义的 ksession name
        //建立KieSession到规则文件的通信管道
        //kieSession有状态, 维护会话状态，type=stateful  最后结束要调用dispose()
        //statelessKieSession无状态，不会维护会话状态 type=stateless
        KieSession kieSession = kieContainer.newKieSession("rules");//那个kmodule配置的文件包的名称
        Person p1 = new Person();
        Car car = new Car();
        DrlResult drlResult = new DrlResult();

        p1.setAge(32);
        p1.setName("小米");

        car.setName("小明");
        car.setAge(40);
        car.setDiscount(50);
        car.setName(car.getName().toUpperCase());
        //car.setPerson(p1);

        drlResult.setStaute("false");

        kieSession.insert(car);//插入到working memory
        kieSession.insert(p1);//插入到working memory
        kieSession.insert(drlResult);//插入到working memory

        int count;
        ClassObjectFilter cf = null;


        RuleStr s = new RuleStr("0003");
        String rules = "rule" + s.getStr();


        //通知规则引擎执行规则

        hashSet.add("rule0003");
        hashSet.add("rule0009");
        hashSet.add("rule0007");
        count = kieSession.fireAllRules(match -> {
            String rulename = match.getRule().getName();

            return hashSet.contains(rulename);
        });  // 匹配包下所有
        // count = kieSession.fireAllRules(new RuleNameEqualsAgendaFilter(rules));  // rules 特定的规则名
        /**
         * 匹配到就会执行文件then，执行then状态就会改变
         */
        cf = new ClassObjectFilter(DrlResult.class);//再通过反射拿Result结果

        for (Object ob : kieSession.getObjects(cf)) {
            DrlResult drlResult1 = (DrlResult) ob;
            System.out.println(drlResult1);
        }

        System.out.println(" 触发的count条数:" + count);

        kieSession.dispose();
    }

    /**
     * lambda 提取
     */
    public static void droolsRules4() {
        //从工厂中获得KieServices实例
        KieServices kieServices = KieServices.Factory.get();
        //默认自动加载 META-INF/kmodule.xml
        //从KieServices中获得KieContainer实例，其会加载kmodule.xml文件并load规则文件
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //kmodule.xml 中定义的 ksession name
        //建立KieSession到规则文件的通信管道
        //kieSession有状态, 维护会话状态，type=stateful  最后结束要调用dispose()
        //statelessKieSession无状态，不会维护会话状态 type=stateless
        KieSession kieSession = kieContainer.newKieSession("rules");//那个kmodule配置的文件包的名称
        Person p1 = new Person();
        Car car = new Car();
        DrlResult drlResult = new DrlResult();

        p1.setAge(32);
        p1.setName("小米");

        car.setName("小明");
        car.setAge(40);
        car.setDiscount(50);
        car.setName(car.getName().toUpperCase());
      //  car.setPerson(p1);

        drlResult.setStaute("false");

        kieSession.insert(car);//插入到working memory
        kieSession.insert(p1);//插入到working memory
        kieSession.insert(drlResult);//插入到working memory

        int count;
        ClassObjectFilter cf = null;


        RuleStr s = new RuleStr("0003");
        String rules = "rule" + s.getStr();


        //通知规则引擎执行规则

        hashSet.add("rule0004");
        hashSet.add("");
        hashSet.add("rule0007");
        count = kieSession.fireAllRules(DroolsTest::accept);  // 匹配包下所有
        // count = kieSession.fireAllRules(new RuleNameEqualsAgendaFilter(rules));  // rules 特定的规则名
        /**
         * 匹配到就会执行文件then，执行then状态就会改变
         */
        cf = new ClassObjectFilter(DrlResult.class);//再通过反射拿Result结果

        for (Object ob : kieSession.getObjects(cf)) {
            DrlResult drlResult1 = (DrlResult) ob;
            System.out.println(drlResult1);
        }

        System.out.println(" 触发的count条数:" + count);

        kieSession.dispose();
    }



    /**
     * 贵州高铁
     */
    public static void GTGZRules() {
        //从工厂中获得KieServices实例
        KieServices kieServices = KieServices.Factory.get();
        //默认自动加载 META-INF/kmodule.xml
        //从KieServices中获得KieContainer实例，其会加载kmodule.xml文件并load规则文件
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //kmodule.xml 中定义的 ksession name
        //建立KieSession到规则文件的通信管道
        //kieSession有状态, 维护会话状态，type=stateful  最后结束要调用dispose()
        //statelessKieSession无状态，不会维护会话状态 type=stateless
        KieSession kieSession = kieContainer.newKieSession("gz001");//那个kmodule配置的文件包的名称

        Person p1 = new Person();
        Car car = new Car();
        DrlResult drlResult = new DrlResult();

        drlResult.setStaute("false");
        RuleStr s = new RuleStr("0003");
        String rule = "rule" + s.getStr();
        kieSession.insert(car);//插入到working memory
        kieSession.insert(drlResult);//插入到working memory
        kieSession.insert(p1);//插入到working memory


        RuleStr str = new RuleStr("0003");
        String rulesGTGZ = "GTGZ" + str.getStr();
        ClassObjectFilter cf = null;
        //通知规则引擎执行规则
        int count = kieSession.fireAllRules();  // 匹配包下所有

        // count = kieSession.fireAllRules(new RuleNameEqualsAgendaFilter(rulesGTGZ));  // 特定的规则名
        cf = new ClassObjectFilter(DrlResult.class);//再通过反射拿Result结果
        for (Object ob : kieSession.getObjects(cf)) {
            DrlResult drlResult1 = (DrlResult) ob;
            System.out.println(drlResult1);
        }
        System.out.println(" 触发的count条数:" + count);
        kieSession.dispose();

    }

    /**
     * 老代码了但又改了，不用了
     * // droolsRules();//寿险 反洗钱
     */
    public static void droolsRules() {
        String A = "";
        for (int i = 0; i < 1000; i++) {
            Person p1 = new Person();
            A += p1.getName();
        }
        System.out.println(A);
        //从工厂中获得KieServices实例
        KieServices kieServices = KieServices.Factory.get();
        //默认自动加载 META-INF/kmodule.xml
        //从KieServices中获得KieContainer实例，其会加载kmodule.xml文件并load规则文件
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //kmodule.xml 中定义的 ksession name
        //建立KieSession到规则文件的通信管道
        //kieSession有状态, 维护会话状态，type=stateful  最后结束要调用dispose()
        //statelessKieSession无状态，不会维护会话状态 type=stateless
        KieSession kieSession = kieContainer.newKieSession("tb");//那个kmodule配置的文件包的名称 tb 下全匹配

        Person p1 = new Person();
        p1.setAge(32);
        Car car = new Car();
        car.setName("aaAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAkkkkkkkkkkkkhhhhhhhhhhhhhhhhh");
        car.setDiscount(50);
        car.setName(car.getName().toUpperCase());
        System.out.println(car.getName().toUpperCase());
       // car.setPerson(p1);

        kieSession.insert(car);//插入到working memory
        kieSession.insert(p1);//插入到working memory

        int count = kieSession.fireAllRules();//通知规则引擎执行规则

        // kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("TBxxxx"));  // 特定的规则名
        ClassObjectFilter cf = new ClassObjectFilter(DrlResult.class);//再通过反射拿Result结果
        for (Object ob : kieSession.getObjects(cf)) {
            DrlResult drlResult = (DrlResult) ob;
            System.out.println(drlResult);
        }

        kieSession.dispose();//关闭规则中心
    }

    private static boolean accept(Match match) {
        String rulename = match.getRule().getName();

        return hashSet.contains(rulename);
    }
}


class c {
    public static void main(String[] args) {
        int c = 0;
        c = (int) Math.ceil(10.0 / 6.0);
        System.out.println(c);

        // 创建一个动态数组
        ArrayList<String> sites = new ArrayList<>();

        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Wiki");
        System.out.println("网站列表: " + sites);

        // 元素位置为1到3
        System.out.println("SubList: " + sites.subList(1, 3));
    }
}