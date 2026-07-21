package org.parceler.g;

import android.os.Parcel;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: CollectionParcelConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d<T, C extends Collection<T>> implements org.parceler.f<Collection<T>, C> {
    public abstract C c();

    @Override // org.parceler.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public C a(Parcel parcel) {
        int i2 = parcel.readInt();
        if (i2 == -1) {
            return null;
        }
        C c2 = (C) c();
        for (int i3 = 0; i3 < i2; i3++) {
            c2.add(e(parcel));
        }
        return c2;
    }

    public abstract T e(Parcel parcel);

    public abstract void f(T t, Parcel parcel);

    @Override // org.parceler.f
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void b(Collection<T> collection, Parcel parcel) {
        if (collection == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            f(it.next(), parcel);
        }
    }
}
