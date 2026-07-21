package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.s0;
import androidx.appcompat.widget.t;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends t implements n.a, View.OnClickListener, ActionMenuView.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    i f246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f247k;
    private Drawable l;
    g.b m;
    private b0 n;
    b o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;

    private class a extends b0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.b0
        public p b() {
            b bVar = ActionMenuItemView.this.o;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.b0
        protected boolean c() {
            p pVarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.m;
            return bVar != null && bVar.a(actionMenuItemView.f246j) && (pVarB = b()) != null && pVarB.a();
        }
    }

    public static abstract class b {
        public abstract p a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void h() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f247k);
        if (this.l != null && (!this.f246j.B() || (!this.p && !this.q))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f247k : null);
        CharSequence contentDescription = this.f246j.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f246j.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f246j.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            s0.a(this, z3 ? null : this.f246j.getTitle());
        } else {
            s0.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return f();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return f() && this.f246j.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(i iVar, int i2) {
        this.f246j = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.i(this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.n == null) {
            this.n = new a();
        }
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.f246j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar = this.m;
        if (bVar != null) {
            bVar.a(this.f246j);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.p = g();
        h();
    }

    @Override // androidx.appcompat.widget.t, android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        boolean zF = f();
        if (zF && (i4 = this.s) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.r) : this.r;
        if (mode != 1073741824 && this.r > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i3);
        }
        if (zF || this.l == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.l.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b0 b0Var;
        if (this.f246j.hasSubMenu() && (b0Var = this.n) != null && b0Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.q != z) {
            this.q = z;
            i iVar = this.f246j;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.l = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.t;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (intrinsicHeight * (i2 / intrinsicWidth));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(g.b bVar) {
        this.m = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.s = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.o = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f247k = charSequence;
        h();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.p = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.v, i2, 0);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.a.j.w, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.t = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.s = -1;
        setSaveEnabled(false);
    }
}
