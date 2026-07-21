package io.sentry.android.ndk;

import io.sentry.android.core.SentryAndroidOptions;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class SentryNdk {
    static {
        System.loadLibrary("log");
        System.loadLibrary("sentry");
        System.loadLibrary("sentry-android");
    }

    private SentryNdk() {
    }

    public static void close() {
        shutdown();
    }

    public static void init(SentryAndroidOptions sentryAndroidOptions) {
        d.a(sentryAndroidOptions.getSdkVersion());
        initSentryNative(sentryAndroidOptions);
        if (sentryAndroidOptions.isEnableScopeSync()) {
            sentryAndroidOptions.addScopeObserver(new c(sentryAndroidOptions));
        }
        sentryAndroidOptions.setDebugImagesLoader(new a(sentryAndroidOptions, new NativeModuleListLoader()));
    }

    private static native void initSentryNative(SentryAndroidOptions sentryAndroidOptions);

    private static native void shutdown();
}
