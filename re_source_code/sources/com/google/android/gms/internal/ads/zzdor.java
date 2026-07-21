package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public class zzdor {
    private static final zzdno a = zzdno.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzdmr f16043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile zzdpk f16044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile zzdmr f16045d;

    private final zzdpk c(zzdpk zzdpkVar) {
        if (this.f16044c == null) {
            synchronized (this) {
                try {
                    if (this.f16044c == null) {
                        try {
                            this.f16044c = zzdpkVar;
                            this.f16045d = zzdmr.f15982f;
                        } catch (zzdok unused) {
                            this.f16044c = zzdpkVar;
                            this.f16045d = zzdmr.f15982f;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f16044c;
    }

    public final zzdmr a() {
        if (this.f16045d != null) {
            return this.f16045d;
        }
        synchronized (this) {
            if (this.f16045d != null) {
                return this.f16045d;
            }
            if (this.f16044c == null) {
                this.f16045d = zzdmr.f15982f;
            } else {
                this.f16045d = this.f16044c.e();
            }
            return this.f16045d;
        }
    }

    public final int b() {
        if (this.f16045d != null) {
            return this.f16045d.size();
        }
        if (this.f16044c != null) {
            return this.f16044c.i();
        }
        return 0;
    }

    public final zzdpk d(zzdpk zzdpkVar) {
        zzdpk zzdpkVar2 = this.f16044c;
        this.f16043b = null;
        this.f16045d = null;
        this.f16044c = zzdpkVar;
        return zzdpkVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdor)) {
            return false;
        }
        zzdor zzdorVar = (zzdor) obj;
        zzdpk zzdpkVar = this.f16044c;
        zzdpk zzdpkVar2 = zzdorVar.f16044c;
        if (zzdpkVar == null && zzdpkVar2 == null) {
            return a().equals(zzdorVar.a());
        }
        if (zzdpkVar == null || zzdpkVar2 == null) {
            return zzdpkVar != null ? zzdpkVar.equals(zzdorVar.c(zzdpkVar.f())) : c(zzdpkVar2.f()).equals(zzdpkVar2);
        }
        return zzdpkVar.equals(zzdpkVar2);
    }

    public int hashCode() {
        return 1;
    }
}
