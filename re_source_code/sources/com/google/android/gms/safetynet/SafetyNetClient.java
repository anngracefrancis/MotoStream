package com.google.android.gms.safetynet;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes2.dex */
public class SafetyNetClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    SafetyNetClient(Context context) {
        super(context, SafetyNet.f18260c, (Api.ApiOptions) null, new ApiExceptionMapper());
    }

    public Task<SafetyNetApi.HarmfulAppsResponse> m() {
        return PendingResultUtil.a(SafetyNet.f18261d.a(a()), new SafetyNetApi.HarmfulAppsResponse());
    }
}
