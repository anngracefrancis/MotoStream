package com.google.android.gms.internal.common;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class c extends zzag {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final transient int f17063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final transient int f17064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ zzag f17065j;

    c(zzag zzagVar, int i2, int i3) {
        this.f17065j = zzagVar;
        this.f17063h = i2;
        this.f17064i = i3;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final int f() {
        return this.f17065j.g() + this.f17063h + this.f17064i;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final int g() {
        return this.f17065j.g() + this.f17063h;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzs.a(i2, this.f17064i, "index");
        return this.f17065j.get(i2 + this.f17063h);
    }

    @Override // com.google.android.gms.internal.common.zzac
    final boolean n() {
        return true;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final Object[] o() {
        return this.f17065j.o();
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* JADX INFO: renamed from: q */
    public final zzag subList(int i2, int i3) {
        zzs.c(i2, i3, this.f17064i);
        zzag zzagVar = this.f17065j;
        int i4 = this.f17063h;
        return zzagVar.subList(i2 + i4, i3 + i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17064i;
    }

    @Override // com.google.android.gms.internal.common.zzag, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i2, int i3) {
        return subList(i2, i3);
    }
}
