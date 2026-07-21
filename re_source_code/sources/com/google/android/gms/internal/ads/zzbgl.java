package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(16)
public abstract class zzbgl extends zzbft {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbdk f14439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f14441k;
    private boolean l;

    public zzbgl(zzbdf zzbdfVar) {
        super(zzbdfVar);
        this.f14441k = null;
        zzbdk zzbdkVar = new zzbdk();
        this.f14439i = zzbdkVar;
        zzbdkVar.c(new ja(this));
    }

    protected abstract zzhn C(String str);

    protected abstract int D();

    public final void E() {
        synchronized (this) {
            this.l = true;
            this.f14439i.a();
        }
    }

    public final zzbdk F() {
        return this.f14439i;
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void b() {
        synchronized (this) {
            this.f14440j = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbft, com.google.android.gms.common.api.Releasable
    public void c() {
        this.f14439i.i();
        super.c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e4, code lost:
    
        java.lang.Thread.sleep(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f5, code lost:
    
        throw new java.io.IOException("Interrupted sleep.");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24, types: [long] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    @Override // com.google.android.gms.internal.ads.zzbft
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean y(java.lang.String r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgl.y(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    protected final String z(String str) {
        String strValueOf = String.valueOf(super.z(str));
        return strValueOf.length() != 0 ? "cache:".concat(strValueOf) : new String("cache:");
    }
}
