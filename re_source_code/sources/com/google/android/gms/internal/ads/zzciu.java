package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.IOUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzciu implements zzczc<zzciv, zzciw> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzasm f15277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f15278d;

    public zzciu(Context context, String str, zzasm zzasmVar, String str2) {
        this.a = context;
        this.f15276b = str;
        this.f15277c = zzasmVar;
        this.f15278d = str2;
    }

    private final zzciw b(String str, zzasd zzasdVar, JSONObject jSONObject, String str2) throws zzcif {
        byte[] bytes;
        InputStreamReader inputStreamReader;
        BufferedOutputStream bufferedOutputStream;
        String str3 = "doritos_v2";
        String str4 = "doritos";
        String str5 = HttpUrl.FRAGMENT_ENCODE_SET;
        try {
            zzciw zzciwVar = new zzciw();
            String strValueOf = String.valueOf(this.f15276b);
            zzbad.h(strValueOf.length() != 0 ? "SDK version: ".concat(strValueOf) : new String("SDK version: "));
            String strValueOf2 = String.valueOf(str);
            zzbad.e(strValueOf2.length() != 0 ? "AdRequestServiceImpl: Sending request: ".concat(strValueOf2) : new String("AdRequestServiceImpl: Sending request: "));
            URL url = new URL(str);
            HashMap map = new HashMap();
            long jB = zzk.zzln().b();
            boolean z = false;
            int i2 = 0;
            while (true) {
                this.f15277c.b();
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    zzk.zzlg().m(this.a, this.f15276b, z, httpURLConnection);
                    if (!TextUtils.isEmpty(str2)) {
                        httpURLConnection.addRequestProperty("Cookie", str2);
                    }
                    if (zzasdVar.d()) {
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("pii");
                        if (jSONObjectOptJSONObject != null) {
                            if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString(str4, str5))) {
                                httpURLConnection.addRequestProperty("x-afma-drt-cookie", jSONObjectOptJSONObject.optString(str4, str5));
                            }
                            if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString(str3, str5))) {
                                httpURLConnection.addRequestProperty("x-afma-drt-v2-cookie", jSONObjectOptJSONObject.optString(str3, str5));
                            }
                        } else {
                            zzawz.m("DSID signal does not exist.");
                        }
                    }
                    if (TextUtils.isEmpty(zzasdVar.c())) {
                        bytes = null;
                    } else {
                        httpURLConnection.setDoOutput(true);
                        bytes = zzasdVar.c().getBytes();
                        httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            try {
                                bufferedOutputStream.write(bytes);
                                IOUtils.a(bufferedOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                IOUtils.a(bufferedOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedOutputStream = null;
                        }
                    }
                    zzazx zzazxVar = new zzazx();
                    zzazxVar.i(httpURLConnection, bytes);
                    int responseCode = httpURLConnection.getResponseCode();
                    for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                        String str6 = str3;
                        String key = entry.getKey();
                        String str7 = str4;
                        List<String> value = entry.getValue();
                        if (map.containsKey(key)) {
                            ((List) map.get(key)).addAll(value);
                        } else {
                            map.put(key, new ArrayList(value));
                            str5 = str5;
                        }
                        str4 = str7;
                        str3 = str6;
                    }
                    String str8 = str3;
                    String str9 = str4;
                    String str10 = str5;
                    zzazxVar.h(httpURLConnection, responseCode);
                    if (responseCode >= 200 && responseCode < 300) {
                        try {
                            InputStreamReader inputStreamReader2 = new InputStreamReader(httpURLConnection.getInputStream());
                            try {
                                zzk.zzlg();
                                String strF = zzaxi.f(inputStreamReader2);
                                IOUtils.a(inputStreamReader2);
                                zzazxVar.p(strF);
                                zzciwVar.a = responseCode;
                                zzciwVar.f15281c = strF;
                                zzciwVar.f15280b = map;
                                if (TextUtils.isEmpty(strF)) {
                                    if (!((Boolean) zzyt.e().c(zzacu.r4)).booleanValue()) {
                                        throw new zzcif("No Fill", 3);
                                    }
                                }
                                zzciwVar.f15282d = zzk.zzln().b() - jB;
                                httpURLConnection.disconnect();
                                this.f15277c.a();
                                return zzciwVar;
                            } catch (Throwable th3) {
                                th = th3;
                                inputStreamReader = inputStreamReader2;
                                IOUtils.a(inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            inputStreamReader = null;
                        }
                    } else {
                        if (responseCode < 300 || responseCode >= 400) {
                            StringBuilder sb = new StringBuilder(46);
                            sb.append("Received error HTTP response code: ");
                            sb.append(responseCode);
                            zzbad.i(sb.toString());
                            StringBuilder sb2 = new StringBuilder(46);
                            sb2.append("Received error HTTP response code: ");
                            sb2.append(responseCode);
                            throw new zzcif(sb2.toString());
                        }
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (TextUtils.isEmpty(headerField)) {
                            zzbad.i("No location header to follow redirect.");
                            throw new zzcif("No location header to follow redirect");
                        }
                        URL url2 = new URL(headerField);
                        i2++;
                        if (i2 > ((Integer) zzyt.e().c(zzacu.a4)).intValue()) {
                            zzbad.i("Too many redirects.");
                            throw new zzcif("Too many redirects");
                        }
                        httpURLConnection.disconnect();
                        this.f15277c.a();
                        url = url2;
                        str5 = str10;
                        str4 = str9;
                        str3 = str8;
                        z = false;
                    }
                } catch (Throwable th5) {
                    httpURLConnection.disconnect();
                    this.f15277c.a();
                    throw th5;
                }
            }
        } catch (IOException e2) {
            String strValueOf3 = String.valueOf(e2.getMessage());
            zzbad.i(strValueOf3.length() != 0 ? "Error while connecting to ad server: ".concat(strValueOf3) : new String("Error while connecting to ad server: "));
            String strValueOf4 = String.valueOf(e2.getMessage());
            throw new zzcif(strValueOf4.length() != 0 ? "Error connecting to ad server:".concat(strValueOf4) : new String("Error connecting to ad server:"), 2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final /* synthetic */ zzciw a(zzciv zzcivVar) throws Exception {
        zzciv zzcivVar2 = zzcivVar;
        return b(zzcivVar2.f15279b.a(), zzcivVar2.f15279b, zzcivVar2.a, this.f15278d);
    }
}
