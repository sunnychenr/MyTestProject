package com.lionmobi.canvaselevation.java_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenR on 2017/4/10.
 *
 * 生产者
 */

public class Producer {

    private Storage mStorage;

    public Producer() {
        mStorage = new Storage();
    }

    public void produce () {
        if (mStorage.enableProduce()) {

        }
    }

    private class Storage {
        private final int MAX_CONTRMAL = 25000;
        private List commodityList = new ArrayList();

        // 是否可以消费商品;
        public boolean enableConsume () {
            boolean isEnable = true;
            if (commodityList.isEmpty()) {
                isEnable = false;
            }
            return isEnable;
        }

        // 是否可以生产商品;
        public boolean enableProduce () {
            boolean isEnable = true;
            if (commodityList.size() > MAX_CONTRMAL) {
                isEnable = false;
            }
            return isEnable;
        }

    }

}
