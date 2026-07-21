package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class a extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17123k;
    private final /* synthetic */ Context l;
    private final /* synthetic */ Bundle m;
    private final /* synthetic */ zzx n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    a(zzx zzxVar, String str, String str2, Context context, Bundle bundle) {
        super(zzxVar);
        this.n = zzxVar;
        this.f17122j = str;
        this.f17123k = str2;
        this.l = context;
        this.m = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    public final void a() {
        String str;
        String str2;
        String str3;
        boolean z;
        int iMax;
        try {
            this.n.l = new ArrayList();
            zzx zzxVar = this.n;
            if (zzx.J(this.f17122j, this.f17123k)) {
                String str4 = this.f17123k;
                str2 = this.f17122j;
                str3 = str4;
                str = this.n.f17577h;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            zzx.W(this.l);
            boolean z2 = zzx.f17572c.booleanValue() || str2 != null;
            zzx zzxVar2 = this.n;
            zzxVar2.p = zzxVar2.b(this.l, z2);
            if (this.n.p == null) {
                Log.w(this.n.f17577h, "Failed to connect to measurement client.");
                return;
            }
            int iU = zzx.U(this.l);
            int iS = zzx.S(this.l);
            if (z2) {
                iMax = Math.max(iU, iS);
                z = iS < iU;
            } else {
                if (iU > 0) {
                    iS = iU;
                }
                z = iU > 0;
                iMax = iS;
            }
            this.n.p.initialize(ObjectWrapper.E0(this.l), new zzv(18202L, iMax, z, str, str2, str3, this.m), this.f17581f);
        } catch (RemoteException e2) {
            this.n.p(e2, true, false);
        }
    }
}
