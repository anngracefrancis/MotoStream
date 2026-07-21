package kotlin.reflect.y.internal.j0.e.a0.b;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.a0.a;

/* JADX INFO: compiled from: JvmNameResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final List<a.e.c> a(List<a.e.c> list) {
        m.f(list, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(list.size());
        for (a.e.c cVar : list) {
            int iF = cVar.F();
            for (int i2 = 0; i2 < iF; i2++) {
                arrayList.add(cVar);
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
