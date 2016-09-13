package me.nicolas.rongcloudimdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import me.nicolas.rongcloudimdemo.ImGetToken;
import me.nicolas.rongcloudimdemo.R;
import me.nicolas.rongcloudimdemo.bean.TokenBean;
import me.nicolas.rongcloudimdemo.config.Constans;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<TokenBean> {
    private String TOKEN = "jQy3DknxiaVHkyBYm7ixkOiiks61eL+mdoStdAfA2gdKJjO5y+StOugaLt3rudJwkhiw6Vk/Wn2FWti/CC/lCA==";
    private Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constans.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        loadToken();
    }

    private void loadToken() {
        ImGetToken imGetToken = mRetrofit.create(ImGetToken.class);

        Call<TokenBean> beanCall = imGetToken.onToken("121", "小瑞", "http://ocgl54rby.bkt.clouddn.com/imgs/a2.jpg");

        beanCall.enqueue(this);
    }

    private RongIMClient.ConnectCallback connectCallback = new RongIMClient.ConnectCallback() {
        @Override
        public void onTokenIncorrect() {

        }

        @Override
        public void onSuccess(String s) {
            Log.e("test", "融云 " + s);
        }

        @Override
        public void onError(RongIMClient.ErrorCode errorCode) {
            Log.e("test", "融云error " + errorCode);
        }
    };

    public void startChat(View view) {
        if (RongIM.getInstance() != null) {
            RongIM.getInstance().startPrivateChat(this, "12", "宇");
        }
    }

    //请求Token成功
    @Override
    public void onResponse(Call<TokenBean> call, Response<TokenBean> response) {
        if (response.code() == 200) {
            TokenBean body = response.body();
            Log.e("test", "Result " + body.getUserId());
            RongIM.connect(body.getToken(), connectCallback);
        }
    }

    //请求失败
    @Override
    public void onFailure(Call<TokenBean> call, Throwable t) {
        Log.e("test", "异常 " + t.getMessage());
    }
}
