package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcfk implements zzczz {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcfi f15168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Clock f15169h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<zzczs, Long> f15167f = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<zzczs, ii> f15170i = new HashMap();

    public zzcfk(zzcfi zzcfiVar, Set<ii> set, Clock clock) {
        this.f15168g = zzcfiVar;
        for (ii iiVar : set) {
            this.f15170i.put(iiVar.f12769c, iiVar);
        }
        this.f15169h = clock;
    }

    private final void a(zzczs zzczsVar, boolean z) {
        zzczs zzczsVar2 = this.f15170i.get(zzczsVar).f12768b;
        String str = z ? "s." : "f.";
        if (this.f15167f.containsKey(zzczsVar2)) {
            long jB = this.f15169h.b() - this.f15167f.get(zzczsVar2).longValue();
            Map<String, String> mapC = this.f15168g.c();
            String strValueOf = String.valueOf(this.f15170i.get(zzczsVar).a);
            String strConcat = strValueOf.length() != 0 ? "label.".concat(strValueOf) : new String("label.");
            String strValueOf2 = String.valueOf(Long.toString(jB));
            mapC.put(strConcat, strValueOf2.length() != 0 ? str.concat(strValueOf2) : new String(str));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void b(zzczs zzczsVar, String str, Throwable th) {
        if (this.f15167f.containsKey(zzczsVar)) {
            long jB = this.f15169h.b() - this.f15167f.get(zzczsVar).longValue();
            Map<String, String> mapC = this.f15168g.c();
            String strValueOf = String.valueOf(str);
            String strConcat = strValueOf.length() != 0 ? "task.".concat(strValueOf) : new String("task.");
            String strValueOf2 = String.valueOf(Long.toString(jB));
            mapC.put(strConcat, strValueOf2.length() != 0 ? "f.".concat(strValueOf2) : new String("f."));
        }
        if (this.f15170i.containsKey(zzczsVar)) {
            a(zzczsVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void c(zzczs zzczsVar, String str) {
        if (this.f15167f.containsKey(zzczsVar)) {
            long jB = this.f15169h.b() - this.f15167f.get(zzczsVar).longValue();
            Map<String, String> mapC = this.f15168g.c();
            String strValueOf = String.valueOf(str);
            String strConcat = strValueOf.length() != 0 ? "task.".concat(strValueOf) : new String("task.");
            String strValueOf2 = String.valueOf(Long.toString(jB));
            mapC.put(strConcat, strValueOf2.length() != 0 ? "s.".concat(strValueOf2) : new String("s."));
        }
        if (this.f15170i.containsKey(zzczsVar)) {
            a(zzczsVar, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void d(zzczs zzczsVar, String str) {
        this.f15167f.put(zzczsVar, Long.valueOf(this.f15169h.b()));
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void e(zzczs zzczsVar, String str) {
    }
}
