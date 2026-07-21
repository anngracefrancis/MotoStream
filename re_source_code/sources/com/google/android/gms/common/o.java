package com.google.android.gms.common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzag;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class o {
    private String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12092b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzag f12093c = zzag.t();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzag f12094d = zzag.t();

    o() {
    }

    final o a(long j2) {
        this.f12092b = j2;
        return this;
    }

    final o b(List list) {
        Preconditions.k(list);
        this.f12094d = zzag.s(list);
        return this;
    }

    final o c(List list) {
        Preconditions.k(list);
        this.f12093c = zzag.s(list);
        return this;
    }

    final o d(String str) {
        this.a = str;
        return this;
    }

    final a e() {
        if (this.a == null) {
            throw new IllegalStateException("packageName must be defined");
        }
        if (this.f12092b < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        }
        if (this.f12093c.isEmpty() && this.f12094d.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        return new a(this.a, this.f12092b, this.f12093c, this.f12094d, null);
    }
}
