package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzln {
    public static final zzln a = new zzln(1.0f, 1.0f);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f16431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f16432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16433d;

    public zzln(float f2, float f3) {
        this.f16431b = f2;
        this.f16432c = f3;
        this.f16433d = Math.round(f2 * 1000.0f);
    }

    public final long a(long j2) {
        return j2 * ((long) this.f16433d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzln.class == obj.getClass()) {
            zzln zzlnVar = (zzln) obj;
            if (this.f16431b == zzlnVar.f16431b && this.f16432c == zzlnVar.f16432c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.f16431b) + 527) * 31) + Float.floatToRawIntBits(this.f16432c);
    }
}
