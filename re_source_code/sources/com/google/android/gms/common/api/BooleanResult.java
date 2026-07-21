package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class BooleanResult implements Result {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Status f11659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f11660g;

    @KeepForSdk
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.f11659f.equals(booleanResult.f11659f) && this.f11660g == booleanResult.f11660g;
    }

    @Override // com.google.android.gms.common.api.Result
    @KeepForSdk
    public Status getStatus() {
        return this.f11659f;
    }

    @KeepForSdk
    public final int hashCode() {
        return ((this.f11659f.hashCode() + 527) * 31) + (this.f11660g ? 1 : 0);
    }
}
