package com.google.android.material.textfield;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.q0;
import androidx.appcompat.widget.t;
import androidx.appcompat.widget.y;
import androidx.core.view.u;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.internal.CheckableImageButton;
import e.e.b.c.j;
import e.e.b.c.k;
import e.e.b.c.l;
import java.util.Iterator;
import java.util.LinkedHashSet;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEF_STYLE_RES = k.m;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator animator;
    private e.e.b.c.a0.g boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private final int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    private e.e.b.c.a0.g boxUnderline;
    final com.google.android.material.internal.a collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;
    private ColorStateList counterTextColor;
    private TextView counterView;
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;
    private int defaultStrokeColor;
    private int disabledColor;
    private int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet<f> editTextAttachedListeners;
    private Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    private final LinkedHashSet<g> endIconChangedListeners;
    private final SparseArray<com.google.android.material.textfield.e> endIconDelegates;
    private final FrameLayout endIconFrame;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;
    private final CheckableImageButton endIconView;
    private final LinearLayout endLayout;
    private View.OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;
    private final CheckableImageButton errorIconView;
    private int focusedFilledBackgroundColor;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasEndIconTintList;
    private boolean hasEndIconTintMode;
    private boolean hasStartIconTintList;
    private boolean hasStartIconTintMode;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private int hoveredFilledBackgroundColor;
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final com.google.android.material.textfield.f indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private boolean placeholderEnabled;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;
    private CharSequence prefixText;
    private final TextView prefixTextView;
    private boolean restoringSavedState;
    private e.e.b.c.a0.k shapeAppearanceModel;
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    private View.OnLongClickListener startIconOnLongClickListener;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;
    private final CheckableImageButton startIconView;
    private final LinearLayout startLayout;
    private ColorStateList strokeErrorColor;
    private CharSequence suffixText;
    private final TextView suffixTextView;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        CharSequence f18768h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f18769i;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f18768h) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f18768h, parcel, i2);
            parcel.writeInt(this.f18769i ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f18768h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f18769i = parcel.readInt() == 1;
        }
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.updateLabelState(!textInputLayout.restoringSavedState);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.counterEnabled) {
                textInputLayout2.updateCounter(editable.length());
            }
            if (TextInputLayout.this.placeholderEnabled) {
                TextInputLayout.this.updatePlaceholderText(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.endIconView.performClick();
            TextInputLayout.this.endIconView.jumpDrawablesToCurrentState();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.editText.requestLayout();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.collapsingTextHelper.d0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends androidx.core.view.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TextInputLayout f18773d;

        public e(TextInputLayout textInputLayout) {
            this.f18773d = textInputLayout;
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.d0.c cVar) {
            super.g(view, cVar);
            EditText editText = this.f18773d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f18773d.getHint();
            CharSequence helperText = this.f18773d.getHelperText();
            CharSequence error = this.f18773d.getError();
            int counterMaxLength = this.f18773d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f18773d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(helperText);
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String string = z2 ? hint.toString() : HttpUrl.FRAGMENT_ENCODE_SET;
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(((z4 || z3) && !TextUtils.isEmpty(string)) ? ", " : HttpUrl.FRAGMENT_ENCODE_SET);
            String string2 = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string2);
            if (z4) {
                helperText = error;
            } else if (!z3) {
                helperText = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            sb2.append((Object) helperText);
            String string3 = sb2.toString();
            if (z) {
                cVar.v0(text);
            } else if (!TextUtils.isEmpty(string3)) {
                cVar.v0(string3);
            }
            if (!TextUtils.isEmpty(string3)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    cVar.j0(string3);
                } else {
                    if (z) {
                        string3 = ((Object) text) + ", " + string3;
                    }
                    cVar.v0(string3);
                }
                cVar.s0(!z);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            cVar.k0(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                cVar.f0(error);
            }
        }
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i2);
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    private void addPlaceholderTextView() {
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            this.inputFrame.addView(textView);
            this.placeholderTextView.setVisibility(0);
        }
    }

    private void applyBoxAttributes() {
        e.e.b.c.a0.g gVar = this.boxBackground;
        if (gVar == null) {
            return;
        }
        gVar.setShapeAppearanceModel(this.shapeAppearanceModel);
        if (canDrawOutlineStroke()) {
            this.boxBackground.e0(this.boxStrokeWidthPx, this.boxStrokeColor);
        }
        int iCalculateBoxBackgroundColor = calculateBoxBackgroundColor();
        this.boxBackgroundColor = iCalculateBoxBackgroundColor;
        this.boxBackground.X(ColorStateList.valueOf(iCalculateBoxBackgroundColor));
        if (this.endIconMode == 3) {
            this.editText.getBackground().invalidateSelf();
        }
        applyBoxUnderlineAttributes();
        invalidate();
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderline == null) {
            return;
        }
        if (canDrawStroke()) {
            this.boxUnderline.X(ColorStateList.valueOf(this.boxStrokeColor));
        }
        invalidate();
    }

    private void applyCutoutPadding(RectF rectF) {
        float f2 = rectF.left;
        int i2 = this.boxLabelCutoutPaddingPx;
        rectF.left = f2 - i2;
        rectF.top -= i2;
        rectF.right += i2;
        rectF.bottom += i2;
    }

    private void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    private void applyIconTint(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (z) {
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            }
            if (z2) {
                androidx.core.graphics.drawable.a.p(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void applyStartIconTint() {
        applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
    }

    private void assignBoxBackgroundByMode() {
        int i2 = this.boxBackgroundMode;
        if (i2 == 0) {
            this.boxBackground = null;
            this.boxUnderline = null;
            return;
        }
        if (i2 == 1) {
            this.boxBackground = new e.e.b.c.a0.g(this.shapeAppearanceModel);
            this.boxUnderline = new e.e.b.c.a0.g();
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.hintEnabled || (this.boxBackground instanceof com.google.android.material.textfield.c)) {
                this.boxBackground = new e.e.b.c.a0.g(this.shapeAppearanceModel);
            } else {
                this.boxBackground = new com.google.android.material.textfield.c(this.shapeAppearanceModel);
            }
            this.boxUnderline = null;
        }
    }

    private int calculateBoxBackgroundColor() {
        return this.boxBackgroundMode == 1 ? e.e.b.c.q.a.e(e.e.b.c.q.a.d(this, e.e.b.c.b.o, 0), this.boxBackgroundColor) : this.boxBackgroundColor;
    }

    private Rect calculateCollapsedTextBounds(Rect rect) {
        if (this.editText == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.tmpBoundsRect;
        boolean z = u.y(this) == 1;
        rect2.bottom = rect.bottom;
        int i2 = this.boxBackgroundMode;
        if (i2 == 1) {
            rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z);
            rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
            rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z);
            return rect2;
        }
        if (i2 != 2) {
            rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z);
            rect2.top = getPaddingTop();
            rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z);
            return rect2;
        }
        rect2.left = rect.left + this.editText.getPaddingLeft();
        rect2.top = rect.top - calculateLabelMarginTop();
        rect2.right = rect.right - this.editText.getPaddingRight();
        return rect2;
    }

    private int calculateExpandedLabelBottom(Rect rect, Rect rect2, float f2) {
        return isSingleLineFilledTextField() ? (int) (rect2.top + f2) : rect.bottom - this.editText.getCompoundPaddingBottom();
    }

    private int calculateExpandedLabelTop(Rect rect, float f2) {
        return isSingleLineFilledTextField() ? (int) (rect.centerY() - (f2 / 2.0f)) : rect.top + this.editText.getCompoundPaddingTop();
    }

    private Rect calculateExpandedTextBounds(Rect rect) {
        if (this.editText == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.tmpBoundsRect;
        float fX = this.collapsingTextHelper.x();
        rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
        rect2.top = calculateExpandedLabelTop(rect, fX);
        rect2.right = rect.right - this.editText.getCompoundPaddingRight();
        rect2.bottom = calculateExpandedLabelBottom(rect, rect2, fX);
        return rect2;
    }

    private int calculateLabelMarginTop() {
        float fP;
        if (!this.hintEnabled) {
            return 0;
        }
        int i2 = this.boxBackgroundMode;
        if (i2 == 0 || i2 == 1) {
            fP = this.collapsingTextHelper.p();
        } else {
            if (i2 != 2) {
                return 0;
            }
            fP = this.collapsingTextHelper.p() / 2.0f;
        }
        return (int) fP;
    }

    private boolean canDrawOutlineStroke() {
        return this.boxBackgroundMode == 2 && canDrawStroke();
    }

    private boolean canDrawStroke() {
        return this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0;
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((com.google.android.material.textfield.c) this.boxBackground).o0();
        }
    }

    private void collapseHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z && this.hintAnimationEnabled) {
            animateToExpansionFraction(1.0f);
        } else {
            this.collapsingTextHelper.d0(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
        showPlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    private boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof com.google.android.material.textfield.c);
    }

    private void dispatchOnEditTextAttached() {
        Iterator<f> it = this.editTextAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void dispatchOnEndIconChanged(int i2) {
        Iterator<g> it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2);
        }
    }

    private void drawBoxUnderline(Canvas canvas) {
        e.e.b.c.a0.g gVar = this.boxUnderline;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bounds.bottom - this.boxStrokeWidthPx;
            this.boxUnderline.draw(canvas);
        }
    }

    private void drawHint(Canvas canvas) {
        if (this.hintEnabled) {
            this.collapsingTextHelper.j(canvas);
        }
    }

    private void expandHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z && this.hintAnimationEnabled) {
            animateToExpansionFraction(0.0f);
        } else {
            this.collapsingTextHelper.d0(0.0f);
        }
        if (cutoutEnabled() && ((com.google.android.material.textfield.c) this.boxBackground).l0()) {
            closeCutout();
        }
        this.hintExpanded = true;
        hidePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        com.google.android.material.textfield.e eVar = this.endIconDelegates.get(this.endIconMode);
        return eVar != null ? eVar : this.endIconDelegates.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) {
            return this.errorIconView;
        }
        if (hasEndIcon() && isEndIconVisible()) {
            return this.endIconView;
        }
        return null;
    }

    private int getLabelLeftBoundAlightWithPrefix(int i2, boolean z) {
        int compoundPaddingLeft = i2 + this.editText.getCompoundPaddingLeft();
        return (this.prefixText == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.prefixTextView.getMeasuredWidth()) + this.prefixTextView.getPaddingLeft();
    }

    private int getLabelRightBoundAlignedWithSuffix(int i2, boolean z) {
        int compoundPaddingRight = i2 - this.editText.getCompoundPaddingRight();
        return (this.prefixText == null || !z) ? compoundPaddingRight : compoundPaddingRight + this.prefixTextView.getMeasuredWidth() + this.prefixTextView.getPaddingRight();
    }

    private boolean hasEndIcon() {
        return this.endIconMode != 0;
    }

    private void hidePlaceholderText() {
        TextView textView = this.placeholderTextView;
        if (textView == null || !this.placeholderEnabled) {
            return;
        }
        textView.setText((CharSequence) null);
        this.placeholderTextView.setVisibility(4);
    }

    private boolean isErrorIconVisible() {
        return this.errorIconView.getVisibility() == 0;
    }

    private boolean isSingleLineFilledTextField() {
        return this.boxBackgroundMode == 1 && (Build.VERSION.SDK_INT < 16 || this.editText.getMinLines() <= 1);
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        setEditTextBoxBackground();
        updateTextInputBoxState();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.m(rectF, this.editText.getWidth(), this.editText.getGravity());
            applyCutoutPadding(rectF);
            rectF.offset(-getPaddingLeft(), -getPaddingTop());
            ((com.google.android.material.textfield.c) this.boxBackground).r0(rectF);
        }
    }

    private static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    private void removePlaceholderTextView() {
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void setEditText(EditText editText) {
        if (this.editText != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.endIconMode != 3 && !(editText instanceof TextInputEditText)) {
            Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.editText = editText;
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new e(this));
        this.collapsingTextHelper.k0(this.editText.getTypeface());
        this.collapsingTextHelper.a0(this.editText.getTextSize());
        int gravity = this.editText.getGravity();
        this.collapsingTextHelper.R((gravity & (-113)) | 48);
        this.collapsingTextHelper.Z(gravity);
        this.editText.addTextChangedListener(new a());
        if (this.defaultHintTextColor == null) {
            this.defaultHintTextColor = this.editText.getHintTextColors();
        }
        if (this.hintEnabled) {
            if (TextUtils.isEmpty(this.hint)) {
                CharSequence hint = this.editText.getHint();
                this.originalHint = hint;
                setHint(hint);
                this.editText.setHint((CharSequence) null);
            }
            this.isProvidingHint = true;
        }
        if (this.counterView != null) {
            updateCounter(this.editText.getText().length());
        }
        updateEditTextBackground();
        this.indicatorViewController.e();
        this.startLayout.bringToFront();
        this.endLayout.bringToFront();
        this.endIconFrame.bringToFront();
        this.errorIconView.bringToFront();
        dispatchOnEditTextAttached();
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        updateLabelState(false, true);
    }

    private void setEditTextBoxBackground() {
        if (shouldUseEditTextBackgroundForBoxBackground()) {
            u.m0(this.editText, this.boxBackground);
        }
    }

    private void setErrorIconVisible(boolean z) {
        this.errorIconView.setVisibility(z ? 0 : 8);
        this.endIconFrame.setVisibility(z ? 8 : 0);
        updateSuffixTextViewPadding();
        if (hasEndIcon()) {
            return;
        }
        updateDummyDrawables();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.hint)) {
            return;
        }
        this.hint = charSequence;
        this.collapsingTextHelper.i0(charSequence);
        if (this.hintExpanded) {
            return;
        }
        openCutout();
    }

    private static void setIconClickable(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zJ = u.J(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = zJ || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zJ);
        checkableImageButton.setPressable(zJ);
        checkableImageButton.setLongClickable(z);
        u.t0(checkableImageButton, z2 ? 1 : 2);
    }

    private static void setIconOnClickListener(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private static void setIconOnLongClickListener(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.placeholderEnabled == z) {
            return;
        }
        if (z) {
            t tVar = new t(getContext());
            this.placeholderTextView = tVar;
            tVar.setId(e.e.b.c.f.G);
            u.k0(this.placeholderTextView, 1);
            setPlaceholderTextAppearance(this.placeholderTextAppearance);
            setPlaceholderTextColor(this.placeholderTextColor);
            addPlaceholderTextView();
        } else {
            removePlaceholderTextView();
            this.placeholderTextView = null;
        }
        this.placeholderEnabled = z;
    }

    private boolean shouldUpdateEndDummyDrawable() {
        return (this.errorIconView.getVisibility() == 0 || ((hasEndIcon() && isEndIconVisible()) || this.suffixText != null)) && this.endLayout.getMeasuredWidth() > 0;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        return !(getStartIconDrawable() == null && this.prefixText == null) && this.startLayout.getMeasuredWidth() > 0;
    }

    private boolean shouldUseEditTextBackgroundForBoxBackground() {
        EditText editText = this.editText;
        return (editText == null || this.boxBackground == null || editText.getBackground() != null || this.boxBackgroundMode == 0) ? false : true;
    }

    private void showPlaceholderText() {
        TextView textView = this.placeholderTextView;
        if (textView == null || !this.placeholderEnabled) {
            return;
        }
        textView.setText(this.placeholderText);
        this.placeholderTextView.setVisibility(0);
        this.placeholderTextView.bringToFront();
    }

    private void tintEndIconOnError(boolean z) {
        if (!z || getEndIconDrawable() == null) {
            applyEndIconTint();
            return;
        }
        Drawable drawableMutate = androidx.core.graphics.drawable.a.r(getEndIconDrawable()).mutate();
        androidx.core.graphics.drawable.a.n(drawableMutate, this.indicatorViewController.o());
        this.endIconView.setImageDrawable(drawableMutate);
    }

    private void updateBoxUnderlineBounds(Rect rect) {
        e.e.b.c.a0.g gVar = this.boxUnderline;
        if (gVar != null) {
            int i2 = rect.bottom;
            gVar.setBounds(rect.left, i2 - this.boxStrokeWidthFocusedPx, rect.right, i2);
        }
    }

    private void updateCounter() {
        if (this.counterView != null) {
            EditText editText = this.editText;
            updateCounter(editText == null ? 0 : editText.getText().length());
        }
    }

    private static void updateCounterContentDescription(Context context, TextView textView, int i2, int i3, boolean z) {
        textView.setContentDescription(context.getString(z ? j.f21020b : j.a, Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    private void updateCounterTextAppearanceAndColor() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.counterView;
        if (textView != null) {
            setTextAppearanceCompatWithErrorFallback(textView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (!this.counterOverflowed || (colorStateList = this.counterOverflowTextColor) == null) {
                return;
            }
            this.counterView.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    private boolean updateDummyDrawables() {
        boolean z;
        if (this.editText == null) {
            return false;
        }
        boolean z2 = true;
        if (shouldUpdateStartDummyDrawable()) {
            int measuredWidth = this.startLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
            if (this.startDummyDrawable == null || this.startDummyDrawableWidth != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.startDummyDrawable = colorDrawable;
                this.startDummyDrawableWidth = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] drawableArrA = androidx.core.widget.k.a(this.editText);
            Drawable drawable = drawableArrA[0];
            Drawable drawable2 = this.startDummyDrawable;
            if (drawable != drawable2) {
                androidx.core.widget.k.i(this.editText, drawable2, drawableArrA[1], drawableArrA[2], drawableArrA[3]);
                z = true;
            } else {
                z = false;
            }
        } else if (this.startDummyDrawable != null) {
            Drawable[] drawableArrA2 = androidx.core.widget.k.a(this.editText);
            androidx.core.widget.k.i(this.editText, null, drawableArrA2[1], drawableArrA2[2], drawableArrA2[3]);
            this.startDummyDrawable = null;
            z = true;
        } else {
            z = false;
        }
        if (shouldUpdateEndDummyDrawable()) {
            int measuredWidth2 = this.suffixTextView.getMeasuredWidth() - this.editText.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + androidx.core.view.g.b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] drawableArrA3 = androidx.core.widget.k.a(this.editText);
            Drawable drawable3 = this.endDummyDrawable;
            if (drawable3 == null || this.endDummyDrawableWidth == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.endDummyDrawable = colorDrawable2;
                    this.endDummyDrawableWidth = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = drawableArrA3[2];
                Drawable drawable5 = this.endDummyDrawable;
                if (drawable4 != drawable5) {
                    this.originalEditTextEndDrawable = drawableArrA3[2];
                    androidx.core.widget.k.i(this.editText, drawableArrA3[0], drawableArrA3[1], drawable5, drawableArrA3[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.endDummyDrawableWidth = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                androidx.core.widget.k.i(this.editText, drawableArrA3[0], drawableArrA3[1], this.endDummyDrawable, drawableArrA3[3]);
            }
        } else {
            if (this.endDummyDrawable == null) {
                return z;
            }
            Drawable[] drawableArrA4 = androidx.core.widget.k.a(this.editText);
            if (drawableArrA4[2] == this.endDummyDrawable) {
                androidx.core.widget.k.i(this.editText, drawableArrA4[0], drawableArrA4[1], this.originalEditTextEndDrawable, drawableArrA4[3]);
            } else {
                z2 = z;
            }
            this.endDummyDrawable = null;
        }
        return z2;
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        int iMax;
        if (this.editText == null || this.editText.getMeasuredHeight() >= (iMax = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
            return false;
        }
        this.editText.setMinimumHeight(iMax);
        return true;
    }

    private void updateIconColorOnState(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
        Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
        androidx.core.graphics.drawable.a.o(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
            int iCalculateLabelMarginTop = calculateLabelMarginTop();
            if (iCalculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = iCalculateLabelMarginTop;
                this.inputFrame.requestLayout();
            }
        }
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        EditText editText;
        if (this.placeholderTextView == null || (editText = this.editText) == null) {
            return;
        }
        this.placeholderTextView.setGravity(editText.getGravity());
        this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
    }

    private void updatePlaceholderText() {
        EditText editText = this.editText;
        updatePlaceholderText(editText == null ? 0 : editText.getText().length());
    }

    private void updatePrefixTextViewPadding() {
        if (this.editText == null) {
            return;
        }
        this.prefixTextView.setPadding(isStartIconVisible() ? 0 : this.editText.getPaddingLeft(), this.editText.getCompoundPaddingTop(), this.prefixTextView.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
    }

    private void updatePrefixTextVisibility() {
        this.prefixTextView.setVisibility((this.prefixText == null || isHintExpanded()) ? 8 : 0);
        updateDummyDrawables();
    }

    private void updateStrokeErrorColor(boolean z, boolean z2) {
        int defaultColor = this.strokeErrorColor.getDefaultColor();
        int colorForState = this.strokeErrorColor.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.boxStrokeColor = colorForState2;
        } else if (z2) {
            this.boxStrokeColor = colorForState;
        } else {
            this.boxStrokeColor = defaultColor;
        }
    }

    private void updateSuffixTextViewPadding() {
        if (this.editText == null) {
            return;
        }
        TextView textView = this.suffixTextView;
        textView.setPadding(textView.getPaddingLeft(), this.editText.getPaddingTop(), (isEndIconVisible() || isErrorIconVisible()) ? 0 : this.editText.getPaddingRight(), this.editText.getPaddingBottom());
    }

    private void updateSuffixTextVisibility() {
        int visibility = this.suffixTextView.getVisibility();
        boolean z = (this.suffixText == null || isHintExpanded()) ? false : true;
        this.suffixTextView.setVisibility(z ? 0 : 8);
        if (visibility != this.suffixTextView.getVisibility()) {
            getEndIconDelegate().c(z);
        }
        updateDummyDrawables();
    }

    public void addOnEditTextAttachedListener(f fVar) {
        this.editTextAttachedListeners.add(fVar);
        if (this.editText != null) {
            fVar.a(this);
        }
    }

    public void addOnEndIconChangedListener(g gVar) {
        this.endIconChangedListeners.add(gVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i2, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.inputFrame.addView(view, layoutParams2);
        this.inputFrame.setLayoutParams(layoutParams);
        updateInputLayoutMargins();
        setEditText((EditText) view);
    }

    void animateToExpansionFraction(float f2) {
        if (this.collapsingTextHelper.z() == f2) {
            return;
        }
        if (this.animator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.animator = valueAnimator;
            valueAnimator.setInterpolator(e.e.b.c.m.a.f21050b);
            this.animator.setDuration(167L);
            this.animator.addUpdateListener(new d());
        }
        this.animator.setFloatValues(this.collapsingTextHelper.z(), f2);
        this.animator.start();
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    boolean cutoutIsOpen() {
        return cutoutEnabled() && ((com.google.android.material.textfield.c) this.boxBackground).l0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText;
        if (this.originalHint == null || (editText = this.editText) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        boolean z = this.isProvidingHint;
        this.isProvidingHint = false;
        CharSequence hint = editText.getHint();
        this.editText.setHint(this.originalHint);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
        } finally {
            this.editText.setHint(hint);
            this.isProvidingHint = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawHint(canvas);
        drawBoxUnderline(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.inDrawableStateChanged) {
            return;
        }
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.collapsingTextHelper;
        boolean zH0 = aVar != null ? aVar.h0(drawableState) | false : false;
        if (this.editText != null) {
            updateLabelState(u.O(this) && isEnabled());
        }
        updateEditTextBackground();
        updateTextInputBoxState();
        if (zH0) {
            invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.editText;
        return editText != null ? editText.getBaseline() + getPaddingTop() + calculateLabelMarginTop() : super.getBaseline();
    }

    e.e.b.c.a0.g getBoxBackground() {
        int i2 = this.boxBackgroundMode;
        if (i2 == 1 || i2 == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxBackground.s();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxBackground.t();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxBackground.H();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.G();
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.counterEnabled && this.counterOverflowed && (textView = this.counterView) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    public CharSequence getError() {
        if (this.indicatorViewController.y()) {
            return this.indicatorViewController.n();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.m();
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.o();
    }

    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    final int getErrorTextCurrentColor() {
        return this.indicatorViewController.o();
    }

    public CharSequence getHelperText() {
        if (this.indicatorViewController.z()) {
            return this.indicatorViewController.q();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.r();
    }

    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.p();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.t();
    }

    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled) {
            return this.placeholderText;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    public CharSequence getPrefixText() {
        return this.prefixText;
    }

    public ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.a();
    }

    public boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.y();
    }

    final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.s();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.z();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.endIconMode == 1;
    }

    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public boolean isStartIconCheckable() {
        return this.startIconView.a();
    }

    public boolean isStartIconVisible() {
        return this.startIconView.getVisibility() == 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        EditText editText = this.editText;
        if (editText != null) {
            Rect rect = this.tmpRect;
            com.google.android.material.internal.b.a(this, editText, rect);
            updateBoxUnderlineBounds(rect);
            if (this.hintEnabled) {
                this.collapsingTextHelper.a0(this.editText.getTextSize());
                int gravity = this.editText.getGravity();
                this.collapsingTextHelper.R((gravity & (-113)) | 48);
                this.collapsingTextHelper.Z(gravity);
                this.collapsingTextHelper.N(calculateCollapsedTextBounds(rect));
                this.collapsingTextHelper.V(calculateExpandedTextBounds(rect));
                this.collapsingTextHelper.K();
                if (!cutoutEnabled() || this.hintExpanded) {
                    return;
                }
                openCutout();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        boolean zUpdateEditTextHeightBasedOnIcon = updateEditTextHeightBasedOnIcon();
        boolean zUpdateDummyDrawables = updateDummyDrawables();
        if (zUpdateEditTextHeightBasedOnIcon || zUpdateDummyDrawables) {
            this.editText.post(new c());
        }
        updatePlaceholderMeasurementsBasedOnEditText();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.f18768h);
        if (savedState.f18769i) {
            this.endIconView.post(new b());
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.k()) {
            savedState.f18768h = getError();
        }
        savedState.f18769i = hasEndIcon() && this.endIconView.isChecked();
        return savedState;
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z) {
        if (this.endIconMode == 1) {
            this.endIconView.performClick();
            if (z) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    public void removeOnEditTextAttachedListener(f fVar) {
        this.editTextAttachedListeners.remove(fVar);
    }

    public void removeOnEndIconChangedListener(g gVar) {
        this.endIconChangedListeners.remove(gVar);
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.boxBackgroundColor != i2) {
            this.boxBackgroundColor = i2;
            this.defaultFilledBackgroundColor = i2;
            this.focusedFilledBackgroundColor = i2;
            this.hoveredFilledBackgroundColor = i2;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(int i2) {
        setBoxBackgroundColor(androidx.core.content.a.d(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.defaultFilledBackgroundColor = defaultColor;
        this.boxBackgroundColor = defaultColor;
        this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 == this.boxBackgroundMode) {
            return;
        }
        this.boxBackgroundMode = i2;
        if (this.editText != null) {
            onApplyBoxBackgroundMode();
        }
    }

    public void setBoxCornerRadii(float f2, float f3, float f4, float f5) {
        e.e.b.c.a0.g gVar = this.boxBackground;
        if (gVar != null && gVar.G() == f2 && this.boxBackground.H() == f3 && this.boxBackground.t() == f5 && this.boxBackground.s() == f4) {
            return;
        }
        this.shapeAppearanceModel = this.shapeAppearanceModel.v().z(f2).D(f3).v(f5).r(f4).m();
        applyBoxAttributes();
    }

    public void setBoxCornerRadiiResources(int i2, int i3, int i4, int i5) {
        setBoxCornerRadii(getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i3), getContext().getResources().getDimension(i5), getContext().getResources().getDimension(i4));
    }

    public void setBoxStrokeColor(int i2) {
        if (this.focusedStrokeColor != i2) {
            this.focusedStrokeColor = i2;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.defaultStrokeColor = colorStateList.getDefaultColor();
            this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.focusedStrokeColor = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
            this.focusedStrokeColor = colorStateList.getDefaultColor();
        }
        updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.strokeErrorColor != colorStateList) {
            this.strokeErrorColor = colorStateList;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.boxStrokeWidthDefaultPx = i2;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.boxStrokeWidthFocusedPx = i2;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            if (z) {
                t tVar = new t(getContext());
                this.counterView = tVar;
                tVar.setId(e.e.b.c.f.D);
                Typeface typeface = this.typeface;
                if (typeface != null) {
                    this.counterView.setTypeface(typeface);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.d(this.counterView, 2);
                androidx.core.view.g.c((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(e.e.b.c.d.S));
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.A(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.counterMaxLength != i2) {
            if (i2 > 0) {
                this.counterMaxLength = i2;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.counterOverflowTextAppearance != i2) {
            this.counterOverflowTextAppearance = i2;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.counterTextAppearance != i2) {
            this.counterTextAppearance = i2;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.endIconView.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.endIconView.setCheckable(z);
    }

    public void setEndIconContentDescription(int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconDrawable(int i2) {
        setEndIconDrawable(i2 != 0 ? c.a.k.a.a.d(getContext(), i2) : null);
    }

    public void setEndIconMode(int i2) {
        int i3 = this.endIconMode;
        this.endIconMode = i2;
        dispatchOnEndIconChanged(i3);
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().b(this.boxBackgroundMode)) {
            getEndIconDelegate().a();
            applyEndIconTint();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + i2);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        setIconOnClickListener(this.endIconView, onClickListener, this.endIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.endIconView, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            this.hasEndIconTintList = true;
            applyEndIconTint();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            this.hasEndIconTintMode = true;
            applyEndIconTint();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (isEndIconVisible() != z) {
            this.endIconView.setVisibility(z ? 0 : 8);
            updateSuffixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.indicatorViewController.y()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.t();
        } else {
            this.indicatorViewController.N(charSequence);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.indicatorViewController.C(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.indicatorViewController.D(z);
    }

    public void setErrorIconDrawable(int i2) {
        setErrorIconDrawable(i2 != 0 ? c.a.k.a.a.d(getContext(), i2) : null);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        setIconOnClickListener(this.errorIconView, onClickListener, this.errorIconOnLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.errorIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.errorIconView, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.errorIconTintList = colorStateList;
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.p(drawable, mode);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i2) {
        this.indicatorViewController.E(i2);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.F(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (isHelperTextEnabled()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.O(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.I(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.indicatorViewController.H(z);
    }

    public void setHelperTextTextAppearance(int i2) {
        this.indicatorViewController.G(i2);
    }

    public void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(RecyclerView.l.FLAG_MOVED);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (z) {
                CharSequence hint = this.editText.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            } else {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        this.collapsingTextHelper.O(i2);
        this.focusedTextColor = this.collapsingTextHelper.n();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                this.collapsingTextHelper.Q(colorStateList);
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? c.a.k.a.a.d(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.endIconMode != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.placeholderEnabled && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        }
        updatePlaceholderText();
    }

    public void setPlaceholderTextAppearance(int i2) {
        this.placeholderTextAppearance = i2;
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            androidx.core.widget.k.n(textView, i2);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.placeholderTextColor != colorStateList) {
            this.placeholderTextColor = colorStateList;
            TextView textView = this.placeholderTextView;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.prefixText = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.prefixTextView.setText(charSequence);
        updatePrefixTextVisibility();
    }

    public void setPrefixTextAppearance(int i2) {
        androidx.core.widget.k.n(this.prefixTextView, i2);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.prefixTextView.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.startIconView.setCheckable(z);
    }

    public void setStartIconContentDescription(int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconDrawable(int i2) {
        setStartIconDrawable(i2 != 0 ? c.a.k.a.a.d(getContext(), i2) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        setIconOnClickListener(this.startIconView, onClickListener, this.startIconOnLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.startIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.startIconView, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.startIconTintList != colorStateList) {
            this.startIconTintList = colorStateList;
            this.hasStartIconTintList = true;
            applyStartIconTint();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.startIconTintMode != mode) {
            this.startIconTintMode = mode;
            this.hasStartIconTintMode = true;
            applyStartIconTint();
        }
    }

    public void setStartIconVisible(boolean z) {
        if (isStartIconVisible() != z) {
            this.startIconView.setVisibility(z ? 0 : 8);
            updatePrefixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.suffixText = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.suffixTextView.setText(charSequence);
        updateSuffixTextVisibility();
    }

    public void setSuffixTextAppearance(int i2) {
        androidx.core.widget.k.n(this.suffixTextView, i2);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.suffixTextView.setTextColor(colorStateList);
    }

    void setTextAppearanceCompatWithErrorFallback(TextView textView, int i2) {
        boolean z = true;
        try {
            androidx.core.widget.k.n(textView, i2);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z = false;
            }
        } catch (Exception unused) {
        }
        if (z) {
            androidx.core.widget.k.n(textView, k.f21030b);
            textView.setTextColor(androidx.core.content.a.d(getContext(), e.e.b.c.c.f20973b));
        }
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.editText;
        if (editText != null) {
            u.i0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.typeface) {
            this.typeface = typeface;
            this.collapsingTextHelper.k0(typeface);
            this.indicatorViewController.K(typeface);
            TextView textView = this.counterView;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void updateEditTextBackground() {
        Drawable background;
        TextView textView;
        EditText editText = this.editText;
        if (editText == null || this.boxBackgroundMode != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (y.a(background)) {
            background = background.mutate();
        }
        if (this.indicatorViewController.k()) {
            background.setColorFilter(androidx.appcompat.widget.h.e(this.indicatorViewController.o(), PorterDuff.Mode.SRC_IN));
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            background.setColorFilter(androidx.appcompat.widget.h.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.a.c(background);
            this.editText.refreshDrawableState();
        }
    }

    void updateLabelState(boolean z) {
        updateLabelState(z, false);
    }

    void updateTextInputBoxState() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.boxBackground == null || this.boxBackgroundMode == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.editText) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.editText) != null && editText.isHovered());
        if (!isEnabled()) {
            this.boxStrokeColor = this.disabledColor;
        } else if (this.indicatorViewController.k()) {
            if (this.strokeErrorColor != null) {
                updateStrokeErrorColor(z2, z3);
            } else {
                this.boxStrokeColor = this.indicatorViewController.o();
            }
        } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
            if (z2) {
                this.boxStrokeColor = this.focusedStrokeColor;
            } else if (z3) {
                this.boxStrokeColor = this.hoveredStrokeColor;
            } else {
                this.boxStrokeColor = this.defaultStrokeColor;
            }
        } else if (this.strokeErrorColor != null) {
            updateStrokeErrorColor(z2, z3);
        } else {
            this.boxStrokeColor = textView.getCurrentTextColor();
        }
        if (getErrorIconDrawable() != null && this.indicatorViewController.y() && this.indicatorViewController.k()) {
            z = true;
        }
        setErrorIconVisible(z);
        updateIconColorOnState(this.errorIconView, this.errorIconTintList);
        updateIconColorOnState(this.startIconView, this.startIconTintList);
        updateIconColorOnState(this.endIconView, this.endIconTintList);
        if (getEndIconDelegate().d()) {
            tintEndIconOnError(this.indicatorViewController.k());
        }
        if (z2 && isEnabled()) {
            this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
        } else {
            this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        }
        if (this.boxBackgroundMode == 1) {
            if (!isEnabled()) {
                this.boxBackgroundColor = this.disabledFilledBackgroundColor;
            } else if (z3 && !z2) {
                this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
            } else if (z2) {
                this.boxBackgroundColor = this.focusedFilledBackgroundColor;
            } else {
                this.boxBackgroundColor = this.defaultFilledBackgroundColor;
            }
        }
        applyBoxAttributes();
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.e.b.c.b.I);
    }

    private void updateLabelState(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.editText;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.editText;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean zK = this.indicatorViewController.k();
        ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            this.collapsingTextHelper.Q(colorStateList2);
            this.collapsingTextHelper.Y(this.defaultHintTextColor);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.defaultHintTextColor;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.disabledColor) : this.disabledColor;
            this.collapsingTextHelper.Q(ColorStateList.valueOf(colorForState));
            this.collapsingTextHelper.Y(ColorStateList.valueOf(colorForState));
        } else if (zK) {
            this.collapsingTextHelper.Q(this.indicatorViewController.p());
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.collapsingTextHelper.Q(textView.getTextColors());
        } else if (z4 && (colorStateList = this.focusedTextColor) != null) {
            this.collapsingTextHelper.Q(colorStateList);
        }
        if (z3 || (isEnabled() && (z4 || zK))) {
            if (z2 || this.hintExpanded) {
                collapseHint(z);
                return;
            }
            return;
        }
        if (z2 || !this.hintExpanded) {
            expandHint(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaceholderText(int i2) {
        if (i2 != 0 || this.hintExpanded) {
            hidePlaceholderText();
        } else {
            showPlaceholderText();
        }
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.indicatorViewController.y());
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.startIconView.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.startIconView.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            applyStartIconTint();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i2) {
        int i3;
        int i4 = DEF_STYLE_RES;
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, i4), attributeSet, i2);
        this.indicatorViewController = new com.google.android.material.textfield.f(this);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet<>();
        this.endIconMode = 0;
        this.endIconDelegates = new SparseArray<>();
        this.endIconChangedListeners = new LinkedHashSet<>();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.collapsingTextHelper = aVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.inputFrame = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.startLayout = linearLayout;
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        frameLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.endLayout = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout.addView(linearLayout2);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.endIconFrame = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = e.e.b.c.m.a.a;
        aVar.j0(timeInterpolator);
        aVar.g0(timeInterpolator);
        aVar.R(8388659);
        int[] iArr = l.N4;
        int i5 = l.g5;
        int i6 = l.e5;
        int i7 = l.t5;
        int i8 = l.x5;
        int i9 = l.B5;
        q0 q0VarI = com.google.android.material.internal.j.i(context2, attributeSet, iArr, i2, i4, i5, i6, i7, i8, i9);
        this.hintEnabled = q0VarI.a(l.A5, true);
        setHint(q0VarI.p(l.Q4));
        this.hintAnimationEnabled = q0VarI.a(l.z5, true);
        this.shapeAppearanceModel = e.e.b.c.a0.k.e(context2, attributeSet, i2, i4).m();
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(e.e.b.c.d.P);
        this.boxCollapsedPaddingTopPx = q0VarI.e(l.T4, 0);
        this.boxStrokeWidthDefaultPx = q0VarI.f(l.a5, context2.getResources().getDimensionPixelSize(e.e.b.c.d.Q));
        this.boxStrokeWidthFocusedPx = q0VarI.f(l.b5, context2.getResources().getDimensionPixelSize(e.e.b.c.d.R));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float fD = q0VarI.d(l.X4, -1.0f);
        float fD2 = q0VarI.d(l.W4, -1.0f);
        float fD3 = q0VarI.d(l.U4, -1.0f);
        float fD4 = q0VarI.d(l.V4, -1.0f);
        e.e.b.c.a0.k.b bVarV = this.shapeAppearanceModel.v();
        if (fD >= 0.0f) {
            bVarV.z(fD);
        }
        if (fD2 >= 0.0f) {
            bVarV.D(fD2);
        }
        if (fD3 >= 0.0f) {
            bVarV.v(fD3);
        }
        if (fD4 >= 0.0f) {
            bVarV.r(fD4);
        }
        this.shapeAppearanceModel = bVarV.m();
        ColorStateList colorStateListB = e.e.b.c.x.c.b(context2, q0VarI, l.R4);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.defaultFilledBackgroundColor = defaultColor;
            this.boxBackgroundColor = defaultColor;
            if (colorStateListB.isStateful()) {
                this.disabledFilledBackgroundColor = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                i3 = 2;
                this.focusedFilledBackgroundColor = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.hoveredFilledBackgroundColor = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                i3 = 2;
                this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
                ColorStateList colorStateListC = c.a.k.a.a.c(context2, e.e.b.c.c.f20978g);
                this.disabledFilledBackgroundColor = colorStateListC.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateListC.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            i3 = 2;
            this.boxBackgroundColor = 0;
            this.defaultFilledBackgroundColor = 0;
            this.disabledFilledBackgroundColor = 0;
            this.focusedFilledBackgroundColor = 0;
            this.hoveredFilledBackgroundColor = 0;
        }
        int i10 = l.P4;
        if (q0VarI.s(i10)) {
            ColorStateList colorStateListC2 = q0VarI.c(i10);
            this.focusedTextColor = colorStateListC2;
            this.defaultHintTextColor = colorStateListC2;
        }
        int i11 = l.Y4;
        ColorStateList colorStateListB2 = e.e.b.c.x.c.b(context2, q0VarI, i11);
        this.focusedStrokeColor = q0VarI.b(i11, 0);
        this.defaultStrokeColor = androidx.core.content.a.d(context2, e.e.b.c.c.f20979h);
        this.disabledColor = androidx.core.content.a.d(context2, e.e.b.c.c.f20980i);
        this.hoveredStrokeColor = androidx.core.content.a.d(context2, e.e.b.c.c.f20981j);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        int i12 = l.Z4;
        if (q0VarI.s(i12)) {
            setBoxStrokeErrorColor(e.e.b.c.x.c.b(context2, q0VarI, i12));
        }
        if (q0VarI.n(i9, -1) != -1) {
            setHintTextAppearance(q0VarI.n(i9, 0));
        }
        int iN = q0VarI.n(i7, 0);
        CharSequence charSequenceP = q0VarI.p(l.o5);
        boolean zA = q0VarI.a(l.p5, false);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int i13 = e.e.b.c.h.f21014f;
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflaterFrom.inflate(i13, (ViewGroup) linearLayout2, false);
        this.errorIconView = checkableImageButton;
        checkableImageButton.setVisibility(8);
        int i14 = l.q5;
        if (q0VarI.s(i14)) {
            setErrorIconDrawable(q0VarI.g(i14));
        }
        int i15 = l.r5;
        if (q0VarI.s(i15)) {
            setErrorIconTintList(e.e.b.c.x.c.b(context2, q0VarI, i15));
        }
        int i16 = l.s5;
        if (q0VarI.s(i16)) {
            setErrorIconTintMode(com.google.android.material.internal.k.e(q0VarI.k(i16, -1), null));
        }
        checkableImageButton.setContentDescription(getResources().getText(j.f21023e));
        u.t0(checkableImageButton, i3);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int iN2 = q0VarI.n(i8, 0);
        boolean zA2 = q0VarI.a(l.w5, false);
        CharSequence charSequenceP2 = q0VarI.p(l.v5);
        int iN3 = q0VarI.n(l.J5, 0);
        CharSequence charSequenceP3 = q0VarI.p(l.I5);
        int iN4 = q0VarI.n(l.M5, 0);
        CharSequence charSequenceP4 = q0VarI.p(l.L5);
        int iN5 = q0VarI.n(l.U5, 0);
        CharSequence charSequenceP5 = q0VarI.p(l.T5);
        boolean zA3 = q0VarI.a(l.c5, false);
        setCounterMaxLength(q0VarI.k(l.d5, -1));
        this.counterTextAppearance = q0VarI.n(i5, 0);
        this.counterOverflowTextAppearance = q0VarI.n(i6, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(e.e.b.c.h.f21015g, (ViewGroup) this.startLayout, false);
        this.startIconView = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        int i17 = l.Q5;
        if (q0VarI.s(i17)) {
            setStartIconDrawable(q0VarI.g(i17));
            int i18 = l.P5;
            if (q0VarI.s(i18)) {
                setStartIconContentDescription(q0VarI.p(i18));
            }
            setStartIconCheckable(q0VarI.a(l.O5, true));
        }
        int i19 = l.R5;
        if (q0VarI.s(i19)) {
            setStartIconTintList(e.e.b.c.x.c.b(context2, q0VarI, i19));
        }
        int i20 = l.S5;
        if (q0VarI.s(i20)) {
            setStartIconTintMode(com.google.android.material.internal.k.e(q0VarI.k(i20, -1), null));
        }
        setBoxBackgroundMode(q0VarI.k(l.S4, 0));
        this.endIconView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(i13, (ViewGroup) this.endIconFrame, false);
        this.endIconFrame.addView(this.endIconView);
        this.endIconView.setVisibility(8);
        this.endIconDelegates.append(-1, new com.google.android.material.textfield.b(this));
        this.endIconDelegates.append(0, new h(this));
        this.endIconDelegates.append(1, new i(this));
        this.endIconDelegates.append(2, new com.google.android.material.textfield.a(this));
        this.endIconDelegates.append(3, new com.google.android.material.textfield.d(this));
        int i21 = l.l5;
        if (q0VarI.s(i21)) {
            setEndIconMode(q0VarI.k(i21, 0));
            int i22 = l.k5;
            if (q0VarI.s(i22)) {
                setEndIconDrawable(q0VarI.g(i22));
            }
            int i23 = l.j5;
            if (q0VarI.s(i23)) {
                setEndIconContentDescription(q0VarI.p(i23));
            }
            setEndIconCheckable(q0VarI.a(l.i5, true));
        } else {
            int i24 = l.F5;
            if (q0VarI.s(i24)) {
                setEndIconMode(q0VarI.a(i24, false) ? 1 : 0);
                setEndIconDrawable(q0VarI.g(l.E5));
                setEndIconContentDescription(q0VarI.p(l.D5));
                int i25 = l.G5;
                if (q0VarI.s(i25)) {
                    setEndIconTintList(e.e.b.c.x.c.b(context2, q0VarI, i25));
                }
                int i26 = l.H5;
                if (q0VarI.s(i26)) {
                    setEndIconTintMode(com.google.android.material.internal.k.e(q0VarI.k(i26, -1), null));
                }
            }
        }
        if (!q0VarI.s(l.F5)) {
            int i27 = l.m5;
            if (q0VarI.s(i27)) {
                setEndIconTintList(e.e.b.c.x.c.b(context2, q0VarI, i27));
            }
            int i28 = l.n5;
            if (q0VarI.s(i28)) {
                setEndIconTintMode(com.google.android.material.internal.k.e(q0VarI.k(i28, -1), null));
            }
        }
        t tVar = new t(context2);
        this.prefixTextView = tVar;
        tVar.setId(e.e.b.c.f.H);
        tVar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        u.k0(tVar, 1);
        this.startLayout.addView(this.startIconView);
        this.startLayout.addView(tVar);
        t tVar2 = new t(context2);
        this.suffixTextView = tVar2;
        tVar2.setId(e.e.b.c.f.I);
        tVar2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        u.k0(tVar2, 1);
        this.endLayout.addView(tVar2);
        this.endLayout.addView(this.errorIconView);
        this.endLayout.addView(this.endIconFrame);
        setHelperTextEnabled(zA2);
        setHelperText(charSequenceP2);
        setHelperTextTextAppearance(iN2);
        setErrorEnabled(zA);
        setErrorTextAppearance(iN);
        setErrorContentDescription(charSequenceP);
        setCounterTextAppearance(this.counterTextAppearance);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setPlaceholderText(charSequenceP3);
        setPlaceholderTextAppearance(iN3);
        setPrefixText(charSequenceP4);
        setPrefixTextAppearance(iN4);
        setSuffixText(charSequenceP5);
        setSuffixTextAppearance(iN5);
        int i29 = l.u5;
        if (q0VarI.s(i29)) {
            setErrorTextColor(q0VarI.c(i29));
        }
        int i30 = l.y5;
        if (q0VarI.s(i30)) {
            setHelperTextColor(q0VarI.c(i30));
        }
        int i31 = l.C5;
        if (q0VarI.s(i31)) {
            setHintTextColor(q0VarI.c(i31));
        }
        int i32 = l.h5;
        if (q0VarI.s(i32)) {
            setCounterTextColor(q0VarI.c(i32));
        }
        int i33 = l.f5;
        if (q0VarI.s(i33)) {
            setCounterOverflowTextColor(q0VarI.c(i33));
        }
        int i34 = l.K5;
        if (q0VarI.s(i34)) {
            setPlaceholderTextColor(q0VarI.c(i34));
        }
        int i35 = l.N5;
        if (q0VarI.s(i35)) {
            setPrefixTextColor(q0VarI.c(i35));
        }
        int i36 = l.V5;
        if (q0VarI.s(i36)) {
            setSuffixTextColor(q0VarI.c(i36));
        }
        setCounterEnabled(zA3);
        setEnabled(q0VarI.a(l.O4, true));
        q0VarI.w();
        u.t0(this, 2);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    void updateCounter(int i2) {
        boolean z = this.counterOverflowed;
        int i3 = this.counterMaxLength;
        if (i3 == -1) {
            this.counterView.setText(String.valueOf(i2));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            this.counterOverflowed = i2 > i3;
            updateCounterContentDescription(getContext(), this.counterView, i2, this.counterMaxLength, this.counterOverflowed);
            if (z != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            this.counterView.setText(c.i.i.a.c().j(getContext().getString(j.f21021c, Integer.valueOf(i2), Integer.valueOf(this.counterMaxLength))));
        }
        if (this.editText == null || z == this.counterOverflowed) {
            return;
        }
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
    }
}
