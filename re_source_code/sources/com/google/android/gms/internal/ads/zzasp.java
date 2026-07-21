package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzasp extends zzass {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f14145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f14146g;

    public zzasp(String str, int i2) {
        this.f14145f = str;
        this.f14146g = i2;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzasp)) {
            zzasp zzaspVar = (zzasp) obj;
            if (Objects.a(this.f14145f, zzaspVar.f14145f) && Objects.a(Integer.valueOf(this.f14146g), Integer.valueOf(zzaspVar.f14146g))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzasr
    public final int getAmount() {
        return this.f14146g;
    }

    @Override // com.google.android.gms.internal.ads.zzasr
    public final String getType() {
        return this.f14145f;
    }
}
