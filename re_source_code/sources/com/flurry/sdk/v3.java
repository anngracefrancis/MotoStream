package com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class v3 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f11099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f11100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f11101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f11102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f11103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f11104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f11105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f11106k;

    public enum a {
        UNKNOWN(0),
        CUSTOM(1),
        PURCHASE(8),
        MESSAGE(9),
        USER_STANDARD(10),
        PERFORMANCE(1),
        SDK_LOG(1);

        final int n;

        a(int i2) {
            this.n = i2;
        }
    }

    public v3(String str, int i2, a aVar, Map<String, String> map, Map<String, String> map2, boolean z, boolean z2, long j2, long j3, long j4) {
        this.a = 2;
        this.f11097b = str;
        this.f11098c = i2;
        this.f11099d = aVar;
        this.f11100e = map;
        this.f11101f = map2;
        this.f11102g = z;
        this.f11103h = z2;
        this.f11104i = j2;
        this.f11105j = j3;
        this.f11106k = j4;
    }

    private static Map<String, String> b(Map<String, String> map, List<String> list) {
        String strH;
        String value;
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (list.contains(entry.getKey())) {
                strH = c2.h(entry.getKey());
                value = entry.getValue();
            } else {
                strH = c2.h(entry.getKey());
                value = c2.h(entry.getValue());
            }
            if (!TextUtils.isEmpty(strH)) {
                map2.put(strH, value);
            }
        }
        return map2;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.event.name", this.f11097b);
        jSONObjectA.put("fl.event.id", this.f11098c);
        jSONObjectA.put("fl.event.type", this.f11099d.n);
        jSONObjectA.put("fl.event.timed", this.f11102g);
        jSONObjectA.put("fl.timed.event.starting", this.f11103h);
        long j2 = this.f11106k;
        if (j2 > 0) {
            jSONObjectA.put("fl.timed.event.duration", j2);
        }
        jSONObjectA.put("fl.event.timestamp", this.f11104i);
        jSONObjectA.put("fl.event.uptime", this.f11105j);
        jSONObjectA.put("fl.event.user.parameters", e2.a(this.f11100e));
        jSONObjectA.put("fl.event.flurry.parameters", e2.a(this.f11101f));
        return jSONObjectA;
    }

    public v3(String str, int i2, a aVar, Map<String, String> map, Map<String, String> map2, List<String> list, boolean z, boolean z2, long j2, long j3) {
        this(c2.h(c2.b(str)), i2, aVar, (Map<String, String>) (map != null ? b(map, list) : new HashMap()), (Map<String, String>) (map2 != null ? b(map2, list) : new HashMap()), z, z2, j2, j3, 0L);
    }
}
