package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbzc {
    public static final zzbzc a = new zzbze().b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzafl f14893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzafi f14894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzafx f14895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzafu f14896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzaje f14897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c.e.g<String, zzafr> f14898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c.e.g<String, zzafo> f14899h;

    private zzbzc(zzbze zzbzeVar) {
        this.f14893b = zzbzeVar.a;
        this.f14894c = zzbzeVar.f14900b;
        this.f14895d = zzbzeVar.f14901c;
        this.f14898g = new c.e.g<>(zzbzeVar.f14904f);
        this.f14899h = new c.e.g<>(zzbzeVar.f14905g);
        this.f14896e = zzbzeVar.f14902d;
        this.f14897f = zzbzeVar.f14903e;
    }

    public final zzafl a() {
        return this.f14893b;
    }

    public final zzafi b() {
        return this.f14894c;
    }

    public final zzafx c() {
        return this.f14895d;
    }

    public final zzafu d() {
        return this.f14896e;
    }

    public final zzaje e() {
        return this.f14897f;
    }

    public final ArrayList<String> f() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.f14895d != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.f14893b != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.f14894c != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.f14898g.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.f14897f != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> g() {
        ArrayList<String> arrayList = new ArrayList<>(this.f14898g.size());
        for (int i2 = 0; i2 < this.f14898g.size(); i2++) {
            arrayList.add(this.f14898g.j(i2));
        }
        return arrayList;
    }

    public final zzafr h(String str) {
        return this.f14898g.get(str);
    }

    public final zzafo i(String str) {
        return this.f14899h.get(str);
    }
}
