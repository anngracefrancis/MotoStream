package c.i.i;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: compiled from: PrecomputedTextCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Spannable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f3262f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Spannable f3263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f3264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final PrecomputedText f3265i;

    public a a() {
        return this.f3264h;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f3263g;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.f3263g.charAt(i2);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f3263g.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f3263g.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f3263g.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f3265i.getSpans(i2, i3, cls) : (T[]) this.f3263g.getSpans(i2, i3, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f3263g.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f3263g.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f3265i.removeSpan(obj);
        } else {
            this.f3263g.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f3265i.setSpan(obj, i2, i3, i4);
        } else {
            this.f3263g.setSpan(obj, i2, i3, i4);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return this.f3263g.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f3263g.toString();
    }

    /* JADX INFO: compiled from: PrecomputedTextCompat.java */
    public static final class a {
        private final TextPaint a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f3266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f3267c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f3268d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f3269e;

        /* JADX INFO: renamed from: c.i.i.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PrecomputedTextCompat.java */
        public static class C0075a {
            private final TextPaint a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f3270b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f3271c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f3272d;

            public C0075a(TextPaint textPaint) {
                this.a = textPaint;
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 23) {
                    this.f3271c = 1;
                    this.f3272d = 1;
                } else {
                    this.f3272d = 0;
                    this.f3271c = 0;
                }
                if (i2 >= 18) {
                    this.f3270b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f3270b = null;
                }
            }

            public a a() {
                return new a(this.a, this.f3270b, this.f3271c, this.f3272d);
            }

            public C0075a b(int i2) {
                this.f3271c = i2;
                return this;
            }

            public C0075a c(int i2) {
                this.f3272d = i2;
                return this;
            }

            public C0075a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f3270b = textDirectionHeuristic;
                return this;
            }
        }

        @SuppressLint({"NewApi"})
        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f3269e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f3269e = null;
            }
            this.a = textPaint;
            this.f3266b = textDirectionHeuristic;
            this.f3267c = i2;
            this.f3268d = i3;
        }

        public boolean a(a aVar) {
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 23 && (this.f3267c != aVar.b() || this.f3268d != aVar.c())) || this.a.getTextSize() != aVar.e().getTextSize() || this.a.getTextScaleX() != aVar.e().getTextScaleX() || this.a.getTextSkewX() != aVar.e().getTextSkewX()) {
                return false;
            }
            if ((i2 >= 21 && (this.a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) || this.a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i2 >= 24) {
                if (!this.a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (i2 >= 17 && !this.a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            if (this.a.getTypeface() == null) {
                return aVar.e().getTypeface() == null;
            }
            return this.a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.f3267c;
        }

        public int c() {
            return this.f3268d;
        }

        public TextDirectionHeuristic d() {
            return this.f3266b;
        }

        public TextPaint e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (a(aVar)) {
                return Build.VERSION.SDK_INT < 18 || this.f3266b == aVar.d();
            }
            return false;
        }

        public int hashCode() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                return c.i.j.d.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.f3266b, Integer.valueOf(this.f3267c), Integer.valueOf(this.f3268d));
            }
            if (i2 >= 21) {
                return c.i.j.d.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.f3266b, Integer.valueOf(this.f3267c), Integer.valueOf(this.f3268d));
            }
            if (i2 >= 18) {
                return c.i.j.d.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), this.f3266b, Integer.valueOf(this.f3267c), Integer.valueOf(this.f3268d));
            }
            return i2 >= 17 ? c.i.j.d.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), this.f3266b, Integer.valueOf(this.f3267c), Integer.valueOf(this.f3268d)) : c.i.j.d.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTypeface(), this.f3266b, Integer.valueOf(this.f3267c), Integer.valueOf(this.f3268d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.a.getTextSize());
            sb.append(", textScaleX=" + this.a.getTextScaleX());
            sb.append(", textSkewX=" + this.a.getTextSkewX());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                sb.append(", letterSpacing=" + this.a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.a.isElegantTextHeight());
            }
            if (i2 >= 24) {
                sb.append(", textLocale=" + this.a.getTextLocales());
            } else if (i2 >= 17) {
                sb.append(", textLocale=" + this.a.getTextLocale());
            }
            sb.append(", typeface=" + this.a.getTypeface());
            if (i2 >= 26) {
                sb.append(", variationSettings=" + this.a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f3266b);
            sb.append(", breakStrategy=" + this.f3267c);
            sb.append(", hyphenationFrequency=" + this.f3268d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.a = params.getTextPaint();
            this.f3266b = params.getTextDirection();
            this.f3267c = params.getBreakStrategy();
            this.f3268d = params.getHyphenationFrequency();
            this.f3269e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
