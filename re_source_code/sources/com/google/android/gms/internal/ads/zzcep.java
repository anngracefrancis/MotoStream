package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcep implements zzbro, zzbrw, zzbsr, zzbtk, zzxr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzwj f15147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f15148g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f15149h = false;

    public zzcep(zzwj zzwjVar) {
        this.f15147f = zzwjVar;
        zzwjVar.b(zzwl.zza.zzb.AD_REQUEST);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void N(zzarx zzarxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final synchronized void onAdClicked() {
        if (this.f15149h) {
            this.f15147f.b(zzwl.zza.zzb.AD_SUBSEQUENT_CLICK);
        } else {
            this.f15147f.b(zzwl.zza.zzb.AD_FIRST_CLICK);
            this.f15149h = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final void onAdFailedToLoad(int i2) {
        switch (i2) {
            case 1:
                this.f15147f.b(zzwl.zza.zzb.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                break;
            case 2:
                this.f15147f.b(zzwl.zza.zzb.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                break;
            case 3:
                this.f15147f.b(zzwl.zza.zzb.AD_FAILED_TO_LOAD_NO_FILL);
                break;
            case 4:
                this.f15147f.b(zzwl.zza.zzb.AD_FAILED_TO_LOAD_TIMEOUT);
                break;
            case 5:
                this.f15147f.b(zzwl.zza.zzb.AD_FAILED_TO_LOAD_CANCELLED);
                break;
            case 6:
                this.f15147f.b(zzwl.zza.zzb.AD_FAILED_TO_LOAD_NO_ERROR);
                break;
            case 7:
                this.f15147f.b(zzwl.zza.zzb.AD_FAILED_TO_LOAD_NOT_FOUND);
                break;
            default:
                this.f15147f.b(zzwl.zza.zzb.AD_FAILED_TO_LOAD);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final synchronized void onAdImpression() {
        this.f15147f.b(zzwl.zza.zzb.AD_IMPRESSION);
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        this.f15147f.b(zzwl.zza.zzb.AD_LOADED);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void q(final zzcxu zzcxuVar) {
        this.f15147f.a(new zzwk(zzcxuVar) { // from class: com.google.android.gms.internal.ads.gi
            private final zzcxu a;

            {
                this.a = zzcxuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzwk
            public final void a(zzxn zzxnVar) {
                zzcxu zzcxuVar2 = this.a;
                zzxnVar.l.f16923f.f16929c = zzcxuVar2.f15747b.f15744b.f15736b;
            }
        });
    }
}
