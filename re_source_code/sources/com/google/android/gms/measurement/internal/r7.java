package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzmd;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class r7 {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbr.zza f17938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BitSet f17939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BitSet f17940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<Integer, Long> f17941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<Integer, List<Long>> f17942f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ q7 f17943g;

    private r7(q7 q7Var, String str) {
        this.f17943g = q7Var;
        this.a = str;
        this.f17938b = (zzbr.zza) ((zzfd) zzbr.zza.Q().C(true).y());
        this.f17939c = new BitSet();
        this.f17940d = new BitSet();
        this.f17941e = new c.e.a();
        this.f17942f = new c.e.a();
    }

    private final List<zzbr.zzb> c() {
        if (this.f17941e == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f17941e.size());
        Iterator<Integer> it = this.f17941e.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            arrayList.add((zzbr.zzb) ((zzfd) zzbr.zzb.J().w(iIntValue).A(this.f17941e.get(Integer.valueOf(iIntValue)).longValue()).y()));
        }
        return arrayList;
    }

    private static List<zzbr.zzj> d(List<zzbr.zzj> list, List<zzbr.zzj> list2, List<Integer> list3) {
        if (list.isEmpty()) {
            return list2;
        }
        ArrayList arrayList = new ArrayList(list2);
        c.e.a aVar = new c.e.a();
        for (zzbr.zzj zzjVar : list) {
            if (zzjVar.I() && zzjVar.M() > 0) {
                aVar.put(Integer.valueOf(zzjVar.J()), Long.valueOf(zzjVar.B(zzjVar.M() - 1)));
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            zzbr.zzj zzjVar2 = (zzbr.zzj) arrayList.get(i2);
            Long l = (Long) aVar.remove(zzjVar2.I() ? Integer.valueOf(zzjVar2.J()) : null);
            if (l != null && (list3 == null || !list3.contains(Integer.valueOf(zzjVar2.J())))) {
                ArrayList arrayList2 = new ArrayList();
                if (l.longValue() < zzjVar2.B(0)) {
                    arrayList2.add(l);
                }
                arrayList2.addAll(zzjVar2.L());
                arrayList.set(i2, (zzbr.zzj) ((zzfd) zzjVar2.v().w().C(arrayList2).y()));
            }
        }
        for (Integer num : aVar.keySet()) {
            arrayList.add((zzbr.zzj) ((zzfd) zzbr.zzj.N().A(num.intValue()).B(((Long) aVar.get(num)).longValue()).y()));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.internal.measurement.zzbr$zza$zza, com.google.android.gms.internal.measurement.zzfd$zzb] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.google.android.gms.internal.measurement.zzbr$zzi$zza] */
    final zzbr.zza a(int i2, boolean z, List<Integer> list) {
        ?? arrayList;
        zzbr.zza zzaVar = this.f17938b;
        ?? Q = zzaVar == null ? zzbr.zza.Q() : zzaVar.v();
        Q.w(i2);
        ?? B = zzbr.zzi.a0().E(zzkg.F(this.f17939c)).B(zzkg.F(this.f17940d));
        B.F(c());
        if (this.f17942f == null) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList(this.f17942f.size());
            for (Integer num : this.f17942f.keySet()) {
                zzbr.zzj.zza zzaVarA = zzbr.zzj.N().A(num.intValue());
                List<Long> list2 = this.f17942f.get(num);
                if (list2 != null) {
                    Collections.sort(list2);
                    Iterator<Long> it = list2.iterator();
                    while (it.hasNext()) {
                        zzaVarA.B(it.next().longValue());
                    }
                }
                arrayList.add((zzbr.zzj) ((zzfd) zzaVarA.y()));
            }
        }
        ?? D = arrayList;
        if (Q.D() && (!zzmd.b() || !this.f17943g.n().y(this.a, zzap.D0) || !z)) {
            D = arrayList;
            D = d(Q.E().X(), arrayList, list);
        }
        B.G(D);
        Q.A(B);
        return (zzbr.zza) ((zzfd) Q.y());
    }

    final void e(zzbr.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map) {
        this.f17939c = bitSet;
        this.f17940d = bitSet2;
        this.f17941e = map;
        zzbr.zzi.zza zzaVarB = zzbr.zzi.a0().E(zzkg.F(bitSet)).B(zzkg.F(bitSet2));
        zzaVarB.F(c());
        this.f17938b = (zzbr.zza) ((zzfd) zzbr.zza.Q().C(false).B(zziVar).A(zzaVarB).y());
    }

    final void f(w7 w7Var) {
        int iA = w7Var.a();
        Boolean bool = w7Var.f18010c;
        if (bool != null) {
            this.f17940d.set(iA, bool.booleanValue());
        }
        Boolean bool2 = w7Var.f18011d;
        if (bool2 != null) {
            this.f17939c.set(iA, bool2.booleanValue());
        }
        if (w7Var.f18012e != null) {
            Long l = this.f17941e.get(Integer.valueOf(iA));
            long jLongValue = w7Var.f18012e.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.f17941e.put(Integer.valueOf(iA), Long.valueOf(jLongValue));
            }
        }
        if (w7Var.f18013f != null) {
            List<Long> arrayList = this.f17942f.get(Integer.valueOf(iA));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f17942f.put(Integer.valueOf(iA), arrayList);
            }
            arrayList.add(Long.valueOf(w7Var.f18013f.longValue() / 1000));
        }
    }

    /* synthetic */ r7(q7 q7Var, String str, s7 s7Var) {
        this(q7Var, str);
    }
}
