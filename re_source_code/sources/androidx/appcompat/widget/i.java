package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;

/* JADX INFO: compiled from: AppCompatEditText.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends EditText implements androidx.core.view.t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final s f539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final r f540h;

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.B);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f538f;
        if (dVar != null) {
            dVar.b();
        }
        s sVar = this.f539g;
        if (sVar != null) {
            sVar.b();
        }
    }

    @Override // androidx.core.view.t
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f538f;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f538f;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        r rVar;
        return (Build.VERSION.SDK_INT >= 28 || (rVar = this.f540h) == null) ? super.getTextClassifier() : rVar.a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f538f;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f538f;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.k.p(this, callback));
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f538f;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f538f;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        s sVar = this.f539g;
        if (sVar != null) {
            sVar.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        r rVar;
        if (Build.VERSION.SDK_INT >= 28 || (rVar = this.f540h) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            rVar.b(textClassifier);
        }
    }

    public i(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        d dVar = new d(this);
        this.f538f = dVar;
        dVar.e(attributeSet, i2);
        s sVar = new s(this);
        this.f539g = sVar;
        sVar.m(attributeSet, i2);
        sVar.b();
        this.f540h = new r(this);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}
