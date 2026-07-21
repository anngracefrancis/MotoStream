package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzabe;
import com.google.android.gms.internal.ads.zzabi;

/* JADX INFO: loaded from: classes2.dex */
public class MobileAds {

    public static final class Settings {
        private final zzabi zzaat = new zzabi();

        @Deprecated
        public final String getTrackingId() {
            return null;
        }

        @Deprecated
        public final boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public final Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public final Settings setTrackingId(String str) {
            return this;
        }

        final zzabi zzdg() {
            return this.zzaat;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzabe.j().a(context);
    }

    @KeepForSdk
    public static String getVersionString() {
        return zzabe.j().b();
    }

    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    public static void openDebugMenu(Context context, String str) {
        zzabe.j().c(context, str);
    }

    @KeepForSdk
    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzabe.j().d(cls);
    }

    public static void setAppMuted(boolean z) {
        zzabe.j().e(z);
    }

    public static void setAppVolume(float f2) {
        zzabe.j().f(f2);
    }

    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzabe.j().g(context, str, settings == null ? null : settings.zzdg(), null);
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }
}
