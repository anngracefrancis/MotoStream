package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbae {
    public static <T> T a(Context context, String str, zzbaf<IBinder, T> zzbafVar) throws zzbag {
        try {
            return zzbafVar.a(c(context).d(str));
        } catch (Exception e2) {
            throw new zzbag(e2);
        }
    }

    public static Context b(Context context) throws zzbag {
        return c(context).b();
    }

    private static DynamiteModule c(Context context) throws zzbag {
        try {
            return DynamiteModule.e(context, DynamiteModule.a, ModuleDescriptor.MODULE_ID);
        } catch (Exception e2) {
            throw new zzbag(e2);
        }
    }
}
