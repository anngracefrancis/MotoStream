package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: loaded from: classes2.dex */
abstract class h60<T> {
    private static final zzzv a = e();

    h60() {
    }

    private static zzzv e() {
        try {
            Object objNewInstance = zzyh.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi2").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(objNewInstance instanceof IBinder)) {
                zzbad.i("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) objNewInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            return iInterfaceQueryLocalInterface instanceof zzzv ? (zzzv) iInterfaceQueryLocalInterface : new zzzx(iBinder);
        } catch (Exception unused) {
            zzbad.i("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    private final T f() {
        zzzv zzzvVar = a;
        if (zzzvVar == null) {
            zzbad.i("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return a(zzzvVar);
        } catch (RemoteException e2) {
            zzbad.d("Cannot invoke local loader using ClientApi class.", e2);
            return null;
        }
    }

    private final T g() {
        try {
            return d();
        } catch (RemoteException e2) {
            zzbad.d("Cannot invoke remote loader.", e2);
            return null;
        }
    }

    protected abstract T a(zzzv zzzvVar) throws RemoteException;

    public final T b(Context context, boolean z) {
        T tF;
        if (!z) {
            zzyt.a();
            if (!zzazt.s(context, 12451000)) {
                zzbad.e("Google Play Services is not available.");
                z = true;
            }
        }
        if (DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.c(context, ModuleDescriptor.MODULE_ID)) {
            z = true;
        }
        zzacu.a(context);
        if (((Boolean) zzyt.e().c(zzacu.Y3)).booleanValue()) {
            z = false;
        }
        if (z) {
            tF = f();
            if (tF == null) {
                tF = g();
            }
        } else {
            T tG = g();
            int i2 = tG == null ? 1 : 0;
            if (i2 != 0) {
                if (zzyt.h().nextInt(((Integer) zzyt.e().c(zzacu.Y4)).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i2);
                    zzyt.a().d(context, zzyt.g().f14326f, "gmob-apps", bundle, true);
                }
            }
            tF = tG == null ? f() : tG;
        }
        return tF == null ? c() : tF;
    }

    protected abstract T c();

    protected abstract T d() throws RemoteException;
}
