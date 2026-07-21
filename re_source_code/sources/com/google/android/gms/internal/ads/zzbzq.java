package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbzq implements View.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzccj f14935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Clock f14936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzagd f14937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzaho f14938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String f14939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Long f14940k;
    WeakReference<View> l;

    public zzbzq(zzccj zzccjVar, Clock clock) {
        this.f14935f = zzccjVar;
        this.f14936g = clock;
    }

    private final void d() {
        View view;
        this.f14939j = null;
        this.f14940k = null;
        WeakReference<View> weakReference = this.l;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.l = null;
    }

    public final void a() {
        if (this.f14937h == null || this.f14940k == null) {
            return;
        }
        d();
        try {
            this.f14937h.onUnconfirmedClickCancelled();
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void b(zzagd zzagdVar) {
        this.f14937h = zzagdVar;
        zzaho<Object> zzahoVar = this.f14938i;
        if (zzahoVar != null) {
            this.f14935f.h("/unconfirmedClick", zzahoVar);
        }
        cg cgVar = new cg(this, zzagdVar);
        this.f14938i = cgVar;
        this.f14935f.d("/unconfirmedClick", cgVar);
    }

    public final zzagd c() {
        return this.f14937h;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference<View> weakReference = this.l;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.f14939j != null && this.f14940k != null) {
            HashMap map = new HashMap();
            map.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, this.f14939j);
            map.put("time_interval", String.valueOf(this.f14936g.a() - this.f14940k.longValue()));
            map.put("messageType", "onePointFiveClick");
            this.f14935f.e("sendMessageToNativeJs", map);
        }
        d();
    }
}
