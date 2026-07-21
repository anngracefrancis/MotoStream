package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzqo implements zzql {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzql[] f16606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayList<zzql> f16607g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzqm f16609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzlr f16610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Object f16611k;
    private zzqq m;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzlu f16608h = new zzlu();
    private int l = -1;

    public zzqo(zzql... zzqlVarArr) {
        this.f16606f = zzqlVarArr;
        this.f16607g = new ArrayList<>(Arrays.asList(zzqlVarArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(int i2, zzlr zzlrVar, Object obj) {
        zzqq zzqqVar;
        if (this.m == null) {
            int iG = zzlrVar.g();
            int i3 = 0;
            while (true) {
                if (i3 >= iG) {
                    if (this.l != -1) {
                        if (zzlrVar.h() != this.l) {
                            zzqqVar = new zzqq(1);
                            break;
                        }
                    } else {
                        this.l = zzlrVar.h();
                    }
                    zzqqVar = null;
                    break;
                }
                if (zzlrVar.d(i3, this.f16608h, false).f16443e) {
                    zzqqVar = new zzqq(0);
                    break;
                }
                i3++;
            }
            this.m = zzqqVar;
        }
        if (this.m != null) {
            return;
        }
        this.f16607g.remove(this.f16606f[i2]);
        if (i2 == 0) {
            this.f16610j = zzlrVar;
            this.f16611k = obj;
        }
        if (this.f16607g.isEmpty()) {
            this.f16609i.e(this.f16610j, this.f16611k);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void a(zzkv zzkvVar, boolean z, zzqm zzqmVar) {
        this.f16609i = zzqmVar;
        int i2 = 0;
        while (true) {
            zzql[] zzqlVarArr = this.f16606f;
            if (i2 >= zzqlVarArr.length) {
                return;
            }
            zzqlVarArr[i2].a(zzkvVar, false, new g30(this, i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final zzqj b(int i2, zzrt zzrtVar) {
        int length = this.f16606f.length;
        zzqj[] zzqjVarArr = new zzqj[length];
        for (int i3 = 0; i3 < length; i3++) {
            zzqjVarArr[i3] = this.f16606f[i3].b(i2, zzrtVar);
        }
        return new f30(zzqjVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void c(zzqj zzqjVar) {
        f30 f30Var = (f30) zzqjVar;
        int i2 = 0;
        while (true) {
            zzql[] zzqlVarArr = this.f16606f;
            if (i2 >= zzqlVarArr.length) {
                return;
            }
            zzqlVarArr[i2].c(f30Var.f12557f[i2]);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void d() {
        for (zzql zzqlVar : this.f16606f) {
            zzqlVar.d();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void f() throws IOException {
        zzqq zzqqVar = this.m;
        if (zzqqVar != null) {
            throw zzqqVar;
        }
        for (zzql zzqlVar : this.f16606f) {
            zzqlVar.f();
        }
    }
}
