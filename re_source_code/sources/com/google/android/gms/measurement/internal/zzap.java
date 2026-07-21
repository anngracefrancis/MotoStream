package com.google.android.gms.measurement.internal;

import android.content.Context;
import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.notification.PullingContentService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbx;
import com.google.android.gms.internal.measurement.zzcm;
import com.google.android.gms.internal.measurement.zzky;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class zzap {
    public static zzem<Long> A;
    public static zzem<Boolean> A0;
    public static zzem<Long> B;
    public static zzem<Boolean> B0;
    public static zzem<Long> C;
    public static zzem<Boolean> C0;
    public static zzem<Long> D;
    public static zzem<Boolean> D0;
    public static zzem<Long> E;
    private static zzem<Boolean> E0;
    public static zzem<Long> F;
    public static zzem<Boolean> F0;
    public static zzem<Long> G;
    public static zzem<Boolean> G0;
    public static zzem<Long> H;
    public static zzem<Boolean> H0;
    public static zzem<Long> I;
    public static zzem<Boolean> I0;
    public static zzem<Integer> J;
    public static zzem<Boolean> J0;
    public static zzem<Long> K;
    public static zzem<Boolean> K0;
    public static zzem<Integer> L;
    public static zzem<Boolean> L0;
    public static zzem<Integer> M;
    public static zzem<Boolean> M0;
    public static zzem<Long> N;
    public static zzem<Boolean> N0;
    public static zzem<Boolean> O;
    public static zzem<Boolean> O0;
    public static zzem<String> P;
    public static zzem<Boolean> P0;
    public static zzem<Long> Q;
    public static zzem<Boolean> Q0;
    public static zzem<Integer> R;
    public static zzem<Boolean> R0;
    public static zzem<Double> S;
    public static zzem<Boolean> S0;
    public static zzem<Integer> T;
    public static zzem<Boolean> T0;
    public static zzem<Boolean> U;
    public static zzem<Boolean> U0;
    public static zzem<Boolean> V;
    public static zzem<Boolean> V0;
    public static zzem<Boolean> W;
    private static zzem<Boolean> W0;
    public static zzem<Boolean> X;
    public static zzem<Boolean> X0;
    public static zzem<Boolean> Y;
    public static zzem<Boolean> Z;
    static zzw a;
    public static zzem<Boolean> a0;
    public static zzem<Boolean> b0;
    public static zzem<Boolean> c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile zzfx f18073d;
    public static zzem<Boolean> d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private static Boolean f18074e;
    public static zzem<Boolean> e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static zzem<Boolean> f18075f;
    public static zzem<Boolean> f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static zzem<Boolean> f18076g;
    public static zzem<Boolean> g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static zzem<String> f18077h;
    public static zzem<Boolean> h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static zzem<Long> f18078i;
    public static zzem<Boolean> i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static zzem<Long> f18079j;
    public static zzem<Boolean> j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static zzem<Long> f18080k;
    public static zzem<Boolean> k0;
    public static zzem<String> l;
    public static zzem<Boolean> l0;
    public static zzem<String> m;
    public static zzem<Boolean> m0;
    public static zzem<Integer> n;
    public static zzem<Boolean> n0;
    public static zzem<Integer> o;
    public static zzem<Boolean> o0;
    public static zzem<Integer> p;
    public static zzem<Boolean> p0;
    public static zzem<Integer> q;
    public static zzem<Boolean> q0;
    public static zzem<Integer> r;
    public static zzem<Boolean> r0;
    public static zzem<Integer> s;
    public static zzem<Boolean> s0;
    public static zzem<Integer> t;
    public static zzem<Boolean> t0;
    public static zzem<Integer> u;
    public static zzem<Boolean> u0;
    public static zzem<Integer> v;
    public static zzem<Boolean> v0;
    public static zzem<Integer> w;
    public static zzem<Boolean> w0;
    public static zzem<String> x;
    public static zzem<Boolean> x0;
    public static zzem<Long> y;
    public static zzem<Boolean> y0;
    public static zzem<Long> z;
    public static zzem<Boolean> z0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<zzem<?>> f18071b = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Set<zzem<?>> f18072c = Collections.synchronizedSet(new HashSet());

    static {
        Boolean bool = Boolean.FALSE;
        f18075f = a("measurement.log_androidId_enabled", bool, bool, k.a);
        f18076g = a("measurement.upload_dsid_enabled", bool, bool, j.a);
        f18077h = a("measurement.log_tag", "FA", "FA-SVC", w.a);
        f18078i = a("measurement.ad_id_cache_time", 10000L, 10000L, f0.a);
        Long lValueOf = Long.valueOf(PullingContentService.UPDATES_INTERVAL);
        f18079j = a("measurement.monitoring.sample_period_millis", lValueOf, lValueOf, t0.a);
        f18080k = a("measurement.config.cache_time", lValueOf, 3600000L, c1.a);
        l = a("measurement.config.url_scheme", BuildConfig.APTOIDE_WEB_SERVICES_SCHEME, BuildConfig.APTOIDE_WEB_SERVICES_SCHEME, p1.a);
        m = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", z1.a);
        n = a("measurement.upload.max_bundles", 100, 100, m2.a);
        o = a("measurement.upload.max_batch_size", 65536, 65536, w2.a);
        p = a("measurement.upload.max_bundle_size", 65536, 65536, m.a);
        q = a("measurement.upload.max_events_per_bundle", 1000, 1000, l.a);
        r = a("measurement.upload.max_events_per_day", 100000, 100000, o.a);
        s = a("measurement.upload.max_error_events_per_day", 1000, 1000, n.a);
        t = a("measurement.upload.max_public_events_per_day", 50000, 50000, q.a);
        u = a("measurement.upload.max_conversions_per_day", 500, 500, p.a);
        v = a("measurement.upload.max_realtime_events_per_day", 10, 10, s.a);
        w = a("measurement.store.max_stored_events_per_app", 100000, 100000, r.a);
        x = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", u.a);
        y = a("measurement.upload.backoff_period", 43200000L, 43200000L, t.a);
        z = a("measurement.upload.window_interval", 3600000L, 3600000L, v.a);
        A = a("measurement.upload.interval", 3600000L, 3600000L, y.a);
        B = a("measurement.upload.realtime_upload_interval", 10000L, 10000L, x.a);
        C = a("measurement.upload.debug_upload_interval", 1000L, 1000L, a0.a);
        D = a("measurement.upload.minimum_delay", 500L, 500L, z.a);
        E = a("measurement.alarm_manager.minimum_interval", 60000L, 60000L, c0.a);
        F = a("measurement.upload.stale_data_deletion_interval", lValueOf, lValueOf, b0.a);
        G = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, e0.a);
        H = a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, d0.a);
        Long lValueOf2 = Long.valueOf(cm.aptoide.pt.BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS);
        I = a("measurement.upload.retry_time", lValueOf2, lValueOf2, g0.a);
        J = a("measurement.upload.retry_count", 6, 6, i0.a);
        K = a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, h0.a);
        L = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, k0.a);
        M = a("measurement.audience.filter_result_max_count", 200, 200, j0.a);
        N = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, m0.a);
        O = a("measurement.test.boolean_flag", bool, bool, l0.a);
        P = a("measurement.test.string_flag", "---", "---", o0.a);
        Q = a("measurement.test.long_flag", -1L, -1L, n0.a);
        R = a("measurement.test.int_flag", -2, -2, q0.a);
        Double dValueOf = Double.valueOf(-3.0d);
        S = a("measurement.test.double_flag", dValueOf, dValueOf, p0.a);
        T = a("measurement.experiment.max_ids", 50, 50, r0.a);
        U = a("measurement.validation.internal_limits_internal_event_params", bool, bool, v0.a);
        Boolean bool2 = Boolean.TRUE;
        V = a("measurement.reset_analytics.persist_time", bool2, bool2, u0.a);
        W = a("measurement.sampling.time_zone_offset_enabled", bool, bool, x0.a);
        X = a("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", bool, bool, w0.a);
        Y = a("measurement.client.sessions.session_id_enabled", bool2, bool2, z0.a);
        Z = a("measurement.service.sessions.session_number_enabled", bool2, bool2, y0.a);
        a0 = a("measurement.client.sessions.immediate_start_enabled_foreground", bool2, bool2, b1.a);
        b0 = a("measurement.client.sessions.background_sessions_enabled", bool2, bool2, a1.a);
        c0 = a("measurement.client.sessions.remove_expired_session_properties_enabled", bool2, bool2, d1.a);
        d0 = a("measurement.service.sessions.session_number_backfill_enabled", bool2, bool2, f1.a);
        e0 = a("measurement.service.sessions.remove_disabled_session_number", bool2, bool2, e1.a);
        f0 = a("measurement.client.sessions.start_session_before_view_screen", bool2, bool2, h1.a);
        g0 = a("measurement.client.sessions.check_on_startup", bool2, bool2, g1.a);
        h0 = a("measurement.collection.firebase_global_collection_flag_enabled", bool2, bool2, j1.a);
        Boolean bool3 = Boolean.FALSE;
        i0 = a("measurement.collection.efficient_engagement_reporting_enabled", bool3, bool3, i1.a);
        j0 = a("measurement.collection.redundant_engagement_removal_enabled", bool3, bool3, l1.a);
        k0 = a("measurement.personalized_ads_signals_collection_enabled", bool2, bool2, k1.a);
        l0 = a("measurement.personalized_ads_property_translation_enabled", bool2, bool2, n1.a);
        m0 = a("measurement.collection.init_params_control_enabled", bool2, bool2, m1.a);
        n0 = a("measurement.upload.disable_is_uploader", bool2, bool2, o1.a);
        o0 = a("measurement.experiment.enable_experiment_reporting", bool2, bool2, r1.a);
        p0 = a("measurement.collection.log_event_and_bundle_v2", bool2, bool2, q1.a);
        q0 = a("measurement.quality.checksum", bool3, bool3, null);
        r0 = a("measurement.module.collection.conditionally_omit_admob_app_id", bool2, bool2, u1.a);
        s0 = a("measurement.sdk.dynamite.use_dynamite2", bool3, bool3, s1.a);
        t0 = a("measurement.sdk.dynamite.allow_remote_dynamite", bool3, bool3, w1.a);
        u0 = a("measurement.sdk.collection.validate_param_names_alphabetical", bool3, bool3, v1.a);
        v0 = a("measurement.collection.event_safelist", bool2, bool2, y1.a);
        w0 = a("measurement.service.audience.scoped_filters_v27", bool3, bool3, x1.a);
        x0 = a("measurement.service.audience.session_scoped_event_aggregates", bool3, bool3, a2.a);
        y0 = a("measurement.service.audience.session_scoped_user_engagement", bool3, bool3, c2.a);
        z0 = a("measurement.service.audience.scoped_engagement_removal_when_session_expired", bool2, bool2, b2.a);
        A0 = a("measurement.client.audience.scoped_engagement_removal_when_session_expired", bool2, bool2, e2.a);
        B0 = a("measurement.service.audience.remove_disabled_session_scoped_user_engagement", bool3, bool3, d2.a);
        C0 = a("measurement.service.audience.use_bundle_timestamp_for_property_filters", bool3, bool3, g2.a);
        D0 = a("measurement.service.audience.not_prepend_timestamps_for_sequence_session_scoped_filters", bool3, bool3, f2.a);
        E0 = a("measurement.service.audience.invalidate_config_cache_after_app_unisntall", bool3, bool3, i2.a);
        F0 = a("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, h2.a);
        G0 = a("measurement.app_launch.event_ordering_fix", bool3, bool3, k2.a);
        H0 = a("measurement.sdk.collection.last_deep_link_referrer", bool3, bool3, j2.a);
        I0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign", bool3, bool3, l2.a);
        J0 = a("measurement.sdk.collection.last_gclid_from_referrer", bool3, bool3, o2.a);
        K0 = a("measurement.sdk.collection.worker_thread_referrer", bool2, bool2, n2.a);
        L0 = a("measurement.upload.file_lock_state_check", bool3, bool3, q2.a);
        M0 = a("measurement.sampling.calculate_bundle_timestamp_before_sampling", bool2, bool2, p2.a);
        N0 = a("measurement.ga.ga_app_id", bool3, Boolean.valueOf(zzky.b()), s2.a);
        O0 = a("measurement.lifecycle.app_backgrounded_tracking", bool3, bool3, r2.a);
        P0 = a("measurement.lifecycle.app_in_background_parameter", bool3, bool3, v2.a);
        Q0 = a("measurement.integration.disable_firebase_instance_id", bool3, bool3, t2.a);
        R0 = a("measurement.lifecycle.app_backgrounded_engagement", bool3, bool3, x2.a);
        S0 = a("measurement.service.fix_gmp_version", bool3, bool3, z2.a);
        T0 = a("measurement.collection.service.update_with_analytics_fix", bool3, bool3, y2.a);
        U0 = a("measurement.service.disable_install_state_reporting", bool3, bool3, b3.a);
        V0 = a("measurement.service.use_appinfo_modified", bool3, bool3, a3.a);
        Boolean bool4 = Boolean.TRUE;
        W0 = a("measurement.upload.dsid_reflection_failure_logging", bool4, bool4, d3.a);
        X0 = a("measurement.client.firebase_feature_rollout.v1.enable", bool4, bool4, c3.a);
    }

    private static boolean B0() {
        if (a != null) {
        }
        return false;
    }

    @VisibleForTesting
    private static <V> zzem<V> a(String str, V v2, V v3, e3<V> e3Var) {
        zzem<V> zzemVar = new zzem<>(str, v2, v3, e3Var);
        f18071b.add(zzemVar);
        return zzemVar;
    }

    public static Map<String, String> c(Context context) {
        zzbx zzbxVarA = zzbx.a(context.getContentResolver(), zzcm.a("com.google.android.gms.measurement"));
        return zzbxVarA == null ? Collections.emptyMap() : zzbxVarA.b();
    }

    static void d(zzfx zzfxVar) {
        f18073d = zzfxVar;
    }

    static void e(zzw zzwVar) {
        a = zzwVar;
    }

    @VisibleForTesting
    static void f(Exception exc) {
        if (f18073d == null) {
            return;
        }
        Context contextF = f18073d.f();
        if (f18074e == null) {
            f18074e = Boolean.valueOf(GoogleApiAvailabilityLight.h().j(contextF, 12451000) == 0);
        }
        if (f18074e.booleanValue()) {
            f18073d.h().H().b("Got Exception on PhenotypeFlag.get on Play device", exc);
        }
    }

    static final /* synthetic */ String x0() {
        return B0() ? com.google.android.gms.internal.measurement.zzji.D() : com.google.android.gms.internal.measurement.zzji.o();
    }
}
