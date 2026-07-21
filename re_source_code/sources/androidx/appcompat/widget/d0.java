package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ListPopupWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class d0 implements androidx.appcompat.view.menu.p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Method f502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Method f503h;
    private View A;
    private Drawable B;
    private AdapterView.OnItemClickListener C;
    private AdapterView.OnItemSelectedListener D;
    final g E;
    private final f F;
    private final e G;
    private final c H;
    private Runnable I;
    final Handler J;
    private final Rect K;
    private Rect L;
    private boolean M;
    PopupWindow N;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ListAdapter f505j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    z f506k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    int w;
    private View x;
    private int y;
    private DataSetObserver z;

    /* JADX INFO: compiled from: ListPopupWindow.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewS = d0.this.s();
            if (viewS == null || viewS.getWindowToken() == null) {
                return;
            }
            d0.this.show();
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            z zVar;
            if (i2 == -1 || (zVar = d0.this.f506k) == null) {
                return;
            }
            zVar.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    private class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.q();
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    private class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (d0.this.a()) {
                d0.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            d0.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    private class e implements AbsListView.OnScrollListener {
        e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 != 1 || d0.this.z() || d0.this.N.getContentView() == null) {
                return;
            }
            d0 d0Var = d0.this;
            d0Var.J.removeCallbacks(d0Var.E);
            d0.this.E.run();
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    private class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = d0.this.N) != null && popupWindow.isShowing() && x >= 0 && x < d0.this.N.getWidth() && y >= 0 && y < d0.this.N.getHeight()) {
                d0 d0Var = d0.this;
                d0Var.J.postDelayed(d0Var.E, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            d0 d0Var2 = d0.this;
            d0Var2.J.removeCallbacks(d0Var2.E);
            return false;
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    private class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z zVar = d0.this.f506k;
            if (zVar == null || !androidx.core.view.u.N(zVar) || d0.this.f506k.getCount() <= d0.this.f506k.getChildCount()) {
                return;
            }
            int childCount = d0.this.f506k.getChildCount();
            d0 d0Var = d0.this;
            if (childCount <= d0Var.w) {
                d0Var.N.setInputMethodMode(2);
                d0.this.show();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f501f = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f503h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f502g = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public d0(Context context) {
        this(context, null, c.a.a.E);
    }

    private void B() {
        View view = this.x;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.x);
            }
        }
    }

    private void M(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.N.setIsClippedToScreen(z);
            return;
        }
        Method method = f501f;
        if (method != null) {
            try {
                method.invoke(this.N, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int p() {
        int measuredHeight;
        int i2;
        int iMakeMeasureSpec;
        View view;
        int i3;
        if (this.f506k == null) {
            Context context = this.f504i;
            this.I = new a();
            z zVarR = r(context, !this.M);
            this.f506k = zVarR;
            Drawable drawable = this.B;
            if (drawable != null) {
                zVarR.setSelector(drawable);
            }
            this.f506k.setAdapter(this.f505j);
            this.f506k.setOnItemClickListener(this.C);
            this.f506k.setFocusable(true);
            this.f506k.setFocusableInTouchMode(true);
            this.f506k.setOnItemSelectedListener(new b());
            this.f506k.setOnScrollListener(this.G);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.D;
            if (onItemSelectedListener != null) {
                this.f506k.setOnItemSelectedListener(onItemSelectedListener);
            }
            z zVar = this.f506k;
            View view2 = this.x;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.y;
                if (i4 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(zVar, layoutParams);
                } else if (i4 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.y);
                } else {
                    linearLayout.addView(zVar, layoutParams);
                    linearLayout.addView(view2);
                }
                int i5 = this.m;
                if (i5 >= 0) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = zVar;
            }
            this.N.setContentView(view);
        } else {
            View view3 = this.x;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.N.getBackground();
        if (background != null) {
            background.getPadding(this.K);
            Rect rect = this.K;
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.q) {
                this.o = -i6;
            }
        } else {
            this.K.setEmpty();
            i2 = 0;
        }
        int iT = t(s(), this.o, this.N.getInputMethodMode() == 2);
        if (this.u || this.l == -1) {
            return iT + i2;
        }
        int i7 = this.m;
        if (i7 == -2) {
            int i8 = this.f504i.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.K;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i7 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        } else {
            int i9 = this.f504i.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.K;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.f506k.d(iMakeMeasureSpec, 0, -1, iT - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i2 + this.f506k.getPaddingTop() + this.f506k.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    private int t(View view, int i2, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.N.getMaxAvailableHeight(view, i2, z);
        }
        Method method = f502g;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.N, view, Integer.valueOf(i2), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.N.getMaxAvailableHeight(view, i2);
    }

    public boolean A() {
        return this.M;
    }

    public void C(View view) {
        this.A = view;
    }

    public void D(int i2) {
        this.N.setAnimationStyle(i2);
    }

    public void E(int i2) {
        Drawable background = this.N.getBackground();
        if (background == null) {
            P(i2);
            return;
        }
        background.getPadding(this.K);
        Rect rect = this.K;
        this.m = rect.left + rect.right + i2;
    }

    public void F(int i2) {
        this.t = i2;
    }

    public void G(Rect rect) {
        this.L = rect != null ? new Rect(rect) : null;
    }

    public void H(int i2) {
        this.N.setInputMethodMode(i2);
    }

    public void I(boolean z) {
        this.M = z;
        this.N.setFocusable(z);
    }

    public void J(PopupWindow.OnDismissListener onDismissListener) {
        this.N.setOnDismissListener(onDismissListener);
    }

    public void K(AdapterView.OnItemClickListener onItemClickListener) {
        this.C = onItemClickListener;
    }

    public void L(boolean z) {
        this.s = true;
        this.r = z;
    }

    public void N(int i2) {
        this.y = i2;
    }

    public void O(int i2) {
        z zVar = this.f506k;
        if (!a() || zVar == null) {
            return;
        }
        zVar.setListSelectionHidden(false);
        zVar.setSelection(i2);
        if (zVar.getChoiceMode() != 0) {
            zVar.setItemChecked(i2, true);
        }
    }

    public void P(int i2) {
        this.m = i2;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a() {
        return this.N.isShowing();
    }

    public void b(Drawable drawable) {
        this.N.setBackgroundDrawable(drawable);
    }

    public int c() {
        return this.n;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        this.N.dismiss();
        B();
        this.N.setContentView(null);
        this.f506k = null;
        this.J.removeCallbacks(this.E);
    }

    public void e(int i2) {
        this.n = i2;
    }

    public Drawable h() {
        return this.N.getBackground();
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView j() {
        return this.f506k;
    }

    public void k(int i2) {
        this.o = i2;
        this.q = true;
    }

    public int n() {
        if (this.q) {
            return this.o;
        }
        return 0;
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.z;
        if (dataSetObserver == null) {
            this.z = new d();
        } else {
            ListAdapter listAdapter2 = this.f505j;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f505j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.z);
        }
        z zVar = this.f506k;
        if (zVar != null) {
            zVar.setAdapter(this.f505j);
        }
    }

    public void q() {
        z zVar = this.f506k;
        if (zVar != null) {
            zVar.setListSelectionHidden(true);
            zVar.requestLayout();
        }
    }

    z r(Context context, boolean z) {
        return new z(context, z);
    }

    public View s() {
        return this.A;
    }

    @Override // androidx.appcompat.view.menu.p
    public void show() {
        int iP = p();
        boolean z = z();
        androidx.core.widget.j.b(this.N, this.p);
        if (this.N.isShowing()) {
            if (androidx.core.view.u.N(s())) {
                int width = this.m;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = s().getWidth();
                }
                int i2 = this.l;
                if (i2 == -1) {
                    if (!z) {
                        iP = -1;
                    }
                    if (z) {
                        this.N.setWidth(this.m == -1 ? -1 : 0);
                        this.N.setHeight(0);
                    } else {
                        this.N.setWidth(this.m == -1 ? -1 : 0);
                        this.N.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    iP = i2;
                }
                this.N.setOutsideTouchable((this.v || this.u) ? false : true);
                this.N.update(s(), this.n, this.o, width < 0 ? -1 : width, iP < 0 ? -1 : iP);
                return;
            }
            return;
        }
        int width2 = this.m;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = s().getWidth();
        }
        int i3 = this.l;
        if (i3 == -1) {
            iP = -1;
        } else if (i3 != -2) {
            iP = i3;
        }
        this.N.setWidth(width2);
        this.N.setHeight(iP);
        M(true);
        this.N.setOutsideTouchable((this.v || this.u) ? false : true);
        this.N.setTouchInterceptor(this.F);
        if (this.s) {
            androidx.core.widget.j.a(this.N, this.r);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f503h;
            if (method != null) {
                try {
                    method.invoke(this.N, this.L);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.N.setEpicenterBounds(this.L);
        }
        androidx.core.widget.j.c(this.N, s(), this.n, this.o, this.t);
        this.f506k.setSelection(-1);
        if (!this.M || this.f506k.isInTouchMode()) {
            q();
        }
        if (this.M) {
            return;
        }
        this.J.post(this.H);
    }

    public Object u() {
        if (a()) {
            return this.f506k.getSelectedItem();
        }
        return null;
    }

    public long v() {
        if (a()) {
            return this.f506k.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int w() {
        if (a()) {
            return this.f506k.getSelectedItemPosition();
        }
        return -1;
    }

    public View x() {
        if (a()) {
            return this.f506k.getSelectedView();
        }
        return null;
    }

    public int y() {
        return this.m;
    }

    public boolean z() {
        return this.N.getInputMethodMode() == 2;
    }

    public d0(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public d0(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.l = -2;
        this.m = -2;
        this.p = 1002;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.w = Integer.MAX_VALUE;
        this.y = 0;
        this.E = new g();
        this.F = new f();
        this.G = new e();
        this.H = new c();
        this.K = new Rect();
        this.f504i = context;
        this.J = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.o1, i2, i3);
        this.n = typedArrayObtainStyledAttributes.getDimensionPixelOffset(c.a.j.p1, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(c.a.j.q1, 0);
        this.o = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.q = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        n nVar = new n(context, attributeSet, i2, i3);
        this.N = nVar;
        nVar.setInputMethodMode(1);
    }
}
