package com.douyu.douyulogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static OkHttpClient client;
    EditText username;
    EditText password;
    // 计次
    public static int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client = new OkHttpClient()
                .newBuilder()
                // 禁止了重定向
                .followRedirects(false)
                .followSslRedirects(false)
                .build();
    }

    public void btn(View view) throws Exception {
        // 初始化
        Entity.init();
        sum = 0;

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        String phone = Algorithm.HloveyRC4(username.getText().toString().trim()).substring(0, 16);
        String passwd = Algorithm.MD5encrypt(password.getText().toString().trim());

        Entity.phoneNumEncrypt = phone;
        Entity.password = passwd;

        //第一次请求
        posthttp();

    }

    // 第一次请求
    public static void posthttp() throws Exception {

        // 需要请求体,把请求参数放在里面
        LinkedHashMap<String, String> paramsMap = new LinkedHashMap<>(Entity.body_1());
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : paramsMap.keySet()) {
            //追加表单信息
            if (paramsMap.get(key) != null) {
                builder.add(key, paramsMap.get(key));
            } else {
                builder.add(key, "");
            }
        }
        RequestBody formBody = builder.build();

//        String body = Entity.body_1();
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), body);

        // 时间戳
        String time = String.valueOf(System.currentTimeMillis() / 1000);

        // 运行得到auth 和 url
        Entity.Url_1(time, 0);

        // 准备post请求内容
        Request postrequest = new Request.Builder()
                .addHeader("User-Device", Entity.User_Device)
                .addHeader("aid", Entity.aid)
                .addHeader("channel", Entity.channel)
                .addHeader("User-Agent", Entity.User_Agent)
                .addHeader("time", time)
                .addHeader("auth", Entity.auth)
                .addHeader("x-dy-traceid", Entity.x_dy_traceid())
                .addHeader("Content-Type", Entity.Content_Type)
//                .addHeader("Content-Length", String.valueOf(formBody.toString().length()))
                .addHeader("Host", Entity.Host)
                .addHeader("Connection", Entity.Connection)
//                .addHeader("Accept-Encoding", Entity.Accept_Encoding)
                .addHeader("Cookie", Entity.Cookie)
                .post(formBody)
                .url(Entity.url)
                .build();


        Call call = client.newCall(postrequest);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("响应失败");
            }

            @Override
            public void onResponse(Call call, Response resp) throws IOException {

                System.out.println("向斗鱼发送第" + (++sum) + "次请求");

                // 获取返回的数据
                String res = resp.body().string();
                System.out.println("返回值：" + res);

                // 数据处理
                JSONObject parseObject = JSON.parseObject(res);
                int error = parseObject.getInteger("error");
                if (error == 81) {
                    // 处理返回的数据
                    JSONObject data = parseObject.getJSONObject("data");
                    Entity.geetest_challenge = data.getJSONObject("code_data").getString("challenge");
                    Entity.gt = data.getJSONObject("code_data").getString("gt");
                    Entity.code_token = data.getString("code_token");
                    Entity.code_type = "1";

                    // 模拟极验
                    Geetest.gt_http1();
                }
            }
        });
    }
}