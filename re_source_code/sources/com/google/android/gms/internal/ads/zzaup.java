package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaup extends zzatr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f14164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f14165g;

    public zzaup(zzato zzatoVar) {
        this(zzatoVar != null ? zzatoVar.f14157f : HttpUrl.FRAGMENT_ENCODE_SET, zzatoVar != null ? zzatoVar.f14158g : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzatq
    public final int getAmount() throws RemoteException {
        return this.f14165g;
    }

    @Override // com.google.android.gms.internal.ads.zzatq
    public final String getType() throws RemoteException {
        return this.f14164f;
    }

    public zzaup(RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : HttpUrl.FRAGMENT_ENCODE_SET, rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzaup(String str, int i2) {
        this.f14164f = str;
        this.f14165g = i2;
    }
}
