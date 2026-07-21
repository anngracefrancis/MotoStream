package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes2.dex */
final class yj implements zzban<SQLiteDatabase> {
    private final /* synthetic */ zzczc a;

    yj(zzcjc zzcjcVar, zzczc zzczcVar) {
        this.a = zzczcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        String strValueOf = String.valueOf(th.getMessage());
        zzbad.g(strValueOf.length() != 0 ? "Failed to get offline signal database: ".concat(strValueOf) : new String("Failed to get offline signal database: "));
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a.a(sQLiteDatabase);
        } catch (Exception e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            zzbad.g(strValueOf.length() != 0 ? "Error executing function on offline signal database: ".concat(strValueOf) : new String("Error executing function on offline signal database: "));
        }
    }
}
