package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class zzbtv {
    private final Set<zzbuz<zzxr>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<zzbuz<zzbrl>> f14725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<zzbuz<zzbrw>> f14726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<zzbuz<zzbsr>> f14727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<zzbuz<zzbro>> f14728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<zzbuz<zzbrs>> f14729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<zzbuz<AdMetadataListener>> f14730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set<zzbuz<AppEventListener>> f14731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzbrm f14732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzcmu f14733j;

    public static class zza {
        private Set<zzbuz<zzxr>> a = new HashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Set<zzbuz<zzbrl>> f14734b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Set<zzbuz<zzbrw>> f14735c = new HashSet();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Set<zzbuz<zzbsr>> f14736d = new HashSet();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Set<zzbuz<zzbro>> f14737e = new HashSet();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Set<zzbuz<AdMetadataListener>> f14738f = new HashSet();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Set<zzbuz<AppEventListener>> f14739g = new HashSet();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Set<zzbuz<zzbrs>> f14740h = new HashSet();

        public final zza a(AppEventListener appEventListener, Executor executor) {
            this.f14739g.add(new zzbuz<>(appEventListener, executor));
            return this;
        }

        public final zza b(AdMetadataListener adMetadataListener, Executor executor) {
            this.f14738f.add(new zzbuz<>(adMetadataListener, executor));
            return this;
        }

        public final zza c(zzbrl zzbrlVar, Executor executor) {
            this.f14734b.add(new zzbuz<>(zzbrlVar, executor));
            return this;
        }

        public final zza d(zzbro zzbroVar, Executor executor) {
            this.f14737e.add(new zzbuz<>(zzbroVar, executor));
            return this;
        }

        public final zza e(zzbrs zzbrsVar, Executor executor) {
            this.f14740h.add(new zzbuz<>(zzbrsVar, executor));
            return this;
        }

        public final zza f(zzbrw zzbrwVar, Executor executor) {
            this.f14735c.add(new zzbuz<>(zzbrwVar, executor));
            return this;
        }

        public final zza g(zzbsr zzbsrVar, Executor executor) {
            this.f14736d.add(new zzbuz<>(zzbsrVar, executor));
            return this;
        }

        public final zza h(zzxr zzxrVar, Executor executor) {
            this.a.add(new zzbuz<>(zzxrVar, executor));
            return this;
        }

        public final zza i(zzzs zzzsVar, Executor executor) {
            if (this.f14739g != null) {
                zzcpy zzcpyVar = new zzcpy();
                zzcpyVar.b(zzzsVar);
                this.f14739g.add(new zzbuz<>(zzcpyVar, executor));
            }
            return this;
        }

        public final zzbtv k() {
            return new zzbtv(this);
        }
    }

    private zzbtv(zza zzaVar) {
        this.a = zzaVar.a;
        this.f14726c = zzaVar.f14735c;
        this.f14725b = zzaVar.f14734b;
        this.f14727d = zzaVar.f14736d;
        this.f14728e = zzaVar.f14737e;
        this.f14729f = zzaVar.f14740h;
        this.f14730g = zzaVar.f14738f;
        this.f14731h = zzaVar.f14739g;
    }

    public final zzcmu a(Clock clock) {
        if (this.f14733j == null) {
            this.f14733j = new zzcmu(clock);
        }
        return this.f14733j;
    }

    public final Set<zzbuz<zzbrl>> b() {
        return this.f14725b;
    }

    public final Set<zzbuz<zzbsr>> c() {
        return this.f14727d;
    }

    public final Set<zzbuz<zzbro>> d() {
        return this.f14728e;
    }

    public final Set<zzbuz<zzbrs>> e() {
        return this.f14729f;
    }

    public final Set<zzbuz<AdMetadataListener>> f() {
        return this.f14730g;
    }

    public final Set<zzbuz<AppEventListener>> g() {
        return this.f14731h;
    }

    public final Set<zzbuz<zzxr>> h() {
        return this.a;
    }

    public final Set<zzbuz<zzbrw>> i() {
        return this.f14726c;
    }

    public final zzbrm j(Set<zzbuz<zzbro>> set) {
        if (this.f14732i == null) {
            this.f14732i = new zzbrm(set);
        }
        return this.f14732i;
    }
}
