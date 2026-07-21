package com.google.android.gms.safetynet;

import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdkWithMembers
public interface SafetyNetApi {

    public static class AttestationResponse extends Response<zza> {
    }

    public static class HarmfulAppsResponse extends Response<zzb> {
        public List<HarmfulAppsData> h() {
            return f().f();
        }
    }

    public static class RecaptchaTokenResponse extends Response<RecaptchaTokenResult> {
    }

    @Deprecated
    public interface RecaptchaTokenResult extends Result {
    }

    @KeepForSdkWithMembers
    public static class SafeBrowsingResponse extends Response<SafeBrowsingResult> {
    }

    @KeepForSdkWithMembers
    @Deprecated
    public interface SafeBrowsingResult extends Result {
    }

    public static class VerifyAppsUserResponse extends Response<zzc> {
    }

    @Deprecated
    public interface zza extends Result {
    }

    @Deprecated
    public interface zzb extends Result {
        List<HarmfulAppsData> f();
    }

    @Deprecated
    public interface zzc extends Result {
    }

    @Deprecated
    PendingResult<zzb> a(GoogleApiClient googleApiClient);
}
