package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.sdk.d0.c;
import com.google.android.gms.common.GoogleApiAvailability;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends d7<e> {
    public String p;
    public boolean q;
    public boolean r;
    private n s;
    private f7<n> t;
    private o u;
    private h7 v;
    private f7<i7> w;

    final class a implements f7<n> {

        /* JADX INFO: renamed from: com.flurry.sdk.d$a$a, reason: collision with other inner class name */
        final class C0159a extends f2 {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ n f10679h;

            C0159a(n nVar) {
                this.f10679h = nVar;
            }

            @Override // com.flurry.sdk.f2
            public final void a() throws Exception {
                d1.c(3, "FlurryProvider", "isInstantApp: " + this.f10679h.a);
                d.this.s = this.f10679h;
                d.A(d.this);
                d.this.u.w(d.this.t);
            }
        }

        a() {
        }

        @Override // com.flurry.sdk.f7
        public final /* synthetic */ void a(n nVar) {
            d.this.m(new C0159a(nVar));
        }
    }

    final class b implements f7<i7> {
        b() {
        }

        @Override // com.flurry.sdk.f7
        public final /* bridge */ /* synthetic */ void a(i7 i7Var) {
            d.A(d.this);
        }
    }

    public class c extends f2 {
        public c() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            d.D(d.this);
            d.A(d.this);
        }
    }

    /* JADX INFO: renamed from: com.flurry.sdk.d$d, reason: collision with other inner class name */
    public enum EnumC0160d {
        UNAVAILABLE(-2),
        UNKNOWN(-1),
        SUCCESS(0),
        SERVICE_MISSING(1),
        SERVICE_UPDATING(2),
        SERVICE_VERSION_UPDATE_REQUIRED(3),
        SERVICE_DISABLED(4),
        SERVICE_INVALID(5);

        public int o;

        EnumC0160d(int i2) {
            this.o = i2;
        }
    }

    public d(o oVar, h7 h7Var) {
        super("FlurryProvider");
        this.q = false;
        this.r = false;
        this.t = new a();
        this.w = new b();
        this.u = oVar;
        oVar.v(this.t);
        this.v = h7Var;
        h7Var.v(this.w);
    }

    static /* synthetic */ void A(d dVar) {
        if (TextUtils.isEmpty(dVar.p) || dVar.s == null) {
            return;
        }
        dVar.t(new e(k0.a().b(), dVar.q, x(), dVar.s));
    }

    static /* synthetic */ void D(d dVar) {
        if (TextUtils.isEmpty(dVar.p)) {
            d1.c(6, "FlurryProvider", "Streaming API Key is invalid");
            return;
        }
        int iE = p2.e("prev_streaming_api_key", 0);
        int iHashCode = p2.g("api_key", HttpUrl.FRAGMENT_ENCODE_SET).hashCode();
        int iHashCode2 = dVar.p.hashCode();
        if (iE == iHashCode2 || iHashCode == iHashCode2) {
            return;
        }
        d1.c(3, "FlurryProvider", "Streaming API key is refreshed");
        p2.b("prev_streaming_api_key", iHashCode2);
        d0 d0Var = e7.a().l;
        d1.c(3, "ReportingProvider", "Reset initial timestamp.");
        d0Var.m(d0Var.new c());
    }

    private static EnumC0160d x() {
        try {
            int i2 = GoogleApiAvailability.q().i(b0.a());
            if (i2 == 0) {
                return EnumC0160d.SUCCESS;
            }
            if (i2 == 1) {
                return EnumC0160d.SERVICE_MISSING;
            }
            if (i2 == 2) {
                return EnumC0160d.SERVICE_VERSION_UPDATE_REQUIRED;
            }
            if (i2 == 3) {
                return EnumC0160d.SERVICE_DISABLED;
            }
            if (i2 != 9) {
                return i2 != 18 ? EnumC0160d.UNAVAILABLE : EnumC0160d.SERVICE_UPDATING;
            }
            return EnumC0160d.SERVICE_INVALID;
        } catch (Exception | NoClassDefFoundError unused) {
            d1.c(3, "FlurryProvider", "Error retrieving Google Play Services Availability. This probably means google play services is unavailable.");
            return EnumC0160d.UNAVAILABLE;
        }
    }
}
