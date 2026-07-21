package com.google.ads.mediation.customevent;

import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends MediationServerParameters {

    @MediationServerParameters.a(name = "label", required = true)
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @MediationServerParameters.a(name = "class_name", required = true)
    public String f11183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @MediationServerParameters.a(name = MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, required = false)
    public String f11184c = null;
}
