package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class n extends m<Bundle> {
    n(int i2, int i3, Bundle bundle) {
        super(i2, 1, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.m
    final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        c(bundle2);
    }

    @Override // com.google.android.gms.cloudmessaging.m
    final boolean d() {
        return false;
    }
}
