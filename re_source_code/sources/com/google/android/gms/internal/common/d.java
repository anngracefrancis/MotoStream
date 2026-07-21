package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
@NullMarked
final class d extends zzag {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final zzag f17066h = new d(new Object[0], 0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final transient Object[] f17067i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final transient int f17068j;

    d(Object[] objArr, int i2) {
        this.f17067i = objArr;
        this.f17068j = i2;
    }

    @Override // com.google.android.gms.internal.common.zzag, com.google.android.gms.internal.common.zzac
    final int c(Object[] objArr, int i2) {
        System.arraycopy(this.f17067i, 0, objArr, 0, this.f17068j);
        return this.f17068j;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final int f() {
        return this.f17068j;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final int g() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzs.a(i2, this.f17068j, "index");
        Object obj = this.f17067i[i2];
        obj.getClass();
        return obj;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final boolean n() {
        return false;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final Object[] o() {
        return this.f17067i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17068j;
    }
}
