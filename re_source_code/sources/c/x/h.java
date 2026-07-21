package c.x;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: compiled from: PathProperty.java */
/* JADX INFO: loaded from: classes.dex */
class h<T> extends Property<T, Float> {
    private final Property<T, PointF> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PathMeasure f3564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f3565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f3566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PointF f3567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f3568f;

    h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f3566d = new float[2];
        this.f3567e = new PointF();
        this.a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f3564b = pathMeasure;
        this.f3565c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(T t) {
        return Float.valueOf(this.f3568f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(T t, Float f2) {
        this.f3568f = f2.floatValue();
        this.f3564b.getPosTan(this.f3565c * f2.floatValue(), this.f3566d, null);
        PointF pointF = this.f3567e;
        float[] fArr = this.f3566d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.a.set(t, pointF);
    }
}
