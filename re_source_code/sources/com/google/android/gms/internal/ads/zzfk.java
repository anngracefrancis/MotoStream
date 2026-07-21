package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzfk implements Callable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f16220f = getClass().getSimpleName();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final zzdy f16221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f16222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f16223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final zzbp.zza.C0176zza f16224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected Method f16225k;
    private final int l;
    private final int m;

    public zzfk(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3) {
        this.f16221g = zzdyVar;
        this.f16222h = str;
        this.f16223i = str2;
        this.f16224j = c0176zza;
        this.l = i2;
        this.m = i3;
    }

    protected abstract void a() throws IllegalAccessException, InvocationTargetException;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        int i2;
        try {
            long jNanoTime = System.nanoTime();
            Method methodP = this.f16221g.p(this.f16222h, this.f16223i);
            this.f16225k = methodP;
            if (methodP == null) {
                return null;
            }
            a();
            zzda zzdaVarW = this.f16221g.w();
            if (zzdaVarW != null && (i2 = this.l) != Integer.MIN_VALUE) {
                zzdaVarW.b(this.m, i2, (System.nanoTime() - jNanoTime) / 1000);
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return null;
    }
}
