package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
final class zj implements zzban<Bundle> {
    private final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzcjm f13714b;

    zj(zzcjm zzcjmVar, boolean z) {
        this.f13714b = zzcjmVar;
        this.a = z;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        zzbad.g("Failed to get signals bundle");
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzcjm zzcjmVar = this.f13714b;
        final ArrayList arrayListK = zzcjm.k(bundle2);
        zzcjm zzcjmVar2 = this.f13714b;
        final zzwt.zzi.zzc zzcVarJ = zzcjm.j(bundle2);
        final zzwt.zzg zzgVarI = this.f13714b.i(bundle2);
        zzcjc zzcjcVar = this.f13714b.f15303f;
        final boolean z = this.a;
        zzcjcVar.a(new zzczc(this, z, arrayListK, zzgVarI, zzcVarJ) { // from class: com.google.android.gms.internal.ads.ak
            private final zj a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final boolean f12256b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final ArrayList f12257c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final zzwt.zzg f12258d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final zzwt.zzi.zzc f12259e;

            {
                this.a = this;
                this.f12256b = z;
                this.f12257c = arrayListK;
                this.f12258d = zzgVarI;
                this.f12259e = zzcVarJ;
            }

            @Override // com.google.android.gms.internal.ads.zzczc
            public final Object a(Object obj) {
                zj zjVar = this.a;
                boolean z2 = this.f12256b;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                byte[] bArrD = zjVar.f13714b.d(z2, this.f12257c, this.f12258d, this.f12259e);
                ContentValues contentValues = new ContentValues();
                contentValues.put("timestamp", Long.valueOf(zzk.zzln().a()));
                contentValues.put("serialized_proto_data", bArrD);
                sQLiteDatabase.insert("offline_signal_contents", null, contentValues);
                sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET total = total+1 WHERE statistic_name = '%s'", "total_requests"));
                if (!z2) {
                    sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET total = total+1 WHERE statistic_name = '%s'", "failed_requests"));
                }
                return null;
            }
        });
    }
}
