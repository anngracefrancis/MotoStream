package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: compiled from: FragmentStateManager.java */
/* JADX INFO: loaded from: classes.dex */
class r {
    private final l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f1632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Fragment f1633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1634d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1635e = -1;

    /* JADX INFO: compiled from: FragmentStateManager.java */
    class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f1636f;

        a(View view) {
            this.f1636f = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f1636f.removeOnAttachStateChangeListener(this);
            androidx.core.view.u.f0(this.f1636f);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: compiled from: FragmentStateManager.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[androidx.lifecycle.g.c.values().length];
            a = iArr;
            try {
                iArr[androidx.lifecycle.g.c.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[androidx.lifecycle.g.c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[androidx.lifecycle.g.c.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[androidx.lifecycle.g.c.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    r(l lVar, t tVar, Fragment fragment) {
        this.a = lVar;
        this.f1632b = tVar;
        this.f1633c = fragment;
    }

    private boolean l(View view) {
        if (view == this.f1633c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f1633c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f1633c.performSaveInstanceState(bundle);
        this.a.j(this.f1633c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f1633c.mView != null) {
            t();
        }
        if (this.f1633c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f1633c.mSavedViewState);
        }
        if (this.f1633c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f1633c.mSavedViewRegistryState);
        }
        if (!this.f1633c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f1633c.mUserVisibleHint);
        }
        return bundle;
    }

    void a() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f1633c);
        }
        Fragment fragment = this.f1633c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        l lVar = this.a;
        Fragment fragment2 = this.f1633c;
        lVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    void b() {
        int iJ = this.f1632b.j(this.f1633c);
        Fragment fragment = this.f1633c;
        fragment.mContainer.addView(fragment.mView, iJ);
    }

    void c() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f1633c);
        }
        Fragment fragment = this.f1633c;
        Fragment fragment2 = fragment.mTarget;
        r rVarM = null;
        if (fragment2 != null) {
            r rVarM2 = this.f1632b.m(fragment2.mWho);
            if (rVarM2 == null) {
                throw new IllegalStateException("Fragment " + this.f1633c + " declared target fragment " + this.f1633c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f1633c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            rVarM = rVarM2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (rVarM = this.f1632b.m(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f1633c + " declared target fragment " + this.f1633c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (rVarM != null && (FragmentManager.f1494b || rVarM.k().mState < 1)) {
            rVarM.m();
        }
        Fragment fragment4 = this.f1633c;
        fragment4.mHost = fragment4.mFragmentManager.w0();
        Fragment fragment5 = this.f1633c;
        fragment5.mParentFragment = fragment5.mFragmentManager.z0();
        this.a.g(this.f1633c, false);
        this.f1633c.performAttach();
        this.a.b(this.f1633c, false);
    }

    int d() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f1633c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int iMin = this.f1635e;
        int i2 = b.a[fragment2.mMaxState.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                iMin = Math.min(iMin, 5);
            } else if (i2 != 3) {
                iMin = i2 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0);
            } else {
                iMin = Math.min(iMin, 1);
            }
        }
        Fragment fragment3 = this.f1633c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                iMin = Math.max(this.f1635e, 2);
                View view = this.f1633c.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f1635e < 4 ? Math.min(iMin, fragment3.mState) : Math.min(iMin, 1);
            }
        }
        if (!this.f1633c.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        a0.e.b bVarL = null;
        if (FragmentManager.f1494b && (viewGroup = (fragment = this.f1633c).mContainer) != null) {
            bVarL = a0.n(viewGroup, fragment.getParentFragmentManager()).l(this);
        }
        if (bVarL == a0.e.b.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (bVarL == a0.e.b.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f1633c;
            if (fragment4.mRemoving) {
                iMin = fragment4.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f1633c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f1633c);
        }
        return iMin;
    }

    void e() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f1633c);
        }
        Fragment fragment = this.f1633c;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.f1633c.mState = 1;
            return;
        }
        this.a.h(fragment, fragment.mSavedFragmentState, false);
        Fragment fragment2 = this.f1633c;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        l lVar = this.a;
        Fragment fragment3 = this.f1633c;
        lVar.c(fragment3, fragment3.mSavedFragmentState, false);
    }

    void f() {
        String resourceName;
        if (this.f1633c.mFromLayout) {
            return;
        }
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1633c);
        }
        Fragment fragment = this.f1633c;
        LayoutInflater layoutInflaterPerformGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = null;
        Fragment fragment2 = this.f1633c;
        ViewGroup viewGroup2 = fragment2.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i2 = fragment2.mContainerId;
            if (i2 != 0) {
                if (i2 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f1633c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.mFragmentManager.q0().c(this.f1633c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f1633c;
                    if (!fragment3.mRestored) {
                        try {
                            resourceName = fragment3.getResources().getResourceName(this.f1633c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f1633c.mContainerId) + " (" + resourceName + ") for fragment " + this.f1633c);
                    }
                }
            }
        }
        Fragment fragment4 = this.f1633c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.f1633c.mView;
        if (view != null) {
            boolean z = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f1633c;
            fragment5.mView.setTag(c.m.b.a, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f1633c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (androidx.core.view.u.N(this.f1633c.mView)) {
                androidx.core.view.u.f0(this.f1633c.mView);
            } else {
                View view2 = this.f1633c.mView;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f1633c.performViewCreated();
            l lVar = this.a;
            Fragment fragment7 = this.f1633c;
            lVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.f1633c.mView.getVisibility();
            float alpha = this.f1633c.mView.getAlpha();
            if (FragmentManager.f1494b) {
                this.f1633c.setPostOnViewCreatedAlpha(alpha);
                Fragment fragment8 = this.f1633c;
                if (fragment8.mContainer != null && visibility == 0) {
                    View viewFindFocus = fragment8.mView.findFocus();
                    if (viewFindFocus != null) {
                        this.f1633c.setFocusedView(viewFindFocus);
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f1633c);
                        }
                    }
                    this.f1633c.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.f1633c;
                if (visibility == 0 && fragment9.mContainer != null) {
                    z = true;
                }
                fragment9.mIsNewlyAdded = z;
            }
        }
        this.f1633c.mState = 2;
    }

    void g() {
        Fragment fragmentF;
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f1633c);
        }
        Fragment fragment = this.f1633c;
        boolean zIsChangingConfigurations = true;
        boolean z = fragment.mRemoving && !fragment.isInBackStack();
        if (!(z || this.f1632b.o().p(this.f1633c))) {
            String str = this.f1633c.mTargetWho;
            if (str != null && (fragmentF = this.f1632b.f(str)) != null && fragmentF.mRetainInstance) {
                this.f1633c.mTarget = fragmentF;
            }
            this.f1633c.mState = 0;
            return;
        }
        j<?> jVar = this.f1633c.mHost;
        if (jVar instanceof androidx.lifecycle.a0) {
            zIsChangingConfigurations = this.f1632b.o().m();
        } else if (jVar.f() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) jVar.f()).isChangingConfigurations();
        }
        if (z || zIsChangingConfigurations) {
            this.f1632b.o().g(this.f1633c);
        }
        this.f1633c.performDestroy();
        this.a.d(this.f1633c, false);
        for (r rVar : this.f1632b.k()) {
            if (rVar != null) {
                Fragment fragmentK = rVar.k();
                if (this.f1633c.mWho.equals(fragmentK.mTargetWho)) {
                    fragmentK.mTarget = this.f1633c;
                    fragmentK.mTargetWho = null;
                }
            }
        }
        Fragment fragment2 = this.f1633c;
        String str2 = fragment2.mTargetWho;
        if (str2 != null) {
            fragment2.mTarget = this.f1632b.f(str2);
        }
        this.f1632b.q(this);
    }

    void h() {
        View view;
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f1633c);
        }
        Fragment fragment = this.f1633c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f1633c.performDestroyView();
        this.a.n(this.f1633c, false);
        Fragment fragment2 = this.f1633c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.n(null);
        this.f1633c.mInLayout = false;
    }

    void i() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f1633c);
        }
        this.f1633c.performDetach();
        boolean z = false;
        this.a.e(this.f1633c, false);
        Fragment fragment = this.f1633c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z = true;
        }
        if (z || this.f1632b.o().p(this.f1633c)) {
            if (FragmentManager.H0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f1633c);
            }
            this.f1633c.initState();
        }
    }

    void j() {
        Fragment fragment = this.f1633c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.H0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1633c);
            }
            Fragment fragment2 = this.f1633c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f1633c.mSavedFragmentState);
            View view = this.f1633c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f1633c;
                fragment3.mView.setTag(c.m.b.a, fragment3);
                Fragment fragment4 = this.f1633c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f1633c.performViewCreated();
                l lVar = this.a;
                Fragment fragment5 = this.f1633c;
                lVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f1633c.mState = 2;
            }
        }
    }

    Fragment k() {
        return this.f1633c;
    }

    void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f1634d) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f1634d = true;
            while (true) {
                int iD = d();
                Fragment fragment = this.f1633c;
                int i2 = fragment.mState;
                if (iD == i2) {
                    if (FragmentManager.f1494b && fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            a0 a0VarN = a0.n(viewGroup, fragment.getParentFragmentManager());
                            if (this.f1633c.mHidden) {
                                a0VarN.c(this);
                            } else {
                                a0VarN.e(this);
                            }
                        }
                        Fragment fragment2 = this.f1633c;
                        fragment2.mHiddenChanged = false;
                        fragment2.onHiddenChanged(fragment2.mHidden);
                    }
                    return;
                }
                if (iD <= i2) {
                    switch (i2 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            this.f1633c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (FragmentManager.H0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f1633c);
                            }
                            Fragment fragment3 = this.f1633c;
                            if (fragment3.mView != null && fragment3.mSavedViewState == null) {
                                t();
                            }
                            Fragment fragment4 = this.f1633c;
                            if (fragment4.mView != null && (viewGroup3 = fragment4.mContainer) != null) {
                                a0.n(viewGroup3, fragment4.getParentFragmentManager()).d(this);
                            }
                            this.f1633c.mState = 3;
                            break;
                        case 4:
                            w();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i2 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                a0.n(viewGroup2, fragment.getParentFragmentManager()).b(a0.e.c.k(this.f1633c.mView.getVisibility()), this);
                            }
                            this.f1633c.mState = 4;
                            break;
                        case 5:
                            v();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
            }
        } finally {
            this.f1634d = false;
        }
    }

    void n() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f1633c);
        }
        this.f1633c.performPause();
        this.a.f(this.f1633c, false);
    }

    void o(ClassLoader classLoader) {
        Bundle bundle = this.f1633c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f1633c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f1633c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f1633c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        Fragment fragment4 = this.f1633c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f1633c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.f1633c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f1633c;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    void p() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f1633c);
        }
        View focusedView = this.f1633c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean zRequestFocus = focusedView.requestFocus();
            if (FragmentManager.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(zRequestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f1633c);
                sb.append(" resulting in focused view ");
                sb.append(this.f1633c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f1633c.setFocusedView(null);
        this.f1633c.performResume();
        this.a.i(this.f1633c, false);
        Fragment fragment = this.f1633c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    Fragment.SavedState r() {
        Bundle bundleQ;
        if (this.f1633c.mState <= -1 || (bundleQ = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(bundleQ);
    }

    FragmentState s() {
        FragmentState fragmentState = new FragmentState(this.f1633c);
        Fragment fragment = this.f1633c;
        if (fragment.mState <= -1 || fragmentState.r != null) {
            fragmentState.r = fragment.mSavedFragmentState;
        } else {
            Bundle bundleQ = q();
            fragmentState.r = bundleQ;
            if (this.f1633c.mTargetWho != null) {
                if (bundleQ == null) {
                    fragmentState.r = new Bundle();
                }
                fragmentState.r.putString("android:target_state", this.f1633c.mTargetWho);
                int i2 = this.f1633c.mTargetRequestCode;
                if (i2 != 0) {
                    fragmentState.r.putInt("android:target_req_state", i2);
                }
            }
        }
        return fragmentState;
    }

    void t() {
        if (this.f1633c.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f1633c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f1633c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f1633c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f1633c.mSavedViewRegistryState = bundle;
    }

    void u(int i2) {
        this.f1635e = i2;
    }

    void v() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f1633c);
        }
        this.f1633c.performStart();
        this.a.k(this.f1633c, false);
    }

    void w() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f1633c);
        }
        this.f1633c.performStop();
        this.a.l(this.f1633c, false);
    }

    r(l lVar, t tVar, ClassLoader classLoader, i iVar, FragmentState fragmentState) {
        this.a = lVar;
        this.f1632b = tVar;
        Fragment fragmentA = iVar.a(classLoader, fragmentState.f1528f);
        this.f1633c = fragmentA;
        Bundle bundle = fragmentState.o;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentA.setArguments(fragmentState.o);
        fragmentA.mWho = fragmentState.f1529g;
        fragmentA.mFromLayout = fragmentState.f1530h;
        fragmentA.mRestored = true;
        fragmentA.mFragmentId = fragmentState.f1531i;
        fragmentA.mContainerId = fragmentState.f1532j;
        fragmentA.mTag = fragmentState.f1533k;
        fragmentA.mRetainInstance = fragmentState.l;
        fragmentA.mRemoving = fragmentState.m;
        fragmentA.mDetached = fragmentState.n;
        fragmentA.mHidden = fragmentState.p;
        fragmentA.mMaxState = androidx.lifecycle.g.c.values()[fragmentState.q];
        Bundle bundle2 = fragmentState.r;
        if (bundle2 != null) {
            fragmentA.mSavedFragmentState = bundle2;
        } else {
            fragmentA.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentA);
        }
    }

    r(l lVar, t tVar, Fragment fragment, FragmentState fragmentState) {
        this.a = lVar;
        this.f1632b = tVar;
        this.f1633c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.r;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
