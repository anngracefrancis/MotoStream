package com.android.installreferrer.api;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class InstallReferrerClient {

    public static final class b {
        private final Context a;

        public InstallReferrerClient a() {
            Context context = this.a;
            if (context != null) {
                return new com.android.installreferrer.api.a(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }

        private b(Context context) {
            this.a = context;
        }
    }

    public static b c(Context context) {
        return new b(context);
    }

    public abstract void a();

    public abstract ReferrerDetails b() throws RemoteException;

    public abstract void d(InstallReferrerStateListener installReferrerStateListener);
}
