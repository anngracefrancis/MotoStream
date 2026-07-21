package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Parcelable f967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    PorterDuff.Mode f971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f972j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f973k;

    public IconCompat() {
        this.f964b = -1;
        this.f966d = null;
        this.f967e = null;
        this.f968f = 0;
        this.f969g = 0;
        this.f970h = null;
        this.f971i = a;
        this.f972j = null;
    }

    static Bitmap a(Bitmap bitmap, boolean z) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f2 = iMin;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2, (-(bitmap.getHeight() - iMin)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat b(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("Bitmap must not be null.");
        }
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f965c = bitmap;
        return iconCompat;
    }

    public static IconCompat c(Resources resources, String str, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        }
        if (i2 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f968f = i2;
        if (resources != null) {
            try {
                iconCompat.f965c = resources.getResourceName(i2);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f965c = str;
        }
        iconCompat.f973k = str;
        return iconCompat;
    }

    private static int f(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }

    private static String h(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    private static int j(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e2);
            return -1;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e3);
            return -1;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e4);
            return -1;
        }
    }

    private static Uri l(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon uri", e4);
            return null;
        }
    }

    private static String r(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap d() {
        int i2 = this.f964b;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f965c;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i2 == 1) {
            return (Bitmap) this.f965c;
        }
        if (i2 == 5) {
            return a((Bitmap) this.f965c, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int e() {
        int i2 = this.f964b;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return f((Icon) this.f965c);
        }
        if (i2 == 2) {
            return this.f968f;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String g() {
        int i2 = this.f964b;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return h((Icon) this.f965c);
        }
        if (i2 == 2) {
            return TextUtils.isEmpty(this.f973k) ? ((String) this.f965c).split(":", -1)[0] : this.f973k;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int i() {
        int i2 = this.f964b;
        return (i2 != -1 || Build.VERSION.SDK_INT < 23) ? i2 : j((Icon) this.f965c);
    }

    public Uri k() {
        int i2 = this.f964b;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return l((Icon) this.f965c);
        }
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f965c);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream m(Context context) {
        Uri uriK = k();
        String scheme = uriK.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriK);
            } catch (Exception e2) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriK, e2);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f965c));
        } catch (FileNotFoundException e3) {
            Log.w("IconCompat", "Unable to load image from path: " + uriK, e3);
            return null;
        }
    }

    public void n() {
        this.f971i = PorterDuff.Mode.valueOf(this.f972j);
        switch (this.f964b) {
            case -1:
                Parcelable parcelable = this.f967e;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f965c = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f967e;
                if (parcelable2 != null) {
                    this.f965c = parcelable2;
                    return;
                }
                byte[] bArr = this.f966d;
                this.f965c = bArr;
                this.f964b = 3;
                this.f968f = 0;
                this.f969g = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f966d, Charset.forName("UTF-16"));
                this.f965c = str;
                if (this.f964b == 2 && this.f973k == null) {
                    this.f973k = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f965c = this.f966d;
                return;
        }
    }

    public void o(boolean z) {
        this.f972j = this.f971i.name();
        switch (this.f964b) {
            case -1:
                if (z) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f967e = (Parcelable) this.f965c;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z) {
                    this.f967e = (Parcelable) this.f965c;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f965c;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f966d = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f966d = ((String) this.f965c).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f966d = (byte[]) this.f965c;
                return;
            case 4:
            case 6:
                this.f966d = this.f965c.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @Deprecated
    public Icon p() {
        return q(null);
    }

    public Icon q(Context context) {
        Icon iconCreateWithBitmap;
        switch (this.f964b) {
            case -1:
                return (Icon) this.f965c;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) this.f965c);
                break;
            case 2:
                iconCreateWithBitmap = Icon.createWithResource(g(), this.f968f);
                break;
            case 3:
                iconCreateWithBitmap = Icon.createWithData((byte[]) this.f965c, this.f968f, this.f969g);
                break;
            case 4:
                iconCreateWithBitmap = Icon.createWithContentUri((String) this.f965c);
                break;
            case 5:
                iconCreateWithBitmap = Build.VERSION.SDK_INT < 26 ? Icon.createWithBitmap(a((Bitmap) this.f965c, false)) : Icon.createWithAdaptiveBitmap((Bitmap) this.f965c);
                break;
            case 6:
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 30) {
                    iconCreateWithBitmap = Icon.createWithAdaptiveBitmapContentUri(k());
                } else {
                    if (context == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + k());
                    }
                    InputStream inputStreamM = m(context);
                    if (inputStreamM == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + k());
                    }
                    if (i2 < 26) {
                        iconCreateWithBitmap = Icon.createWithBitmap(a(BitmapFactory.decodeStream(inputStreamM), false));
                    } else {
                        iconCreateWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(inputStreamM));
                    }
                }
                break;
        }
        ColorStateList colorStateList = this.f970h;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f971i;
        if (mode != a) {
            iconCreateWithBitmap.setTintMode(mode);
        }
        return iconCreateWithBitmap;
    }

    public String toString() {
        if (this.f964b == -1) {
            return String.valueOf(this.f965c);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(r(this.f964b));
        switch (this.f964b) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f965c).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f965c).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f973k);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(e())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f968f);
                if (this.f969g != 0) {
                    sb.append(" off=");
                    sb.append(this.f969g);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f965c);
                break;
        }
        if (this.f970h != null) {
            sb.append(" tint=");
            sb.append(this.f970h);
        }
        if (this.f971i != a) {
            sb.append(" mode=");
            sb.append(this.f971i);
        }
        sb.append(")");
        return sb.toString();
    }

    private IconCompat(int i2) {
        this.f964b = -1;
        this.f966d = null;
        this.f967e = null;
        this.f968f = 0;
        this.f969g = 0;
        this.f970h = null;
        this.f971i = a;
        this.f972j = null;
        this.f964b = i2;
    }
}
