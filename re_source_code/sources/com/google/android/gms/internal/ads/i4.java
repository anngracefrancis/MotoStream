package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class i4 implements r4 {
    static final r4 a = new i4();

    private i4() {
    }

    @Override // com.google.android.gms.internal.ads.r4
    public final Object a(zzbjf zzbjfVar) throws RemoteException {
        String strJ2 = zzbjfVar.J2();
        if (strJ2 != null) {
            return strJ2;
        }
        String strO4 = zzbjfVar.O4();
        return strO4 != null ? strO4 : HttpUrl.FRAGMENT_ENCODE_SET;
    }
}
