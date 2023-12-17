package com.x.xserver.unitl;

import java.util.Random;

public class systemUnitl {
    /**
     * 获取五位学生id[10002,99999]
     * @return sid
     */
    public Integer getSid(){
        return getInteger(10002,99999);
    }

    /**
     * 获取四位教师id[1002,9999]
     * @return tid
     */
    public Integer getTid(){
        return getInteger(1002,9999);
    }

    /**
     * 获取四位学生识别码[1000,9999]
     * @return sunique
     */
    public Integer getSunique(){
        return getInteger(1000,9999);
    }

    /**
     * 获取四位教师id[1000,9999]
     * @return tunique
     */
    public Integer getTunique(){
        return getInteger(1000,9999);
    }

    /**
     *获取随机数
     * @param min
     * @param max
     * @return
     */
    private Integer getInteger(Integer min,Integer max) {
        Random rand = new Random();
        Integer num = null;
        for (int i = 0; i < 10; i++) {
            num = Integer.valueOf(rand.nextInt(max - min + 1) + min);
        }
        return num;
    }
}
