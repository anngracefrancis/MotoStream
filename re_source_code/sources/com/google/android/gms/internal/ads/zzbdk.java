package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(16)
public final class zzbdk {

    @VisibleForTesting
    private static int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private static int f14388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzge f14389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzhd f14390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzgn f14391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbdo f14392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final j8 f14393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final k8 f14394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final i8 f14395i;

    public zzbdk() {
        h8 h8Var = null;
        j8 j8Var = new j8(this);
        this.f14393g = j8Var;
        this.f14394h = new k8(this);
        this.f14395i = new i8(this);
        Preconditions.f("ExoPlayer must be created on the main UI thread.");
        if (zzawz.n()) {
            String strValueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 29);
            sb.append("AdExoPlayerHelper initialize ");
            sb.append(strValueOf);
            zzawz.m(sb.toString());
        }
        a++;
        zzge zzgeVarA = zzgg.a(2);
        this.f14389c = zzgeVarA;
        zzgeVarA.i(j8Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void f(String str, String str2) {
        zzbdo zzbdoVar = this.f14392f;
        if (zzbdoVar != null) {
            zzbdoVar.b(str, str2);
        }
    }

    public static int g() {
        return a;
    }

    public static int h() {
        return f14388b;
    }

    public final synchronized void a() {
        this.f14392f = null;
    }

    public final synchronized void c(zzbdo zzbdoVar) {
        this.f14392f = zzbdoVar;
    }

    public final void d(zzgh zzghVar, zzhh zzhhVar, zzgq zzgqVar) {
        this.f14393g.d(zzghVar);
        this.f14394h.i(zzhhVar);
        this.f14395i.i(zzgqVar);
    }

    public final boolean e(zzhn zzhnVar) {
        if (this.f14389c == null) {
            return false;
        }
        Handler handler = zzaxi.a;
        this.f14390d = new zzhd(zzhnVar, 1, 0L, handler, this.f14394h, -1);
        zzgn zzgnVar = new zzgn(zzhnVar, handler, this.f14395i);
        this.f14391e = zzgnVar;
        this.f14389c.k(this.f14390d, zzgnVar);
        f14388b++;
        return true;
    }

    public final void finalize() throws Throwable {
        a--;
        if (zzawz.n()) {
            String strValueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 27);
            sb.append("AdExoPlayerHelper finalize ");
            sb.append(strValueOf);
            zzawz.m(sb.toString());
        }
    }

    public final void i() {
        zzge zzgeVar = this.f14389c;
        if (zzgeVar != null) {
            zzgeVar.c();
            this.f14389c = null;
            f14388b--;
        }
    }

    public final zzge j() {
        return this.f14389c;
    }

    public final zzhd k() {
        return this.f14390d;
    }

    public final zzgn l() {
        return this.f14391e;
    }
}
