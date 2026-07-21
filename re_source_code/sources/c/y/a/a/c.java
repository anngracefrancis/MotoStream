package c.y.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends h implements Animatable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f3633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f3634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArgbEvaluator f3635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Animator.AnimatorListener f3636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    ArrayList<c.y.a.a.b> f3637k;
    final Drawable.Callback l;

    /* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            c.this.scheduleSelf(runnable, j2);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
    private static class b extends Drawable.ConstantState {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        i f3639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        AnimatorSet f3640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList<Animator> f3641d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c.e.a<Animator, String> f3642e;

        public b(Context context, b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.a = bVar.a;
                i iVar = bVar.f3639b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    if (resources != null) {
                        this.f3639b = (i) constantState.newDrawable(resources);
                    } else {
                        this.f3639b = (i) constantState.newDrawable();
                    }
                    i iVar2 = (i) this.f3639b.mutate();
                    this.f3639b = iVar2;
                    iVar2.setCallback(callback);
                    this.f3639b.setBounds(bVar.f3639b.getBounds());
                    this.f3639b.h(false);
                }
                ArrayList<Animator> arrayList = bVar.f3641d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f3641d = new ArrayList<>(size);
                    this.f3642e = new c.e.a<>(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Animator animator = bVar.f3641d.get(i2);
                        Animator animatorClone = animator.clone();
                        String str = bVar.f3642e.get(animator);
                        animatorClone.setTarget(this.f3639b.d(str));
                        this.f3641d.add(animatorClone);
                        this.f3642e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f3640c == null) {
                this.f3640c = new AnimatorSet();
            }
            this.f3640c.playTogether(this.f3641d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    c() {
        this(null, null, null);
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f3633g.f3639b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        b bVar = this.f3633g;
        if (bVar.f3641d == null) {
            bVar.f3641d = new ArrayList<>();
            this.f3633g.f3642e = new c.e.a<>();
        }
        this.f3633g.f3641d.add(animator);
        this.f3633g.f3642e.put(animator, str);
    }

    private void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                c(childAnimations.get(i2));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f3635i == null) {
                    this.f3635i = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f3635i);
            }
        }
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f3633g.f3639b.draw(canvas);
        if (this.f3633g.f3640c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f3644f;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f3633g.f3639b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f3644f;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f3633g.a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f3644f;
        return drawable != null ? androidx.core.graphics.drawable.a.e(drawable) : this.f3633g.f3639b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f3644f == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0103c(this.f3644f.getConstantState());
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f3644f;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f3633g.f3639b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f3644f;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f3633g.f3639b.getIntrinsicWidth();
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3644f;
        return drawable != null ? drawable.getOpacity() : this.f3633g.f3639b.getOpacity();
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayS = androidx.core.content.d.g.s(resources, theme, attributeSet, c.y.a.a.a.f3626e);
                    int resourceId = typedArrayS.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i iVarB = i.b(resources, resourceId, theme);
                        iVarB.h(false);
                        iVarB.setCallback(this.l);
                        i iVar = this.f3633g.f3639b;
                        if (iVar != null) {
                            iVar.setCallback(null);
                        }
                        this.f3633g.f3639b = iVarB;
                    }
                    typedArrayS.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, c.y.a.a.a.f3627f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f3634h;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        b(string, e.i(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f3633g.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f3644f;
        return drawable != null ? androidx.core.graphics.drawable.a.h(drawable) : this.f3633g.f3639b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f3644f;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f3633g.f3640c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f3644f;
        return drawable != null ? drawable.isStateful() : this.f3633g.f3639b.isStateful();
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f3633g.f3639b.setBounds(rect);
        }
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.f3644f;
        return drawable != null ? drawable.setLevel(i2) : this.f3633g.f3639b.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f3644f;
        return drawable != null ? drawable.setState(iArr) : this.f3633g.f3639b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.f3633g.f3639b.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z);
        } else {
            this.f3633g.f3639b.setAutoMirrored(z);
        }
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // c.y.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i2);
        } else {
            this.f3633g.f3639b.setTint(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        } else {
            this.f3633g.f3639b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
        } else {
            this.f3633g.f3639b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f3633g.f3639b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f3633g.f3640c.isStarted()) {
                return;
            }
            this.f3633g.f3640c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f3633g.f3640c.end();
        }
    }

    private c(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3644f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f3633g.f3639b.setColorFilter(colorFilter);
        }
    }

    /* JADX INFO: renamed from: c.y.a.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
    private static class C0103c extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public C0103c(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            c cVar = new c();
            Drawable drawableNewDrawable = this.a.newDrawable();
            cVar.f3644f = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.l);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            Drawable drawableNewDrawable = this.a.newDrawable(resources);
            cVar.f3644f = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.l);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            Drawable drawableNewDrawable = this.a.newDrawable(resources, theme);
            cVar.f3644f = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.l);
            return cVar;
        }
    }

    private c(Context context, b bVar, Resources resources) {
        this.f3635i = null;
        this.f3636j = null;
        this.f3637k = null;
        a aVar = new a();
        this.l = aVar;
        this.f3634h = context;
        if (bVar != null) {
            this.f3633g = bVar;
        } else {
            this.f3633g = new b(context, bVar, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
