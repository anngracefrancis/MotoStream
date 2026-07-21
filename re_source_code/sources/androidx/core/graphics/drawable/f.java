package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: compiled from: WrappedDrawableState.java */
/* JADX INFO: loaded from: classes.dex */
final class f extends Drawable.ConstantState {
    int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ColorStateList f984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f985d;

    f(f fVar) {
        this.f984c = null;
        this.f985d = d.f977f;
        if (fVar != null) {
            this.a = fVar.a;
            this.f983b = fVar.f983b;
            this.f984c = fVar.f984c;
            this.f985d = fVar.f985d;
        }
    }

    boolean a() {
        return this.f983b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i2 = this.a;
        Drawable.ConstantState constantState = this.f983b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new e(this, resources) : new d(this, resources);
    }
}
