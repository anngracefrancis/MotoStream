package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzhp implements zzgf {
    private int a;

    final void a() throws zzgd {
        zzkh.d(this.a == 2);
        this.a = 1;
        u();
    }

    protected abstract long b();

    protected final int c() {
        return this.a;
    }

    protected abstract boolean d();

    protected void e() throws zzgd {
    }

    @Override // com.google.android.gms.internal.ads.zzgf
    public void f(int i2, Object obj) throws zzgd {
    }

    protected void g() throws zzgd {
    }

    final void h() throws zzgd {
        int i2 = this.a;
        zzkh.d((i2 == 2 || i2 == 3 || i2 == -2) ? false : true);
        this.a = -2;
        v();
    }

    protected abstract void i(long j2) throws zzgd;

    final void j() throws zzgd {
        zzkh.d(this.a == 2);
        this.a = 3;
        e();
    }

    final void k() throws zzgd {
        zzkh.d(this.a == 3);
        this.a = 2;
        g();
    }

    protected abstract void l(long j2, long j3) throws zzgd;

    protected void m(long j2, boolean z) throws zzgd {
    }

    final void n(long j2, boolean z) throws zzgd {
        zzkh.d(this.a == 1);
        this.a = 2;
        m(j2, z);
    }

    protected abstract int o(long j2) throws zzgd;

    final int p(long j2) throws zzgd {
        zzkh.d(this.a == 0);
        int iO = o(j2);
        this.a = iO;
        zzkh.d(iO == 0 || iO == 1 || iO == -1);
        return this.a;
    }

    protected abstract long q();

    protected boolean r() {
        return false;
    }

    protected abstract boolean s();

    protected abstract long t();

    protected void u() throws zzgd {
    }

    protected void v() throws zzgd {
    }
}
