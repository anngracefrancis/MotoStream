package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdl extends zzcf<Integer, Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15970c;

    public zzdl() {
        this.f15969b = -1L;
        this.f15970c = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final void a(String str) {
        HashMap mapB = zzcf.b(str);
        if (mapB != null) {
            this.f15969b = ((Long) mapB.get(0)).longValue();
            this.f15970c = ((Long) mapB.get(1)).longValue();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Long> c() {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, Long.valueOf(this.f15969b));
        map.put(1, Long.valueOf(this.f15970c));
        return map;
    }

    public zzdl(String str) {
        this();
        a(str);
    }
}
