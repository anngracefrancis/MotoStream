package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmg {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzaly f14537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f14538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbmn f14539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzaho<Object> f14540e = new rc(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzaho<Object> f14541f = new tc(this);

    public zzbmg(String str, zzaly zzalyVar, Executor executor) {
        this.a = str;
        this.f14537b = zzalyVar;
        this.f14538c = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.a);
    }

    public final void b(zzbmn zzbmnVar) {
        this.f14537b.b("/updateActiveView", this.f14540e);
        this.f14537b.b("/untrackActiveViewUnit", this.f14541f);
        this.f14539d = zzbmnVar;
    }

    public final void d() {
        this.f14537b.c("/updateActiveView", this.f14540e);
        this.f14537b.c("/untrackActiveViewUnit", this.f14541f);
    }

    public final void f(zzbgz zzbgzVar) {
        zzbgzVar.f("/updateActiveView", this.f14540e);
        zzbgzVar.f("/untrackActiveViewUnit", this.f14541f);
    }

    public final void g(zzbgz zzbgzVar) {
        zzbgzVar.i("/updateActiveView", this.f14540e);
        zzbgzVar.i("/untrackActiveViewUnit", this.f14541f);
    }
}
