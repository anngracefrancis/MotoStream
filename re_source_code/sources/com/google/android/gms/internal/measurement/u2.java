package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class u2 extends s2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Class<?> f17262c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private u2() {
        super();
    }

    private static <L> List<L> f(Object obj, long j2, int i2) {
        Object obj2;
        List<L> listD;
        List<L> listG = g(obj, j2);
        if (listG.isEmpty()) {
            if (listG instanceof zzfv) {
                listD = new zzfw(i2);
            } else {
                listD = ((listG instanceof m3) && (listG instanceof zzfl)) ? ((zzfl) listG).d(i2) : new ArrayList<>(i2);
            }
            k4.j(obj, j2, listD);
            return listD;
        }
        if (f17262c.isAssignableFrom(listG.getClass())) {
            ArrayList arrayList = new ArrayList(listG.size() + i2);
            arrayList.addAll(listG);
            k4.j(obj, j2, arrayList);
            obj2 = arrayList;
        } else {
            if (!(listG instanceof zzia)) {
                if (!(listG instanceof m3) || !(listG instanceof zzfl)) {
                    return listG;
                }
                zzfl zzflVar = (zzfl) listG;
                if (zzflVar.a()) {
                    return listG;
                }
                zzfl zzflVarD = zzflVar.d(listG.size() + i2);
                k4.j(obj, j2, zzflVarD);
                return zzflVarD;
            }
            zzfw zzfwVar = new zzfw(listG.size() + i2);
            zzfwVar.addAll((zzia) listG);
            k4.j(obj, j2, zzfwVar);
            obj2 = zzfwVar;
        }
        return (List<L>) obj2;
    }

    private static <E> List<E> g(Object obj, long j2) {
        return (List) k4.F(obj, j2);
    }

    @Override // com.google.android.gms.internal.measurement.s2
    final <L> List<L> b(Object obj, long j2) {
        return f(obj, j2, 10);
    }

    @Override // com.google.android.gms.internal.measurement.s2
    final <E> void c(Object obj, Object obj2, long j2) {
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
        k4.j(obj, j2, listG);
    }

    @Override // com.google.android.gms.internal.measurement.s2
    final void e(Object obj, long j2) {
        Object objUnmodifiableList;
        List list = (List) k4.F(obj, j2);
        if (list instanceof zzfv) {
            objUnmodifiableList = ((zzfv) list).y0();
        } else {
            if (f17262c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof m3) && (list instanceof zzfl)) {
                zzfl zzflVar = (zzfl) list;
                if (zzflVar.a()) {
                    zzflVar.I();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        k4.j(obj, j2, objUnmodifiableList);
    }
}
