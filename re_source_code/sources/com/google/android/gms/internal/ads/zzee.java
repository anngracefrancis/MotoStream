package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzee extends zzcf<Integer, Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f16192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f16193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f16194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f16195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f16196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f16197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f16198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f16199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f16200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f16201k;
    public Long l;

    public zzee() {
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final void a(String str) {
        HashMap mapB = zzcf.b(str);
        if (mapB != null) {
            this.f16192b = (Long) mapB.get(0);
            this.f16193c = (Long) mapB.get(1);
            this.f16194d = (Long) mapB.get(2);
            this.f16195e = (Long) mapB.get(3);
            this.f16196f = (Long) mapB.get(4);
            this.f16197g = (Long) mapB.get(5);
            this.f16198h = (Long) mapB.get(6);
            this.f16199i = (Long) mapB.get(7);
            this.f16200j = (Long) mapB.get(8);
            this.f16201k = (Long) mapB.get(9);
            this.l = (Long) mapB.get(10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Long> c() {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, this.f16192b);
        map.put(1, this.f16193c);
        map.put(2, this.f16194d);
        map.put(3, this.f16195e);
        map.put(4, this.f16196f);
        map.put(5, this.f16197g);
        map.put(6, this.f16198h);
        map.put(7, this.f16199i);
        map.put(8, this.f16200j);
        map.put(9, this.f16201k);
        map.put(10, this.l);
        return map;
    }

    public zzee(String str) {
        a(str);
    }
}
