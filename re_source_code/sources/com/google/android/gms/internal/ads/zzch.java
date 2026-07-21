package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzch extends zzcf<Integer, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f15230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f15231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f15232f;

    public zzch(String str) {
        this();
        a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final void a(String str) {
        HashMap mapB = zzcf.b(str);
        if (mapB != null) {
            this.f15228b = mapB.get(0) == null ? "E" : (String) mapB.get(0);
            this.f15229c = mapB.get(1) == null ? -1L : ((Long) mapB.get(1)).longValue();
            this.f15230d = mapB.get(2) == null ? "E" : (String) mapB.get(2);
            this.f15231e = mapB.get(3) == null ? "E" : (String) mapB.get(3);
            this.f15232f = mapB.get(4) != null ? (String) mapB.get(4) : "E";
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Object> c() {
        HashMap<Integer, Object> map = new HashMap<>();
        map.put(0, this.f15228b);
        map.put(4, this.f15232f);
        map.put(3, this.f15231e);
        map.put(2, this.f15230d);
        map.put(1, Long.valueOf(this.f15229c));
        return map;
    }

    public zzch() {
        this.f15228b = "E";
        this.f15229c = -1L;
        this.f15230d = "E";
        this.f15231e = "E";
        this.f15232f = "E";
    }
}
