package com.unesc.unireddit.Model;

public enum TipoVoto {
    UPVOTE,
    DOWNVOTE,
    INDEFINIDO;

    public static TipoVoto fromInt(int valor) {
        return switch (valor) {
            case 0 -> DOWNVOTE;
            case 1 -> UPVOTE;
            default -> INDEFINIDO;
        };
    }
}
