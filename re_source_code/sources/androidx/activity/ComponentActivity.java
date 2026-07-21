package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.app.f;
import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends f implements k, a0, androidx.savedstate.c, androidx.activity.c, androidx.activity.result.c {
    private ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final androidx.activity.d.a mContextAwareHelper;
    private y.b mDefaultFactory;
    private final l mLifecycleRegistry;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    final androidx.savedstate.b mSavedStateRegistryController;
    private z mViewModelStore;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e2) {
                if (!TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e2;
                }
            }
        }
    }

    class b extends ActivityResultRegistry {

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f72f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ androidx.activity.result.d.a.C0008a f73g;

            a(int i2, androidx.activity.result.d.a.C0008a c0008a) {
                this.f72f = i2;
                this.f73g = c0008a;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c(this.f72f, this.f73g.a());
            }
        }

        /* JADX INFO: renamed from: androidx.activity.ComponentActivity$b$b, reason: collision with other inner class name */
        class RunnableC0007b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f75f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f76g;

            RunnableC0007b(int i2, IntentSender.SendIntentException sendIntentException) {
                this.f75f = i2;
                this.f76g = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(this.f75f, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f76g));
            }
        }

        b() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void f(int i2, androidx.activity.result.d.a<I, O> aVar, I i3, androidx.core.app.b bVar) {
            ComponentActivity componentActivity = ComponentActivity.this;
            androidx.activity.result.d.a.C0008a<O> c0008aB = aVar.b(componentActivity, i3);
            if (c0008aB != null) {
                new Handler(Looper.getMainLooper()).post(new a(i2, c0008aB));
                return;
            }
            Intent intentA = aVar.a(componentActivity, i3);
            Bundle bundleB = null;
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundleB = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else if (bVar != null) {
                bundleB = bVar.b();
            }
            Bundle bundle = bundleB;
            if (!"androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
                if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                    androidx.core.app.a.u(componentActivity, intentA, i2, bundle);
                    return;
                }
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    androidx.core.app.a.v(componentActivity, intentSenderRequest.d(), i2, intentSenderRequest.a(), intentSenderRequest.b(), intentSenderRequest.c(), 0, bundle);
                    return;
                } catch (IntentSender.SendIntentException e2) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0007b(i2, e2));
                    return;
                }
            }
            String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : stringArrayExtra) {
                if (ComponentActivity.this.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                    arrayList.add(str);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            androidx.core.app.a.q(componentActivity, (String[]) arrayList.toArray(new String[0]), i2);
        }
    }

    static final class c {
        Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        z f78b;

        c() {
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new androidx.activity.d.a();
        this.mLifecycleRegistry = new l(this);
        this.mSavedStateRegistryController = androidx.savedstate.b.a(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b();
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            getLifecycle().a(new i() { // from class: androidx.activity.ComponentActivity.3
                @Override // androidx.lifecycle.i
                public void a(k kVar, g.b bVar) {
                    if (bVar == g.b.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                        if (viewPeekDecorView != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        getLifecycle().a(new i() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.i
            public void a(k kVar, g.b bVar) {
                if (bVar == g.b.ON_DESTROY) {
                    ComponentActivity.this.mContextAwareHelper.b();
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.getViewModelStore().a();
                }
            }
        });
        getLifecycle().a(new i() { // from class: androidx.activity.ComponentActivity.5
            @Override // androidx.lifecycle.i
            public void a(k kVar, g.b bVar) {
                ComponentActivity.this.ensureViewModelStore();
                ComponentActivity.this.getLifecycle().c(this);
            }
        });
        if (19 > i2 || i2 > 23) {
            return;
        }
        getLifecycle().a(new ImmLeaksCleaner(this));
    }

    private void initViewTreeOwners() {
        b0.a(getWindow().getDecorView(), this);
        c0.a(getWindow().getDecorView(), this);
        d.a(getWindow().getDecorView(), this);
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public final void addOnContextAvailableListener(androidx.activity.d.b bVar) {
        this.mContextAwareHelper.a(bVar);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            c cVar = (c) getLastNonConfigurationInstance();
            if (cVar != null) {
                this.mViewModelStore = cVar.f78b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new z();
            }
        }
    }

    @Override // androidx.activity.result.c
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public y.b getDefaultViewModelProviderFactory() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new v(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        c cVar = (c) getLastNonConfigurationInstance();
        if (cVar != null) {
            return cVar.a;
        }
        return null;
    }

    @Override // androidx.core.app.f, androidx.lifecycle.k
    public g getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.c
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.a0
    public z getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    @Override // android.app.Activity
    @Deprecated
    protected void onActivityResult(int i2, int i3, Intent intent) {
        if (this.mActivityResultRegistry.b(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.c();
    }

    @Override // androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.c(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        this.mActivityResultRegistry.g(bundle);
        t.g(this);
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.b(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        c cVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        z zVar = this.mViewModelStore;
        if (zVar == null && (cVar = (c) getLastNonConfigurationInstance()) != null) {
            zVar = cVar.f78b;
        }
        if (zVar == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        c cVar2 = new c();
        cVar2.a = objOnRetainCustomNonConfigurationInstance;
        cVar2.f78b = zVar;
        return cVar2;
    }

    @Override // androidx.core.app.f, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        g lifecycle = getLifecycle();
        if (lifecycle instanceof l) {
            ((l) lifecycle).o(g.c.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.d(bundle);
        this.mActivityResultRegistry.h(bundle);
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.d.a<I, O> aVar, ActivityResultRegistry activityResultRegistry, androidx.activity.result.a<O> aVar2) {
        return activityResultRegistry.j("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, aVar2);
    }

    public final void removeOnContextAvailableListener(androidx.activity.d.b bVar) {
        this.mContextAwareHelper.e(bVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (c.w.a.d()) {
                c.w.a.a("reportFullyDrawn() for " + getComponentName());
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 19) {
                super.reportFullyDrawn();
            } else if (i2 == 19 && androidx.core.content.a.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                super.reportFullyDrawn();
            }
        } finally {
            c.w.a.b();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        initViewTreeOwners();
        super.setContentView(i2);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.d.a<I, O> aVar, androidx.activity.result.a<O> aVar2) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, aVar2);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    public ComponentActivity(int i2) {
        this();
        this.mContentLayoutId = i2;
    }
}
