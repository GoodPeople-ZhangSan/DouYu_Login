package com.douyu.douyulogin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.douyu.douyulogin.Entity.Referer;

// 模拟极验的过程
public class Geetest {
    public static OkHttpClient client;

    static {
        client = new OkHttpClient()
                .newBuilder()
                // 禁止了重定向
                .followRedirects(false)
                .followSslRedirects(false)
                .build();
    }

    public static void gt_http1() {
        // 准备请求内容
        Request request = new Request.Builder()
                .addHeader("User-Agent", Entity.gt_User_Agent)
                .addHeader("Host", Entity.gt_Host)
                .addHeader("Connection", Entity.Connection)
                .url(Entity.Url_2(1))
                .build();

        // 发送请求
        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("极验第一次请求");
                String set_cookie = response.header("Set-Cookie");
                if (set_cookie != null) {
                    Entity.gt_Cookie = "GeeTestUser=" + (String) set_cookie.subSequence(12, 44);
                    gt_http2();
                } else {
                    System.out.println("set_cookie为空");
                }

            }
        });
    }

    public static void gt_http2() {
        // 准备请求内容
        Request request = new Request.Builder()
                .addHeader("Cookie", Entity.gt_Cookie)
                .addHeader("User-Agent", Entity.gt_User_Agent)
                .addHeader("Host", Entity.gt_Host)
                .addHeader("Connection", Entity.Connection)
                .url(Entity.Url_2(2))
                .build();

        // 发送请求
        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) {
                System.out.println("极验第二次请求");
                gt_http3();

            }
        });
    }

    public static void gt_http3() {

        // 需要请求体,把请求参数放在里面
        org.json.JSONObject body = Entity.gt_body();

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), String.valueOf(body));

        // 准备请求内容
        Request request = new Request.Builder()
                .addHeader("Cookie", Entity.gt_Cookie)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", Entity.gt_User_Agent)
                .addHeader("Host", Entity.gt_Host)
                .addHeader("Connection", Entity.Connection)
                .post(requestBody)
                .url(Entity.Url_2(3))
                .build();

        // 发送请求
        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("极验第三次请求");

                // 获取并处理数据
                String res = response.body().string();
                JSONObject parseObject = JSON.parseObject(res);
                String validate = parseObject.getJSONObject("data").getString("validate");
                if (validate != null) {
                    Entity.geetest_validate = validate;
                    Entity.geetest_seccode = validate + "|jordan";
                    try {
                        MainActivity.posthttp();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    gt_http4();
                }
            }
        });
    }

    private static void gt_http4() {
        // 准备请求内容
        Request request = new Request.Builder()
                .addHeader("Connection", Entity.Connection)
                .addHeader("Accept", "*/*")
                .addHeader("User-Agent", Entity.gt_User_Agent2)
                .addHeader("Referer", Referer())
                .addHeader("Accept-Encoding", Entity.gt_Accept_Encoding)
                .addHeader("Accept-Language", Entity.gt_Accept_Language)
                .addHeader("Cookie", Entity.gt_Cookie + "; GeeTestAjaxUser=acadf49593e897826cda125a9b23a8b0")
                .addHeader("X-Requested-With", Entity.gt_X_Requested_With)
                .url(Entity.Url_2(4))
                .build();

        // 发送请求
        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) {
                System.out.println("极验第四次请求");
                try {
                    gt_http5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private static void gt_http5() throws InterruptedException {
        Thread.sleep(1000);

        // 准备请求内容
        Request request = new Request.Builder()
                .addHeader("Host", Entity.gt_Host)
                .addHeader("Connection", Entity.Connection)
                .addHeader("Accept", "*/*")
                .addHeader("User-Agent", Entity.gt_User_Agent2)
                .addHeader("Referer", Referer())
//                .addHeader("Accept-Encoding", Entity.gt_Accept_Encoding)
                .addHeader("Accept-Language", Entity.gt_Accept_Language)
                .addHeader("Cookie", Entity.gt_Cookie + "; GeeTestAjaxUser=acadf49593e897826cda125a9b23a8b0")
                .addHeader("X-Requested-With", Entity.gt_X_Requested_With)
                .url(Entity.Url_2(5))
                .build();

        // 发送请求
        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) {
                System.out.println("极验第五次请求");
                String res = response.message();
                System.out.println("返回值：" + res);
                String res1 = (String) res.substring(22, res.length() - 1);
                System.out.println(res1);


//
//                JSONObject parseObject = JSON.parseObject(res1);
//                String validate = parseObject.getString("validate");
//                if (validate != null) {
//                    Entity.geetest_validate = validate;
//                    Entity.geetest_seccode = validate + "|jordan";
//                    try {
//                        MainActivity.posthttp();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    System.out.println("validate为空");
//                }
            }
        });
    }
}
