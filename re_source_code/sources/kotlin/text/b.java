package kotlin.text;

import kotlin.Metadata;
import kotlin.ranges.IntRange;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: CharJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001\u001a\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u001a\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u001b\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\n\u0010\u001c\u001a\u00020\u000f*\u00020\u0002\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010!\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010\"\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010#\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010$\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010%\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010&\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010'\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0014\u0010'\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010(\u001a\u00020\u0002*\u00020\u0002H\u0087\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006)"}, d2 = {"category", "Lkotlin/text/CharCategory;", HttpUrl.FRAGMENT_ENCODE_SET, "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", HttpUrl.FRAGMENT_ENCODE_SET, "radix", "digitOf", "char", "isDefined", HttpUrl.FRAGMENT_ENCODE_SET, "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "lowercase", HttpUrl.FRAGMENT_ENCODE_SET, "locale", "Ljava/util/Locale;", "lowercaseChar", "titlecase", "titlecaseChar", "toLowerCase", "toTitleCase", "toUpperCase", "uppercase", "uppercaseChar", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/CharsKt")
public class b {
    public static int a(int i2) {
        if (new IntRange(2, 36).o(i2)) {
            return i2;
        }
        throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new IntRange(2, 36));
    }

    public static final int b(char c2, int i2) {
        return Character.digit((int) c2, i2);
    }

    public static boolean c(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }
}
