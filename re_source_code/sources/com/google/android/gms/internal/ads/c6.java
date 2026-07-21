package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import java.util.concurrent.Callable;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class c6 implements Callable<String> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Context f12400f;

    c6(zzazm zzazmVar, Context context) {
        this.f12400f = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        SharedPreferences sharedPreferences = this.f12400f.getSharedPreferences("admob_user_agent", 0);
        String string = sharedPreferences.getString("user_agent", HttpUrl.FRAGMENT_ENCODE_SET);
        if (!TextUtils.isEmpty(string)) {
            zzawz.m("User agent is already initialized on Google Play Services.");
            return string;
        }
        zzawz.m("User agent is not initialized on Google Play Services. Initializing.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(this.f12400f);
        SharedPreferencesUtils.a(this.f12400f, sharedPreferences.edit().putString("user_agent", defaultUserAgent), "admob_user_agent");
        return defaultUserAgent;
    }
}
