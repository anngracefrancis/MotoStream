package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcbw extends zzajb implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzadv {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f15024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzaar f15025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzbyn f15026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15027i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f15028j = false;

    public zzcbw(zzbyn zzbynVar, zzbyt zzbytVar) {
        this.f15024f = zzbytVar.z();
        this.f15025g = zzbytVar.m();
        this.f15026h = zzbynVar;
        if (zzbytVar.A() != null) {
            zzbytVar.A().D(this);
        }
    }

    private static void h7(zzajc zzajcVar, int i2) {
        try {
            zzajcVar.i2(i2);
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    private final void i7() {
        View view = this.f15024f;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f15024f);
        }
    }

    private final void j7() {
        View view;
        zzbyn zzbynVar = this.f15026h;
        if (zzbynVar == null || (view = this.f15024f) == null) {
            return;
        }
        zzbynVar.u(view, Collections.emptyMap(), Collections.emptyMap(), zzbyn.D(this.f15024f));
    }

    @Override // com.google.android.gms.internal.ads.zzaja
    public final void destroy() throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        i7();
        zzbyn zzbynVar = this.f15026h;
        if (zzbynVar != null) {
            zzbynVar.a();
        }
        this.f15026h = null;
        this.f15024f = null;
        this.f15025g = null;
        this.f15027i = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaja
    public final zzaar getVideoController() throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        if (!this.f15027i) {
            return this.f15025g;
        }
        zzbad.g("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    final /* synthetic */ void k7() {
        try {
            destroy();
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaja
    public final void m6(IObjectWrapper iObjectWrapper, zzajc zzajcVar) throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        if (this.f15027i) {
            zzbad.g("Instream ad is destroyed already.");
            h7(zzajcVar, 2);
            return;
        }
        View view = this.f15024f;
        if (view == null || this.f15025g == null) {
            String str = view == null ? "can not get video view." : "can not get video controller.";
            zzbad.g(str.length() != 0 ? "Instream internal error: ".concat(str) : new String("Instream internal error: "));
            h7(zzajcVar, 0);
            return;
        }
        if (this.f15028j) {
            zzbad.g("Instream ad should not be used again.");
            h7(zzajcVar, 1);
            return;
        }
        this.f15028j = true;
        i7();
        ((ViewGroup) ObjectWrapper.k0(iObjectWrapper)).addView(this.f15024f, new ViewGroup.LayoutParams(-1, -1));
        zzk.zzmd();
        zzbbz.a(this.f15024f, this);
        zzk.zzmd();
        zzbbz.b(this.f15024f, this);
        j7();
        try {
            zzajcVar.c7();
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        j7();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        j7();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void p5() {
        zzaxi.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.hh

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcbw f12714f;

            {
                this.f12714f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12714f.k7();
            }
        });
    }
}
