package e.e.b.c.m;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* JADX INFO: compiled from: ImageMatrixProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends Property<ImageView, Matrix> {
    private final Matrix a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.a = new Matrix();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(ImageView imageView) {
        this.a.set(imageView.getImageMatrix());
        return this.a;
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
