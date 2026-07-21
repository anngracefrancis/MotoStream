package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzeg extends zzcf<Integer, Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f16202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f16203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f16204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f16205e;

    public zzeg() {
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final void a(String str) {
        HashMap mapB = zzcf.b(str);
        if (mapB != null) {
            this.f16202b = (Long) mapB.get(0);
            this.f16203c = (Long) mapB.get(1);
            this.f16204d = (Long) mapB.get(2);
            this.f16205e = (Long) mapB.get(3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Long> c() {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, this.f16202b);
        map.put(1, this.f16203c);
        map.put(2, this.f16204d);
        map.put(3, this.f16205e);
        return map;
    }

    public zzeg(String str) {
        a(str);
    }
}
