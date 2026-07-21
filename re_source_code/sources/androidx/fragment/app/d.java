package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: FragmentActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends ComponentActivity implements androidx.core.app.a.c, androidx.core.app.a.e {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final androidx.lifecycle.l mFragmentLifecycleRegistry;
    final h mFragments;
    boolean mResumed;
    boolean mStopped;

    /* JADX INFO: compiled from: FragmentActivity.java */
    class a implements SavedStateRegistry.b {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            Bundle bundle = new Bundle();
            d.this.markFragmentsCreated();
            d.this.mFragmentLifecycleRegistry.h(androidx.lifecycle.g.b.ON_STOP);
            Parcelable parcelableX = d.this.mFragments.x();
            if (parcelableX != null) {
                bundle.putParcelable(d.FRAGMENTS_TAG, parcelableX);
            }
            return bundle;
        }
    }

    /* JADX INFO: compiled from: FragmentActivity.java */
    class b implements androidx.activity.d.b {
        b() {
        }

        @Override // androidx.activity.d.b
        public void a(Context context) {
            d.this.mFragments.a(null);
            Bundle bundleA = d.this.getSavedStateRegistry().a(d.FRAGMENTS_TAG);
            if (bundleA != null) {
                d.this.mFragments.w(bundleA.getParcelable(d.FRAGMENTS_TAG));
            }
        }
    }

    /* JADX INFO: compiled from: FragmentActivity.java */
    class c extends j<d> implements androidx.lifecycle.a0, androidx.activity.c, androidx.activity.result.c, o {
        public c() {
            super(d.this);
        }

        @Override // androidx.fragment.app.o
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            d.this.onAttachFragment(fragment);
        }

        @Override // androidx.fragment.app.j, androidx.fragment.app.f
        public View c(int i2) {
            return d.this.findViewById(i2);
        }

        @Override // androidx.fragment.app.j, androidx.fragment.app.f
        public boolean d() {
            Window window = d.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.activity.result.c
        public ActivityResultRegistry getActivityResultRegistry() {
            return d.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.k
        public androidx.lifecycle.g getLifecycle() {
            return d.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.c
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return d.this.getOnBackPressedDispatcher();
        }

        @Override // androidx.lifecycle.a0
        public androidx.lifecycle.z getViewModelStore() {
            return d.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.j
        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            d.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.j
        public LayoutInflater j() {
            return d.this.getLayoutInflater().cloneInContext(d.this);
        }

        @Override // androidx.fragment.app.j
        public boolean l(Fragment fragment) {
            return !d.this.isFinishing();
        }

        @Override // androidx.fragment.app.j
        public boolean m(String str) {
            return androidx.core.app.a.t(d.this, str);
        }

        @Override // androidx.fragment.app.j
        public void p() {
            d.this.supportInvalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.j
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public d i() {
            return d.this;
        }
    }

    public d() {
        this.mFragments = h.b(new c());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.l(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().d(FRAGMENTS_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private static boolean markState(FragmentManager fragmentManager, androidx.lifecycle.g.c cVar) {
        boolean zMarkState = false;
        for (Fragment fragment : fragmentManager.v0()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    zMarkState |= markState(fragment.getChildFragmentManager(), cVar);
                }
                y yVar = fragment.mViewLifecycleOwner;
                if (yVar != null && yVar.getLifecycle().b().g(androidx.lifecycle.g.c.STARTED)) {
                    fragment.mViewLifecycleOwner.f(cVar);
                    zMarkState = true;
                }
                if (fragment.mLifecycleRegistry.b().g(androidx.lifecycle.g.c.STARTED)) {
                    fragment.mLifecycleRegistry.o(cVar);
                    zMarkState = true;
                }
            }
        }
        return zMarkState;
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.v(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            c.p.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.t().X(str, fileDescriptor, printWriter, strArr);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.t();
    }

    @Deprecated
    public c.p.a.a getSupportLoaderManager() {
        return c.p.a.a.b(this);
    }

    void markFragmentsCreated() {
        while (markState(getSupportFragmentManager(), androidx.lifecycle.g.c.CREATED)) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        this.mFragments.u();
        super.onActivityResult(i2, i3, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.u();
        this.mFragments.d(configuration);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(androidx.lifecycle.g.b.ON_CREATE);
        this.mFragments.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return i2 == 0 ? super.onCreatePanelMenu(i2, menu) | this.mFragments.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i2, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.h(androidx.lifecycle.g.b.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.mFragments.k(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.mFragments.e(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.j(z);
    }

    @Override // android.app.Activity
    protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.u();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.mFragments.l(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.m();
        this.mFragmentLifecycleRegistry.h(androidx.lifecycle.g.b.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.n(z);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return i2 == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.o(menu) : super.onPreparePanel(i2, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mFragments.u();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.u();
        this.mFragments.s();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(androidx.lifecycle.g.b.ON_RESUME);
        this.mFragments.p();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.u();
        this.mFragments.s();
        this.mFragmentLifecycleRegistry.h(androidx.lifecycle.g.b.ON_START);
        this.mFragments.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.u();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.r();
        this.mFragmentLifecycleRegistry.h(androidx.lifecycle.g.b.ON_STOP);
    }

    public void setEnterSharedElementCallback(androidx.core.app.o oVar) {
        androidx.core.app.a.r(this, oVar);
    }

    public void setExitSharedElementCallback(androidx.core.app.o oVar) {
        androidx.core.app.a.s(this, oVar);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityFromFragment(fragment, intent, i2, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 == -1) {
            androidx.core.app.a.v(this, intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.a.n(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.a.o(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.a.w(this);
    }

    @Override // androidx.core.app.a.e
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i2) {
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            androidx.core.app.a.u(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i2, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    public d(int i2) {
        super(i2);
        this.mFragments = h.b(new c());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.l(this);
        this.mStopped = true;
        init();
    }
}
