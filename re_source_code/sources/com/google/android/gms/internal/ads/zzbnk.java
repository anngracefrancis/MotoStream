package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class zzbnk {
    private final zzbpb a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f14590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcxn f14591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbgz f14592d;

    public zzbnk(View view, zzbgz zzbgzVar, zzbpb zzbpbVar, zzcxn zzcxnVar) {
        this.f14590b = view;
        this.f14592d = zzbgzVar;
        this.a = zzbpbVar;
        this.f14591c = zzcxnVar;
    }

    public zzbso a(Set<zzbuz<zzbsr>> set) {
        return new zzbso(set);
    }

    public final View b() {
        return this.f14590b;
    }

    public final zzbgz c() {
        return this.f14592d;
    }

    public final zzbpb d() {
        return this.a;
    }

    public final zzcxn e() {
        return this.f14591c;
    }
}
