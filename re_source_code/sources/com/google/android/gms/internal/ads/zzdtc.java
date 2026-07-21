package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdtc {
    public static zzdtc b(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zzdsx(cls.getSimpleName()) : new zzdsz(cls.getSimpleName());
    }

    public abstract void a(String str);
}
