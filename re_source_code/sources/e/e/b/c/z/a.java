package e.e.b.c.z;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: compiled from: ShadowRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final int[] a = new int[3];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float[] f21110b = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f21111c = new int[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float[] f21112d = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Paint f21113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f21114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f21115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f21116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f21117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f21118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Path f21119k;
    private Paint l;

    public a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i2, float f2, float f3) {
        boolean z = f3 < 0.0f;
        Path path = this.f21119k;
        if (z) {
            int[] iArr = f21111c;
            iArr[0] = 0;
            iArr[1] = this.f21118j;
            iArr[2] = this.f21117i;
            iArr[3] = this.f21116h;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            float f4 = -i2;
            rectF.inset(f4, f4);
            int[] iArr2 = f21111c;
            iArr2[0] = 0;
            iArr2[1] = this.f21116h;
            iArr2[2] = this.f21117i;
            iArr2[3] = this.f21118j;
        }
        float fWidth = 1.0f - (i2 / (rectF.width() / 2.0f));
        float[] fArr = f21112d;
        fArr[1] = fWidth;
        fArr[2] = ((1.0f - fWidth) / 2.0f) + fWidth;
        this.f21114f.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, f21111c, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.l);
        }
        canvas.drawArc(rectF, f2, f3, true, this.f21114f);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i2) {
        rectF.bottom += i2;
        rectF.offset(0.0f, -i2);
        int[] iArr = a;
        iArr[0] = this.f21118j;
        iArr[1] = this.f21117i;
        iArr[2] = this.f21116h;
        Paint paint = this.f21115g;
        float f2 = rectF.left;
        paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, iArr, f21110b, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f21115g);
        canvas.restore();
    }

    public Paint c() {
        return this.f21113e;
    }

    public void d(int i2) {
        this.f21116h = c.i.e.a.o(i2, 68);
        this.f21117i = c.i.e.a.o(i2, 20);
        this.f21118j = c.i.e.a.o(i2, 0);
        this.f21113e.setColor(this.f21116h);
    }

    public a(int i2) {
        this.f21119k = new Path();
        this.l = new Paint();
        this.f21113e = new Paint();
        d(i2);
        this.l.setColor(0);
        Paint paint = new Paint(4);
        this.f21114f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f21115g = new Paint(paint);
    }
}
