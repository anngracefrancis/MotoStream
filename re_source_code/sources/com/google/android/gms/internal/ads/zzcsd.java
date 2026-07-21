package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcsd implements zzcva<zzcsc> {
    private final zzbbl a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15599b;

    public zzcsd(zzbbl zzbblVar, Context context) {
        this.a = zzbblVar;
        this.f15599b = context;
    }

    final /* synthetic */ zzcsc a() throws Exception {
        AudioManager audioManager = (AudioManager) this.f15599b.getSystemService("audio");
        return new zzcsc(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzk.zzll().d(), zzk.zzll().e());
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcsc> b() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.yn

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcsd f13652f;

            {
                this.f13652f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13652f.a();
            }
        });
    }
}
