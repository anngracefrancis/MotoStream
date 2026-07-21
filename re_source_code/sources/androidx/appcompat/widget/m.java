package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* JADX INFO: compiled from: AppCompatMultiAutoCompleteTextView.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends MultiAutoCompleteTextView implements androidx.core.view.t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f585f = {R.attr.popupBackground};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final s f587h;

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.p);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f586g;
        if (dVar != null) {
            dVar.b();
        }
        s sVar = this.f587h;
        if (sVar != null) {
            sVar.b();
        }
    }

    @Override // androidx.core.view.t
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f586g;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f586g;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f586g;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f586g;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(c.a.k.a.a.d(getContext(), i2));
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f586g;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f586g;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        s sVar = this.f587h;
        if (sVar != null) {
            sVar.q(context, i2);
        }
    }

    public m(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        q0 q0VarV = q0.v(getContext(), attributeSet, f585f, i2, 0);
        if (q0VarV.s(0)) {
            setDropDownBackgroundDrawable(q0VarV.g(0));
        }
        q0VarV.w();
        d dVar = new d(this);
        this.f586g = dVar;
        dVar.e(attributeSet, i2);
        s sVar = new s(this);
        this.f587h = sVar;
        sVar.m(attributeSet, i2);
        sVar.b();
    }
}
