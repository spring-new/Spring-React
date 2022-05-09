package java.spring.entity;

import java.util.Map;

public abstract class AbstractSNGenerator {
    /**
     * 准备流水号生成需要的参数MAP
     * @return
     */
    protected abstract Map prepareMap();

    public  Map generate(){
        Map parameterMap = prepareMap();

        return  parameterMap;
    }
}
