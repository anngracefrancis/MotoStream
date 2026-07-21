package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: DropDownListView.java */
/* JADX INFO: loaded from: classes.dex */
class z extends ListView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f671i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f672j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f673k;
    private Field l;
    private a m;
    private boolean n;
    private boolean o;
    private boolean p;
    private androidx.core.view.y q;
    private androidx.core.widget.h r;
    b s;

    /* JADX INFO: compiled from: DropDownListView.java */
    private static class a extends c.a.l.a.c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f674g;

        a(Drawable drawable) {
            super(drawable);
            this.f674g = true;
        }

        void c(boolean z) {
            this.f674g = z;
        }

        @Override // c.a.l.a.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f674g) {
                super.draw(canvas);
            }
        }

        @Override // c.a.l.a.c, android.graphics.drawable.Drawable
        public void setHotspot(float f2, float f3) {
            if (this.f674g) {
                super.setHotspot(f2, f3);
            }
        }

        @Override // c.a.l.a.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.f674g) {
                super.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        @Override // c.a.l.a.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f674g) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // c.a.l.a.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f674g) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: DropDownListView.java */
    private class b implements Runnable {
        b() {
        }

        public void a() {
            z zVar = z.this;
            zVar.s = null;
            zVar.removeCallbacks(this);
        }

        public void b() {
            z.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            z zVar = z.this;
            zVar.s = null;
            zVar.drawableStateChanged();
        }
    }

    z(Context context, boolean z) {
        super(context, null, c.a.a.A);
        this.f668f = new Rect();
        this.f669g = 0;
        this.f670h = 0;
        this.f671i = 0;
        this.f672j = 0;
        this.o = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.l = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        this.p = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f673k - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        androidx.core.view.y yVar = this.q;
        if (yVar != null) {
            yVar.b();
            this.q = null;
        }
    }

    private void b(View view, int i2) {
        performItemClick(view, i2, getItemIdAtPosition(i2));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f668f.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f668f);
        selector.draw(canvas);
    }

    private void f(int i2, View view) {
        Rect rect = this.f668f;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f669g;
        rect.top -= this.f670h;
        rect.right += this.f671i;
        rect.bottom += this.f672j;
        try {
            boolean z = this.l.getBoolean(this);
            if (view.isEnabled() != z) {
                this.l.set(this, Boolean.valueOf(!z));
                if (i2 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    private void g(int i2, View view) {
        Drawable selector = getSelector();
        boolean z = (selector == null || i2 == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        f(i2, view);
        if (z) {
            Rect rect = this.f668f;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.a.k(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void h(int i2, View view, float f2, float f3) {
        g(i2, view);
        Drawable selector = getSelector();
        if (selector == null || i2 == -1) {
            return;
        }
        androidx.core.graphics.drawable.a.k(selector, f2, f3);
    }

    private void i(View view, int i2, float f2, float f3) {
        View childAt;
        this.p = true;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            drawableHotspotChanged(f2, f3);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i4 = this.f673k;
        if (i4 != -1 && (childAt = getChildAt(i4 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f673k = i2;
        float left = f2 - view.getLeft();
        float top = f3 - view.getTop();
        if (i3 >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i2, view, f2, f3);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean j() {
        return this.p;
    }

    private void k() {
        Drawable selector = getSelector();
        if (selector != null && j() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void setSelectorEnabled(boolean z) {
        a aVar = this.m;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    public int d(int i2, int i3, int i4, int i5, int i6) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i10 = layoutParams.height;
            view.measure(i2, i10 > 0 ? View.MeasureSpec.makeMeasureSpec(i10, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i5) {
                return (i6 < 0 || i7 <= i6 || i9 <= 0 || measuredHeight == i5) ? i5 : i9;
            }
            if (i6 >= 0 && i7 >= i6) {
                i9 = measuredHeight;
            }
            i7++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.s != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        k();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:9:0x0011  */
    public boolean e(MotionEvent motionEvent, int i2) {
        boolean z;
        boolean z2;
        androidx.core.widget.h hVar;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            z = false;
        } else {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    z2 = false;
                    z = true;
                } else {
                    z2 = false;
                    z = false;
                }
                if (z || z2) {
                    a();
                }
                if (z) {
                    if (this.r == null) {
                        this.r = new androidx.core.widget.h(this);
                    }
                    this.r.m(true);
                    this.r.onTouch(this, motionEvent);
                } else {
                    hVar = this.r;
                    if (hVar != null) {
                        hVar.m(false);
                    }
                }
                return z;
            }
            z = true;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i2);
        if (iFindPointerIndex < 0) {
            z2 = false;
            z = false;
        } else {
            int x = (int) motionEvent.getX(iFindPointerIndex);
            int y = (int) motionEvent.getY(iFindPointerIndex);
            int iPointToPosition = pointToPosition(x, y);
            if (iPointToPosition == -1) {
                z2 = true;
            } else {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                i(childAt, iPointToPosition, x, y);
                if (actionMasked == 1) {
                    b(childAt, iPointToPosition);
                }
                z2 = false;
                z = true;
            }
        }
        if (z) {
            a();
        } else {
            a();
        }
        if (z) {
            if (this.r == null) {
                this.r = new androidx.core.widget.h(this);
            }
            this.r.m(true);
            this.r.onTouch(this, motionEvent);
        } else {
            hVar = this.r;
            if (hVar != null) {
                hVar.m(false);
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.o || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.o || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.o || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.o && this.n) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.s = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.s == null) {
            b bVar = new b();
            this.s = bVar;
            bVar.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                k();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f673k = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.s;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z) {
        this.n = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.m = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f669g = rect.left;
        this.f670h = rect.top;
        this.f671i = rect.right;
        this.f672j = rect.bottom;
    }
}
