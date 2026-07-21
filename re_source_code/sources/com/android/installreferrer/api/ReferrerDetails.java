package com.android.installreferrer.api;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class ReferrerDetails {
    private final Bundle a;

    public ReferrerDetails(Bundle bundle) {
        this.a = bundle;
    }

    public String a() {
        return this.a.getString("install_referrer");
    }
}
