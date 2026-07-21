package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class k extends m<Void> {
    k(int i2, int i3, Bundle bundle) {
        super(i2, 2, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.m
    final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            c(null);
        } else {
            b(new zzp(4, "Invalid response to one way request"));
        }
    }

    @Override // com.google.android.gms.cloudmessaging.m
    final boolean d() {
        return true;
    }
}
