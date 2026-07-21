package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcae implements zzbzb {
    private final zzana a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzand f14960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzang f14961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbrt f14962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbri f14963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f14964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcxm f14965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbai f14966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzcxv f14967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14968j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14969k = false;

    public zzcae(zzana zzanaVar, zzand zzandVar, zzang zzangVar, zzbrt zzbrtVar, zzbri zzbriVar, Context context, zzcxm zzcxmVar, zzbai zzbaiVar, zzcxv zzcxvVar) {
        this.a = zzanaVar;
        this.f14960b = zzandVar;
        this.f14961c = zzangVar;
        this.f14962d = zzbrtVar;
        this.f14963e = zzbriVar;
        this.f14964f = context;
        this.f14965g = zzcxmVar;
        this.f14966h = zzbaiVar;
        this.f14967i = zzcxvVar;
    }

    private final void o(View view) {
        try {
            zzang zzangVar = this.f14961c;
            if (zzangVar != null && !zzangVar.M()) {
                this.f14961c.N(ObjectWrapper.E0(view));
                this.f14963e.onAdClicked();
                return;
            }
            zzana zzanaVar = this.a;
            if (zzanaVar != null && !zzanaVar.M()) {
                this.a.N(ObjectWrapper.E0(view));
                this.f14963e.onAdClicked();
                return;
            }
            zzand zzandVar = this.f14960b;
            if (zzandVar == null || zzandVar.M()) {
                return;
            }
            this.f14960b.N(ObjectWrapper.E0(view));
            this.f14963e.onAdClicked();
        } catch (RemoteException e2) {
            zzbad.d("Failed to call handleClick", e2);
        }
    }

    private static HashMap<String, View> p(Map<String, WeakReference<View>> map) {
        HashMap<String, View> map2 = new HashMap<>();
        if (map == null) {
            return map2;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    map2.put(entry.getKey(), view);
                }
            }
        }
        return map2;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void G0(zzaag zzaagVar) {
        zzbad.i("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void W() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper iObjectWrapperE0 = ObjectWrapper.E0(view);
            HashMap<String, View> mapP = p(map);
            HashMap<String, View> mapP2 = p(map2);
            zzang zzangVar = this.f14961c;
            if (zzangVar != null) {
                zzangVar.D(iObjectWrapperE0, ObjectWrapper.E0(mapP), ObjectWrapper.E0(mapP2));
                return;
            }
            zzana zzanaVar = this.a;
            if (zzanaVar != null) {
                zzanaVar.D(iObjectWrapperE0, ObjectWrapper.E0(mapP), ObjectWrapper.E0(mapP2));
                this.a.C0(iObjectWrapperE0);
                return;
            }
            zzand zzandVar = this.f14960b;
            if (zzandVar != null) {
                zzandVar.D(iObjectWrapperE0, ObjectWrapper.E0(mapP), ObjectWrapper.E0(mapP2));
                this.f14960b.C0(iObjectWrapperE0);
            }
        } catch (RemoteException e2) {
            zzbad.d("Failed to call trackView", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void b(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void c(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void d() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void d0(zzagd zzagdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void destroy() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void e(View view, Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper iObjectWrapperE0 = ObjectWrapper.E0(view);
            zzang zzangVar = this.f14961c;
            if (zzangVar != null) {
                zzangVar.A(iObjectWrapperE0);
                return;
            }
            zzana zzanaVar = this.a;
            if (zzanaVar != null) {
                zzanaVar.A(iObjectWrapperE0);
                return;
            }
            zzand zzandVar = this.f14960b;
            if (zzandVar != null) {
                zzandVar.A(iObjectWrapperE0);
            }
        } catch (RemoteException e2) {
            zzbad.d("Failed to call untrackView", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void e0(zzaak zzaakVar) {
        zzbad.i("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void f(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void g(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void h(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (this.f14969k && this.f14965g.D) {
            return;
        }
        o(view);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void i(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void j(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        try {
            boolean z = this.f14968j;
            if (!z && this.f14965g.z != null) {
                this.f14968j = z | zzk.zzlq().c(this.f14964f, this.f14966h.f14326f, this.f14965g.z.toString(), this.f14967i.f15752f);
            }
            zzang zzangVar = this.f14961c;
            if (zzangVar != null && !zzangVar.C()) {
                this.f14961c.recordImpression();
                this.f14962d.Y();
                return;
            }
            zzana zzanaVar = this.a;
            if (zzanaVar != null && !zzanaVar.C()) {
                this.a.recordImpression();
                this.f14962d.Y();
                return;
            }
            zzand zzandVar = this.f14960b;
            if (zzandVar == null || zzandVar.C()) {
                return;
            }
            this.f14960b.recordImpression();
            this.f14962d.Y();
        } catch (RemoteException e2) {
            zzbad.d("Failed to call recordImpression", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void j0() {
        this.f14969k = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void k(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.f14969k) {
            zzbad.i("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (this.f14965g.D) {
            o(view);
        } else {
            zzbad.i("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void l() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final boolean m(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void n() {
        zzbad.i("Mute This Ad is not supported for 3rd party ads");
    }
}
