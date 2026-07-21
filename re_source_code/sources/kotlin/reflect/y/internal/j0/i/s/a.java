package kotlin.reflect.y.internal.j0.i.s;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: DeprecationInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements Comparable<a> {
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        m.f(aVar, "other");
        int iCompareTo = k().compareTo(aVar.k());
        if (iCompareTo == 0 && !q() && aVar.q()) {
            return 1;
        }
        return iCompareTo;
    }

    public abstract b k();

    public abstract boolean q();
}
