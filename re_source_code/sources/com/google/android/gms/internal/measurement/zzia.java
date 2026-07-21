package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzia extends AbstractList<String> implements zzfv, RandomAccess {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzfv f17434f;

    public zzia(zzfv zzfvVar) {
        this.f17434f = zzfvVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzfv
    public final List<?> b() {
        return this.f17434f.b();
    }

    @Override // com.google.android.gms.internal.measurement.zzfv
    public final Object e(int i2) {
        return this.f17434f.e(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return (String) this.f17434f.get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new l4(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i2) {
        return new j4(this, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzfv
    public final void n1(zzdu zzduVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17434f.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzfv
    public final zzfv y0() {
        return this;
    }
}
