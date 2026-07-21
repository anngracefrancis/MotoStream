package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends c0 implements androidx.appcompat.view.menu.g.b, androidx.appcompat.view.menu.n {
    androidx.appcompat.view.menu.g.a A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    e F;
    private androidx.appcompat.view.menu.g u;
    private Context v;
    private int w;
    private boolean x;
    private ActionMenuPresenter y;
    private androidx.appcompat.view.menu.m.a z;

    public interface a {
        boolean a();

        boolean b();
    }

    private static class b implements androidx.appcompat.view.menu.m.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            return false;
        }
    }

    public static class c extends c0.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f379c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f380d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f381e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f382f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f383g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f384h;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f379c = cVar.f379c;
        }

        public c(int i2, int i3) {
            super(i2, i3);
            this.f379c = false;
        }
    }

    private class d implements androidx.appcompat.view.menu.g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.F;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.g.a aVar = ActionMenuView.this.A;
            if (aVar != null) {
                aVar.b(gVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    static int L(View view, int i2, int i3, int i4, int i5) {
        c cVar = (c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = actionMenuItemView != null && actionMenuItemView.f();
        int i6 = 2;
        if (i3 <= 0 || (z && i3 < 2)) {
            i6 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i7 = measuredWidth / i2;
            if (measuredWidth % i2 != 0) {
                i7++;
            }
            if (!z || i7 >= 2) {
                i6 = i7;
            }
        }
        cVar.f382f = !cVar.f379c && z;
        cVar.f380d = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), iMakeMeasureSpec);
        return i6;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    private void M(int i2, int i3) {
        boolean z;
        int i4;
        boolean z2;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int i5 = size - paddingLeft;
        int i6 = this.D;
        int i7 = i5 / i6;
        int i8 = i5 % i6;
        if (i7 == 0) {
            setMeasuredDimension(i5, 0);
            return;
        }
        int i9 = i6 + (i8 / i7);
        int childCount = getChildCount();
        int iMax = 0;
        int i10 = 0;
        boolean z3 = false;
        int i11 = 0;
        int iMax2 = 0;
        int i12 = 0;
        long j2 = 0;
        while (i10 < childCount) {
            View childAt = getChildAt(i10);
            int i13 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z4 = childAt instanceof ActionMenuItemView;
                int i14 = i11 + 1;
                if (z4) {
                    int i15 = this.E;
                    r14 = 0;
                    childAt.setPadding(i15, 0, i15, 0);
                } else {
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f384h = r14;
                cVar.f381e = r14;
                cVar.f380d = r14;
                cVar.f382f = r14;
                ((ViewGroup.MarginLayoutParams) cVar).leftMargin = r14;
                ((ViewGroup.MarginLayoutParams) cVar).rightMargin = r14;
                cVar.f383g = z4 && ((ActionMenuItemView) childAt).f();
                int iL = L(childAt, i9, cVar.f379c ? 1 : i7, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iL);
                if (cVar.f382f) {
                    i12++;
                }
                if (cVar.f379c) {
                    z3 = true;
                }
                i7 -= iL;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iL == 1) {
                    j2 |= (long) (1 << i10);
                    iMax = iMax;
                }
                i11 = i14;
            }
            i10++;
            size2 = i13;
        }
        int i16 = size2;
        boolean z5 = z3 && i11 == 2;
        boolean z6 = false;
        while (true) {
            if (i12 <= 0 || i7 <= 0) {
                z = z6;
                i4 = iMax;
                break;
            }
            int i17 = 0;
            int i18 = 0;
            int i19 = Integer.MAX_VALUE;
            long j3 = 0;
            while (i18 < childCount) {
                boolean z7 = z6;
                c cVar2 = (c) getChildAt(i18).getLayoutParams();
                int i20 = iMax;
                if (cVar2.f382f) {
                    int i21 = cVar2.f380d;
                    if (i21 < i19) {
                        j3 = 1 << i18;
                        i19 = i21;
                        i17 = 1;
                    } else if (i21 == i19) {
                        i17++;
                        j3 |= 1 << i18;
                    }
                }
                i18++;
                iMax = i20;
                z6 = z7;
            }
            z = z6;
            i4 = iMax;
            j2 |= j3;
            if (i17 > i7) {
                break;
            }
            int i22 = i19 + 1;
            int i23 = 0;
            while (i23 < childCount) {
                View childAt2 = getChildAt(i23);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i24 = i5;
                int i25 = mode;
                long j4 = 1 << i23;
                if ((j3 & j4) == 0) {
                    if (cVar3.f380d == i22) {
                        j2 |= j4;
                    }
                    z5 = z5;
                } else {
                    if (z5 && cVar3.f383g && i7 == 1) {
                        int i26 = this.E;
                        childAt2.setPadding(i26 + i9, 0, i26, 0);
                    }
                    cVar3.f380d++;
                    cVar3.f384h = true;
                    i7--;
                }
                i23++;
                mode = i25;
                i5 = i24;
                z5 = z5;
            }
            iMax = i4;
            z6 = true;
        }
        boolean z8 = !z3 && i11 == 1;
        if (i7 <= 0 || j2 == 0 || (i7 >= i11 - 1 && !z8 && iMax2 <= 1)) {
            z2 = z;
        } else {
            float fBitCount = Long.bitCount(j2);
            if (!z8) {
                if ((j2 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f383g) {
                    fBitCount -= 0.5f;
                }
                int i27 = childCount - 1;
                if ((j2 & ((long) (1 << i27))) != 0 && !((c) getChildAt(i27).getLayoutParams()).f383g) {
                    fBitCount -= 0.5f;
                }
            }
            int i28 = fBitCount > 0.0f ? (int) ((i7 * i9) / fBitCount) : 0;
            z2 = z;
            for (int i29 = 0; i29 < childCount; i29++) {
                if ((j2 & ((long) (1 << i29))) != 0) {
                    View childAt3 = getChildAt(i29);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f381e = i28;
                        cVar4.f384h = true;
                        if (i29 == 0 && !cVar4.f383g) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = (-i28) / 2;
                        }
                    } else if (cVar4.f379c) {
                        cVar4.f381e = i28;
                        cVar4.f384h = true;
                        ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = (-i28) / 2;
                    } else {
                        if (i29 != 0) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = i28 / 2;
                        }
                        if (i29 != childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = i28 / 2;
                        }
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            for (int i30 = 0; i30 < childCount; i30++) {
                View childAt4 = getChildAt(i30);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f384h) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f380d * i9) + cVar5.f381e, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i5, mode != 1073741824 ? i4 : i16);
    }

    public void B() {
        ActionMenuPresenter actionMenuPresenter = this.y;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.c0
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.f495b = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.c0
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.c0
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.f495b <= 0) {
            cVar.f495b = 16;
        }
        return cVar;
    }

    public c F() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f379c = true;
        return cVarGenerateDefaultLayoutParams;
    }

    protected boolean G(int i2) {
        boolean zA = false;
        if (i2 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i2 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            zA = false | ((a) childAt).a();
        }
        return (i2 <= 0 || !(childAt2 instanceof a)) ? zA : zA | ((a) childAt2).b();
    }

    public boolean H() {
        ActionMenuPresenter actionMenuPresenter = this.y;
        return actionMenuPresenter != null && actionMenuPresenter.D();
    }

    public boolean I() {
        ActionMenuPresenter actionMenuPresenter = this.y;
        return actionMenuPresenter != null && actionMenuPresenter.F();
    }

    public boolean J() {
        ActionMenuPresenter actionMenuPresenter = this.y;
        return actionMenuPresenter != null && actionMenuPresenter.G();
    }

    public boolean K() {
        return this.x;
    }

    public androidx.appcompat.view.menu.g N() {
        return this.u;
    }

    public void O(androidx.appcompat.view.menu.m.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.z = aVar;
        this.A = aVar2;
    }

    public boolean P() {
        ActionMenuPresenter actionMenuPresenter = this.y;
        return actionMenuPresenter != null && actionMenuPresenter.M();
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(androidx.appcompat.view.menu.i iVar) {
        return this.u.N(iVar, 0);
    }

    @Override // androidx.appcompat.view.menu.n
    public void b(androidx.appcompat.view.menu.g gVar) {
        this.u = gVar;
    }

    @Override // androidx.appcompat.widget.c0, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.u == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
            this.u = gVar;
            gVar.V(new d());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.y = actionMenuPresenter;
            actionMenuPresenter.L(true);
            ActionMenuPresenter actionMenuPresenter2 = this.y;
            androidx.appcompat.view.menu.m.a bVar = this.z;
            if (bVar == null) {
                bVar = new b();
            }
            actionMenuPresenter2.g(bVar);
            this.u.c(this.y, this.v);
            this.y.J(this);
        }
        return this.u;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.y.C();
    }

    public int getPopupTheme() {
        return this.w;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.y;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.c(false);
            if (this.y.G()) {
                this.y.D();
                this.y.M();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    @Override // androidx.appcompat.widget.c0, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int width;
        int paddingLeft;
        if (!this.B) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i6 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i7 = i4 - i2;
        int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
        boolean zB = w0.b(this);
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f379c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i10)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i11 = i6 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i11, width, measuredHeight + i11);
                    paddingRight -= measuredWidth;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin) + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                    G(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = (i7 / 2) - (measuredWidth2 / 2);
            int i13 = i6 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth2 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (i8 ^ 1);
        int iMax = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt3 = getChildAt(i15);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f379c) {
                    int i16 = width2 - ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i6 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth3, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt4 = getChildAt(i18);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f379c) {
                int i19 = paddingLeft2 + ((ViewGroup.MarginLayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i20 = i6 - (measuredHeight4 / 2);
                childAt4.layout(i19, i20, i19 + measuredWidth4, measuredHeight4 + i20);
                paddingLeft2 = i19 + measuredWidth4 + ((ViewGroup.MarginLayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.c0, android.view.View
    protected void onMeasure(int i2, int i3) {
        androidx.appcompat.view.menu.g gVar;
        boolean z = this.B;
        boolean z2 = View.MeasureSpec.getMode(i2) == 1073741824;
        this.B = z2;
        if (z != z2) {
            this.C = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (this.B && (gVar = this.u) != null && size != this.C) {
            this.C = size;
            gVar.M(true);
        }
        int childCount = getChildCount();
        if (this.B && childCount > 0) {
            M(i2, i3);
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            c cVar = (c) getChildAt(i4).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) cVar).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i2, i3);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.y.I(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.F = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.y.K(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.x = z;
    }

    public void setPopupTheme(int i2) {
        if (this.w != i2) {
            this.w = i2;
            if (i2 == 0) {
                this.v = getContext();
            } else {
                this.v = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.y = actionMenuPresenter;
        actionMenuPresenter.J(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.D = (int) (56.0f * f2);
        this.E = (int) (f2 * 4.0f);
        this.v = context;
        this.w = 0;
    }
}
