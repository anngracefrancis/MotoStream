package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class zzbvz {
    private final zzbwz a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbgz f14760b;

    public zzbvz(zzbwz zzbwzVar) {
        this(zzbwzVar, null);
    }

    public Set<zzbuz<zzbrl>> a(zzbxc zzbxcVar) {
        return Collections.singleton(zzbuz.a(zzbxcVar, zzbbm.f14331b));
    }

    public final zzbgz b() {
        return this.f14760b;
    }

    public final zzbwz c() {
        return this.a;
    }

    public final View d() {
        zzbgz zzbgzVar = this.f14760b;
        if (zzbgzVar == null) {
            return null;
        }
        return zzbgzVar.getWebView();
    }

    final /* synthetic */ void e() {
        if (this.f14760b.k0() != null) {
            this.f14760b.k0().close();
        }
    }

    public zzbvz(zzbwz zzbwzVar, zzbgz zzbgzVar) {
        this.a = zzbwzVar;
        this.f14760b = zzbgzVar;
    }
}
