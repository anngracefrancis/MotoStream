package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: PreferenceFragmentCompat.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class g extends Fragment implements j.c, j.a, j.b, DialogPreference.a {
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private static final String TAG = "PreferenceFragment";
    private boolean mHavePrefs;
    private boolean mInitDone;
    RecyclerView mList;
    private j mPreferenceManager;
    private Runnable mSelectPreferenceRunnable;
    private final d mDividerDecoration = new d();
    private int mLayoutResId = q.f1880c;
    private Handler mHandler = new a();
    private final Runnable mRequestFocus = new b();

    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            g.this.bindPreferences();
        }
    }

    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    class b implements Runnable {
        b() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = g.this.mList;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Preference f1820f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f1821g;

        c(Preference preference, String str) {
            this.f1820f = preference;
            this.f1821g = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            RecyclerView.g adapter = g.this.mList.getAdapter();
            if (!(adapter instanceof PreferenceGroup.c)) {
                if (adapter != 0) {
                    throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
                }
                return;
            }
            Preference preference = this.f1820f;
            int iC = preference != null ? ((PreferenceGroup.c) adapter).c(preference) : ((PreferenceGroup.c) adapter).f(this.f1821g);
            if (iC != -1) {
                g.this.mList.scrollToPosition(iC);
            } else {
                adapter.registerAdapterDataObserver(new h(adapter, g.this.mList, this.f1820f, this.f1821g));
            }
        }
    }

    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    private class d extends RecyclerView.n {
        private Drawable a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1824c = true;

        d() {
        }

        private boolean g(View view, RecyclerView recyclerView) {
            RecyclerView.c0 childViewHolder = recyclerView.getChildViewHolder(view);
            boolean z = false;
            if (!((childViewHolder instanceof l) && ((l) childViewHolder).c())) {
                return false;
            }
            boolean z2 = this.f1824c;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z2;
            }
            RecyclerView.c0 childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(iIndexOfChild + 1));
            if ((childViewHolder2 instanceof l) && ((l) childViewHolder2).b()) {
                z = true;
            }
            return z;
        }

        public void d(boolean z) {
            this.f1824c = z;
        }

        public void e(Drawable drawable) {
            if (drawable != null) {
                this.f1823b = drawable.getIntrinsicHeight();
            } else {
                this.f1823b = 0;
            }
            this.a = drawable;
            g.this.mList.invalidateItemDecorations();
        }

        public void f(int i2) {
            this.f1823b = i2;
            g.this.mList.invalidateItemDecorations();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
            if (g(view, recyclerView)) {
                rect.bottom = this.f1823b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
            if (this.a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (g(childAt, recyclerView)) {
                    int y = ((int) childAt.getY()) + childAt.getHeight();
                    this.a.setBounds(0, y, width, this.f1823b + y);
                    this.a.draw(canvas);
                }
            }
        }
    }

    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    public interface e {
        boolean a(g gVar, Preference preference);
    }

    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    public interface f {
        boolean a(g gVar, Preference preference);
    }

    /* JADX INFO: renamed from: androidx.preference.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    public interface InterfaceC0039g {
        boolean a(g gVar, PreferenceScreen preferenceScreen);
    }

    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    private static class h extends RecyclerView.i {
        private final RecyclerView.g a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RecyclerView f1826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Preference f1827c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f1828d;

        public h(RecyclerView.g gVar, RecyclerView recyclerView, Preference preference, String str) {
            this.a = gVar;
            this.f1826b = recyclerView;
            this.f1827c = preference;
            this.f1828d = str;
        }

        private void a() {
            this.a.unregisterAdapterDataObserver(this);
            Preference preference = this.f1827c;
            int iC = preference != null ? ((PreferenceGroup.c) this.a).c(preference) : ((PreferenceGroup.c) this.a).f(this.f1828d);
            if (iC != -1) {
                this.f1826b.scrollToPosition(iC);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onChanged() {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeChanged(int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeInserted(int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeMoved(int i2, int i3, int i4) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeRemoved(int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeChanged(int i2, int i3, Object obj) {
            a();
        }
    }

    private void postBindPreferences() {
        if (this.mHandler.hasMessages(1)) {
            return;
        }
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    private void requirePreferenceManager() {
        if (this.mPreferenceManager == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void scrollToPreferenceInternal(Preference preference, String str) {
        c cVar = new c(preference, str);
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = cVar;
        } else {
            cVar.run();
        }
    }

    private void unbindPreferences() {
        getListView().setAdapter(null);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.n0();
        }
        onUnbindPreferences();
    }

    public void addPreferencesFromResource(int i2) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.k(getContext(), i2, getPreferenceScreen()));
    }

    void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(onCreateAdapter(preferenceScreen));
            preferenceScreen.h0();
        }
        onBindPreferences();
    }

    @Override // androidx.preference.DialogPreference.a
    public <T extends Preference> T findPreference(CharSequence charSequence) {
        j jVar = this.mPreferenceManager;
        if (jVar == null) {
            return null;
        }
        return (T) jVar.a(charSequence);
    }

    public Fragment getCallbackFragment() {
        return null;
    }

    public final RecyclerView getListView() {
        return this.mList;
    }

    public j getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.i();
    }

    protected void onBindPreferences() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(m.f1872j, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            i2 = s.a;
        }
        getActivity().getTheme().applyStyle(i2, false);
        j jVar = new j(getContext());
        this.mPreferenceManager = jVar;
        jVar.n(this);
        onCreatePreferences(bundle, getArguments() != null ? getArguments().getString(ARG_PREFERENCE_ROOT) : null);
    }

    protected RecyclerView.g onCreateAdapter(PreferenceScreen preferenceScreen) {
        return new androidx.preference.h(preferenceScreen);
    }

    public RecyclerView.o onCreateLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    public abstract void onCreatePreferences(Bundle bundle, String str);

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (getContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(p.f1874b)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(q.f1881d, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        recyclerView2.setAccessibilityDelegateCompat(new k(recyclerView2));
        return recyclerView2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, t.c1, m.f1869g, 0);
        this.mLayoutResId = typedArrayObtainStyledAttributes.getResourceId(t.d1, this.mLayoutResId);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(t.e1);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(t.f1, -1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(t.g1, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(getContext());
        View viewInflate = layoutInflaterCloneInContext.inflate(this.mLayoutResId, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewOnCreateRecyclerView = onCreateRecyclerView(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewOnCreateRecyclerView == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.mList = recyclerViewOnCreateRecyclerView;
        recyclerViewOnCreateRecyclerView.addItemDecoration(this.mDividerDecoration);
        setDivider(drawable);
        if (dimensionPixelSize != -1) {
            setDividerHeight(dimensionPixelSize);
        }
        this.mDividerDecoration.d(z);
        if (this.mList.getParent() == null) {
            viewGroup2.addView(this.mList);
        }
        this.mHandler.post(this.mRequestFocus);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            unbindPreferences();
        }
        this.mList = null;
        super.onDestroyView();
    }

    @Override // androidx.preference.j.a
    public void onDisplayPreferenceDialog(Preference preference) {
        androidx.fragment.app.c cVarL;
        boolean zA = getCallbackFragment() instanceof e ? ((e) getCallbackFragment()).a(this, preference) : false;
        if (!zA && (getActivity() instanceof e)) {
            zA = ((e) getActivity()).a(this, preference);
        }
        if (!zA && getFragmentManager().j0(DIALOG_FRAGMENT_TAG) == null) {
            if (preference instanceof EditTextPreference) {
                cVarL = androidx.preference.a.l(preference.J());
            } else if (preference instanceof ListPreference) {
                cVarL = androidx.preference.c.l(preference.J());
            } else {
                if (!(preference instanceof MultiSelectListPreference)) {
                    throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
                }
                cVarL = androidx.preference.d.l(preference.J());
            }
            cVarL.setTargetFragment(this, 0);
            cVarL.show(getFragmentManager(), DIALOG_FRAGMENT_TAG);
        }
    }

    @Override // androidx.preference.j.b
    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        if ((getCallbackFragment() instanceof InterfaceC0039g ? ((InterfaceC0039g) getCallbackFragment()).a(this, preferenceScreen) : false) || !(getActivity() instanceof InterfaceC0039g)) {
            return;
        }
        ((InterfaceC0039g) getActivity()).a(this, preferenceScreen);
    }

    @Override // androidx.preference.j.c
    public boolean onPreferenceTreeClick(Preference preference) {
        if (preference.G() == null) {
            return false;
        }
        boolean zA = getCallbackFragment() instanceof f ? ((f) getCallbackFragment()).a(this, preference) : false;
        if (!zA && (getActivity() instanceof f)) {
            zA = ((f) getActivity()).a(this, preference);
        }
        if (zA) {
            return true;
        }
        Log.w(TAG, "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Bundle bundleE = preference.E();
        Fragment fragmentA = supportFragmentManager.t0().a(requireActivity().getClassLoader(), preference.G());
        fragmentA.setArguments(bundleE);
        fragmentA.setTargetFragment(this, 0);
        supportFragmentManager.m().q(((View) getView().getParent()).getId(), fragmentA).g(null).i();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.F0(bundle2);
            bundle.putBundle(PREFERENCES_TAG, bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mPreferenceManager.o(this);
        this.mPreferenceManager.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mPreferenceManager.o(null);
        this.mPreferenceManager.m(null);
    }

    protected void onUnbindPreferences() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle(PREFERENCES_TAG)) != null && (preferenceScreen = getPreferenceScreen()) != null) {
            preferenceScreen.E0(bundle2);
        }
        if (this.mHavePrefs) {
            bindPreferences();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    public void scrollToPreference(String str) {
        scrollToPreferenceInternal(null, str);
    }

    public void setDivider(Drawable drawable) {
        this.mDividerDecoration.e(drawable);
    }

    public void setDividerHeight(int i2) {
        this.mDividerDecoration.f(i2);
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (!this.mPreferenceManager.p(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        onUnbindPreferences();
        this.mHavePrefs = true;
        if (this.mInitDone) {
            postBindPreferences();
        }
    }

    public void setPreferencesFromResource(int i2, String str) {
        Preference preferenceB1;
        requirePreferenceManager();
        PreferenceScreen preferenceScreenK = this.mPreferenceManager.k(getContext(), i2, null);
        Preference preference = preferenceScreenK;
        if (str != null) {
            preferenceB1 = preferenceScreenK.b1(str);
            if (!(preferenceB1 instanceof PreferenceScreen)) {
                preference = preferenceB1;
                throw new IllegalArgumentException("Preference object with key " + str + " is not a PreferenceScreen");
            }
        }
        preference = preferenceB1;
        setPreferenceScreen((PreferenceScreen) preference);
    }

    public void scrollToPreference(Preference preference) {
        scrollToPreferenceInternal(preference, null);
    }
}
