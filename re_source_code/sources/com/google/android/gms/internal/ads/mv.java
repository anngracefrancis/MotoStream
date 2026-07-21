package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class mv extends kv {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Class<?> f12996c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private mv() {
        super();
    }

    private static <L> List<L> f(Object obj, long j2, int i2) {
        Object obj2;
        List<L> listN;
        List<L> listG = g(obj, j2);
        if (listG.isEmpty()) {
            if (listG instanceof zzdot) {
                listN = new zzdos(i2);
            } else {
                listN = ((listG instanceof fw) && (listG instanceof zzdoj)) ? ((zzdoj) listG).N(i2) : new ArrayList<>(i2);
            }
            gx.g(obj, j2, listN);
            return listN;
        }
        if (f12996c.isAssignableFrom(listG.getClass())) {
            ArrayList arrayList = new ArrayList(listG.size() + i2);
            arrayList.addAll(listG);
            gx.g(obj, j2, arrayList);
            obj2 = arrayList;
        } else {
            if (!(listG instanceof zzdqw)) {
                if (!(listG instanceof fw) || !(listG instanceof zzdoj)) {
                    return listG;
                }
                zzdoj zzdojVar = (zzdoj) listG;
                if (zzdojVar.m0()) {
                    return listG;
                }
                zzdoj zzdojVarN = zzdojVar.N(listG.size() + i2);
                gx.g(obj, j2, zzdojVarN);
                return zzdojVarN;
            }
            zzdos zzdosVar = new zzdos(listG.size() + i2);
            zzdosVar.addAll((zzdqw) listG);
            gx.g(obj, j2, zzdosVar);
            obj2 = zzdosVar;
        }
        return (List<L>) obj2;
    }

    private static <E> List<E> g(Object obj, long j2) {
        return (List) gx.L(obj, j2);
    }

    @Override // com.google.android.gms.internal.ads.kv
    final <L> List<L> a(Object obj, long j2) {
        return f(obj, j2, 10);
    }

    @Override // com.google.android.gms.internal.ads.kv
    final <E> void b(Object obj, Object obj2, long j2) {
        List listG = g(obj2, j2);
        List listF = f(obj, j2, listG.size());
        int size = listF.size();
        int size2 = listG.size();
        if (size > 0 && size2 > 0) {
            listF.addAll(listG);
        }
        if (size > 0) {
            listG = listF;
        }
        gx.g(obj, j2, listG);
    }

    @Override // com.google.android.gms.internal.ads.kv
    final void e(Object obj, long j2) {
        Object objUnmodifiableList;
        List list = (List) gx.L(obj, j2);
        if (list instanceof zzdot) {
            objUnmodifiableList = ((zzdot) list).H();
        } else {
            if (f12996c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof fw) && (list instanceof zzdoj)) {
                zzdoj zzdojVar = (zzdoj) list;
                if (zzdojVar.m0()) {
                    zzdojVar.x0();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        gx.g(obj, j2, objUnmodifiableList);
    }
}
