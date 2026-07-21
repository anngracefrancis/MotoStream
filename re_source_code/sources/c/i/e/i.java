package c.i.e;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: TypefaceCompatApi29Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends j {
    @Override // c.i.e.j
    public Typeface b(Context context, androidx.core.content.d.c.b bVar, Resources resources, int i2) {
        try {
            androidx.core.content.d.c.C0022c[] c0022cArrA = bVar.a();
            int length = c0022cArrA.length;
            FontFamily.Builder builder = null;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    break;
                }
                androidx.core.content.d.c.C0022c c0022c = c0022cArrA[i3];
                try {
                    Font.Builder weight = new Font.Builder(resources, c0022c.b()).setWeight(c0022c.e());
                    if (!c0022c.f()) {
                        i4 = 0;
                    }
                    Font fontBuild = weight.setSlant(i4).setTtcIndex(c0022c.c()).setFontVariationSettings(c0022c.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
                i3++;
            }
            if (builder == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : 400, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // c.i.e.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, c.i.h.f.b[] bVarArr, int i2) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = bVarArr.length;
            FontFamily.Builder builder = null;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    if (builder == null) {
                        return null;
                    }
                    return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : 400, (i2 & 2) != 0 ? 1 : 0)).build();
                }
                c.i.h.f.b bVar = bVarArr[i3];
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(bVar.d(), "r", cancellationSignal);
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                        }
                        i3++;
                    } else {
                        try {
                            Font.Builder weight = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(bVar.e());
                            if (!bVar.f()) {
                                i4 = 0;
                            }
                            Font fontBuild = weight.setSlant(i4).setTtcIndex(bVar.c()).build();
                            if (builder == null) {
                                builder = new FontFamily.Builder(fontBuild);
                            } else {
                                builder.addFont(fontBuild);
                            }
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable unused) {
                            }
                            throw th;
                        }
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (IOException unused2) {
                }
                i3++;
            }
        } catch (Exception unused3) {
            return null;
        }
    }

    @Override // c.i.e.j
    protected Typeface d(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // c.i.e.j
    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        try {
            Font fontBuild = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // c.i.e.j
    protected c.i.h.f.b h(c.i.h.f.b[] bVarArr, int i2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
