package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdw extends zzcf<Integer, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f16177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f16178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f16179d;

    public zzdw() {
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final void a(String str) {
        HashMap mapB = zzcf.b(str);
        if (mapB != null) {
            this.f16177b = (Long) mapB.get(0);
            this.f16178c = (Boolean) mapB.get(1);
            this.f16179d = (Boolean) mapB.get(2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Object> c() {
        HashMap<Integer, Object> map = new HashMap<>();
        map.put(0, this.f16177b);
        map.put(1, this.f16178c);
        map.put(2, this.f16179d);
        return map;
    }

    public zzdw(String str) {
        a(str);
    }
}
