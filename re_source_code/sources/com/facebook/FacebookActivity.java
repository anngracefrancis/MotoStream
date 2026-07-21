package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.internal.p0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: FacebookActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\b\u0016\u0018\u0000  2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0016H\u0017¢\u0006\u0004\b\u0018\u0010\u0019R(\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000b¨\u0006!"}, d2 = {"Lcom/facebook/FacebookActivity;", "Landroidx/fragment/app/d;", "Lkotlin/u;", "c", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroidx/fragment/app/Fragment;", "b", "()Landroidx/fragment/app/Fragment;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", HttpUrl.FRAGMENT_ENCODE_SET, "prefix", "Ljava/io/FileDescriptor;", "fd", "Ljava/io/PrintWriter;", "writer", HttpUrl.FRAGMENT_ENCODE_SET, "args", "dump", "(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "<set-?>", "h", "Landroidx/fragment/app/Fragment;", "a", "currentFragment", "<init>", "f", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public class FacebookActivity extends androidx.fragment.app.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f9596g = FacebookActivity.class.getName();

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Fragment currentFragment;

    private final void c() {
        Intent intent = getIntent();
        com.facebook.internal.k0 k0Var = com.facebook.internal.k0.a;
        kotlin.jvm.internal.m.e(intent, "requestIntent");
        FacebookException facebookExceptionP = com.facebook.internal.k0.p(com.facebook.internal.k0.t(intent));
        Intent intent2 = getIntent();
        kotlin.jvm.internal.m.e(intent2, "intent");
        setResult(0, com.facebook.internal.k0.l(intent2, null, facebookExceptionP));
        finish();
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Fragment getCurrentFragment() {
        return this.currentFragment;
    }

    protected Fragment b() {
        Fragment fragment;
        Intent intent = getIntent();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.m.e(supportFragmentManager, "supportFragmentManager");
        Fragment fragmentJ0 = supportFragmentManager.j0("SingleFragment");
        if (fragmentJ0 != null) {
            return fragmentJ0;
        }
        if (kotlin.jvm.internal.m.a("FacebookDialogFragment", intent.getAction())) {
            com.facebook.internal.w wVar = new com.facebook.internal.w();
            wVar.setRetainInstance(true);
            wVar.show(supportFragmentManager, "SingleFragment");
            fragment = wVar;
        } else {
            com.facebook.login.v vVar = new com.facebook.login.v();
            vVar.setRetainInstance(true);
            supportFragmentManager.m().c(com.facebook.common.b.f9674c, vVar, "SingleFragment").i();
            fragment = vVar;
        }
        return fragment;
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        kotlin.jvm.internal.m.f(prefix, "prefix");
        kotlin.jvm.internal.m.f(writer, "writer");
        com.facebook.internal.u0.a.a aVarA = com.facebook.internal.u0.a.a.a.a();
        if (kotlin.jvm.internal.m.a(aVarA == null ? null : Boolean.valueOf(aVarA.a(prefix, writer, args)), Boolean.TRUE)) {
            return;
        }
        super.dump(prefix, fd, writer, args);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.m.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Fragment fragment = this.currentFragment;
        if (fragment == null) {
            return;
        }
        fragment.onConfigurationChanged(newConfig);
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        a0 a0Var = a0.a;
        if (!a0.w()) {
            p0 p0Var = p0.a;
            p0.j0(f9596g, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.m.e(applicationContext, "applicationContext");
            a0.M(applicationContext);
        }
        setContentView(com.facebook.common.c.a);
        if (kotlin.jvm.internal.m.a("PassThrough", intent.getAction())) {
            c();
        } else {
            this.currentFragment = b();
        }
    }
}
