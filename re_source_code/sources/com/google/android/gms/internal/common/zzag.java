package com.google.android.gms.internal.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.jspecify.nullness.NullMarked;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
@NullMarked
public abstract class zzag extends zzac implements List, RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final zzak f17074g = new b(d.f17066h, 0);

    zzag() {
    }

    static zzag r(Object[] objArr, int i2) {
        return i2 == 0 ? d.f17066h : new d(objArr, i2);
    }

    public static zzag s(Collection collection) {
        if (!(collection instanceof zzac)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzah.a(array, length);
            return r(array, length);
        }
        zzag zzagVarH = ((zzac) collection).h();
        if (!zzagVarH.n()) {
            return zzagVarH;
        }
        Object[] array2 = zzagVarH.toArray();
        return r(array2, array2.length);
    }

    public static zzag t() {
        return d.f17066h;
    }

    public static zzag u(Object obj) {
        Object[] objArr = {obj};
        zzah.a(objArr, 1);
        return r(objArr, 1);
    }

    public static zzag v(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzah.a(objArr, 2);
        return r(objArr, 2);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.common.zzac
    int c(Object[] objArr, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i3] = get(i3);
        }
        return size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i2 = 0; i2 < size; i2++) {
                        if (zzr.a(get(i2), list.get(i2))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (it.hasNext()) {
                    if (it2.hasNext() && zzr.a(it.next(), it2.next())) {
                    }
                }
                if (!it2.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.common.zzac
    @Deprecated
    public final zzag h() {
        return this;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i2 = 0; i2 < size; i2++) {
            iHashCode = (iHashCode * 31) + get(i2).hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.common.zzac
    /* JADX INFO: renamed from: i */
    public final zzaj iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (obj.equals(get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.zzac, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public zzag subList(int i2, int i3) {
        zzs.c(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        return i4 == 0 ? d.f17066h : new c(this, i2, i4);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public final zzak listIterator(int i2) {
        zzs.b(i2, size(), "index");
        return isEmpty() ? f17074g : new b(this, i2);
    }
}
