package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcjr {
    private zzwj a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f15308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzcjc f15309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbai f15310d;

    public zzcjr(Context context, zzbai zzbaiVar, zzwj zzwjVar, zzcjc zzcjcVar) {
        this.f15308b = context;
        this.f15310d = zzbaiVar;
        this.a = zzwjVar;
        this.f15309c = zzcjcVar;
    }

    public final void a() {
        try {
            this.f15309c.a(new zzczc(this) { // from class: com.google.android.gms.internal.ads.bk
                private final zzcjr a;

                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzczc
                public final Object a(Object obj) {
                    return this.a.b((SQLiteDatabase) obj);
                }
            });
        } catch (Exception e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            zzbad.g(strValueOf.length() != 0 ? "Error in offline signals database startup: ".concat(strValueOf) : new String("Error in offline signals database startup: "));
        }
    }

    final /* synthetic */ Void b(SQLiteDatabase sQLiteDatabase) throws Exception {
        final zzwt.zzi zziVar = (zzwt.zzi) ((zzdob) zzwt.zzi.J().u(this.f15308b.getPackageName()).v(Build.MODEL).w(zzcjq.a(sQLiteDatabase, 1)).B(zzcjq.b(sQLiteDatabase)).A(zzcjq.a(sQLiteDatabase, 2)).C(zzk.zzln().a()).p0());
        this.a.a(new zzwk(zziVar) { // from class: com.google.android.gms.internal.ads.ck
            private final zzwt.zzi a;

            {
                this.a = zziVar;
            }

            @Override // com.google.android.gms.internal.ads.zzwk
            public final void a(zzxn zzxnVar) {
                zzxnVar.m = this.a;
            }
        });
        final zzxo zzxoVar = new zzxo();
        zzxoVar.f16951c = Integer.valueOf(this.f15310d.f14327g);
        zzxoVar.f16952d = Integer.valueOf(this.f15310d.f14328h);
        zzxoVar.f16953e = Integer.valueOf(this.f15310d.f14329i ? 0 : 2);
        this.a.a(new zzwk(zzxoVar) { // from class: com.google.android.gms.internal.ads.dk
            private final zzxo a;

            {
                this.a = zzxoVar;
            }

            @Override // com.google.android.gms.internal.ads.zzwk
            public final void a(zzxn zzxnVar) {
                zzxnVar.f16948i.f16937f = this.a;
            }
        });
        this.a.b(zzwl.zza.zzb.OFFLINE_UPLOAD);
        sQLiteDatabase.delete("offline_signal_contents", null, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("total", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = ?", new String[]{"failed_requests"});
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("total", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }
}
