package com.lionmobi.mvptest.mvp_interface.base;

import java.util.Objects;

/**
 * Created by ChenR on 2017/5/5.
 */

public interface IBaseView {
    public <T extends IBaseModel> T onResult (T data);
    public <K> K onResultError (K error);
}
