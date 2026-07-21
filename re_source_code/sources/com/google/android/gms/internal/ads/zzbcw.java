package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbcw {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbdf f14353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ViewGroup f14354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbcq f14355d;

    public zzbcw(Context context, ViewGroup viewGroup, zzbgz zzbgzVar) {
        this(context, viewGroup, zzbgzVar, null);
    }

    public final void a() {
        Preconditions.f("onDestroy must be called from the UI thread.");
        zzbcq zzbcqVar = this.f14355d;
        if (zzbcqVar != null) {
            zzbcqVar.j();
            this.f14354c.removeView(this.f14355d);
            this.f14355d = null;
        }
    }

    public final void b() {
        Preconditions.f("onPause must be called from the UI thread.");
        zzbcq zzbcqVar = this.f14355d;
        if (zzbcqVar != null) {
            zzbcqVar.k();
        }
    }

    public final void c(int i2, int i3, int i4, int i5, int i6, boolean z, zzbde zzbdeVar) {
        if (this.f14355d != null) {
            return;
        }
        zzadb.a(this.f14353b.n().c(), this.f14353b.P(), "vpr2");
        Context context = this.a;
        zzbdf zzbdfVar = this.f14353b;
        zzbcq zzbcqVar = new zzbcq(context, zzbdfVar, i6, z, zzbdfVar.n().c(), zzbdeVar);
        this.f14355d = zzbcqVar;
        this.f14354c.addView(zzbcqVar, 0, new ViewGroup.LayoutParams(-1, -1));
        this.f14355d.w(i2, i3, i4, i5);
        this.f14353b.v0(false);
    }

    public final void d(int i2, int i3, int i4, int i5) {
        Preconditions.f("The underlay may only be modified from the UI thread.");
        zzbcq zzbcqVar = this.f14355d;
        if (zzbcqVar != null) {
            zzbcqVar.w(i2, i3, i4, i5);
        }
    }

    public final zzbcq e() {
        Preconditions.f("getAdVideoUnderlay must be called from the UI thread.");
        return this.f14355d;
    }

    @VisibleForTesting
    private zzbcw(Context context, ViewGroup viewGroup, zzbdf zzbdfVar, zzbcq zzbcqVar) {
        this.a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f14354c = viewGroup;
        this.f14353b = zzbdfVar;
        this.f14355d = null;
    }
}
