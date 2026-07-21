package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class zzgz {
    final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f18169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f18170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f18171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Boolean f18172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f18173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    com.google.android.gms.internal.measurement.zzv f18174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f18175h;

    @VisibleForTesting
    public zzgz(Context context, com.google.android.gms.internal.measurement.zzv zzvVar) {
        this.f18175h = true;
        Preconditions.k(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.k(applicationContext);
        this.a = applicationContext;
        if (zzvVar != null) {
            this.f18174g = zzvVar;
            this.f18169b = zzvVar.f17570k;
            this.f18170c = zzvVar.f17569j;
            this.f18171d = zzvVar.f17568i;
            this.f18175h = zzvVar.f17567h;
            this.f18173f = zzvVar.f17566g;
            Bundle bundle = zzvVar.l;
            if (bundle != null) {
                this.f18172e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
