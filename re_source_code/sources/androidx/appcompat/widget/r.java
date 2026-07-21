package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: compiled from: AppCompatTextClassifierHelper.java */
/* JADX INFO: loaded from: classes.dex */
final class r {
    private TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextClassifier f607b;

    r(TextView textView) {
        this.a = (TextView) c.i.j.i.c(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f607b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    public void b(TextClassifier textClassifier) {
        this.f607b = textClassifier;
    }
}
