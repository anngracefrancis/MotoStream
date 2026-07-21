package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class DataBufferRef {

    @KeepForSdk
    protected final DataHolder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @KeepForSdk
    protected int f11905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11906c;

    protected final void a(int i2) {
        Preconditions.n(i2 >= 0 && i2 < this.a.getCount());
        this.f11905b = i2;
        this.f11906c = this.a.e0(i2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (Objects.a(Integer.valueOf(dataBufferRef.f11905b), Integer.valueOf(this.f11905b)) && Objects.a(Integer.valueOf(dataBufferRef.f11906c), Integer.valueOf(this.f11906c)) && dataBufferRef.a == this.a) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.f11905b), Integer.valueOf(this.f11906c), this.a);
    }
}
