package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbfs implements Iterable<zzbfq> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<zzbfq> f14429f = new ArrayList();

    public static boolean g(zzbdf zzbdfVar) {
        zzbfq zzbfqVarH = h(zzbdfVar);
        if (zzbfqVarH == null) {
            return false;
        }
        zzbfqVarH.f14426b.b();
        return true;
    }

    static zzbfq h(zzbdf zzbdfVar) {
        for (zzbfq zzbfqVar : zzk.zzmc()) {
            if (zzbfqVar.a == zzbdfVar) {
                return zzbfqVar;
            }
        }
        return null;
    }

    public final void c(zzbfq zzbfqVar) {
        this.f14429f.add(zzbfqVar);
    }

    public final void f(zzbfq zzbfqVar) {
        this.f14429f.remove(zzbfqVar);
    }

    @Override // java.lang.Iterable
    public final Iterator<zzbfq> iterator() {
        return this.f14429f.iterator();
    }
}
