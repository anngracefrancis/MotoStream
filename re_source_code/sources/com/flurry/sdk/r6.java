package com.flurry.sdk;

import android.os.SystemClock;
import okhttp3.HttpUrl;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r6 implements u6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private t6 f11032c;
    private long a = System.currentTimeMillis();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f11031b = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11033d = true;

    public r6(t6 t6Var) {
        this.f11032c = t6Var;
    }

    @Override // com.flurry.sdk.u6
    public final long b() {
        return this.f11031b;
    }

    @Override // com.flurry.sdk.u6
    public final long c() {
        return this.a;
    }

    @Override // com.flurry.sdk.u6
    public final String d() {
        try {
            return this.f11032c.a().toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    @Override // com.flurry.sdk.u6
    public final byte e() {
        return (byte) ((!this.f11033d ? 1 : 0) | 128);
    }

    @Override // com.flurry.sdk.u6
    public final t6 f() {
        return this.f11032c;
    }

    @Override // com.flurry.sdk.u6
    public final boolean g() {
        return this.f11033d;
    }
}
