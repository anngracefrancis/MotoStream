package c.v.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.u;

/* JADX INFO: compiled from: CircleImageView.java */
/* JADX INFO: loaded from: classes.dex */
class a extends ImageView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Animation.AnimationListener f3493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f3494g;

    /* JADX INFO: renamed from: c.v.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CircleImageView.java */
    private class C0097a extends OvalShape {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private RadialGradient f3495f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Paint f3496g = new Paint();

        C0097a(int i2) {
            a.this.f3494g = i2;
            b((int) rect().width());
        }

        private void b(int i2) {
            float f2 = i2 / 2;
            RadialGradient radialGradient = new RadialGradient(f2, f2, a.this.f3494g, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f3495f = radialGradient;
            this.f3496g.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width = a.this.getWidth() / 2;
            float f2 = width;
            float height = a.this.getHeight() / 2;
            canvas.drawCircle(f2, height, f2, this.f3496g);
            canvas.drawCircle(f2, height, width - a.this.f3494g, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            b((int) f2);
        }
    }

    a(Context context, int i2) {
        ShapeDrawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f3494g = (int) (3.5f * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            u.q0(this, f2 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0097a(this.f3494g));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f3494g, i4, i3, 503316480);
            int i5 = this.f3494g;
            setPadding(i5, i5, i5, i5);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i2);
        u.m0(this, shapeDrawable);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f3493f = animationListener;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f3493f;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f3493f;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f3494g * 2), getMeasuredHeight() + (this.f3494g * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }
}
