package com.google.firebase.messaging;

import java.util.Locale;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class SendException extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f19790f;

    SendException(String str) {
        super(str);
        this.f19790f = a(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    private int a(String str) {
        byte b2;
        if (str == null) {
            return 0;
        }
        switch (str.toLowerCase(Locale.US)) {
            case "service_not_available":
                b2 = 3;
                break;
            case "toomanymessages":
                b2 = 4;
                break;
            case "invalid_parameters":
                b2 = 0;
                break;
            case "messagetoobig":
                b2 = 2;
                break;
            case "missing_to":
                b2 = 1;
                break;
            default:
                b2 = -1;
                break;
        }
        if (b2 == 0 || b2 == 1) {
            return 1;
        }
        if (b2 == 2) {
            return 2;
        }
        if (b2 != 3) {
            return b2 != 4 ? 0 : 4;
        }
        return 3;
    }
}
