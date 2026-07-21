package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.MurmurHash3;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzve {
    public static int a(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        return MurmurHash3.a(bytes, 0, bytes.length, 0);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0083  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d6  */
    public static String[] b(String str, boolean z) {
        boolean z2;
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        char[] charArray = str.toCharArray();
        int length = str.length();
        int i2 = 0;
        boolean z3 = false;
        int i3 = 0;
        while (i2 < length) {
            int iCodePointAt = Character.codePointAt(charArray, i2);
            int iCharCount = Character.charCount(iCodePointAt);
            if (Character.isLetter(iCodePointAt)) {
                Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(iCodePointAt);
                if (!(unicodeBlockOf == Character.UnicodeBlock.BOPOMOFO || unicodeBlockOf == Character.UnicodeBlock.BOPOMOFO_EXTENDED || unicodeBlockOf == Character.UnicodeBlock.CJK_COMPATIBILITY || unicodeBlockOf == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlockOf == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || unicodeBlockOf == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlockOf == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlockOf == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || unicodeBlockOf == Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS || unicodeBlockOf == Character.UnicodeBlock.HANGUL_JAMO || unicodeBlockOf == Character.UnicodeBlock.HANGUL_SYLLABLES || unicodeBlockOf == Character.UnicodeBlock.HIRAGANA || unicodeBlockOf == Character.UnicodeBlock.KATAKANA || unicodeBlockOf == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS)) {
                    if (!((iCodePointAt >= 65382 && iCodePointAt <= 65437) || (iCodePointAt >= 65441 && iCodePointAt <= 65500))) {
                        z2 = false;
                    }
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (z3) {
                    arrayList.add(new String(charArray, i3, i2 - i3));
                }
                arrayList.add(new String(charArray, i2, iCharCount));
            } else {
                if (Character.isLetterOrDigit(iCodePointAt) || Character.getType(iCodePointAt) == 6 || Character.getType(iCodePointAt) == 8) {
                    if (!z3) {
                        i3 = i2;
                    }
                    z3 = true;
                } else if (z && Character.charCount(iCodePointAt) == 1 && Character.toChars(iCodePointAt)[0] == '\'') {
                    if (!z3) {
                        i3 = i2;
                    }
                    z3 = true;
                } else if (z3) {
                    arrayList.add(new String(charArray, i3, i2 - i3));
                }
                i2 += iCharCount;
            }
            z3 = false;
            i2 += iCharCount;
        }
        if (z3) {
            arrayList.add(new String(charArray, i3, i2 - i3));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
