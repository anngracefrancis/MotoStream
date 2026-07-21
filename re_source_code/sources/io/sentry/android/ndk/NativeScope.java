package io.sentry.android.ndk;

/* JADX INFO: loaded from: classes2.dex */
final class NativeScope implements b {
    NativeScope() {
    }

    public static native void nativeAddBreadcrumb(String str, String str2, String str3, String str4, String str5, String str6);

    @Override // io.sentry.android.ndk.b
    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        nativeAddBreadcrumb(str, str2, str3, str4, str5, str6);
    }
}
