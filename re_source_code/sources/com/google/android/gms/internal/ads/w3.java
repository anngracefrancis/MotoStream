package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class w3 implements zzbaf {
    static final zzbaf a = new w3();

    private w3() {
    }

    @Override // com.google.android.gms.internal.ads.zzbaf
    public final Object a(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        return iInterfaceQueryLocalInterface instanceof zzatz ? (zzatz) iInterfaceQueryLocalInterface : new zzaua(iBinder);
    }
}
