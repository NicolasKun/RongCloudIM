package me.nicolas.rongcloudimdemo;

import me.nicolas.rongcloudimdemo.bean.TokenBean;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by LeeQ
 * Date : 2016-09-13
 * Name : RongCloudIMDemo
 * Use :
 */

public interface ImGetToken {

    @FormUrlEncoded
    @POST("token")
    Call<TokenBean> onToken(
            @Field("xiaoqiangId") String userId,
            @Field("xiaoruiName") String userName,
            @Field("url") String userAvatarPath
    );
}
