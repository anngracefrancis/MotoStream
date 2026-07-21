package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public class zzaqb {
    private final zzbgz a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14073b;

    public zzaqb(zzbgz zzbgzVar) {
        this(zzbgzVar, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public final void b(int i2, int i3, int i4, int i5) {
        try {
            this.a.j("onSizeChanged", new JSONObject().put("x", i2).put("y", i3).put("width", i4).put("height", i5));
        } catch (JSONException e2) {
            zzbad.c("Error occured while dispatching size change.", e2);
        }
    }

    public final void c(int i2, int i3, int i4, int i5, float f2, int i6) {
        try {
            this.a.j("onScreenInfoChanged", new JSONObject().put("width", i2).put("height", i3).put("maxSizeWidth", i4).put("maxSizeHeight", i5).put("density", f2).put("rotation", i6));
        } catch (JSONException e2) {
            zzbad.c("Error occured while obtaining screen information.", e2);
        }
    }

    public final void d(int i2, int i3, int i4, int i5) {
        try {
            this.a.j("onDefaultPositionReceived", new JSONObject().put("x", i2).put("y", i3).put("width", i4).put("height", i5));
        } catch (JSONException e2) {
            zzbad.c("Error occured while dispatching default position.", e2);
        }
    }

    public final void e(String str) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("message", str).put("action", this.f14073b);
            zzbgz zzbgzVar = this.a;
            if (zzbgzVar != null) {
                zzbgzVar.j("onError", jSONObjectPut);
            }
        } catch (JSONException e2) {
            zzbad.c("Error occurred while dispatching error event.", e2);
        }
    }

    public final void f(String str) {
        try {
            this.a.j("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e2) {
            zzbad.c("Error occured while dispatching ready Event.", e2);
        }
    }

    public final void g(String str) {
        try {
            this.a.j("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e2) {
            zzbad.c("Error occured while dispatching state change.", e2);
        }
    }

    public zzaqb(zzbgz zzbgzVar, String str) {
        this.a = zzbgzVar;
        this.f14073b = str;
    }
}
