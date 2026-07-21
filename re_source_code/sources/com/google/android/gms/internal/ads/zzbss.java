package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbss extends zzbts<AdMetadataListener> implements zzagv {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bundle f14718g;

    public zzbss(Set<zzbuz<AdMetadataListener>> set) {
        super(set);
        this.f14718g = new Bundle();
    }

    public final synchronized Bundle Y() {
        return new Bundle(this.f14718g);
    }

    @Override // com.google.android.gms.internal.ads.zzagv
    public final synchronized void k(String str, Bundle bundle) {
        this.f14718g.putAll(bundle);
        T(ge.a);
    }
}
