package com.google.android.gms.internal.location;

import android.content.ContentProviderClient;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzas {
    private final zzbj<zzao> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f17086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ContentProviderClient f17087c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17088d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<ListenerHolder.ListenerKey<LocationListener>, e> f17089e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<ListenerHolder.ListenerKey<Object>, d> f17090f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<ListenerHolder.ListenerKey<LocationCallback>, a> f17091g = new HashMap();

    public zzas(Context context, zzbj<zzao> zzbjVar) {
        this.f17086b = context;
        this.a = zzbjVar;
    }

    public final void a() throws RemoteException {
        synchronized (this.f17089e) {
            for (e eVar : this.f17089e.values()) {
                if (eVar != null) {
                    ((zzao) this.a.b()).B5(zzbf.z(eVar, null));
                }
            }
            this.f17089e.clear();
        }
        synchronized (this.f17091g) {
            for (a aVar : this.f17091g.values()) {
                if (aVar != null) {
                    ((zzao) this.a.b()).B5(zzbf.y(aVar, null));
                }
            }
            this.f17091g.clear();
        }
        synchronized (this.f17090f) {
            for (d dVar : this.f17090f.values()) {
                if (dVar != null) {
                    ((zzao) this.a.b()).A3(new zzo(2, null, dVar.asBinder(), null));
                }
            }
            this.f17090f.clear();
        }
    }

    public final void b(boolean z) throws RemoteException {
        this.a.a();
        ((zzao) this.a.b()).B0(z);
        this.f17088d = z;
    }

    public final void c() throws RemoteException {
        if (this.f17088d) {
            b(false);
        }
    }
}
