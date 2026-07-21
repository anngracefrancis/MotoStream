package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzauh implements RewardItem {
    private final zzatq a;

    public zzauh(zzatq zzatqVar) {
        this.a = zzatqVar;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final int getAmount() {
        zzatq zzatqVar = this.a;
        if (zzatqVar == null) {
            return 0;
        }
        try {
            return zzatqVar.getAmount();
        } catch (RemoteException e2) {
            zzbad.d("Could not forward getAmount to RewardItem", e2);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final String getType() {
        zzatq zzatqVar = this.a;
        if (zzatqVar == null) {
            return null;
        }
        try {
            return zzatqVar.getType();
        } catch (RemoteException e2) {
            zzbad.d("Could not forward getType to RewardItem", e2);
            return null;
        }
    }
}
