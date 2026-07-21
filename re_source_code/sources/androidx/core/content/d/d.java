package androidx.core.content.d;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: GradientColorInflaterCompat.java */
/* JADX INFO: loaded from: classes.dex */
final class d {
    private static a a(a aVar, int i2, int i3, boolean z, int i4) {
        if (aVar != null) {
            return aVar;
        }
        return z ? new a(i2, i4, i3) : new a(i2, i3);
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayS = g.s(resources, theme, attributeSet, c.i.d.y);
        float fJ = g.j(typedArrayS, xmlPullParser, "startX", c.i.d.H, 0.0f);
        float fJ2 = g.j(typedArrayS, xmlPullParser, "startY", c.i.d.I, 0.0f);
        float fJ3 = g.j(typedArrayS, xmlPullParser, "endX", c.i.d.J, 0.0f);
        float fJ4 = g.j(typedArrayS, xmlPullParser, "endY", c.i.d.K, 0.0f);
        float fJ5 = g.j(typedArrayS, xmlPullParser, "centerX", c.i.d.C, 0.0f);
        float fJ6 = g.j(typedArrayS, xmlPullParser, "centerY", c.i.d.D, 0.0f);
        int iK = g.k(typedArrayS, xmlPullParser, "type", c.i.d.B, 0);
        int iF = g.f(typedArrayS, xmlPullParser, "startColor", c.i.d.z, 0);
        boolean zR = g.r(xmlPullParser, "centerColor");
        int iF2 = g.f(typedArrayS, xmlPullParser, "centerColor", c.i.d.G, 0);
        int iF3 = g.f(typedArrayS, xmlPullParser, "endColor", c.i.d.A, 0);
        int iK2 = g.k(typedArrayS, xmlPullParser, "tileMode", c.i.d.F, 0);
        float fJ7 = g.j(typedArrayS, xmlPullParser, "gradientRadius", c.i.d.E, 0.0f);
        typedArrayS.recycle();
        a aVarA = a(c(resources, xmlPullParser, attributeSet, theme), iF, iF3, zR, iF2);
        if (iK != 1) {
            return iK != 2 ? new LinearGradient(fJ, fJ2, fJ3, fJ4, aVarA.a, aVarA.f953b, d(iK2)) : new SweepGradient(fJ5, fJ6, aVarA.a, aVarA.f953b);
        }
        if (fJ7 > 0.0f) {
            return new RadialGradient(fJ5, fJ6, fJ7, aVarA.a, aVarA.f953b, d(iK2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    private static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayS = g.s(resources, theme, attributeSet, c.i.d.L);
                int i2 = c.i.d.M;
                boolean zHasValue = typedArrayS.hasValue(i2);
                int i3 = c.i.d.N;
                boolean zHasValue2 = typedArrayS.hasValue(i3);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color = typedArrayS.getColor(i2, 0);
                float f2 = typedArrayS.getFloat(i3, 0.0f);
                typedArrayS.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f2));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode d(int i2) {
        if (i2 != 1) {
            return i2 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    /* JADX INFO: compiled from: GradientColorInflaterCompat.java */
    static final class a {
        final int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float[] f953b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.a = new int[size];
            this.f953b = new float[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.a[i2] = list.get(i2).intValue();
                this.f953b[i2] = list2.get(i2).floatValue();
            }
        }

        a(int i2, int i3) {
            this.a = new int[]{i2, i3};
            this.f953b = new float[]{0.0f, 1.0f};
        }

        a(int i2, int i3, int i4) {
            this.a = new int[]{i2, i3, i4};
            this.f953b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
