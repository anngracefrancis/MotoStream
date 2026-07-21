package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes2.dex */
public class zzda {
    private static final ConditionVariable a = new ConditionVariable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static volatile zzwo f15816b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Random f15817c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzdy f15818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected volatile Boolean f15819e;

    public zzda(zzdy zzdyVar) {
        this.f15818d = zzdyVar;
        zzdyVar.r().execute(new ar(this));
    }

    public static int d() {
        try {
            return Build.VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : e().nextInt();
        } catch (RuntimeException unused) {
            return e().nextInt();
        }
    }

    private static Random e() {
        if (f15817c == null) {
            synchronized (zzda.class) {
                if (f15817c == null) {
                    f15817c = new Random();
                }
            }
        }
        return f15817c;
    }

    public final void b(int i2, int i3, long j2) {
        c(i2, i3, j2, null);
    }

    public final void c(int i2, int i3, long j2, Exception exc) {
        try {
            a.block();
            if (!this.f15819e.booleanValue() || f15816b == null) {
                return;
            }
            zzbi.zza.C0174zza c0174zzaU = zzbi.zza.F().v(this.f15818d.f16182b.getPackageName()).u(j2);
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                zzdmb.a(exc, new PrintWriter(stringWriter));
                c0174zzaU.w(stringWriter.toString()).A(exc.getClass().getName());
            }
            zzws zzwsVarA = f15816b.a(((zzbi.zza) ((zzdob) c0174zzaU.p0())).g());
            zzwsVarA.b(i2);
            if (i3 != -1) {
                zzwsVarA.a(i3);
            }
            zzwsVarA.c();
        } catch (Exception unused) {
        }
    }
}
