package com.cy.student.modules.utils.factory;

import com.cy.student.modules.config.SystemConfig;
import com.cy.student.modules.utils.PageUtils;
import com.cy.student.modules.utils.SpringContextUtils;


import java.util.Map;

/**
 * @author ChengKexing
 * @date 2019/1/4 0004
 */
public class PageUtilsFactory {

    private static SystemConfig systemConfig = null;

    static{
        systemConfig = SpringContextUtils.getBean("systemConfig", SystemConfig.class);
    }

    public static PageUtils getInstance(Map <String,Object> map) {
        if( "NaN".equals(map.get("currentpagecount").toString().intern()) ){
            map.put("currentpagecount",1);
            return new PageUtils( map );
        }else{
            return new PageUtils(map,systemConfig);
        }
    }
}
