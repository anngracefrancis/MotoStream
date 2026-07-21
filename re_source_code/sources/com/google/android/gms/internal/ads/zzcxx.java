package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcxx {
    private zzxz a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzyd f15758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzzy f15759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzacd f15761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f15762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<String> f15763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<String> f15764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzady f15765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private PublisherAdViewOptions f15766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzzs f15767k;
    private String l;
    private String m;
    private zzaiy o;
    private int n = 1;
    public final Set<String> p = new HashSet();

    public final zzyd G() {
        return this.f15758b;
    }

    public final zzxz b() {
        return this.a;
    }

    public final String c() {
        return this.f15760d;
    }

    public final zzcxv d() {
        Preconditions.l(this.f15760d, "ad unit must not be null");
        Preconditions.l(this.f15758b, "ad size must not be null");
        Preconditions.l(this.a, "ad request must not be null");
        return new zzcxv(this);
    }

    public final zzcxx e(PublisherAdViewOptions publisherAdViewOptions) {
        this.f15766j = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.f15762f = publisherAdViewOptions.getManualImpressionsEnabled();
            this.f15767k = publisherAdViewOptions.zzkt();
        }
        return this;
    }

    public final zzcxx f(zzady zzadyVar) {
        this.f15765i = zzadyVar;
        return this;
    }

    public final zzcxx g(zzaiy zzaiyVar) {
        this.o = zzaiyVar;
        this.f15761e = new zzacd(false, true, false);
        return this;
    }

    public final zzcxx h(ArrayList<String> arrayList) {
        this.f15763g = arrayList;
        return this;
    }

    public final zzcxx j(boolean z) {
        this.f15762f = z;
        return this;
    }

    public final zzcxx k(zzacd zzacdVar) {
        this.f15761e = zzacdVar;
        return this;
    }

    public final zzcxx l(ArrayList<String> arrayList) {
        this.f15764h = arrayList;
        return this;
    }

    public final zzcxx n(zzyd zzydVar) {
        this.f15758b = zzydVar;
        return this;
    }

    public final zzcxx o(zzzy zzzyVar) {
        this.f15759c = zzzyVar;
        return this;
    }

    public final zzcxx q(int i2) {
        this.n = i2;
        return this;
    }

    public final zzcxx t(String str) {
        this.f15760d = str;
        return this;
    }

    public final zzcxx u(String str) {
        this.l = str;
        return this;
    }

    public final zzcxx v(String str) {
        this.m = str;
        return this;
    }

    public final zzcxx w(zzxz zzxzVar) {
        this.a = zzxzVar;
        return this;
    }
}
