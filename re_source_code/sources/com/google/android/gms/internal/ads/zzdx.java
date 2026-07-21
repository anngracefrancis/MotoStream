package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdx extends zzcf<Integer, Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f16180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f16181c;

    public zzdx() {
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final void a(String str) {
        HashMap mapB = zzcf.b(str);
        if (mapB != null) {
            this.f16180b = (Long) mapB.get(0);
            this.f16181c = (Long) mapB.get(1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Long> c() {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, this.f16180b);
        map.put(1, this.f16181c);
        return map;
    }

    public zzdx(String str) {
        a(str);
    }
}
