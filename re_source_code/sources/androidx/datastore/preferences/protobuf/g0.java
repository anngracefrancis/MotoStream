package androidx.datastore.preferences.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ListFieldSchema.java */
/* JADX INFO: loaded from: classes.dex */
abstract class g0 {
    private static final g0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g0 f1296b;

    /* JADX INFO: compiled from: ListFieldSchema.java */
    private static final class b extends g0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Class<?> f1297c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private b() {
            super();
        }

        static <E> List<E> f(Object obj, long j2) {
            return (List) p1.A(obj, j2);
        }

        private static <L> List<L> g(Object obj, long j2, int i2) {
            Object obj2;
            List<L> listJ;
            List<L> listF = f(obj, j2);
            if (listF.isEmpty()) {
                if (listF instanceof f0) {
                    listJ = new e0(i2);
                } else {
                    listJ = ((listF instanceof z0) && (listF instanceof a0.i)) ? ((a0.i) listF).J(i2) : new ArrayList<>(i2);
                }
                p1.O(obj, j2, listJ);
                return listJ;
            }
            if (f1297c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + i2);
                arrayList.addAll(listF);
                p1.O(obj, j2, arrayList);
                obj2 = arrayList;
            } else {
                if (!(listF instanceof o1)) {
                    if (!(listF instanceof z0) || !(listF instanceof a0.i)) {
                        return listF;
                    }
                    a0.i iVar = (a0.i) listF;
                    if (iVar.l1()) {
                        return listF;
                    }
                    a0.i iVarJ = iVar.J(listF.size() + i2);
                    p1.O(obj, j2, iVarJ);
                    return iVarJ;
                }
                e0 e0Var = new e0(listF.size() + i2);
                e0Var.addAll((o1) listF);
                p1.O(obj, j2, e0Var);
                obj2 = e0Var;
            }
            return (List<L>) obj2;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        void c(Object obj, long j2) {
            Object objUnmodifiableList;
            List list = (List) p1.A(obj, j2);
            if (list instanceof f0) {
                objUnmodifiableList = ((f0) list).k();
            } else {
                if (f1297c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof z0) && (list instanceof a0.i)) {
                    a0.i iVar = (a0.i) list;
                    if (iVar.l1()) {
                        iVar.B();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            p1.O(obj, j2, objUnmodifiableList);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        <E> void d(Object obj, Object obj2, long j2) {
            List listF = f(obj2, j2);
            List listG = g(obj, j2, listF.size());
            int size = listG.size();
            int size2 = listF.size();
            if (size > 0 && size2 > 0) {
                listG.addAll(listF);
            }
            if (size > 0) {
                listF = listG;
            }
            p1.O(obj, j2, listF);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        <L> List<L> e(Object obj, long j2) {
            return g(obj, j2, 10);
        }
    }

    /* JADX INFO: compiled from: ListFieldSchema.java */
    private static final class c extends g0 {
        private c() {
            super();
        }

        static <E> a0.i<E> f(Object obj, long j2) {
            return (a0.i) p1.A(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        void c(Object obj, long j2) {
            f(obj, j2).B();
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        <E> void d(Object obj, Object obj2, long j2) {
            a0.i iVarF = f(obj, j2);
            a0.i iVarF2 = f(obj2, j2);
            int size = iVarF.size();
            int size2 = iVarF2.size();
            if (size > 0 && size2 > 0) {
                if (!iVarF.l1()) {
                    iVarF = iVarF.J(size2 + size);
                }
                iVarF.addAll(iVarF2);
            }
            if (size > 0) {
                iVarF2 = iVarF;
            }
            p1.O(obj, j2, iVarF2);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        <L> List<L> e(Object obj, long j2) {
            a0.i iVarF = f(obj, j2);
            if (iVarF.l1()) {
                return iVarF;
            }
            int size = iVarF.size();
            a0.i iVarJ = iVarF.J(size == 0 ? 10 : size * 2);
            p1.O(obj, j2, iVarJ);
            return iVarJ;
        }
    }

    static {
        a = new b();
        f1296b = new c();
    }

    static g0 a() {
        return a;
    }

    static g0 b() {
        return f1296b;
    }

    abstract void c(Object obj, long j2);

    abstract <L> void d(Object obj, Object obj2, long j2);

    abstract <L> List<L> e(Object obj, long j2);

    private g0() {
    }
}
