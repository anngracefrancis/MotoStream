package com.google.android.gms.measurement.internal;

import cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzgy {
    public static final String[] a = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", TimeLineFollowFragment.BundleKeys.USER_ID, "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "ga_session_number", "ga_session_id", "last_gclid", "session_number", "session_id"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f18168b = {"_ln", "_fot", "_fvt", "_ldl", "_id", "_fi", "_lte", "_se", "_npa", "_sno", "_sid", "_lgclid", "_sno", "_sid"};

    protected zzgy() {
    }

    public static String a(String str) {
        return zzid.a(str, a, f18168b);
    }
}
