package c.y.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AnimatorInflaterCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: compiled from: AnimatorInflaterCompat.java */
    private static class a implements TypeEvaluator<c.i.e.c.b[]> {
        private c.i.e.c.b[] a;

        a() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c.i.e.c.b[] evaluate(float f2, c.i.e.c.b[] bVarArr, c.i.e.c.b[] bVarArr2) {
            if (!c.i.e.c.b(bVarArr, bVarArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!c.i.e.c.b(this.a, bVarArr)) {
                this.a = c.i.e.c.f(bVarArr);
            }
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                this.a[i2].d(bVarArr[i2], bVarArr2[i2], f2);
            }
            return this.a;
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f2) throws XmlPullParserException, IOException {
        return b(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f2);
    }

    private static Animator b(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i2, float f2) throws XmlPullParserException, IOException {
        int i3;
        int depth = xmlPullParser.getDepth();
        Animator animatorL = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            i3 = 0;
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    animatorL = n(context, resources, theme, attributeSet, f2, xmlPullParser);
                } else {
                    if (name.equals("animator")) {
                        animatorL = l(context, resources, theme, attributeSet, null, f2, xmlPullParser);
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray typedArrayS = androidx.core.content.d.g.s(resources, theme, attributeSet, c.y.a.a.a.f3629h);
                        b(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, androidx.core.content.d.g.k(typedArrayS, xmlPullParser, "ordering", 0, 0), f2);
                        typedArrayS.recycle();
                        animatorL = animatorSet2;
                    } else {
                        if (!name.equals("propertyValuesHolder")) {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        }
                        PropertyValuesHolder[] propertyValuesHolderArrP = p(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (propertyValuesHolderArrP != null && (animatorL instanceof ValueAnimator)) {
                            ((ValueAnimator) animatorL).setValues(propertyValuesHolderArrP);
                        }
                        i3 = 1;
                    }
                    if (animatorSet == null && i3 == 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animatorL);
                    }
                }
                if (animatorSet == null) {
                }
            }
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i3] = (Animator) it.next();
                i3++;
            }
            if (i2 == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animatorL;
    }

    private static Keyframe c(Keyframe keyframe, float f2) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f2);
        }
        return keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f2) : Keyframe.ofObject(f2);
    }

    private static void d(Keyframe[] keyframeArr, float f2, int i2, int i3) {
        float f3 = f2 / ((i3 - i2) + 2);
        while (i2 <= i3) {
            keyframeArr[i2].setFraction(keyframeArr[i2 - 1].getFraction() + f3);
            i2++;
        }
    }

    private static PropertyValuesHolder e(TypedArray typedArray, int i2, int i3, int i4, String str) {
        int color;
        int color2;
        int color3;
        PropertyValuesHolder propertyValuesHolderOfFloat;
        PropertyValuesHolder propertyValuesHolderOfObject;
        TypedValue typedValuePeekValue = typedArray.peekValue(i3);
        boolean z = typedValuePeekValue != null;
        int i5 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i4);
        boolean z2 = typedValuePeekValue2 != null;
        int i6 = z2 ? typedValuePeekValue2.type : 0;
        if (i2 == 4) {
            i2 = ((z && h(i5)) || (z2 && h(i6))) ? 3 : 0;
        }
        boolean z3 = i2 == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i2 == 2) {
            String string = typedArray.getString(i3);
            String string2 = typedArray.getString(i4);
            c.i.e.c.b[] bVarArrD = c.i.e.c.d(string);
            c.i.e.c.b[] bVarArrD2 = c.i.e.c.d(string2);
            if (bVarArrD == null && bVarArrD2 == null) {
                return null;
            }
            if (bVarArrD == null) {
                if (bVarArrD2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), bVarArrD2);
                }
                return null;
            }
            a aVar = new a();
            if (bVarArrD2 == null) {
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, bVarArrD);
            } else {
                if (!c.i.e.c.b(bVarArrD, bVarArrD2)) {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, bVarArrD, bVarArrD2);
            }
            return propertyValuesHolderOfObject;
        }
        f fVarA = i2 == 3 ? f.a() : null;
        if (z3) {
            if (z) {
                float dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                if (z2) {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z) {
            if (i5 == 5) {
                color2 = (int) typedArray.getDimension(i3, 0.0f);
            } else {
                color2 = h(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            }
            if (z2) {
                if (i6 == 5) {
                    color3 = (int) typedArray.getDimension(i4, 0.0f);
                } else {
                    color3 = h(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z2) {
            if (i6 == 5) {
                color = (int) typedArray.getDimension(i4, 0.0f);
            } else {
                color = h(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt == null || fVarA == null) {
            return propertyValuesHolderOfInt;
        }
        propertyValuesHolderOfInt.setEvaluator(fVarA);
        return propertyValuesHolderOfInt;
    }

    private static int f(TypedArray typedArray, int i2, int i3) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z = typedValuePeekValue != null;
        int i4 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        return ((z && h(i4)) || (z2 && h(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
    }

    private static int g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayS = androidx.core.content.d.g.s(resources, theme, attributeSet, c.y.a.a.a.f3631j);
        int i2 = 0;
        TypedValue typedValueT = androidx.core.content.d.g.t(typedArrayS, xmlPullParser, "value", 0);
        if ((typedValueT != null) && h(typedValueT.type)) {
            i2 = 3;
        }
        typedArrayS.recycle();
        return i2;
    }

    private static boolean h(int i2) {
        return i2 >= 28 && i2 <= 31;
    }

    public static Animator i(Context context, int i2) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i2) : j(context, context.getResources(), context.getTheme(), i2);
    }

    public static Animator j(Context context, Resources resources, Resources.Theme theme, int i2) throws Resources.NotFoundException {
        return k(context, resources, theme, i2, 1.0f);
    }

    public static Animator k(Context context, Resources resources, Resources.Theme theme, int i2, float f2) throws Resources.NotFoundException {
        XmlResourceParser animation = null;
        try {
            try {
                try {
                    animation = resources.getAnimation(i2);
                    Animator animatorA = a(context, resources, theme, animation, f2);
                    if (animation != null) {
                        animation.close();
                    }
                    return animatorA;
                } catch (XmlPullParserException e2) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                    notFoundException.initCause(e2);
                    throw notFoundException;
                }
            } catch (IOException e3) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                notFoundException2.initCause(e3);
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (animation != null) {
                animation.close();
            }
            throw th;
        }
    }

    private static ValueAnimator l(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray typedArrayS = androidx.core.content.d.g.s(resources, theme, attributeSet, c.y.a.a.a.f3628g);
        TypedArray typedArrayS2 = androidx.core.content.d.g.s(resources, theme, attributeSet, c.y.a.a.a.f3632k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        q(valueAnimator, typedArrayS, typedArrayS2, f2, xmlPullParser);
        int iL = androidx.core.content.d.g.l(typedArrayS, xmlPullParser, "interpolator", 0, 0);
        if (iL > 0) {
            valueAnimator.setInterpolator(d.b(context, iL));
        }
        typedArrayS.recycle();
        if (typedArrayS2 != null) {
            typedArrayS2.recycle();
        }
        return valueAnimator;
    }

    private static Keyframe m(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i2, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Keyframe keyframeOfFloat;
        TypedArray typedArrayS = androidx.core.content.d.g.s(resources, theme, attributeSet, c.y.a.a.a.f3631j);
        float fJ = androidx.core.content.d.g.j(typedArrayS, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue typedValueT = androidx.core.content.d.g.t(typedArrayS, xmlPullParser, "value", 0);
        boolean z = typedValueT != null;
        if (i2 == 4) {
            i2 = (z && h(typedValueT.type)) ? 3 : 0;
        }
        if (!z) {
            keyframeOfFloat = i2 == 0 ? Keyframe.ofFloat(fJ) : Keyframe.ofInt(fJ);
        } else if (i2 != 0) {
            keyframeOfFloat = (i2 == 1 || i2 == 3) ? Keyframe.ofInt(fJ, androidx.core.content.d.g.k(typedArrayS, xmlPullParser, "value", 0, 0)) : null;
        } else {
            keyframeOfFloat = Keyframe.ofFloat(fJ, androidx.core.content.d.g.j(typedArrayS, xmlPullParser, "value", 0, 0.0f));
        }
        int iL = androidx.core.content.d.g.l(typedArrayS, xmlPullParser, "interpolator", 1, 0);
        if (iL > 0) {
            keyframeOfFloat.setInterpolator(d.b(context, iL));
        }
        typedArrayS.recycle();
        return keyframeOfFloat;
    }

    private static ObjectAnimator n(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        l(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder o(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i2) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolderOfKeyframe = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (i2 == 4) {
                    i2 = g(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe keyframeM = m(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i2, xmlPullParser);
                if (keyframeM != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(keyframeM);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), c(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, c(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i3 = 0; i3 < size; i3++) {
                Keyframe keyframe3 = keyframeArr[i3];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i3 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i4 = size - 1;
                        if (i3 == i4) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i5 = i3;
                            for (int i6 = i3 + 1; i6 < i4 && keyframeArr[i6].getFraction() < 0.0f; i6++) {
                                i5 = i6;
                            }
                            d(keyframeArr, keyframeArr[i5 + 1].getFraction() - keyframeArr[i3 - 1].getFraction(), i3, i5);
                        }
                    }
                }
            }
            propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i2 == 3) {
                propertyValuesHolderOfKeyframe.setEvaluator(f.a());
            }
        }
        return propertyValuesHolderOfKeyframe;
    }

    private static PropertyValuesHolder[] p(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i2;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray typedArrayS = androidx.core.content.d.g.s(resources, theme, attributeSet, c.y.a.a.a.f3630i);
                    String strM = androidx.core.content.d.g.m(typedArrayS, xmlPullParser, "propertyName", 3);
                    int iK = androidx.core.content.d.g.k(typedArrayS, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder propertyValuesHolderO = o(context, resources, theme, xmlPullParser, strM, iK);
                    if (propertyValuesHolderO == null) {
                        propertyValuesHolderO = e(typedArrayS, iK, 0, 1, strM);
                    }
                    if (propertyValuesHolderO != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(propertyValuesHolderO);
                    }
                    typedArrayS.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i2 = 0; i2 < size; i2++) {
                propertyValuesHolderArr[i2] = (PropertyValuesHolder) arrayList.get(i2);
            }
        }
        return propertyValuesHolderArr;
    }

    private static void q(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f2, XmlPullParser xmlPullParser) {
        long jK = androidx.core.content.d.g.k(typedArray, xmlPullParser, "duration", 1, 300);
        long jK2 = androidx.core.content.d.g.k(typedArray, xmlPullParser, "startOffset", 2, 0);
        int iK = androidx.core.content.d.g.k(typedArray, xmlPullParser, "valueType", 7, 4);
        if (androidx.core.content.d.g.r(xmlPullParser, "valueFrom") && androidx.core.content.d.g.r(xmlPullParser, "valueTo")) {
            if (iK == 4) {
                iK = f(typedArray, 5, 6);
            }
            PropertyValuesHolder propertyValuesHolderE = e(typedArray, iK, 5, 6, HttpUrl.FRAGMENT_ENCODE_SET);
            if (propertyValuesHolderE != null) {
                valueAnimator.setValues(propertyValuesHolderE);
            }
        }
        valueAnimator.setDuration(jK);
        valueAnimator.setStartDelay(jK2);
        valueAnimator.setRepeatCount(androidx.core.content.d.g.k(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(androidx.core.content.d.g.k(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            r(valueAnimator, typedArray2, iK, f2, xmlPullParser);
        }
    }

    private static void r(ValueAnimator valueAnimator, TypedArray typedArray, int i2, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String strM = androidx.core.content.d.g.m(typedArray, xmlPullParser, "pathData", 1);
        if (strM == null) {
            objectAnimator.setPropertyName(androidx.core.content.d.g.m(typedArray, xmlPullParser, "propertyName", 0));
            return;
        }
        String strM2 = androidx.core.content.d.g.m(typedArray, xmlPullParser, "propertyXName", 2);
        String strM3 = androidx.core.content.d.g.m(typedArray, xmlPullParser, "propertyYName", 3);
        if (i2 != 2) {
        }
        if (strM2 != null || strM3 != null) {
            s(c.i.e.c.e(strM), objectAnimator, f2 * 0.5f, strM2, strM3);
            return;
        }
        throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    }

    private static void s(Path path, ObjectAnimator objectAnimator, float f2, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f3 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float length = 0.0f;
        do {
            length += pathMeasure.getLength();
            arrayList.add(Float.valueOf(length));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int iMin = Math.min(100, ((int) (length / f2)) + 1);
        float[] fArr = new float[iMin];
        float[] fArr2 = new float[iMin];
        float[] fArr3 = new float[2];
        float f4 = length / (iMin - 1);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= iMin) {
                break;
            }
            pathMeasure2.getPosTan(f3 - ((Float) arrayList.get(i3)).floatValue(), fArr3, null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            f3 += f4;
            int i4 = i3 + 1;
            if (i4 < arrayList.size() && f3 > ((Float) arrayList.get(i4)).floatValue()) {
                pathMeasure2.nextContour();
                i3 = i4;
            }
            i2++;
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (propertyValuesHolderOfFloat == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat2);
        } else if (propertyValuesHolderOfFloat2 == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat);
        } else {
            objectAnimator.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        }
    }
}
