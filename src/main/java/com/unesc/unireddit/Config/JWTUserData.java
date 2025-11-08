package com.unesc.unireddit.Config;

import lombok.Builder;

import java.util.List;

@Builder
public record JWTUserData(Long userId, String mail, List<String> roles) {
}