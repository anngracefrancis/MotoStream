package com.google.android.gms.internal.measurement;

import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.notification.PullingContentService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjk implements zzjh {
    private static final zzcl<Long> A;
    private static final zzcl<Long> B;
    private static final zzcl<Long> C;
    private static final zzcl<Long> D;
    private static final zzcl<Long> E;
    private static final zzcl<Long> F;
    private static final zzcl<Long> G;
    private static final zzcl<Long> H;
    private static final zzcl<String> I;
    private static final zzcl<Long> J;
    private static final zzcl<Long> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzcl<Long> f17462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzcl<String> f17463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzcl<String> f17464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzcl<String> f17465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzcl<Long> f17466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final zzcl<Long> f17467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final zzcl<Long> f17468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final zzcl<Long> f17469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final zzcl<Long> f17470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final zzcl<Long> f17471k;
    private static final zzcl<Long> l;
    private static final zzcl<Long> m;
    private static final zzcl<Long> n;
    private static final zzcl<Long> o;
    private static final zzcl<Long> p;
    private static final zzcl<Long> q;
    private static final zzcl<String> r;
    private static final zzcl<Long> s;
    private static final zzcl<Long> t;
    private static final zzcl<Long> u;
    private static final zzcl<Long> v;
    private static final zzcl<Long> w;
    private static final zzcl<Long> x;
    private static final zzcl<Long> y;
    private static final zzcl<Long> z;

    static {
        zzcr zzcrVar = new zzcr(zzcm.a("com.google.android.gms.measurement"));
        a = zzcrVar.b("measurement.ad_id_cache_time", 10000L);
        f17462b = zzcrVar.b("measurement.config.cache_time", PullingContentService.UPDATES_INTERVAL);
        f17463c = zzcrVar.c("measurement.log_tag", "FA");
        f17464d = zzcrVar.c("measurement.config.url_authority", "app-measurement.com");
        f17465e = zzcrVar.c("measurement.config.url_scheme", BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        f17466f = zzcrVar.b("measurement.upload.debug_upload_interval", 1000L);
        f17467g = zzcrVar.b("measurement.lifetimevalue.max_currency_tracked", 4L);
        f17468h = zzcrVar.b("measurement.store.max_stored_events_per_app", 100000L);
        f17469i = zzcrVar.b("measurement.experiment.max_ids", 50L);
        f17470j = zzcrVar.b("measurement.audience.filter_result_max_count", 200L);
        f17471k = zzcrVar.b("measurement.alarm_manager.minimum_interval", 60000L);
        l = zzcrVar.b("measurement.upload.minimum_delay", 500L);
        m = zzcrVar.b("measurement.monitoring.sample_period_millis", PullingContentService.UPDATES_INTERVAL);
        n = zzcrVar.b("measurement.upload.realtime_upload_interval", 10000L);
        o = zzcrVar.b("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        p = zzcrVar.b("measurement.config.cache_time.service", 3600000L);
        q = zzcrVar.b("measurement.service_client.idle_disconnect_millis", 5000L);
        r = zzcrVar.c("measurement.log_tag.service", "FA-SVC");
        s = zzcrVar.b("measurement.upload.stale_data_deletion_interval", PullingContentService.UPDATES_INTERVAL);
        t = zzcrVar.b("measurement.upload.backoff_period", 43200000L);
        u = zzcrVar.b("measurement.upload.initial_upload_delay_time", 15000L);
        v = zzcrVar.b("measurement.upload.interval", 3600000L);
        w = zzcrVar.b("measurement.upload.max_bundle_size", 65536L);
        x = zzcrVar.b("measurement.upload.max_bundles", 100L);
        y = zzcrVar.b("measurement.upload.max_conversions_per_day", 500L);
        z = zzcrVar.b("measurement.upload.max_error_events_per_day", 1000L);
        A = zzcrVar.b("measurement.upload.max_events_per_bundle", 1000L);
        B = zzcrVar.b("measurement.upload.max_events_per_day", 100000L);
        C = zzcrVar.b("measurement.upload.max_public_events_per_day", 50000L);
        D = zzcrVar.b("measurement.upload.max_queue_time", 2419200000L);
        E = zzcrVar.b("measurement.upload.max_realtime_events_per_day", 10L);
        F = zzcrVar.b("measurement.upload.max_batch_size", 65536L);
        G = zzcrVar.b("measurement.upload.retry_count", 6L);
        H = zzcrVar.b("measurement.upload.retry_time", cm.aptoide.pt.BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS);
        I = zzcrVar.c("measurement.upload.url", "https://app-measurement.com/a");
        J = zzcrVar.b("measurement.upload.window_interval", 3600000L);
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long A() {
        return A.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long A0() {
        return v.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final String B() {
        return I.n();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long C() {
        return B.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long G() {
        return u.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long O() {
        return f17471k.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long U() {
        return y.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long X() {
        return z.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long a() {
        return a.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long b() {
        return f17462b.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final String c() {
        return f17463c.n();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final String d() {
        return f17464d.n();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final String e() {
        return f17465e.n();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long f() {
        return n.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long f0() {
        return w.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long g() {
        return q.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final String h() {
        return r.n();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long i() {
        return C.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long j() {
        return m.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long k() {
        return p.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long l() {
        return f17469i.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long l0() {
        return x.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long m() {
        return f17468h.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long n() {
        return G.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long o() {
        return H.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long p() {
        return o.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long q() {
        return f17466f.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long r() {
        return E.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long s() {
        return f17467g.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long t() {
        return F.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long u() {
        return D.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long v() {
        return f17470j.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long w() {
        return l.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long x() {
        return s.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long y() {
        return t.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final long z() {
        return J.n().longValue();
    }
}
