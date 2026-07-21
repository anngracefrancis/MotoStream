package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrr;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class zzdrr<M extends zzdrr<M>> extends zzdrw {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected zzdrt f16072b;

    @Override // com.google.android.gms.internal.ads.zzdrw
    public void a(zzdrp zzdrpVar) throws IOException {
        if (this.f16072b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f16072b.b(); i2++) {
            this.f16072b.d(i2).d(zzdrpVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdrw
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzdrr zzdrrVar = (zzdrr) super.clone();
        zzdrv.a(this, zzdrrVar);
        return zzdrrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdrw
    /* JADX INFO: renamed from: d */
    public final /* synthetic */ zzdrw clone() throws CloneNotSupportedException {
        return (zzdrr) clone();
    }

    @Override // com.google.android.gms.internal.ads.zzdrw
    protected int e() {
        if (this.f16072b != null) {
            for (int i2 = 0; i2 < this.f16072b.b(); i2++) {
                this.f16072b.d(i2).f();
            }
        }
        return 0;
    }
}
