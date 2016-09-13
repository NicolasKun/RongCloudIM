package me.nicolas.rongcloudimdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import me.nicolas.rongcloudimdemo.R;

public class MainActivity extends AppCompatActivity {
    private String TOKEN = "jQy3DknxiaVHkyBYm7ixkOiiks61eL+mdoStdAfA2gdKJjO5y+StOugaLt3rudJwkhiw6Vk/Wn2FWti/CC/lCA==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RongIM.connect(TOKEN, connectCallback);
        
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
}
