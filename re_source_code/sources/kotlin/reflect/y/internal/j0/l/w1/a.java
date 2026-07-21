package kotlin.reflect.y.internal.j0.l.w1;

import java.util.ArrayList;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends ArrayList<m> implements l {
    public a(int i2) {
        super(i2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof m) {
            return f((m) obj);
        }
        return false;
    }

    public /* bridge */ boolean f(m mVar) {
        return super.contains(mVar);
    }

    public /* bridge */ int g() {
        return super.size();
    }

    public /* bridge */ int h(m mVar) {
        return super.indexOf(mVar);
    }

    public /* bridge */ int i(m mVar) {
        return super.lastIndexOf(mVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof m) {
            return h((m) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof m) {
            return i((m) obj);
        }
        return -1;
    }

    public /* bridge */ boolean n(m mVar) {
        return super.remove(mVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof m) {
            return n((m) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return g();
    }
}
