package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.instantapps.InstantApps;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends d7<n> {
    private q p;
    private boolean q;
    private String r;
    public String s;
    private f7<p> t;

    final class a implements f7<p> {

        /* JADX INFO: renamed from: com.flurry.sdk.o$a$a, reason: collision with other inner class name */
        final class C0164a extends f2 {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ p f10959h;

            C0164a(p pVar) {
                this.f10959h = pVar;
            }

            @Override // com.flurry.sdk.f2
            public final void a() throws Exception {
                if (o.this.r == null && this.f10959h.a.equals(p.a.CREATED)) {
                    o.this.r = this.f10959h.f10968b.getString("activity_name");
                    o.this.d();
                    o.this.p.w(o.this.t);
                }
            }
        }

        a() {
        }

        @Override // com.flurry.sdk.f7
        public final /* synthetic */ void a(p pVar) {
            o.this.m(new C0164a(pVar));
        }
    }

    final class b extends f2 {
        b() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            Context contextA = b0.a();
            if (contextA == null) {
                d1.c(6, "InstantAppProvider", "Context is null");
                return;
            }
            try {
                Class.forName("com.google.android.instantapps.InstantApps");
                o.this.q = InstantApps.isInstantApp(contextA);
                d1.c(3, "InstantAppProvider", "isInstantApp: " + String.valueOf(o.this.q));
            } catch (ClassNotFoundException unused) {
                d1.c(3, "InstantAppProvider", "isInstantApps dependency is not added");
            }
            o.this.d();
        }
    }

    public o(q qVar) {
        super("InstantAppProvider");
        a aVar = new a();
        this.t = aVar;
        this.p = qVar;
        qVar.v(aVar);
    }

    public final void d() {
        if (this.q && x() == null) {
            d1.c(3, "InstantAppProvider", "Fetching instant app name");
        } else {
            boolean z = this.q;
            t(new n(z, z ? x() : null));
        }
    }

    @Override // com.flurry.sdk.d7
    public final void u() {
        m(new b());
    }

    public final String x() {
        if (this.q) {
            return !TextUtils.isEmpty(this.s) ? this.s : this.r;
        }
        return null;
    }
}
