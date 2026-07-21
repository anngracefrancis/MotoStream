package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class LifecycleCallback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @KeepForSdk
    protected final LifecycleFragment f11734f;

    @KeepForSdk
    protected LifecycleCallback(LifecycleFragment lifecycleFragment) {
        this.f11734f = lifecycleFragment;
    }

    @KeepForSdk
    protected static LifecycleFragment c(LifecycleActivity lifecycleActivity) {
        if (lifecycleActivity.d()) {
            return zzd.f(lifecycleActivity.b());
        }
        if (lifecycleActivity.c()) {
            return zzb.f(lifecycleActivity.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity lifecycleActivity) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @KeepForSdk
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @KeepForSdk
    public Activity b() {
        Activity activityC = this.f11734f.c();
        Preconditions.k(activityC);
        return activityC;
    }

    @KeepForSdk
    public void d(int i2, int i3, Intent intent) {
    }

    @KeepForSdk
    public void e(Bundle bundle) {
    }

    @KeepForSdk
    public void f() {
    }

    @KeepForSdk
    public void g() {
    }

    @KeepForSdk
    public void h(Bundle bundle) {
    }

    @KeepForSdk
    public void i() {
    }

    @KeepForSdk
    public void j() {
    }
}
