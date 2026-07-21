package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class ar implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzda f12266f;

    ar(zzda zzdaVar) {
        this.f12266f = zzdaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        if (this.f12266f.f15819e != null) {
            return;
        }
        synchronized (zzda.a) {
            if (this.f12266f.f15819e != null) {
                return;
            }
            boolean z = false;
            try {
                zBooleanValue = ((Boolean) zzyt.e().c(zzacu.i2)).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzda.f15816b = new zzwo(this.f12266f.f15818d.f16182b, "ADSHIELD", null);
                } catch (Throwable unused2) {
                }
            }
            z = zBooleanValue;
            this.f12266f.f15819e = Boolean.valueOf(z);
            zzda.a.open();
        }
    }
}
