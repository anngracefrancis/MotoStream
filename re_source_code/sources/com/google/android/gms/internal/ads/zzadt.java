package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzadt extends zzaeb {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f13832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f13833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f13834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f13835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f13836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<zzadw> f13837k = new ArrayList();
    private final List<zzaei> l = new ArrayList();
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final boolean r;

    static {
        int iRgb = Color.rgb(12, 174, 206);
        f13832f = iRgb;
        int iRgb2 = Color.rgb(204, 204, 204);
        f13833g = iRgb2;
        f13834h = iRgb2;
        f13835i = iRgb;
    }

    public zzadt(String str, List<zzadw> list, Integer num, Integer num2, Integer num3, int i2, int i3, boolean z) {
        this.f13836j = str;
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                zzadw zzadwVar = list.get(i4);
                this.f13837k.add(zzadwVar);
                this.l.add(zzadwVar);
            }
        }
        this.m = num != null ? num.intValue() : f13834h;
        this.n = num2 != null ? num2.intValue() : f13835i;
        this.o = num3 != null ? num3.intValue() : 12;
        this.p = i2;
        this.q = i3;
        this.r = z;
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final List<zzaei> M0() {
        return this.l;
    }

    public final int i7() {
        return this.m;
    }

    public final int j7() {
        return this.n;
    }

    public final int k7() {
        return this.o;
    }

    public final List<zzadw> l7() {
        return this.f13837k;
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final String m1() {
        return this.f13836j;
    }

    public final int m7() {
        return this.p;
    }

    public final int n7() {
        return this.q;
    }
}
