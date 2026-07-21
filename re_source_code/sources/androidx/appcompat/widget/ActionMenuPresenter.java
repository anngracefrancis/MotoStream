package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements androidx.core.view.b.a {
    private boolean A;
    private int B;
    private final SparseBooleanArray C;
    e D;
    a E;
    c F;
    private b G;
    final f H;
    int I;
    d p;
    private Drawable q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f374f;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f374f);
        }

        SavedState(Parcel parcel) {
            this.f374f = parcel.readInt();
        }
    }

    private class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.r rVar, View view) {
            super(context, rVar, view, false, c.a.a.l);
            if (!((androidx.appcompat.view.menu.i) rVar.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.p;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).n : view2);
            }
            j(ActionMenuPresenter.this.H);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.E = null;
            actionMenuPresenter.I = 0;
            super.e();
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.p a() {
            a aVar = ActionMenuPresenter.this.E;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private e f375f;

        public c(e eVar) {
            this.f375f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f269h != null) {
                ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f269h.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).n;
            if (view != null && view.getWindowToken() != null && this.f375f.m()) {
                ActionMenuPresenter.this.D = this.f375f;
            }
            ActionMenuPresenter.this.F = null;
        }
    }

    private class d extends AppCompatImageView implements ActionMenuView.a {

        class a extends b0 {
            final /* synthetic */ ActionMenuPresenter o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.o = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.b0
            public androidx.appcompat.view.menu.p b() {
                e eVar = ActionMenuPresenter.this.D;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.b0
            public boolean c() {
                ActionMenuPresenter.this.M();
                return true;
            }

            @Override // androidx.appcompat.widget.b0
            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.F != null) {
                    return false;
                }
                actionMenuPresenter.D();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, c.a.a.f2694k);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            s0.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.M();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    private class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z) {
            super(context, gVar, view, z, c.a.a.l);
            h(8388613);
            j(ActionMenuPresenter.this.H);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            if (((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f269h != null) {
                ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f269h.close();
            }
            ActionMenuPresenter.this.D = null;
            super.e();
        }
    }

    private class f implements androidx.appcompat.view.menu.m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (gVar instanceof androidx.appcompat.view.menu.r) {
                gVar.F().e(false);
            }
            androidx.appcompat.view.menu.m.a aVarO = ActionMenuPresenter.this.o();
            if (aVarO != null) {
                aVarO.b(gVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            if (gVar == ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f269h) {
                return false;
            }
            ActionMenuPresenter.this.I = ((androidx.appcompat.view.menu.r) gVar).getItem().getItemId();
            androidx.appcompat.view.menu.m.a aVarO = ActionMenuPresenter.this.o();
            if (aVarO != null) {
                return aVarO.c(gVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, c.a.g.f2733c, c.a.g.f2732b);
        this.C = new SparseBooleanArray();
        this.H = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View B(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.n;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof androidx.appcompat.view.menu.n.a) && ((androidx.appcompat.view.menu.n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean A() {
        return D() | E();
    }

    public Drawable C() {
        d dVar = this.p;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.r) {
            return this.q;
        }
        return null;
    }

    public boolean D() {
        Object obj;
        c cVar = this.F;
        if (cVar != null && (obj = this.n) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.F = null;
            return true;
        }
        e eVar = this.D;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean E() {
        a aVar = this.E;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean F() {
        return this.F != null || G();
    }

    public boolean G() {
        e eVar = this.D;
        return eVar != null && eVar.d();
    }

    public void H(Configuration configuration) {
        if (!this.x) {
            this.w = c.a.o.a.b(this.f268g).d();
        }
        androidx.appcompat.view.menu.g gVar = this.f269h;
        if (gVar != null) {
            gVar.M(true);
        }
    }

    public void I(boolean z) {
        this.A = z;
    }

    public void J(ActionMenuView actionMenuView) {
        this.n = actionMenuView;
        actionMenuView.b(this.f269h);
    }

    public void K(Drawable drawable) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.r = true;
            this.q = drawable;
        }
    }

    public void L(boolean z) {
        this.s = z;
        this.t = true;
    }

    public boolean M() {
        androidx.appcompat.view.menu.g gVar;
        if (!this.s || G() || (gVar = this.f269h) == null || this.n == null || this.F != null || gVar.B().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f268g, this.f269h, this.p, true));
        this.F = cVar;
        ((View) this.n).post(cVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
        A();
        super.b(gVar, z);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void c(boolean z) {
        super.c(z);
        ((View) this.n).requestLayout();
        androidx.appcompat.view.menu.g gVar = this.f269h;
        boolean z2 = false;
        if (gVar != null) {
            ArrayList<androidx.appcompat.view.menu.i> arrayListU = gVar.u();
            int size = arrayListU.size();
            for (int i2 = 0; i2 < size; i2++) {
                androidx.core.view.b bVarB = arrayListU.get(i2).b();
                if (bVarB != null) {
                    bVarB.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.g gVar2 = this.f269h;
        ArrayList<androidx.appcompat.view.menu.i> arrayListB = gVar2 != null ? gVar2.B() : null;
        if (this.s && arrayListB != null) {
            int size2 = arrayListB.size();
            if (size2 == 1) {
                z2 = !arrayListB.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.p == null) {
                this.p = new d(this.f267f);
            }
            ViewGroup viewGroup = (ViewGroup) this.p.getParent();
            if (viewGroup != this.n) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.p);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.n;
                actionMenuView.addView(this.p, actionMenuView.F());
            }
        } else {
            d dVar = this.p;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.n;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.p);
                }
            }
        }
        ((ActionMenuView) this.n).setOverflowReserved(this.s);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        ArrayList<androidx.appcompat.view.menu.i> arrayListG;
        int size;
        int i2;
        int iL;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.g gVar = actionMenuPresenter.f269h;
        View view = null;
        int i3 = 0;
        if (gVar != null) {
            arrayListG = gVar.G();
            size = arrayListG.size();
        } else {
            arrayListG = null;
            size = 0;
        }
        int i4 = actionMenuPresenter.w;
        int i5 = actionMenuPresenter.v;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.n;
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            androidx.appcompat.view.menu.i iVar = arrayListG.get(i8);
            if (iVar.o()) {
                i6++;
            } else if (iVar.n()) {
                i7++;
            } else {
                z = true;
            }
            if (actionMenuPresenter.A && iVar.isActionViewExpanded()) {
                i4 = 0;
            }
        }
        if (actionMenuPresenter.s && (z || i7 + i6 > i4)) {
            i4--;
        }
        int i9 = i4 - i6;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.C;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.y) {
            int i10 = actionMenuPresenter.B;
            iL = i5 / i10;
            i2 = i10 + ((i5 % i10) / iL);
        } else {
            i2 = 0;
            iL = 0;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            androidx.appcompat.view.menu.i iVar2 = arrayListG.get(i11);
            if (iVar2.o()) {
                View viewP = actionMenuPresenter.p(iVar2, view, viewGroup);
                if (actionMenuPresenter.y) {
                    iL -= ActionMenuView.L(viewP, i2, iL, iMakeMeasureSpec, i3);
                } else {
                    viewP.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewP.getMeasuredWidth();
                i5 -= measuredWidth;
                if (i12 == 0) {
                    i12 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
            } else {
                if (iVar2.n()) {
                    int groupId2 = iVar2.getGroupId();
                    boolean z2 = sparseBooleanArray.get(groupId2);
                    boolean z3 = (i9 > 0 || z2) && i5 > 0 && (!actionMenuPresenter.y || iL > 0);
                    boolean z4 = z3;
                    if (z3) {
                        View viewP2 = actionMenuPresenter.p(iVar2, null, viewGroup);
                        if (actionMenuPresenter.y) {
                            int iL2 = ActionMenuView.L(viewP2, i2, iL, iMakeMeasureSpec, 0);
                            iL -= iL2;
                            if (iL2 == 0) {
                                z4 = false;
                            }
                        } else {
                            viewP2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        }
                        boolean z5 = z4;
                        int measuredWidth2 = viewP2.getMeasuredWidth();
                        i5 -= measuredWidth2;
                        if (i12 == 0) {
                            i12 = measuredWidth2;
                        }
                        z3 = z5 & (!actionMenuPresenter.y ? i5 + i12 <= 0 : i5 < 0);
                    }
                    if (z3 && groupId2 != 0) {
                        sparseBooleanArray.put(groupId2, true);
                    } else if (z2) {
                        sparseBooleanArray.put(groupId2, false);
                        for (int i13 = 0; i13 < i11; i13++) {
                            androidx.appcompat.view.menu.i iVar3 = arrayListG.get(i13);
                            if (iVar3.getGroupId() == groupId2) {
                                if (iVar3.l()) {
                                    i9++;
                                }
                                iVar3.u(false);
                            }
                        }
                    }
                    if (z3) {
                        i9--;
                    }
                    iVar2.u(z3);
                } else {
                    size = size;
                    iVar2.u(false);
                }
                i11++;
                view = null;
                actionMenuPresenter = this;
                size = size;
                i3 = 0;
            }
            i11++;
            view = null;
            actionMenuPresenter = this;
            size = size;
            i3 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void h(Context context, androidx.appcompat.view.menu.g gVar) {
        super.h(context, gVar);
        Resources resources = context.getResources();
        c.a.o.a aVarB = c.a.o.a.b(context);
        if (!this.t) {
            this.s = aVarB.h();
        }
        if (!this.z) {
            this.u = aVarB.c();
        }
        if (!this.x) {
            this.w = aVarB.d();
        }
        int measuredWidth = this.u;
        if (this.s) {
            if (this.p == null) {
                d dVar = new d(this.f267f);
                this.p = dVar;
                if (this.r) {
                    dVar.setImageDrawable(this.q);
                    this.q = null;
                    this.r = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.p.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.p.getMeasuredWidth();
        } else {
            this.p = null;
        }
        this.v = measuredWidth;
        this.B = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(Parcelable parcelable) {
        int i2;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i2 = ((SavedState) parcelable).f374f) > 0 && (menuItemFindItem = this.f269h.findItem(i2)) != null) {
            k((androidx.appcompat.view.menu.r) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.b
    public void j(androidx.appcompat.view.menu.i iVar, androidx.appcompat.view.menu.n.a aVar) {
        aVar.e(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.n);
        if (this.G == null) {
            this.G = new b();
        }
        actionMenuItemView.setPopupCallback(this.G);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean k(androidx.appcompat.view.menu.r rVar) {
        boolean z = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.r rVar2 = rVar;
        while (rVar2.i0() != this.f269h) {
            rVar2 = (androidx.appcompat.view.menu.r) rVar2.i0();
        }
        View viewB = B(rVar2.getItem());
        if (viewB == null) {
            return false;
        }
        this.I = rVar.getItem().getItemId();
        int size = rVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = rVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        a aVar = new a(this.f268g, rVar, viewB);
        this.E = aVar;
        aVar.g(z);
        this.E.k();
        super.k(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable l() {
        SavedState savedState = new SavedState();
        savedState.f374f = this.I;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean n(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.p) {
            return false;
        }
        return super.n(viewGroup, i2);
    }

    @Override // androidx.appcompat.view.menu.b
    public View p(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.p(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.n q(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.n nVar = this.n;
        androidx.appcompat.view.menu.n nVarQ = super.q(viewGroup);
        if (nVar != nVarQ) {
            ((ActionMenuView) nVarQ).setPresenter(this);
        }
        return nVarQ;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean s(int i2, androidx.appcompat.view.menu.i iVar) {
        return iVar.l();
    }
}
