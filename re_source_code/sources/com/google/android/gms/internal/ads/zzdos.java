package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdos extends yt<String> implements zzdot, RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final zzdos f16046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final zzdot f16047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<Object> f16048i;

    static {
        zzdos zzdosVar = new zzdos();
        f16046g = zzdosVar;
        zzdosVar.x0();
        f16047h = zzdosVar;
    }

    public zzdos() {
        this(10);
    }

    private static String f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof zzdmr ? ((zzdmr) obj).n() : zzdod.f((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final zzdot H() {
        return m0() ? new zzdqw(this) : this;
    }

    @Override // com.google.android.gms.internal.ads.zzdoj
    public final /* synthetic */ zzdoj N(int i2) {
        if (i2 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i2);
        arrayList.addAll(this.f16048i);
        return new zzdos((ArrayList<Object>) arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        c();
        this.f16048i.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        c();
        this.f16048i.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f16048i.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdmr) {
            zzdmr zzdmrVar = (zzdmr) obj;
            String strN = zzdmrVar.n();
            if (zzdmrVar.o()) {
                this.f16048i.set(i2, strN);
            }
            return strN;
        }
        byte[] bArr = (byte[]) obj;
        String strF = zzdod.f(bArr);
        if (zzdod.e(bArr)) {
            this.f16048i.set(i2, strF);
        }
        return strF;
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final Object k1(int i2) {
        return this.f16048i.get(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final List<?> m() {
        return Collections.unmodifiableList(this.f16048i);
    }

    @Override // com.google.android.gms.internal.ads.yt, com.google.android.gms.internal.ads.zzdoj
    public final /* bridge */ /* synthetic */ boolean m0() {
        return super.m0();
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final void q0(zzdmr zzdmrVar) {
        c();
        this.f16048i.add(zzdmrVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        c();
        return f(this.f16048i.set(i2, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f16048i.size();
    }

    public zzdos(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection<? extends String> collection) {
        c();
        if (collection instanceof zzdot) {
            collection = ((zzdot) collection).m();
        }
        boolean zAddAll = this.f16048i.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        c();
        Object objRemove = this.f16048i.remove(i2);
        ((AbstractList) this).modCount++;
        return f(objRemove);
    }

    private zzdos(ArrayList<Object> arrayList) {
        this.f16048i = arrayList;
    }
}
