package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: compiled from: AppCompatImageButton.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends ImageButton implements androidx.core.view.t, androidx.core.widget.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l f565g;

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.C);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f564f;
        if (dVar != null) {
            dVar.b();
        }
        l lVar = this.f565g;
        if (lVar != null) {
            lVar.b();
        }
    }

    @Override // androidx.core.view.t
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f564f;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f564f;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.n
    public ColorStateList getSupportImageTintList() {
        l lVar = this.f565g;
        if (lVar != null) {
            return lVar.c();
        }
        return null;
    }

    @Override // androidx.core.widget.n
    public PorterDuff.Mode getSupportImageTintMode() {
        l lVar = this.f565g;
        if (lVar != null) {
            return lVar.d();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f565g.e() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f564f;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f564f;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        l lVar = this.f565g;
        if (lVar != null) {
            lVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l lVar = this.f565g;
        if (lVar != null) {
            lVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        this.f565g.g(i2);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l lVar = this.f565g;
        if (lVar != null) {
            lVar.b();
        }
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f564f;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f564f;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportImageTintList(ColorStateList colorStateList) {
        l lVar = this.f565g;
        if (lVar != null) {
            lVar.h(colorStateList);
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        l lVar = this.f565g;
        if (lVar != null) {
            lVar.i(mode);
        }
    }

    public k(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        d dVar = new d(this);
        this.f564f = dVar;
        dVar.e(attributeSet, i2);
        l lVar = new l(this);
        this.f565g = lVar;
        lVar.f(attributeSet, i2);
    }
}
