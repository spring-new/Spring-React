package java.spring.entity;

import java.util.Map;

public abstract class AbstractSNGenerator {
    /**
     * ׼����ˮ��������Ҫ�Ĳ���MAP
     * @return
     */
    protected abstract Map prepareMap();

    public  Map generate(){
        Map parameterMap = prepareMap();

        return  parameterMap;
    }
}
