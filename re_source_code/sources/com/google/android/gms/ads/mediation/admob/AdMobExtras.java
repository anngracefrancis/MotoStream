package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.e;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class AdMobExtras implements e {
    private final Bundle extras;

    public AdMobExtras(Bundle bundle) {
        this.extras = bundle != null ? new Bundle(bundle) : null;
    }

    public final Bundle getExtras() {
        return this.extras;
    }
}
