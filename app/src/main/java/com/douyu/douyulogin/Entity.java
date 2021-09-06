package com.douyu.douyulogin;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Random;

public class Entity {
    public static String User_Device = "NGIzNzg2MDk0YjEyODc2ZDA1N2JjZDdjOTAzMDUxMTF8djYuMS4x";
    public static String aid = "android1";
    public static String client_sys = "android";
    public static String channel = "1125";
    public static String User_Agent = "android/6.1.1 (android 4.4.3; ; Nexus+5)";
    public static String gt_User_Agent = "Dalvik/1.6.0 (Linux; U; Android 4.4.3; Nexus 5 Build/KTU84M)";
    public static String gt_User_Agent2 = "Mozilla/5.0 (Linux; Android 4.4.3; Nexus 5 Build/KTU84M) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Mobile Safari/537.36";
    public static String Content_Type = "application/x-www-form-urlencoded";
    public static String Host = "passport.douyu.com";
    public static String gt_Host = "api.geetest.com";
    public static String Connection = "Keep-Alive";
    public static String Cookie = "acf_did=4b3786094b12876d057bcd7c90305111";
    public static String gt_Accept_Language = "zh-CN,en-US;q=0.8";
    public static String gt_Accept_Encoding = "gzip,deflate";
    public static String gt_X_Requested_With = "air.tv.douyu.android";
    public static String Accept_Encoding = "gzip";
    public static String areaCodeEncrypt = "hyRSOg==";
    public static String biz_type = "12";
    public static String gt_version = "v3";
    public static String sm_did = "20181204180007f086254cbe3e2f31daa673b8f9e126860101ba113bc41084";

    public static String code_type;
    public static String geetest_validate;
    public static String phoneCaptcha;
    public static String nickname;
    public static String geetest_challenge;
    public static String phoneNumEncrypt;
    public static String password;
    public static String geetest_seccode;
    public static String auth;
    public static String url;
    public static String code_token;
    public static String gt;
    public static String gt_Cookie;

    public static void init(){
        code_type="";
        geetest_validate="";
        phoneCaptcha="";
        nickname="";
        geetest_challenge="";
        phoneNumEncrypt="";
        password="";
        geetest_seccode="";
        auth="";
        url="";
        code_token="";
        gt="";
        gt_Cookie="";

    }


    // DouYu 的 url
    public static void Url_1(String time, int i) throws Exception {
        StringBuilder str = new StringBuilder();
        if (i == 0) {
            auth = "";
        }

        str.append("app/loginCheck3?");
        str.append("aid=" + aid);
        if (i != 0) {
            str.append("&auth=" + auth);
        }
        str.append("&client_sys=" + client_sys);
        str.append("&time=" + time + "vq47Hd9JUgfDCytC");
        str.append("&areaCodeEncrypt=" + areaCodeEncrypt);
        str.append("&biz_type=" + biz_type);
        if (code_token != null) {
            str.append("&code_token=" + code_token);
        }
        if (code_type != null) {
            str.append("&code_type=" + code_type);

        }
        str.append("&geetest_challenge=" + geetest_challenge);
        str.append("&geetest_seccode=" + geetest_seccode);
        str.append("&geetest_validate=" + geetest_validate);
        str.append("&gt_version=" + gt_version);
        str.append("&nickname=");
        str.append("&password=" + password);
        str.append("&phoneCaptcha=");
        str.append("&phoneNumEncrypt=" + phoneNumEncrypt);
        str.append("&sm_did=20181204180007f086254cbe3e2f31daa673b8f9e126860101ba113bc41084");

        System.out.println(str.toString());
        String auth1 = Algorithm.MD5encrypt(str.toString().replace("null", ""));
        auth = auth1;

        if (i == 0) {
            String result = "https://passport.douyu.com/app/loginCheck3?aid=" + aid + "&time=" + time + "&auth=" + auth1 + "&client_sys=" + client_sys;
            url = result;
            Url_1(time, 1);
        }
    }


    // x_dy_traceid的值
    public static String x_dy_traceid() {
        Random e = new Random();
        int i = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < 16; i2++) {
            if (i2 == 0) {
                stringBuilder.append(Integer.toHexString(e.nextInt(8)));
            } else {
                stringBuilder.append(Integer.toHexString(e.nextInt(16)));
            }
        }

        stringBuilder.append(":").append(stringBuilder.toString()).append("0:02");
        String valueOf = String.valueOf(e.nextInt(10000));
        int length = valueOf.length();
        if (length < 4) {
            while (i < 4 - length) {
                stringBuilder.append("0");
                i++;
            }
        }
        stringBuilder.append(valueOf);
        return stringBuilder.toString();
    }

    // 请求的body
    public static LinkedHashMap<String, String> body_1() {
        LinkedHashMap<String, String> paramsMap = new LinkedHashMap<>();
        paramsMap.put("geetest_validate", geetest_validate);
        paramsMap.put("phoneCaptcha", phoneCaptcha);
        paramsMap.put("biz_type", biz_type);
        paramsMap.put("sm_did", sm_did);
        paramsMap.put("nickname", nickname);
        paramsMap.put("gt_version", gt_version);
        paramsMap.put("geetest_challenge", geetest_challenge);
        if (code_token != null) {
            paramsMap.put("code_token", code_token);
        }
        paramsMap.put("phoneNumEncrypt", phoneNumEncrypt);
        paramsMap.put("areaCodeEncrypt", areaCodeEncrypt);
        paramsMap.put("password", password);
        if (code_type != null) {
            paramsMap.put("code_type", code_type);
        }
        paramsMap.put("geetest_seccode", geetest_seccode);
        return paramsMap;
    }
    public static String time(){
        String s = String.valueOf(System.currentTimeMillis());
        return s;
    }

    // 极验的 url
    public static String Url_2(int z) {
        StringBuffer str = new StringBuffer();
        str.append("https://api.geetest.com/");
        if (z == 1) {
            str.append("gettype.php?");
            str.append("gt=" + gt);
            str.append("&client_type=android&pure=1");
        } else if (z == 2) {
            str.append("get.php?");
            str.append("gt=" + gt);
            str.append("&challenge=" + geetest_challenge);
            str.append("&client_type=android&pure=1");
        } else if (z == 3) {
            str.append("ajax.php?");
            str.append("gt=" + gt);
            str.append("&challenge=" + geetest_challenge);
            str.append("&client_type=android&pure=1");
        } else if (z == 4) {
            str.append("get.php?");
            str.append("is_next=true&mobile=true&product=embed&width=100%25&https=true");
            str.append("&gt=" + gt);
            str.append("&challenge=" + geetest_challenge);
            str.append("&lang=zh-cn&type=slide3&api_server=api.geetest.com&timoout=15000&callback=geetest_"+time());
        } else if (z == 5) {
            str.append("ajax.php?");
            str.append("gt=" + gt);
            str.append("&challenge=" + geetest_challenge);
            str.append("&lang=zh-cn&pt=3&client_type=web_mobile");
            str.append("&w=(uKwDuNfODL8i4s7mSHPtab9UGo7PKg5JWOqRM7vS8xs2PWGwaBKn3S1isa0xrmBc1PgQRGpozqeC6h2xANDDL5GifLPFqtPbHzstb7(8aGsYiULIiu4z(1QqBFlCXeNahVZ1rxbdYLQ8hqA5RSqZ6lNPfCBGe5(1XjZ32(W1xqDs)kbsemI)tGsRiiQJdREvftScWpV(bDYI2bAbQji7Y0N3F9vThHsal)SJq8(7gMBG0eLqvAUgUpcYG2WRqcOmWgIornrRNA7UwEOsYbmSu5girsK5P67X7m)DNdBQn)tPJvMXsDU8AzBuKc3RfFdbCPTAbr0yj9NxG25cyp0Og4WLZSRFniTqhOVWIc)cyWZSr9RSpe7wKfIYmpD6NRZdLZl5gSwtLz4ZzMq8nPpm548duWW7SjWaLR5MgFcW17FfckyFg0SRhxGqOq2VVvmU)BsRJj4JVY0(Iqyg5Zt1yCBDvSIeH4ieTWFbYxDjPRelPUO9Ko2nZls0XBOpMu3(NZ9uz2)m1kVOP7HIOR3RtvhOUVuz1aC1Q)5SHg1VLPxstw)m39xPuY21ZHxHsIdy15ALFeplCfBtUMfnCAMTO0rCXBESUhmbyuuzUJFjQWv(y2FlF(GEHyLhrFQXJBHER1Zzd6irqrrJhWrSiF1z41tltVxq3G)glSIateKVHaGIDmd2bWtExbWnG63xiaaZEBiEx8icfHxETTuRcsSht2GI8BypS3nvKHyJdpI8w(j79wP4wrSkxz4BZ62W3ooc4chud83CV6uxthSg3O5ZHnJl4LUwdbUmCe1)X24eDBq91esxo9n3pX5mPqdfElijRxHI7hixNBomAsauoRSEnhmMbooS4b1mNk2DxuMa0(BBdDeeN3B35MCFgB1KuH2q2DgvB(VYT125RNJQ84IE(zsrv29QzM0GJZBfHQVCDRhElsRmME0G7YJ(RWZfzGoQG5N4j7GNkATvfiFKHOznu0F2YThQkP4zSpPM8AlURpgIjH3780c8)xL9ICHnxnreRFxlS6nJynoVneNY0TPhhIsPzwXw24yUnkNQTDVzwdlHUkDxrLHvQaQmF9zI1kNhy7xRZFSRZC6fncjdr)QE)KKTSUDvFLR5eCZQRlBhB9wMjHYS(5aXu95b3DQd3S9bcc03e223c425ba41db874a83ba24df6a232bcf1fc2b55688884950426dc72013d3ce2bcb3d54bdcc5fe4886373dd665a8ba1021cb4923e158a66ff7e9d3a73a4c130aee397b668a6060388a9e8e122fd2913b9124a394bfdf87888313841896027a34d4acd02b76df5aec2b4897186669282b29689b86042ad07c5a2e4e3acc");
            str.append("&callback=geetest_"+time());
        }

        return str.toString();
    }


    public static JSONObject gt_body() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("pure", "1");
            jsonObject.put("gt", gt);
            jsonObject.put("challenge", geetest_challenge);
            jsonObject.put("m", "QVSIcGBMQQ..");
            jsonObject.put("client_type", "android");
            jsonObject.put("light", "");
            jsonObject.put("mi", "7UJd1F2bSGYK1V4f(F)b(EJMSFjbSGYKRWCMQUJMSHibSGYKRXKLQWTIRWPLSWTKYUJMSF(b0W2Y1EKOSEle0Gpf5FgKcEIZ(Fia)E1YpFgKaUKM1FnLZVnLXWOL2HPKVWDJSFQK9EkbSGYK1V4f(F)b(EJMSEqbSGYK1V4f(F)b(EJMSErZ5FxYSGYKRWDKRWGIQWIKcEJcxF5bSGYK6UwKcEIayUKOSGSKeGAKcEIZwWhU5GvYSGaX7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhO1EmazUJMSHoKaUKJeGFORWIK9VSfSGsKaUKJSFQK(EKOSEtf9FaZ1UlczF9d9FbY5F1ZzVma2U0b1EJMSHoKaULIeHBOTVWJRXGMXXKLSH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0FZY1Fob)F7YxE1e1GoKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGAKcEJeSGYK0FlOyV8a2VYZ(Fia)E1YeGyY)GtZ0FYd(GvYxFxc1GoKcELaSGYKSVbLQFmcwVma5F1Z(HgZ8GEK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FZZ4UscxF5b1EJMSHoKaULKeGJNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deEle0Gpf5FhOwWpf2U1Y1GqbeGgZyXhe1Goa)F8f9Ema7GsKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deEle0Gpf5FhOzF9e0Ukb0WsKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deEle0Gpf5FhOwUwZzVka1Eld)GoZ(FtZSFQK2UKOSGFOQULdcG8KzUKOSGEKcEJeSGYKzF9deEle0Gpf5FhOwUxf(FkKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deEle0Gpf5FhOzElczHlcxHhfyWIKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeEmYwWtO3Ulc8FnY(FobyVlcSFQK2UKOSGJOQVWSRXCJdHqJVVWSlBxRhCtRSH1M7UKbSGYKQUJMSF4KaUIb)F1OzV9c8G3ZeGyY)GtZ0FYc)F8feF1f0FlcSFQK2UKOSGNOSVaJQVZZ2HOMYXEaSH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0FYc0V1c2U1Z3VmaSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeEtZ8FwayV8Z0EsZzXia1EtZ5HpZyUJMSHoKaULIeHBOTVWJRXGMXXKLSH1M7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhO3GtaeFxf3E1eSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeEpc1VnY)F)Y4EJMSHoKaULIeHBOTVWJRXGMXXKLSH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0FaYyV)a5FhZyWtOzElc1F5YxGoKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeFldxE1cSFQK2UKOSHJOSVWJRXGMXXKLSH1M7UKbSGYKQUJMSF4KaUIb)F1OyVmd1V5OxFgdeGme)F5ZSFQK2UKOSGFOQULdcG8KzUKOSGEKcEJeSGYKzF9deGkd4F9feGhZyV1d3GoKcELaSGYKYVaJeGFOTULdcG8KzUKOSGAKcEJeSGYKzF9deGubeEle0Gpf5FhOxGrY5Etc1Fba5FhZ)EJMSHoKaULIeGFOYULdcG8KzUKOSGEKcEJeSGYKzF9deEle0Gpf5FhOwWpf2U1Y1GqbeFhf3V5c)ElYzVbZ5EJMSHoKaULIeHBOTVWJRXGMXXKLSH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0FZY)EvZ9Fle0WvZ5EJMSHoKaULIeHBOTVWJRXGMXXKLSH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0Fab4Ema1Fib0V(axFtZyEkb7HmYSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeHqY(FgdxFxf3GsKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deEle0Gpf5FhOwWpf2U1Y1GqbeF1Z0E0ZSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FZdxGra5F5O0Ulc7EoZzE8KcELaSGYKTVbJeGEK9VSfSGsKaUKJSFQK(EKOSE6YeEtfeF9dyV9ezV9a0VYd3V5e5F1ZeF1ceE8a0Fbb4E3Y1EJMSHoKaUKJeGIK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeEtZyXgd(GvYxFxc1GoKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeFhZzU8b8F8b7EJMSHoKaUKLeGBOQULdcG8KzUKOSGAKcEJeSGYKzF9deHjY4UmYwWtO3U1a5ElYyEJMSHoKaUKKeGFOTULdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeFtdzUJMSHoKaULIeGNOSWMIYGGIWWXLSWVNQWOMZELdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeGtZ0XmY3U2exGpYSFQK2UKOSGFOTULdcG8KzUKOSGEKcEJeSGYKzF9deEle0Gpf5FhOzVnY0U1e3GsKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGAKcEJeSGYK)GpbeGia)Gyd0Gpf5FgKcELaSGYKSVbLeGAK9VSfSGsKaUKJSFQK(EKOSEtf9Faa1Fga1F5YeHpY9EsKcELaSGYKUVbJeGFORWAK9VSfSGsKaUKISFQK(EKOSEtf9FYe1EtZ8G0d(FYa1U1c0Gia)GgKcELaSGYKRVaJSH1M7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhOzXia1FnYSFQK2UKOSGFOYVaJeGIK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FYZwWibeFtZ(E1ZeFtZ(E1Z3U1Y3FnYSFQK2UKOSGFOTVaJRULdcG8KzUKOSGEKcEJeSGYKzF9deEyYeEle0Gpf5FhOwWod(Hib1Gra5EtZSFQK2UKOSGFOQVaLZULdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeFtf)Ftc1GnZ5EsfzVkZyUscyF(cSFQK2UKOSGNOTVaJRVaJQXKNWXGMeEma9ELdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeF3ZzU0bSFQK2UKOSHFOSVaJTWCJsFaMZWGKXWEK9VSfSGsKaUKISFQK(EKOSEtf9FZZ4UldwVxZeElY9E1e5GvYyUnY)GpO4F9f7FhZyHlbSFQK2UKOSGFOQULdcG8KzUKOSGEKcEJeSGYKzF9deEle0Gpf5FhO3Ulc8GgZwVmaeFwd2VmY5Esf1GoKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeEmYwWtO5F6Y1Xhd1Hgc)FhO4E1e0E0KcELaSGYKRVaIeGFOUXGLUXHKVWIK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeGgZzE8Z3Fkd(GvYxFxc1GoKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeE1ewXnY9FnY4F9YeFwZ0U1eSFQK2UKOSGJOQVaJZWCITVaJRXGMXXKLxELdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeEoZzE)ZwXiaxF6bwV(a0UJMSHoKaULIeHBOTVWJRXGMXXKLSH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0FaYyV)a5FhZyWtO0Vlc1Ggc)F6dSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FbY0WsKcELaSGYKSVbIeGNORWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeEmYwWtO9EmYzUJMSHoKaULLeHFOQULdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeEmYwWtOzFxf1ViYyU1e0UJMSHoKaUKIeGRORWAK9VSfSGsKaUKISFQK(EKOSEtf9FabzV5Y7FYa5XhZ0ElezFkKcELaSGYKRVaISH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0FbbxFxcwUmY1GobyV(YwVmaSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeFxfzEnY5F9eeFrZzVlYSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeEoZzE)ZwUtf(FodyV0KcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deEle0Gpf5FhOwWpf2U1Y1GqbeGtZ0Xgd(FubSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSE6YeEtfeF9dyV9ezV9a0VYd3V5e5F1ZeF1cSFQK2UKOSGJOSVbKdBtf)Ftc1FXQdGCNhELdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeFwZ1V4b4FmaSFQK2UKOSGFOQVaJQVaJQXKNWXGMSH1M7UKbSGYKRUJMSF4KaUIb)F1OxXkZ8Etf9F1OxUua5FxdzVvY1V5e1FwKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeEmYwWtO0F8bzUJMSHoKaUKJeGJOUWTIeGGMSH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0FaYyV)a5FhZyWtO0F)b(FxfxFibSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKISFQK(EKOSEtf9Fac1V5d1F5beGxd8G1c)Fsd(Gsd9HlcxHgd)F4KcELaSGYKRVaISH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0FYayV)bzVmaeGia)Hod0FmaSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeF3ZzU0b2GwKcELaSGYKRVbISH1M7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhOxGiYzVYa)F8fzUJMSHoKaUKLeGFOTWMK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0Fba5FhZ)GsKcELaSGYKTVaIeGLLSH1M7UKbSGYKRUJMSF4KaUIb)F1O8FtZeHmY0EnY1EJMSHoKaULIeHBOTVWJRXGMXXKLSH1M7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhO5F6Y1Xhd1Hgc)FhOwU1e5U1eSFQK2UKOSGJORVaJQETIWWLJZWKNUUUK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FZbxFxc1GqdTVgKcELaSGYKRVaJeHCITWDISH1M7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhO)F5Z0U1d1E1e5HgdxFwd6VmaSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FaYxGrY(FmazVnY1WgKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGAKcEJeSGYKzF9deFia)E1Y1GpOzG2b1Uxf)E8KcELaSGYKRVaISH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0FaYyV(c5UwZ(Fhc1GoKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGAKcEJeSGYKzF9deFsd0UzZyFbZ5EnZ0V9dxHhfyVbY1GvYSH1M7UKbSGYKQUJMSF4KaUIb)F1O3E3Y4HkaeHkdxHnY)F0Z0V(aSFQK2UKOSGFORVbLSH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0FYd(GjZ0VhZ2U0b1GsKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FYZ(Fia)E1YeFpZ1FgaxEsfSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FbYxFwfSFQK2UKOSGJOQVaLQWMIYGGIQXCMQXNNTWANSH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0FZe2EsKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGAKcEJeSGYKxE2aeHjaeFhf1W3ZeEle0Gpf5FgKcELaSGYKWVaJeGEK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeGvY7EJMSHoKaULIeHBOTVWJRXGMXXKLSH1M7UKbSGYKRUJMSF4KaUIb)F1OxXkZ8Etf9F1OzUzZ0Vhf3V5c5GvY(FmaSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeGia)Hod0FmazVbZzVma0E0b0U1f(Ema5UJMSHoKaULIeHBOTVWJRXGMXXKLSH1M7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhO5F6Y1Xhd1Hgc)FhO7F(a1EleSFQK2UKOSGBOZWEK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FYb)F5a5FvZwVgZ0VmaSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeGgZzGia)EtZzWtfyUJMSHoKaULIeHBOTVWJRXGMXXKLSH1M7UKbSGYKQUJMSF4KaUIb)F1O0F)Z5XlO0F)Z5Xlc)Fsd(EJMSHoKaUKJeGAK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FZY5Elc1GoKcELaSGYKRVaJSH1M7UKbSGYKRUJMSF4KaUIb)F1OxXkdzE9f2FodzFlOxF5YyV8d0EJMSHoKaULKeGNORVaIUWEK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeGia5F7YzWhf)FxZyUJMSHoKaUKJSH1M7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhO7FlZwUJMSHoKaUKKeGBOVWEK9VSfSGsKaUKJSFQK(EKOSEle0Gpf5FgKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deEle0Gpf5FhOwWpf2U1Y1GqbeEtf(HgZzHibSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKISFQK(EKOSEtf9FZY1F1feG7Z5G1f1VhZ9F8KcELaSGYKRVaISH1M7UKbSGYKRUJMSF4KaUIb)F1OxF5YyV8d0FZZ4XhZyV4Z8GvY)GoZ3FkKcELaSGYKUVbIeGNNRWHJYXPKTULdcG8KzUKOSGEKcEJeSGYKzF9deEle0Gpf5FhO0GpZxF2beEoZzU0bSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FYZwWibeGhc1WsKcELaSGYKUVaKeGNOVXLLWWOIXWQK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeHpZ(Fgd(FsKcELaSGYKUVbJeGGISH1M7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhOwVwZ5VZbxF1ZzUJMSHoKaUKJeGFOQXAIYHONUWTISVWLQUUK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeGudzXhZ9HkdSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeE9Z5UscxE1eSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FZb9EJMSHoKaULIeHJORUAMRWHJYXPKTUUK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FbYxFsKcELaSGYKRVaJSH1M7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhOnF9f3FxZjEld1GoZSFQK2UKOSGJOQVaIQWIIYGGJVWTLWWNNTWANSH1M7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhO5V)Z0Xka1EJMSHoKaULJeGJOSXMK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FYZwWibeF0Z3Eme5F5ZzUJMSHoKaUKLeGBORULdcG8KzUKOSGEKcEJeSGYKzF9deFtf)Ftc1FZZxGrY4EJMSHoKaULLeGFOTVaJSXHJSH1M7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhO3GtaSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeE9Z5VvZxGpYSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeFoZzFlc)EsfSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FZb)F9b8FlOxF5YyV8d0FYbxFxZ(FgZyUJMSHoKaUKKQWGLQWSISWMK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeEscyV9d1EJMSHoKaUKLSVaIeGHLQWBOZWUK9VSfSGsKaUKJSFQK(EKOSEtf9FYZ(Fia)E1YeGsc1FxcSFQK2UKOSHBOUVaLdGGJVWTLWWMK9VSfSGsKaUKJSFQK(EKOSEtf9FZc3FlOjWia5F7YoE1Y0FletFle1UJMSHoKaULIeHBOSVWQkA(JQXHLSXLJSH1M7UKbSGYKRUJMSF4KaUIb)F1O3F9f3FxZeEle0Gpf5FhOzW1ezElYxGjY1GqbeEtf(HgZzHibSFQK2UKOSHBOUVaLdGGJVWTLWWMK9T1MSFvYTUKOSGNOSVaJRVbISFQK0EwKaUKJXXPKSFQK0F0KaUJb)F9b8FkKcEIbxGqa5FmaSGYK1V4f(F)b(EJMSFheSGYK1V4f(F)b(EJMSEmYwUKOSFFRWVGNWVGNXVFRZVESRVESjFFRXVGNiFESUVFRWVGNSVERkEJMSHpZ(FhfyUKOSEkdyVbY2VZY)Hmd1VYZ(Fia)E1YSFQK5F1Z5EKOSGPJTXCNQWDKXXCLTXGLYUJMSEtf1V4KaUITuEJMSEtZ8FwKaULTpBoVSFQK0F6bSGYK1V4f(F)b(EJMSFxfzEKOSFDZ(E9e)HteQFxfzEnY5F9eQE2bQF7Z8FwKcEJfzXpZyUKOSHBOUVaLSFQK5GgKaUKfsUIdwXrKsUKO2FmMQWaOYUkbZWZYQVpaaVpZ1HGOVXCM1EDUSHtcxF6IsUKORWWKeGHKYVaIeGGIYUDUSFxfsUKORWLLeGBOQVaJsULdSFQKwW0KaULZ(E9e)HteSFQKyV)Z0VkKaUJJSWLQgVVUpB4XvWQTkHFJSWIKcELZ1U1YSGYKXXMZyGCLWUpNzEoZ1FXITWTKdEobZXFNxGGIzHKKUWBZxHFZSFQKyVlc1Emb1EKOSHJORVaJSH0.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static String Referer() {
        StringBuffer str = new StringBuffer();
        str.append("https://static.geetest.com/static/appweb/app3-index.html?");
        str.append("&gt=" + gt);
        str.append("&challenge=" + geetest_challenge);
        str.append("&lang=zh-cn&title=&slide=/static/js/slide.7.8.3.js&type=slide&api_server=api.geetest.com&static_servers=static.geetest.com,%20dn-staticdown.qbox.me&width=100%&timoout=15000");

        return str.toString();
    }
}
