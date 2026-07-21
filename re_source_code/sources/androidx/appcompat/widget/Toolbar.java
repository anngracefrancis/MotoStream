package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private int A;
    private int B;
    private CharSequence C;
    private CharSequence D;
    private ColorStateList E;
    private ColorStateList F;
    private boolean G;
    private boolean H;
    private final ArrayList<View> I;
    private final ArrayList<View> J;
    private final int[] K;
    f L;
    private final ActionMenuView.e M;
    private r0 N;
    private ActionMenuPresenter O;
    private d P;
    private androidx.appcompat.view.menu.m.a Q;
    private androidx.appcompat.view.menu.g.a R;
    private boolean S;
    private final Runnable T;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ActionMenuView f451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImageButton f454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f455j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f456k;
    private CharSequence l;
    ImageButton m;
    View n;
    private Context o;
    private int p;
    private int q;
    private int r;
    int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private i0 y;
    private int z;

    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            f fVar = Toolbar.this.L;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.O();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    private class d implements androidx.appcompat.view.menu.m {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        androidx.appcompat.view.menu.g f461f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        androidx.appcompat.view.menu.i f462g;

        d() {
        }

        @Override // androidx.appcompat.view.menu.m
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m
        public void c(boolean z) {
            if (this.f462g != null) {
                androidx.appcompat.view.menu.g gVar = this.f461f;
                boolean z2 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.f461f.getItem(i2) == this.f462g) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    return;
                }
                e(this.f461f, this.f462g);
            }
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean d() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean e(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            KeyEvent.Callback callback = Toolbar.this.n;
            if (callback instanceof c.a.o.c) {
                ((c.a.o.c) callback).f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.n);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.m);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.n = null;
            toolbar3.a();
            this.f462g = null;
            Toolbar.this.requestLayout();
            iVar.r(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean f(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.m.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.m);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.m);
            }
            Toolbar.this.n = iVar.getActionView();
            this.f462g = iVar;
            ViewParent parent2 = Toolbar.this.n.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.n);
                }
                e eVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                eVarGenerateDefaultLayoutParams.a = 8388611 | (toolbar4.s & 112);
                eVarGenerateDefaultLayoutParams.f464b = 2;
                toolbar4.n.setLayoutParams(eVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.n);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            iVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.n;
            if (callback instanceof c.a.o.c) {
                ((c.a.o.c) callback).c();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.m
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.m
        public void h(Context context, androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.i iVar;
            androidx.appcompat.view.menu.g gVar2 = this.f461f;
            if (gVar2 != null && (iVar = this.f462g) != null) {
                gVar2.f(iVar);
            }
            this.f461f = gVar;
        }

        @Override // androidx.appcompat.view.menu.m
        public void i(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean k(androidx.appcompat.view.menu.r rVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public Parcelable l() {
            return null;
        }
    }

    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.O);
    }

    private int B(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int iMax = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int iQ = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    private int C(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int iMax = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int iQ = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    private int D(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + iMax + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void E(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void F() {
        removeCallbacks(this.T);
        post(this.T);
    }

    private boolean M() {
        if (!this.S) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (N(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean N(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i2) {
        boolean z = androidx.core.view.u.y(this) == 1;
        int childCount = getChildCount();
        int iB = androidx.core.view.d.b(i2, androidx.core.view.u.y(this));
        list.clear();
        if (!z) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f464b == 0 && N(childAt) && p(eVar.a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f464b == 0 && N(childAt2) && p(eVar2.a) == iB) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z) {
        e eVarGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            eVarGenerateLayoutParams = generateDefaultLayoutParams();
        } else {
            eVarGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        }
        eVarGenerateLayoutParams.f464b = 1;
        if (!z || this.n == null) {
            addView(view, eVarGenerateLayoutParams);
        } else {
            view.setLayoutParams(eVarGenerateLayoutParams);
            this.J.add(view);
        }
    }

    private MenuInflater getMenuInflater() {
        return new c.a.o.g(getContext());
    }

    private void h() {
        if (this.y == null) {
            this.y = new i0();
        }
    }

    private void i() {
        if (this.f455j == null) {
            this.f455j = new AppCompatImageView(getContext());
        }
    }

    private void j() {
        k();
        if (this.f451f.N() == null) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) this.f451f.getMenu();
            if (this.P == null) {
                this.P = new d();
            }
            this.f451f.setExpandedActionViewsExclusive(true);
            gVar.c(this.P, this.o);
        }
    }

    private void k() {
        if (this.f451f == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f451f = actionMenuView;
            actionMenuView.setPopupTheme(this.p);
            this.f451f.setOnMenuItemClickListener(this.M);
            this.f451f.O(this.Q, this.R);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.a = 8388613 | (this.s & 112);
            this.f451f.setLayoutParams(eVarGenerateDefaultLayoutParams);
            c(this.f451f, false);
        }
    }

    private void l() {
        if (this.f454i == null) {
            this.f454i = new k(getContext(), null, c.a.a.N);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.a = 8388611 | (this.s & 112);
            this.f454i.setLayoutParams(eVarGenerateDefaultLayoutParams);
        }
    }

    private int p(int i2) {
        int iY = androidx.core.view.u.y(this);
        int iB = androidx.core.view.d.b(i2, iY) & 7;
        if (iB == 1 || iB == 3 || iB == 5) {
            return iB;
        }
        return iY == 1 ? 5 : 3;
    }

    private int q(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int iR = r(eVar.a);
        if (iR == 48) {
            return getPaddingTop() - i3;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (iMax < i4) {
            iMax = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i6 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i5 < i6) {
                iMax = Math.max(0, iMax - (i6 - i5));
            }
        }
        return paddingTop + iMax;
    }

    private int r(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.B & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.view.g.b(marginLayoutParams) + androidx.core.view.g.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = 0;
        int measuredWidth = 0;
        while (i4 < size) {
            View view = list.get(i4);
            e eVar = (e) view.getLayoutParams();
            int i5 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i2;
            int i6 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i3;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, i6);
            int iMax3 = Math.max(0, -i5);
            int iMax4 = Math.max(0, -i6);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i4++;
            i3 = iMax4;
            i2 = iMax3;
        }
        return measuredWidth;
    }

    private boolean y(View view) {
        return view.getParent() == this || this.J.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f451f;
        return actionMenuView != null && actionMenuView.J();
    }

    void G() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).f464b != 2 && childAt != this.f451f) {
                removeViewAt(childCount);
                this.J.add(childAt);
            }
        }
    }

    public void H(int i2, int i3) {
        h();
        this.y.g(i2, i3);
    }

    public void I(androidx.appcompat.view.menu.g gVar, ActionMenuPresenter actionMenuPresenter) {
        if (gVar == null && this.f451f == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.g gVarN = this.f451f.N();
        if (gVarN == gVar) {
            return;
        }
        if (gVarN != null) {
            gVarN.Q(this.O);
            gVarN.Q(this.P);
        }
        if (this.P == null) {
            this.P = new d();
        }
        actionMenuPresenter.I(true);
        if (gVar != null) {
            gVar.c(actionMenuPresenter, this.o);
            gVar.c(this.P, this.o);
        } else {
            actionMenuPresenter.h(this.o, null);
            this.P.h(this.o, null);
            actionMenuPresenter.c(true);
            this.P.c(true);
        }
        this.f451f.setPopupTheme(this.p);
        this.f451f.setPresenter(actionMenuPresenter);
        this.O = actionMenuPresenter;
    }

    public void J(androidx.appcompat.view.menu.m.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.Q = aVar;
        this.R = aVar2;
        ActionMenuView actionMenuView = this.f451f;
        if (actionMenuView != null) {
            actionMenuView.O(aVar, aVar2);
        }
    }

    public void K(Context context, int i2) {
        this.r = i2;
        TextView textView = this.f453h;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void L(Context context, int i2) {
        this.q = i2;
        TextView textView = this.f452g;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public boolean O() {
        ActionMenuView actionMenuView = this.f451f;
        return actionMenuView != null && actionMenuView.P();
    }

    void a() {
        for (int size = this.J.size() - 1; size >= 0; size--) {
            addView(this.J.get(size));
        }
        this.J.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f451f) != null && actionMenuView.K();
    }

    public void e() {
        d dVar = this.P;
        androidx.appcompat.view.menu.i iVar = dVar == null ? null : dVar.f462g;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f451f;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    void g() {
        if (this.m == null) {
            k kVar = new k(getContext(), null, c.a.a.N);
            this.m = kVar;
            kVar.setImageDrawable(this.f456k);
            this.m.setContentDescription(this.l);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.a = 8388611 | (this.s & 112);
            eVarGenerateDefaultLayoutParams.f464b = 2;
            this.m.setLayoutParams(eVarGenerateDefaultLayoutParams);
            this.m.setOnClickListener(new c());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.m;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.m;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        i0 i0Var = this.y;
        if (i0Var != null) {
            return i0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.A;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        i0 i0Var = this.y;
        if (i0Var != null) {
            return i0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        i0 i0Var = this.y;
        if (i0Var != null) {
            return i0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        i0 i0Var = this.y;
        if (i0Var != null) {
            return i0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.z;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.g gVarN;
        ActionMenuView actionMenuView = this.f451f;
        return actionMenuView != null && (gVarN = actionMenuView.N()) != null && gVarN.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.A, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return androidx.core.view.u.y(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return androidx.core.view.u.y(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.z, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f455j;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f455j;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f451f.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f454i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f454i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.O;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f451f.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.o;
    }

    public int getPopupTheme() {
        return this.p;
    }

    public CharSequence getSubtitle() {
        return this.D;
    }

    final TextView getSubtitleTextView() {
        return this.f453h;
    }

    public CharSequence getTitle() {
        return this.C;
    }

    public int getTitleMarginBottom() {
        return this.x;
    }

    public int getTitleMarginEnd() {
        return this.v;
    }

    public int getTitleMarginStart() {
        return this.u;
    }

    public int getTitleMarginTop() {
        return this.w;
    }

    final TextView getTitleTextView() {
        return this.f452g;
    }

    public x getWrapper() {
        if (this.N == null) {
            this.N = new r0(this, true);
        }
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof androidx.appcompat.app.a.C0009a) {
            return new e((androidx.appcompat.app.a.C0009a) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.T);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.H = false;
        }
        if (!this.H) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.H = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.H = false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0289  */
    /* JADX WARN: Code duplicated, block: B:102:0x028c  */
    /* JADX WARN: Code duplicated, block: B:105:0x029f A[LOOP:0: B:104:0x029d->B:105:0x029f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x02c1 A[LOOP:1: B:107:0x02bf->B:108:0x02c1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:112:0x02eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:114:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:117:0x02fa A[LOOP:2: B:116:0x02f8->B:117:0x02fa, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x005f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0061  */
    /* JADX WARN: Code duplicated, block: B:21:0x0068  */
    /* JADX WARN: Code duplicated, block: B:24:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0078  */
    /* JADX WARN: Code duplicated, block: B:26:0x007f  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ca A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:40:0x0100  */
    /* JADX WARN: Code duplicated, block: B:42:0x0105  */
    /* JADX WARN: Code duplicated, block: B:43:0x011d  */
    /* JADX WARN: Code duplicated, block: B:49:0x012b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x012d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0130  */
    /* JADX WARN: Code duplicated, block: B:53:0x0134  */
    /* JADX WARN: Code duplicated, block: B:54:0x0137  */
    /* JADX WARN: Code duplicated, block: B:57:0x0147  */
    /* JADX WARN: Code duplicated, block: B:59:0x014f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x0168  */
    /* JADX WARN: Code duplicated, block: B:68:0x016c  */
    /* JADX WARN: Code duplicated, block: B:70:0x017e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0181  */
    /* JADX WARN: Code duplicated, block: B:73:0x018c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0198  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:80:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:87:0x021b  */
    /* JADX WARN: Code duplicated, block: B:89:0x021e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0227 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0229  */
    /* JADX WARN: Code duplicated, block: B:93:0x022d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0241  */
    /* JADX WARN: Code duplicated, block: B:97:0x0264  */
    /* JADX WARN: Code duplicated, block: B:99:0x0267  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int iB;
        int iC;
        int iMax;
        int iMin;
        boolean zN;
        boolean zN2;
        int measuredHeight;
        TextView textView;
        TextView textView2;
        e eVar;
        e eVar2;
        boolean z2;
        int i6;
        int i7;
        int paddingTop;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int iMax2;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int size;
        int i20;
        int i21;
        int size2;
        int i22;
        int i23;
        int i24;
        int size3;
        boolean z3 = androidx.core.view.u.y(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i25 = width - paddingRight;
        int[] iArr = this.K;
        iArr[1] = 0;
        iArr[0] = 0;
        int iZ = androidx.core.view.u.z(this);
        int iMin2 = iZ >= 0 ? Math.min(iZ, i5 - i3) : 0;
        if (N(this.f454i)) {
            if (z3) {
                iC = C(this.f454i, i25, iArr, iMin2);
                iB = paddingLeft;
            } else {
                iB = B(this.f454i, paddingLeft, iArr, iMin2);
            }
            if (N(this.m)) {
                if (z3) {
                    iC = C(this.m, iC, iArr, iMin2);
                } else {
                    iB = B(this.m, iB, iArr, iMin2);
                }
            }
            if (N(this.f451f)) {
                if (z3) {
                    iB = B(this.f451f, iB, iArr, iMin2);
                } else {
                    iC = C(this.f451f, iC, iArr, iMin2);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - iB);
            iArr[1] = Math.max(0, currentContentInsetRight - (i25 - iC));
            iMax = Math.max(iB, currentContentInsetLeft);
            iMin = Math.min(iC, i25 - currentContentInsetRight);
            if (N(this.n)) {
                if (z3) {
                    iMin = C(this.n, iMin, iArr, iMin2);
                } else {
                    iMax = B(this.n, iMax, iArr, iMin2);
                }
            }
            if (N(this.f455j)) {
                if (z3) {
                    iMin = C(this.f455j, iMin, iArr, iMin2);
                } else {
                    iMax = B(this.f455j, iMax, iArr, iMin2);
                }
            }
            zN = N(this.f452g);
            zN2 = N(this.f453h);
            if (zN) {
                e eVar3 = (e) this.f452g.getLayoutParams();
                measuredHeight = ((ViewGroup.MarginLayoutParams) eVar3).topMargin + this.f452g.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin + 0;
            } else {
                measuredHeight = 0;
            }
            if (zN2) {
                e eVar4 = (e) this.f453h.getLayoutParams();
                measuredHeight += ((ViewGroup.MarginLayoutParams) eVar4).topMargin + this.f453h.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar4).bottomMargin;
            }
            if (!zN || zN2) {
                if (zN) {
                    textView = this.f452g;
                } else {
                    textView = this.f453h;
                }
                if (zN2) {
                    textView2 = this.f453h;
                } else {
                    textView2 = this.f452g;
                }
                eVar = (e) textView.getLayoutParams();
                eVar2 = (e) textView2.getLayoutParams();
                z2 = (!zN && this.f452g.getMeasuredWidth() > 0) || (zN2 && this.f453h.getMeasuredWidth() > 0);
                i6 = this.B & 112;
                i7 = paddingLeft;
                if (i6 == 48) {
                    paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + this.w;
                } else if (i6 != 80) {
                    iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    i15 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                    i16 = this.w;
                    if (iMax2 < i15 + i16) {
                        iMax2 = i15 + i16;
                    } else {
                        i17 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                        i18 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                        i19 = this.x;
                        if (i17 < i18 + i19) {
                            iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) eVar2).bottomMargin + i19) - i17));
                        }
                    }
                    paddingTop = paddingTop2 + iMax2;
                } else {
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin) - this.x) - measuredHeight;
                }
                if (z3) {
                    if (z2) {
                        i12 = this.u;
                    } else {
                        i12 = 0;
                    }
                    int i26 = i12 - iArr[1];
                    iMin -= Math.max(0, i26);
                    iArr[1] = Math.max(0, -i26);
                    if (zN) {
                        e eVar5 = (e) this.f452g.getLayoutParams();
                        int measuredWidth = iMin - this.f452g.getMeasuredWidth();
                        int measuredHeight2 = this.f452g.getMeasuredHeight() + paddingTop;
                        this.f452g.layout(measuredWidth, paddingTop, iMin, measuredHeight2);
                        i13 = measuredWidth - this.v;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) eVar5).bottomMargin;
                    } else {
                        i13 = iMin;
                    }
                    if (zN2) {
                        int i27 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f453h.getLayoutParams())).topMargin;
                        this.f453h.layout(iMin - this.f453h.getMeasuredWidth(), i27, iMin, this.f453h.getMeasuredHeight() + i27);
                        i14 = iMin - this.v;
                    } else {
                        i14 = iMin;
                    }
                    if (z2) {
                        iMin = Math.min(i13, i14);
                    }
                    iMax = iMax;
                } else {
                    if (z2) {
                        i9 = this.u;
                        i8 = 0;
                    } else {
                        i8 = 0;
                        i9 = 0;
                    }
                    int i28 = i9 - iArr[i8];
                    iMax += Math.max(i8, i28);
                    iArr[i8] = Math.max(i8, -i28);
                    if (zN) {
                        e eVar6 = (e) this.f452g.getLayoutParams();
                        int measuredWidth2 = this.f452g.getMeasuredWidth() + iMax;
                        int measuredHeight3 = this.f452g.getMeasuredHeight() + paddingTop;
                        this.f452g.layout(iMax, paddingTop, measuredWidth2, measuredHeight3);
                        i10 = measuredWidth2 + this.v;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) eVar6).bottomMargin;
                    } else {
                        i10 = iMax;
                    }
                    if (zN2) {
                        int i29 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f453h.getLayoutParams())).topMargin;
                        int measuredWidth3 = this.f453h.getMeasuredWidth() + iMax;
                        this.f453h.layout(iMax, i29, measuredWidth3, this.f453h.getMeasuredHeight() + i29);
                        i11 = measuredWidth3 + this.v;
                    } else {
                        i11 = iMax;
                    }
                    if (z2) {
                        iMax = Math.max(i10, i11);
                    }
                }
                b(this.I, 3);
                size = this.I.size();
                for (i20 = 0; i20 < size; i20++) {
                    iMax = B(this.I.get(i20), iMax, iArr, iMin2);
                }
                i21 = iMin2;
                b(this.I, 5);
                size2 = this.I.size();
                for (i22 = 0; i22 < size2; i22++) {
                    iMin = C(this.I.get(i22), iMin, iArr, i21);
                }
                b(this.I, 1);
                int iU = u(this.I, iArr);
                i23 = (i7 + (((width - i7) - paddingRight) / 2)) - (iU / 2);
                i24 = iU + i23;
                if (i23 >= iMax) {
                    if (i24 > iMin) {
                        iMax = i23 - (i24 - iMin);
                    } else {
                        iMax = i23;
                    }
                }
                size3 = this.I.size();
                while (i8 < size3) {
                    iMax = B(this.I.get(i8), iMax, iArr, i21);
                    i8++;
                }
                this.I.clear();
            }
            i7 = paddingLeft;
            iMin2 = iMin2;
            i8 = 0;
            b(this.I, 3);
            size = this.I.size();
            while (i20 < size) {
                iMax = B(this.I.get(i20), iMax, iArr, iMin2);
            }
            i21 = iMin2;
            b(this.I, 5);
            size2 = this.I.size();
            while (i22 < size2) {
                iMin = C(this.I.get(i22), iMin, iArr, i21);
            }
            b(this.I, 1);
            int iU2 = u(this.I, iArr);
            i23 = (i7 + (((width - i7) - paddingRight) / 2)) - (iU2 / 2);
            i24 = iU2 + i23;
            if (i23 >= iMax) {
                if (i24 > iMin) {
                    iMax = i23 - (i24 - iMin);
                } else {
                    iMax = i23;
                }
            }
            size3 = this.I.size();
            while (i8 < size3) {
                iMax = B(this.I.get(i8), iMax, iArr, i21);
                i8++;
            }
            this.I.clear();
        }
        iB = paddingLeft;
        iC = i25;
        if (N(this.m)) {
            if (z3) {
                iC = C(this.m, iC, iArr, iMin2);
            } else {
                iB = B(this.m, iB, iArr, iMin2);
            }
        }
        if (N(this.f451f)) {
            if (z3) {
                iB = B(this.f451f, iB, iArr, iMin2);
            } else {
                iC = C(this.f451f, iC, iArr, iMin2);
            }
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iB);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i25 - iC));
        iMax = Math.max(iB, currentContentInsetLeft2);
        iMin = Math.min(iC, i25 - currentContentInsetRight2);
        if (N(this.n)) {
            if (z3) {
                iMin = C(this.n, iMin, iArr, iMin2);
            } else {
                iMax = B(this.n, iMax, iArr, iMin2);
            }
        }
        if (N(this.f455j)) {
            if (z3) {
                iMin = C(this.f455j, iMin, iArr, iMin2);
            } else {
                iMax = B(this.f455j, iMax, iArr, iMin2);
            }
        }
        zN = N(this.f452g);
        zN2 = N(this.f453h);
        if (zN) {
            e eVar7 = (e) this.f452g.getLayoutParams();
            measuredHeight = ((ViewGroup.MarginLayoutParams) eVar7).topMargin + this.f452g.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar7).bottomMargin + 0;
        } else {
            measuredHeight = 0;
        }
        if (zN2) {
            e eVar8 = (e) this.f453h.getLayoutParams();
            measuredHeight += ((ViewGroup.MarginLayoutParams) eVar8).topMargin + this.f453h.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar8).bottomMargin;
        }
        if (zN) {
            if (zN) {
                textView = this.f452g;
            } else {
                textView = this.f453h;
            }
            if (zN2) {
                textView2 = this.f453h;
            } else {
                textView2 = this.f452g;
            }
            eVar = (e) textView.getLayoutParams();
            eVar2 = (e) textView2.getLayoutParams();
            if (zN) {
            }
            i6 = this.B & 112;
            i7 = paddingLeft;
            if (i6 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + this.w;
            } else if (i6 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i15 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                i16 = this.w;
                if (iMax2 < i15 + i16) {
                    iMax2 = i15 + i16;
                } else {
                    i17 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    i18 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                    i19 = this.x;
                    if (i17 < i18 + i19) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) eVar2).bottomMargin + i19) - i17));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin) - this.x) - measuredHeight;
            }
            if (z3) {
                if (z2) {
                    i12 = this.u;
                } else {
                    i12 = 0;
                }
                int i210 = i12 - iArr[1];
                iMin -= Math.max(0, i210);
                iArr[1] = Math.max(0, -i210);
                if (zN) {
                    e eVar9 = (e) this.f452g.getLayoutParams();
                    int measuredWidth4 = iMin - this.f452g.getMeasuredWidth();
                    int measuredHeight4 = this.f452g.getMeasuredHeight() + paddingTop;
                    this.f452g.layout(measuredWidth4, paddingTop, iMin, measuredHeight4);
                    i13 = measuredWidth4 - this.v;
                    paddingTop = measuredHeight4 + ((ViewGroup.MarginLayoutParams) eVar9).bottomMargin;
                } else {
                    i13 = iMin;
                }
                if (zN2) {
                    int i211 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f453h.getLayoutParams())).topMargin;
                    this.f453h.layout(iMin - this.f453h.getMeasuredWidth(), i211, iMin, this.f453h.getMeasuredHeight() + i211);
                    i14 = iMin - this.v;
                } else {
                    i14 = iMin;
                }
                if (z2) {
                    iMin = Math.min(i13, i14);
                }
                iMax = iMax;
                i8 = 0;
            } else {
                if (z2) {
                    i9 = this.u;
                    i8 = 0;
                } else {
                    i8 = 0;
                    i9 = 0;
                }
                int i212 = i9 - iArr[i8];
                iMax += Math.max(i8, i212);
                iArr[i8] = Math.max(i8, -i212);
                if (zN) {
                    e eVar10 = (e) this.f452g.getLayoutParams();
                    int measuredWidth5 = this.f452g.getMeasuredWidth() + iMax;
                    int measuredHeight5 = this.f452g.getMeasuredHeight() + paddingTop;
                    this.f452g.layout(iMax, paddingTop, measuredWidth5, measuredHeight5);
                    i10 = measuredWidth5 + this.v;
                    paddingTop = measuredHeight5 + ((ViewGroup.MarginLayoutParams) eVar10).bottomMargin;
                } else {
                    i10 = iMax;
                }
                if (zN2) {
                    int i213 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f453h.getLayoutParams())).topMargin;
                    int measuredWidth6 = this.f453h.getMeasuredWidth() + iMax;
                    this.f453h.layout(iMax, i213, measuredWidth6, this.f453h.getMeasuredHeight() + i213);
                    i11 = measuredWidth6 + this.v;
                } else {
                    i11 = iMax;
                }
                if (z2) {
                    iMax = Math.max(i10, i11);
                }
            }
        } else {
            if (zN) {
                textView = this.f452g;
            } else {
                textView = this.f453h;
            }
            if (zN2) {
                textView2 = this.f453h;
            } else {
                textView2 = this.f452g;
            }
            eVar = (e) textView.getLayoutParams();
            eVar2 = (e) textView2.getLayoutParams();
            if (zN) {
            }
            i6 = this.B & 112;
            i7 = paddingLeft;
            if (i6 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + this.w;
            } else if (i6 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i15 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                i16 = this.w;
                if (iMax2 < i15 + i16) {
                    iMax2 = i15 + i16;
                } else {
                    i17 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    i18 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                    i19 = this.x;
                    if (i17 < i18 + i19) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) eVar2).bottomMargin + i19) - i17));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin) - this.x) - measuredHeight;
            }
            if (z3) {
                if (z2) {
                    i12 = this.u;
                } else {
                    i12 = 0;
                }
                int i214 = i12 - iArr[1];
                iMin -= Math.max(0, i214);
                iArr[1] = Math.max(0, -i214);
                if (zN) {
                    e eVar11 = (e) this.f452g.getLayoutParams();
                    int measuredWidth7 = iMin - this.f452g.getMeasuredWidth();
                    int measuredHeight6 = this.f452g.getMeasuredHeight() + paddingTop;
                    this.f452g.layout(measuredWidth7, paddingTop, iMin, measuredHeight6);
                    i13 = measuredWidth7 - this.v;
                    paddingTop = measuredHeight6 + ((ViewGroup.MarginLayoutParams) eVar11).bottomMargin;
                } else {
                    i13 = iMin;
                }
                if (zN2) {
                    int i215 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f453h.getLayoutParams())).topMargin;
                    this.f453h.layout(iMin - this.f453h.getMeasuredWidth(), i215, iMin, this.f453h.getMeasuredHeight() + i215);
                    i14 = iMin - this.v;
                } else {
                    i14 = iMin;
                }
                if (z2) {
                    iMin = Math.min(i13, i14);
                }
                iMax = iMax;
                i8 = 0;
            } else {
                if (z2) {
                    i9 = this.u;
                    i8 = 0;
                } else {
                    i8 = 0;
                    i9 = 0;
                }
                int i216 = i9 - iArr[i8];
                iMax += Math.max(i8, i216);
                iArr[i8] = Math.max(i8, -i216);
                if (zN) {
                    e eVar12 = (e) this.f452g.getLayoutParams();
                    int measuredWidth8 = this.f452g.getMeasuredWidth() + iMax;
                    int measuredHeight7 = this.f452g.getMeasuredHeight() + paddingTop;
                    this.f452g.layout(iMax, paddingTop, measuredWidth8, measuredHeight7);
                    i10 = measuredWidth8 + this.v;
                    paddingTop = measuredHeight7 + ((ViewGroup.MarginLayoutParams) eVar12).bottomMargin;
                } else {
                    i10 = iMax;
                }
                if (zN2) {
                    int i217 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f453h.getLayoutParams())).topMargin;
                    int measuredWidth9 = this.f453h.getMeasuredWidth() + iMax;
                    this.f453h.layout(iMax, i217, measuredWidth9, this.f453h.getMeasuredHeight() + i217);
                    i11 = measuredWidth9 + this.v;
                } else {
                    i11 = iMax;
                }
                if (z2) {
                    iMax = Math.max(i10, i11);
                }
            }
        }
        b(this.I, 3);
        size = this.I.size();
        while (i20 < size) {
            iMax = B(this.I.get(i20), iMax, iArr, iMin2);
        }
        i21 = iMin2;
        b(this.I, 5);
        size2 = this.I.size();
        while (i22 < size2) {
            iMin = C(this.I.get(i22), iMin, iArr, i21);
        }
        b(this.I, 1);
        int iU3 = u(this.I, iArr);
        i23 = (i7 + (((width - i7) - paddingRight) / 2)) - (iU3 / 2);
        i24 = iU3 + i23;
        if (i23 >= iMax) {
            if (i24 > iMin) {
                iMax = i23 - (i24 - iMin);
            } else {
                iMax = i23;
            }
        }
        size3 = this.I.size();
        while (i8 < size3) {
            iMax = B(this.I.get(i8), iMax, iArr, i21);
            i8++;
        }
        this.I.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        int[] iArr = this.K;
        if (w0.b(this)) {
            c2 = 1;
            c3 = 0;
        } else {
            c2 = 0;
            c3 = 1;
        }
        if (N(this.f454i)) {
            E(this.f454i, i2, 0, i3, 0, this.t);
            measuredWidth = this.f454i.getMeasuredWidth() + s(this.f454i);
            iMax = Math.max(0, this.f454i.getMeasuredHeight() + t(this.f454i));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f454i.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (N(this.m)) {
            E(this.m, i2, 0, i3, 0, this.t);
            measuredWidth = this.m.getMeasuredWidth() + s(this.m);
            iMax = Math.max(iMax, this.m.getMeasuredHeight() + t(this.m));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.m.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = 0 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[c2] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (N(this.f451f)) {
            E(this.f451f, i2, iMax3, i3, 0, this.t);
            measuredWidth2 = this.f451f.getMeasuredWidth() + s(this.f451f);
            iMax = Math.max(iMax, this.f451f.getMeasuredHeight() + t(this.f451f));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f451f.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[c3] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (N(this.n)) {
            iMax4 += D(this.n, i2, iMax4, i3, 0, iArr);
            iMax = Math.max(iMax, this.n.getMeasuredHeight() + t(this.n));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.n.getMeasuredState());
        }
        if (N(this.f455j)) {
            iMax4 += D(this.f455j, i2, iMax4, i3, 0, iArr);
            iMax = Math.max(iMax, this.f455j.getMeasuredHeight() + t(this.f455j));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f455j.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (((e) childAt.getLayoutParams()).f464b == 0 && N(childAt)) {
                iMax4 += D(childAt, i2, iMax4, i3, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i5 = this.w + this.x;
        int i6 = this.u + this.v;
        if (N(this.f452g)) {
            D(this.f452g, i2, iMax4 + i6, i3, i5, iArr);
            int measuredWidth3 = this.f452g.getMeasuredWidth() + s(this.f452g);
            measuredHeight = this.f452g.getMeasuredHeight() + t(this.f452g);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f452g.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (N(this.f453h)) {
            iMax2 = Math.max(iMax2, D(this.f453h, i2, iMax4 + i6, i3, measuredHeight + i5, iArr));
            measuredHeight += this.f453h.getMeasuredHeight() + t(this.f453h);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f453h.getMeasuredState());
        }
        int iMax5 = Math.max(iMax, measuredHeight);
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, (-16777216) & iCombineMeasuredStates2), M() ? 0 : View.resolveSizeAndState(Math.max(iMax5 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f451f;
        androidx.appcompat.view.menu.g gVarN = actionMenuView != null ? actionMenuView.N() : null;
        int i2 = savedState.f457h;
        if (i2 != 0 && this.P != null && gVarN != null && (menuItemFindItem = gVarN.findItem(i2)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.f458i) {
            F();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i2);
        }
        h();
        this.y.f(i2 == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.i iVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        d dVar = this.P;
        if (dVar != null && (iVar = dVar.f462g) != null) {
            savedState.f457h = iVar.getItemId();
        }
        savedState.f458i = A();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.G = false;
        }
        if (!this.G) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.G = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.G = false;
        }
        return true;
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(c.a.k.a.a.d(getContext(), i2));
    }

    public void setCollapsible(boolean z) {
        this.S = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.A) {
            this.A = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.z) {
            this.z = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(c.a.k.a.a.d(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(c.a.k.a.a.d(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f454i.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.L = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f451f.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.p != i2) {
            this.p = i2;
            if (i2 == 0) {
                this.o = getContext();
            } else {
                this.o = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.x = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.v = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.u = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.w = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public boolean v() {
        d dVar = this.P;
        return (dVar == null || dVar.f462g == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f451f;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.f451f;
        return actionMenuView != null && actionMenuView.I();
    }

    public static class e extends androidx.appcompat.app.a.C0009a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f464b;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f464b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(int i2, int i3) {
            super(i2, i3);
            this.f464b = 0;
            this.a = 8388627;
        }

        public e(e eVar) {
            super((androidx.appcompat.app.a.C0009a) eVar);
            this.f464b = 0;
            this.f464b = eVar.f464b;
        }

        public e(androidx.appcompat.app.a.C0009a c0009a) {
            super(c0009a);
            this.f464b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f464b = 0;
            a(marginLayoutParams);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f464b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.B = 8388627;
        this.I = new ArrayList<>();
        this.J = new ArrayList<>();
        this.K = new int[2];
        this.M = new a();
        this.T = new b();
        Context context2 = getContext();
        int[] iArr = c.a.j.k3;
        q0 q0VarV = q0.v(context2, attributeSet, iArr, i2, 0);
        androidx.core.view.u.g0(this, context, iArr, attributeSet, q0VarV.r(), i2, 0);
        this.q = q0VarV.n(c.a.j.M3, 0);
        this.r = q0VarV.n(c.a.j.D3, 0);
        this.B = q0VarV.l(c.a.j.l3, this.B);
        this.s = q0VarV.l(c.a.j.m3, 48);
        int iE = q0VarV.e(c.a.j.G3, 0);
        int i3 = c.a.j.L3;
        iE = q0VarV.s(i3) ? q0VarV.e(i3, iE) : iE;
        this.x = iE;
        this.w = iE;
        this.v = iE;
        this.u = iE;
        int iE2 = q0VarV.e(c.a.j.J3, -1);
        if (iE2 >= 0) {
            this.u = iE2;
        }
        int iE3 = q0VarV.e(c.a.j.I3, -1);
        if (iE3 >= 0) {
            this.v = iE3;
        }
        int iE4 = q0VarV.e(c.a.j.K3, -1);
        if (iE4 >= 0) {
            this.w = iE4;
        }
        int iE5 = q0VarV.e(c.a.j.H3, -1);
        if (iE5 >= 0) {
            this.x = iE5;
        }
        this.t = q0VarV.f(c.a.j.x3, -1);
        int iE6 = q0VarV.e(c.a.j.t3, Integer.MIN_VALUE);
        int iE7 = q0VarV.e(c.a.j.p3, Integer.MIN_VALUE);
        int iF = q0VarV.f(c.a.j.r3, 0);
        int iF2 = q0VarV.f(c.a.j.s3, 0);
        h();
        this.y.e(iF, iF2);
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            this.y.g(iE6, iE7);
        }
        this.z = q0VarV.e(c.a.j.u3, Integer.MIN_VALUE);
        this.A = q0VarV.e(c.a.j.q3, Integer.MIN_VALUE);
        this.f456k = q0VarV.g(c.a.j.o3);
        this.l = q0VarV.p(c.a.j.n3);
        CharSequence charSequenceP = q0VarV.p(c.a.j.F3);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = q0VarV.p(c.a.j.C3);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.o = getContext();
        setPopupTheme(q0VarV.n(c.a.j.B3, 0));
        Drawable drawableG = q0VarV.g(c.a.j.A3);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = q0VarV.p(c.a.j.z3);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = q0VarV.g(c.a.j.v3);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = q0VarV.p(c.a.j.w3);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        int i4 = c.a.j.N3;
        if (q0VarV.s(i4)) {
            setTitleTextColor(q0VarV.c(i4));
        }
        int i5 = c.a.j.E3;
        if (q0VarV.s(i5)) {
            setSubtitleTextColor(q0VarV.c(i5));
        }
        int i6 = c.a.j.y3;
        if (q0VarV.s(i6)) {
            x(q0VarV.n(i6, 0));
        }
        q0VarV.w();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.m;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.m.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.m;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f456k);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!y(this.f455j)) {
                c(this.f455j, true);
            }
        } else {
            ImageView imageView = this.f455j;
            if (imageView != null && y(imageView)) {
                removeView(this.f455j);
                this.J.remove(this.f455j);
            }
        }
        ImageView imageView2 = this.f455j;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f455j;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f454i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!y(this.f454i)) {
                c(this.f454i, true);
            }
        } else {
            ImageButton imageButton = this.f454i;
            if (imageButton != null && y(imageButton)) {
                removeView(this.f454i);
                this.J.remove(this.f454i);
            }
        }
        ImageButton imageButton2 = this.f454i;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f453h;
            if (textView != null && y(textView)) {
                removeView(this.f453h);
                this.J.remove(this.f453h);
            }
        } else {
            if (this.f453h == null) {
                Context context = getContext();
                t tVar = new t(context);
                this.f453h = tVar;
                tVar.setSingleLine();
                this.f453h.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.r;
                if (i2 != 0) {
                    this.f453h.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.F;
                if (colorStateList != null) {
                    this.f453h.setTextColor(colorStateList);
                }
            }
            if (!y(this.f453h)) {
                c(this.f453h, true);
            }
        }
        TextView textView2 = this.f453h;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.D = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.F = colorStateList;
        TextView textView = this.f453h;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f452g;
            if (textView != null && y(textView)) {
                removeView(this.f452g);
                this.J.remove(this.f452g);
            }
        } else {
            if (this.f452g == null) {
                Context context = getContext();
                t tVar = new t(context);
                this.f452g = tVar;
                tVar.setSingleLine();
                this.f452g.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.q;
                if (i2 != 0) {
                    this.f452g.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    this.f452g.setTextColor(colorStateList);
                }
            }
            if (!y(this.f452g)) {
                c(this.f452g, true);
            }
        }
        TextView textView2 = this.f452g;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.C = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.E = colorStateList;
        TextView textView = this.f452g;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f457h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f458i;

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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f457h = parcel.readInt();
            this.f458i = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f457h);
            parcel.writeInt(this.f458i ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
