package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdqw extends AbstractList<String> implements zzdot, RandomAccess {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdot f16057f;

    public zzdqw(zzdot zzdotVar) {
        this.f16057f = zzdotVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final zzdot H() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return (String) this.f16057f.get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new fx(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final Object k1(int i2) {
        return this.f16057f.k1(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i2) {
        return new ex(this, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final List<?> m() {
        return this.f16057f.m();
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final void q0(zzdmr zzdmrVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f16057f.size();
    }
}
