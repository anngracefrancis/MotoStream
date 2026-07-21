package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.LiveData;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.k, androidx.lifecycle.a0, androidx.savedstate.c {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    i mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    private androidx.lifecycle.y.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    androidx.fragment.app.j<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.l mLifecycleRegistry;
    androidx.lifecycle.g.c mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<j> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    androidx.savedstate.b mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    y mViewLifecycleOwner;
    androidx.lifecycle.q<androidx.lifecycle.k> mViewLifecycleOwnerLiveData;
    String mWho;

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.callStartTransitionListener(false);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0 f1475f;

        c(a0 a0Var) {
            this.f1475f = a0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1475f.g();
        }
    }

    class d extends androidx.fragment.app.f {
        d() {
        }

        @Override // androidx.fragment.app.f
        public View c(int i2) {
            View view = Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i2);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        @Override // androidx.fragment.app.f
        public boolean d() {
            return Fragment.this.mView != null;
        }
    }

    class e implements c.b.a.c.a<Void, ActivityResultRegistry> {
        e() {
        }

        @Override // c.b.a.c.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActivityResultRegistry a(Void r3) {
            Fragment fragment = Fragment.this;
            Object obj = fragment.mHost;
            return obj instanceof androidx.activity.result.c ? ((androidx.activity.result.c) obj).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
        }
    }

    class f implements c.b.a.c.a<Void, ActivityResultRegistry> {
        final /* synthetic */ ActivityResultRegistry a;

        f(ActivityResultRegistry activityResultRegistry) {
            this.a = activityResultRegistry;
        }

        @Override // c.b.a.c.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActivityResultRegistry a(Void r1) {
            return this.a;
        }
    }

    class g extends j {
        final /* synthetic */ c.b.a.c.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference f1478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.activity.result.d.a f1479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ androidx.activity.result.a f1480d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(c.b.a.c.a aVar, AtomicReference atomicReference, androidx.activity.result.d.a aVar2, androidx.activity.result.a aVar3) {
            super(null);
            this.a = aVar;
            this.f1478b = atomicReference;
            this.f1479c = aVar2;
            this.f1480d = aVar3;
        }

        @Override // androidx.fragment.app.Fragment.j
        void a() {
            String strGenerateActivityResultKey = Fragment.this.generateActivityResultKey();
            this.f1478b.set(((ActivityResultRegistry) this.a.a(null)).j(strGenerateActivityResultKey, Fragment.this, this.f1479c, this.f1480d));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    class h<I> extends androidx.activity.result.b<I> {
        final /* synthetic */ AtomicReference a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.activity.result.d.a f1482b;

        h(AtomicReference atomicReference, androidx.activity.result.d.a aVar) {
            this.a = atomicReference;
            this.f1482b = aVar;
        }

        @Override // androidx.activity.result.b
        public void b(I i2, androidx.core.app.b bVar) {
            androidx.activity.result.b bVar2 = (androidx.activity.result.b) this.a.get();
            if (bVar2 == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            bVar2.b(i2, bVar);
        }

        @Override // androidx.activity.result.b
        public void c() {
            androidx.activity.result.b bVar = (androidx.activity.result.b) this.a.getAndSet(null);
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    static class i {
        View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Animator f1484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1486d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ArrayList<String> f1487e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ArrayList<String> f1488f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f1489g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f1490h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f1491i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f1492j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f1493k;
        Object l;
        Boolean m;
        Boolean n;
        androidx.core.app.o o;
        androidx.core.app.o p;
        float q;
        View r;
        boolean s;
        k t;
        boolean u;

        i() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.f1490h = obj;
            this.f1491i = null;
            this.f1492j = obj;
            this.f1493k = null;
            this.l = obj;
            this.q = 1.0f;
            this.r = null;
        }
    }

    private static abstract class j {
        private j() {
        }

        abstract void a();

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    interface k {
        void a();

        void b();
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new m();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new a();
        this.mMaxState = androidx.lifecycle.g.c.RESUMED;
        this.mViewLifecycleOwnerLiveData = new androidx.lifecycle.q<>();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList<>();
        initLifecycle();
    }

    private i ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new i();
        }
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        androidx.lifecycle.g.c cVar = this.mMaxState;
        return (cVar == androidx.lifecycle.g.c.INITIALIZED || this.mParentFragment == null) ? cVar.ordinal() : Math.min(cVar.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new androidx.lifecycle.l(this);
        this.mSavedStateRegistryController = androidx.savedstate.b.a(this);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    private <I, O> androidx.activity.result.b<I> prepareCallInternal(androidx.activity.result.d.a<I, O> aVar, c.b.a.c.a<Void, ActivityResultRegistry> aVar2, androidx.activity.result.a<O> aVar3) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            registerOnPreAttachListener(new g(aVar2, atomicReference, aVar, aVar3));
            return new h(atomicReference, aVar);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void registerOnPreAttachListener(j jVar) {
        if (this.mState >= 0) {
            jVar.a();
        } else {
            this.mOnPreAttachedListeners.add(jVar);
        }
    }

    void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        i iVar = this.mAnimationInfo;
        k kVar = null;
        if (iVar != null) {
            iVar.s = false;
            k kVar2 = iVar.t;
            iVar.t = null;
            kVar = kVar2;
        }
        if (kVar != null) {
            kVar.b();
            return;
        }
        if (!FragmentManager.f1494b || this.mView == null || (viewGroup = this.mContainer) == null || (fragmentManager = this.mFragmentManager) == null) {
            return;
        }
        a0 a0VarN = a0.n(viewGroup, fragmentManager);
        a0VarN.p();
        if (z) {
            this.mHost.g().post(new c(a0VarN));
        } else {
            a0VarN.g();
        }
    }

    androidx.fragment.app.f createFragmentContainer() {
        return new d();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(getNextAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            c.p.a.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.X(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.k0(str);
    }

    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final androidx.fragment.app.d getActivity() {
        androidx.fragment.app.j<?> jVar = this.mHost;
        if (jVar == null) {
            return null;
        }
        return (androidx.fragment.app.d) jVar.e();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    View getAnimatingAway() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.a;
    }

    Animator getAnimator() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f1484b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        androidx.fragment.app.j<?> jVar = this.mHost;
        if (jVar == null) {
            return null;
        }
        return jVar.f();
    }

    public androidx.lifecycle.y.b getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Application application = null;
            for (Context applicationContext = requireContext().getApplicationContext(); applicationContext instanceof ContextWrapper; applicationContext = ((ContextWrapper) applicationContext).getBaseContext()) {
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
            }
            if (application == null && FragmentManager.H0(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new androidx.lifecycle.v(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public Object getEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f1489g;
    }

    androidx.core.app.o getEnterTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.o;
    }

    public Object getExitTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f1491i;
    }

    androidx.core.app.o getExitTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.p;
    }

    View getFocusedView() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.r;
    }

    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        androidx.fragment.app.j<?> jVar = this.mHost;
        if (jVar == null) {
            return null;
        }
        return jVar.i();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.k
    public androidx.lifecycle.g getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public c.p.a.a getLoaderManager() {
        return c.p.a.a.b(this);
    }

    int getNextAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f1485c;
    }

    int getNextTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f1486d;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    float getPostOnViewCreatedAlpha() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.q;
    }

    public Object getReenterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f1492j;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f1490h;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // androidx.savedstate.c
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    public Object getSharedElementEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f1493k;
    }

    public Object getSharedElementReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.l;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        i iVar = this.mAnimationInfo;
        return (iVar == null || (arrayList = iVar.f1487e) == null) ? new ArrayList<>() : arrayList;
    }

    ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        i iVar = this.mAnimationInfo;
        return (iVar == null || (arrayList = iVar.f1488f) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i2) {
        return getResources().getString(i2);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return fragmentManager.h0(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i2) {
        return getResources().getText(i2);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public androidx.lifecycle.k getViewLifecycleOwner() {
        y yVar = this.mViewLifecycleOwner;
        if (yVar != null) {
            return yVar;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<androidx.lifecycle.k> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.a0
    public androidx.lifecycle.z getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (getMinimumMaxLifecycleState() != androidx.lifecycle.g.c.INITIALIZED.ordinal()) {
            return this.mFragmentManager.D0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new m();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    boolean isHideReplaced() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.u;
    }

    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        FragmentManager fragmentManager;
        return this.mMenuVisible && ((fragmentManager = this.mFragmentManager) == null || fragmentManager.J0(this.mParentFragment));
    }

    boolean isPostponed() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.s;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.M0();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.V0();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        androidx.fragment.app.j<?> jVar = this.mHost;
        Activity activityE = jVar == null ? null : jVar.e();
        if (activityE != null) {
            this.mCalled = false;
            onAttach(activityE);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.L0(1)) {
            return;
        }
        this.mChildFragmentManager.D();
    }

    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        return null;
    }

    public Animator onCreateAnimator(int i2, boolean z, int i3) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        androidx.fragment.app.j<?> jVar = this.mHost;
        Activity activityE = jVar == null ? null : jVar.e();
        if (activityE != null) {
            this.mCalled = false;
            onInflate(activityE, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.V0();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            restoreViewState();
            this.mChildFragmentManager.z();
        } else {
            throw new c0("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    void performAttach() {
        Iterator<j> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.k(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.f());
        if (this.mCalled) {
            this.mFragmentManager.J(this);
            this.mChildFragmentManager.A();
        } else {
            throw new c0("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.B(configuration);
    }

    boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.C(menuItem);
    }

    void performCreate(Bundle bundle) {
        this.mChildFragmentManager.V0();
        this.mState = 1;
        this.mCalled = false;
        if (Build.VERSION.SDK_INT >= 19) {
            this.mLifecycleRegistry.a(new androidx.lifecycle.i() { // from class: androidx.fragment.app.Fragment.5
                @Override // androidx.lifecycle.i
                public void a(androidx.lifecycle.k kVar, androidx.lifecycle.g.b bVar) {
                    View view;
                    if (bVar != androidx.lifecycle.g.b.ON_STOP || (view = Fragment.this.mView) == null) {
                        return;
                    }
                    view.cancelPendingInputEvents();
                }
            });
        }
        this.mSavedStateRegistryController.c(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.h(androidx.lifecycle.g.b.ON_CREATE);
            return;
        }
        throw new c0("Fragment " + this + " did not call through to super.onCreate()");
    }

    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.mChildFragmentManager.E(menu, menuInflater);
    }

    void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.V0();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new y();
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        if (viewOnCreateView == null) {
            if (this.mViewLifecycleOwner.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
        } else {
            this.mViewLifecycleOwner.b();
            androidx.lifecycle.b0.a(this.mView, this.mViewLifecycleOwner);
            androidx.lifecycle.c0.a(this.mView, this);
            androidx.savedstate.d.a(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.n(this.mViewLifecycleOwner);
        }
    }

    void performDestroy() {
        this.mChildFragmentManager.F();
        this.mLifecycleRegistry.h(androidx.lifecycle.g.b.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new c0("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDestroyView() {
        this.mChildFragmentManager.G();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().b().g(androidx.lifecycle.g.c.CREATED)) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.g.b.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            c.p.a.a.b(this).d();
            this.mPerformedCreateView = false;
        } else {
            throw new c0("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            if (this.mChildFragmentManager.G0()) {
                return;
            }
            this.mChildFragmentManager.F();
            this.mChildFragmentManager = new m();
            return;
        }
        throw new c0("Fragment " + this + " did not call through to super.onDetach()");
    }

    LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.H();
    }

    void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.I(z);
    }

    boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.K(menuItem);
    }

    void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.L(menu);
    }

    void performPause() {
        this.mChildFragmentManager.N();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.g.b.ON_PAUSE);
        }
        this.mLifecycleRegistry.h(androidx.lifecycle.g.b.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new c0("Fragment " + this + " did not call through to super.onPause()");
    }

    void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.O(z);
    }

    boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.mChildFragmentManager.P(menu);
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean zK0 = this.mFragmentManager.K0(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zK0) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zK0);
            onPrimaryNavigationFragmentChanged(zK0);
            this.mChildFragmentManager.Q();
        }
    }

    void performResume() {
        this.mChildFragmentManager.V0();
        this.mChildFragmentManager.b0(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new c0("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.l lVar = this.mLifecycleRegistry;
        androidx.lifecycle.g.b bVar = androidx.lifecycle.g.b.ON_RESUME;
        lVar.h(bVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bVar);
        }
        this.mChildFragmentManager.R();
    }

    void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.d(bundle);
        Parcelable parcelableM1 = this.mChildFragmentManager.m1();
        if (parcelableM1 != null) {
            bundle.putParcelable("android:support:fragments", parcelableM1);
        }
    }

    void performStart() {
        this.mChildFragmentManager.V0();
        this.mChildFragmentManager.b0(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new c0("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.l lVar = this.mLifecycleRegistry;
        androidx.lifecycle.g.b bVar = androidx.lifecycle.g.b.ON_START;
        lVar.h(bVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bVar);
        }
        this.mChildFragmentManager.S();
    }

    void performStop() {
        this.mChildFragmentManager.U();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.g.b.ON_STOP);
        }
        this.mLifecycleRegistry.h(androidx.lifecycle.g.b.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new c0("Fragment " + this + " did not call through to super.onStop()");
    }

    void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.V();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().s = true;
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.d.a<I, O> aVar, androidx.activity.result.a<O> aVar2) {
        return prepareCallInternal(aVar, new e(), aVar2);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i2) {
        if (this.mHost != null) {
            getParentFragmentManager().N0(this, strArr, i2);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final androidx.fragment.app.d requireActivity() {
        androidx.fragment.app.d activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.k1(parcelable);
        this.mChildFragmentManager.D();
    }

    final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.d(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(androidx.lifecycle.g.b.ON_CREATE);
            }
        } else {
            throw new c0("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().n = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().m = Boolean.valueOf(z);
    }

    void setAnimatingAway(View view) {
        ensureAnimationInfo().a = view;
    }

    void setAnimator(Animator animator) {
        ensureAnimationInfo().f1484b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(androidx.core.app.o oVar) {
        ensureAnimationInfo().o = oVar;
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().f1489g = obj;
    }

    public void setExitSharedElementCallback(androidx.core.app.o oVar) {
        ensureAnimationInfo().p = oVar;
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().f1491i = obj;
    }

    void setFocusedView(View view) {
        ensureAnimationInfo().r = view;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.p();
        }
    }

    void setHideReplaced(boolean z) {
        ensureAnimationInfo().u = z;
    }

    public void setInitialSavedState(SavedState savedState) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (savedState == null || (bundle = savedState.f1472f) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.p();
            }
        }
    }

    void setNextAnim(int i2) {
        if (this.mAnimationInfo == null && i2 == 0) {
            return;
        }
        ensureAnimationInfo().f1485c = i2;
    }

    void setNextTransition(int i2) {
        if (this.mAnimationInfo == null && i2 == 0) {
            return;
        }
        ensureAnimationInfo();
        this.mAnimationInfo.f1486d = i2;
    }

    void setOnStartEnterTransitionListener(k kVar) {
        ensureAnimationInfo();
        i iVar = this.mAnimationInfo;
        k kVar2 = iVar.t;
        if (kVar == kVar2) {
            return;
        }
        if (kVar != null && kVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (iVar.s) {
            iVar.t = kVar;
        }
        if (kVar != null) {
            kVar.a();
        }
    }

    void setPostOnViewCreatedAlpha(float f2) {
        ensureAnimationInfo().q = f2;
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().f1492j = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            fragmentManager.i(this);
        } else {
            fragmentManager.i1(this);
        }
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().f1490h = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().f1493k = obj;
    }

    void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ensureAnimationInfo();
        i iVar = this.mAnimationInfo;
        iVar.f1487e = arrayList;
        iVar.f1488f = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().l = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i2) {
        FragmentManager fragmentManager = this.mFragmentManager;
        FragmentManager fragmentManager2 = fragment != null ? fragment.mFragmentManager : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment targetFragment = fragment; targetFragment != null; targetFragment = targetFragment.getTargetFragment()) {
            if (targetFragment.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i2;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            FragmentManager fragmentManager = this.mFragmentManager;
            fragmentManager.W0(fragmentManager.w(this));
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 5 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        androidx.fragment.app.j<?> jVar = this.mHost;
        if (jVar != null) {
            return jVar.m(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityForResult(intent, i2, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i2 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        getParentFragmentManager().P0(this, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !ensureAnimationInfo().s) {
            return;
        }
        if (this.mHost == null) {
            ensureAnimationInfo().s = false;
        } else if (Looper.myLooper() != this.mHost.g().getLooper()) {
            this.mHost.g().postAtFrontOfQueue(new b());
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")");
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Bundle f1472f;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        SavedState(Bundle bundle) {
            this.f1472f = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeBundle(this.f1472f);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f1472f = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragmentNewInstance = androidx.fragment.app.i.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.setArguments(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (java.lang.InstantiationException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    public final String getString(int i2, Object... objArr) {
        return getResources().getString(i2, objArr);
    }

    public final void postponeEnterTransition(long j2, TimeUnit timeUnit) {
        ensureAnimationInfo().s = true;
        FragmentManager fragmentManager = this.mFragmentManager;
        Handler handlerG = fragmentManager != null ? fragmentManager.w0().g() : new Handler(Looper.getMainLooper());
        handlerG.removeCallbacks(this.mPostponedDurationRunnable);
        handlerG.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j2));
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.d.a<I, O> aVar, ActivityResultRegistry activityResultRegistry, androidx.activity.result.a<O> aVar2) {
        return prepareCallInternal(aVar, new f(activityResultRegistry), aVar2);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        androidx.fragment.app.j<?> jVar = this.mHost;
        if (jVar != null) {
            jVar.n(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (this.mHost != null) {
            getParentFragmentManager().O0(this, intent, i2, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        androidx.fragment.app.j<?> jVar = this.mHost;
        if (jVar != null) {
            LayoutInflater layoutInflaterJ = jVar.j();
            androidx.core.view.f.b(layoutInflaterJ, this.mChildFragmentManager.x0());
            return layoutInflaterJ;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    private void restoreViewState() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    public Fragment(int i2) {
        this();
        this.mContentLayoutId = i2;
    }
}
