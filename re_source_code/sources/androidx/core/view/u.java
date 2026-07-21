package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f1058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f1060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f1061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static WeakHashMap<View, String> f1062f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Field f1064h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ThreadLocal<Rect> f1066j;
    private static final AtomicInteger a = new AtomicInteger(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static WeakHashMap<View, y> f1063g = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f1065i = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f1067k = {c.i.c.f3168b, c.i.c.f3169c, c.i.c.n, c.i.c.y, c.i.c.B, c.i.c.C, c.i.c.D, c.i.c.E, c.i.c.F, c.i.c.G, c.i.c.f3170d, c.i.c.f3171e, c.i.c.f3172f, c.i.c.f3173g, c.i.c.f3174h, c.i.c.f3175i, c.i.c.f3176j, c.i.c.f3177k, c.i.c.l, c.i.c.m, c.i.c.o, c.i.c.p, c.i.c.q, c.i.c.r, c.i.c.s, c.i.c.t, c.i.c.u, c.i.c.v, c.i.c.w, c.i.c.x, c.i.c.z, c.i.c.A};
    private static final q l = new a();
    private static f m = new f();

    /* JADX INFO: compiled from: ViewCompat.java */
    class a implements q {
        a() {
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    class b extends g<Boolean> {
        b(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.u.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.u.g
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            view.setScreenReaderFocusable(bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.u.g
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    class c extends g<CharSequence> {
        c(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.u.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return view.getAccessibilityPaneTitle();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.u.g
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.u.g
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    class d extends g<CharSequence> {
        d(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.u.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return view.getStateDescription();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.u.g
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.u.g
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    class e extends g<Boolean> {
        e(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.u.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.u.g
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            view.setAccessibilityHeading(bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.u.g
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    static class f implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f1068f = new WeakHashMap<>();

        f() {
        }

        private void a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                u.S(view, z2 ? 16 : 32);
                this.f1068f.put(view, Boolean.valueOf(z2));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f1068f.entrySet()) {
                    a(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    static abstract class g<T> {
        private final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<T> f1069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f1071d;

        g(int i2, Class<T> cls, int i3) {
            this(i2, cls, 0, i3);
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.f1070c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        abstract T d(View view);

        abstract void e(View view, T t);

        T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T t = (T) view.getTag(this.a);
            if (this.f1069b.isInstance(t)) {
                return t;
            }
            return null;
        }

        void g(View view, T t) {
            if (c()) {
                e(view, t);
            } else if (b() && h(f(view), t)) {
                u.B(view);
                view.setTag(this.a, t);
                u.S(view, this.f1071d);
            }
        }

        abstract boolean h(T t, T t2);

        g(int i2, Class<T> cls, int i3, int i4) {
            this.a = i2;
            this.f1069b = cls;
            this.f1071d = i3;
            this.f1070c = i4;
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    private static class h {

        /* JADX INFO: compiled from: ViewCompat.java */
        class a implements View.OnApplyWindowInsetsListener {
            c0 a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f1072b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ p f1073c;

            a(View view, p pVar) {
                this.f1072b = view;
                this.f1073c = pVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                c0 c0VarV = c0.v(windowInsets, view);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 30) {
                    h.a(windowInsets, this.f1072b);
                    if (c0VarV.equals(this.a)) {
                        return this.f1073c.a(view, c0VarV).t();
                    }
                }
                this.a = c0VarV;
                c0 c0VarA = this.f1073c.a(view, c0VarV);
                if (i2 >= 30) {
                    return c0VarA.t();
                }
                u.f0(view);
                return c0VarA.t();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(c.i.c.R);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static c0 b(View view, c0 c0Var, Rect rect) {
            WindowInsets windowInsetsT = c0Var.t();
            if (windowInsetsT != null) {
                return c0.v(view.computeSystemWindowInsets(windowInsetsT, rect), view);
            }
            rect.setEmpty();
            return c0Var;
        }

        public static c0 c(View view) {
            return c0.a.a(view);
        }

        static void d(View view, p pVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(c.i.c.L, pVar);
            }
            if (pVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(c.i.c.R));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, pVar));
            }
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    private static class i {
        public static c0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            c0 c0VarU = c0.u(rootWindowInsets);
            c0VarU.r(c0VarU);
            c0VarU.d(view.getRootView());
            return c0VarU;
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    private static class j {
        static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public interface k {
        boolean a(View view, KeyEvent keyEvent);
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    static class l {
        private static final ArrayList<WeakReference<View>> a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f1074b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SparseArray<WeakReference<View>> f1075c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private WeakReference<KeyEvent> f1076d = null;

        l() {
        }

        static l a(View view) {
            int i2 = c.i.c.P;
            l lVar = (l) view.getTag(i2);
            if (lVar != null) {
                return lVar;
            }
            l lVar2 = new l();
            view.setTag(i2, lVar2);
            return lVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f1074b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f1075c == null) {
                this.f1075c = new SparseArray<>();
            }
            return this.f1075c;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(c.i.c.Q);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((k) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f1074b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = a;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f1074b == null) {
                    this.f1074b = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = a;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f1074b.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f1074b.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(viewC));
                }
            }
            return viewC != null;
        }

        boolean f(KeyEvent keyEvent) {
            int iIndexOfKey;
            WeakReference<KeyEvent> weakReference = this.f1076d;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f1076d = new WeakReference<>(keyEvent);
            WeakReference<View> weakReferenceValueAt = null;
            SparseArray<WeakReference<View>> sparseArrayD = d();
            if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReferenceValueAt = sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReferenceValueAt == null) {
                weakReferenceValueAt = sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReferenceValueAt == null) {
                return false;
            }
            View view = weakReferenceValueAt.get();
            if (view != null && u.N(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    public static int A(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f1059c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f1058b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1059c = true;
        }
        Field field = f1058b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    private static void A0(View view) {
        if (w(view) == 0) {
            t0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (w((View) parent) == 4) {
                t0(view, 2);
                return;
            }
        }
    }

    static androidx.core.view.a B(View view) {
        androidx.core.view.a aVarJ = j(view);
        if (aVarJ == null) {
            aVarJ = new androidx.core.view.a();
        }
        i0(view, aVarJ);
        return aVarJ;
    }

    private static g<CharSequence> B0() {
        return new d(c.i.c.N, CharSequence.class, 64, 30);
    }

    public static int C(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void C0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof androidx.core.view.j) {
            ((androidx.core.view.j) view).stopNestedScroll();
        }
    }

    public static int D(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    private static void D0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static c0 E(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return i.a(view);
        }
        if (i2 >= 21) {
            return h.c(view);
        }
        return null;
    }

    public static final CharSequence F(View view) {
        return B0().f(view);
    }

    public static String G(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f1062f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int H(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float I(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean J(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean K(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean L(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean M(View view) {
        Boolean boolF = a().f(view);
        if (boolF == null) {
            return false;
        }
        return boolF.booleanValue();
    }

    public static boolean N(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean O(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean P(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof androidx.core.view.j) {
            return ((androidx.core.view.j) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean Q(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static boolean R(View view) {
        Boolean boolF = h0().f(view);
        if (boolF == null) {
            return false;
        }
        return boolF.booleanValue();
    }

    static void S(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = n(view) != null && view.getVisibility() == 0;
            if (m(view) != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : RecyclerView.l.FLAG_MOVED);
                accessibilityEventObtain.setContentChangeTypes(i2);
                if (z) {
                    accessibilityEventObtain.getText().add(n(view));
                    A0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i2);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(n(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static void T(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        if (i3 < 21) {
            d(view, i2);
            return;
        }
        Rect rectU = u();
        boolean z = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectU.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectU.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        d(view, i2);
        if (z && rectU.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectU);
        }
    }

    public static void U(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        if (i3 < 21) {
            e(view, i2);
            return;
        }
        Rect rectU = u();
        boolean z = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectU.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectU.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        e(view, i2);
        if (z && rectU.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectU);
        }
    }

    public static c0 V(View view, c0 c0Var) {
        WindowInsets windowInsetsT;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsT = c0Var.t()) != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsT);
            if (!windowInsetsOnApplyWindowInsets.equals(windowInsetsT)) {
                return c0.v(windowInsetsOnApplyWindowInsets, view);
            }
        }
        return c0Var;
    }

    public static void W(View view, androidx.core.view.d0.c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.x0());
    }

    private static g<CharSequence> X() {
        return new c(c.i.c.K, CharSequence.class, 8, 28);
    }

    public static boolean Y(View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    public static void Z(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    private static g<Boolean> a() {
        return new e(c.i.c.J, Boolean.class, 28);
    }

    public static void a0(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    private static void b(View view, androidx.core.view.d0.c.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            B(view);
            d0(aVar.b(), view);
            o(view).add(aVar);
            S(view, 0);
        }
    }

    public static void b0(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static y c(View view) {
        if (f1063g == null) {
            f1063g = new WeakHashMap<>();
        }
        y yVar = f1063g.get(view);
        if (yVar != null) {
            return yVar;
        }
        y yVar2 = new y(view);
        f1063g.put(view, yVar2);
        return yVar2;
    }

    public static void c0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            d0(i2, view);
            S(view, 0);
        }
    }

    private static void d(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            D0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                D0((View) parent);
            }
        }
    }

    private static void d0(int i2, View view) {
        List<androidx.core.view.d0.c.a> listO = o(view);
        for (int i3 = 0; i3 < listO.size(); i3++) {
            if (listO.get(i3).b() == i2) {
                listO.remove(i3);
                return;
            }
        }
    }

    private static void e(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            D0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                D0((View) parent);
            }
        }
    }

    public static void e0(View view, androidx.core.view.d0.c.a aVar, CharSequence charSequence, androidx.core.view.d0.f fVar) {
        if (fVar == null && charSequence == null) {
            c0(view, aVar.b());
        } else {
            b(view, aVar.a(charSequence, fVar));
        }
    }

    public static c0 f(View view, c0 c0Var, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? h.b(view, c0Var, rect) : c0Var;
    }

    public static void f0(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            view.requestApplyInsets();
        } else if (i2 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static c0 g(View view, c0 c0Var) {
        WindowInsets windowInsetsT;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsT = c0Var.t()) != null) {
            WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsetsT);
            if (!windowInsetsDispatchApplyWindowInsets.equals(windowInsetsT)) {
                return c0.v(windowInsetsDispatchApplyWindowInsets, view);
            }
        }
        return c0Var;
    }

    public static void g0(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            j.a(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(view).b(view, keyEvent);
    }

    private static g<Boolean> h0() {
        return new b(c.i.c.M, Boolean.class, 28);
    }

    static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(view).f(keyEvent);
    }

    public static void i0(View view, androidx.core.view.a aVar) {
        if (aVar == null && (k(view) instanceof androidx.core.view.a.C0023a)) {
            aVar = new androidx.core.view.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    public static androidx.core.view.a j(View view) {
        View.AccessibilityDelegate accessibilityDelegateK = k(view);
        if (accessibilityDelegateK == null) {
            return null;
        }
        return accessibilityDelegateK instanceof androidx.core.view.a.C0023a ? ((androidx.core.view.a.C0023a) accessibilityDelegateK).a : new androidx.core.view.a(accessibilityDelegateK);
    }

    public static void j0(View view, boolean z) {
        a().g(view, Boolean.valueOf(z));
    }

    private static View.AccessibilityDelegate k(View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : l(view);
    }

    public static void k0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    private static View.AccessibilityDelegate l(View view) {
        if (f1065i) {
            return null;
        }
        if (f1064h == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f1064h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1065i = true;
                return null;
            }
        }
        try {
            Object obj = f1064h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f1065i = true;
            return null;
        }
    }

    @Deprecated
    public static void l0(View view, float f2) {
        view.setAlpha(f2);
    }

    public static int m(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void m0(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static CharSequence n(View view) {
        return X().f(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void n0(View view, ColorStateList colorStateList) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            if (view instanceof t) {
                ((t) view).setSupportBackgroundTintList(colorStateList);
                return;
            }
            return;
        }
        view.setBackgroundTintList(colorStateList);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    private static List<androidx.core.view.d0.c.a> o(View view) {
        int i2 = c.i.c.H;
        ArrayList arrayList = (ArrayList) view.getTag(i2);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i2, arrayList2);
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void o0(View view, PorterDuff.Mode mode) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            if (view instanceof t) {
                ((t) view).setSupportBackgroundTintMode(mode);
                return;
            }
            return;
        }
        view.setBackgroundTintMode(mode);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList p(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof t) {
            return ((t) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void p0(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode q(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof t) {
            return ((t) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void q0(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static Rect r(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    @Deprecated
    public static void r0(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static Display s(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (N(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static void s0(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static float t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void t0(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (i3 >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    private static Rect u() {
        if (f1066j == null) {
            f1066j = new ThreadLocal<>();
        }
        Rect rect = f1066j.get();
        if (rect == null) {
            rect = new Rect();
            f1066j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void u0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static boolean v(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static void v0(View view, p pVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.d(view, pVar);
        }
    }

    public static int w(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void w0(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    @SuppressLint({"InlinedApi"})
    public static int x(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void x0(View view, s sVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (sVar != null ? sVar.a() : null));
        }
    }

    public static int y(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static void y0(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static int z(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f1061e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f1060d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1061e = true;
        }
        Field field = f1060d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void z0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f1062f == null) {
            f1062f = new WeakHashMap<>();
        }
        f1062f.put(view, str);
    }
}
