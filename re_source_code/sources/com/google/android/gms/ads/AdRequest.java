package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzaba;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    private final zzaaz zzaam;

    @VisibleForTesting
    public static final class Builder {
        private final zzaba zzaan;

        public Builder() {
            zzaba zzabaVar = new zzaba();
            this.zzaan = zzabaVar;
            zzabaVar.j("B3EEABB8EE11C2BE770B684D95219ECB");
        }

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzaan.h(cls, bundle);
            return this;
        }

        public final Builder addKeyword(String str) {
            this.zzaan.i(str);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzaan.d(networkExtras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
            this.zzaan.e(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.zzaan.k("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }

        public final Builder addTestDevice(String str) {
            this.zzaan.j(str);
            return this;
        }

        public final AdRequest build() {
            return new AdRequest(this);
        }

        @Deprecated
        public final Builder setBirthday(Date date) {
            this.zzaan.f(date);
            return this;
        }

        public final Builder setContentUrl(String str) {
            Preconditions.l(str, "Content URL must be non-null.");
            Preconditions.h(str, "Content URL must be non-empty.");
            Preconditions.c(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(AdRequest.MAX_CONTENT_URL_LENGTH), Integer.valueOf(str.length()));
            this.zzaan.l(str);
            return this;
        }

        @Deprecated
        public final Builder setGender(int i2) {
            this.zzaan.r(i2);
            return this;
        }

        @Deprecated
        public final Builder setIsDesignedForFamilies(boolean z) {
            this.zzaan.J(z);
            return this;
        }

        public final Builder setLocation(Location location) {
            this.zzaan.c(location);
            return this;
        }

        public final Builder setMaxAdContentRating(String str) {
            this.zzaan.q(str);
            return this;
        }

        public final Builder setRequestAgent(String str) {
            this.zzaan.o(str);
            return this;
        }

        public final Builder setTagForUnderAgeOfConsent(int i2) {
            this.zzaan.s(i2);
            return this;
        }

        public final Builder tagForChildDirectedTreatment(boolean z) {
            this.zzaan.I(z);
            return this;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface MaxAdContentRating {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForUnderAgeOfConsent {
    }

    private AdRequest(Builder builder) {
        this.zzaam = new zzaaz(builder.zzaan);
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzaam.a();
    }

    public final String getContentUrl() {
        return this.zzaam.b();
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzaam.c(cls);
    }

    @Deprecated
    public final int getGender() {
        return this.zzaam.e();
    }

    public final Set<String> getKeywords() {
        return this.zzaam.f();
    }

    public final Location getLocation() {
        return this.zzaam.g();
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zzaam.j(cls);
    }

    public final <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzaam.k(cls);
    }

    public final boolean isTestDevice(Context context) {
        return this.zzaam.n(context);
    }

    public final zzaaz zzde() {
        return this.zzaam;
    }
}
