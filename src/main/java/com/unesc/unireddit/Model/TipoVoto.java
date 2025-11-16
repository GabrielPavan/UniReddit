package com.unesc.unireddit.Model;

public enum TipoVoto {
    UPVOTE,
    DOWNVOTE,
    INDEFINIDO;

    public static TipoVoto fromInt(int valor) {
        return switch (valor) {
            case 1 -> UPVOTE;
            case 2 -> DOWNVOTE;
            default -> INDEFINIDO;
        };
    }
}
