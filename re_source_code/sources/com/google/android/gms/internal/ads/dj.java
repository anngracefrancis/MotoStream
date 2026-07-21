package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes2.dex */
final class dj implements zzban<zzcxu> {
    private final /* synthetic */ zzchl a;

    dj(zzchl zzchlVar) {
        this.a = zzchlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        if (((Boolean) zzyt.e().c(zzacu.a5)).booleanValue()) {
            Matcher matcher = zzchl.f15239b.matcher(th.getMessage());
            if (matcher.matches()) {
                this.a.f15244g.e(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzcxu zzcxuVar) {
        zzcxu zzcxuVar2 = zzcxuVar;
        if (((Boolean) zzyt.e().c(zzacu.a5)).booleanValue()) {
            this.a.f15244g.e(zzcxuVar2.f15747b.f15744b.f15739e);
            this.a.f15244g.f(zzcxuVar2.f15747b.f15744b.f15740f);
        }
    }
}
