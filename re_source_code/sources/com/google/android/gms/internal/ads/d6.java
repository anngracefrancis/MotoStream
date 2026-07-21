package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class d6 implements Callable<String> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Context f12452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Context f12453g;

    d6(zzazm zzazmVar, Context context, Context context2) {
        this.f12452f = context;
        this.f12453g = context2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.f12452f != null) {
            zzawz.m("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.f12452f.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzawz.m("Attempting to read user agent from local cache.");
            sharedPreferences = this.f12453g.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", HttpUrl.FRAGMENT_ENCODE_SET);
        if (TextUtils.isEmpty(string)) {
            zzawz.m("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.f12453g);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzawz.m("Persisting user agent.");
            }
        }
        return string;
    }
}
