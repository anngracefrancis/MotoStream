package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class zzdsu implements zzbe, Closeable, Iterator<zzbd> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzbd f16149f = new gy("eof ");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static zzdtc f16150g = zzdtc.b(zzdsu.class);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected zzba f16151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected zzdsw f16152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzbd f16153j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f16154k = 0;
    long l = 0;
    long m = 0;
    private List<zzbd> n = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Iterator
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final zzbd next() {
        zzbd zzbdVarA;
        zzbd zzbdVar = this.f16153j;
        if (zzbdVar != null && zzbdVar != f16149f) {
            this.f16153j = null;
            return zzbdVar;
        }
        zzdsw zzdswVar = this.f16152i;
        if (zzdswVar == null || this.f16154k >= this.m) {
            this.f16153j = f16149f;
            throw new NoSuchElementException();
        }
        try {
            synchronized (zzdswVar) {
                this.f16152i.d1(this.f16154k);
                zzbdVarA = this.f16151h.a(this.f16152i, this);
                this.f16154k = this.f16152i.k0();
            }
            return zzbdVarA;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public void close() throws IOException {
        this.f16152i.close();
    }

    public void d(zzdsw zzdswVar, long j2, zzba zzbaVar) throws IOException {
        this.f16152i = zzdswVar;
        long jK0 = zzdswVar.k0();
        this.l = jK0;
        this.f16154k = jK0;
        zzdswVar.d1(zzdswVar.k0() + j2);
        this.m = zzdswVar.k0();
        this.f16151h = zzbaVar;
    }

    public final List<zzbd> e() {
        return (this.f16152i == null || this.f16153j == f16149f) ? this.n : new zzdta(this.n, this);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        zzbd zzbdVar = this.f16153j;
        if (zzbdVar == f16149f) {
            return false;
        }
        if (zzbdVar != null) {
            return true;
        }
        try {
            this.f16153j = (zzbd) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.f16153j = f16149f;
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            if (i2 > 0) {
                sb.append(";");
            }
            sb.append(this.n.get(i2).toString());
        }
        sb.append("]");
        return sb.toString();
    }
}
