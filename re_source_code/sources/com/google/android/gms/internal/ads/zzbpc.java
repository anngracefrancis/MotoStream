package com.google.android.gms.internal.ads;

import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class zzbpc {
    protected zzcxu a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected zzcxm f14662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected zzbry f14663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected zzbso f14664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f14665e;

    private static String e(zzcxm zzcxmVar) {
        try {
            return zzcxmVar.s.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    public void a() {
        this.f14663c.i0(null);
    }

    public final String b() {
        return this.f14665e;
    }

    public void c() {
        this.f14664d.onAdLoaded();
    }

    public final zzbry d() {
        return this.f14663c;
    }

    public final String f() {
        String strE = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(this.f14665e) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(this.f14665e) ? e(this.f14662b) : null;
        return strE == null ? this.f14665e : strE;
    }
}
