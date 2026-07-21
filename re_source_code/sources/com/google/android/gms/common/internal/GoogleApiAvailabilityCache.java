package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleApiAvailabilityCache {
    private final SparseIntArray a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GoogleApiAvailabilityLight f11989b;

    public GoogleApiAvailabilityCache() {
        this(GoogleApiAvailability.q());
    }

    public void a() {
        this.a.clear();
    }

    public int b(Context context, Api.Client client) {
        Preconditions.k(context);
        Preconditions.k(client);
        int iJ = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int i2 = this.a.get(minApkVersion, -1);
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.a.size()) {
                iJ = i2;
                break;
            }
            int iKeyAt = this.a.keyAt(i3);
            if (iKeyAt > minApkVersion && this.a.get(iKeyAt) == 0) {
                break;
            }
            i3++;
        }
        if (iJ == -1) {
            iJ = this.f11989b.j(context, minApkVersion);
        }
        this.a.put(minApkVersion, iJ);
        return iJ;
    }

    public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.a = new SparseIntArray();
        Preconditions.k(googleApiAvailabilityLight);
        this.f11989b = googleApiAvailabilityLight;
    }
}
